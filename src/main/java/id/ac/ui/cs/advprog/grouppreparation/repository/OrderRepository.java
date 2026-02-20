package id.ac.ui.cs.advprog.grouppreparation.repository;

import id.ac.ui.cs.advprog.grouppreparation.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByBuyerId(String buyerId);
    List<Order> findBySellerId(String sellerId);
}
