package pl.example.fcauctionapp.infrastructure.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.example.fcauctionapp.domain.order.CreateOrderClient;
import pl.example.fcauctionapp.domain.order.Order;

@Service
@RequiredArgsConstructor
public class CreateOrderPostgresClient implements CreateOrderClient {

    private final OrderRepository orderRepository;

    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }
}
