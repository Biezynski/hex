package hexagonal.architecture.domain.event

import java.time.LocalDateTime

class ProductCreatedEvent private constructor(
    val id: Long?,
    val date: LocalDateTime
) {

    data class Builder(
        var id: Long? = null,
        var date: LocalDateTime = LocalDateTime.now()
    ) {
        fun setId(id: Long) = apply { this.id = id }
        fun build() = ProductCreatedEvent(id, date)
    }
}