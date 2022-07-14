package org.jesperancinha.fintech

import picocli.CommandLine
import kotlin.system.exitProcess

object JwtGenerator {
    @JvmStatic
    fun main(args: Array<String>) {
        val exitCode = CommandLine(JwtGeneratorCommand()).execute(*args)
        exitProcess(exitCode)
    }
}