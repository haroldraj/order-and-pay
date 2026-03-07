DROP INDEX idx_users_user_idf;
DROP INDEX idx_addresses_address_idf;
DROP INDEX idx_addresses_user_id;

ALTER TABLE addresses
    DROP COLUMN user_id;
