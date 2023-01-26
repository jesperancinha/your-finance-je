package org.jesperancinha.fintech.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class AccountTest {
    @Test
    fun testAddCurrentValue() {
        val account = Account.builder().accountNumber("SDFSFS234862398643398246345345345928").build()
        val accountNew = account.addCurrentValue(100L)
        Assertions.assertThat(accountNew.accountNumber).isEqualTo("SDFSFS234862398643398246345345345928")
        Assertions.assertThat(accountNew.creditValue).isEqualTo(BigDecimal.valueOf(0L))
        Assertions.assertThat(accountNew.currentValue).isEqualTo(BigDecimal.valueOf(100L))
    }

    @Test
    fun testAddCreditValue() {
        val account = Account.builder().accountNumber("SDFSFS234862398643398246345345345928").build()
        val accountNew = account.addCreditValue(10L)
        Assertions.assertThat(accountNew.accountNumber).isEqualTo("SDFSFS234862398643398246345345345928")
        Assertions.assertThat(accountNew.creditValue).isEqualTo(BigDecimal.valueOf(10L))
        Assertions.assertThat(accountNew.currentValue).isEqualTo(BigDecimal.valueOf(0L))
    }
}