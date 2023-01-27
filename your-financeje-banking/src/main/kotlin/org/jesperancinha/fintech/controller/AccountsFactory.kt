package org.jesperancinha.fintech.controller

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.eclipse.microprofile.jwt.JsonWebToken
import org.jesperancinha.fintech.model.Account
import org.jesperancinha.fintech.model.Accounts
import org.slf4j.Logger
import java.io.Serializable
import java.security.Principal
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces
import javax.json.Json
import javax.json.JsonString
import javax.ws.rs.core.Response

class AccountsFactory : Serializable {
    @Produces
    @AccountsProduct
    @ApplicationScoped
    fun getAccounts(): Accounts = Accounts(mutableMapOf())

    companion object {
        @Throws(JsonProcessingException::class)
        fun createResponse(
            currentAccount: Account,
            name: JsonString?,
            accounts: Accounts,
            log: Logger,
            objectMapper: ObjectMapper,
            principal: Principal?,
            jsonWebToken: JsonWebToken?
        ): Response? {
            val jsonObject = Json.createObjectBuilder()
                .add("balance", currentAccount.currentValue)
                .add("client", name)
                .build()
            accounts.accountMap[name.getString()] = currentAccount
            log.info("Principal: {}", objectMapper.writeValueAsString(principal))
            log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken))
            return Response.ok(jsonObject)
                .build()
        }
    }
}