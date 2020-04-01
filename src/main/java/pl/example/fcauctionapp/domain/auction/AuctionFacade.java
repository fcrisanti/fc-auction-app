package pl.example.fcauctionapp.domain.auction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionFacade {

    private final AuctionCreator auctionCreator;

    public void createAuction(AuctionDto auctionDto) {
        auctionCreator.create(auctionDto);
    }
}
