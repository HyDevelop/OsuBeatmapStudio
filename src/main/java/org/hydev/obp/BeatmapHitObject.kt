package org.hydev.obp

import java.util.*

/**
 * TODO: Write a description for this class!
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 19:04
 */
class BeatmapHitObject(

    // Position in osu! pixels of the object.
    var x: Int,
    var y: Int,

    // Time when the object is to be hit, in milliseconds from the beginning of the beatmap's audio.
    var time: Int,

    // Bit flags indicating the type of the object.
    var type: BitSet,

    // Bit flags indicating the hitsound applied to the object.
    var hitSound: BitSet,

    // Extra parameters specific to the object's type.
    var objectParams: List<Int>,

    // Information about which samples are played when the object is hit.
    // It is closely related to hitSound; see the hitsounds section.
    // If it is not written, it defaults to 0:0:0:0:.
    var hitSample: List<Int> = listOf(0, 0, 0, 0)
)
