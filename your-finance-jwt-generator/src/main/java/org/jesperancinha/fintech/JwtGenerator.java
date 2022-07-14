package org.jesperancinha.fintech;

import picocli.CommandLine;

public class JwtGenerator {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new JwtGeneratorCommand()).execute(args);
        System.exit(exitCode);
    }
}