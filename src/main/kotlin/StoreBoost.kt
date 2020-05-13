import kotlinx.serialization.Serializable

@Serializable
class StoreBoost(
    var doubleDarkness: Boolean = false,
    var bounty: Boolean = false
) {
    val doubleDarknessBoost: Int
        get() = if (doubleDarkness) 2 else 0
    val bountyBoost: Int
        get() = if (bounty) 1 else 0
}
