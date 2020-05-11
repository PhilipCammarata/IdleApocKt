import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class AdBonus(
    var creatureDrop: Boolean = false,
    var creatureDamage: Boolean = false,
    var creatureDarkEnergy: Boolean = false
) {
    val creatureDropBonus: Int
        get() = if (this.creatureDrop) 1 else 0
    val creatureDamageBonus: Float
        get() = if (this.creatureDamage) 100.0f else 0f
    val creatureDarkEnergyBonus: Float
        get() = if (this.creatureDarkEnergy) 100.0f else 0f
}