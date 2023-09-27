INSERT INTO account (id, password, role, username) VALUES (1, 'password1','ADMIN','testUser1');
INSERT INTO account (id, password, role, username) VALUES (2, 'password2','USER','testUser2');
INSERT INTO recept  (id, namn) VALUES (1,'lasagne');
INSERT INTO recept  (id, namn) VALUES (2,'bolognese');
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (1, 'pasta', 150);
INSERT INTO livsmedel (id, namn, vikt_gram) VALUES (2, 'meat', 120);

-- Näringsvärde produkt 1
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (1, 'fett', 36, 'g', 1);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (2, 'protein', 77, 'g', 1);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (3, 'kolhydrater', 80, 'g', 1);

-- Näringsvärde produkt 2
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (4, 'fett', 20, 'g', 2);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (5, 'protein', 33, 'g', 2);
INSERT INTO naringsvarde (id, namn, varde, enhet, livsmedel_id) VALUES (6, 'kolhydrater', 99, 'g', 2);

-- Populating the join tables
INSERT INTO account_recept_list(accounts_id, recept_list_id) VALUES (1,1);
INSERT INTO account_recept_list (accounts_id, recept_list_id) VALUES (1,2);
INSERT INTO account_recept_list (accounts_id, recept_list_id) VALUES (2,1);

-- Recipe 1
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (1,1);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (1,2);
-- Recipe 2
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (2,1);
INSERT INTO recept_ingredients (recipes_id, ingredients_id) VALUES (2,2);
