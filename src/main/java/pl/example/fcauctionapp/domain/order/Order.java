package pl.example.fcauctionapp.domain.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import pl.example.fcauctionapp.domain.auction.Auction;
import pl.example.fcauctionapp.shared.Auditable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@Table(name = "ORDERS")
public class Order extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_sequence")
    @SequenceGenerator(name = "order_sequence")
    private long id;
    private long auctionId;
    private long ownerId;
    private long ownerAccountId;
    private BigDecimal unitPrice;
    private long clientId;
    private String clientAccountNumber;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    static Order generatePending(OrderDto orderDto, Auction auction) {
        Order order = Order.builder().auctionId(orderDto.getAuctionId())
                .ownerId(auction.getOwnerId())
                .ownerAccountId(auction.getOwnerAccountId())
                .unitPrice(auction.getPrice())
                .clientId(orderDto.getClientId())
                .clientAccountNumber(orderDto.getClientAccountNumber())
                .quantity(orderDto.getQuantity())
                .status(OrderStatus.PENDING)
                .build();
        return order;
    }
}
