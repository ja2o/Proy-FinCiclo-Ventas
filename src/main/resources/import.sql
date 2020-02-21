/* Populate tables */

INSERT INTO clientes(nombre, apellido, email, create_at, direccion, password, telefono) VALUES('Andres', 'Guzman', 'profe@gmail.com', '2000-01-28', 'Mz 15 lote 5 Urb Las flores - Villa Maria','123abc', '989764185');
INSERT INTO clientes(nombre, apellido, email, create_at, direccion, password, telefono) VALUES('Monica', 'Suarez', 'gata@gmail.com', '2017-08-28', 'Pasaje 15 Urb 15 Surco','123abc', '984625843');
INSERT INTO clientes(nombre, apellido, email, create_at, direccion, password, telefono) VALUES('Bruno', 'Guzman', 'alianza@gmail.com', '2015-05-10', 'Los Podemos Nuevos 15 - San Isidro','123abc', '684952197');

insert into productos (nombre, precio) values('Gaseosa inka cola 1L', 2.5);
insert into productos (nombre, precio) values('Gaseosa inka cola 3L', 5.0);
insert into productos (nombre, precio) values('Gaseosa coca cola 1L', 2.5);
insert into productos (nombre, precio) values('Gaseosa inka cola 3L', 2.5);
insert into productos (nombre, precio) values('Gaseosa inka cola 75ml', 1.5);
insert into productos (nombre, precio) values('Gaseosa fanta 1L', 2.3);

insert into productos (nombre, precio) values('pollo a la brasa 1/4',12.0);
insert into productos (nombre, precio) values('pavo navideno preparado 6k', 72.0);
insert into productos (nombre, precio) values('pato horneado 2k', 60.0);

insert into productos (nombre, precio) values('chicle sabor menta x bolsa mediana',4.50);
insert into productos (nombre, precio) values('papitas al hilo x bolsa pequeña', 3.0);
insert into productos (nombre, precio) values('papitas al hilo x bolsa grande', 5.5);
insert into productos (nombre, precio) values('carmelos sabor menta x bolsa', 6.50);

insert into productos (nombre, precio) values('sixpack cerveza cuzquena', 25.0);
insert into productos (nombre, precio) values('cerveza pilsea x caja', 65.0);
insert into productos (nombre, precio) values('vino rosel x unidad', 25.0);
insert into productos (nombre, precio) values('red label 1L', 95.0);

insert into productos (nombre, precio) values('arroz costeño 1k', 3.5);
insert into productos (nombre, precio) values('arroz costeño 5k', 18.0);
insert into productos (nombre, precio) values('fideos molitalia codito 5k', 14.0);
insert into productos (nombre, precio) values('lata leche gloria unidad', 3.50);
insert into productos (nombre, precio) values('lata atum florida unidad', 5.0);
insert into productos (nombre, precio) values('sal marina unidad', 1.50);


INSERT INTO facturas(fec_Factura, cliente_id) VALUES(now(), 1);
INSERT INTO factura_detalles(cantidad, producto_id, factura_id) VALUES(1,1,1);
INSERT INTO factura_detalles(cantidad, producto_id, factura_id) VALUES(1,2,1);
INSERT INTO factura_detalles(cantidad, producto_id, factura_id) VALUES(2,3,1);

INSERT INTO facturas(fec_Factura, cliente_id) VALUES(now(), 1);
INSERT INTO factura_detalles(cantidad, producto_id, factura_id) VALUES(1,7,2);
INSERT INTO factura_detalles(cantidad, producto_id, factura_id) VALUES(1,8,2);
INSERT INTO factura_detalles(cantidad, producto_id, factura_id) VALUES(1,9,2);

