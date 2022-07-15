package org.jesperancinha.fintech.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jesperancinha.fintech.model.Account;
import org.jesperancinha.fintech.model.Accounts;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.json.Json;
import javax.json.JsonString;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.security.Principal;
import java.util.HashMap;

public class AccountsFactory implements Serializable {

    @Produces
    @AccountsProduct
    @ApplicationScoped
    public Accounts getAccounts() {
        return Accounts.builder()
            .accountMap(new HashMap<>())
            .build();
    }

    static Response createResponse(Account currentAccount, JsonString name, Accounts accounts, Logger log, ObjectMapper objectMapper, Principal principal, JsonWebToken jsonWebToken) throws JsonProcessingException {
        val jsonObject = Json.createObjectBuilder()
                .add("balance", currentAccount.currentValue())
                .add("client", name)
                .build();

        accounts.getAccountMap()
                .put(name.getString(), currentAccount);
        log.info("Principal: {}", objectMapper.writeValueAsString(principal));
        log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken));
        return Response.ok(jsonObject)
                .build();
    }
}
