package domain

/* contains info for processing resources using recipes. the crafter/refiner/etc.
 * recipes are processor specific.
 */

class Processor(val processorName: String, var processorRRR: Double, val processorFee: Int, val processorRecipes: List<Recipe>)