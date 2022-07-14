package org.jesperancinha.fintech

import picocli.CommandLine
import picocli.CommandLine.Command
import java.util.concurrent.Callable
import java.io.File

/**
 * Created by jofisaes on 13/07/2022
 */
@CommandLine.Command(
    name = "JWT Generator",
    mixinStandardHelpOptions = true,
    version = ["0.0.0"],
    description = ["Creates a JWT token based on payload and private key PEM"]
)
class JwtGeneratorCommand : Callable<Int?> {
    @CommandLine.Option(
        names = ["-key", "--private-key-file"],
        description = ["Private PEM (.pem) key file"],
        defaultValue = "privateKey.pem",
        required = true
    )
    private val privateKeyFile: File? = null

    @CommandLine.Option(names = ["-p", "--payload"], description = ["Payload (.json) file."], required = true)
    private val payloadFile: File? = null

    @Throws(Exception::class)
    override fun call(): Int {
        val jwtString = SecurityManager.generateJWTString(payloadFile, privateKeyFile)
        println(jwtString)
        return 0
    }
}