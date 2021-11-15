package `object`

//TODO: generate some test in the sheets if Double works fine. Maybe just have the presentation as an Int? accurate for returnDouble == returnDouble == 0 return
data class Inventory(val inventoryName: String, var resourceList: MutableMap<Resource, Double>, var silver: Int) {
    fun getResourceCount(resource: Resource): Double {
        return resourceList[resourceList.keys.find { obj -> resource == obj }]?:0.0
    }

    fun subResource(resource: Resource, num: Double) {
        val key = resourceList.keys.find { obj -> obj == resource }
        if (key != null) {
            resourceList[key] = resourceList[key]!!.minus(num)
        }

    }

    fun addResource(resource: Resource, num: Double) {
        val key = resourceList.keys.find { obj -> obj == resource }
        if (key != null) {
            resourceList[key] = resourceList[key]!! + num
        } else {
            resourceList.replace(resource, num)
        }
    }

    fun setResource(resource: Resource, num: Double) {
        resourceList.replace(resource, num)
    }



    // delete keys with 0 values
    fun cleanInventory() {
        TODO()
        // TODO: 2021-11-11
    }

    override fun equals(other: Any?): Boolean {
        return other is Inventory
                && other.inventoryName == this.inventoryName
                && other.resourceList == this.resourceList
    }
}