package org.hydev.obp

import java.lang.Math.*
import kotlin.math.pow

/**
 * Utility for bitwise flags
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 18:17
 */
object BitFlagUtil
{
    /**
     * Check a bitwise flag is on or off
     */
    @JvmStatic
    fun contains(num: Int, flag: Int): Boolean
    {
        val power = 2.0.pow(flag).toInt();
        return num.and(power) == power;
    }
}
