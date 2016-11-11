
CREATE DATABASE Ferreteria;

use Ferreteria;

create table Producto (
codigo int not null,
precio int not null,
nombreProducto varchar(50) not null,
cantExistencias int not null,
primary key(codigo)
);

insert into Producto(codigo,nombreProducto,precio,cantExistencias) values (25486,'Martillo Carpintero Surtek',7000,50);
insert into Producto(codigo,nombreProducto,precio,cantExistencias) values (3456,'Cuchara China',1000,100);
insert into Producto(codigo,nombreProducto,precio,cantExistencias) values (061096,'Cuchara Foy Tools',2500,15);
insert into Producto(codigo,nombreProducto,precio,cantExistencias) values (221298,'Guante Algodon',400,10);
insert into Producto(codigo,nombreProducto,precio,cantExistencias) values (4567,'Guante Neopreno',1400,50);
insert into Producto(codigo,nombreProducto,precio,cantExistencias) values (8897,'Espander Plastico',10,150);
insert into Producto(codigo,nombreProducto,precio,cantExistencias) values (7854,'Espander Fischer',30,200);
insert into Producto(codigo,nombreProducto,precio,cantExistencias) values (2223,'Desatornillador Cruz Phillips',1000,40);
insert into Producto(codigo,nombreProducto,precio,cantExistencias) values (1178,'Desatornillador Plano Phillips',1200,30);

create table Cliente (
idCliente varchar(10) not null,
nombreCliente varchar(50) not null,
telefonoCliente varchar(10) not null,
descuento int not null,
primary key(idCliente)
);

insert into Cliente(idCliente,nombreCliente,telefonoCliente,descuento) values ('111','Jose','24876543',10);
insert into Cliente(idCliente,nombreCliente,telefonoCliente,descuento) values ('000','Prueba','000000',0);

create table Empleado(
idEmpleado varchar(10) not null,
nombreEmpleado varchar(50) not null,
contrasena varchar(15) not null,
rol varchar(20) not null,
primary key(idEmpleado)
);

insert into Empleado(idEmpleado,nombreEmpleado,contrasena,rol) values ('111','Luis Alejandro','1234','Administrador');
insert into Empleado(idEmpleado,nombreEmpleado,contrasena,rol) values ('444','Jason','5678','Vendedor');
insert into Empleado(idEmpleado,nombreEmpleado,contrasena,rol) values ('555','Fernanda','9012','Cajero');
insert into Empleado(idEmpleado,nombreEmpleado,contrasena,rol) values ('666','Jose','6789','Despachador');
insert into Empleado(idEmpleado,nombreEmpleado,contrasena,rol) values ('777','Andrea','9876','Bodeguero');

create table Factura(
numFactura varchar(10) not null,
fecha varchar(10) not null,
hora varchar(10) not null,
cancelada boolean not null,
despachada boolean not null,
numFerreteria varchar(10) not null,
Cliente varchar(10) not null,
Empleado varchar(10) not null,
primary key(numFactura)
);

ALTER TABLE Factura ADD foreign key(Cliente) references Cliente(idCliente) on delete cascade on update cascade;
ALTER TABLE Factura ADD foreign key(Empleado) references Empleado(idEmpleado) on delete cascade on update cascade;

insert into Factura (numFactura,fecha,hora,cancelada,despachada,numFerreteria,Cliente,Empleado) values ('000', '24/10/2016', '05:09',false,false,'24567898', '111', '111');

create table Lineas(
numFactura1 varchar(10) not null,
cantidad int not null,
codigo int not null,
primary key(numFactura1)
);

ALTER TABLE Lineas ADD foreign key(numFactura1) references Factura(numFactura) on delete cascade on update cascade;
ALTER TABLE Lineas ADD foreign key(codigo) references Producto(codigo)on delete cascade on update cascade;

insert into Lineas(numFactura1,cantidad,codigo) values ('000',3,061096);




