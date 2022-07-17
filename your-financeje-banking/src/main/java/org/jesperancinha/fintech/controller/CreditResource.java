package org.jesperancinha.fintech.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jesperancinha.fintech.model.Account;
import org.jesperancinha.fintech.model.Accounts;
import org.jesperancinha.fintech.model.TransactionBody;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonString;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;

import static java.util.Objects.isNull;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.serverError;

@Path("credit")
@RequestScoped
@Produces(APPLICATION_JSON)
@Slf4j
public class CreditResource {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    @AccountsProduct
    private Accounts accounts;

    @Inject
    private Principal principal;

    @Inject
    private JsonWebToken jsonWebToken;

    @Inject
    @Claim("access")
    private JsonString access;

    @Inject
    @Claim("iat")
    private JsonNumber iat;

    @Inject
    @Claim("name")
    private JsonString name;

    @Inject
    @Claim("user_id")
    private JsonNumber userId;

    @GET
    @RolesAllowed({"admin", "credit"})
    public Response getAccount() throws JsonProcessingException {
        val userAccount = accounts.getAccountMap()
                .get(name.getString());
        if (isNull(userAccount)) {
            return serverError().build();
        }
        return createResponse(userAccount);
    }

    @PUT
    @RolesAllowed({"admin", "credit"})
    @Consumes(APPLICATION_JSON)
    public Response cashIn(final TransactionBody transactionBody) throws JsonProcessingException {
        val userAccount = accounts.getAccountMap()
                .get(name.getString());
        if (isNull(userAccount)) {
            return serverError()
                    .build();
        }
        val currentAccount = userAccount.addCreditValue(transactionBody.saldo());
        accounts.getAccountMap().put(name.getString(), currentAccount);
        return createResponse(currentAccount);
    }

    @GET
    @Path("all")
    @Produces(APPLICATION_JSON)
    public Response getAll() throws JsonProcessingException {
        val allAccounts = new ArrayList<>(accounts.getAccountMap()
                .values());
        log.info("Principal: {}", objectMapper.writeValueAsString(principal));
        log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken));
        return Response.ok(allAccounts)
                .build();
    }

    @GET
    @Path("summary")
    @Produces(APPLICATION_JSON)
    public Response getSummary() throws JsonProcessingException {
        val totalCredit = accounts.getAccountMap()
                .values()
                .stream()
                .map(Account::creditValue)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        val jsonObject = Json.createObjectBuilder()
                .add("totalCredit", totalCredit)
                .add("client", "Mother Nature Dream Team")
                .build();
        log.info("Summary");
        log.info("Principal: {}", objectMapper.writeValueAsString(principal));
        log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken));
        return Response.ok(jsonObject)
                .build();
    }

    @GET
    @RolesAllowed({"admin", "client"})
    @Path("jwt")
    public Response getJWT() {
        val jsonObject = Json.createObjectBuilder()
                .add("jwt", jsonWebToken.getRawToken())
                .add("userId", userId.doubleValue())
                .add("access", access.getString())
                .add("iat", iat.doubleValue())
                .build();
        return Response.ok(jsonObject)
                .build();
    }

    private Response createResponse(Account currentAccount) throws JsonProcessingException {
        return AccountsFactory.createResponse(currentAccount, name, accounts, log, objectMapper, principal, jsonWebToken);
    }
}