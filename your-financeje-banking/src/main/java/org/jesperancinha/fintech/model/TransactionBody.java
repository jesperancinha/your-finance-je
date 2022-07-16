package org.jesperancinha.fintech.model;

import javax.json.bind.annotation.JsonbCreator;

public record TransactionBody(
        Long saldo
) {
    @JsonbCreator
    public TransactionBody {
    }
}
