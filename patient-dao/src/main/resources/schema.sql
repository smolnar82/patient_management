-- ------------------------------------------------------------
-- This table content all users who can be use this system. Here are all doctors and all patient. All users are in one or more group. These groups represent that who is doctor or patient.
-- ------------------------------------------------------------

CREATE TABLE users (
  id SERIAL  NOT NULL ,
  user_name VARCHAR(45)   NOT NULL ,
  passw VARCHAR(40)   NOT NULL ,
  fullname VARCHAR(255)    ,
  email VARCHAR(128)    ,
  active BOOL  DEFAULT false NOT NULL ,
  created_date TIMESTAMP  DEFAULT NOW() NOT NULL   ,
PRIMARY KEY(id)      );


CREATE INDEX users_index1112 ON users (created_date);
CREATE INDEX users_index1186 ON users (user_name);
CREATE UNIQUE INDEX udx_users_index1232 ON users (user_name, passw);










-- ------------------------------------------------------------
-- This table content the all users groups. These groups represent the permissions and that what kind of functions are available.
-- ------------------------------------------------------------

CREATE TABLE user_group (
  id SERIAL  NOT NULL ,
  name VARCHAR(50)   NOT NULL ,
  note VARCHAR(300)    ,
  created_date TIMESTAMP  DEFAULT NOW() NOT NULL   ,
PRIMARY KEY(id)    );


CREATE INDEX user_group_index1120 ON user_group (created_date);
CREATE INDEX user_group_index1188 ON user_group (name);







CREATE TABLE session_list (
  id SERIAL  NOT NULL ,
  user_id BIGINT   NOT NULL ,
  ip VARCHAR(45)   NOT NULL ,
  user_agent VARCHAR(200)    ,
  disabled BOOL    ,
  created_date TIMESTAMP      ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(user_id)
    REFERENCES users(id));


CREATE INDEX session_list_FKIndex1 ON session_list (user_id);


CREATE INDEX IFK_rel_users_session ON session_list (user_id);


-- ------------------------------------------------------------
-- In this table can be define that the user is doctor or patient. Of course can be create another groups relation, too.
-- ------------------------------------------------------------

CREATE TABLE user_group_relation (
  user_group_id BIGINT   NOT NULL ,
  users_id BIGINT   NOT NULL ,
  created_date TIMESTAMP  DEFAULT NOW() NOT NULL   ,
PRIMARY KEY(user_group_id, users_id)        ,
  FOREIGN KEY(users_id)
    REFERENCES users(id),
  FOREIGN KEY(user_group_id)
    REFERENCES user_group(id));


CREATE INDEX user_group_relation_FKIndex1 ON user_group_relation (users_id);
CREATE INDEX user_group_relation_FKIndex2 ON user_group_relation (user_group_id);
CREATE UNIQUE INDEX udx_userg_rel_gruop_user ON user_group_relation (user_group_id, users_id);
CREATE INDEX user_group_relation_index1126 ON user_group_relation (created_date);



CREATE INDEX IFK_rel_user_group_relation ON user_group_relation (users_id);
CREATE INDEX IFK_rel_user_group_group_relat ON user_group_relation (user_group_id);


-- ------------------------------------------------------------
-- This is a schedule table. Here can be recorded when the doctor will meet with patient.
-- ------------------------------------------------------------

CREATE TABLE appointment_table (
  id SERIAL  NOT NULL ,
  doctor_id BIGINT   NOT NULL ,
  patient_id BIGINT   NOT NULL ,
  appointment DATETIME   NOT NULL ,
  description VARCHAR(300)    ,
  sid BIGINT   NOT NULL   ,
PRIMARY KEY(id)        ,
  FOREIGN KEY(doctor_id)
    REFERENCES users(id),
  FOREIGN KEY(patient_id)
    REFERENCES users(id),
  FOREIGN KEY(sid)
    REFERENCES session_list(id));


CREATE INDEX appointment_table_FKIndex1 ON appointment_table (doctor_id);
CREATE INDEX appointment_table_FKIndex2 ON appointment_table (patient_id);
CREATE UNIQUE INDEX udx_appointment_tab_doctor_patient ON appointment_table (doctor_id, appointment);
CREATE INDEX appointment_table_FKIndex3 ON appointment_table (sid);



CREATE INDEX IFK_rel_user_doctor_appointmen ON appointment_table (doctor_id);
CREATE INDEX IFK_rel_user_patient_appointme ON appointment_table (patient_id);
CREATE INDEX IFK_rel_appointment_session ON appointment_table (sid);


CREATE TABLE appointment_notes (
  id SERIAL  NOT NULL ,
  appointment_id BIGINT   NOT NULL ,
  note VARCHAR(30)    ,
  sid BIGINT   NOT NULL   ,
PRIMARY KEY(id)      ,
  FOREIGN KEY(appointment_id)
    REFERENCES appointment_table(id),
  FOREIGN KEY(sid)
    REFERENCES session_list(id));


CREATE INDEX appointment_tags_index1176 ON appointment_notes (appointment_id);
CREATE INDEX appointment_notes_FKIndex1 ON appointment_notes (sid);
CREATE INDEX appointment_notes_FKIndex2 ON appointment_notes (appointment_id);


CREATE INDEX IFK_rel_appointment_note ON appointment_notes (appointment_id);
CREATE INDEX IFK_rel_note_session ON appointment_notes (sid);


-- ------------------------------------------------------------
-- This table contains all modify of main table(schedule_table). So we can restore or recheck previous data, that changed by doctors. We load contents with trigger, so don't manipulate with manual.
-- ------------------------------------------------------------

CREATE TABLE mod_appointment_table (
  id SERIAL  NOT NULL ,
  appointment_id BIGINT   NOT NULL ,
  mod_type CHAR(1)   NOT NULL ,
  mod_created_date TIMESTAMP  DEFAULT NOW() NOT NULL ,
  mod_sid BIGINT   NOT NULL ,
  doctor_id BIGINT    ,
  patient_id BIGINT    ,
  appointment DATETIME    ,
  description VARCHAR(300)    ,
  sid BIGINT   NOT NULL   ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(sid)
    REFERENCES session_list(id));


CREATE INDEX mod_schedule_table_FKIndex1 ON mod_appointment_table (appointment_id);
CREATE INDEX mod_appointment_table_FKIndex2 ON mod_appointment_table (sid);




CREATE INDEX IFK_rel_appointment_table_modi ON mod_appointment_table (appointment_id);
CREATE INDEX IFK_rel_mod_appointment_sessio ON mod_appointment_table (sid);

-- ------------------------------------------------------------
-- triggers
-- ------------------------------------------------------------
CREATE TRIGGER IF NOT EXISTS zzz_utg_appointment_table 
AFTER UPDATE
ON appointment_table 
FOR EACH ROW CALL "hu.kuncystem.patient.triggers.ModAppointment";

CREATE TRIGGER IF NOT EXISTS zzz_dtg_appointment_table 
AFTER DELETE
ON appointment_table 
FOR EACH ROW CALL "hu.kuncystem.patient.triggers.ModAppointment";
