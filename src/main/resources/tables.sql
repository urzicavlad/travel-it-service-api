DROP TABLE IF EXISTS recommendations;
DROP TABLE IF EXISTS cities;
DROP TABLE IF EXISTS countries;

CREATE TABLE countries
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    code VARCHAR(2) NOT NULL,
    flag VARCHAR(5000) NOT NULL
);

CREATE TABLE cities
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(250) NOT NULL,
    description VARCHAR(5000) NOT NULL,
    country_id  VARCHAR(250) NOT NULL
);

CREATE TABLE recommendations
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(250) NOT NULL,
    address     VARCHAR(250) NOT NULL,
    description VARCHAR(5000) NOT NULL,
    city_id     VARCHAR(250) NOT NULL
);

ALTER TABLE cities
    ADD FOREIGN KEY (country_id)
        REFERENCES countries(id);

ALTER TABLE recommendations
    ADD FOREIGN KEY (city_id)
        REFERENCES cities(id);
