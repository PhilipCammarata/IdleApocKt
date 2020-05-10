import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Creature(
    val name: String,
    val race: String,
    val floor: String,
    val drop: String,
    @Json(name = "spawn_order") val spawnOrder: Int,
    @Json(name = "spawn_timer") val spawnTimer: Int,
    val health: Int,
    val levels: List<Map<String, Int>>,
    val skins: List<Skin>
)

@JsonClass(generateAdapter = true)
data class Skin(
    val name: String,
    val levels: List<Map<String, Int>>
)
