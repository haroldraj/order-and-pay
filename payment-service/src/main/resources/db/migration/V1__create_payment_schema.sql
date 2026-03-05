CREATE TABLE IF NOT EXISTS payments(
    id UUID PRIMARY KEY,
    order_id UUID NOT NULL,
    user_id UUID NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    method VARCHAR(30) NOT NULL,
    status VARCHAR(30) NOT NULL,
    reference VARCHAR(100),
    value_date TIMESTAMP DEFAULT NOW(),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_payments_order_idf ON payments(order_id);
CREATE INDEX IF NOT EXISTS idx_payments_user_idf ON payments(user_id);

CREATE TABLE IF NOT EXISTS refunds(
    id UUID PRIMARY KEY,
    payment_id UUID REFERENCES payments(id) ON DELETE CASCADE,
    amount DECIMAL(12,2) NOT NULL,
    reason VARCHAR(255),
    refund_date TIMESTAMP DEFAULT NOW(),
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_refunds_payment_id ON refunds(payment_id);