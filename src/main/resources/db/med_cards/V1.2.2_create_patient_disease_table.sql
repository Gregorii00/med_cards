CREATE TABLE IF NOT EXISTS med_cards.patient_disease (
    id UUID,
    start_date date NOT NULL,
    end_date date NOT NULL,
    prescription VARCHAR(1024),
    disease VARCHAR(255) NOT NULL,
    patient_id UUID,
    disease_id VARCHAR(255)
    PRIMARY KEY (id)
);