package org.hydev.obp

/**
 * Beatmap Event
 * https://github.com/ppy/osu-wiki/blob/master/wiki/osu!_File_Formats/Osu_(file_format)/en.md#events
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 17:47
 */
class BeatmapEvent()
{
    // Type of the event. Some events may be referred to by either a name or a number.
    var eventType: String = ""

    // Start time of the event, in milliseconds from the beginning of the beatmap's audio.
    // For events that do not use a start time, the default is 0.
    var startTime: Int = 0

    // (Comma-separated list): Extra parameters specific to the event's type.
    var eventParams: ArrayList<String> = ArrayList()

    /**
     * Parse from line
     */
    constructor(line: String): this()
    {
        // Line format: eventType,startTime,eventParams
        val split = line.split(",")
        eventType = split[0]
        startTime = split[1].toInt()
        eventParams = ArrayList(split.from(2))
    }

    /**
     * To line format
     */
    override fun toString(): String
    {
        return "$eventType,$startTime,${eventParams.joinToString(",")}"
    }
}
