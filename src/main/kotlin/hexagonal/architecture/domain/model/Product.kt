package hexagonal.architecture.domain.model

data class Product(
    val id: Long?,
    val name: String?,
    val description: String?
) {
    data class Builder(
        var id: Long? = null,
        var name: String? = null,
        var description: String? = null
    ) {
        fun setId(id: Long) = apply { this.id = id }
        fun setName(name: String) = apply { this.name = name }
        fun setDescription(desciption: String) = apply { this.description = desciption }
        fun build() = Product(id, name, description)
    }
}