package org.jesperancinha.fintech.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jesperancinha.fintech.model.Account;
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
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Path("accounts")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class AccountResource {

    private static Map<String, Account> accountMap = new HashMap<>();

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    private Principal principal;

    @Inject
    private JsonWebToken jsonWebToken;

    @Inject
    @Claim("user_id")
    private JsonNumber administratorId;

    @Inject
    @Claim("accecc_level")
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
    @RolesAllowed("admin")
    public Response getAccount() throws JsonProcessingException {

        final Account currentAccount = Optional.ofNullable(accountMap.get(name.getString())).orElse(Account.builder()
                .client(Client.builder().name(name.getString()).build()).build());

        return createResponse(currentAccount);
    }

    @POST
    @RolesAllowed("admin")
    public Response cashIn() throws JsonProcessingException {

        final Account currentAccount = Optional.ofNullable(accountMap.get(name.getString())).orElse(
                Account.builder()
                        .accountNumber(userId.toString())
                        .client(Client.builder().name(name.getString()).build()).build());

        currentAccount.addValue();

        return createResponse(currentAccount);
    }

    @GET
    @Path("all")
    public Response getAll() throws JsonProcessingException {
        final List<Account> accounts = new ArrayList<>(accountMap.values());
        log.info("Principal: {}", objectMapper.writeValueAsString(principal));
        log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken));
        return Response.ok(accounts).build();
    }


    private Response createResponse(Account currentAccount) throws JsonProcessingException {
        final JsonObject jsonObject = Json.createObjectBuilder()
                .add("balance", currentAccount.getCurrentValue())
                .add("client", name)
                .build();

        accountMap.put(name.getString(), currentAccount);
        log.info("Principal: {}", objectMapper.writeValueAsString(principal));
        log.info("JSonWebToken: {}", objectMapper.writeValueAsString(jsonWebToken));
        return Response.ok(jsonObject).build();
    }
}