package hexagonal.architecture.adapters.input.rest

import hexagonal.architecture.adapters.input.rest.data.request.ProductCreateRequest
import hexagonal.architecture.adapters.input.rest.data.response.ProductCreateResponse
import hexagonal.architecture.adapters.input.rest.data.response.ProductQueryResponse
import hexagonal.architecture.adapters.input.rest.mapper.ProductRestMapper
import hexagonal.architecture.application.ports.input.CreateProductUseCase
import hexagonal.architecture.application.ports.input.GetProductUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1")
class ProductRestAdapter (val productRestMapper: ProductRestMapper,
                          val createProductUseCase: CreateProductUseCase,
                          val getProductUseCase: GetProductUseCase){

    @PostMapping("/products")
    fun createProduct( @RequestBody @Valid productCreateRequest: ProductCreateRequest): ResponseEntity<ProductCreateResponse>{
        // Request to domain
        val product = productRestMapper.toProduct(productCreateRequest)
        val createProduct = createProductUseCase.createProduct(product)

        // Domain to response
        return ResponseEntity(productRestMapper.toProductCreateResponse(createProduct), HttpStatus.CREATED)
    }

    @GetMapping("/product/{id}")
    fun getProduct(@PathVariable id: Long):ResponseEntity<ProductQueryResponse>{
        val productById = getProductUseCase.getProductById(id)
        return ResponseEntity(productRestMapper.toProductQueryResponse(productById), HttpStatus.OK)
    }
}