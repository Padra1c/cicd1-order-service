package ie.atu.cicd1.catalog.cicd1orderservice.client;

import ie.atu.cicd1.catalog.cicd1orderservice.client.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "catalog-service",
        url = "http://localhost:8081"
)
public interface CatalogClient {
    @GetMapping("/products/{id}")
    ProductResponse getProductById(@PathVariable("id") Long id);
}