CREATE TABLE IF NOT EXISTS migrations.patient (
    id BIGINT,
    surname VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),
    gender VARCHAR(255) NOT NULL,
    birthday VARCHAR(255) NOT NULL,
    police_oms BIGINT NOT NULL,
    hireDate VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
--Go

--CREATE FUNCTION save()
--AS $$
--   BEGIN
--    INSERT into migrations.patient (patient);
--  END;
--$$ LANGUAGE plpgsql;
