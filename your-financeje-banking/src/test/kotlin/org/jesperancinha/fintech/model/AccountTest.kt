package org.jesperancinha.fintech.model

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class AccountTest {
    @Test
    fun `should add current value`() {
        val account = Account(
            accountNumber = "SDFSFS234862398643398246345345345928"
        )
        val accountNew = account.addCurrentValue(100L)
        accountNew.accountNumber shouldBe "SDFSFS234862398643398246345345345928"
        accountNew.creditValue shouldBe BigDecimal.valueOf(0L)
        accountNew.currentValue shouldBe BigDecimal.valueOf(100L)
    }

    @Test
    fun `should add credit value`() {
        val account = Account(
            accountNumber = "SDFSFS234862398643398246345345345928"
        )
        val accountNew = account.addCreditValue(10L)
        accountNew.accountNumber shouldBe "SDFSFS234862398643398246345345345928"
        accountNew.creditValue shouldBe BigDecimal.valueOf(10L)
        accountNew.currentValue shouldBe BigDecimal.valueOf(0L)
    }
}