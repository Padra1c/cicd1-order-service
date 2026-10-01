package ie.atu.cicd1.catalog.cicd1orderservice.service;

import ie.atu.cicd1.catalog.cicd1orderservice.model.PurchaseOrder;
import ie.atu.cicd1.catalog.cicd1orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PurchaseOrderService {
    private final OrderRepository repository;

    public PurchaseOrderService(OrderRepository repository) {
        this.repository = repository;
    }
    public List<PurchaseOrder> getAll() {
        return repository.findAll();
    }
    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(null);
        return repository.save(order);
    }
}
