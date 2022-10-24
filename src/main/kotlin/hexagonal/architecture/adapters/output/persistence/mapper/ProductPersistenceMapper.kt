package hexagonal.architecture.adapters.output.persistence.mapper

import hexagonal.architecture.adapters.output.persistence.entity.ProductEntity
import hexagonal.architecture.domain.model.Product

interface ProductPersistenceMapper {

    fun toProductEntity(product: Product): ProductEntity

    fun toProduct(productEntity: ProductEntity): Product
}