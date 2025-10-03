ALTER TABLE users
    DROP CONSTRAINT FK_users_addresses;

ALTER TABLE restaurants
    DROP CONSTRAINT FK_restaurants_addresses;

DROP TABLE addresses;