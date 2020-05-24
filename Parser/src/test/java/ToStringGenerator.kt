import org.hydev.obp.BeatmapProperties
import kotlin.reflect.full.createType
import kotlin.reflect.full.declaredMemberProperties

/**
 * TODO: Write a description for this class!
 * <p>
 * Class created by the HyDEV Team on 2020-05-23!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-23 15:09
 */
fun main(args: Array<String>)
{
    val target = BeatmapProperties::class
    val result = StringBuilder("\"\"\"\n");

    // All fields
    for (field in target.declaredMemberProperties)
    {
        val name = field.name
        val type = field.returnType
        val line = "${name.capitalize()}:$" +
            when (type)
            {
                Boolean::class.createType() -> "{$name.num()}"
                else -> name
            }

        // Assignment line
        result.append(line).append("\n")
    }

    // Ending text block
    result.append("\"\"\".trimIndent()")

    println(result);
}
