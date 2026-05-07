CREATE TABLE IF NOT EXISTS restaurant_orders(
    id UUID PRIMARY KEY,
    order_id UUID NOT NULL,
    restaurant_id UUID NOT NULL REFERENCES restaurants(id),
    status VARCHAR(30) NOT NULL,
    amount DECIMAL(12, 2) NOT NULL,
    customer_snapshot JSONB NOT NULL,
    items_snapshot JSONB NOT NULL,
    delivery_address JSONB NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS restaurant_order_status_history(
    id UUID PRIMARY KEY,
    order_id UUID NOT NULL,
    previous_status VARCHAR(30) NOT NULL,
    new_status VARCHAR(30) NOT NULL,
    changed_at TIMESTAMP NOT NULL
);

CREATE INDEX idx_restaurant_orders_order_id
    ON restaurant_orders(order_id);