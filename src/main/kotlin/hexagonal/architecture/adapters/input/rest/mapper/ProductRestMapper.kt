package hexagonal.architecture.adapters.input.rest.mapper

import hexagonal.architecture.adapters.input.rest.data.request.ProductCreateRequest
import hexagonal.architecture.adapters.input.rest.data.response.ProductCreateResponse
import hexagonal.architecture.adapters.input.rest.data.response.ProductQueryResponse
import hexagonal.architecture.domain.model.Product

interface ProductRestMapper {

    fun toProduct(productCreateRequest: ProductCreateRequest): Product

    fun toProductCreateResponse(product: Product): ProductCreateResponse

    fun toProductQueryResponse(product: Product): ProductQueryResponse
}