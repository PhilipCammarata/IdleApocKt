import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.File

fun main() {
    val json = Json(JsonConfiguration.Stable.copy(prettyPrint = true))
    val creatureJson = File("src/main/resources/creatures.json").readText()
    val creatures = json.parse(Creature.serializer().list, creatureJson)


    val gremlin = creatures.single { it.name == "Gremlin" }
    val adBoost = AdBoost(creatureDrop = true, creatureDamage = true, creatureDarkEnergy = true)
    val storeBoost = StoreBoost(doubleDarkness = true, bounty = true)
    val chantBoost = ChantBoost(natureChantLevel = 4)

    gremlin.adBoost = adBoost
    gremlin.storeBoost = storeBoost
    gremlin.chantBoost = chantBoost

    gremlin.level = 4
    gremlin.skins[0].level = 3
    gremlin.skins[1].level = 4
    gremlin.skins[2].level = 5

    println("Level ${gremlin.level} ${gremlin.name} drops ${gremlin.drop} ${gremlin.dropType}")
}
