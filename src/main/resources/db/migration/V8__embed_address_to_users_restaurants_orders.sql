ALTER TABLE users
    ADD COLUMN addr_street VARCHAR(50),
    ADD COLUMN addr_house VARCHAR(10),
    ADD COLUMN addr_box VARCHAR(10),
    ADD COLUMN addr_city VARCHAR(30),
    ADD COLUMN addr_postal_code INTEGER,
    ADD COLUMN addr_country VARCHAR(30);

ALTER TABLE restaurants
    ADD COLUMN addr_street VARCHAR(50),
    ADD COLUMN addr_house VARCHAR(10),
    ADD COLUMN addr_box VARCHAR(10),
    ADD COLUMN addr_city VARCHAR(30),
    ADD COLUMN addr_postal_code INTEGER,
    ADD COLUMN addr_country VARCHAR(30);

ALTER TABLE orders
    ADD COLUMN ship_name VARCHAR(120),
    ADD COLUMN ship_phone VARCHAR(30),
    ADD COLUMN ship_street VARCHAR(50),
    ADD COLUMN ship_house VARCHAR(10),
    ADD COLUMN ship_box VARCHAR(10),
    ADD COLUMN ship_city VARCHAR(30),
    ADD COLUMN ship_postal_code INTEGER,
    ADD COLUMN ship_country VARCHAR(30);