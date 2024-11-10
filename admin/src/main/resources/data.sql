INSERT INTO rol ( nombre) VALUES ('ADMIN');
INSERT INTO rol ( nombre) VALUES ('USER');
INSERT INTO rol ( nombre) VALUES ('CUSTOMER');


INSERT INTO usuario ( nombre, email, contrasena, rol_id) VALUES
    ( 'El Admin Manu', 'admin@admin.com', '$2a$10$mlIQySVRg9ySl.XMuoL/YeZ9NcZgCIm3OF7ty/l0C.KgyLKvhj.3C', 1);

INSERT INTO usuario ( nombre, email, contrasena, rol_id) VALUES
    ( 'usuario', 'user@admin.com', '$2a$10$mlIQySVRg9ySl.XMuoL/YeZ9NcZgCIm3OF7ty/l0C.KgyLKvhj.3C', 2),
    ( 'El Usuario Manu', 'manuser@admin.com', '$2a$10$mlIQySVRg9ySl.XMuoL/YeZ9NcZgCIm3OF7ty/l0C.KgyLKvhj.3C', 2);


INSERT INTO menu (name, url, icon) VALUES ('Dashboard', '/dashboard', 'icon');
INSERT INTO menu (name, url, icon) VALUES ('Usuarios', '/user', 'icon');
INSERT INTO menu (name, url, icon) VALUES ('Roles', '/role', 'icon');
INSERT INTO menu (name, url, icon) VALUES ('Menu', '/menu', 'icon');

-- 3. Insertar relaciones entre menús y roles en la tabla intermedia 'menu_roles'
-- Supongamos que 'Dashboard' tiene id=1, 'Usuarios' tiene id=2, 'USER' tiene id=1 y 'ADMIN' tiene id=2
-- (Estos valores dependen de cómo se maneje la autogeneración de ids en la base de datos, es decir, estos valores pueden cambiar)

INSERT INTO menu_role (menu_id, role_id) VALUES (1, 1);  -- Dashboard - ADMIN
INSERT INTO menu_role (menu_id, role_id) VALUES (2, 1);  -- Usuarios - ADMIN
INSERT INTO menu_role (menu_id, role_id) VALUES (3, 1);  -- Roles - ADMIN
INSERT INTO menu_role (menu_id, role_id) VALUES (4, 1);  -- Menu - ADMIN

INSERT INTO menu_role (menu_id, role_id) VALUES (1, 2);  -- Dashboard - USER
INSERT INTO menu_role (menu_id, role_id) VALUES (2, 2);  -- Usuarios - USER
INSERT INTO menu_role (menu_id, role_id) VALUES (3, 2);  -- Roles - USER
INSERT INTO menu_role (menu_id, role_id) VALUES (4, 2);  -- Menu - USER

