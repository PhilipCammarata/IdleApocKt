import kotlinx.serialization.Serializable

@Serializable
class TowerBoost(
        var sunkenTower: Boolean = false,
        var graveyardTower: Boolean = false,
        var loveShackTower: Boolean = false
) {
    val creatureJuiceDropBoost: Int
        get() = if (sunkenTower) 1 else 0
    val creatureDarkEnergyBoost: Float
        get() = if (graveyardTower) 100f else 0f
    val creatureDamageBoost: Float
        get() = if (loveShackTower) 100f else 0f
}
