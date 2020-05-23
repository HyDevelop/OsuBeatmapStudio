package org.hydev.obp

fun String.toBoolean(): Boolean
{
    return this == "1" || this.toLowerCase() == "true"
}

fun Boolean.num(): String = if (this) "1" else "0"
