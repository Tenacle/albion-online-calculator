package `object`

data class Resource(val resourceName: String, val resourcePrice: Int, val resourceValue: Int) {
    override fun equals(other: Any?): Boolean {
        return (other is Resource)
                && other.resourceName == this.resourceName
                && (other.resourcePrice == -1 || this.resourcePrice == -1 || other.resourcePrice == this.resourcePrice)
    }
}