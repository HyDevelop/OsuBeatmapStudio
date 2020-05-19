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
 * @since 2020-05-19 16:28
 */
@Serializable
class BeatmapProperties(

    // Location of the audio file relative to the current folder
    var audioFilename: String = " ",

    // Milliseconds of silence before the audio starts playing
    var audioLeadIn: Int = 0,

    // *Deprecated*
    var audioHash: String = " ",

    // Time in milliseconds when the audio preview should start
    var previewTime: Int = -1,

    // Speed of the countdown before the first hit object
    // (0 = no countdown, 1 = normal, 2 = half, 3 = double)
    var countdown: Int = 1,

    // Sample set that will be used if timing points do not override it (Normal, Soft, Drum)
    var sampleSet: String = "Normal",

    // Multiplier for the threshold in time where hit objects placed close together stack (0–1)
    var stackLeniency: Double = 0.7,

    // Game mode (0 = osu!, 1 = osu!taiko, 2 = osu!catch, 3 = osu!mania)
    var mode: Int = 0,

    // Whether or not breaks have a letterboxing effect
    var letterboxInBreaks: Boolean = false,

    // *Deprecated*
    var storyFireInFront: Boolean = true,

    // Whether or not the storyboard can use the user's skin images
    var useSkinSprites: Boolean = false,

    // *Deprecated*
    var alwaysShowPlayfield: Boolean = false,

    // Draw order of hit circle overlays compared to hit numbers
    // (NoChange = use skin setting, Below = draw overlays under numbers, Above = draw overlays on top of numbers)
    var overlayPosition: String = "NoChange",

    // Preferred skin to use during gameplay
    var skinPreference: String = " ",

    // Whether or not a warning about flashing colours should be shown at the beginning of the map
    var epilepsyWarning: Boolean = false,

    // Time in beats that the countdown starts before the first hit object
    var countdownOffset: Int = 0,

    // Whether or not the "N+1" style key layout is used for osu!mania
    var specialStyle: Boolean = false,

    // Whether or not the storyboard allows widescreen viewing
    var widescreenStoryboard: Boolean = false,

    // Whether or not sound samples will change rate when playing with speed-changing mods
    var samplesMatchPlaybackRate: Boolean = false,


    // Editor

    // Time in milliseconds of bookmarks
    var bookmarks: String,

    // Distance snap multiplier
    var distanceSpacing: Double,

    // Beat snap divisor
    var beatDivisor: Double,

    // Grid size
    var gridSize: Int,

    // Scale factor for the object timeline
    var timelineZoom: Double,


    // Metadata

    // Romanised song title
    var title: String = "",

    // Song title
    var titleUnicode: String = "",

    // Romanised song artist
    var artist: String = "",

    // Song artist
    var artistUnicode: String = "",

    // Beatmap creator
    var creator: String = "",

    // Difficulty name
    var version: String = "",

    // Original media the song was produced for
    var source: String = "",

    // Search terms
    var tags: String,

    // Beatmap ID
    var beatmapID: Int,

    // Beatmapset ID
    var beatmapSetID: Int,


    // Difficulty

    // HP setting (0–10)
    var hPDrainRate: Double,

    // CS setting (0–10)
    var circleSize: Double,

    // OD setting (0–10)
    var overallDifficulty: Double,

    // AR setting (0–10)
    var approachRate: Double,

    // Base slider velocity in hecto-[osu! pixels](/wiki/Glossary#osupixel) per beat
    var sliderMultiplier: Double,

    // Amount of slider ticks per beat
    var sliderTickRate: Double
)
{
    val bookmarksList: List<Long>
        get() = bookmarks.split(",").map { it.toLong() }

    val tagsList: List<String>
        get() = tags.split(" ")
}
