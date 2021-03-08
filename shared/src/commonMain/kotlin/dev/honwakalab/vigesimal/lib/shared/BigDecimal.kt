package dev.honwakalab.vigesimal.lib.shared

expect class BigDecimal(intVal: Int) : Comparable<BigDecimal> {

    fun add(augend: BigDecimal): BigDecimal
    fun multiply(multiplicand: BigDecimal): BigDecimal
    fun pow(n: Int): BigDecimal
    fun toPlainString(): String
}

operator fun BigDecimal.plus(augend: BigDecimal) = this.add(augend)
operator fun BigDecimal.times(multiplicand: BigDecimal) = this.multiply(multiplicand)
