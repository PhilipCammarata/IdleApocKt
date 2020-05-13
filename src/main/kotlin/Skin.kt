import kotlinx.serialization.Serializable

@Serializable
class Skin(
    val name: String,
    val quality: Quality
) {
    var level: Int = if (this.name == "Default") 1 else 0
    val creatureDropBoost: Int
        get() = calculateCreatureDrop()
    val creatureDamageBoost: Float
        get() = calculateCreatureDamageBoost()
    val creatureDarkEnergyBoost: Float
        get() = calculateCreatureDarkEnergyBoost()

    fun calculateCreatureDrop(): Int {
        return when (quality) {
            Quality.Default -> 0
            Quality.Rare -> 1
            Quality.Legendary -> if (level >= 3) 1 else 0
        }
    }

    fun calculateCreatureDamageBoost(): Float {
        return when (quality) {
            Quality.Default -> if (level >= 2) 100f else 0f
            Quality.Rare -> if (level >= 3) 150f else 0f
            Quality.Legendary -> if (level >= 4) 400f else 200f
        }
    }

    fun calculateCreatureDarkEnergyBoost(): Float {
        return when (quality) {
            Quality.Default -> if (level >= 3) 100f else 0f
            Quality.Rare -> when (level) {
                2,3 -> 150f
                4 -> 300f
                else -> 0f
            }
            Quality.Legendary -> when (level) {
                2,3,4 -> 200f
                5 -> 400f
                else -> 0f
            }
        }
    }
}


