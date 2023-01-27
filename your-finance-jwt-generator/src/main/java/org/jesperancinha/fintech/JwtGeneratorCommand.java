package org.jesperancinha.fintech;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.concurrent.Callable;

/**
 * Created by jofisaes on 13/07/2022
 */
@Command(name = "JWT Generator",
        mixinStandardHelpOptions = true,
        version = "0.0.0",
        description = "Creates a JWT token based on payload and private key PEM")
public class JwtGeneratorCommand implements Callable<Integer> {

    @Option(names = {"-key", "--private-key-file"},
            description = "Private PEM (.pem) key file",
            defaultValue = "privateKey.pem",
            required = true)
    private File privateKeyFile;

    @Option(names = {"-p", "--payload"},
            description = "Payload (.json) file.",
            required = true)
    private File payloadFile;

    @Override
    public Integer call() throws Exception {
         final String jwtString = SecurityManager.generateJWTString(payloadFile, privateKeyFile);
        System.out.println(jwtString);
        return 0;
    }
}
