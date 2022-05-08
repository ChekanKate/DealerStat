CREATE DATABASE IF NOT EXISTS dealerStat;
USE dealerStat;

DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS game_object;
DROP TABLE IF EXISTS comment;

CREATE TABLE IF NOT EXISTS game (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY(id)
    );

CREATE TABLE IF NOT EXISTS role (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY(id)
    );

CREATE TABLE IF NOT EXISTS user (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    password VARCHAR(100),
    email VARCHAR(50),
    activation_code VARCHAR(5),
    created_at DATETIME,
    PRIMARY KEY(id)
    );

CREATE TABLE IF NOT EXISTS user_role (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS game_object (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100),
    text TEXT,
    price DECIMAL,
    is_approved TINYINT(1),
    created_at DATETIME,
    updated_at DATETIME,
    game_id INT,
    user_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS comment (
    id INT NOT NULL AUTO_INCREMENT,
    message TEXT,
    rate SMALLINT,
    created_at DATETIME,
    approved TINYINT(1),
    post_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY (post_id) REFERENCES game_object(id) ON DELETE CASCADE
    );

INSERT INTO game (id, name) VALUES
    (101, 'Minecraft'),
    (102, 'Fifa'),
    (103, 'GTA');

INSERT INTO role (id, name) VALUES
    (201, 'TRADER'),
    (202, 'ADMIN');

INSERT INTO user (id, first_name, last_name, password, email, activation_code, created_at) VALUES
    (301, 'Kateryna', 'Chekan', 'kateadmin', 'chekankate@gmail.com', 12345, '2022-04-17 15:30:00'),
    (302, 'Tom', 'Smith', 'trader', 'trader@gmail.com', 54321, '2022-04-17 15:36:00');

INSERT INTO user_role (user_id, role_id) VALUES
    (301, 202),
    (302, 201);

INSERT INTO game_object (id, title, text, price, is_approved, created_at, updated_at, game_id, user_id) VALUES
    (401, 'GTA', 'Experience Rockstar Games critically acclaimed open world game, Grand Theft Auto V.', 350, 0, '2022-04-17 15:30:00', '2022-04-17 18:30:00', 103, 302);

INSERT INTO comment (id, message, rate, created_at, approved, post_id) VALUES
    (501, 'Good game', 8, '2022-04-17 22:36:00', 0, 401);
