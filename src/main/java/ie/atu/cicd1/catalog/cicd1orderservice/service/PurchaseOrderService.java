package ie.atu.cicd1.catalog.cicd1orderservice.service;

import ie.atu.cicd1.catalog.cicd1orderservice.model.PurchaseOrder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class PurchaseOrderService {
    private final List<PurchaseOrder> orders = new ArrayList<>();
    private long nextId = 1;
    public List<PurchaseOrder> getAll() {
        return orders;
    }
    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(nextId++);
        orders.add(order);
        return order;
    }
}
