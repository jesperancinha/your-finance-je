package org.jesperancinha.fintech.controller;

import org.jesperancinha.fintech.model.Accounts;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.Serializable;
import java.util.HashMap;

public class AccountsFactory implements Serializable {

    @Produces
    @AccountsProduct
    @ApplicationScoped
    public Accounts getAccounts() {
        return Accounts.builder().accountMap(new HashMap<>()).build();
    }

}
