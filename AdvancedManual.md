# your-finance-je

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
