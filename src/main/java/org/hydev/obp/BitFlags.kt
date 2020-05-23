package org.hydev.obp

/**
 * Bit flags
 * <p>
 * Class created by the HyDEV Team on 2020-05-23!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-23 18:03
 */
class BitFlags(var num: Int = 0)
{
    fun get(flag: Int): Boolean
    {
        val bit = 1 shl flag
        return num and bit == bit
    }

    fun set(flag: Int, on: Boolean)
    {
        val bit = 1 shl flag
        num = if (on) num or bit
        else num and bit.inv()
    }
}
