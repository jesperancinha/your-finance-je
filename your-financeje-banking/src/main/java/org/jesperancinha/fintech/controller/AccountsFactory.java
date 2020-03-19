package org.jesperancinha.fintech.controller;

import org.jesperancinha.fintech.model.Accounts;

import javax.enterprise.context.SessionScoped;
import javax.ws.rs.Produces;
import java.io.Serializable;
import java.util.HashMap;

@SessionScoped
public class AccountsFactory implements Serializable {

    @Produces
    public Accounts getAccountMap() {
        return Accounts.builder().accountMap(new HashMap<>()).build();
    }

}
