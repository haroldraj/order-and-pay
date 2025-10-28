INSERT INTO users (user_idf, user_name, phone_number, email_address, status, role)
VALUES
    ('6f0b2af5-42e1-4b7f-b6b1-5a74b0cfb0e1', 'Alice Dupont',  '+32475123456', 'alice.dupont@example.com', 'ACTIVE', 'CUSTOMER'),
    ('74a8a6b3-208c-4c5a-900e-6e5135f477cd', 'Bob Martin',    '+32488991234', 'bob.martin@example.com',   'ACTIVE', 'DISPATCHER'),
    ('b92c80f7-f7d1-47f5-a0e9-0f4169e832d7', 'Claire Leroy',  '+32496321254', 'claire.leroy@example.com', 'SUSPENDED', 'CUSTOMER'),
    ('0adf09f5-2bde-4bb7-bb4b-c42f9f28cf44', 'David Noël',    '+32499112233', 'david.noel@example.com',   'ACTIVE', 'DISPATCHER'),
    ('2cfa4b4f-89d1-4d42-8f5b-073dfe4a07b5', 'Emma Dubois',   '+32477445566', 'emma.dubois@example.com',  'ACTIVE', 'ADMIN');

INSERT INTO addresses (
    address_idf, user_id, label, street, house_number, box_number, city, postal_code, country, is_default
) VALUES
      ('4a3a1c3e-2ef0-4707-bc3a-37e2f1a7b8ab', 1, 'Home', 'Rue de la Loi', '25', NULL, 'Bruxelles', 1000, 'Belgium', TRUE),
      ('28d53f6d-dedf-4789-8184-82b28d1fa6e1', 1, 'Work', 'Avenue Louise', '60', NULL, 'Bruxelles', 1050, 'Belgium', FALSE),
      ('d1e2f1a3-65c7-4a88-bb3e-42a3b6cd99ab', 2, 'Home', 'Rue des Fleurs', '15', NULL, 'Namur', 5000, 'Belgium', TRUE),
      ('f3c8d7a9-17c2-4fae-9a55-5e83b53a1d7c', 3, 'Home', 'Boulevard de la Liberté', '120', NULL, 'Liège', 4000, 'Belgium', TRUE),
      ('89a1d2e4-91b4-4e3c-8e2f-91dfe8f42a1b', 4, 'Restaurant', 'Chaussée de Waterloo', '155', NULL, 'Uccle', 1180, 'Belgium', TRUE),
      ('a7b5c3d1-24e9-4d5f-9e4a-2b8a1c3f4e5d', 5, 'Office', 'Rue Royale', '200', NULL, 'Bruxelles', 1210, 'Belgium', TRUE);
