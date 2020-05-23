package org.hydev.obp

/**
 * Beatmap timings
 * https://github.com/ppy/osu-wiki/blob/master/wiki/osu!_File_Formats/Osu_(file_format)/en.md#timing-points
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 18:07
 */
class BeatmapTimingPoint(

    // Start time of the timing section, in milliseconds from the beginning of the beatmap's audio.
    // The end of the timing section is the next timing point's time (or never, if this is the last timing point).
    var time: Int,

    // This property has two meanings: For uninherited timing points, the duration of a beat, in milliseconds.
    // For inherited timing points, a negative inverse slider velocity multiplier, as a percentage.
    // For example, -50 would make all sliders in this timing section twice as fast as SliderMultiplier.
    var beatLength: Double,

    // Amount of beats in a measure. Inherited timing points ignore this property.
    var meter: Int,

    // Default sample set for hit objects (0 = beatmap default, 1 = normal, 2 = soft, 3 = drum).
    var sampleSet: Int,

    // Custom sample index for hit objects. 0 indicates osu!'s default hitsounds.
    var sampleIndex: Int,

    // Volume percentage for hit objects.
    var volume: Int,

    // Whether or not the timing point is uninherited.
    var uninherited: Boolean,

    // Bit flags that give the timing point extra effects. See [the effects section](#effects).
    var effects: BitFlags
)
{
    constructor(): this(-1, -1.0, -1, -1, -1, -1, false, BitFlags())

    /**
     * Parse from line
     */
    constructor(line: String): this()
    {
        // Line format: time,beatLength,meter,sampleSet,sampleIndex,volume,uninherited,effects
        val split = line.split(",")
        time = split[0].toInt()
        beatLength = split[1].toDouble()
        meter = split[2].toInt()
        sampleSet = split[3].toInt()
        sampleIndex = split[4].toInt()
        volume = split[5].toInt()
        uninherited = split[6].toBoolean()
        effects = BitFlags(split[7].toInt())
    }

    /**
     * To line format
     */
    override fun toString(): String
    {
        return "$time,$beatLength,$meter,$sampleSet,$sampleIndex,$volume,${uninherited.num()},$effects"
    }
}
