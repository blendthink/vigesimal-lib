@file:Suppress("EXPERIMENTAL_API_USAGE", "unused")

package dev.honwakalab.vigesimal.lib.shared

import platform.Foundation.NSDecimalNumber

actual class BigDecimal : Comparable<BigDecimal> {
    private val decimalNumber: NSDecimalNumber

    actual constructor(intVal: Int) {
        decimalNumber = NSDecimalNumber(intVal)
    }

    private constructor(nsDecimalNumber: NSDecimalNumber) {
        decimalNumber = nsDecimalNumber
    }

    actual fun add(augend: BigDecimal): BigDecimal {
        val tmp = decimalNumber.decimalNumberByAdding(augend.decimalNumber)
        return BigDecimal(tmp)
    }

    actual fun multiply(multiplicand: BigDecimal): BigDecimal {
        val tmp = decimalNumber.decimalNumberByMultiplyingBy(multiplicand.decimalNumber)
        return BigDecimal(tmp)
    }

    actual fun pow(n: Int): BigDecimal {
        val tmp = decimalNumber.decimalNumberByRaisingToPower(n.toULong())
        return BigDecimal(tmp)
    }

    actual fun toPlainString(): String = decimalNumber.stringValue

    override fun compareTo(other: BigDecimal): Int = this.compareTo(other)
}
