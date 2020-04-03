package pl.example.fcauctionapp.domain.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.example.fcauctionapp.domain.order.Order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "payment_sequence")
    @SequenceGenerator(name = "payment_sequence")
    private long id;

    private long ownerId;
    private long ownerAccountId;
    private String clientAccountNumber;
    private BigDecimal totalPrice;
    private String title;

    @JsonIgnore
    @OneToOne(mappedBy = "payment")
    private Order order;

    public static Payment generate(Order order) {
        Payment payment = new Payment();
        payment.ownerId = order.getOwnerId();
        payment.ownerAccountId = order.getOwnerAccountId();
        payment.clientAccountNumber = order.getClientAccountNumber();
        payment.totalPrice = order.getUnitPrice().multiply(new BigDecimal(order.getQuantity()));
        payment.title = String.format("%d, %d, %d", order.getId(), order.getOwnerId(), order.getClientId());
        payment.order = order;
        return payment;
    }
}
