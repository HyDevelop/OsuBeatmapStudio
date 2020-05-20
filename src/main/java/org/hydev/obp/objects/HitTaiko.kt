package org.hydev.obp.objects

import org.hydev.obp.Beatmap

/**
 * Taiko key
 * <p>
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 21:34
 */
class HitTaiko(beatmap: Beatmap) : HitCircle(beatmap)
{
    var red: Boolean
        get() = !(hitSound.get(1) or hitSound.get(3))
        set(value) { hitSound.set(1, value) }
}
