package org.jesperancinha.fintech.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNullElse;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String accountNumber;

    private Client client;

    @Default
    private BigDecimal currentValue = BigDecimal.ZERO;

    @Default
    private BigDecimal creditValue = BigDecimal.ZERO;

    public void addCurrentValue(Long value) {
        this.currentValue = requireNonNullElse(currentValue, BigDecimal.ZERO)
                .add(BigDecimal.valueOf(value));
    }

    public void addCreditValue(Long value) {
        this.creditValue = requireNonNullElse(creditValue, BigDecimal.ZERO)
                .add(BigDecimal.valueOf(value));
    }
}
