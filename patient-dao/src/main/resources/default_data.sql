--add default groups
INSERT INTO user_group (name, note) VALUES 
('Patient', 'This group contains all patients.'),
('Doctor', 'This group contains all doctors.'),
('Admin', 'This group contains all administrators.');

--add default: admin
--password: admin
INSERT INTO users (user_name, passw, fullname, email, active) VALUES 
('admin', '$2a$10$sGFpzGonliuBnA5cdtduNu/9fYFi5ixVio0PAoGBFFvultAjz4p5m', 'Administrator', 'admin@patientmanagement.com', true);

--add relation of user and group
INSERT INTO user_group_relation (user_group_id, users_id)
VALUES (3, 1);