import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.File

fun main() {
    val moshi: Moshi = Moshi.Builder().build()
    val adapter: JsonAdapter<List<Creature>> = moshi.adapter(Types.newParameterizedType(List::class.java, Creature::class.java))

    val creatureJson = File("src/main/resources/creatures.json").readText()
    val creatures: List<Creature> = adapter.fromJson(creatureJson) ?: return

    val gremlin = creatures.single { it.name == "Gremlin" }
    val adBonus = AdBonus(creatureDrop = true, creatureDamage = true, creatureDarkEnergy = true)
    val storeBoost = StoreBoost(doubleDarkness = true, bounty = true)
    gremlin.adBonus = adBonus
    gremlin.storeBoost = storeBoost

    gremlin.level = 4
    println(gremlin.juice)
}
