import kotlinx.serialization.Serializable

@Serializable
data class CreatureLevel(
        val level: Int,
        val drop: Int,
        val juice: Int = 0,
        val damage: Float,
        val darkEnergy: Float
)
