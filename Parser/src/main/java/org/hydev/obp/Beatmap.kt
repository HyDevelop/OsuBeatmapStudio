package org.hydev.obp

import org.hydev.obp.objects.HitCircle

/**
 * Beatmap
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 16:27
 */
class Beatmap
{
    var properties: BeatmapProperties = BeatmapProperties()
    var events: ArrayList<BeatmapEvent> = ArrayList()
    var colors: ArrayList<BeatmapColor> = ArrayList()
    var timings: ArrayList<BeatmapTiming> = ArrayList()
    var objects: ArrayList<HitCircle> = ArrayList()

    /**
     * Get the timing point at time
     */
    fun getTiming(time: Int): BeatmapTiming
    {
        return try { timings.last { it.time < time } }
        catch (e: NoSuchElementException) { timings.first() }
    }

    /**
     * To beatmap string
     */
    override fun toString(): String
    {
        val output = StringBuilder("osu file format v14\n\n$properties")

        if (events.isNotEmpty())
        {
            output.line()
            output.line("[Events]")
            events.forEach { output.line(it) }
        }
        if (timings.isNotEmpty())
        {
            output.line()
            output.line("[TimingPoints]")
            timings.forEach { output.line(it) }
        }
        if (colors.isNotEmpty())
        {
            output.line()
            output.line("[Colours]")
            colors.forEach { output.line(it) }
        }
        if (objects.isNotEmpty())
        {
            output.line()
            output.line("[HitObjects]")
            objects.forEach { output.line(it) }
        }

        return output.toString();
    }
}
