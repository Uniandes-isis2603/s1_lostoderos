delete from ServicioEntity;
  
insert into ServicioEntity  (nombre, categorias, descripcion, imagen) values ('Plomeria', 'agua y tuberias', 'Aqui va una descripcion detallada del servicio', 'data/images/servicio1.png');
insert into ServicioEntity  (nombre, categorias, descripcion, imagen) values ('Climatizacion', 'Aire Acondicionado', 'Aqui va una descripcion detallada del servicio', 'data/images/Acondicionamiento.png');
insert into ServicioEntity  (nombre, categorias, descripcion, imagen) values ('Pintura', 'Pintura', 'Aqui va una descripcion detallada del servicio', 'data/images/Pintura.png');
insert into ServicioEntity  (nombre, categorias, descripcion, imagen) values ('Gas', 'Servicios Basicos', 'Aqui va una descripcion detallada del servicio', 'data/images/Gas.png');
insert into ServicioEntity  (nombre, categorias, descripcion, imagen) values ('Electricidad', 'Servicios Básicos', 'Aqui va una descripcion detallada del servicio', 'data/images/Electricidad.jpg');
insert into ServicioEntity  (nombre, categorias, descripcion, imagen) values ('Mudanza', 'Servicios Premium', 'Aqui va una descripcion detallada del servicio', 'data/images/Mudanza.png');

<<<<<<< HEAD
delete from USUARIOENTITY;
insert into USUARIOENTITY ( dtype,nombre, correo, usuario, contrasena, reputacion) values ('ContratistaEntity' ,'Christi Lamanby', 'clamanby0@youtube.com', 'clamanby0', 'FmAhX0zkz9WQ', null);
insert into USUARIOENTITY (dtype ,nombre, correo, usuario, contrasena, reputacion) values ( 'ContratistaEntity' ,'Gill Heisman', 'gheisman1@nymag.com', 'gheisman1', 'LOUAd68', null);
insert into USUARIOENTITY (dtype ,nombre, correo, usuario, contrasena, reputacion) values ('ContratistaEntity' , 'Saundra Bonhan', 'sbonhan2@mashable.com', 'sbonhan2', 'CjeMX5YG', null);
insert into USUARIOENTITY (dtype ,nombre, correo, usuario, contrasena, reputacion) values ( 'ContratistaEntity' ,'Sybil Ivanenko', 'sivanenko3@friendfeed.com', 'sivanenko3', 'tr2esTLJ', null);
insert into USUARIOENTITY (dtype ,nombre, correo, usuario, contrasena, reputacion) values ( 'ContratistaEntity' ,'Reuben Skerman', 'rskerman4@odnoklassniki.ru', 'rskerman4', 'XS6EEX9E', null);
insert into USUARIOENTITY ( dtype,nombre, correo, usuario, contrasena, reputacion) values ('ContratistaEntity' , 'Francis Mum', 'fmum5@loc.gov', 'fmum5', 'DKKORXeqYPni', null);
insert into USUARIOENTITY (dtype ,nombre, correo, usuario, contrasena, reputacion) values ('ContratistaEntity' ,'Noam Leeds', 'nleeds6@free.fr', 'nleeds6', 'yWFNDCET9TAU', null);
insert into USUARIOENTITY (dtype ,nombre, correo, usuario, contrasena, reputacion) values ('ContratistaEntity' , 'Redford Hugle', 'rhugle7@google.cn', 'rhugle7', 'UxYmUlEAm', null);
insert into USUARIOENTITY (dtype ,nombre, correo, usuario, contrasena, reputacion) values ('ContratistaEntity' , 'Catrina Currie', 'ccurrie8@quantcast.com', 'ccurrie8', 'pfWjXOB', null);
insert into USUARIOENTITY ( dtype,nombre, correo, usuario, contrasena, reputacion) values ('ContratistaEntity' , 'Karalynn Feveryear', 'kfeveryear9@fc2.com', 'kfeveryear9', 'ty4ew9k5fq', null);
=======

delete from USUARIOENTITY;
insert into USUARIOENTITY (id, dtype,nombre, correo, usuario, contrasena, reputacion) values (1,'ContratistaEntity' ,'Christi Lamanby', 'clamanby0@youtube.com', 'clamanby0', 'FmAhX0zkz9WQ', null);
insert into USUARIOENTITY (id,dtype ,nombre, correo, usuario, contrasena, reputacion) values (2, 'ContratistaEntity' ,'Gill Heisman', 'gheisman1@nymag.com', 'gheisman1', 'LOUAd68', null);
insert into USUARIOENTITY (id,dtype ,nombre, correo, usuario, contrasena, reputacion) values (3,'ContratistaEntity' , 'Saundra Bonhan', 'sbonhan2@mashable.com', 'sbonhan2', 'CjeMX5YG', null);
insert into USUARIOENTITY (id,dtype ,nombre, correo, usuario, contrasena, reputacion) values (4, 'ContratistaEntity' ,'Sybil Ivanenko', 'sivanenko3@friendfeed.com', 'sivanenko3', 'tr2esTLJ', null);
insert into USUARIOENTITY (id,dtype ,nombre, correo, usuario, contrasena, reputacion) values (5, 'ContratistaEntity' ,'Reuben Skerman', 'rskerman4@odnoklassniki.ru', 'rskerman4', 'XS6EEX9E', null);
insert into USUARIOENTITY (id, dtype,nombre, correo, usuario, contrasena, reputacion) values (6,'ContratistaEntity' , 'Francis Mum', 'fmum5@loc.gov', 'fmum5', 'DKKORXeqYPni', null);
insert into USUARIOENTITY (id,dtype ,nombre, correo, usuario, contrasena, reputacion) values (7, 'ContratistaEntity' ,'Noam Leeds', 'nleeds6@free.fr', 'nleeds6', 'yWFNDCET9TAU', null);
insert into USUARIOENTITY (id,dtype ,nombre, correo, usuario, contrasena, reputacion) values (8,'ContratistaEntity' , 'Redford Hugle', 'rhugle7@google.cn', 'rhugle7', 'UxYmUlEAm', null);
insert into USUARIOENTITY (id,dtype ,nombre, correo, usuario, contrasena, reputacion) values (9,'ContratistaEntity' , 'Catrina Currie', 'ccurrie8@quantcast.com', 'ccurrie8', 'pfWjXOB', null);
insert into USUARIOENTITY (id, dtype,nombre, correo, usuario, contrasena, reputacion) values (10,'ContratistaEntity' , 'Karalynn Feveryear', 'kfeveryear9@fc2.com', 'kfeveryear9', 'ty4ew9k5fq', null);
>>>>>>> origin/master


delete from PAGOENTITY;
insert into PAGOENTITY (ID, CODIGOTARJETA, COMPROBANTEPAGOMEDIO, COMPROBANTEPAGOTOTAL, DESCRIPCION, FECHATARJETA,NAME, NUMTARJETA) values (100, '123', 1, 1,  'pago de tarjeta con num 123',  '19/02/2018', null, '123456789123');
insert into PAGOENTITY (ID, CODIGOTARJETA, COMPROBANTEPAGOMEDIO, COMPROBANTEPAGOTOTAL, DESCRIPCION, FECHATARJETA,NAME, NUMTARJETA) values (101, '523', 1, 0,  'pago de tarjeta con num 468',  '19/02/2018', null, '4681624557223');
insert into PAGOENTITY (ID, CODIGOTARJETA, COMPROBANTEPAGOMEDIO, COMPROBANTEPAGOTOTAL, DESCRIPCION, FECHATARJETA,NAME, NUMTARJETA) values (103, '534', 0, 1,  'pago de tarjeta con num 163',  '19/02/2018', null, '1631485457956');
insert into PAGOENTITY (ID, CODIGOTARJETA, COMPROBANTEPAGOMEDIO, COMPROBANTEPAGOTOTAL, DESCRIPCION, FECHATARJETA,NAME, NUMTARJETA) values (104, '547', 0, 0,  'pago de tarjeta con num 641',  '19/02/2018', null, '6413484641983');



delete from FACTURAENTITY;
insert into FACTURAENTITY (FORMAPAGO, NAME, PRODUCTO, SUBTOTAL, TOTAL, PAGO_ID) values ('Efectivo', 'name','Plomeria',100, 110, null);
insert into FACTURAENTITY (FORMAPAGO, NAME, PRODUCTO, SUBTOTAL, TOTAL, PAGO_ID) values ('Efectivo', 'name','Plomeria',100, 110, null);
insert into FACTURAENTITY (FORMAPAGO, NAME, PRODUCTO, SUBTOTAL, TOTAL, PAGO_ID) values ('TarjetaCredito', 'ayuda','Limpieza',200, 110, null);
insert into FACTURAENTITY (FORMAPAGO, NAME, PRODUCTO, SUBTOTAL, TOTAL, PAGO_ID) values ('TarjetaDebito', 'ayuda','Lavanderia',200, 110, null);


