CREATE TABLE IF NOT EXISTS roles(
    id INTEGER AUTO_INCREMENT,
    role_idf VARCHAR(36) NOT NULL,
    role_value VARCHAR(50) UNIQUE,
    CONSTRAINT PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS addresses(
    id INTEGER AUTO_INCREMENT,
    address_idf VARCHAR(36) NOT NULL,
    street VARCHAR(50) NOT NULL,
    house_number VARCHAR(50) NOT NULL,
    box_number INTEGER,
    city VARCHAR(30),
    postal_code INTEGER,
    country VARCHAR(30),
    CONSTRAINT PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users(
    id INTEGER AUTO_INCREMENT,
    user_idf VARCHAR(36) NOT NULL,
    address_id INTEGER,
    user_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(25) NOT NULL,
    email_address VARCHAR(30) NOT NULL UNIQUE,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT FK_users_addresses FOREIGN KEY (address_id) REFERENCES addresses(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS users_roles(
    user_id INTEGER,
    role_id INTEGER,
    CONSTRAINT FK_users_roles_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT FK_users_roles_roles FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (user_id,role_id)
);

CREATE TABLE IF NOT EXISTS restaurants(
    id INTEGER AUTO_INCREMENT,
    restaurant_idf VARCHAR(36) NOT NULL,
    address_id INTEGER,
    restaurant_name VARCHAR(50) NOT NULL UNIQUE,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT FK_restaurants_addresses FOREIGN KEY (address_id) REFERENCES addresses(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS menu_items(
    id INTEGER AUTO_INCREMENT,
    menu_item_idf VARCHAR(36) NOT NULL,
    restaurant_id INTEGER,
    menu_name VARCHAR(50) NOT NULL UNIQUE,
    price DECIMAL NOT NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT FK_menu_items_restaurants FOREIGN KEY (restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS orders(
    id INTEGER AUTO_INCREMENT,
    order_idf VARCHAR(36) NOT NULL,
    user_id INTEGER,
    restaurant_id INTEGER,
    total_amount DECIMAL NOT NULL,
    status VARCHAR(15) NOT NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT FK_orders_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT FK_orders_restaurants FOREIGN KEY (restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS deliveries(
    id INTEGER AUTO_INCREMENT,
    delivery_idf VARCHAR(36) NOT NULL,
    user_id INTEGER,
    order_id INTEGER,
    pick_up_time TIMESTAMP,
    delivery_time TIMESTAMP,
    status VARCHAR(15) NOT NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT FK_deliveries_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT FK_deliveries_orders FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS order_items(
    id INTEGER AUTO_INCREMENT,
    oder_item_idf VARCHAR(36) NOT NULL,
    menu_item_id INTEGER,
    order_id INTEGER,
    quantity INTEGER,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT FK_order_items_menu_items FOREIGN KEY (menu_item_id) REFERENCES menu_items(id) ON DELETE CASCADE,
    CONSTRAINT FK_order_items_orders FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS payments(
    id INTEGER AUTO_INCREMENT,
    payment_idf VARCHAR(36) NOT NULL,
    user_id INTEGER,
    order_id INTEGER,
    value_date TIMESTAMP,
    status VARCHAR(15) NOT NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT FK_payments_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT FK_payments_orders FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);