package domain

data class Resource(val resourceName: String, var resourcePrice: Int, val resourceValue: Int) {

    override fun equals(other: Any?): Boolean {
        return (other is Resource)
                && other.resourceName == this.resourceName
                && other.resourcePrice == this.resourcePrice
                && other.resourceValue == this.resourceValue
    }

    fun isSame(other: Resource): Boolean {
        return (other.resourceName == this.resourceName)
    }
}