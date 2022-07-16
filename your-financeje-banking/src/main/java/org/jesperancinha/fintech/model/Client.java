package org.jesperancinha.fintech.model;

import lombok.Builder;
import lombok.Getter;

public record Client(
        @Getter
        String name
) {
    @Builder
    public Client {
    }
}
