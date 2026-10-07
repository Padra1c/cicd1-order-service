package ie.atu.cicd1.catalog.cicd1orderservice.catalog;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(
        name = "catalog-service",
        url = "http://localhost:8081"
)
public interface CatalogClient {
    @GetMapping("/products/{id}")
    String getProductById(@PathVariable("id") Long id);
}