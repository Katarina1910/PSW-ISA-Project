INSERT INTO `authorities` (id, name) VALUES (1, 'ROLE_CCA');
INSERT INTO `authorities` (id, name) VALUES (2, 'ROLE_CA');
INSERT INTO `authorities` (id, name) VALUES (3, 'ROLE_DOCTOR');
INSERT INTO `authorities` (id, name) VALUES (4, 'ROLE_PATIENT');

INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username, last_password_reset_date) VALUES (1, 'Kralja Petra 42', 'Novi Sad', 'Srbija', 'pswtim2+1@gmail.com', true, 'John', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06122251251', 'ROLE_CCA', 'Doe', '0701921800150', 'admin1', '2019-12-31 00:00:00');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username, last_password_reset_date) VALUES (2, 'Jovana Obrenovica 55', 'Foca', 'BiH', 'pswtim2+2@gmail.com', true, 'Mike', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06022251232', 'ROLE_PATIENT', 'Smith', '0711951122164', 'pac1', '2019-12-31 00:00:00');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username, last_password_reset_date) VALUES (3, 'Ive Andrica 11', 'Nevesinje', 'BiH', 'pacijent2@pacijent.com', true, 'Ron', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566551288', 'ROLE_PATIENT', 'Lo', '1201986820543', 'pac2', '2019-12-31 00:00:00');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username, last_password_reset_date) VALUES (4, 'Doktora Doktorica 59', 'Novi Sad', 'Srbija', 'pswtim2+3@gmail.com', true, 'Doktorko', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566000288', 'ROLE_DOCTOR', 'Doktoric', '0206985820121', 'dok1', '2019-12-31 00:00:00');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username, last_password_reset_date) VALUES (5, 'Nevinih zrtava 13', 'Novi Sad', 'Srbija', 'doktor1@doktor.com', true, 'Blagoje', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566000288', 'ROLE_DOCTOR', 'Pantic', '0206985820121', 'dok2', '2019-12-31 00:00:00');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username, last_password_reset_date) VALUES (6, 'Simke Simica 10', 'Novi Sad', 'Srbija', 'doktor2@doktor.com', true, 'Simka', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566000288', 'ROLE_DOCTOR', 'Simic', '0206985820121', 'dok3', '2019-12-31 00:00:00');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username, last_password_reset_date) VALUES (7, 'Skolska 10', 'Nis', 'Srbija', 'pswtim2+4@gmail.com', true, 'Cadmin', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06512000288', 'ROLE_CA', 'Cadminic', '0206123820121', 'cadmin1', '2019-12-31 00:00:00');

INSERT INTO `clinic` (id, address, description, grade, name, price_list_id) VALUES (1, 'Adresa 1', 'Opis klinike1...', '4', 'klinika1', null);
INSERT INTO `clinic` (id, address, description, grade, name, price_list_id) VALUES (2, 'Adresa 2', 'Opis klinike2...', '5', 'klinika2', null);
INSERT INTO `clinic` (id, address, description, grade, name, price_list_id) VALUES (3, 'Adresa 3', 'Opis klinike3...', '4', 'klinika3', null);

INSERT INTO `doctor` (grade, type_id, id, scheduled_from, scheduled_to) VALUES (5, 1, 4, '2020-02-15 00:00:00', '2020-02-17 00:00:00');
INSERT INTO `doctor` (grade, type_id, id, scheduled_from, scheduled_to) VALUES (5, 1, 5, '2020-02-21 00:00:00', '2020-02-22 00:00:00');
INSERT INTO `doctor` (grade, type_id, id, scheduled_from, scheduled_to) VALUES (4, 2, 6, '2020-02-25 00:00:00', '2020-02-28 00:00:00');

INSERT INTO `personnel` (id, clinic_id, consult_term_id) VALUES (4, 1, 2);
INSERT INTO `personnel` (id, clinic_id, consult_term_id) VALUES (5, 2, 1);
INSERT INTO `personnel` (id, clinic_id, consult_term_id) VALUES (6, 1, 1);

INSERT INTO `clinic_administrator` (id, clinic_id) VALUES (7, 1);

INSERT INTO `room` (id, name, type, clinic_id) VALUES (1, 'room1', 0, null);
INSERT INTO `room` (id, name, type, clinic_id) VALUES (2, 'room2', 1, null);

INSERT INTO `consult_type` (id, description, name) VALUES (1, 'Opis tipa1...', 'tip1');
INSERT INTO `consult_type` (id, description, name) VALUES (2, 'Opis tipa2...', 'tip2');




INSERT INTO `consult_term` (dtype, id, date, discount, duration, price, report, clinic_id, doctor_id, patient_id, room_id, type_id, medical_record_id) VALUES ('ConsultTerm', 1, '2019-12-31 00:00:00', '5', '10', '150', null, 1, 4, 2, 2, 1, null);
INSERT INTO `consult_term` (dtype, id, date, discount, duration, price, report, clinic_id, doctor_id, patient_id, room_id, type_id, medical_record_id) VALUES ('ConsultTerm', 2, '2019-12-30 00:00:00', '10', '11', '100', null, 1, 6, 2, 1, 2, null);
INSERT INTO `consult_term` (dtype, id, date, discount, duration, price, report, clinic_id, doctor_id, patient_id, room_id, type_id, medical_record_id) VALUES ('ConsultTerm', 3, '2019-12-29 00:00:00', '15', '12', '170', null, 1, 5, 3, 2, 2, null);
INSERT INTO `consult_term` (dtype, id, date, discount, duration, price, report, clinic_id, doctor_id, patient_id, room_id, type_id, medical_record_id) VALUES ('ConsultTerm', 4, '2019-12-28 00:00:00', '20', '13', '90', null, 1, 4, 3, 1, 1, null);
INSERT INTO `consult_term` (dtype, id, date, discount, duration, price, report, clinic_id, doctor_id, patient_id, room_id, type_id, medical_record_id) VALUES ('ConsultTerm', 5, '2019-01-28 00:00:00', '60', '14', '10', null, 1, 4, 2, 1, 1, null);


INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (4, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (5, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (6, 3);

insert into room_terms (date, room_id, term1, term2, term3, term4, term5, term6) values ('2020-02-04',1,true,true,true,true,true,true);
insert into room_terms (date, room_id, term1, term2, term3, term4, term5, term6) values ('2020-02-04',2,true,true,true,true,true,true);
insert into request_for_consult (consult_term_id, date_and_time, is_accepted, patient_id, type_id) values (null,'2020-02-04', false, 3,2);

insert into doctor_terms (date, doctor_id, term1, term2, term3, term4, term5, term6) values ('2020-02-04',4,false ,true,true,true,true,true);
insert into doctor_terms (date, doctor_id, term1, term2, term3, term4, term5, term6) values ('2020-02-04',5,true ,true,true,true,true,true);
insert into doctor_terms (date, doctor_id, term1, term2, term3, term4, term5, term6) values ('2020-02-04',6,true,true,true,true,true,true);


insert into diagnosis (id, code, description, name) values (1,'001', 'opis','Upala pluca');
insert into diagnosis (id, code, description, name) values (2,'002', 'opis','Brohintis');
insert into diagnosis (id, code, description, name) values (3,'003', 'opis','Astma');

insert into medicament (id, code, description, name) values (1,'001', 'opis','Paracetamol');
insert into medicament (id, code, description, name) values (2,'002', 'opis','Brufen');
insert into medicament (id, code, description, name) values (3,'003', 'opis','Andol');


insert into medical_record (id, alergies, blood_type, diopter, height, weight) values  (1,'nema', '0','-1','180','80');
insert into medical_record (id, alergies, blood_type, diopter, height, weight) values  (2,'nema', 'A','0','190','100');


INSERT INTO `patient` (id, clinic_id, medical_record) VALUES (2, null, 1);
INSERT INTO `patient` (id, clinic_id, medical_record) VALUES (3, null, 2);

