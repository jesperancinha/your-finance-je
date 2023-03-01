# Your Finance App

---
[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/jesperancinha/your-finance-je)
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

<div align="center">

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-100/JEOrgLogo-27.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![](https://img.shields.io/badge/youtube-%230077B5.svg?style=for-the-badge&logo=youtube&color=FF0000)](https://www.youtube.com/@joaoesperancinha)
[![](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@jofisaes)
[![](https://img.shields.io/badge/Buy%20Me%20A%20Coffee-%230077B5.svg?style=for-the-badge&logo=buymeacoffee&color=yellow)](https://www.buymeacoffee.com/jesperancinha)
[![](https://img.shields.io/badge/Twitter-%230077B5.svg?style=for-the-badge&logo=twitter&color=white)](https://twitter.com/joaofse)
[![](https://img.shields.io/badge/Mastodon-%230077B5.svg?style=for-the-badge&logo=mastodon&color=afd7f7)](https://masto.ai/@jesperancinha)
[![](https://img.shields.io/badge/Sessionize-%230077B5.svg?style=for-the-badge&logo=sessionize&color=cffff6)](https://sessionize.com/joao-esperancinha)
[![](https://img.shields.io/badge/Instagram-%230077B5.svg?style=for-the-badge&logo=instagram&color=purple)](https://www.instagram.com/joaofisaes)
[![](https://img.shields.io/badge/Tumblr-%230077B5.svg?style=for-the-badge&logo=tumblr&color=192841)](https://jofisaes.tumblr.com)
[![](https://img.shields.io/badge/Spotify-1ED760?style=for-the-badge&logo=spotify&logoColor=white)](https://open.spotify.com/user/jlnozkcomrxgsaip7yvffpqqm)
[![](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/joaoesperancinha/)
[![](https://img.shields.io/badge/Xing-%230077B5.svg?style=for-the-badge&logo=xing&color=064e40)](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![](https://img.shields.io/badge/YCombinator-%230077B5.svg?style=for-the-badge&logo=ycombinator&color=d0d9cd)](https://news.ycombinator.com/user?id=jesperancinha)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
[![](https://img.shields.io/badge/bitbucket-%230077B5.svg?style=for-the-badge&logo=bitbucket&color=blue)](https://bitbucket.org/jesperancinha)
[![](https://img.shields.io/badge/gitlab-%230077B5.svg?style=for-the-badge&logo=gitlab&color=orange)](https://gitlab.com/jesperancinha)
[![](https://img.shields.io/badge/Stack%20Overflow-%230077B5.svg?style=for-the-badge&logo=stackoverflow&color=5A5A5A)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![](https://img.shields.io/badge/Credly-%230077B5.svg?style=for-the-badge&logo=credly&color=064e40)](https://www.credly.com/users/joao-esperancinha)
[![](https://img.shields.io/badge/Coursera-%230077B5.svg?style=for-the-badge&logo=coursera&color=000080)](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![](https://img.shields.io/badge/Docker-%230077B5.svg?style=for-the-badge&logo=docker&color=cyan)](https://hub.docker.com/u/jesperancinha)
[![](https://img.shields.io/badge/Reddit-%230077B5.svg?style=for-the-badge&logo=reddit&color=black)](https://www.reddit.com/user/jesperancinha/)
[![](https://img.shields.io/badge/Hackernoon-%230077B5.svg?style=for-the-badge&logo=hackernoon&color=0a5d00)](https://hackernoon.com/@jesperancinha)
[![](https://img.shields.io/badge/Code%20Project-%230077B5.svg?style=for-the-badge&logo=codeproject&color=063b00)](https://www.codeproject.com/Members/jesperancinha)
[![](https://img.shields.io/badge/Free%20Code%20Camp-%230077B5.svg?style=for-the-badge&logo=freecodecamp&color=0a5d00)](https://www.freecodecamp.org/jofisaes)
[![](https://img.shields.io/badge/Hackerrank-%230077B5.svg?style=for-the-badge&logo=hackerrank&color=1e2f97)](https://www.hackerrank.com/jofisaes)
[![](https://img.shields.io/badge/LeetCode-%230077B5.svg?style=for-the-badge&logo=leetcode&color=002647)](https://leetcode.com/jofisaes)
[![](https://img.shields.io/badge/Codewars-%230077B5.svg?style=for-the-badge&logo=codewars&color=722F37)](https://www.codewars.com/users/jesperancinha)
[![](https://img.shields.io/badge/CodePen-%230077B5.svg?style=for-the-badge&logo=codepen&color=black)](https://codepen.io/jesperancinha)
[![](https://img.shields.io/badge/HackerEarth-%230077B5.svg?style=for-the-badge&logo=hackerearth&color=00035b)](https://www.hackerearth.com/@jofisaes)
[![](https://img.shields.io/badge/Khan%20Academy-%230077B5.svg?style=for-the-badge&logo=khanacademy&color=00035b)](https://www.khanacademy.org/profile/jofisaes)
[![](https://img.shields.io/badge/Pinterest-%230077B5.svg?style=for-the-badge&logo=pinterest&color=FF0000)](https://nl.pinterest.com/jesperancinha)
[![](https://img.shields.io/badge/Quora-%230077B5.svg?style=for-the-badge&logo=quora&color=FF0000)](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
[![](https://img.shields.io/badge/Google%20Play-%230077B5.svg?style=for-the-badge&logo=googleplay&color=purple)](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
| [Sonatype Search Repos](https://search.maven.org/search?q=org.jesperancinha)
| [Dev.TO](https://dev.to/jofisaes)
| [Codebyte](https://coderbyte.com/profile/jesperancinha)
| [InfoQ](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![](https://img.shields.io/badge/OCP%20Java%2011-%230077B5.svg?style=for-the-badge&logo=oracle&color=064e40)](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
[![](https://img.shields.io/badge/OCP%20JEE%207-%230077B5.svg?style=for-the-badge&logo=oracle&color=064e40)](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
[![](https://img.shields.io/badge/VMWare%20Spring%20Professional%202021-%230077B5.svg?style=for-the-badge&logo=spring&color=064e40)](https://www.credly.com/badges/762fa7a4-9cf4-417d-bd29-7e072d74cdb7)
[![](https://img.shields.io/badge/IBM%20Cybersecurity%20Analyst%20Professional-%230077B5.svg?style=for-the-badge&logo=ibm&color=064e40)](https://www.credly.com/badges/ad1f4abe-3dfa-4a8c-b3c7-bae4669ad8ce)
[![](https://img.shields.io/badge/Deep%20Learning-%230077B5.svg?style=for-the-badge&logo=ibm&color=064e40)](https://www.credly.com/badges/8d27e38c-869d-4815-8df3-13762c642d64)
[![](https://img.shields.io/badge/Certified%20Neo4j%20Professional-%230077B5.svg?style=for-the-badge&logo=neo4j&color=064e40)](https://graphacademy.neo4j.com/certificates/c279afd7c3988bd727f8b3acb44b87f7504f940aac952495ff827dbfcac024fb.pdf)
[![](https://img.shields.io/badge/Certified%20Advanced%20JavaScript%20Developer-%230077B5.svg?style=for-the-badge&logo=javascript&color=064e40)](https://cancanit.com/certified/1462/)
[![](https://img.shields.io/badge/Kong%20Champions-%230077B5.svg?style=for-the-badge&logo=kong&color=064e40)](https://konghq.com/kong-champions)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=064e40&style=for-the-badge "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=064e40&style=for-the-badge "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=orange&style=for-the-badge "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)

</div>
