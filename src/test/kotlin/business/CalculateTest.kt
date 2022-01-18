package business

import domain.Inventory
import domain.Processor
import domain.Resource
import domain.Recipe
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class CalculateTest {
    // persistence stub
    private val resourceList = mapOf<String, Resource>(
        "hide2" to Resource("hide t2", 100, 10),
        "leather2" to Resource("leather t2", 100, 10),
        "hide3" to Resource("hide t3", 100, 10),
        "leather3" to Resource("leather t3", 100, 10),
        "hide4" to Resource("hide t4", 100, 10),
        "leather4" to Resource("leather t4", 100, 10)
    )

    private val recipeList = mapOf<String, Recipe>(
        "leather3" to Recipe(
            "leather3",
            mapOf<Resource,Int>(
                resourceList["hide3"]!! to 2,
                resourceList["leather2"]!! to 1
            ),
            mapOf<Resource, Int>(
                resourceList["leather3"]!! to 1
            )
        )
    )

    private val processorList = mapOf<String, Processor>(
        "tanner" to Processor("Tanner",
            .367,
            470,
            recipeList.values.toList()
        )
    )

    private val inventoryList = mapOf<String, Inventory>(
        "tannerInventory" to Inventory("tannerInventory",
            mutableMapOf<Resource,Int>(
                resourceList["leather2"]!! to 100,
                resourceList["hide3"]!! to 100
            ),
            1000000
        )
    )

    val calculator = Calculate(inventoryList["tannerInventory"]!!, processorList["tanner"]!!)

    // get # of craftable
    @Test
    fun getNumCraftable() {
        val maxCraftable = calculator.getMaxCraftable(recipeList["leather3"]!!)
        assertTrue(maxCraftable == 50, "Found: $maxCraftable")
    }

    // get LPB
    @Test
    fun getLPB() {
        val valLPB = calculator.getLPB()
        assertTrue( kotlin.math.ceil(valLPB) == 58.0, "Found: $valLPB")
    }

    // get cost of recipe

    // craft max once

    // craft all

    // craft specific input

    // craft for specific output

}