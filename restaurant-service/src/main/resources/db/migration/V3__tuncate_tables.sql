ALTER TABLE menu_items
DROP CONSTRAINT menu_items_restaurant_id_fkey;

TRUNCATE  TABLE restaurants;
TRUNCATE TABLE  menu_items;
