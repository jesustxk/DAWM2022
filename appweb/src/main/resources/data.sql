-- USUARIOS

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED, EMAIL, FECHA_ALTA) VALUES ('usuario', '$2a$12$76W6G/T4HwVxAZGqOr/BM.6qlNamMrH0t5nRIk7U3DgS5zkJYLaSS', 'true', 'usuario@gmail.com', CURRENT_TIMESTAMP);

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED, EMAIL, FECHA_ALTA) VALUES ('usuario2', '$2a$12$cqSegF.SJLCqe77hmarxmuiOiXBnC0ItaGX2ewad6hYB5hC0927mq', 'true', 'usuario2@gmail.com', CURRENT_TIMESTAMP);


-- AUTHORITIES

INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('usuario', 'read');

INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('usuario2', 'read');


-- CURSOS

INSERT INTO CURSO (CODIGO, TITULO, DESCRIPCION, FECHA_ALTA, ID_USUARIO) VALUES ('GA000', 'Google Analytics', 'Aprende a utilizar Google Analytics para tu negocio', CURRENT_TIMESTAMP, 1);

INSERT INTO CURSO (CODIGO, TITULO, DESCRIPCION, FECHA_ALTA) VALUES ('GPE', 'Gestión de proyectos de energía', 'Conceptos, procesos, técnicas y herramientas para la gestión de proyectos de energía', CURRENT_TIMESTAMP);

INSERT INTO CURSO (CODIGO, TITULO, DESCRIPCION, FECHA_ALTA) VALUES ('CUT', 'C# and Unity', 'C# Programming for Unity Game Development', CURRENT_TIMESTAMP);

INSERT INTO CURSO (CODIGO, TITULO, DESCRIPCION, FECHA_ALTA) VALUES ('CDEVOPS', 'Continuous Delivery & DevOps', 'When it comes to digital innovation, velocity is critical and many would say it is the most reliable determinant of success', CURRENT_TIMESTAMP);

INSERT INTO CURSO (CODIGO, TITULO, DESCRIPCION, FECHA_ALTA) VALUES ('PYDATSCI', 'Python for Data Science', 'Kickstart your learning of Python with this beginner-friendly self-paced course taught by an expert', CURRENT_TIMESTAMP);

INSERT INTO CURSO (CODIGO, TITULO, DESCRIPCION, FECHA_ALTA) VALUES ('BBWCU', 'Basic behavior with C# in Unity', 'Develop a foundational understanding of coding in C# and the value and power of Unity', CURRENT_TIMESTAMP);


-- CURSO_USUARIO

INSERT INTO CURSO_USUARIO (ID_CURSO, ID_USUARIO, VALORACION, COMPLETADO) VALUES (1, 1, null, null);

INSERT INTO CURSO_USUARIO (ID_CURSO, ID_USUARIO, VALORACION, COMPLETADO) VALUES (2, 1, null, null);

INSERT INTO CURSO_USUARIO (ID_CURSO, ID_USUARIO, VALORACION, COMPLETADO) VALUES (4, 2, null, null);