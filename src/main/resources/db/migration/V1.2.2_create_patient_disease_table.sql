CREATE TABLE IF NOT EXISTS migrations.patient_disease (
    id UUID,
    start_date VARCHAR(255) NOT NULL,
    end_date VARCHAR(255) NOT NULL,
    prescription VARCHAR(1024),
    disease VARCHAR(255) NOT NULL,
    patient_id UUID
    PRIMARY KEY (id)
);
--GO
--
--INSERT into migrations.patient_disease (start_date, end_date, prescription, disease, disease_message);