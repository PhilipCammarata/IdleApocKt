import kotlinx.serialization.Serializable

@Serializable
class ScrollBoost(
    var natureScroll: Boolean = false,
    var mightScroll: Boolean = false,
    var darkScroll: Boolean = false
) {
    val creatureDropBoost: Int
        get() = if (natureScroll) 1 else 0
    val creatureDamageBoost: Float
        get() = if (mightScroll) 1000f else 0f
    val creatureDarkEnergyBoost: Float
        get() = if (darkScroll) 1000f else 0f
}
