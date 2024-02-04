-- Creating the required tables

CREATE TABLE Patient (
  patient_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  date_of_birth DATE NOT NULL,
  gender ENUM('M', 'F', 'O') NOT NULL,
  address VARCHAR(255),
  phone_number VARCHAR(20),
  medical_insurance_id INT,
  user_id INT,
  FOREIGN KEY (medical_insurance_id) REFERENCES MedicalInsurance(insurance_id),
  FOREIGN KEY (user_id) REFERENCES User(user_id)
);

CREATE TABLE User (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (role_id) REFERENCES Role(role_id)
);

CREATE TABLE Role (
  role_id INT AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE Department (
  department_id INT AUTO_INCREMENT PRIMARY KEY,
  department_name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Doctor (
  doctor_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  department_id INT NOT NULL,
  specialization VARCHAR(255),
  FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

CREATE TABLE MedicalInsurance (
  insurance_id INT AUTO_INCREMENT PRIMARY KEY,
  insurance_provider VARCHAR(255) NOT NULL,
  policy_number VARCHAR(255) NOT NULL,
  coverage_limits VARCHAR(255)
);

CREATE TABLE Appointment (
  appointment_id INT AUTO_INCREMENT PRIMARY KEY,
  patient_id INT NOT NULL,
  doctor_id INT NOT NULL,
  appointment_date DATE NOT NULL,
  appointment_time TIME NOT NULL,
  appointment_status ENUM('Booked', 'Confirmed', 'Cancelled', 'Completed'),
  FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
  FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);



CREATE TABLE Diagnosis (
  diagnosis_id INT AUTO_INCREMENT PRIMARY KEY,
  appointment_id INT NOT NULL,
  doctor_id INT NOT NULL,
  diagnosis_code VARCHAR(255) NOT NULL,
  diagnosis_description VARCHAR(255),
  FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id),
  FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE Treatment (
  treatment_id INT AUTO_INCREMENT PRIMARY KEY,
  diagnosis_id INT NOT NULL,
  medication_name VARCHAR(255),
  procedure_name VARCHAR(255),
  dosage VARCHAR(255),
  instructions VARCHAR(255),
  FOREIGN KEY (diagnosis_id) REFERENCES Diagnosis(diagnosis_id)
);

CREATE TABLE Bill (
  bill_id INT AUTO_INCREMENT PRIMARY KEY,
  patient_id INT NOT NULL,
  appointment_id INT,
  total_amount DECIMAL(10,2) NOT NULL,
  payment_status ENUM('Pending', 'Partially Paid', 'Paid'),
  FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
  FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id)
);
