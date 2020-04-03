package pl.example.fcauctionapp.domain.order;


import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import pl.example.fcauctionapp.domain.payment.Payment;
import pl.example.fcauctionapp.domain.payment.PaymentVerifierClient;
import pl.example.fcauctionapp.infrastructure.order.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderCreator orderCreator;
    private final OrderRetrievalClient orderRetrievalClient;
    private final PaymentVerifierClient paymentVerifierClient;


    public void createOrder(OrderDto orderDto, boolean payNow) {
        orderCreator.createOrderUpdateAuctionOrThrow(orderDto, payNow);
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

    public void getAllPaymentsFromBankAndSetOrdersAsPaid() {
        setOrdersAsPaid(paymentVerifierClient.getSuccessfulPayments());
    }

    public void setOrdersAsPaid(List<Payment> payments) {
        for (Payment payment : payments) {
            orderRetrievalClient
                    .getPendingOrders()
                    .stream()
                    .filter(order -> order.getPayment() == null)
                    .filter(order -> order.getOwnerId() == payment.getOwnerId())
                    .filter(order -> order.getOwnerAccountId() == payment.getOwnerAccountId())
                    .filter(order -> order.getClientAccountNumber().equals(payment.getClientAccountNumber()))
                    .forEach(order ->
                    {
                        order.setPayment(payment);
                        order.setStatus(OrderStatus.PAID);
                        orderCreator.save(order);
                        System.out.println(payment.getClientAccountNumber());
                        System.out.println(order.getClientAccountNumber());
                    });
        }
    }

//    public void setOrdersAsPaid(List<Payment> paymentList) {
//        orderRetrievalClient.getPendingOrders().stream()
//                .filter()
//    }
}
