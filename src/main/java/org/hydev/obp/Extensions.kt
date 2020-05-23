package org.hydev.obp

fun String.toBoolean(): Boolean
{
    return this == "1" || this.toLowerCase() == "true"
}
