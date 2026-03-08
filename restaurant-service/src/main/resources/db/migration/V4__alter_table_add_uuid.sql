DROP INDEX idx_menu_items_item_idf;
DROP INDEX  idx_menu_items_restaurant_id;
DROP INDEX idx_restaurants_restaurant_idf;

ALTER TABLE menu_items
DROP COLUMN id;

ALTER TABLE  menu_items
DROP COLUMN item_idf;

ALTER TABLE menu_items
ADD COLUMN id UUID PRIMARY KEY;

ALTER TABLE restaurants
DROP COLUMN id;

ALTER TABLE restaurants
RENAME COLUMN restaurant_idf TO id;

ALTER TABLE  restaurants
ADD PRIMARY KEY (id);

ALTER TABLE menu_items
DROP COLUMN restaurant_id;

ALTER TABLE menu_items
ADD COLUMN restaurant_id UUID REFERENCES restaurants(id) ON DELETE CASCADE ;
