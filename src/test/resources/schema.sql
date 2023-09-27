-- Creating table for Livsmedel
CREATE TABLE livsmedel
(
    id       BIGINT PRIMARY KEY,
    namn     VARCHAR(255),
    vikt_gram INT
);

-- Creating table for Naringsvarde
CREATE TABLE naringsvarde
(
    id           BIGINT PRIMARY KEY,
    namn         VARCHAR(255),
    varde        DOUBLE,
    enhet        VARCHAR(255),
    livsmedel_id BIGINT,
    FOREIGN KEY (livsmedel_id) REFERENCES livsmedel (id)
);

-- Creating table for Account
CREATE TABLE account
(
    id       BIGINT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role     VARCHAR(255)
);

-- Creating table for Recept
CREATE TABLE recept
(
    id   BIGINT PRIMARY KEY,
    namn VARCHAR(255)
);

-- Creating join table for Account and Recept (ManyToMany relationship)
CREATE TABLE account_recept_list
(
    accounts_id BIGINT,
    recept_list_id  BIGINT,
    PRIMARY KEY (accounts_id, recept_list_id),
    FOREIGN KEY (accounts_id) REFERENCES account (id),
    FOREIGN KEY (recept_list_id) REFERENCES recept (id)
);

-- Creating join table for Recept and Livsmedel (ManyToMany relationship)
CREATE TABLE recept_ingredients
(
    recipes_id    BIGINT,
    ingredients_id BIGINT,
    PRIMARY KEY (recipes_id, ingredients_id),
    FOREIGN KEY (recipes_id) REFERENCES recept (id),
    FOREIGN KEY (ingredients_id) REFERENCES livsmedel (id)
);
