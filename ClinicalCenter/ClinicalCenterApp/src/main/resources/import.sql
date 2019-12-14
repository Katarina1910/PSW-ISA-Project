INSERT INTO `authorities` (id, name) VALUES (1, 'ADMIN');
INSERT INTO `authorities` (id, name) VALUES (2, 'PATIENT');

INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (1, 'Kralja Petra 42', 'Novi Sad', 'Srbija', 'wadeyix946@mailfile.org', true, 'John', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06122251251', 'ADMIN', 'Doe', '0701921800150', 'adm1');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (2, 'Jovana Obrenovica 55', 'Foca', 'BiH', 'email@gmail.com', true, 'Mike', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06022251232', 'PATIENT', 'Smith', '0711951122164', 'pac1');
INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (3, 'Ive Andrica 11', 'Nevesinje', 'BiH', 'email@gmail.com', true, 'Ron', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566551288', 'PATIENT', 'Lo', '1201986820543', 'pac2');

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 2);
