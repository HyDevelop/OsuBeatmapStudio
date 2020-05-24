package org.hydev.obp

fun String.toBoolean(): Boolean
{
    return this == "1" || this.toLowerCase() == "true"
}

fun Boolean.num(): String = if (this) "1" else "0"

fun List<String>.from(from: Int) = subList(from, size)

fun StringBuilder.line(a: Any = ""): StringBuilder = append(a).append("\n")
