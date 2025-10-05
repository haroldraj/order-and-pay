INSERT INTO users (
    user_idf, user_name, phone_number, email_address, creation_date, role,
    addr_street, addr_house, addr_box, addr_city, addr_postal_code, addr_country
) VALUES
      ('bdf2a80d-5c8b-4dc7-a1b7-39b9b3f70112', 'Alice Martin', '+32470112233', 'alice.martin@example.com', '2025-10-04 14:00:00', 'CUSTOMER',
       'Rue de la Loi', '15', '2A', 'Bruxelles', '1000', 'Belgique'),

      ('9f67c9b2-0ac5-4a83-87a9-c7b6b4d94e82', 'Bob Leroy', '+32470113344', 'bob.leroy@example.com', '2025-10-04 14:05:00', 'DRIVER',
       'Avenue Louise', '200', '5', 'Bruxelles', '1050', 'Belgique'),

      ('f25b61e7-fd16-4c8f-9508-daf442edb3a5', 'Caroline Dupont', '+32470114455', 'caroline.dupont@example.com', '2025-10-04 14:10:00', 'RESTAURANT_OWNER',
       'Rue des Chartreux', '11', '6', 'Bruxelles', '1000', 'Belgique'),

      ('6e3f9d44-66b1-4f11-bbe9-b8cfb9a9a9a7', 'David Moreau', '+32470115566', 'david.moreau@example.com', '2025-10-04 14:15:00', 'ADMIN',
       'Chaussée de Louvain', '54', '10', 'Louvain-la-Neuve', '1348', 'Belgique'),

      ('af1c77cc-46b3-4b76-a216-78a11cfca91f', 'Emma Van Damme', '+32470116677', 'emma.vandamme@example.com', '2025-10-04 14:20:00', 'CUSTOMER',
       'Rue du Midi', '23', '1B', 'Namur', '5000', 'Belgique');
