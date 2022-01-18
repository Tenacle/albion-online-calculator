package business

import domain.Inventory
import domain.Processor
import domain.Recipe
import domain.Resource

class Calculate(private val inventory: Inventory, private val processor: Processor) {
    private val nutritionFactor: Double = 0.1125

    fun getMaxCraftable(recipe: Recipe): Int {
        var minVal = -1
        for((i,j) in recipe.input) {
            val numResource: Int = inventory.resourceList[i] ?: return 0
            val curVal = numResource / j
            if(minVal == -1 || minVal > curVal) {
                minVal = curVal
            }
        }
        return minVal
    }

    fun getLPB(): Double {
        println(processor.processorRRR)
        return ((100*processor.processorRRR) / (1-processor.processorRRR))
    }

    fun craft(recipeName: String, count: Int): Int {
        val recipeUsed: Recipe = processor.processorRecipes.firstOrNull {it.recipeName == recipeName} ?: return -1
        // if count is -1 then we craft all.
        if(count == -1) {
            val maxOutput = getMaxCraftable(recipeUsed)
            for((i,j) in recipeUsed.output) {
                inventory.addResource(i, j*maxOutput*getLPB().toInt())
            }
        }
        return 0
    }

}