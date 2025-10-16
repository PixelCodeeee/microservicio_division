Division
Select * From division;
INSERT INTO DIVISION (NOMBRE) VALUES ('DIVISION DE TECNOLOGIAS');
INSERT INTO DIVISION (NOMBRE) VALUES ('División Económico-Administrativa'); 
INSERT INTO DIVISION (NOMBRE) VALUES ('División de Ingeniería y Manufactura'); 
INSERT INTO DIVISION (NOMBRE) VALUES ('División de Ciencias Ambientales'); 
INSERT INTO DIVISION (NOMBRE) VALUES ('División de Estudios de Posgrado');
INSERT INTO DIVISION (NOMBRE, ACTIVO) VALUES ('División de Postgrado', TRUE);
UPDATE DIVISION SET ACTIVO = TRUE;

Programa educativo
Select * From programa_educativo;
INSERT INTO programa_educativo (nombre, activo) VALUES ('Ingeniería en Sistemas Computacionales', TRUE);
INSERT INTO programa_educativo (nombre, activo) VALUES ('Licenciatura en Gestión Empresarial', TRUE);
INSERT INTO programa_educativo (nombre, activo) VALUES ('Ingeniería en Mecatrónica', TRUE);
INSERT INTO programa_educativo (nombre, activo) VALUES ('Licenciatura en Desarrollo de Negocios', FALSE);
INSERT INTO programa_educativo (nombre, activo) VALUES ('Ingeniería en Tecnologías de la Información y Comunicación', TRUE);

UPDATE PROGRAMA_EDUCATIVO SET DIVICION_ID = 1 WHERE ID = 1;
UPDATE PROGRAMA_EDUCATIVO SET DIVICION_ID = 3 WHERE ID = 2;
UPDATE PROGRAMA_EDUCATIVO SET DIVICION_ID = 4 WHERE ID = 3;
UPDATE PROGRAMA_EDUCATIVO SET DIVICION_ID = 3 WHERE ID = 4;
UPDATE PROGRAMA_EDUCATIVO SET DIVICION_ID = 1 WHERE ID = 5;