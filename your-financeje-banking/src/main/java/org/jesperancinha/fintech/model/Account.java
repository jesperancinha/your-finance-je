package org.jesperancinha.fintech.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

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
        this.currentValue = Optional.ofNullable(currentValue)
            .orElse(BigDecimal.ZERO)
            .add(BigDecimal.valueOf(value));
    }

    public void addCreditValue(Long value) {
        this.creditValue = Optional.ofNullable(creditValue)
            .orElse(BigDecimal.ZERO)
            .add(BigDecimal.valueOf(value));
    }
}
