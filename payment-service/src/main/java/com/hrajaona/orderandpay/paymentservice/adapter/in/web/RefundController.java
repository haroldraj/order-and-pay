package com.hrajaona.orderandpay.paymentservice.adapter.in.web;

import com.hrajaona.orderandpay.paymentservice.application.service.RefundService;
import com.hrajaona.orderandpay.paymentservice.domain.model.Refund;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/refunds")
@RequiredArgsConstructor
public class RefundController {
    private final RefundService refundService;

    @GetMapping
    public ResponseEntity<List<Refund>> getAllRefund(){
        return ResponseEntity.ok(refundService.getAllRefunds());
    }
}
