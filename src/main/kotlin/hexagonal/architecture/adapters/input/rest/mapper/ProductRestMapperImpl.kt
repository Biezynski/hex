package hexagonal.architecture.adapters.input.rest.mapper

import hexagonal.architecture.adapters.input.rest.data.request.ProductCreateRequest
import hexagonal.architecture.adapters.input.rest.data.response.ProductCreateResponse
import hexagonal.architecture.adapters.input.rest.data.response.ProductQueryResponse
import hexagonal.architecture.domain.model.Product
import org.springframework.stereotype.Component

@Component
class ProductRestMapperImpl : ProductRestMapper {
    override fun toProduct(productCreateRequest: ProductCreateRequest): Product {

        var name: String? = null
        var description: String? = null

        name = productCreateRequest.name
        description = productCreateRequest.description

        val id: Long? = null

        return Product(id, name, description)
    }

    override fun toProductCreateResponse(product: Product): ProductCreateResponse {

        var id = 0L
        var name: String? = null
        var description: String? = null

        if (product.id != null) {
            id = product.id
        }
        name = product.name
        description = product.description

        return ProductCreateResponse(id, name!!, description!!)
    }

    override fun toProductQueryResponse(product: Product): ProductQueryResponse {

        var id = 0L
        var name: String? = null
        var description: String? = null

        if (product.id != null) {
            id = product.id
        }
        name = product.name
        description = product.description

        return ProductQueryResponse(id, name!!, description!!)
    }
}