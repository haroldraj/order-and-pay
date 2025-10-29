CREATE TABLE IF NOT EXISTS restaurants(
    id BIGSERIAL PRIMARY KEY,
    restaurant_idf UUID UNIQUE,
    name VARCHAR(150) NOT NULL,
    phone_number VARCHAR(25),
    email_address VARCHAR(30),
    address VARCHAR(150),
    status VARCHAR(30),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_restaurants_restaurant_idf ON restaurants(restaurant_idf);

CREATE TABLE IF NOT EXISTS menu_items(
    id BIGSERIAL PRIMARY KEY,
    item_idf UUID UNIQUE NOT NULL,
    restaurant_id BIGINT REFERENCES restaurants(id) ON DELETE CASCADE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    available BOOLEAN DEFAULT TRUE,
    price DECIMAL(12,2) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_menu_items_item_idf ON menu_items(item_idf);
CREATE INDEX IF NOT EXISTS idx_menu_items_restaurant_id ON menu_items(restaurant_id);