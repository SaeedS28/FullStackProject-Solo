-- Adding items to the store

insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (1, 'Boots', 'Clothing', 'They cover your feet from the cold and wet', 32, 12.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (2, 'Google Pixel Phone', 'Technology', 'It''s a phone fam', 12, 699.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (3, 'Water Bottle', 'Essentials', 'You can smuggle your alcohol now', 42, 5.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (4, 'Baseballs', 'Sports', 'You can now bash people with 95 mph fastball', 32, 4.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (5, 'Glasses', 'Technology', 'It''s a phone fam', 12, 699.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (6, 'Surface Pro 7', 'Technology', 'Latest and greatest computer so far', 12, 2099.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (7, 'Chocolate Bars', 'Food/Beverage', 'Dan will eat these in a flash', 85, 3.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (8, 'Mango Pudding', 'Food/Beverage', 'Dan will definitely eat these in a heartbeat', 50, 0.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (9, 'Jackets', 'Clothing', 'Leather jacket to keep you warm', 30, 69.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (10, 'Laniard', 'Clothing', 'Good for keeping your IDs in view', 32, 8.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (11, 'Wooden Table', 'Furniture', 'It''s a table made of dark maple wood', 32, 69.69);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (12, 'We are not your kind', 'Music', 'Slipknot''s latest album. It''s dank', 22, 39.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (13, 'Lightbulb', 'Utility', 'Only one person required to screw this one in', 72, 2.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (14, 'Pirated Movies', 'Illegal', 'Assorted bunch to choose from', 420, 2.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (15, 'Spiked Baseball bats', 'Illegal', 'We are not liable for any damage...they pop heads.', 32, 42.99);
insert into ITEM_LIST (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_DESCRIPTION, STORE_QUANTITY, UNIT_PRICE) VALUES (16, 'Pizza', 'Food/Beverage', 'Something definitely ain''t right here', 45, 12.99);


-- Adding User addresses to the store

insert into ADDRESS_LIST (EMAIL_ADDRESS, STREET, CITY, PROVINCE, COUNTRY, POSTAL_CODE) VALUES ('saeeds28', '130 Adelaide St W', 'Toronto', 'Ontario', 'Canada', 'M5H3P5');
insert into ADDRESS_LIST (EMAIL_ADDRESS, STREET, CITY, PROVINCE, COUNTRY, POSTAL_CODE) VALUES ('samad', '66 Wellington St', 'Toronto', 'Ontario', 'Canada', 'M5K1A1');


-- Adding users to the store

insert into USER_LIST (USER_NAME, PASSWORD_HASH, FIRST_NAME, LAST_NAME, USER_TYPE, EMAIL_ADDRESS) VALUES ('saeeds28','2d0587d5fbd8f92c092a788953d79e01dbb9bdb25e7bff499fa6f39fd7ca8ae2', 'Saad', 'Saeed', 'admin', 'saeeds28');
insert into USER_LIST (USER_NAME, PASSWORD_HASH, FIRST_NAME, LAST_NAME, USER_TYPE, EMAIL_ADDRESS) VALUES ('samad','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Samad', 'Saeed', 'regular', 'samad');


-- Adding purchased items to the store

insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (1, CURRENT_TIMESTAMP, 'samad', 3, 4, 5.99);
insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (2, CURRENT_TIMESTAMP, 'samad', 2, 1, 699.99);
insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (3, CURRENT_TIMESTAMP, 'samad', 4, 3, 4.99);
insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (4, CURRENT_TIMESTAMP, 'samad', 6, 1, 2099.99);
insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (5, CURRENT_TIMESTAMP, 'samad', 5, 2, 199.99);
insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (6, CURRENT_TIMESTAMP, 'samad', 9, 1, 69.99);
insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (7, CURRENT_TIMESTAMP, 'samad', 11, 1, 69.69);
insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (8, CURRENT_TIMESTAMP, 'samad', 12, 1, 39.99);
insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (9, CURRENT_TIMESTAMP, 'samad', 14, 16, 2.99);
insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (10, CURRENT_TIMESTAMP, 'samad', 16, 3, 12.99);
insert into PURCHASE_ORDER_LIST (PURCHASE_ID, PURCHASE_DATE, EMAIL_ADDRESS, PRODUCT_ID, QUANTITY, PRICE) VALUES (11, CURRENT_TIMESTAMP, 'samad', 2, 1, 699.99);