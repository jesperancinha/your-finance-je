package org.jesperancinha.fintech.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
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

    private BigDecimal currentValue;

    private BigDecimal creditValue;

    public void addValue() {
        this.currentValue = Optional.ofNullable(currentValue).orElse(BigDecimal.ZERO).add(BigDecimal.valueOf(10L));
    }
}
