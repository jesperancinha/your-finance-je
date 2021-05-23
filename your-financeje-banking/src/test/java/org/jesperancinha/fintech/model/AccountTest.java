package org.jesperancinha.fintech.model;

import junit.framework.TestCase;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest extends TestCase {

    public void testAddCurrentValue() {
        final var account = Account.builder().accountNumber("SDFSFS234862398643398246345345345928").build();
        account.addCurrentValue(100L);

        assertThat(account.getAccountNumber()).isEqualTo("SDFSFS234862398643398246345345345928");
        assertThat(account.getCreditValue()).isEqualTo(BigDecimal.valueOf(0L));
        assertThat(account.getCurrentValue()).isEqualTo(BigDecimal.valueOf(100L));
    }

    public void testAddCreditValue() {
        final var account = Account.builder().accountNumber("SDFSFS234862398643398246345345345928").build();
        account.addCreditValue(10L);

        assertThat(account.getAccountNumber()).isEqualTo("SDFSFS234862398643398246345345345928");
        assertThat(account.getCreditValue()).isEqualTo(BigDecimal.valueOf(10L));
        assertThat(account.getCurrentValue()).isEqualTo(BigDecimal.valueOf(0L));
    }
}