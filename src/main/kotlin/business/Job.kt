package business

import `object`.Inventory
import `object`.Processor
import `object`.Recipe
import java.lang.Double.MAX_VALUE
import java.lang.Double.min

class Job(val processorName: String, val processor: Processor, var inventory: Inventory) {

    // returns the number of resources made
    fun processOnce(recipe: Recipe): Int {
        var maxOutputPossible = MAX_VALUE
        var costs = 0

        // check to see the max possible output we can do (gets floor for accuracy)
        for(item in recipe.input.iterator()) {
            //TODO: make use of Float for determining proper RRR. Right now it is using the minimum possible return .
            maxOutputPossible = (min(inventory.getResourceCount(item.key).div(item.value), maxOutputPossible)).toInt().toDouble()    // let's take the floor for minimum possibility
        }

        if(maxOutputPossible == 0.0) { return 0 }

        // remove used resources in the list
        for(item in recipe.input.iterator()) {
            val resourceSpent = (maxOutputPossible * item.value)                // resource that will be spent on the process
            val resourceReturned = resourceSpent * processor.processorRRR                // resource that will be returned during the process
            val actualResourceSpent = resourceSpent - resourceReturned          // actual # of resource spent
            /* Prevents infinite resource pool
             * - if RRR results in the same number as the inventory count then set result to 0. (e.g. 0.36==0.36)
             * this is to be consistent with the behaviour found in the game
             */
            if(actualResourceSpent == inventory.getResourceCount(item.key)) {
                inventory.setResource(item.key, 0.0)
            } else {
                inventory.subResource(item.key, actualResourceSpent)
            }
        }

        // add new resource to the list
        for(item in recipe.output.iterator()) {
            inventory.addResource(item.key, maxOutputPossible)
        }
        return maxOutputPossible.toInt()
    }

    // returns the number of resources made
    fun process(recipe: Recipe): Int {
        var maxOutput = 0
        while(true) {
            val output = processOnce(recipe)
            if(output == 0) { break }
            maxOutput += output
        }
        return maxOutput
    }
}