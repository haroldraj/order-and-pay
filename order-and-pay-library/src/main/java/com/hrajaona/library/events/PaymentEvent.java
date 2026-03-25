package com.hrajaona.library.events;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class PaymentEvent {
    private UUID eventId;
    private UUID orderId;
    private UUID paymentId;
    private UUID userId;
    private LocalDateTime valueDate;
}
