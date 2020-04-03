package pl.example.fcauctionapp.domain.order;

import java.util.List;

public interface OrderRetrievalClient {

    List<Order> getPendingOrders();
    List<Order> getPaidOrders();
}
