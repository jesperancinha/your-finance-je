package org.jesperancinha.fintech.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNullElse;

public record Account(
        @Getter
        String accountNumber,
        @Getter
        Client client,
        @Getter
        BigDecimal currentValue,
        @Getter
        BigDecimal creditValue
){
    @Builder
    public Account(String accountNumber, Client client) {
        this(accountNumber, client, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    public Account addCurrentValue(Long value) {
        return new Account(accountNumber, client, requireNonNullElse(currentValue, BigDecimal.ZERO)
                .add(BigDecimal.valueOf(value)), creditValue);
    }

    public Account addCreditValue(Long value) {
        return new Account(accountNumber, client, currentValue, requireNonNullElse(creditValue, BigDecimal.ZERO)
                .add(BigDecimal.valueOf(value)));
    }
}
