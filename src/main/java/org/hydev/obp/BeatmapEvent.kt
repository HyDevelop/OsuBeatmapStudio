package org.hydev.obp

import kotlinx.serialization.Serializable

/**
 * TODO: Write a description for this class!
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 17:47
 */
@Serializable
class BeatmapEvent(

    // Type of the event. Some events may be referred to by either a name or a number.
    var eventType: String = "",

    // Start time of the event, in milliseconds from the beginning of the beatmap's audio.
    // For events that do not use a start time, the default is 0.
    var startTime: Int = 0,

    // (Comma-separated list): Extra parameters specific to the event's type.
    var eventParams: String = ""
)
{
    /**
     * Getter for EventParams
     */
    val eventParamsList: List<String>
        get() = eventParams.split("");
}
