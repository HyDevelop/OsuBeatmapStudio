package org.hydev.obp

import java.awt.Point

/**
 * Object params (also the params for hit circles)
 */
open class ObjectParams(var raw: String)
{
    var split = raw.split(",")
}

/**
 * Params for Sliders
 * (curveType|curvePoints,slides,length,edgeSounds,edgeSets)
 */
class SliderParams(raw: String) : ObjectParams(raw)
{
    // Type of curve used to construct this slider
    // (B = bezier, C = centripetal catmull-rom, L = linear, P = perfect circle)
    var curveType: String

    // Points used to construct the slider. Each point is in the format x:y
    var curvePoints: List<Point>

    // Amount of times the player has to follow the slider's curve back-and-forth before the slider is complete.
    // It can also be interpreted as the repeat count plus one.
    var slides: Int = split[1].toInt();

    // Visual length in osu! pixels of the slider.
    var length: Double = split[2].toDouble();

    // Hitsounds that play when hitting edges of the slider's curve.
    // The first sound is the one that plays when the slider is first clicked,
    // and the last sound is the one that plays when the slider's end is hit.
    var edgeSounds: List<Int> = split[3].split("|").map { it.toInt() }

    // Sample sets used for the edgeSounds.
    // Each set is in the format normalSet:additionSet,
    // with the same meaning as in the hitsounds section.
    var edgeSets: List<String> = split[4].split("|")

    init
    {
        // Curve
        val curveSplit = split[0].split("|");
        curveType = curveSplit[0];
        curvePoints = curveSplit.subList(0, curveSplit.size)
            .map { it.split(":") }.map { Point(it[0].toInt(), it[1].toInt()) }


    }
}

/**
 * Params for Spinners
 * (endTime)
 */
class SpinnerParams(raw: String) : ObjectParams(raw)
{
    // End time of the spinner, in milliseconds from the beginning of the beatmap's audio.
    var endTime: Int = split[0].toInt();
}

/**
 * Params for Holds (mania only)
 * (endTime)
 */
class ManiaHoldParams(raw: String) : ObjectParams(raw)
{
    // End time of the hold, in milliseconds from the beginning of the beatmap's audio.
    var endTime: Int = split[0].toInt();
}
