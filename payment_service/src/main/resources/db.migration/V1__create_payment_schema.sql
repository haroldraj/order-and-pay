CREATE TABLE IF NOT EXISTS payments(
    id BIGSERIAL PRIMARY KEY,
    payment_idf UUID UNIQUE NOT NULL,
    order_idf UUID NOT NULL,
    user_idf UUID NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    method VARCHAR(30) NOT NULL,
    status VARCHAR(30) NOT NULL,
    reference VARCHAR(100),
    value_date TIMESTAMP DEFAULT NOW(),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_payments_payment_idf ON payments(payment_idf);
CREATE INDEX IF NOT EXISTS idx_payments_order_idf ON payments(order_idf);
CREATE INDEX IF NOT EXISTS idx_payments_user_idf ON payments(user_idf);

CREATE TABLE IF NOT EXISTS refunds(
    id BIGSERIAL PRIMARY KEY,
    refund_idf UUID UNIQUE NOT NULL,
    payment_id BIGINT REFERENCES payments(id) ON DELETE CASCADE,
    amount DECIMAL(12,2) NOT NULL,
    reason VARCHAR(255),
    refund_date TIMESTAMP DEFAULT NOW(),
    status VARCHAR(30) NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_refunds_refund_idf ON refunds(refund_idf);
CREATE INDEX IF NOT EXISTS idx_refunds_payment_id ON refunds(payment_id);