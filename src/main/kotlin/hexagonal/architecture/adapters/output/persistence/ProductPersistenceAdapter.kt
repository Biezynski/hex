package hexagonal.architecture.adapters.output.persistence

import hexagonal.architecture.adapters.output.persistence.mapper.ProductPersistenceMapper
import hexagonal.architecture.adapters.output.persistence.repository.ProductRepository
import hexagonal.architecture.application.ports.output.ProductOutputPort
import hexagonal.architecture.domain.model.Product
import java.util.*

class ProductPersistenceAdapter(
    private val productPersistenceMapper: ProductPersistenceMapper,
    private val productRepository: ProductRepository
) : ProductOutputPort {
    override fun saveProduct(product: Product): Product {
        val productEntity = productPersistenceMapper.toProductEntity(product)
        productRepository.save(productEntity)
        return productPersistenceMapper.toProduct(productEntity)
    }

    override fun getProductById(id: Long): Optional<Product> {
        val optionalProduct = productRepository.findById(id)
        if (optionalProduct.isEmpty) return Optional.empty()

        val productOptional = productPersistenceMapper.toProduct(optionalProduct.get())
        return Optional.of(productOptional)
    }
}