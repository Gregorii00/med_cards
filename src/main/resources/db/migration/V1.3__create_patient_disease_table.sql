CREATE TABLE IF NOT EXISTS patient_disease (
    id UUID
        CONSTRAINT patient_disease_pk
            primary key,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    prescription VARCHAR(1024),
    patient_id UUID NOT NULL
            references patient(id),
    disease_id VARCHAR(255) NOT NULL
            REFERENCES  disease(id)
);