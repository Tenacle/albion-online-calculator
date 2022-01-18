package domain

data class Recipe(val recipeName: String, val input: Map<Resource, Int>, val output: Map<Resource, Int>)