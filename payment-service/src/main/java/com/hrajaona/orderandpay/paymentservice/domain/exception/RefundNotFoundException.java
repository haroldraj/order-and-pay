package com.hrajaona.orderandpay.paymentservice.domain.exception;


import java.util.UUID;

public class RefundNotFoundException extends  RuntimeException{
    public RefundNotFoundException(UUID id){
        super("Refund with id "+id+" not found");
    }
}
