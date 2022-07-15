package org.jesperancinha.fintech.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jesperancinha.fintech.model.Account;
import org.jesperancinha.fintech.model.Accounts;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonString;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;

import static java.util.Objects.isNull;
import static javax.ws.rs.core.Response.serverError;

@Path("credit")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class CreditResource {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    @AccountsProduct
    private Accounts accounts;

    @Inject
    private Principal principal;

    @Inject
    private JsonWebToken jsonWebToken;

    @Inject
    @Claim("user_id")
    private JsonNumber administratorId;

    @Inject
    @Claim("access")
    private JsonString administratorLevel;

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
    @Path("{value}")
    @RolesAllowed({"admin", "credit"})
    public Response cashIn(
            @PathParam("value")
            Long value) throws JsonProcessingException {
        val userAccount = accounts.getAccountMap()
                .get(name.getString());
        if (isNull(userAccount)) {
            return serverError()
                    .build();
        }
        return createResponse(userAccount.addCreditValue(value));
    }

    @GET
    @Path("all")
    public Response getAll() throws JsonProcessingException {
        val allAcounts = new ArrayList<>(accounts.getAccountMap()
                .values());
        log.info("Principal: {}", objectMapper.writeValueAsString(principal));
        log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken));
        return Response.ok(allAcounts)
                .build();
    }

    @GET
    @Path("summary")
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

    private Response createResponse(Account currentAccount) throws JsonProcessingException {
        return AccountsFactory.createResponse(currentAccount, name, accounts, log, objectMapper, principal, jsonWebToken);
    }
}