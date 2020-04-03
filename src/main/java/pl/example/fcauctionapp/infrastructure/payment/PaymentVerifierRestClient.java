package pl.example.fcauctionapp.infrastructure.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.example.fcauctionapp.domain.payment.Payment;
import pl.example.fcauctionapp.domain.payment.PaymentVerifierClient;

import java.util.List;


@Service
class PaymentVerifierRestClient implements PaymentVerifierClient
{

    private final RestTemplate restTemplate;
    private final String pendingTransfersUrl;

    @Autowired
    public PaymentVerifierRestClient(RestTemplate restTemplate, @Value("${verify.payments.bankapp.url}") String pendingTransferUrl) {
        this.restTemplate = restTemplate;
        this.pendingTransfersUrl = pendingTransferUrl;
    }

    @Override
    public List<Payment> getSuccessfulPayments() {
        return  restTemplate.exchange(
                pendingTransfersUrl,
                HttpMethod.POST,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Payment>>() {
                })
                .getBody();
//        return result.stream()
//                .map(CreateTransferCommandMapper::map)
//                .collect(Collectors.toList());
    }
}


