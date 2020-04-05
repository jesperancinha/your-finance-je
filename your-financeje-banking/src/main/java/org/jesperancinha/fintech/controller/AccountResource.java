package org.jesperancinha.fintech.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jesperancinha.fintech.model.Account;
import org.jesperancinha.fintech.model.Accounts;
import org.jesperancinha.fintech.model.Client;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

@Path("accounts")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class AccountResource {

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

    @POST
    @RolesAllowed({ "admin",  "client", "credit"})
    public Response createAccount() throws JsonProcessingException {
        final Account currentAccount = ofNullable(accounts.getAccountMap()
            .get(name.getString())).orElse(Account.builder()
            .client(Client.builder()
                .name(name.getString())
                .build())
            .build());

        return createResponse(currentAccount);
    }
    @POST
    @RolesAllowed({ "admin",  "user"})
    @Path("user")
    public Response createUser() throws JsonProcessingException {
        final Account currentAccount = ofNullable(accounts.getAccountMap()
            .get(name.getString())).orElse(Account.builder()
            .client(Client.builder()
                .name(name.getString())
                .build())
            .build());

        return createResponse(currentAccount);
    }

    @GET
    @RolesAllowed({ "admin", "client" })
    public Response getAccount() throws JsonProcessingException {
        final Account userAccount = accounts.getAccountMap()
            .get(name.getString());
        if (isNull(userAccount)) {
            return Response.serverError()
                .build();
        }
        return createResponse(userAccount);
    }

    @PUT
    @Path("{value}")
    @RolesAllowed({ "admin", "client" })
    public Response cashIn(
        @PathParam("value")
            Long value) throws JsonProcessingException {
        final Account userAccount = accounts.getAccountMap()
            .get(name.getString());
        if (isNull(userAccount)) {
            return Response.serverError()
                .build();
        }
        userAccount.addCurrentValue(value);
        return createResponse(userAccount);
    }

    @GET
    @Path("all")
    public Response getAll() throws JsonProcessingException {
        final List<Account> allAcounts = new ArrayList<>(accounts.getAccountMap()
            .values());
        log.info("Principal: {}", objectMapper.writeValueAsString(principal));
        log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken));
        return Response.ok(allAcounts)
            .build();
    }

    @GET
    @Path("summary")
    public Response getSummary() throws JsonProcessingException {
        BigDecimal totalCredit = accounts.getAccountMap()
            .values()
            .stream()
            .map(Account::getCurrentValue)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);
        final JsonObject jsonObject = Json.createObjectBuilder()
            .add("totalCurrent", totalCredit)
            .add("client", "Team Let's Get Physical")
            .build();

        log.info("Summary");
        log.info("Principal: {}", objectMapper.writeValueAsString(principal));
        log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken));
        return Response.ok(jsonObject)
            .build();
    }

    private Response createResponse(Account currentAccount) throws JsonProcessingException {
        final JsonObject jsonObject = Json.createObjectBuilder()
            .add("balance", currentAccount.getCurrentValue())
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