CREATE TABLE IF NOT EXISTS disease (
    id VARCHAR(255)
        CONSTRAINT disease_pk
            primary key,
    name VARCHAR(1000) NOT NULL
);