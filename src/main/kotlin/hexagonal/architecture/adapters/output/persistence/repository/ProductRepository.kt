package hexagonal.architecture.adapters.output.persistence.repository

import hexagonal.architecture.adapters.output.persistence.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<ProductEntity, Long>{
}