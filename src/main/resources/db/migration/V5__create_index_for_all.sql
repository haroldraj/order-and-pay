
CREATE INDEX ix_orders__customer ON orders (user_id);

CREATE INDEX ix_orders__restaurant ON orders (restaurant_id);

CREATE INDEX ix_orders__status ON orders (status);

CREATE INDEX ix_orders__created_at ON orders (creation_date);

CREATE INDEX ix_orders__user_created ON orders (user_id, creation_date);

CREATE INDEX ix_order_items__order ON order_items (order_id);

CREATE INDEX ix_order_items__menu_item ON order_items (menu_items_id);

CREATE INDEX ix_menu_items__restaurant ON menu_items (restaurant_id);

CREATE INDEX ix_payments__order ON payments (order_id);

CREATE INDEX ix_payments__status ON payments (status);

CREATE INDEX ix_payments__user ON payments (user_id);

CREATE INDEX ix_payments__value_date ON payments (value_date);

CREATE INDEX ix_payments__order_status ON payments (order_id, status);

CREATE INDEX ix_deliveries__order ON deliveries (order_id);

CREATE INDEX ix_deliveries__courier ON deliveries (user_id);

CREATE INDEX ix_deliveries__status ON deliveries (status);

CREATE INDEX ix_deliveries__pickup ON deliveries (pick_up_time);

CREATE INDEX ix_deliveries__delivery ON deliveries (delivery_time);

CREATE INDEX ix_users__created ON users (creation_date);

CREATE INDEX ix_users_roles__role ON users_roles (role_id);

CREATE INDEX ix_restaurants__name ON restaurants (restaurant_name);

CREATE INDEX ix_addresses__city ON addresses (city);

CREATE INDEX ix_addresses__postal ON addresses (postal_code);