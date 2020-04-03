package pl.example.fcauctionapp.infrastructure.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.example.fcauctionapp.domain.order.Order;
import pl.example.fcauctionapp.domain.order.OrderRetrievalClient;
import pl.example.fcauctionapp.domain.order.OrderStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderRetrievalPostgresClient implements OrderRetrievalClient {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getPendingOrders() {
       return orderRepository.findAllByStatus(OrderStatus.PENDING);
    }

    @Override
    public List<Order> getPaidOrders() {
       return orderRepository.findAllByStatus(OrderStatus.PAID
       );
    }
}
