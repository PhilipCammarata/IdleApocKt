import kotlinx.serialization.Serializable

@Serializable
class ChantBoost(
    var angerChantLevel: Int = 0,
    var darkChantLevel: Int = 0,
    var natureChantLevel: Int = 0
) {
    val creatureDamageBoost: Float
        get() = listOf(0f, 150f, 300f, 500f, 750f, 1000f, 1500f)[angerChantLevel - 1]
    val creatureDarkEnergyBoost: Float
        get() = listOf(0f, 200f, 400f, 750f, 1000f, 1500f, 2000f)[darkChantLevel - 1]
    val creatureDropBoost: Int
        get() = listOf(0, 1, 2, 3)[natureChantLevel - 1]
}
