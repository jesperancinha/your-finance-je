package org.jesperancinha.fintech.controller

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.eclipse.microprofile.jwt.Claim
import org.eclipse.microprofile.jwt.JsonWebToken
import org.jesperancinha.fintech.model.Account
import org.jesperancinha.fintech.model.Accounts
import org.jesperancinha.fintech.model.TransactionBody
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

@Path("credit")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
class CreditResource {
    @Inject
    @AccountsProduct
    private val accounts: Accounts? = null

    @Inject
    private val principal: Principal? = null

    @Inject
    private val jsonWebToken: JsonWebToken? = null

    @Inject
    @Claim("access")
    private val access: JsonString? = null

    @Inject
    @Claim("iat")
    private val iat: JsonNumber? = null

    @Inject
    @Claim("name")
    private val name: JsonString? = null

    @Inject
    @Claim("user_id")
    private val userId: JsonNumber? = null
    @GET
    @RolesAllowed("admin", "credit")
    @Throws(JsonProcessingException::class)
    fun getAccount(): Response? {
        val userAccount = accounts.getAccountMap()[name.getString()]
        return if (Objects.isNull(userAccount)) {
            Response.serverError().build()
        } else createResponse(userAccount)
    }

    @PUT
    @RolesAllowed("admin", "credit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Throws(
        JsonProcessingException::class
    )
    fun cashIn(transactionBody: TransactionBody?): Response? {
        val userAccount = accounts.getAccountMap()[name.getString()]
        if (Objects.isNull(userAccount)) {
            return Response.serverError()
                .build()
        }
        val currentAccount = userAccount.addCreditValue(transactionBody.saldo)
        accounts.getAccountMap()[name.getString()] = currentAccount
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
            accounts.getAccountMap()
                .values
        )
        CreditResource.log.info("Principal: {}", objectMapper.writeValueAsString(principal))
        CreditResource.log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken))
        return Response.ok(allAccounts)
            .build()
    }

    @GET
    @Path("summary")
    @Produces(MediaType.APPLICATION_JSON)
    @Throws(
        JsonProcessingException::class
    )
    fun getSummary(): Response? {
        val totalCredit = accounts.getAccountMap()
            .values
            .stream()
            .map(Account::creditValue)
            .reduce { obj: BigDecimal?, augend: BigDecimal? -> obj.add(augend) }
            .orElse(BigDecimal.ZERO)
        val jsonObject = Json.createObjectBuilder()
            .add("totalCredit", totalCredit)
            .add("client", "Mother Nature Dream Team")
            .build()
        CreditResource.log.info("Summary")
        CreditResource.log.info("Principal: {}", objectMapper.writeValueAsString(principal))
        CreditResource.log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken))
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
        return AccountsFactory.Companion.createResponse(
            currentAccount,
            name,
            accounts,
            CreditResource.log,
            objectMapper,
            principal,
            jsonWebToken
        )
    }

    companion object {
        private val objectMapper: ObjectMapper? = ObjectMapper()
    }
}