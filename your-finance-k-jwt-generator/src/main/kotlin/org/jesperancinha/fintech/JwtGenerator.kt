package org.jesperancinha.fintech

import picocli.CommandLine
import kotlin.system.exitProcess

object JwtGenerator {
    @JvmStatic
    fun main(args: Array<String>) {
        val exitCode = runCommand(args)
        exitProcess(exitCode)
    }

    fun runCommand(args: Array<String>) =
        CommandLine(JwtGeneratorCommand()).execute(*args)

}