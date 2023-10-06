-- Account Inserts
INSERT INTO Account (id, password, role, username) VALUES (1, '$2a$10$nhEpjymRAFsvpoimCZ92BeQBHSwk01FiYUFPal.vbmMtBjr/1MODO','ADMIN','admin');
INSERT INTO Account (id, password, role, username) VALUES (2, '$2a$10$WYbfVpShvv0WHspIisedI.FVJHeQ0JuJhGRa778u/jzMuvcqoD3B6','USER','user');


-- Recipe Inserts
INSERT INTO recept (id, namn) VALUES (1,'lasagne');
INSERT INTO recept (id, namn) VALUES (2,'bolognese');
INSERT INTO recept (id, namn) VALUES (3, 'pannkaka');
INSERT INTO recept (id, namn) VALUES (4, 'bolognese');
INSERT INTO recept (id, namn) VALUES (5, 'pizza');

-- Ingredients for the recipes
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (1, 'pasta', 150);
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (2, 'meat', 120);
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (3, 'ägg', 50);
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (4, 'mjöl', 100);
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (5, 'mjölk', 200);
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (6, 'pasta', 150);
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (7, 'köttfärs', 120);
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (8, 'tomatsås', 150);
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (9, 'skinka', 100);
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (10, 'ost', 100);

-- Näringsvärde for the ingredients
-- For pasta
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (1, 'fett', 36, 'g', 1);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (2, 'protein', 77, 'g', 1);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (3, 'kolhydrater', 80, 'g', 1);

-- For meat
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (4, 'fett', 20, 'g', 2);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (5, 'protein', 33, 'g', 2);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (6, 'kolhydrater', 99, 'g', 2);

-- For ägg
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (7, 'fett', 5, 'g', 3);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (8, 'protein', 6, 'g', 3);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (9, 'kolhydrater', 1, 'g', 3);

-- For mjöl
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (10, 'fett', 1, 'g', 4);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (11, 'protein', 10, 'g', 4);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (12, 'kolhydrater', 74, 'g', 4);

-- For mjölk
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (13, 'fett', 3.3, 'g', 5);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (14, 'protein', 3.4, 'g', 5);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (15, 'kolhydrater', 4.8, 'g', 5);

-- For köttfärs
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (16, 'fett', 17, 'g', 7);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (17, 'protein', 27, 'g', 7);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (18, 'kolhydrater', 0, 'g', 7);

-- For tomatsås
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (19, 'fett', 0.2, 'g', 8);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (20, 'protein', 1.2, 'g', 8);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (21, 'kolhydrater', 5.7, 'g', 8);

-- For skinka
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (22, 'fett', 3, 'g', 9);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (23, 'protein', 21, 'g', 9);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (24, 'kolhydrater', 0.3, 'g', 9);

-- For ost
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (25, 'fett', 25, 'g', 10);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (26, 'protein', 32, 'g', 10);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (27, 'kolhydrater', 1.3, 'g', 10);

-- Populating the join tables
INSERT INTO account_recept_list(accounts_id, recept_list_id) VALUES (1,1);
INSERT INTO account_recept_list (accounts_id, recept_list_id) VALUES (1,2);
INSERT INTO account_recept_list (accounts_id, recept_list_id) VALUES (2,1);

-- For lasagne
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (1,1);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (1,2);

-- For bolognese
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (2,1);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (2,2);

-- For pannkaka
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (3,3);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (3,4);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (3,5);

-- For bolognese
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (4,6);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (4,7);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (4,8);

-- For pizza
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (5,8);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (5,4);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (5,9);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (5,10);
