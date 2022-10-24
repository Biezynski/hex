package hexagonal.architecture.application.ports.input

import hexagonal.architecture.domain.model.Product

interface GetProductUseCase {

    fun getProductById(id: Long): Product
}