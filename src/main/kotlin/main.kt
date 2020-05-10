import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.File

fun main() {
    val moshi: Moshi = Moshi.Builder().build()
    val adapter: JsonAdapter<List<Creature>> = moshi.adapter(Types.newParameterizedType(List::class.java, Creature::class.java))

    val creatureJson = File("src/main/resources/creatures.json").readText()
    val creatures: List<Creature> = adapter.fromJson(creatureJson) ?: return

    println(adapter.toJson(creatures))
}
