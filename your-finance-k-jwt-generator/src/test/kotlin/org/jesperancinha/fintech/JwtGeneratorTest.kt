package org.jesperancinha.fintech

import org.jesperancinha.fintech.JwtGenerator.runCommand
import org.junit.jupiter.api.Test

internal class JwtGeneratorTest {
    @Test
    fun `should not run with empty input arguments but also not result in exception`() {
        runCommand(arrayOf())
    }
}