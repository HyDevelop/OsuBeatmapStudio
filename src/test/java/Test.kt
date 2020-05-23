import org.hydev.obp.BeatmapReader
import java.io.File

fun main(args: Array<String>)
{
    val beatmap = BeatmapReader.parse(File("samples/Various Artists - 4K 1st Dan (PortalLife) [1].osu"))
    File("samples/out.osu").writeText(beatmap.toString())
}
