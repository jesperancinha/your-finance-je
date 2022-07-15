package org.jesperancinha.fintech.model;

import junit.framework.TestCase;
import lombok.val;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest extends TestCase {

    public void testAddCurrentValue() {
        val account = Account.builder().accountNumber("SDFSFS234862398643398246345345345928").build();
        val accountNew = account.addCurrentValue(100L);

        assertThat(accountNew.accountNumber()).isEqualTo("SDFSFS234862398643398246345345345928");
        assertThat(accountNew.creditValue()).isEqualTo(BigDecimal.valueOf(0L));
        assertThat(accountNew.currentValue()).isEqualTo(BigDecimal.valueOf(100L));
    }

    public void testAddCreditValue() {
        val account = Account.builder().accountNumber("SDFSFS234862398643398246345345345928").build();
        val accountNew = account.addCreditValue(10L);

        assertThat(accountNew.accountNumber()).isEqualTo("SDFSFS234862398643398246345345345928");
        assertThat(accountNew.creditValue()).isEqualTo(BigDecimal.valueOf(10L));
        assertThat(accountNew.currentValue()).isEqualTo(BigDecimal.valueOf(0L));
    }
}