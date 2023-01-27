package org.jesperancinha.fintech.controller

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.eclipse.microprofile.jwt.Claim
import org.eclipse.microprofile.jwt.JsonWebToken
import org.jesperancinha.fintech.model.Account
import org.jesperancinha.fintech.model.Accounts
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

@Path("credit")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
open class CreditResource {
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

    @Inject
    @Claim("iat")
    open var iat: JsonNumber? = null

    @Inject
    @Claim("name")
    open var name: JsonString? = null

    @Inject
    @Claim("user_id")
    open var userId: JsonNumber? = null

    @GET
    @RolesAllowed("admin", "credit")
    @Throws(JsonProcessingException::class)
    open fun getAccount(): Response = requireNotNull(accounts).let { accounts ->
        createResponse(
            accounts.accountMap[requireNotNull(name).string] ?: return Response.serverError().build()
        )
    }

    @PUT
    @RolesAllowed("admin", "credit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Throws(
        JsonProcessingException::class
    )
    open fun cashIn(transactionBody: TransactionBody) = requireNotNull(accounts).let { accounts ->
        requireNotNull(name).let { name ->
            accounts.accountMap[name.string] = (accounts.accountMap[name.string] ?: return Response.serverError()
                .build()).addCreditValue(transactionBody.saldo?: 0L)
            createResponse(
                (accounts.accountMap[name.string] ?: return Response.serverError()
                    .build()).addCreditValue(transactionBody.saldo?: 0L)
            )
        }
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
    @Produces(MediaType.APPLICATION_JSON)
    @Throws(
        JsonProcessingException::class
    )
    open fun getSummary(): Response? {
        val totalCredit = requireNotNull(accounts).accountMap
            .values
            .map(Account::creditValue)
            .stream()
            .reduce { total, v -> total.add(v) }
            .orElse(BigDecimal.ZERO)
        val jsonObject = Json.createObjectBuilder()
            .add("totalCredit", totalCredit)
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
    private fun createResponse(currentAccount: Account): Response {
        return AccountsFactory.createResponse(
            currentAccount,
            requireNotNull(name),
            requireNotNull(accounts),
            logger,
            objectMapper,
            principal,
            jsonWebToken
        )
    }

    companion object {
        val objectMapper: ObjectMapper = ObjectMapper()
        val logger: Logger = LoggerFactory.getLogger(CreditResource::class.java)
    }
}