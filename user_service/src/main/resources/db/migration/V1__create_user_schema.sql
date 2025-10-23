CREATE TABLE IF NOT EXISTS users(
    id BIGSERIAL PRIMARY KEY ,
    user_idf UUID UNIQUE NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(25) NOT NULL,
    email_address VARCHAR(30) NOT NULL UNIQUE,
    status VARCHAR(30),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
    );

CREATE INDEX IF NOT EXISTS idx_users_user_idf ON users(user_idf);

CREATE TABLE IF NOT EXISTS addresses(
    id BIGSERIAL PRIMARY KEY ,
    address_idf UUID UNIQUE NOT NULL,
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE,
    label VARCHAR(50),
    street VARCHAR(50) NOT NULL,
    house_number VARCHAR(50) NOT NULL,
    box_number INTEGER,
    city VARCHAR(30),
    postal_code INTEGER,
    country VARCHAR(30),
    is_default BOOLEAN,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
    );

CREATE INDEX IF NOT EXISTS idx_addresses_address_idf ON addresses(address_idf);
CREATE INDEX IF NOT EXISTS idx_addresses_user_id ON addresses(user_id);

CREATE TABLE IF NOT EXISTS roles(
    id BIGSERIAL PRIMARY KEY,
    role_idf UUID UNIQUE NOT NULL,
    role_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles(
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE,
    role_id BIGINT REFERENCES roles(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);