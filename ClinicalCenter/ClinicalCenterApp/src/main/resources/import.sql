INSERT INTO `authorities` (id, name) VALUES (1, 'ADMIN');
INSERT INTO `authorities` (id, name) VALUES (2, 'PATIENT');
INSERT INTO `authorities` (id, name) VALUES (3, 'DOCTOR');

INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (1, 'Kralja Petra 42', 'Novi Sad', 'Srbija', 'wadeyix946@mailfile.org', true, 'John', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06122251251', 'ADMIN', 'Doe', '0701921800150', 'adm1');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (2, 'Jovana Obrenovica 55', 'Foca', 'BiH', 'pacijent@pacijent.com', true, 'Mike', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06022251232', 'PATIENT', 'Smith', '0711951122164', 'pac1');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (3, 'Ive Andrica 11', 'Nevesinje', 'BiH', 'pacijent2@pacijent.com', true, 'Ron', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566551288', 'PATIENT', 'Lo', '1201986820543', 'pac2');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (4, 'Doktora Doktorica 59', 'Novi Sad', 'Srbija', 'doktor@doktor.com', true, 'Doktorko', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566000288', 'DOCTOR', 'Doktoric', '0206985820121', 'dok1');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (5, 'Nevinih zrtava 13', 'Novi Sad', 'Srbija', 'doktor1@doktor.com', true, 'Blagoje', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566000288', 'DOCTOR', 'Pantic', '0206985820121', 'dok2');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (6, 'Simke Simica 10', 'Novi Sad', 'Srbija', 'doktor2@doktor.com', true, 'Simka', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566000288', 'DOCTOR', 'Simic', '0206985820121', 'dok3');

INSERT INTO `clinic` (id, address, description, grade, name, price_list_id) VALUES (1, 'Adresa 1', 'Opis klinike1...', '4', 'klinika1', null);
INSERT INTO `clinic` (id, address, description, grade, name, price_list_id) VALUES (2, 'Adresa 2', 'Opis klinike2...', '5', 'klinika2', null);
INSERT INTO `clinic` (id, address, description, grade, name, price_list_id) VALUES (3, 'Adresa 3', 'Opis klinike3...', '4', 'klinika3', null);

INSERT INTO `doctor` (grade, type_id, id) VALUES (5, 1, 4);
INSERT INTO `doctor` (grade, type_id, id) VALUES (5, 1, 5);
INSERT INTO `doctor` (grade, type_id, id) VALUES (4, 2, 6);
INSERT INTO `personnel` (id, clinic_id, consult_term_id) VALUES (4, 1, 2);
INSERT INTO `personnel` (id, clinic_id, consult_term_id) VALUES (5, 2, 1);
INSERT INTO `personnel` (id, clinic_id, consult_term_id) VALUES (6, 1, 1);

INSERT INTO `room` (id, is_free, name, type, clinic_id) VALUES (1, 1, 'room1', 0, null);
INSERT INTO `room` (id, is_free, name, type, clinic_id) VALUES (2, 1, 'room2', 1, null);

INSERT INTO `consult_type` (id, description, name) VALUES (1, 'Opis tipa1...', 'tip1');
INSERT INTO `consult_type` (id, description, name) VALUES (2, 'Opis tipa2...', 'tip2');

INSERT INTO `consult_term` (dtype, id, date, discount, duration, price, report, clinic_id, doctor_id, patient_id, room_id, type_id, medical_record_id) VALUES ('ConsultTerm', 1, '2019-12-31 00:00:00', '5', '10', '150', null, null, 4, null, 2, 1, null);
INSERT INTO `consult_term` (dtype, id, date, discount, duration, price, report, clinic_id, doctor_id, patient_id, room_id, type_id, medical_record_id) VALUES ('ConsultTerm', 2, '2019-12-30 00:00:00', '10', '11', '100', null, null, 6, null, 1, 2, null);
INSERT INTO `consult_term` (dtype, id, date, discount, duration, price, report, clinic_id, doctor_id, patient_id, room_id, type_id, medical_record_id) VALUES ('ConsultTerm', 3, '2019-12-29 00:00:00', '15', '12', '170', null, null, 5, null, 2, 2, null);
INSERT INTO `consult_term` (dtype, id, date, discount, duration, price, report, clinic_id, doctor_id, patient_id, room_id, type_id, medical_record_id) VALUES ('ConsultTerm', 4, '2019-12-28 00:00:00', '20', '13', '90', null, null, 4, null, 1, 1, null);

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (4, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (5, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (6, 3);

