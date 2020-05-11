import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Creature(
        val name: String,
        val race: String = "",
        val floor: String,
        val dropType: String,
        val juiceType: String?,
        val spawnOrder: Int,
        val spawnTimer: Int,
        val health: Int,
        var level: Int = 1,
        val levels: List<CreatureLevel>,
        val skins: List<Skin>
) {
    var adBonus: AdBonus = AdBonus()
    var storeBoost: StoreBoost = StoreBoost()
    val drop: Int
        get() = calculateDrop()
    val juice: Int
        get() = calculateJuice()
    val damage: Float
        get() = calculateDamage()
    val darkEnergy: Float
        get() = calcuateDarkEnergy()


    fun calculateDrop(): Int {
        return levels[level - 1].drop + adBonus.creatureDropBonus
    }

    fun calculateJuice(): Int {
        return levels[level - 1].juice + adBonus.creatureDropBonus + storeBoost.bountyBoost
    }

    fun calculateDamage(): Float {
        return levels[level - 1].damage
    }

    fun calcuateDarkEnergy(): Float {
        return levels[level - 1].darkEnergy * storeBoost.doubleDarknessBoost
    }
}


@JsonClass(generateAdapter = true)
data class CreatureLevel(
        val level: Int,
        val juice: Int,
        val drop: Int,
        val damage: Float,
        val darkEnergy: Float
)

