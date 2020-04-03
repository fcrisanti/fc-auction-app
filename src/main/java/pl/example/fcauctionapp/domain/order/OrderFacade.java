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

    public void createOrder(OrderDto orderDto, boolean payNow) {
        orderCreator.createOrderUpdateAuctionOrThrow(orderDto,payNow);
    }

    public List<Payment> getAllPaymentsByOrderStatusPending() {
        return orderRetrievalClient.getPendingOrders().stream()
                .map(Payment::generate)
                .collect(Collectors.toList());
    }

    public List<Payment> getAllPaymentsByOrderStatusPaid() {
        return orderRetrievalClient.getPaidOrders().stream()
                .map(Payment::generate)
                .collect(Collectors.toList());
    }

    public void setOrdersAsPaid(List<Payment> payments) {
        for (Payment payment : payments) {
            orderRetrievalClient.getPendingOrders().stream()
                    .filter(order -> order.getPayment().equals(payment))
                    .forEach(order -> order.setStatus(OrderStatus.PAID));
        }
    }

//    public void setOrdersAsPaid(List<Payment> paymentList) {
//        orderRetrievalClient.getPendingOrders().stream()
//                .filter()
//    }
}
