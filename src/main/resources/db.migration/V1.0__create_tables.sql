CREATE TABLE users
(
    user_id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    username       VARCHAR(255) NOT NULL,
    first_name     VARCHAR(255),
    last_name      VARCHAR(255),
    address        JSON,
    prefered_flags JSON
);

CREATE TABLE venues
(
    venue_id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    venue_name       VARCHAR(255) NOT NULL,
    city             VARCHAR(255),
    state            VARCHAR(255),
    seating_capacity INT
);

CREATE TABLE categories
(
    category_id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_group       VARCHAR(255) NOT NULL,
    category_name        VARCHAR(255) NOT NULL,
    category_description VARCHAR(500)
);

CREATE TABLE dates
(
    date_id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    calendar_date VARCHAR(10) NOT NULL,
    day           VARCHAR(2),
    week          INT,
    month         VARCHAR(3),
    quarter       INT,
    year          INT,
    holiday_flag  BOOLEAN
);

CREATE TABLE listings
(
    listing_id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    seller_id         BIGINT            NOT NULL,
    event_id          BIGINT            NOT NULL,
    date_id           BIGINT            NOT NULL,
    number_of_tickets INT            NOT NULL,
    price_per_ticket  DECIMAL(10, 2) NOT NULL,
    total_price       DECIMAL(10, 2) NOT NULL,
    listing_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_seller FOREIGN KEY (seller_id) REFERENCES users (user_id),
    CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES users (user_id),
    CONSTRAINT fk_date FOREIGN KEY (date_id) REFERENCES dates (date_id)
);

