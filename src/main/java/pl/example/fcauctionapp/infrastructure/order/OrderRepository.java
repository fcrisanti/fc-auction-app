package pl.example.fcauctionapp.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.fcauctionapp.domain.order.Order;
import pl.example.fcauctionapp.domain.order.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByStatus(OrderStatus orderStatus);
}
