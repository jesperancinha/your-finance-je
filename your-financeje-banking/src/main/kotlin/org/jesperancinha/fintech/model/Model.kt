package org.jesperancinha.fintech.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class Account(
    @JsonProperty
    val accountNumber: String?,
    @JsonProperty
    val client: Client? = null,
    @JsonProperty
    var currentValue: BigDecimal = BigDecimal.ZERO,
    @JsonProperty
    var creditValue: BigDecimal = BigDecimal.ZERO
) {
    fun addCurrentValue(value: Long) = Account(
        accountNumber, client, currentValue
            .add(BigDecimal.valueOf(value)), creditValue
    )

    fun addCreditValue(value: Long): Account = Account(
        accountNumber, client, currentValue, currentValue
            .add(BigDecimal.valueOf(value))
    )
}

open class Accounts constructor(
    open val accountMap: MutableMap<String, Account> = mutableMapOf()
)

data class Client constructor(
    @JsonProperty
    val name: String
)

data class TransactionBody constructor(
    @JsonProperty
    val saldo: Long
)