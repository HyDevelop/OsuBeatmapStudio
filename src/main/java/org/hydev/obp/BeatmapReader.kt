package org.hydev.obp

import java.io.BufferedReader
import java.io.File
import java.io.StringReader

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
    fun parse(file: File)
    {
        return parse(file.readText())
    }

    /**
     * Parse a string
     */
    fun parse(osu: String)
    {
        val beatmap = Beatmap()

        // What is it currently scanning
        var state: String = "version"

        // Cannot use Split because we're not sure if it's \n or \r\n
        BufferedReader(StringReader(osu)).lines().forEach { line ->

            // Switching Sections
            if (line.startsWith("["))
            {
                state = if (line == GENERAL || line == EDITOR || line == METADATA || line == DIFFICULTY) GENERAL
                else line
            }

            // Reading data
            when (state)
            {
                // Reading meta data about the map
                GENERAL ->
                {
                    // Line format: Property : Value
                    val split = line.split(":")
                    beatmap.properties.assign(split[0].trim(), split[1].trim())
                }

                // Reading events
                EVENTS -> { beatmap.events.add(BeatmapEvent(line)) }
            }
        }
    }
}
