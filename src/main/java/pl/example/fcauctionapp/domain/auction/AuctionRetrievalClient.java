package pl.example.fcauctionapp.domain.auction;

public interface AuctionRetrievalClient {
    Auction getActiveByIdOrThrow(long id);
}
