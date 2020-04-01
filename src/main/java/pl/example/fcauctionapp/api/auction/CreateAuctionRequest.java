package pl.example.fcauctionapp.api.auction;

import lombok.Value;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class CreateAuctionRequest {

    @Min(1)
    private final long ownerId;
    @Min(1)
    private final long ownerAccountId;
    @NotNull
    @NotEmpty
    private final String title;
    @NotNull
    @NotEmpty
    private final String description;
    @Min(1)
    private final int quantity;
    @DecimalMin("0.01")
    private final BigDecimal price;
    @Min(1)
    private final int expirationDays;
}
