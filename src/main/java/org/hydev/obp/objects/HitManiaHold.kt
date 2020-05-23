package org.hydev.obp.objects

import org.hydev.obp.Beatmap

/**
 * Hold keys for mania
 * x,y,time,type,hitSound,endTime,hitSample
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 21:23
 */
class HitManiaHold(beatmap: Beatmap) : HitMania(beatmap)
{
    // End time of the hold, in milliseconds from the beginning of the beatmap's audio.
    var endTime: Int = -1

    override fun param() = "$endTime:${super.param()}"
}
