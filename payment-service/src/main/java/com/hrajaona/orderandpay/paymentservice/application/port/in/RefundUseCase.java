package com.hrajaona.orderandpay.paymentservice.application.port.in;

import com.hrajaona.orderandpay.paymentservice.adapters.in.web.dto.RefundRequest;
import com.hrajaona.orderandpay.paymentservice.domain.model.Refund;

import java.util.List;
import java.util.UUID;

public interface RefundUseCase {
    Refund updateRefund(UUID id, RefundRequest refundRequest);
    Refund getRefundById(UUID id);
    void deleteRefund(UUID id);
    List<Refund> getAllRefunds();
    Refund createRefund(RefundRequest refundRequest);

}
