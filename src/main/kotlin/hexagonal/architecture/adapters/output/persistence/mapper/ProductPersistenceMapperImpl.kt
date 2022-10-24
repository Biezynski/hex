package hexagonal.architecture.adapters.output.persistence.mapper

import hexagonal.architecture.adapters.output.persistence.entity.ProductEntity
import hexagonal.architecture.domain.model.Product
import org.springframework.stereotype.Component

@Component
class ProductPersistenceMapperImpl: ProductPersistenceMapper {
    override fun toProductEntity(product: Product): ProductEntity {

        var id = 0L
        var name: String? = null
        var description: String? = null

        if (product.id != null) {
            id = product.id
        }
        name = product.name
        description = product.description

        return ProductEntity(id, name!!, description!!)
    }

    override fun toProduct(productEntity: ProductEntity): Product {
        var id = 0L
        var name: String? = null
        var description: String? = null

        if (productEntity.id != null) {
            id = productEntity.id
        }
        name = productEntity.name
        description = productEntity.description

        return Product(id, name!!, description!!)
    }
}