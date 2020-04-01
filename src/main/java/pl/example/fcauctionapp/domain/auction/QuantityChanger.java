package pl.example.fcauctionapp.domain.auction;

public interface QuantityChanger {
    void reduceQuantity (Auction auction, int reduceByQty);
}
