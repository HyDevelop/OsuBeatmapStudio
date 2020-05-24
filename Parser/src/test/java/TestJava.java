import org.hydev.obp.Beatmap;
import org.hydev.obp.BeatmapReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * TODO: Write a description for this class!
 * <p>
 * Class created by the HyDEV Team on 2020-05-23!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-23 16:02
 */
public class TestJava
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Beatmap beatmap = BeatmapReader.parse(new File("samples/Various Artists - 4K 1st Dan (PortalLife) [1].osu"));

        PrintWriter out = new PrintWriter("outJava.osu");
        out.print(beatmap);
    }
}
