@file:Suppress("EXPERIMENTAL_API_USAGE")

package dev.honwakalab.vigesimal.lib.shared

import platform.Foundation.NSDecimalNumber

actual class BigDecimal actual constructor(intVal: Int) : NSDecimalNumber(intVal),
    Comparable<BigDecimal> {

    actual fun add(augend: BigDecimal): BigDecimal =
        this.decimalNumberByAdding(augend) as BigDecimal

    actual fun multiply(multiplicand: BigDecimal): BigDecimal =
        this.decimalNumberByMultiplyingBy(multiplicand) as BigDecimal

    actual fun pow(n: Int): BigDecimal =
        this.decimalNumberByRaisingToPower(n.toULong()) as BigDecimal

    actual fun toPlainString(): String = this.stringValue

    override fun compareTo(other: BigDecimal): Int = this.compareTo(other)
}