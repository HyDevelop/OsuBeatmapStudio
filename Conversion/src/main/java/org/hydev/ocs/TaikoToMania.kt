package org.hydev.ocs

import org.hydev.obp.Beatmap
import org.hydev.obp.BeatmapReader
import org.hydev.obp.objects.HitMania
import org.hydev.obp.objects.HitManiaHold
import org.hydev.obp.objects.HitSpinner
import org.hydev.obp.objects.HitTaiko
import java.io.File

/**
 * Taiko to Mania conversion v1.0
 * <p>
 * Class created by the HyDEV Team on 2020-05-23!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-23 16:58
 */
fun main(args: Array<String>)
{
    val names = listOf("1018134 siromaru + cranky - conflict")

    for (name in names)
    {
        val inputDir = File("D:\\Games\\osu!\\Songs\\$name")
        val outputDir = File("D:\\Games\\osu!test\\Songs\\$name")
        convertSet(inputDir, outputDir)
    }
}

/**
 * Convert an entire set
 */
fun convertSet(inputDir: File, outputDir: File)
{
    for (file in inputDir.listFiles()!!)
    {
        val out = File(outputDir, file.name.substringBefore("].osu") + " 4K].osu")
        if (file.name.endsWith("osu"))
        {
            val mania = TaikoToMania.convert(BeatmapReader.parse(file))
            out.delete()
            out.writeText(mania.toString())
        }

        try
        {
            file.copyTo(File(outputDir, file.name), true)
        }
        catch (e: Exception) {}
    }
}

object TaikoToMania
{
    /**
     * Convert from taiko to mania
     * (Version v1)
     */
    fun convert(taiko: Beatmap): Beatmap
    {
        if (taiko.properties.mode != 1) return Beatmap()

        // Create map
        val mania = Beatmap().apply {
            properties = taiko.properties
            events = taiko.events
            colors = taiko.colors
            timings = taiko.timings
            properties.apply {
                mode = 3
                version += " 4K"
                circleSize = 4.0
                distanceSpacing = 0.8
                beatDivisor = 8
                gridSize = 32
                timelineZoom = 3.0
                beatmapID = 0
                beatmapSetID = -1
                creator += " & Hykilpikonna"
                tags.add("ConversionStudio")
            }
        }

        // Convert HitObjects
        var lastRed = true
        var lastBlue = true

        fun add(hit: HitTaiko)
        {
            mania.objects.add(if (hit.red)
            {
                lastRed = !lastRed

                if (lastRed) key(hit, 1)
                else key(hit, 2)
            }
            else
            {
                lastBlue = !lastBlue

                if (lastBlue) key(hit, 0)
                else key(hit, 3)
            })
        }

        fun addHold(hit: HitSpinner)
        {
            val col = (0..4).random()
            mania.objects.add(HitManiaHold(mania).apply { copyFrom(hit); column = col; endTime = hit.endTime; y = 192; type.num = 128 })
        }

        for (raw in taiko.objects)
        {
            if (raw is HitTaiko)
            {
                add(raw)
                if (raw.big) add(raw)
            }
            if (raw is HitSpinner)
            {
                addHold(raw)
            }
        }

        return mania
    }

    fun key(taiko: HitTaiko, col: Int): HitMania
    {
        return HitMania(taiko.beatmap).apply {
            copyFrom(taiko)
            column = col
            y = 192
        }
    }
}
