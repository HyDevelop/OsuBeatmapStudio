package org.hydev.obp

import org.hydev.obp.objects.HitCircle

/**
 * Beatmap
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 16:27
 */
class Beatmap
{
    var properties: BeatmapProperties = BeatmapProperties();
    var events: ArrayList<BeatmapEvent> = ArrayList();
    var colors: ArrayList<BeatmapColor> = ArrayList();
    var timings: ArrayList<BeatmapTimingPoint> = ArrayList();
    var objects: ArrayList<HitCircle> = ArrayList();
}
