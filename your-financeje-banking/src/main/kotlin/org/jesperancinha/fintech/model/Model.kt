package org.jesperancinha.fintech.model

import java.math.BigDecimal

data class Account(
    val accountNumber: String?,
    val client: Client? = null,
    var currentValue: BigDecimal = BigDecimal.ZERO,
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

data class Accounts (
    val accountMap: MutableMap<String, Account>
)

data class Client constructor(val name: String)

data class TransactionBody(val saldo: Long)