ALTER TABLE users
    MODIFY COLUMN creation_date DATETIME NOT NULL;

ALTER TABLE deliveries
    MODIFY COLUMN pick_up_time DATETIME,
    MODIFY COLUMN delivery_time DATETIME;

ALTER TABLE payments
    MODIFY COLUMN value_date DATETIME;