package pl.example.fcauctionapp.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.example.fcauctionapp.domain.auction.Auction;
import pl.example.fcauctionapp.domain.auction.AuctionRetrievalClient;
import pl.example.fcauctionapp.domain.auction.QuantityChanger;
import pl.example.fcauctionapp.domain.payment.PaymentSenderClient;

@Service
@RequiredArgsConstructor
class OrderCreator {

    private final AuctionRetrievalClient auctionRetrievalClient;
    private final CreateOrderClient createOrderClient;
    private final QuantityChanger quantityChanger;
    private final PaymentSenderClient paymentSenderClient;

    @Transactional
    public void createOrderUpdateAuctionOrThrow(OrderDto orderDto, Boolean payNow) {
        Auction auction = auctionRetrievalClient.getActiveByIdOrThrow(orderDto.getAuctionId());
        if (auction.getQuantity() >= orderDto.getQuantity()) {
            Order order = Order.generatePending(orderDto, auction);
            createOrderClient.create(order);
            quantityChanger.reduceQuantity(auction, order.getQuantity());
        if (payNow) {
            paymentSenderClient.sendPayment(order);
            order.setStatus(OrderStatus.PAID);
        }
        } else {
            throw new IllegalArgumentException(String
                    .format("Order quantity is higher then auction quantity [Order quantity = %d] [Auction quantity = %d]",
                            orderDto.getQuantity(),
                            auction.getQuantity()));
        }
    }
}
