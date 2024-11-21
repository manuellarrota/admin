INSERT INTO practica_user (id, last_name, mail, name, nickname, password )
VALUES (1, 'Apellido', 'mail@mail.com', 'Nombre', 'nombreUsuario', 'clave'),
(2, 'Due', 'jhon2@mail.com', 'Jhon', 'jhondue2', 'clavejhondue'),
(3, 'Due', 'jhon3@mail.com', 'Jhon', 'jhondue3', 'clavejhondue'),
(4, 'Due', 'jhon4@mail.com', 'Jhon', 'jhondue4', 'clavejhondue'),
(5, 'Due', 'jhon5@mail.com', 'Jhon', 'jhondue5', 'clavejhondue'),
(6, 'Due', 'jhon6@mail.com', 'Jhon', 'jhondue6', 'clavejhondue'),
(7, 'Due', 'jhon7@mail.com', 'Jhon', 'jhondue7', 'clavejhondue'),
(8, 'Due', 'jhon8@mail.com', 'Jhon', 'jhondue8', 'clavejhondue'),
(9, 'Due', 'jhon9@mail.com', 'Jhon', 'jhondue9', 'clavejhondue'),
(10, 'Due', 'jhon10@mail.com', 'Jhon', 'jhondue10', 'clavejhondue'),
(11, 'Due', 'jhon11@mail.com', 'Jhon', 'jhondue11', 'clavejhondue'),
(12, 'Due', 'jhon12@mail.com', 'Jhon', 'jhondue12', 'clavejhondue');

INSERT INTO practica_role (id, name) VALUES (1,'ROLE_USER'), (2,'ROLE_MODERATOR'),(3,'ROLE_ADMIN');

INSERT INTO practica_user_roles (role_id, user_id) VALUES (1,1), (2,2),(3,3);