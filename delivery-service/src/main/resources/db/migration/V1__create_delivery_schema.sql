CREATE TABLE IF NOT EXISTS deliveries(
    id BIGSERIAL PRIMARY KEY,
    delivery_idf UUID UNIQUE,
    order_idf UUID NOT NULL,
    user_idf UUID NOT NULL,
    restaurant_idf UUID NOT NULL,
    restaurant_snapshot JSONB,
    address_snapshot JSONB,
    status VARCHAR(30),
    estimated_delivery_time TIMESTAMP,
    delivered_at TIMESTAMP,
    picked_up_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_deliveries_delivery_idf ON deliveries(delivery_idf);
CREATE INDEX IF NOT EXISTS idx_deliveries_order_idf ON deliveries(order_idf);
CREATE INDEX IF NOT EXISTS idx_deliveries_user_idf ON deliveries(user_idf);
CREATE INDEX IF NOT EXISTS idx_deliveries_restaurant_idf ON deliveries(restaurant_idf);

CREATE TABLE IF NOT EXISTS drivers(
    id BIGSERIAL PRIMARY KEY,
    driver_idf UUID UNIQUE NOT NULL,
    driver_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(25) NOT NULL,
    email_address VARCHAR(30) NOT NULL,
    vehicule_type VARCHAR(15) NOT NULL,
    available BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_drivers_driver_idf ON drivers(driver_idf);

CREATE TABLE IF NOT EXISTS delivery_assignments(
    delivery_id BIGINT REFERENCES deliveries(id),
    driver_id BIGINT REFERENCES drivers(id),
    assigned_at TIMESTAMP DEFAULT NOW(),
    PRIMARY KEY (delivery_id, driver_id)
);