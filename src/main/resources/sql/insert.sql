TRUNCATE TABLE agencianaviera CASCADE;
TRUNCATE TABLE cliente CASCADE;
TRUNCATE TABLE destino CASCADE;
TRUNCATE TABLE usuario CASCADE;

INSERT INTO agencianaviera (id,nombre) VALUES (1, 'MAERSK');

INSERT INTO cliente (id,nombre) VALUES (1, 'ESTAR');

INSERT INTO destino (id,nombre) VALUES (1, 'ESPAÑA');

INSERT INTO usuario (id,login,nombre,password) VALUES (1, 'carper', 'Carlos Julio Pérez Quizhpe', '123');
