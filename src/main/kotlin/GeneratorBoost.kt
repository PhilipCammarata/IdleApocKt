import kotlinx.serialization.Serializable

/*
    I make an assumption that the Spanner of Power has been fully upgraded here.
 */

@Serializable
class GeneratorBoost(
        val generatorI: Boolean = false,
        val generatorII: Boolean = false,
        val generatorII_2: Boolean = false,
        val generatorIV: Boolean = false,
        val generatorIV_2: Boolean = false,
        val superGenerator: Boolean = false
) {
    val creatureDamageBoost: Float
        get() {
            var boost = 0f
            boost += if (generatorIV) 300f else 0f
            boost += if (generatorIV_2) 300f else 0f
            return boost
        }
    val creatureDarkEnergyBoost: Float
        get() {
            var boost = 0f
            boost += if (generatorII) 300f else 0f
            boost += if (generatorII_2) 300f else 0f
            return boost
        }
}
