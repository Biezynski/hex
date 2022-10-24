package hexagonal.architecture.application.ports.output

import hexagonal.architecture.domain.model.Product
import java.util.*

interface ProductOutputPort {

    fun saveProduct(product: Product): Product

    fun getProductById(id: Long): Optional<Product>
}