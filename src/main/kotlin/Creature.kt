import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Creature(
    val name: String,
    val race: String = "",
    val floor: String,
    @Json(name = "drop_type") val dropType: String,
    @Json(name = "juice_type") val juiceType: String?,
    @Json(name = "spawn_order") val spawnOrder: Int,
    @Json(name = "spawn_timer") val spawnTimer: Int,
    val health: Int,
    var level: Int = 1,
    val levels: List<CreatureLevel>,
    val skins: List<Skin>
) {
    val drop: Int
        get() = this.levels[this.level - 1].drop
    val juice: Int
        get() = this.levels[this.level - 1].juice
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
    @Json(name = "dark_energy") val darkEnergy: Float
)

@JsonClass(generateAdapter = true)
data class Skin(
    val name: String,
    val levels: List<SkinLevel>
)

@JsonClass(generateAdapter = true)
data class SkinLevel(
    val level: Int,
    @Json(name = "drop_bonus") val dropBonus: Int,
    @Json(name = "damage_bonus") val damageBonus: Int,
    @Json(name = "dark_energy_bonus") val darkEnergyBonus: Int
)

