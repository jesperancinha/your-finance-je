package org.jesperancinha.fintech.controller

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.eclipse.microprofile.jwt.Claim
import org.eclipse.microprofile.jwt.JsonWebToken
import org.jesperancinha.fintech.model.Account
import org.jesperancinha.fintech.model.Accounts
import org.jesperancinha.fintech.model.Client
import org.jesperancinha.fintech.model.TransactionBody
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import java.security.Principal
import java.util.*
import javax.annotation.security.RolesAllowed
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.json.Json
import javax.json.JsonNumber
import javax.json.JsonString
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("accounts")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
class AccountResource {
    @Inject
    @AccountsProduct
    lateinit var accounts: Accounts
    @Inject
    lateinit var principal: Principal
    @Inject
    lateinit var jsonWebToken: JsonWebToken
    @Inject
    @Claim("access")
    lateinit var access: JsonString
    @Inject
    @Claim("iat")
    lateinit var iat: JsonNumber
    @Inject
    @Claim("name")
    lateinit var name: JsonString
    @Inject
    @Claim("user_id")
    lateinit var userId: JsonNumber
    @POST
    @RolesAllowed("admin", "client", "credit")
    @Throws(JsonProcessingException::class)
    fun createAccount(): Response? {
        val currentAccount = Objects.requireNonNullElse(
            accounts.accountMap[name.getString()], Account.builder()
                .client(
                    Client.builder()
                        .name(name.getString())
                        .build()
                )
                .accountNumber(UUID.randomUUID().toString())
                .build()
        )
        return createResponse(currentAccount)
    }

    @POST
    @RolesAllowed("admin", "user")
    @Path("user")
    @Throws(JsonProcessingException::class)
    fun createUser(): Response? {
        val currentAccount = Objects.requireNonNullElse(
            accounts.accountMap[name.getString()], Account.builder()
                .client(
                    Client.builder()
                        .name(name.getString())
                        .build()
                )
                .accountNumber(UUID.randomUUID().toString())
                .build()
        )
        return createResponse(currentAccount)
    }

    @GET
    @RolesAllowed("admin", "client")
    @Throws(JsonProcessingException::class)
    fun getAccount(): Response? {
        val userAccount = accounts.accountMap[name.getString()]
        return Objects.requireNonNullElse(
            createResponse(userAccount), Response.serverError()
                .build()
        )
    }

    @PUT
    @RolesAllowed("admin", "client")
    @Consumes(MediaType.APPLICATION_JSON)
    @Throws(
        JsonProcessingException::class
    )
    fun cashIn(transactionBody: TransactionBody?): Response? {
        val userAccount = accounts.accountMap[name.getString()]
        if (Objects.isNull(userAccount)) {
            return Response.serverError()
                .build()
        }
        val currentAccount = userAccount.addCurrentValue(transactionBody.saldo)
        accounts.accountMap[name.getString()] = currentAccount
        return createResponse(currentAccount)
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @Throws(
        JsonProcessingException::class
    )
    fun getAll(): Response? {
        val allAccounts = ArrayList(
            accounts.accountMap
                .values
        )
        logger.info("Principal: {}", objectMapper.writeValueAsString(principal))
        logger.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken))
        return Response.ok(allAccounts)
            .build()
    }

    @GET
    @Path("summary")
    @Throws(JsonProcessingException::class)
    fun getSummary(): Response? {
        val totalCredit = accounts.accountMap
            .values
            .stream()
            .map(Account::currentValue)
            .reduce { obj: BigDecimal?, augend: BigDecimal? -> obj.add(augend) }
            .orElse(BigDecimal.ZERO)
        val jsonObject = Json.createObjectBuilder()
            .add("totalCurrent", totalCredit)
            .add("client", "Mother Nature Dream Team")
            .build()
        logger.info("Summary")
        logger.info("Principal: {}", objectMapper.writeValueAsString(principal))
        logger.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken))
        return Response.ok(jsonObject)
            .build()
    }

    @GET
    @RolesAllowed("admin", "client")
    @Path("jwt")
    fun getJWT(): Response? {
        val jsonObject = Json.createObjectBuilder()
            .add("jwt", jsonWebToken.getRawToken())
            .add("userId", userId.doubleValue())
            .add("access", access.getString())
            .add("iat", iat.doubleValue())
            .build()
        return Response.ok(jsonObject)
            .build()
    }

    @Throws(JsonProcessingException::class)
    private fun createResponse(currentAccount: Account?): Response? {
        return AccountsFactory.createResponse(
            currentAccount,
            name,
            accounts,
            logger,
            objectMapper,
            principal,
            jsonWebToken
        )
    }

    companion object {
        val objectMapper: ObjectMapper? = ObjectMapper()
        val logger: Logger = LoggerFactory.getLogger(AccountResource::class.java)
    }
}