CREATE TABLE IF NOT EXISTS app_user (
    id BIGINT not null,
    name VARCHAR(255) not null,
    surname VARCHAR(255) not null,
    email VARCHAR(255) not null,
    password VARCHAR(255) not null,
    PRIMARY KEY(id)
    )