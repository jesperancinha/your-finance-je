package org.jesperancinha.fintech.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Accounts {
    private Map<String, Account> accountMap;
}
