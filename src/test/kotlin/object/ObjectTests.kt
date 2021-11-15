package `object`

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ObjectTests {
    @Test
    fun itemTest() {
        val resource = Resource("item0", 100)
        assert(resource == Resource("item0", 100))
    }
    @Test
    fun inventoryTest() {
        val inv1 = Inventory("inv1", mutableMapOf(
            Resource("item0", 100) to 160f
        ))
        val inv2 = Inventory("inv1", mutableMapOf(
            Resource("item0", 100) to 160f
        ))
        val mut1 = mutableMapOf(
            Resource("item0", 100) to 160)
        val mut2 = mutableMapOf(
            Resource("item0", 100) to 160)
        println(inv1)
        assert(mut1 == (mut2))
        assertEquals(inv1, inv2)
    }
}