package org.jesperancinha.fintech.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class Account(
    @param:JsonProperty
    val accountNumber: String?,
    @param:JsonProperty
    val client: Client? = null,
    @param:JsonProperty
    val currentValue: BigDecimal = BigDecimal.ZERO,
    @param:JsonProperty
    val creditValue: BigDecimal = BigDecimal.ZERO
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
    @param:JsonProperty
    val name: String ?= null
)

data class TransactionBody constructor(
    @param:JsonProperty
    val saldo: Long ?= null
)