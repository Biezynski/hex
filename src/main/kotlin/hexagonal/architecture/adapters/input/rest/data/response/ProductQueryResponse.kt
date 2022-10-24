package hexagonal.architecture.adapters.input.rest.data.response

data class ProductQueryResponse(
    val id: Long,
    val name: String,
    val description: String
)