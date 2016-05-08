# your-finance-je
Analysis of a particular test case for KumuluzEE. Goal is to understand the framework and buld microservices for a future application

## Running microservices

In version 1.0.0, Kumuluz.EE ran only on Jetty. This is the server that is now being used although version 2.0.0 is now available.

To run the yourfinanceje-overview module on port 8080:

```
$ java -cp yourfinanceje-overview/target/classes:yourfinanceje-overview/target/dependency/* com.kumuluz.ee.EeApplication
```

## Resources:

* https://ee.kumuluz.com/tutorial/2015/06/04/microservices-with-java-ee-and-kumuluzee.html
