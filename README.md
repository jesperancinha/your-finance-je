# Your Finance App

[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Your%20finance%20JE&color=informational)](https://github.com/jesperancinha/your-finance-je) 
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/your-finance-je.svg)](#)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c0692606b0864078b03f04e5d3464e5d)](https://www.codacy.com/manual/jofisaes/your-finance-je?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/your-finance-je&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/jesperancinha/your-finance-je.svg?style=svg)](https://circleci.com/gh/jesperancinha/your-finance-je)
[![codebeat badge](https://codebeat.co/badges/66bd8179-b645-40f4-9a02-072a8df5ff32)](https://codebeat.co/projects/github-com-jesperancinha-your-finance-je-master)
[![Build Status](https://travis-ci.com/jesperancinha/your-finance-je.svg?branch=master)](https://travis-ci.com/jesperancinha/your-finance-je)
[![BCH compliance](https://bettercodehub.com/edge/badge/jesperancinha/your-finance-je?branch=master)](https://bettercodehub.com/)
[![Build status](https://ci.appveyor.com/api/projects/status/u5yk9x8ldvk1g7h1/branch/master?svg=true)](https://ci.appveyor.com/project/jesperancinha/your-finance-je/branch/master)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/your-finance-je/badge.svg)](https://snyk.io/test/github/jesperancinha/your-finance-je)
[![Coverage Status](https://coveralls.io/repos/github/jesperancinha/your-finance-je/badge.svg?branch=master)](https://coveralls.io/github/jesperancinha/your-finance-je?branch=master)
[![codecov](https://codecov.io/gh/jesperancinha/your-finance-je/branch/master/graph/badge.svg?token=Tn7WAPeYui)](https://codecov.io/gh/jesperancinha/your-finance-je)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/your-finance-je.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/your-finance-je.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/your-finance-je.svg)](#)

Let's make a bunch of [KumuluzEE](https://ee.kumuluz.com/) Apps and with it investigate the most common secure protocols using REST services.

Here a the definitions of our apps:

1.  [your-finance-invoice-shipping](./your-financeje-invoice-shipping) - We will use JWT token. It will handle the sending of invoices
2.  [your-finance-banking](./your-financeje-banking) - We will access banking
3.  [your-finance-mortgages](./your-financeje-mortgages) - Let's buy a house!
4.  [your-financeje-overview](./your-financeje-overview) - Let's have an overview!

## Running microservices

In version 1.0.0, Kumuluz.EE ran only on Jetty. This is the server that is now being used although version 2.0.0 is now available.

To run the yourfinanceje-overview module on port 8080:

```
$ java -cp yourfinanceje-overview/target/classes:yourfinanceje-overview/target/dependency/* com.kumuluz.ee.EeApplication
```

## Setting up certificates

In order to setup the certificate, private key and get the main admin token, please run the following file.

```bash
setupCertificates.sh
```

## Hints and Tricks

### Generating Certificates

```bash
openssl req -new -newkey rsa:4096 -nodes -keyout yourfinance.key -out yourfinance.csr
openssl x509 -req -sha256 -days 365 -in yourfinance.csr -signkey yourfinance.key -out yourfinance.pem
```

### [Further reading](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Hints%26Tricks.md)

## References

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

## About me 👨🏽‍💻🚀🏳️‍🌈

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/credly-20.png "Credly")](https://www.credly.com/users/joao-esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED "João Esperancinha Homepage")](https://joaofilipesabinoesperancinha.nl/)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)   
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Webapp&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/google-apps-20.png "Google Apps")](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)   
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/sonatype-20.png "Sonatype Search Repos")](https://search.maven.org/search?q=org.jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/docker-20.png "Docker Images")](https://hub.docker.com/u/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/stack-overflow-20.png)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/reddit-20.png "Reddit")](https://www.reddit.com/user/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/devto-20.png "Dev To")](https://dev.to/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackernoon-20.jpeg "Hackernoon")](https://hackernoon.com/@jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeproject-20.png "Code Project")](https://www.codeproject.com/Members/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/github-20.png "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bitbucket-20.png "BitBucket")](https://bitbucket.org/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/gitlab-20.png "GitLab")](https://gitlab.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bintray-20.png "BinTray")](https://bintray.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/free-code-camp-20.jpg "FreeCodeCamp")](https://www.freecodecamp.org/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackerrank-20.png "HackerRank")](https://www.hackerrank.com/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeforces-20.png "Code Forces")](https://codeforces.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codebyte-20.png "Codebyte")](https://coderbyte.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codewars-20.png "CodeWars")](https://www.codewars.com/users/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codepen-20.png "Code Pen")](https://codepen.io/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hacker-news-20.png "Hacker News")](https://news.ycombinator.com/user?id=jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/infoq-20.png "InfoQ")](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/linkedin-20.png "LinkedIn")](https://www.linkedin.com/in/joaoesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/xing-20.png "Xing")](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/tumblr-20.png "Tumblr")](https://jofisaes.tumblr.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/pinterest-20.png "Pinterest")](https://nl.pinterest.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/quora-20.png "Quora")](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)

## Achievements

[![Oracle Certified Professional, JEE 7 Developer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-ee-7-application-developer-100.png "Oracle Certified Professional, JEE7 Developer")](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
[![Oracle Certified Professional, Java SE 11 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-11-developer-100.png "Oracle Certified Professional, Java SE 11 Programmer")](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
[![Oracle Certified Professional, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-8-programmer-100.png "Oracle Certified Professional, Java SE 8 Programmer")](https://www.credly.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074)
[![Oracle Certified Associate, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-8-programmer-100.png "Oracle Certified Associate, Java SE 8 Programmer")](https://www.credly.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7)
[![Oracle Certified Associate, Java SE 7 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-7-programmer-100.png "Oracle Certified Associate, Java SE 7 Programmer")](https://www.credly.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225)
[![Oracle Certified Junior Associate](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-foundations-associate-java-100.png "Oracle Certified Foundations Associate")](https://www.credly.com/badges/6db92c1e-7bca-4856-9543-0d5ed0182794)
