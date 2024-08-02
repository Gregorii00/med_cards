CREATE TABLE IF NOT EXISTS migrations.patient (
    id UUID,
    surname VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),
    gender VARCHAR(255) NOT NULL,
    birthday VARCHAR(255) NOT NULL,
    police_oms BIGINT NOT NULL,
    hireDate date NOT NULL,
    PRIMARY KEY (id)
);