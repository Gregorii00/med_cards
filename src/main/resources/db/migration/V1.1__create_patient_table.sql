CREATE TABLE IF NOT EXISTS patient (
    id UUID
        CONSTRAINT patient_pk
            primary key,
    surname VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),
    gender VARCHAR(255) NOT NULL,
    birthday TIMESTAMP NOT NULL,
    police_oms BIGINT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);