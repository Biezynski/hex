package hexagonal.architecture.domain.service

import hexagonal.architecture.application.ports.input.CreateProductUseCase
import hexagonal.architecture.application.ports.input.GetProductUseCase
import hexagonal.architecture.application.ports.output.ProductEventPublisher
import hexagonal.architecture.application.ports.output.ProductOutputPort
import hexagonal.architecture.domain.event.ProductCreatedEvent
import hexagonal.architecture.domain.exception.ProductNotFound
import hexagonal.architecture.domain.model.Product

class ProductService(
    private val productOutputPort: ProductOutputPort,
    private val productEventPublisher: ProductEventPublisher
) : CreateProductUseCase, GetProductUseCase {

    override fun createProduct(product: Product): Product {
        val savedProduct= productOutputPort.saveProduct(product)
        productEventPublisher.publishProductCreatedEvent(
            ProductCreatedEvent.Builder().setId(savedProduct.id!!).build()
        )
        return savedProduct
    }

    override fun getProductById(id: Long): Product {
        return productOutputPort.getProductById(id).orElseThrow { ProductNotFound("Product with id: $id not found") }
    }
}