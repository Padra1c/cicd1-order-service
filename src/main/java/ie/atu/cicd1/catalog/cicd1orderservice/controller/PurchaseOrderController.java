package ie.atu.cicd1.catalog.cicd1orderservice.controller;

import ie.atu.cicd1.catalog.cicd1orderservice.client.dto.ProductResponse;
import ie.atu.cicd1.catalog.cicd1orderservice.model.PurchaseOrder;
import ie.atu.cicd1.catalog.cicd1orderservice.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/orders")
public class PurchaseOrderController {
    private final PurchaseOrderService service;
    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }
    @GetMapping
    public List<PurchaseOrder> getAll() {
        return service.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseOrder create(@RequestBody PurchaseOrder order) {
        return service.create(order);
    }
    @GetMapping("/test-catalog/{productId}")
    public ProductResponse testCatalogConnection(@PathVariable Long productId) {
        return service.testCatalogConnection(productId);
    }
}