package domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ObjectTests {
    private val resourceName = "Bar T2"
    private val resourcePrice = 30000
    private val resourceValue = 15
    private val bar2 = Resource(resourceName, resourcePrice, resourceValue)
    private val bar2a = Resource(resourceName, resourcePrice+10, resourceValue)

    @Test
    fun resourceTest() {
        val resource2 = bar2a.copy()
        resource2.resourcePrice = resourcePrice

        assertFalse(bar2 == bar2a, "comparing different object with same name but different resourcePrice")
        assertTrue(bar2 == resource2, "comparing different object with same resource price")
        assertTrue(bar2.isSame(bar2a), "comparing different object with same name but different resourcePrice")
    }

    private val ore3 = Resource("Ore T3", resourcePrice, resourceValue)
    private val bar3 = Resource("Bar T3", resourcePrice, resourceValue)
    private val recipe0 = Recipe("recipe", mapOf<Resource, Int>(Pair(bar2, 1), Pair(ore3, 2)), mapOf<Resource, Int>(Pair(bar3, 1)))
    @Test
    fun recipeTest() {
        assertTrue(recipe0.output.size == 1)
        assertTrue(recipe0.output.keys.contains(bar3))
        assertTrue(recipe0.input.keys.size == 2)
        assertTrue(recipe0.input.keys.contains(bar2))
        assertTrue(recipe0.input.keys.contains(ore3))
    }
}