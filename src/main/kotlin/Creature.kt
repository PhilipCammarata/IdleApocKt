import kotlinx.serialization.Serializable

@Serializable
class Creature(
        val name: String,
        val race: String,
        val floor: String,
        val dropType: String,
        val juiceType: String? = null,
        val spawnOrder: Int,
        val spawnTimer: Int,
        val health: Int,
        var level: Int = 1,
        val levels: List<CreatureLevel>,
        val skins: List<Skin>

) {
    var adBoost: AdBoost = AdBoost()
    var storeBoost: StoreBoost = StoreBoost()
    var chantBoost: ChantBoost = ChantBoost()
    val drop: Int
        get() = calculateCreatureDrop()
    val juiceDrop: Int
        get() = calculateCreatureJuiceDrop()
    val damage: Float
        get() = calculateCreatureDamage()
    val darkEnergy: Float
        get() = calcuateCreatureDarkEnergy()


    fun calculateCreatureDrop(): Int {
        val skinsCreatureDropBoost = skins.sumBy { it.creatureDropBoost }
        println("level $level drop: ${levels[level -1].drop}")
        println("chantDropBoost: ${chantBoost.creatureDropBoost}")
        println("skinsDropBoost: $skinsCreatureDropBoost")
        println("adBoost.creatureDropBoost: ${adBoost.creatureDropBoost}")
        println("storeBoost.bountyBoost: ${storeBoost.bountyBoost}")
        return levels[level - 1].drop + adBoost.creatureDropBoost + storeBoost.bountyBoost + skinsCreatureDropBoost + chantBoost.creatureDropBoost
    }

    fun calculateCreatureJuiceDrop(): Int {
        return levels[level - 1].juice + adBoost.creatureDropBoost
    }

    fun calculateCreatureDamage(): Float {
        return levels[level - 1].damage
    }

    fun calcuateCreatureDarkEnergy(): Float {
        return levels[level - 1].darkEnergy * storeBoost.doubleDarknessBoost
    }
}

@Serializable
data class CreatureLevel(
        val level: Int,
        val juice: Int,
        val drop: Int,
        val damage: Float,
        val darkEnergy: Float
)

