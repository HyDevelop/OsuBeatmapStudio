package org.hydev.obp

import java.lang.StringBuilder
import java.util.*

fun String.toBoolean(): Boolean
{
    return this == "1" || this.toLowerCase() == "true"
}

fun Boolean.num(): String = if (this) "1" else "0"

fun List<String>.from(from: Int) = subList(from, size)

/**
 * BitSet to number
 */
fun BitSet.num(): Long
{
    var value = 0L
    for (i in 0 until length())
    {
        value += if (get(i)) 1L shl i else 0L
    }
    return value
}

fun StringBuilder.line(a: Any = ""): StringBuilder = append(a).append("\n")
