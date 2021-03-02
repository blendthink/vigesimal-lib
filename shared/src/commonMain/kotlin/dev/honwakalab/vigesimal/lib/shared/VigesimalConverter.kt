@file:Suppress("unused")

package dev.honwakalab.vigesimal.lib.shared

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.decimal.toBigDecimal

/**
 * 20進法のマッピング
 */
private val MAPPING_VIGESIMAL: Map<String, BigDecimal> = mapOf(
    "0" to BigDecimal.fromInt(0),
    "1" to BigDecimal.fromInt(1),
    "2" to BigDecimal.fromInt(2),
    "3" to BigDecimal.fromInt(3),
    "4" to BigDecimal.fromInt(4),
    "5" to BigDecimal.fromInt(5),
    "6" to BigDecimal.fromInt(6),
    "7" to BigDecimal.fromInt(7),
    "8" to BigDecimal.fromInt(8),
    "9" to BigDecimal.fromInt(9),
    "a" to BigDecimal.fromInt(10),
    "b" to BigDecimal.fromInt(11),
    "c" to BigDecimal.fromInt(12),
    "d" to BigDecimal.fromInt(13),
    "e" to BigDecimal.fromInt(14),
    "f" to BigDecimal.fromInt(15),
    "g" to BigDecimal.fromInt(16),
    "h" to BigDecimal.fromInt(17),
    "i" to BigDecimal.fromInt(18),
    "j" to BigDecimal.fromInt(19),
)

object VigesimalConverter {
    fun toDecimal(vigesimal: String): BigDecimal {
        val length = vigesimal.length - 1
        return vigesimal.mapIndexed { index, c ->
            val bigDecimal = MAPPING_VIGESIMAL[c.toString()] ?: throw IllegalArgumentException("$c")
            val powOf86 = 20.toBigDecimal().pow(length - index)
            return@mapIndexed (bigDecimal * powOf86)
        }.sumOf { it }
    }

    fun toVigesimal() {

    }
}

private inline fun Iterable<BigDecimal>.sumOf(selector: (BigDecimal) -> BigDecimal): BigDecimal {
    var sum: BigDecimal = 0.toBigDecimal()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}
