package pl.example.fcauctionapp.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class OrderDto {

    @NonNull
    private long auctionId;
    @NonNull
    private final long clientId;
    @NonNull
    private final String clientAccountNumber;
    @NonNull
    private final int quantity;
}
