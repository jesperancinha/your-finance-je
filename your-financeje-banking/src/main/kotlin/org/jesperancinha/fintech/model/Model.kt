package org.jesperancinha.fintech.model

import java.math.BigDecimal

data class Account(
    val accountNumber: String?,
    val client: Client?,
    var currentValue: BigDecimal?,
    var creditValue: BigDecimal?
) {
    fun addCurrentValue(value: Long) = Account(
        accountNumber, client, (currentValue ?: BigDecimal.ZERO)
            .add(BigDecimal.valueOf(value)), creditValue
    )

    fun addCreditValue(value: Long): Account = Account(
        accountNumber, client, currentValue, (currentValue ?: BigDecimal.ZERO)
            .add(BigDecimal.valueOf(value))
    )
}

data class Accounts (
    val accountMap: MutableMap<String, Account>
)

data class Client constructor(val name: String?)

data class TransactionBody(val saldo: Long?)