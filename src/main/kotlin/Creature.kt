import kotlinx.serialization.Serializable

@Serializable
class Creature(
        val name: String,
        val race: String,
        val floor: String,
        val dropName: String,
        val juiceName: String? = null,
        val spawnTimer: Int,
        var level: Int = 1,
        val levels: List<CreatureLevel>,
        val skins: List<Skin>
) {
    var adBoost: AdBoost = AdBoost()
    var storeBoost: StoreBoost = StoreBoost()
    var chantBoost: ChantBoost = ChantBoost()
    var scrollBoost: ScrollBoost = ScrollBoost()
    var towerBoost: TowerBoost = TowerBoost()
    var tokenBoost: TokenBoost = TokenBoost()
    val drop: Int
        get() = calculateCreatureDrop()

    val juice: Int
        get() = calculateCreatureJuiceDrop()
    val damage: Float
        get() = calculateCreatureDamage()
    val darkEnergy: Float
        get() = calculateCreatureDarkEnergy()


    private fun calculateCreatureDrop(): Int {
        return listOf(
            levels[level - 1].drop,
            skins.sumBy { it.creatureDropBoost },
            chantBoost.creatureDropBoost,
            scrollBoost.creatureDropBoost,
            storeBoost.creatureDropBoost,
            adBoost.creatureDropBoost
        ).sum()
    }

    private fun calculateCreatureJuiceDrop(): Int {
        val baseJuice = levels[level - 1].juice
        return if (baseJuice == 0) {
            0
        } else {
            baseJuice + adBoost.creatureJuiceDropBoost + towerBoost.creatureJuiceDropBoost
        }
    }

    private fun calculateCreatureDamage(): Float {
        return levels[level - 1].damage
    }

    private fun calculateCreatureDarkEnergy(): Float {
        val baseDarkEnergy = levels[level - 1].darkEnergy
        val darkEnergyBoost = (tokenBoost.creatureDarkEnergyBoost / 100)
        return baseDarkEnergy + (baseDarkEnergy * darkEnergyBoost)
    }
}
