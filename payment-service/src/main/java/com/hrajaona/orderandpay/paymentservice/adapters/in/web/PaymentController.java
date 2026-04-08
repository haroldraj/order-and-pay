package com.hrajaona.orderandpay.paymentservice.adapters.in.web;

import com.hrajaona.orderandpay.paymentservice.adapters.in.web.dto.PaymentRequest;
import com.hrajaona.orderandpay.paymentservice.application.service.PaymentService;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping()
    public ResponseEntity<List<Payment>> getAllPayments(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    //RequestParam & RequestBody
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePaymentById(@PathVariable("id") UUID paymentId, @RequestBody PaymentRequest payment){
        return ResponseEntity.ok(new Payment());
    }

    @PostMapping()
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentRequest payment){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.createPayment(payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Payment> deletePaymentByIdf(@PathVariable("id") UUID paymentIdf){
        return ResponseEntity.ok(new Payment());
    }
}
