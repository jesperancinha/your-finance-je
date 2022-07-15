package org.jesperancinha.fintech

import picocli.CommandLine.Command
import picocli.CommandLine.Option
import java.io.File
import java.util.concurrent.Callable

/**
 * Created by jofisaes on 13/07/2022
 */
@Command(
    name = "JWT Generator",
    mixinStandardHelpOptions = true,
    version = ["0.0.0"],
    description = ["Creates a JWT token based on payload and private key PEM"]
)
class JwtGeneratorCommand : Callable<Int?> {
    @Option(
        names = ["-key", "--private-key-file"],
        description = ["Private PEM (.pem) key file"],
        defaultValue = "privateKey.pem",
        required = true
    )
    private val privateKeyFile: File? = null

    @Option(names = ["-p", "--payload"], description = ["Payload (.json) file."], required = true)
    private val payloadFile: File? = null

    override fun call(): Int {
        val jwtString = SecurityManager.generateJWTString(payloadFile, privateKeyFile)
        println(jwtString)
        return 0
    }
}