import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.File

fun main() {
    val json = Json(JsonConfiguration.Stable.copy(prettyPrint = true))
    val creatureJson = File("src/main/resources/creatures.json").readText()
    val creatures = json.parse(Creature.serializer().list, creatureJson)

    val adBoost = AdBoost(creatureDrop = true, creatureDamage = true, creatureDarkEnergy = true)
    val storeBoost = StoreBoost(doubleDarkness = true, bounty = true)
    val chantBoost = ChantBoost(natureChantLevel = 4, angerChantLevel = 7, darkChantLevel = 7)
    val scrollBoost = ScrollBoost(natureScroll = true, mightScroll = true, darkScroll = true)
    val towerBoost = TowerBoost(sunkenTower = true, graveyardTower = true, loveShackTower = true)
    val tokenBoost = TokenBoost(combatToken = 1425, darkEnergyToken = 1608)

    val gremlin = creatures.single { it.name == "Gremlin" }
    gremlin.level = 4 // 4
    gremlin.adBoost = adBoost // 1
    gremlin.storeBoost = storeBoost // 1
    gremlin.chantBoost = chantBoost // 3
    gremlin.scrollBoost = scrollBoost // 1
    gremlin.towerBoost = towerBoost
    gremlin.tokenBoost = tokenBoost

    gremlin.skins[0].level = 3 // 0
    gremlin.skins[1].level = 4 // 1
    gremlin.skins[2].level = 5 // 1

    println("Level ${gremlin.level} ${gremlin.name} drops ${gremlin.drop} ${gremlin.dropName} and ${gremlin.juice} ${gremlin.juiceName}")
    println("Level ${gremlin.level} ${gremlin.name} drops ${gremlin.darkEnergy} darkEnergy")
}
