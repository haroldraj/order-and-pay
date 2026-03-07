
INSERT INTO users (id, user_name, phone_number, email_address, status, role, created_at, updated_at)
VALUES
    ('6f0b2af5-42e1-4b7f-b6b1-5a74b0cfb0e1', 'Alice Dupont',  '+32475123456', 'alice.dupont@example.com', 'ACTIVE', 'CUSTOMER', NOW() - INTERVAL '10 days', NOW() - INTERVAL '10 days'),
    ('74a8a6b3-208c-4c5a-900e-6e5135f477cd', 'Bob Martin',    '+32488991234', 'bob.martin@example.com',   'ACTIVE', 'DISPATCHER', NOW() - INTERVAL '1 days', NOW() - INTERVAL '1 days'),
    ('b92c80f7-f7d1-47f5-a0e9-0f4169e832d7', 'Claire Leroy',  '+32496321254', 'claire.leroy@example.com', 'ACTIVE', 'CUSTOMER', NOW() - INTERVAL '8 days', NOW() - INTERVAL '8 days'),
    ('0adf09f5-2bde-4bb7-bb4b-c42f9f28cf44', 'David Noël',    '+32499112233', 'david.noel@example.com',   'ACTIVE', 'DISPATCHER', NOW() - INTERVAL '4 days', NOW() - INTERVAL '4 days'),
    ('2cfa4b4f-89d1-4d42-8f5b-073dfe4a07b5', 'Emma Dubois',   '+32477445566', 'emma.dubois@example.com',  'ACTIVE', 'ADMIN', NOW() - INTERVAL '2 days', NOW() - INTERVAL '2 days'),
    ('2cfa4b4f-89d1-4d47-8f5b-073dfe4a07b8', 'Marc Dubois',   '+32477445588', 'marc.dubois@example.com',  'ACTIVE', 'ADMIN', NOW() - INTERVAL '7 days', NOW() - INTERVAL '7 days');;

INSERT INTO addresses (
    id, user_id, label, street, house_number, box_number, city, postal_code, country, is_default, created_at, updated_at
) VALUES
      ('4a3a1c3e-2ef0-4707-bc3a-37e2f1a7b8ab', '6f0b2af5-42e1-4b7f-b6b1-5a74b0cfb0e1', 'Home', 'Rue de la Loi', '25', NULL, 'Bruxelles', 1000, 'Belgium', TRUE, NOW() - INTERVAL '10 days', NOW() - INTERVAL '10 days'),
      ('28d53f6d-dedf-4789-8184-82b28d1fa6e1', '2cfa4b4f-89d1-4d47-8f5b-073dfe4a07b8', 'Work', 'Avenue Louise', '60', NULL, 'Bruxelles', 1050, 'Belgium', TRUE, NOW() - INTERVAL '1 days', NOW() - INTERVAL '1 days'),
      ('d1e2f1a3-65c7-4a88-bb3e-42a3b6cd99ab', '2cfa4b4f-89d1-4d42-8f5b-073dfe4a07b5', 'Home', 'Rue des Fleurs', '15', NULL, 'Namur', 5000, 'Belgium', TRUE, NOW() - INTERVAL '8 days', NOW() - INTERVAL '8 days'),
      ('f3c8d7a9-17c2-4fae-9a55-5e83b53a1d7c', 'b92c80f7-f7d1-47f5-a0e9-0f4169e832d7', 'Home', 'Boulevard de la Liberté', '120', NULL, 'Liège', 4000, 'Belgium', TRUE, NOW() - INTERVAL '5 days',NOW() - INTERVAL '5 days'),
      ('89a1d2e4-91b4-4e3c-8e2f-91dfe8f42a1b', '74a8a6b3-208c-4c5a-900e-6e5135f477cd', 'Restaurant', 'Chaussée de Waterloo', '155', NULL, 'Uccle', 1180, 'Belgium', TRUE, NOW() - INTERVAL '4 days', NOW() - INTERVAL '4 days'),
      ('a7b5c3d1-24e9-4d5f-9e4a-2b8a1c3f4e5d', '0adf09f5-2bde-4bb7-bb4b-c42f9f28cf44', 'Office', 'Rue Royale', '200', NULL, 'Bruxelles', 1210, 'Belgium', TRUE, NOW() - INTERVAL '2 days', NOW() - INTERVAL '2 days');
