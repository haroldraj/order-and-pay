CREATE TABLE IF NOT EXISTS orders(
    id BIGSERIAL PRIMARY KEY,
    order_idf UUID UNIQUE NOT NULL,
    user_idf UUID NOT NULL,
    address_idf UUID NOT NULL,
    restaurant_idf UUID NOT NULL,
    status VARCHAR(30) NOT NULL,
    total_amount DECIMAL(12,2) NOT NULL,
    payment_status VARCHAR(30) NOT NULL,
    delivery_status VARCHAR(30) NOT NULL,
    address_snapshot JSONB NOT NULL,
    restaurant_snapshot JSONB NOT NULL,
    order_date TIMESTAMP DEFAULT NOW(),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_orders_order_idf ON orders(order_idf);
CREATE INDEX IF NOT EXISTS idx_orders_user_idf ON orders(user_idf);
CREATE INDEX IF NOT EXISTS idx_orders_address_idf ON orders(address_idf);
CREATE INDEX IF NOT EXISTS idx_orders_restaurant_idf ON orders(restaurant_idf);

CREATE TABLE IF NOT EXISTS order_items(
    id BIGSERIAL PRIMARY KEY,
    order_item_idf UUID UNIQUE NOT NULL,
    order_id BIGINT REFERENCES orders(id) ON DELETE CASCADE,
    item_idf UUID NOT NULL,
    quantity INTEGER CHECK ( quantity > 0 ),
    unit_price DECIMAL(12,2) NOT NULL
);

CREATE INDEX IF NOT EXISTS  idx_order_items_order_id ON order_items(order_id);
CREATE INDEX IF NOT EXISTS  idx_order_items_item_idf ON order_items(item_idf);
CREATE INDEX IF NOT EXISTS  idx_order_items_order_item_idf ON order_items(order_item_idf);

CREATE TABLE IF NOT EXISTS order_status_history(
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT REFERENCES orders(id) ON DELETE CASCADE,
    previous_status VARCHAR(30),
    status VARCHAR(30),
    changed_at TIMESTAMP DEFAULT NOW(),
    changed_by VARCHAR(50)
);

CREATE INDEX IF NOT EXISTS  idx_order_status_history_order_id ON order_status_history(order_id);

