package org.jesperancinha.fintech.controller;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@LoginConfig(authMethod = "MP-JWT")
@ApplicationPath("/")
@DeclareRoles({ "admin",
                  "creditor",
                  "client",
                  "user" })
public class BankApplication extends Application {
}