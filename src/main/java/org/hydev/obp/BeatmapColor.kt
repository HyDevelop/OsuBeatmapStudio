package org.hydev.obp

import java.awt.Color

/**
 * Beatmap combo color setting
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 18:36
 */
class BeatmapColor(

    // Additive combo colours
    var combo: Int,

    // New color
    var color: Color
)
{
    /**
     * Parse from line
     */
    constructor(line: String)
    {
        // Line format: eventType,startTime,eventParams
        val split = line.split(":")
        combo = split[0].trim().replace("Combo", "").toInt()

        val rgb = split[1].trim().split(",").map { it.toInt() }
        color = Color(rgb[0], rgb[1], rgb[2])
    }
}
