package org.jesperancinha.fintech.controller;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@LoginConfig(authMethod = "MP-JWT")
@ApplicationPath("resources")
@DeclareRoles({"admin", "chief", "duke", "hacker"})
public class BankApplication extends Application {

}