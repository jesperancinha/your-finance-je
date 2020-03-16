package org.jesperancinha.fintech.controller;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@LoginConfig(authMethod = "MP-JWT")
public class BankApplication extends Application {

}