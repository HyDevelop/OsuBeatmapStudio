package org.hydev.obp

/**
 * Object params (also the params for hit circles)
 */
open class ObjectParams(var raw: String)
{
    var split = raw.split(",")
}
