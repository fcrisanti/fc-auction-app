package pl.example.fcauctionapp.infrastructure.auction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.example.fcauctionapp.domain.auction.Auction;

import pl.example.fcauctionapp.domain.auction.AuctionRetrievalClient;

@Service
@RequiredArgsConstructor
public class AuctionRetrievalPostgresClient implements AuctionRetrievalClient {

    private final AuctionRepository auctionRepository;

    @Override
    public Auction getActiveByIdOrThrow(long id) {
        Auction auction = auctionRepository.getOne(id);
        if (!auction.isActive()) {
            throw new IllegalArgumentException(String
                    .format("Auction is inactive [auctionId = %d]", auction.getId()));
        }
        return auction;
    }
}
