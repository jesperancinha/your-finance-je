package org.jesperancinha.fintech.model;

import lombok.Builder;


public record Client(
        String name
) {
    @Builder
    public Client {

    }
}
