package pl.example.fcauctionapp.domain.payment;
import pl.example.fcauctionapp.domain.order.Order;

public interface PaymentSenderClient {
    void sendPayment(Order order);



}
