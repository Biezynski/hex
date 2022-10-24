package hexagonal.architecture.adapters.config

import hexagonal.architecture.adapters.output.eventpublisher.ProductEventPublisherAdapter
import hexagonal.architecture.adapters.output.persistence.ProductPersistenceAdapter
import hexagonal.architecture.adapters.output.persistence.mapper.ProductPersistenceMapper
import hexagonal.architecture.adapters.output.persistence.repository.ProductRepository
import hexagonal.architecture.domain.service.ProductService
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {
    @Bean
    fun productPersistenceAdapter(
        productRepository: ProductRepository?,
        productPersistenceMapper: ProductPersistenceMapper?
    ): ProductPersistenceAdapter {
        return ProductPersistenceAdapter(productPersistenceMapper!!, productRepository!!)
    }

    @Bean
    fun productEventPublisherAdapter(applicationEventPublisher: ApplicationEventPublisher?): ProductEventPublisherAdapter {
        return ProductEventPublisherAdapter(applicationEventPublisher!!)
    }

    @Bean
    fun productService(
        productPersistenceAdapter: ProductPersistenceAdapter?,
        productEventPublisherAdapter: ProductEventPublisherAdapter?
    ): ProductService {
        return ProductService(productPersistenceAdapter!!, productEventPublisherAdapter!!)
    }
}