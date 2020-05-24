import org.hydev.obp.BeatmapProperties
import java.lang.StringBuilder
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberExtensionProperties
import kotlin.reflect.full.declaredMemberProperties

/**
 * TODO: Write a description for this class!
 * <p>
 * Class created by the HyDEV Team on 2020-05-23!
 *
 * @author HyDEV Team (https://github.com/HyDevelop)
 * @author Hykilpikonna (https://github.com/hykilpikonna)
 * @author Vanilla (https://github.com/VergeDX)
 * @since 2020-05-23 12:22
 */
fun main(args: Array<String>)
{
    val target = BeatmapProperties::class
    val result = StringBuilder("when (field.toLowerCase()) \n{\n");

    // All fields
    for (field in target.declaredMemberProperties)
    {
        val name = field.name
        val type = field.returnType.toString().split(".").last()

        // Assignment line
        result.append("""    "${name.toLowerCase()}" -> $name = value as $type""").append("\n")
    }

    // Ending bracket
    result.append("}")

    println(result);
}
