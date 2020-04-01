package pl.example.fcauctionapp.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.example.fcauctionapp.domain.order.Order;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Payment {

    private long ownerId;
    private long ownerAccountId;
    private String clientAccountNumber;
    private BigDecimal totalPrice;
    private String title;

    public static Payment generate(Order order) {
        Payment payment = new Payment();
        payment.ownerId = order.getOwnerId();
        payment.ownerAccountId = order.getOwnerAccountId();
        payment.clientAccountNumber = order.getClientAccountNumber();
        payment.totalPrice = order.getUnitPrice().multiply(new BigDecimal(order.getQuantity()));
        payment.title = String.format("%d, %d, %d", order.getId(), order.getOwnerId(), order.getClientId());
        return payment;
    }
}
