INSERT INTO `authorities` (id, name) VALUES (1, 'ADMIN');
INSERT INTO `authorities` (id, name) VALUES (2, 'PATIENT');
INSERT INTO `authorities` (id, name) VALUES (3, 'DOCTOR');

INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (1, 'Kralja Petra 42', 'Novi Sad', 'Srbija', 'wadeyix946@mailfile.org', true, 'John', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06122251251', 'ADMIN', 'Doe', '0701921800150', 'adm1');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (2, 'Jovana Obrenovica 55', 'Foca', 'BiH', 'pacijent@pacijent.com', true, 'Mike', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06022251232', 'PATIENT', 'Smith', '0711951122164', 'pac1');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (3, 'Ive Andrica 11', 'Nevesinje', 'BiH', 'pacijent2@pacijent.com', true, 'Ron', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566551288', 'PATIENT', 'Lo', '1201986820543', 'pac2');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (4, 'Doktora Doktorica 59', 'Novi Sad', 'Srbija', 'doktor@doktor.com', true, 'Doktorko', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566000288', 'DOCTOR', 'Doktoric', '0206985820121', 'dok1');

INSERT INTO `clinic` (id, address, description, grade, name, price_list_id) VALUES (1, 'Adresa 1', 'Opsise klinike1...', '4', 'klinika1', null);
INSERT INTO `clinic` (id, address, description, grade, name, price_list_id) VALUES (2, 'Adresa 2', 'Opsise klinike2...', '5', 'klinika2', null);
INSERT INTO `clinic` (id, address, description, grade, name, price_list_id) VALUES (3, 'Adresa 3', 'Opsise klinike3...', '4', 'klinika3', null);

INSERT INTO `doctor` (grade, id) VALUES (0, 4);
INSERT INTO `personnel` (id, clinic_id, consult_term_id) VALUES (4, 1, 1);

INSERT INTO `room` (id, is_free, name, type, clinic_id) VALUES (1, 1, 'room1', 0, null);
INSERT INTO `room` (id, is_free, name, type, clinic_id) VALUES (2, 1, 'room2', 1, null);

INSERT INTO `consult_type` (id, description, name) VALUES (1, 'Opis tipa...', 'tip1');



INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (4, 3);

