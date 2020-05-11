import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Creature(
    val name: String,
    val race: String = "",
    val floor: String,
    val drop: String,
    @Json(name = "spawn_order") val spawnOrder: Int,
    @Json(name = "spawn_timer") val spawnTimer: Int,
    val health: Int,
    val levels: List<Map<String, Int>>,
    val skins: List<Skin>
) {
    var darkEnergy: Float = 0.0f
        get() = 2f + field
    var level: Int = 1
}

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
