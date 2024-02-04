-- 1. Write necessary queries to register new user roles and personas 
INSERT INTO Role (role_name) VALUES ('Nurse');
INSERT INTO User (email, password, role_id) VALUES ('nurse1@hospital.com', 'nurse@password', (SELECT role_id FROM Role WHERE role_name = 'Nurse'));

-- 2. Write necessary queries to add to the list of diagnosis of the patient tagged by date.
INSERT INTO Diagnosis (appointment_id, doctor_id, diagnosis_code, diagnosis_description)
VALUES (
    (SELECT appointment_id FROM Appointment WHERE patient_id = 1 AND appointment_date = '2024-02-10'),
    1, 
    'ICD-10-CODE-123', 
    'Hypertension' 
);

-- 3. Write necessary queries to fetch required details of a particular patient.
SELECT 
    Patient.patient_id,
    Patient.first_name,
    Patient.last_name,
    Patient.date_of_birth,
    Patient.gender,
    Patient.address,
    Patient.phone_number,
    MedicalInsurance.insurance_provider,
    MedicalInsurance.policy_number,
    MedicalInsurance.coverage_limits,
    User.email
FROM 
    Patient
LEFT JOIN 
    MedicalInsurance ON Patient.medical_insurance_id = MedicalInsurance.insurance_id
LEFT JOIN 
    User ON Patient.user_id = User.user_id
WHERE 
    Patient.patient_id = 1;

-- 4. Write necessary queries to prepare bill for the patient at the end of checkout.
SELECT 
    SUM(t.total_amount) AS total_amount
FROM 
    Appointment AS a
LEFT JOIN 
    Diagnosis AS d ON a.appointment_id = d.appointment_id
LEFT JOIN 
    Treatment AS t ON d.diagnosis_id = t.diagnosis_id
WHERE 
    a.patient_id = 1; -- Replace 1 with the patient's ID
INSERT INTO Bill (patient_id, total_amount, payment_status)
VALUES 
    (1, 
    (SELECT SUM(t.total_amount) FROM Appointment AS a LEFT JOIN Diagnosis AS d ON a.appointment_id = d.appointment_id LEFT JOIN Treatment AS t ON d.diagnosis_id = t.diagnosis_id WHERE a.patient_id = 1),
    'Pending'); 

--5. Write necessary queries to fetch and show data from various related tables (Joins)
-- Fetch patient details with their diagnosis and corresponding doctor details:
SELECT 
    Patient.patient_id,
    Patient.first_name AS patient_first_name,
    Patient.last_name AS patient_last_name,
    Diagnosis.diagnosis_id,
    Diagnosis.diagnosis_code,
    Diagnosis.diagnosis_description,
    Doctor.first_name AS doctor_first_name,
    Doctor.last_name AS doctor_last_name
FROM 
    Patient
INNER JOIN 
    Appointment ON Patient.patient_id = Appointment.patient_id
INNER JOIN 
    Diagnosis ON Appointment.appointment_id = Diagnosis.appointment_id
INNER JOIN 
    Doctor ON Diagnosis.doctor_id = Doctor.doctor_id;
--Fetch appointment details with patient, doctor, and department information:
SELECT 
    Appointment.appointment_id,
    Appointment.appointment_date,
    Appointment.appointment_time,
    Patient.first_name AS patient_first_name,
    Patient.last_name AS patient_last_name,
    Doctor.first_name AS doctor_first_name,
    Doctor.last_name AS doctor_last_name,
    Department.department_name
FROM 
    Appointment
INNER JOIN 
    Patient ON Appointment.patient_id = Patient.patient_id
INNER JOIN 
    Doctor ON Appointment.doctor_id = Doctor.doctor_id
INNER JOIN 
    Department ON Doctor.department_id = Department.department_id;
--Fetch diagnosis details with patient, doctor, and appointment information:
SELECT 
    Diagnosis.diagnosis_id,
    Diagnosis.diagnosis_code,
    Diagnosis.diagnosis_description,
    Patient.first_name AS patient_first_name,
    Patient.last_name AS patient_last_name,
    Appointment.appointment_date,
    Appointment.appointment_time,
    Doctor.first_name AS doctor_first_name,
    Doctor.last_name AS doctor_last_name
FROM 
    Diagnosis
INNER JOIN 
    Appointment ON Diagnosis.appointment_id = Appointment.appointment_id
INNER JOIN 
    Patient ON Appointment.patient_id = Patient.patient_id
INNER JOIN 
    Doctor ON Diagnosis.doctor_id = Doctor.doctor_id;

--6. Optimize repeated read operations using views/materialized views.
--view to fetch patient details along with their appointment information and corresponding doctor details:
CREATE VIEW PatientAppointmentDoctor AS
SELECT 
    Patient.patient_id,
    Patient.first_name AS patient_first_name,
    Patient.last_name AS patient_last_name,
    Appointment.appointment_id,
    Appointment.appointment_date,
    Appointment.appointment_time,
    Appointment.appointment_status,
    Doctor.first_name AS doctor_first_name,
    Doctor.last_name AS doctor_last_name,
    Department.department_name
FROM 
    Patient
INNER JOIN 
    Appointment ON Patient.patient_id = Appointment.patient_id
INNER JOIN 
    Doctor ON Appointment.doctor_id = Doctor.doctor_id
INNER JOIN 
    Department ON Doctor.department_id = Department.department_id;


--7. Optimize read operations using indexing wherever required. (Create index on at least 1 table)
-- create an index on the patient_id column in the Appointment table, assuming it's frequently used for filtering appointments by patient:
CREATE INDEX idx_appointment_patient_id ON Appointment (patient_id);


--8. Try optimizing bill generation using stored procedures.
-- stored procedure to calculate and generate a bill for a given patient:
DELIMITER //

CREATE PROCEDURE GenerateBillForPatient (
    IN patient_id INT
)
BEGIN
    DECLARE total_amount DECIMAL(10, 2);
    
    -- Calculate the total amount for the patient's appointments
    SELECT SUM(total_amount)
    INTO total_amount
    FROM Appointment AS a
    LEFT JOIN Diagnosis AS d ON a.appointment_id = d.appointment_id
    LEFT JOIN Treatment AS t ON d.diagnosis_id = t.diagnosis_id
    WHERE a.patient_id = patient_id;
    
    -- Insert the calculated total amount into the Bill table
    INSERT INTO Bill (patient_id, total_amount, payment_status)
    VALUES (patient_id, total_amount, 'Pending');
    
    SELECT LAST_INSERT_ID() AS bill_id; -- Return the ID of the newly inserted bill
END //

DELIMITER ;
--To use this stored procedure, call it with the patient_id parameter:
CALL GenerateBillForPatient(1); -- 1 is the patient_id 

-- 9. Add necessary triggers to indicate when patients medical insurance limit has expired.
DELIMITER //

CREATE TRIGGER CheckInsuranceLimit
AFTER INSERT ON Bill
FOR EACH ROW
BEGIN
    DECLARE insurance_limit DECIMAL(10, 2);
    DECLARE total_billed DECIMAL(10, 2);
    
    -- Get the medical insurance coverage limit for the patient
    SELECT coverage_limits INTO insurance_limit
    FROM MedicalInsurance
    WHERE insurance_id = (
        SELECT medical_insurance_id
        FROM Patient
        WHERE patient_id = NEW.patient_id
    );
    
    -- Get the total amount billed for the patient
    SELECT SUM(total_amount) INTO total_billed
    FROM Bill
    WHERE patient_id = NEW.patient_id;
    
    -- Check if the total billed amount exceeds the insurance limit
    IF total_billed > insurance_limit THEN
        -- Update a flag or send a notification indicating that the insurance limit has expired
        UPDATE Patient
        SET insurance_limit_expired = 1 -- Assuming there's a column to store this flag
        WHERE patient_id = NEW.patient_id;
        
        -- Optionally, you can raise an error or log a message here
    END IF;
END //

DELIMITER ;

