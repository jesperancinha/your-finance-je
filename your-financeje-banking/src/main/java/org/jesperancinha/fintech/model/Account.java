package org.jesperancinha.fintech.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class Account {

    private String accountNumber;

    private Account account;

    private BigDecimal currentValue;

    private BigDecimal creditValue;
}
