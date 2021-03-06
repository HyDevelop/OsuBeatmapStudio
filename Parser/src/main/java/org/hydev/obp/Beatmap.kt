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
     * Timings that contains bpm information
     */
    val bpmTimings: List<BeatmapTiming>
        get() = timings.filter { !it.isSpeedPoint }

    /**
     * Get the bpm timing at time
     */
    fun getBpmTiming(time: Int): BeatmapTiming
    {
        return try { bpmTimings.last { it.time < time } }
        catch (e: NoSuchElementException) { bpmTimings.first() }
    }

    /**
     * Convert time to beat
     * (Base Length) / time
     */
    fun toBeat(time: Int, divider: Int = 4): Beat
    {
        val len = getBpmTiming(time).beatLength / divider
        val beatNum = if (time != 0) (len / time).toInt() else 0
        return Beat(beatNum, (beatNum * len).toInt(), ((beatNum + 1) * len).toInt(), divider)
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

        return output.toString()
    }
}
