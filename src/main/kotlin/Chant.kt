import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Chant(
    var angerChantLevel: Int = 0,
    var darkChantLevel: Int = 0,
    var natureChantLevel: Int = 0
) {
    val damageBonus: Float
        get() = listOf(0f, 150f, 300f, 500f, 750f, 1000f, 1500f)[angerChantLevel]
    val darkEnergyBonus: Float
        get() = listOf(0f, 200f, 400f, 750f, 1000f, 1500f, 2000f)[darkChantLevel]
    val dropBonus: Int
        get() = listOf(0, 1, 2, 3)[natureChantLevel]
}
