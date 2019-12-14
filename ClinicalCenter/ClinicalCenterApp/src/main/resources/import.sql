INSERT INTO `authorities` (id, name) VALUES (1, 'PATIENT');
INSERT INTO `authorities` (id, name) VALUES (2, 'ADMIN');

INSERT INTO `user` (id, address, city, country, email, is_activated, name, password, phone, role, surname, ucidn, username) VALUES (1, 'Kralja Petra 11', 'Novi Sad', 'Srbija', 'wadeyix946@mailfile.org', true, 'John', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06122251251', 'PATIENT', 'Doe', '0701921800150', 'pac1');

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 1);
