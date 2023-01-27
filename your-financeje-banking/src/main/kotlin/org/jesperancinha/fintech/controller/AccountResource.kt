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

/**
 * Values have to be assigned to var and latet init var does not work with KumuluzEE probably because there is still no plugin available for this framework
 */
@Path("accounts")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
open class AccountResource {

    @Inject
    @AccountsProduct
    open var accounts: Accounts? = null

    @Inject
    open var principal: Principal? = null

    @Inject
    open var jsonWebToken: JsonWebToken? = null

    @Inject
    @Claim("access")
    open var access: JsonString? = null

    @Claim("iat")
    @Inject
    open var iat: JsonNumber? = null

    @Inject
    @Claim("name")
    open var name: JsonString? = null

    @Inject
    @Claim("user_id")
    open var userId: JsonNumber? = null

    @POST
    @RolesAllowed("admin", "client", "credit")
    @Throws(JsonProcessingException::class)
    open fun createAccount(): Response = createResponse(
        requireNotNull(accounts).accountMap[requireNotNull(name).string] ?: Account(
            client = Client(name = requireNotNull(name).string),
            accountNumber = UUID.randomUUID().toString()
        )
    )

    @POST
    @RolesAllowed("admin", "user")
    @Path("user")
    @Throws(JsonProcessingException::class)
    open fun createUser(): Response {
        return createResponse(
            requireNotNull(accounts).accountMap[requireNotNull(name).string] ?: Account(
                client = Client(name = requireNotNull(name).string),
                accountNumber = UUID.randomUUID().toString()
            )
        )
    }

    @GET
    @RolesAllowed("admin", "client")
    @Throws(JsonProcessingException::class)
    open fun getAccount(): Response? {
        return createResponse(
            requireNotNull(accounts).accountMap[requireNotNull(name).string] ?: return Response.serverError()
                .build()
        )
    }

    @PUT
    @RolesAllowed("admin", "client")
    @Consumes(MediaType.APPLICATION_JSON)
    @Throws(
        JsonProcessingException::class
    )
    open fun cashIn(transactionBody: TransactionBody): Response? {
        val userAccount =
            requireNotNull(accounts).accountMap[requireNotNull(name).string] ?: return Response.serverError()
                .build()

        val currentAccount = userAccount.addCurrentValue(transactionBody.saldo)
        requireNotNull(accounts).accountMap[requireNotNull(name).string] = currentAccount
        return createResponse(currentAccount)
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @Throws(
        JsonProcessingException::class
    )
    open fun getAll(): Response? {
        val allAccounts = ArrayList(
            requireNotNull(accounts).accountMap
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
    open fun getSummary(): Response? {
        val totalCredit = requireNotNull(accounts).accountMap
            .values
            .map(Account::currentValue)
            .stream()
            .reduce { result, u -> result.add(u) }
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
    open fun getJWT(): Response? {
        val jsonObject = Json.createObjectBuilder()
            .add("jwt", requireNotNull(jsonWebToken).rawToken)
            .add("userId", requireNotNull(userId).doubleValue())
            .add("access", requireNotNull(access).string)
            .add("iat", requireNotNull(iat).doubleValue())
            .build()
        return Response.ok(jsonObject)
            .build()
    }

    @Throws(JsonProcessingException::class)
    private fun createResponse(currentAccount: Account): Response =
        AccountsFactory.createResponse(
            currentAccount,
            requireNotNull(name),
            requireNotNull(accounts),
            logger,
            objectMapper,
            principal,
            jsonWebToken
        )

    companion object {
        val objectMapper: ObjectMapper = ObjectMapper()
        val logger: Logger = LoggerFactory.getLogger(AccountResource::class.java)
    }
}