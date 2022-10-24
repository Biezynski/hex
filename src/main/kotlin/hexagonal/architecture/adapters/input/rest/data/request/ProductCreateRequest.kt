package hexagonal.architecture.adapters.input.rest.data.request

import javax.validation.constraints.NotEmpty

data class ProductCreateRequest (
    @NotEmpty(message = "Name may not be empty")
    val name: String,

    @NotEmpty(message = "Description may not be empty")
    val description: String
)