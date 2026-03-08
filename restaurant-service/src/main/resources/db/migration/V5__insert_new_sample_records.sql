
INSERT INTO restaurants (id, name, phone_number, email_address, address, status, created_at, updated_at)
VALUES
    ('3c5a88e2-ff5b-44a7-8d7c-0e6f6a9fbd11', 'Le Gourmet Belge', '+32475111222', 'contact@legourmet.be', 'Avenue Louise 124, Bruxelles', 'OPEN', NOW(), NOW()),
    ('6f73a9bc-3d3e-4b2e-93c9-32b778e58201', 'Pizza Napoli', '+32477222333', 'info@pizzanapoli.be', 'Rue des Dominicains 8, Liège', 'OPEN', NOW(), NOW()),
    ('b2d445af-5f32-41f8-9011-39e95b63a902', 'Sushi House', '+32478333444', 'order@sushihouse.be', 'Chaussée de Louvain 202, Namur', 'OPEN', NOW(), NOW()),
    ('a18e42e3-1cd1-4cc2-87d9-9ef04a3b9a01', 'Veggie World', '+32479444555', 'hello@veggieworld.be', 'Boulevard Anspach 99, Bruxelles', 'CLOSED', NOW(), NOW());

INSERT INTO menu_items (id, restaurant_id, name, description, available, price, created_at, updated_at)
VALUES
    (gen_random_uuid(), '3c5a88e2-ff5b-44a7-8d7c-0e6f6a9fbd11', 'Carbonnade Flamande', 'Boeuf mijoté à la bière brune, servi avec frites.', TRUE, 19.90, NOW(), NOW()),
    (gen_random_uuid(), '3c5a88e2-ff5b-44a7-8d7c-0e6f6a9fbd11', 'Croquettes de Crevettes', 'Spécialité belge aux crevettes grises.', TRUE, 14.50, NOW(), NOW()),
    (gen_random_uuid(), '3c5a88e2-ff5b-44a7-8d7c-0e6f6a9fbd11', 'Dame Blanche', 'Glace vanille, sauce chocolat chaud et chantilly.', TRUE, 8.90, NOW(), NOW());

INSERT INTO menu_items (id, restaurant_id, name, description, available, price, created_at, updated_at)
VALUES
    (gen_random_uuid(), '6f73a9bc-3d3e-4b2e-93c9-32b778e58201', 'Margherita', 'Tomate, mozzarella, basilic frais.', TRUE, 10.00, NOW(), NOW()),
    (gen_random_uuid(), '6f73a9bc-3d3e-4b2e-93c9-32b778e58201', 'Diavola', 'Tomate, mozzarella, salami piquant.', TRUE, 12.50, NOW(), NOW()),
    (gen_random_uuid(), '6f73a9bc-3d3e-4b2e-93c9-32b778e58201', 'Quattro Formaggi', 'Sauce blanche, mozzarella, gorgonzola, parmesan, ricotta.', TRUE, 13.50, NOW(), NOW());

INSERT INTO menu_items (id, restaurant_id, name, description, available, price, created_at, updated_at)
VALUES
    (gen_random_uuid(), 'b2d445af-5f32-41f8-9011-39e95b63a902', 'Sushi Mix 12 pièces', 'Assortiment varié de nigiris et makis.', TRUE, 17.90, NOW(), NOW()),
    (gen_random_uuid(), 'b2d445af-5f32-41f8-9011-39e95b63a902', 'California Roll Saumon', 'Riz, saumon, avocat, fromage frais.', TRUE, 11.50, NOW(), NOW()),
    (gen_random_uuid(), 'b2d445af-5f32-41f8-9011-39e95b63a902', 'Tempura Crevette', 'Crevettes croustillantes, sauce soja sucrée.', TRUE, 9.90, NOW(), NOW());

INSERT INTO menu_items (id, restaurant_id, name, description, available, price, created_at, updated_at)
VALUES
    (gen_random_uuid(), 'a18e42e3-1cd1-4cc2-87d9-9ef04a3b9a01', 'Burger Végétarien', 'Pain complet, galette de pois chiches, légumes grillés.', FALSE, 12.90, NOW(), NOW()),
    (gen_random_uuid(), 'a18e42e3-1cd1-4cc2-87d9-9ef04a3b9a01', 'Salade Quinoa', 'Quinoa, légumes de saison, sauce citronnée.', TRUE, 10.50, NOW(), NOW()),
    (gen_random_uuid(), 'a18e42e3-1cd1-4cc2-87d9-9ef04a3b9a01', 'Soupe du Jour', 'Soupe maison à base de légumes bio.', TRUE, 6.50, NOW(), NOW());
