package pl.example.fcauctionapp.domain.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.example.fcauctionapp.domain.order.OrderRetrievalClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentFacade {

    private final OrderRetrievalClient orderRetrievalClient;

    public List<String> getAllPendingPaymentTitle() {
        return orderRetrievalClient.getPendingOrders().stream()
                .map(Payment::generate)
                .map(Payment::getTitle)
                .collect(Collectors.toList());
    }
}
