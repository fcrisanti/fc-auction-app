package pl.example.fcauctionapp.api.order;

import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class CreateOrderRequest {

    @Min(1)
    private final long clientId;
    @NotNull
    @NotEmpty
    private final String clientAccountNumber;
    @Min(1)
    private final int quantity;
}
