package pl.example.fcauctionapp.domain.auction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class AuctionCreator {

    private final CreateAuctionClient createAuctionClient;

    @Transactional
    public void create(AuctionDto auctionDto) {
        Auction auction = Auction.generateActive(auctionDto);
        createAuctionClient.create(auction);
    }
}
