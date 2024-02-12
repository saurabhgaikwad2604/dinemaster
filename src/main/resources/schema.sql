CREATE TABLE IF NOT EXISTS restaurant(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    address VARCHAR(255),
    cuisinetype VARCHAR(255),
    rating INT
);

CREATE TABLE IF NOT EXISTS chef(
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    expertise VARCHAR(255),
    experienceYears INT,
    restaurantId INT,
    FOREIGN KEY (restaurantId) REFERENCES restaurant(id)
);