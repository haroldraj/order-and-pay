package com.hrajaona.orderandpay.paymentservice.adapter.in.web.error;

import com.hrajaona.orderandpay.paymentservice.adapter.in.web.enums.ApiCodeError;

public record ApiError(ApiCodeError code, String message) {
}
