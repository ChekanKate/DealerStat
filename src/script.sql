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
    (103, 'GTA'),
    (104, 'Among us');

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


INSERT INTO game_object (id, title, text, price, is_approved, created_at, updated_at, game_id, user_id) VALUES
    (402, 'Fifa 22', 'Video game simulator of football, published by Electronic Arts. This is the 29th part of the FIFA series, which was released worldwide on October 1, 2021.', 220, 0, '2022-03-23 11:54:00', '2022-03-23 11:54:00', 102, 302),
    (403, 'Fifa 20', 'A football imitation of a video game published by Electronic Arts as part of the FIFA series. This is the 27th category in the FIFA series and was released on September 27, 2019.', 175, 0, '2021-04-11 10:03:00', '2021-04-11 10:03:00', 102, 301),
    (404, 'Minecraft', 'Prepare for an adventure of limitless possibilities as you build, mine, battle mobs, and explore the ever-changing Minecraft landscape.', 400, 0, '2022-03-28 19:44:00', '2022-03-28 19:44:00', 101, 302),
    (405, 'Among Us', 'The game is performed in a space environment. The goal of civilians is to find impostors and neutralize them, and the goal of imposters is to kill all civilians.', 310, 0, '2022-01-07 13:51:00', '2022-01-07 13:51:00', 103, 301);

INSERT INTO game (id, name) VALUES
                                (104, 'Among us');