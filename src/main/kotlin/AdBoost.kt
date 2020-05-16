import kotlinx.serialization.Serializable

@Serializable
class AdBoost(
    var creatureDrop: Boolean = false,
    var creatureDamage: Boolean = false,
    var creatureDarkEnergy: Boolean = false
) {
    val creatureDropBoost: Int
        get() = if (creatureDrop) 1 else 0
    val creatureJuiceDropBoost: Int
        get() = if (creatureDrop) 1 else 0
    val creatureDamageBoost: Float
        get() = if (creatureDamage) 100f else 0f
    val creatureDarkEnergyBoost: Float
        get() = if (creatureDarkEnergy) 100f else 0f
}
