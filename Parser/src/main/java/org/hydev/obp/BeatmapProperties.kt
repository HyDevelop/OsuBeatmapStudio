package org.hydev.obp

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
class BeatmapProperties
{
    // Location of the audio file relative to the current folder
    lateinit var audioFilename: String

    // Milliseconds of silence before the audio starts playing
    var audioLeadIn: Int = 0

    // *Deprecated*
    var audioHash: String? = null

    // Time in milliseconds when the audio preview should start
    var previewTime: Int = -1

    // Speed of the countdown before the first hit object
    // (0 = no countdown, 1 = normal, 2 = half, 3 = double)
    var countdown: Int = 0

    // Sample set that will be used if timing points do not override it (Normal, Soft, Drum)
    var sampleSet: String = "Normal"

    // Multiplier for the threshold in time where hit objects placed close together stack (0–1)
    var stackLeniency: Double = 0.7

    // Game mode (0 = osu!, 1 = osu!taiko, 2 = osu!catch, 3 = osu!mania)
    var mode: Int = 0

    // Whether or not breaks have a letterboxing effect
    var letterboxInBreaks: Boolean = false

    // *Deprecated*
    var storyFireInFront: Boolean? = null // Default: true

    // Whether or not the storyboard can use the user's skin images
    var useSkinSprites: Boolean? = null // Default: false

    // *Deprecated*
    var alwaysShowPlayfield: Boolean? = null // Default: false

    // Draw order of hit circle overlays compared to hit numbers
    // (NoChange = use skin setting, Below = draw overlays under numbers, Above = draw overlays on top of numbers)
    var overlayPosition: String? = null // Default: "NoChange"

    // Preferred skin to use during gameplay
    var skinPreference: String? = null // Default: " "

    // Whether or not a warning about flashing colours should be shown at the beginning of the map
    var epilepsyWarning: Boolean? = null // Default: false

    // Time in beats that the countdown starts before the first hit object
    var countdownOffset: Int? = null // Default: 0

    // Whether or not the "N+1" style key layout is used for osu!mania
    var specialStyle: Boolean? = null // Default: false

    // Whether or not the storyboard allows widescreen viewing
    var widescreenStoryboard: Boolean = false

    // Whether or not sound samples will change rate when playing with speed-changing mods
    var samplesMatchPlaybackRate: Boolean? = null // Default: false


    // Editor

    // Time in milliseconds of bookmarks
    var bookmarks: ArrayList<Int>? = null

    // Distance snap multiplier
    var distanceSpacing: Double? = null

    // Beat snap divisor
    var beatDivisor: Int? = null

    // Grid size
    var gridSize: Int? = null

    // Scale factor for the object timeline
    var timelineZoom: Double? = null


    // Metadata

    // Romanised song title
    var title: String = ""

    // Song title
    var titleUnicode: String = ""

    // Romanised song artist
    var artist: String = ""

    // Song artist
    var artistUnicode: String = ""

    // Beatmap creator
    var creator: String = ""

    // Difficulty name
    var version: String = ""

    // Original media the song was produced for
    var source: String = ""

    // Search terms
    var tags: ArrayList<String> = ArrayList()

    // Beatmap ID
    var beatmapID: Int = 0

    // Beatmapset ID
    var beatmapSetID: Int = -1


    // Difficulty

    // HP setting (0–10)
    var hpDrainRate: Double = 5.0

    // CS setting (0–10)
    var circleSize: Double = 5.0

    // OD setting (0–10)
    var overallDifficulty: Double = 5.0

    // AR setting (0–10)
    var approachRate: Double = 5.0

    // Base slider velocity in hecto-[osu! pixels](/wiki/Glossary#osupixel) per beat
    var sliderMultiplier: Double = 1.4

    // Amount of slider ticks per beat
    var sliderTickRate: Double = 1.0


    /**
     * Assign a value to a field
     */
    fun assign(field: String, v: String)
    {
        // Mostly generated by AssignerGenerator.kt
        when (field.toLowerCase())
        {
            "alwaysshowplayfield" -> alwaysShowPlayfield = v.toBoolean()
            "approachrate" -> approachRate = v.toDouble()
            "artist" -> artist = v
            "artistunicode" -> artistUnicode = v
            "audiofilename" -> audioFilename = v
            "audiohash" -> audioHash = v
            "audioleadin" -> audioLeadIn = v.toInt()
            "beatdivisor" -> beatDivisor = v.toInt()
            "beatmapid" -> beatmapID = v.toInt()
            "beatmapsetid" -> beatmapSetID = v.toInt()
            "bookmarks" -> bookmarks = ArrayList(v.split(",").map { it.toInt() })
            "circlesize" -> circleSize = v.toDouble()
            "countdown" -> countdown = v.toInt()
            "countdownoffset" -> countdownOffset = v.toInt()
            "creator" -> creator = v
            "distancespacing" -> distanceSpacing = v.toDouble()
            "epilepsywarning" -> epilepsyWarning = v.toBoolean()
            "gridsize" -> gridSize = v.toInt()
            "hpdrainrate" -> hpDrainRate = v.toDouble()
            "letterboxinbreaks" -> letterboxInBreaks = v.toBoolean()
            "mode" -> mode = v.toInt()
            "overalldifficulty" -> overallDifficulty = v.toDouble()
            "overlayposition" -> overlayPosition = v
            "previewtime" -> previewTime = v.toInt()
            "sampleset" -> sampleSet = v
            "samplesmatchplaybackrate" -> samplesMatchPlaybackRate = v.toBoolean()
            "skinpreference" -> skinPreference = v
            "slidermultiplier" -> sliderMultiplier = v.toDouble()
            "slidertickrate" -> sliderTickRate = v.toDouble()
            "source" -> source = v
            "specialstyle" -> specialStyle = v.toBoolean()
            "stackleniency" -> stackLeniency = v.toDouble()
            "storyfireinfront" -> storyFireInFront = v.toBoolean()
            "tags" -> tags = ArrayList(v.split(" "))
            "timelinezoom" -> timelineZoom = v.toDouble()
            "title" -> title = v
            "titleunicode" -> titleUnicode = v
            "useskinsprites" -> useSkinSprites = v.toBoolean()
            "version" -> version = v
            "widescreenstoryboard" -> widescreenStoryboard = v.toBoolean()
        }
    }

    override fun toString(): String
    {
        // Mostly generated by MdConverterToString.kt
        return StringBuilder().apply {
            line("[General]")
            line("AudioFilename:$audioFilename")
            line("AudioLeadIn:$audioLeadIn")
            if (audioHash != null) line("AudioHash:$audioHash")
            line("PreviewTime:$previewTime")
            line("Countdown:$countdown")
            line("SampleSet:$sampleSet")
            line("StackLeniency:$stackLeniency")
            line("Mode:$mode")
            line("LetterboxInBreaks:${letterboxInBreaks.num()}")
            if (storyFireInFront != null) line("StoryFireInFront:${storyFireInFront!!.num()}")
            if (useSkinSprites != null) line("UseSkinSprites:${useSkinSprites!!.num()}")
            if (alwaysShowPlayfield != null) line("AlwaysShowPlayfield:${alwaysShowPlayfield!!.num()}")
            if (overlayPosition != null) line("OverlayPosition:$overlayPosition")
            if (skinPreference != null) line("SkinPreference:$skinPreference")
            if (epilepsyWarning != null) line("EpilepsyWarning:${epilepsyWarning!!.num()}")
            if (countdownOffset != null) line("CountdownOffset:$countdownOffset")
            if (specialStyle != null) line("SpecialStyle:${specialStyle!!.num()}")
            line("WidescreenStoryboard:${widescreenStoryboard.num()}")
            if (samplesMatchPlaybackRate != null) line("SamplesMatchPlaybackRate:${samplesMatchPlaybackRate!!.num()}")

            line("[Editor]")
            if (bookmarks != null) line("Bookmarks:$bookmarks")
            if (distanceSpacing != null) line("DistanceSpacing:$distanceSpacing")
            if (beatDivisor != null) line("BeatDivisor:$beatDivisor")
            if (gridSize != null) line("GridSize:$gridSize")
            if (timelineZoom != null) line("TimelineZoom:$timelineZoom")

            line("[Metadata]")
            line("Title:$title")
            line("TitleUnicode:$titleUnicode")
            line("Artist:$artist")
            line("ArtistUnicode:$artistUnicode")
            line("Creator:$creator")
            line("Version:$version")
            line("Source:$source")
            line("Tags:$tags")
            line("BeatmapID:$beatmapID")
            line("BeatmapSetID:$beatmapSetID")

            line("[Difficulty]")
            line("HPDrainRate:$hpDrainRate")
            line("CircleSize:$circleSize")
            line("OverallDifficulty:$overallDifficulty")
            line("ApproachRate:$approachRate")
            line("SliderMultiplier:$sliderMultiplier")
            line("SliderTickRate:$sliderTickRate")
        }.toString()
    }
}
