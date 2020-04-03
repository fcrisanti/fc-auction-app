package pl.example.fcauctionapp.domain.payment;

import java.util.List;

public interface PaymentVerifierClient {
    List<Payment> getSuccessfulPayments();
}
