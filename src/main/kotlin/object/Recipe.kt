package `object`

data class Recipe(val input: Map<Resource, Int>, val output: Map<Resource, Int>) {
    fun getRecipeValue(): Int {
        var totalValue = 0
        for((key, value) in output) {
            totalValue += key.resourceValue * value
        }
        return totalValue
    }
}