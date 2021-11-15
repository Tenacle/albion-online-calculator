package business

import `object`.Inventory
import `object`.Resource
import `object`.Recipe
import org.junit.jupiter.api.Test

internal class JobTest {
    private val t4Bar = Resource("T4 Bar", 100, 10)
    private val t3Bar = Resource("T3 Bar", 50, 5)
    private val items = mutableMapOf(
            t4Bar to 64.0,
            t3Bar to 160.0
        )

    private val bridgewatchMarket = Inventory("Bridgewatch",
        mutableMapOf(
            t4Bar to 64.0,
            t3Bar to 160.0
        ),
        1000
    )
    private val t4GuardianArmor = Recipe(
        mapOf(Resource("T4 Bar", 100, 10) to 16),
        mapOf(Resource("T4 Guardian Armor", 1200, 5) to 1)
    )

    @Test
    fun testProcess() {
        val expectedResult = Inventory("Bridgewatch",
            mutableMapOf(
                t4Bar to 0.0,
                t3Bar to 160.0
            ),
            1000
        )

        val blacksmith = Job("blacksmith", 0.248f, 0.09f, bridgewatchMarket)

        blacksmith.process(t4GuardianArmor)
        println(blacksmith)
        assert(blacksmith.inventory == expectedResult)
    }

    @Test
    // total items used (from resource return rate)
    fun getTotalResourceUsed() {
    }

}