package pl.example.fcauctionapp.infrastructure.auction;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.fcauctionapp.domain.auction.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
