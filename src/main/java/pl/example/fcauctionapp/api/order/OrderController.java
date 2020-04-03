package pl.example.fcauctionapp.api.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.example.fcauctionapp.domain.order.OrderFacade;
import pl.example.fcauctionapp.domain.payment.Payment;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderFacade orderFacade;

    @GetMapping(path = "/pending")
    public ResponseEntity<List<Payment>> getPendingOrders() {
        return ResponseEntity.ok(orderFacade.getAllPaymentsByOrderStatusPending());
    }

    @GetMapping(path = "/checkall")
    public void getPaidOrders() {
        orderFacade.getAllPaymentsFromBankAndSetOrdersAsPaid();
    }

    @PostMapping(path = "/setpaid")
    public void setOrdersAsPaid(@Valid @RequestBody List<Payment> payments) {
        orderFacade.setOrdersAsPaid(payments);
    }
}
