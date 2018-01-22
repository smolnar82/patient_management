--add default groups
INSERT INTO user_group (name, note) VALUES 
('Patient', 'This group contains all patients.'),
('Doctor', 'This group contains all doctors.'),
('Admin', 'This group contains all administrators.');

--add default user
--password: 12345678
INSERT INTO users (user_name, passw, fullname, email, active) VALUES 
('admin', '25d55ad283aa400af464c76d713c07ad', 'Administrator', 'admin@patientmanagement.com', true);

--add relation of user and group
INSERT INTO user_group_relation (user_group_id, users_id)
VALUES (3, 1);