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
        get() = this.levels[this.level - 1].drop + this.adBonus.creatureDropBonus
    val juice: Int
        get() = this.levels[this.level - 1].juice + this.adBonus.creatureDropBonus + this.storeBoost.bountyBoost
    val damage: Float
        get() = this.levels[this.level - 1].damage
    val darkEnergy: Float
        get() = this.levels[this.level - 1].darkEnergy
}

@JsonClass(generateAdapter = true)
data class CreatureLevel(
    val level: Int,
    val juice: Int,
    val drop: Int,
    val damage: Float,
    val darkEnergy: Float
)

@JsonClass(generateAdapter = true)
data class Skin(
    val name: String,
    val levels: List<SkinLevel>
)

@JsonClass(generateAdapter = true)
data class SkinLevel(
    val level: Int,
    val dropBonus: Int,
    val damageBonus: Int,
    val darkEnergyBonus: Int
)
