package hexagonal.architecture.adapters.input.eventlistener

import hexagonal.architecture.domain.event.ProductCreatedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class ProductEventListenerAdapter {
    @EventListener
    fun handle(event: ProductCreatedEvent) {
        println("Product created with id " + event.id + " at " + event.date)
    }
}