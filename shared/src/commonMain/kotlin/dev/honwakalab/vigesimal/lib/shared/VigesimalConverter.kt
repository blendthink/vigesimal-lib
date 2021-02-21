package dev.honwakalab.vigesimal.lib.shared

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.decimal.toBigDecimal

/**
 * 20進法のマッピング
 */
private val MAPPING_VIGESIMAL: Map<String, Int> = mapOf(
    "0" to 0,
    "1" to 1,
    "2" to 2,
    "3" to 3,
    "4" to 4,
    "5" to 5,
    "6" to 6,
    "7" to 7,
    "8" to 8,
    "9" to 9,
    "a" to 10,
    "b" to 11,
    "c" to 12,
    "d" to 13,
    "e" to 14,
    "f" to 15,
    "g" to 16,
    "h" to 17,
    "i" to 18,
    "j" to 19,
)

object VigesimalConverter {
    fun toDecimal(vigesimal: String): BigDecimal {
        val length = vigesimal.length - 1
        return vigesimal.mapIndexed { index, c ->
            val decimal = MAPPING_VIGESIMAL[c.toString()] ?: throw IllegalArgumentException("$c")
            val bigDecimal = decimal.toBigDecimal()
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
