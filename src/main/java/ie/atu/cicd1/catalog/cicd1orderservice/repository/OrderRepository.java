package ie.atu.cicd1.catalog.cicd1orderservice.repository;
import ie.atu.cicd1.catalog.cicd1orderservice.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PurchaseOrder,Long> {
}
