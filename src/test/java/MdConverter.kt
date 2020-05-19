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
fun main(args: Array<String>)
{
    val test = object {}.javaClass.getResource("/MdConverter.txt").readText()
            .replace("([`\r])".toRegex(), "")
            .replace("(\\| | \\| | \\|)".toRegex(), "|").replace("||", "| |")
            .replace("Integer", "Int").replace("Decimal", "Double").replace("0 or 1", "Boolean")

    val output = StringBuilder()

    // Read by line
    for (line in test.split("\n").toTypedArray())
    {
        // Empty line
        if (line.isEmpty())
        {
            output.append("\n\n    // Next Section\n")
            continue
        }

        // Split
        val split = line.split("\\|").toTypedArray()
        val varName = ("" + split[1][0]).toLowerCase() + split[1].substring(1)
        val type = split[2]
        val description = split[3]
        var defaultValue = split.getOrElse(4) {""}

        // Specific default values
        if (type == "Boolean")
        {
            defaultValue = if (defaultValue == "0") "false" else if (defaultValue == "1") "true" else defaultValue
        }
        if (type == "String")
        {
            defaultValue = "\"" + defaultValue + "\""
        }
        if (!defaultValue.isEmpty())
        {
            defaultValue = " = $defaultValue"
        }

        // Add line
        output.append(String.format("\n    // %s \n    var %s: %s%s,\n", description, varName, type, defaultValue))
    }
    println(output)
}
