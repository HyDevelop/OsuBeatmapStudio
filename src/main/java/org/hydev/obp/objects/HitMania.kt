package org.hydev.obp.objects

import org.hydev.obp.Beatmap
import java.util.*

/**
 * Mania key
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 20:50
 */
open class HitMania(beatmap: Beatmap) : HitCircle(beatmap)
{
    var column: Int
        get() = (beatmap.properties.circleSize / 512 * x).toInt()
        set(value) { x = ((value + 0.5) / (beatmap.properties.circleSize / 512)).toInt() }
}
