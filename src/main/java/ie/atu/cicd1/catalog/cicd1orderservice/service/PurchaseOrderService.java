package ie.atu.cicd1.catalog.cicd1orderservice.service;

import ie.atu.cicd1.catalog.cicd1orderservice.client.CatalogClient;
import ie.atu.cicd1.catalog.cicd1orderservice.client.dto.ProductResponse;
import ie.atu.cicd1.catalog.cicd1orderservice.model.PurchaseOrder;
import ie.atu.cicd1.catalog.cicd1orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
@Service
public class PurchaseOrderService {
    private final OrderRepository repository;
    private final CatalogClient catalogClient;

    public PurchaseOrderService(OrderRepository repository,
                                CatalogClient catalogClient) {
        this.repository = repository;
        this.catalogClient = catalogClient;
    }

    public List<PurchaseOrder> getAll() {
        return repository.findAll();
    }

    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(null);
        return repository.save(order);
    }

    public ProductResponse testCatalogConnection(Long productId) {
        return catalogClient.getProductById(productId);
    }

    public ProductResponse getProductForOrder(Long orderId) {
        PurchaseOrder order = repository.findById(orderId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        return catalogClient.getProductById(order.getProductId());
    }

}

