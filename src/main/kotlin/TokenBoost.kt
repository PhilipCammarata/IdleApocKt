import kotlinx.serialization.Serializable

@Serializable
class TokenBoost(
    var combatToken: Int = 0,
    var darkEnergyToken: Int = 0
) {
    val creatureDamageBoost: Float
        get() = combatToken.toFloat()
    val creatureDarkEnergyBoost: Float
        get() = darkEnergyToken.toFloat()
}
