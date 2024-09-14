# Your Finance App

---

[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Your%20finance%20JE&color=informational)](https://github.com/jesperancinha/your-finance-je) 
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/your-finance-je.svg)](#)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

[![CircleCI](https://circleci.com/gh/jesperancinha/your-finance-je.svg?style=svg)](https://circleci.com/gh/jesperancinha/your-finance-je)
[![Build status](https://ci.appveyor.com/api/projects/status/u5yk9x8ldvk1g7h1/branch/master?svg=true)](https://ci.appveyor.com/project/jesperancinha/your-finance-je/branch/master)
[![your-finance-je](https://github.com/jesperancinha/your-finance-je/actions/workflows/your-finance-je.yml/badge.svg)](https://github.com/jesperancinha/your-finance-je/actions/workflows/your-finance-je.yml)
[![e2e-your-finance-je](https://github.com/jesperancinha/your-finance-je/actions/workflows/your-finance-je-e2e.yml/badge.svg)](https://github.com/jesperancinha/your-finance-je/actions/workflows/your-finance-je-e2e.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/b1ba6086c1b44820b62345c44bee2f1d)](https://www.codacy.com/gh/jesperancinha/your-finance-je/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/your-finance-je&amp;utm_campaign=Badge_Grade)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/your-finance-je/badge.svg)](https://snyk.io/test/github/jesperancinha/your-finance-je)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/b1ba6086c1b44820b62345c44bee2f1d)](https://www.codacy.com/gh/jesperancinha/your-finance-je/dashboard?utm_source=github.com&utm_medium=referral&utm_content=jesperancinha/your-finance-je&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/jesperancinha/your-finance-je/badge.svg?branch=master)](https://coveralls.io/github/jesperancinha/your-finance-je?branch=master)
[![codecov](https://codecov.io/gh/jesperancinha/your-finance-je/branch/master/graph/badge.svg?token=Tn7WAPeYui)](https://codecov.io/gh/jesperancinha/your-finance-je)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/your-finance-je.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/your-finance-je.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/your-finance-je.svg)](#)

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/kotlin-50.png "Kotlin")](https://kotlinlang.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/jetty-50.png "Jetty")](https://www.eclipse.org/jetty/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/kumuluzee-50.png "KumuluzEE")](https://ee.kumuluz.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/swagger-50.png "Swagger")](https://swagger.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/cypress-50.png "Cypress")](https://www.cypress.io/)

---

# Introduction

Creation of one  [KumuluzEE](https://ee.kumuluz.com/) App and with it investigate how the JWT token works.

This is the main project struture:

1.  [your-finance-banking](./your-financeje-banking) - This is an extremely basic banking application that only performs a couple of functions
2.  [your-finance-jwt-generator](./your-finance-jwt-generator) - Java project that creates a JWT token. It is an alternative to project [jwtenizr](https://github.com/AdamBien/jwtenizr), by [Adam Bien](https://github.com/AdamBien).
3.  [your-finance-k-jwt-generator](./your-finance-k-jwt-generator) - Kotlin project that creates a JWT token. It is an alternative to project [jwtenizr](https://github.com/AdamBien/jwtenizr), by [Adam Bien](https://github.com/AdamBien).

This project is also the official support project of my article on medium:

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://itnext.io/learning-jwt-security-using-kumuluzee-the-finances-of-a-league-of-the-environment-2f541e99cc90) [Learning JWT security using KumuluzEE — The finances of a league of the environment](https://itnext.io/learning-jwt-security-using-kumuluzee-the-finances-of-a-league-of-the-environment-2f541e99cc90)


<div align="center">
      <a title="Learning JWT security using KumuluzEE — The finances of a league of the environment" href="https://itnext.io/learning-jwt-security-using-kumuluzee-the-finances-of-a-league-of-the-environment-2f541e99cc90">
     <img 
          src="./docs/images/articles.your.finance.intro.png" 
          style="width:100%;">
      </a>
</div>

#### Stable releases

-   [0.0.0](https://github.com/jesperancinha/your-finance-je/tree/0.0.0) - [0bae454ebed482d6f1652bbc295c2b8b07bd1a20](https://github.com/jesperancinha/your-finance-je/tree/0.0.0) - Java / JD17 / KumuluzEE
-   [1.0.0](https://github.com/jesperancinha/your-finance-je/tree/1.0.0) - [ecd9d600f0ab265f343f3697f6f36a17a35f9aa6](https://github.com/jesperancinha/your-finance-je/tree/1.0.0) - Kotlin 1.8.0 / JDK17 / KumuluzEE

## How to run

There are many scripts available in the [Makefile](./Makefile) at the root of this project. However, the way to start this project and see all the aspects of it, it's better to just start the containers and open the cypress console;

1.  Run command `make dcup-full-action`
2.  Run cypress with `make cypress-open`

> You can also run everything at once with `make demo-action`

#### Behind the scenes

Running the previous commands performs the following actions

1.  Cleanup environment
2.  Make a first Maven build to ensure that the JWT generator project is compiled
3.  Creates AWS tokens using [jwtenizr](https://github.com/AdamBien/jwtenizr) and [your-finance-jwt-generator](./your-finance-jwt-generator) in separate locations:   
      1.  Start Generation Scripts
      2.  Create User creation script: [jwtenizr-files/createUser.sh](./jwtenizr-files/createUser.sh) and [your-finance-files/createUser.sh](./your-finance-files/createUser.sh)
      3.  Create Account creation script: [jwtenizr-files/createAccount.sh](./jwtenizr-files/createAccount.sh) and [your-finance-files/createAccount.sh](./your-finance-files/createAccount.sh)
      4.  Create Send Money creation script: [jwtenizr-files/sendMoney.sh](./jwtenizr-files/sendMoney.sh) and [your-finance-files/sendMoney.sh](./your-finance-files/sendMoney.sh)
      5.  Create Asks Credit script: [jwtenizr-files/askCredit.sh](./jwtenizr-files/askCredit.sh) and [your-finance-files/askCredit.sh](./your-finance-files/askCredit.sh)
4.  Creates CSV to be used in Swagger tests;
      1.  Name/JWT token pairs: [jwtenizr-files/tokenNameValue.csv](./jwtenizr-files/tokenNameValue.csv) and [your-finance-files/tokenNameValue.csv](./your-finance-files/tokenNameValue.csv)
5.  Sets variables in [config.yml](your-financeje-banking/src/main/resources/config.yml)
6.  Makes new Maven build to create a running [jar](your-financeje-banking/target/your-financeje-banking.jar) with the correct configuration
7.  Copies both jars to separate folders[your-finance-images](./your-finance-images)
8.  Starts both containers via [your-finance-images/docker-compose.yaml](./your-finance-images/docker-compose.yaml)
9.  Runs cypress console

## Generating Certificates

```bash
openssl req -new -newkey rsa:4096 -nodes -keyout yourfinance.key -out yourfinance.csr
openssl x509 -req -sha256 -days 365 -in yourfinance.csr -signkey yourfinance.key -out yourfinance.pem
```

## References

-   [Eclipse MicroProfile JWT Authentication API](https://docs.payara.fish/enterprise/docs/documentation/microprofile/jwt.html)
-   [MicroProfile JSON Web Token (JWT)](https://www.tomitribe.com/blog/microprofile-json-web-token-jwt/)
-   [JSON Web Token Claims](https://auth0.com/docs/tokens/concepts/jwt-claims)
-   [Kumuluz Blog](https://blog.kumuluz.com/product/developers/2017/05/03/microservices-with-java-ee-and-kumuluzee-updated.html)
-   [kumuluzEE](https://ee.kumuluz.com/)
-   [REST API Security](https://dzone.com/refcardz/rest-api-security-1?chapter=1)
-   [RESTful API Security](https://dzone.com/articles/restful-api-security?fromrel=true)
-   [Tutorial: Create and Verify JWTs in Java](https://developer.okta.com/blog/2018/10/31/jwts-with-java)
-   [oktadeveloper/okta-java-jwt-example](https://github.com/oktadeveloper/okta-java-jwt-example)
-   [Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-cli.html)
-   [Java EE Security API (JSR 375/Soteria) with JWT tokens](https://blog.payara.fish/java-ee-security-api-jsr-375/soteria-with-jwt-tokens)
-   [payara/Payara-Examples](https://github.com/payara/Payara-Examples/tree/master/javaee/security-jwt-example)
-   [Securing JAX-RS Endpoints with JWT](https://antoniogoncalves.org/2016/10/03/securing-jax-rs-endpoints-with-jwt/)
-   [Secure your application with Eclipse MicroProfile JWT Auth](https://rieckpil.de/whatis-eclipse-microprofile-jwt-auth/)
-   [JWT Dispenser](http://jwtenizr.sh/)
-   [Configurable Token Expiration 4.0.0](https://github.com/AdamBien/jwtenizr/releases/tag/0.0.4)
-   [Microservices with KumuluzEE MicroProfile 1.2](https://github.com/kumuluz/kumuluzee-samples/tree/master/kumuluzee-microProfile-1.2)
-   [JWT authentication: When and how to use it](https://blog.logrocket.com/jwt-authentication-best-practices/)
-   [The Ultimate Guide to handling JWTs on frontend clients (GraphQL)](https://hasura.io/blog/best-practices-of-using-jwt-with-graphql/)
-   [IANA JSON Web Token (JWT)](https://www.iana.org/assignments/jwt/jwt.xhtml)
-   [CyberChef](https://gchq.github.io/CyberChef/)
-   [Using KumuluzEE Security](https://kumuluz.io/blog/kumuluzee/security/2017/09/17/kumuluzee-security-usage/)
-   [A plain English introduction to JSON web tokens (JWT): what it is and what it isn’t](https://medium.com/ag-grid/a-plain-english-introduction-to-json-web-tokens-jwt-what-it-is-and-what-it-isnt-8076ca679843)
-   [Internet Engineering Task Force RFC7519](https://tools.ietf.org/html/rfc7519)

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
