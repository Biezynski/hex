package hexagonal.architecture.adapters.output.eventpublisher

import hexagonal.architecture.application.ports.output.ProductEventPublisher
import hexagonal.architecture.domain.event.ProductCreatedEvent
import org.springframework.context.ApplicationEventPublisher

class ProductEventPublisherAdapter
    (private val applicationEventPublisher: ApplicationEventPublisher) : ProductEventPublisher {

    override fun publishProductCreatedEvent(event: ProductCreatedEvent) {
        applicationEventPublisher.publishEvent(event)
    }
}