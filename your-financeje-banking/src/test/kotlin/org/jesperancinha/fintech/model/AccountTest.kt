package org.jesperancinha.fintech.model;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void testAddCurrentValue() {
        val account = Account.builder().accountNumber("SDFSFS234862398643398246345345345928").build();
        val accountNew = account.addCurrentValue(100L);

        assertThat(accountNew.accountNumber()).isEqualTo("SDFSFS234862398643398246345345345928");
        assertThat(accountNew.creditValue()).isEqualTo(BigDecimal.valueOf(0L));
        assertThat(accountNew.currentValue()).isEqualTo(BigDecimal.valueOf(100L));
    }

    @Test
    public void testAddCreditValue() {
        val account = Account.builder().accountNumber("SDFSFS234862398643398246345345345928").build();
        val accountNew = account.addCreditValue(10L);

        assertThat(accountNew.accountNumber()).isEqualTo("SDFSFS234862398643398246345345345928");
        assertThat(accountNew.creditValue()).isEqualTo(BigDecimal.valueOf(10L));
        assertThat(accountNew.currentValue()).isEqualTo(BigDecimal.valueOf(0L));
    }
}