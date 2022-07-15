package org.jesperancinha.fintech.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNullElse;

public record Account(
         String accountNumber,
         Client client,
         BigDecimal currentValue,
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
