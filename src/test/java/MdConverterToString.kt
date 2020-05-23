import java.util.*
import kotlin.reflect.full.createType

/**
 * This script coverts the osu file format readme into kotlin variables.
 * https://osu.ppy.sh/help/wiki/osu!_File_Formats/Osu_(file_format)
 *
 * Class created by the HyDEV Team on 2020-05-19!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-19 17:28
 */
fun main()
{
    val test = object {}.javaClass.getResource("/MdBeatmapProperties.txt").readText()
            .replace("([`\r])".toRegex(), "")
            .replace("(\\| | \\| | \\|)".toRegex(), "|").replace("||", "| |")
            .replace("Integer", "Int").replace("Decimal", "Double").replace("0 or 1", "Boolean")

    val output = StringBuilder("\"\"\"\n");

    // Read by line
    for (line in test.split("\n").toTypedArray())
    {
        // Empty line
        if (line.isEmpty())
        {
            output.append("\n// Next Section\n")
            continue
        }

        // Split
        val split = line.split("|")
        val name = split[1]
        val type = split[2]

        val line = "${name.capitalize()}:$" +
            when (type)
            {
                "Boolean" -> "{${name.decapitalize()}.num()}"
                else -> name.decapitalize()
            }

        output.append(line).append("\n")
    }

    println("$output\"\"\".trimIndent()")
}
