package com.hrajaona.orderandpay.paymentservice.application.service;

import com.hrajaona.orderandpay.paymentservice.adapters.in.web.dto.RefundRequest;
import com.hrajaona.orderandpay.paymentservice.adapters.out.persistence.mapper.RefundMapper;
import com.hrajaona.orderandpay.paymentservice.application.port.in.RefundUseCase;
import com.hrajaona.orderandpay.paymentservice.application.port.out.RefundRepository;
import com.hrajaona.orderandpay.paymentservice.domain.exception.RefundNotFoundException;
import com.hrajaona.orderandpay.paymentservice.domain.model.Refund;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefundService implements RefundUseCase {
    private final RefundRepository refundRepository;
    private final RefundMapper refundMapper;

    @Override
    public Refund createRefund(RefundRequest refundRequest) {
        return null;
    }

    @Override
    public void deleteRefund(UUID id) {

    }

    @Override
    public List<Refund> getAllRefunds() {
        return refundRepository.findAll()
                .stream()
                .map(refundMapper::toDomain)
                .toList();
    }

    @Override
    public Refund getRefundById(UUID id) {
        return refundRepository.findById(id)
                .map(refundMapper::toDomain)
                .orElseThrow(()-> new RefundNotFoundException(id));
    }

    @Override
    public Refund updateRefund(UUID id, RefundRequest refundRequest) {
        return null;
    }
}
