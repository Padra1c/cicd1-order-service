package ie.atu.cicd1.catalog.cicd1orderservice.service;

import ie.atu.cicd1.catalog.cicd1orderservice.catalog.CatalogClient;
import ie.atu.cicd1.catalog.cicd1orderservice.model.PurchaseOrder;
import ie.atu.cicd1.catalog.cicd1orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
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

    public String testCatalogConnection(Long productId) {
        return catalogClient.getProductById(productId);
    }
}

