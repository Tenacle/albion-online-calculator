package `object`

/* contains info for processing resources using recipes. the crafter/refiner/etc.
 * recipes are processor specific.
 */

class Processor(val processorName: String, val processorRRR: Float, val processorFee: Float, var processorRecipes: List<Recipe>) {
}