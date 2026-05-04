CREATE TABLE IF NOT EXISTS deliveries(
    id UUID PRIMARY KEY,
    order_id UUID NOT NULL,
    user_id UUID NOT NULL,
    restaurant_id UUID NOT NULL,
    restaurant_snapshot JSONB,
    address_snapshot JSONB,
    status VARCHAR(30),
    estimated_delivery_time TIMESTAMP,
    delivered_at TIMESTAMP,
    picked_up_at TIMESTAMP,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_deliveries_order_id ON deliveries(order_id);
CREATE INDEX IF NOT EXISTS idx_deliveries_user_id ON deliveries(user_id);
CREATE INDEX IF NOT EXISTS idx_deliveries_restaurant_id ON deliveries(restaurant_id);

CREATE TABLE IF NOT EXISTS drivers(
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(25) NOT NULL,
    email_address VARCHAR(30) NOT NULL,
    vehicle_type VARCHAR(15) NOT NULL,
    available BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);


CREATE TABLE IF NOT EXISTS delivery_assignments(
    delivery_id UUID REFERENCES deliveries(id),
    driver_id UUID REFERENCES drivers(id),
    status VARCHAR(30) NOT NULL DEFAULT 'ASSIGNED',
    assigned_at TIMESTAMP,
    accepted_at TIMESTAMP,
    completed_at TIMESTAMP,
    cancelled_at TIMESTAMP,
    PRIMARY KEY (delivery_id, driver_id)
);