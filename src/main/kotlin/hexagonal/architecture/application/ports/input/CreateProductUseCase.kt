package hexagonal.architecture.application.ports.input

import hexagonal.architecture.domain.model.Product

interface CreateProductUseCase {

    fun createProduct(product: Product): Product
}