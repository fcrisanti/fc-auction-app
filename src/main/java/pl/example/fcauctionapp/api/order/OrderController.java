package pl.example.fcauctionapp.api.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.example.fcauctionapp.domain.order.OrderFacade;
import pl.example.fcauctionapp.domain.payment.Payment;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderFacade orderFacade;

    @GetMapping(path = "/pending")
    public ResponseEntity<List<Payment>> getPendingOrders() {
        return ResponseEntity.ok(orderFacade.getAllPaymentsByOrderStatus());
    }
}
