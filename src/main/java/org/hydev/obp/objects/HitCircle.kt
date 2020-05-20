package org.hydev.obp.objects

import java.util.*

/**
 * Hit Object!
 * https://github.com/ppy/osu-wiki/blob/master/wiki/osu!_File_Formats/Osu_(file_format)/en.md#hit-objects
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 19:04
 */
open class HitCircle
{
    // Position in osu! pixels of the object.
    var x: Int = -1
    var y: Int = -1

    // Time when the object is to be hit, in milliseconds from the beginning of the beatmap's audio.
    var time: Int = -1

    // Bit flags indicating the type of the object.
    var type: BitSet = BitSet()

    // Bit flags indicating the hitsound applied to the object.
    var hitSound: BitSet = BitSet()

    // Information about which samples are played when the object is hit.
    // It is closely related to hitSound; see the hitsounds section.
    // If it is not written, it defaults to 0:0:0:0:.
    var hitSample: List<Int> = listOf(0, 0, 0, 0)

    // Hit sample file name
    var hitSampleFile: String = ""

    // Bitset methods
    fun isHitCircle() = type.get(0)
    fun isSlider() = type.get(1)
    fun isNewCombo() = type.get(2)
    fun isSpinner() = type.get(3)
    fun isManiaHold() = type.get(7)
}
