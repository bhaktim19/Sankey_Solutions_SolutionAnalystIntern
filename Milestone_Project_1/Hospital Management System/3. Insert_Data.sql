-- Inserting data into Role table
INSERT INTO Role (role_name) VALUES
('Admin'),
('Doctor'),
('Patient');

-- Inserting data into User table
INSERT INTO User (email, password, role_id) VALUES
('admin@hospital.com', 'admin@password', 1),
('john.doe@hospital.com', 'john@password', 2),
('jane.smith@hospital.com', 'jane@password', 2),
('michael.johnson@hospital.com', 'michael@password', 2),
('alice.johnson@patient.com', 'alice@password', 3),
('bob.smith@patient.com', 'bob@password', 3),
('bob.volta@patient.com', 'volta@password', 3);


-- Inserting data into Department table
INSERT INTO Department (department_name) VALUES
('Cardiology'),
('Orthopedics'),
('Neurology');

-- Inserting data into Doctor table
INSERT INTO Doctor (first_name, last_name, department_id, specialization) VALUES
('John', 'Doe', 1, 'Cardiologist'),
('Jane', 'Smith', 2, 'Orthopedic Surgeon'),
('Michael', 'Johnson', 3, 'Neurologist');

-- Inserting data into MedicalInsurance table
INSERT INTO MedicalInsurance (insurance_provider, policy_number, coverage_limits) VALUES
('ABC Insurance', 'POL123', 'Inpatient: $5000, Outpatient: $2000'),
('XYZ Insurance', 'POL456', 'Inpatient: $8000, Outpatient: $3000');
('PQR Insurance', 'POL678', 'Inpatient: $5000, Outpatient: $8000');
('WXY Insurance', 'POL908', 'Inpatient: $7800, Outpatient: $6700');

-- Inserting data into Patient table
INSERT INTO Patient (first_name, last_name, date_of_birth, gender, address, phone_number, medical_insurance_id, user_id) VALUES
('Alice', 'Johnson', '1990-05-15', 'F', '123 Main St, City', '123-456-7890', 1, 3),
('Bob', 'Smith', '1985-10-20', 'M', '456 Oak St, Town', '987-654-3210', 2, 3);
('Bob', 'Volta', '1985-10-20', 'M', '456 Main St, Town', '987-654-3210', 3, 3);

-- Inserting data into Appointment table
INSERT INTO Appointment (patient_id, doctor_id, appointment_date, appointment_time, appointment_status) VALUES
(1, 1, '2024-02-10', '09:00:00', 'Booked'),
(2, 2, '2024-02-12', '10:30:00', 'Confirmed');

INSERT INTO Diagnosis (appointment_id, doctor_id, diagnosis_code, diagnosis_description) VALUES
(1, 1, 'ICD-10-CODE-123', 'Hypertension'),
(2, 2, 'ICD-10-CODE-456', 'Fractured Arm');

-- Inserting data into Treatment table
INSERT INTO Treatment (diagnosis_id, medication_name, procedure_name, dosage, instructions) VALUES
(1, 'Lisinopril', NULL, NULL, 'Take one tablet daily'),
(2, NULL, 'Arm Cast', NULL, 'Keep arm elevated');

INSERT INTO Bill (patient_id, appointment_id, total_amount, payment_status) VALUES
(1, 1, 100.00, 'Pending'),
(2, 2, 200.00, 'Partially Paid');
