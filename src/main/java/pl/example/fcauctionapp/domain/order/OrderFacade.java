package pl.example.fcauctionapp.domain.order;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.example.fcauctionapp.domain.payment.Payment;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderCreator orderCreator;
    private final OrderRetrievalClient orderRetrievalClient;

    public void createOrder(OrderDto orderDto) {
        orderCreator.createOrderAndUpdateAuction(orderDto);
    }

    public List<Payment> getAllPaymentsByOrderStatus() {
        return orderRetrievalClient.getPendingOrders().stream()
                .map(Payment::generate)
                .collect(Collectors.toList());
    }
}
