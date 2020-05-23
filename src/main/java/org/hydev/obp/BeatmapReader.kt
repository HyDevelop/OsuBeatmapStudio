package org.hydev.obp

import org.hydev.obp.objects.*
import java.awt.Point
import java.io.BufferedReader
import java.io.File
import java.io.StringReader
import java.util.*
import kotlin.collections.ArrayList

/**
 * Beatmap parser that parses .osu files to Beatmap objects.
 * <p>
 * Class created by the HyDEV Team on 2020-05-23!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-23 11:49
 */
object BeatmapReader
{
    const val GENERAL = "[general]"
    const val EDITOR = "[editor]"
    const val METADATA = "[metadata]"
    const val DIFFICULTY = "[difficulty]"
    const val EVENTS = "[events]"
    const val TIMINGS = "[timingpoints]"
    const val COLORS = "[colours]"
    const val HITS = "[hitobjects]"

    /**
     * Parse a file
     */
    fun parse(file: File): Beatmap
    {
        return parse(file.readText())
    }

    /**
     * Parse a string
     */
    fun parse(osu: String): Beatmap
    {
        val beatmap = Beatmap()

        // What is it currently scanning
        var state: String = "version"

        // Cannot use Split because we're not sure if it's \n or \r\n
        for (line in BufferedReader(StringReader(osu)).lines().iterator())
        {
            // Switching Sections
            if (line.startsWith("["))
            {
                state = if (line == GENERAL || line == EDITOR || line == METADATA || line == DIFFICULTY) GENERAL
                else line
                continue
            }

            // Empty lines or comments
            if (line.isBlank() || line.startsWith("//")) continue

            // Reading data
            when (state)
            {
                // Reading meta data about the map
                GENERAL ->
                {
                    // Line format: Property : Value
                    val split = line.split(":")
                    val name = split[0]
                    beatmap.properties.assign(name.trim(), line.substring(name.length + 1).trim())
                }

                // Reading other entries
                EVENTS -> { beatmap.events.add(BeatmapEvent(line)) }
                TIMINGS -> { beatmap.timings.add(BeatmapTimingPoint(line)) }
                COLORS -> { beatmap.colors.add(BeatmapColor(line)) }
                HITS -> { beatmap.objects.add(parseHitObject(beatmap, line)) }
            }
        }

        return beatmap
    }

    /**
     * Parse a hit object line
     */
    fun parseHitObject(beatmap: Beatmap, line: String): HitCircle
    {
        val split = line.split(",")

        // Universal properties
        val x = split[0].toInt()
        val y = split[1].toInt()
        val time = split[2].toInt()
        val type = BitSet(split[3].toInt())
        val hitSound = BitSet(split[4].toInt())
        val next = split.subList(5, split.size)

        // Hit to be parsed
        val hit: HitCircle
        val hitSample: List<String>

        // Mania hold (endTime:hitSample)
        if (type.get(7))
        {
            val params = next[0].split(":")
            hit = HitManiaHold(beatmap).apply { endTime = params[0].toInt() }
            hitSample = params.subList(1, params.size)
        }

        // Spinner (endTime,hitSample)
        else if (type.get(3))
        {
            hit = HitSpinner(beatmap).apply { endTime = next[0].toInt() }
            hitSample = next[1].split(":")
        }

        // Slider (curveType|curvePoints,slides,length,edgeSounds,edgeSets,hitSample)
        else if (type.get(1))
        {
            val curve = next[0].split("|")
            hit = HitSlider(beatmap).apply {
                curveType = curve[0]
                curvePoints = ArrayList(curve.from(1).map { it.split(":") }.map { Point(it[0].toInt(), it[1].toInt()) })
                slides = next[1].toInt()
                length = next[2].toDouble()
                edgeSounds = ArrayList(next[3].split("|").map { it.toInt() })
                edgeSets = ArrayList(next[4].split("|"))
            }
            hitSample = next[5].split(":")
        }

        // Hit Circle
        else
        {
            hit = when (beatmap.properties.mode)
            {
                1 -> HitTaiko(beatmap)
                3 -> HitMania(beatmap)
                else -> HitCircle(beatmap)
            }
            hitSample = next[0].split(":")
        }

        // Assign universal properties
        hit.apply {
            this.x = x
            this.y = y
            this.time = time
            this.type = type
            this.hitSound = hitSound
            this.hitSample = ArrayList(hitSample.subList(0, hitSample.size - 1).map { it.toInt() })
            this.hitSampleFile = if (hitSample.size > 4) hitSample.from(5).joinToString(",") else ""
        }

        return hit;
    }
}
