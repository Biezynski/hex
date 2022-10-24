package hexagonal.architecture.application.ports.output

import hexagonal.architecture.domain.event.ProductCreatedEvent

interface ProductEventPublisher {

    fun publishProductCreatedEvent(event: ProductCreatedEvent)
}