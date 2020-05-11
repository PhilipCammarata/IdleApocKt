import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Skin(
    val name: String,
    val levels: List<SkinLevel>
)


@JsonClass(generateAdapter = true)
data class SkinLevel(
    val dropBonus: Int,
    val damageBonus: Int,
    val darkEnergyBonus: Int
) {
    var level: Int = 0
}