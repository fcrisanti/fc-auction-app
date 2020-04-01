package pl.example.fcauctionapp.domain.auction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuctionQuantityChanger implements QuantityChanger {

    @Override
    public void reduceQuantity(Auction auction, int reduceByQty) {
        auction.reduceQuantityAndVerifyStatus(reduceByQty);
    }
}
