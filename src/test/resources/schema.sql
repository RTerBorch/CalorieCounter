-- Creating table for Livsmedel
CREATE TABLE livsmedel
(
    id       BIGINT PRIMARY KEY,
    namn     VARCHAR(255),
    viktGram INT
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
CREATE TABLE account_recept
(
    account_id BIGINT,
    recept_id  BIGINT,
    PRIMARY KEY (account_id, recept_id),
    FOREIGN KEY (account_id) REFERENCES account (id),
    FOREIGN KEY (recept_id) REFERENCES recept (id)
);

-- Creating join table for Recept and Livsmedel (ManyToMany relationship)
CREATE TABLE recept_livsmedel
(
    recept_id    BIGINT,
    livsmedel_id BIGINT,
    PRIMARY KEY (recept_id, livsmedel_id),
    FOREIGN KEY (recept_id) REFERENCES recept (id),
    FOREIGN KEY (livsmedel_id) REFERENCES livsmedel (id)
);
