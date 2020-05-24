package org.hydev.obp.objects

import org.hydev.obp.Beatmap
import java.awt.Point

/**
 * Slider
 * x,y,time,type,hitSound,curveType|curvePoints,slides,length,edgeSounds,edgeSets,hitSample
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 21:28
 */
class HitSlider(beatmap: Beatmap) : HitCircle(beatmap)
{
    // Type of curve used to construct this slider
    // (B = bezier, C = centripetal catmull-rom, L = linear, P = perfect circle)
    var curveType: String = ""

    // Points used to construct the slider. Each point is in the format x:y
    var curvePoints: ArrayList<Point> = ArrayList()

    // Amount of times the player has to follow the slider's curve back-and-forth before the slider is complete.
    // It can also be interpreted as the repeat count plus one.
    var slides: Int = -1;

    // Visual length in osu! pixels of the slider.
    var length: Double = -1.0;

    // Hitsounds that play when hitting edges of the slider's curve.
    // The first sound is the one that plays when the slider is first clicked,
    // and the last sound is the one that plays when the slider's end is hit.
    var edgeSounds: ArrayList<Int> = ArrayList()

    // Sample sets used for the edgeSounds.
    // Each set is in the format normalSet:additionSet,
    // with the same meaning as in the hitsounds section.
    var edgeSets: ArrayList<String> = ArrayList()

    /**
     * To param line
     */
    override fun param(): String
    {
        val curve = "$curveType|${curvePoints.map { "${it.x}:${it.y}" }.joinToString("|")}";
        return "$curve,$slides,$length,${edgeSounds.joinToString("|")},${edgeSets.joinToString("|")},${super.param()}"
    }
}
