package org.jesperancinha.fintech.model

import java.math.BigDecimal
import java.util.*
import javax.json.bind.annotation.JsonbCreator

data class Account(
    val accountNumber: String?,
    val   client: Client?,
    val   currentValue: BigDecimal?,
    val  creditValue: BigDecimal?
) {
    @Builder
    constructor(accountNumber: String?, client: Client?) : this(accountNumber, client, BigDecimal.ZERO, BigDecimal.ZERO)

    fun addCurrentValue(value: Long?): Account? {
        return Account(
            accountNumber, client, Objects.requireNonNullElse(currentValue, BigDecimal.ZERO)
                .add(BigDecimal.valueOf(value)), creditValue
        )
    }

    fun addCreditValue(value: Long?): Account? {
        return Account(
            accountNumber, client, currentValue, Objects.requireNonNullElse(creditValue, BigDecimal.ZERO)
                .add(BigDecimal.valueOf(value))
        )
    }

    init {
        this.name = name
        this.accountNumber = accountNumber
        this.client = client
        this.currentValue = currentValue
        this.creditValue = creditValue
    }
}

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Accounts {
    private val accountMap: MutableMap<String?, Account?>? = null
}

@JvmRecord
data class Client @Builder constructor(@field:Getter val name: String?)

@JvmRecord
data class TransactionBody @JsonbCreator constructor(val saldo: Long?)