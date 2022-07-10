/* insertando usuarios*/
insert into usuarios values(1,'CLIENTE','ismale07','080502','ismael07@gmail.com','1995-04-12',4227895,'2022-07-02');
insert into usuarios values(2,'ADMINISTRACION','fedex9','fedex9','fedex9@gmail.com','1988-02-08',4158442,'2022-07-02');

/* insertando actores */

insert into actores values(1,'Johnny', 'Depp' );
insert into actores values(2,'Geoffrey', 'Rush');
insert into actores values(19,'Orlando', 'Bloom' );
insert into actores values(3,'Johnny', 'Depp' );
insert into actores values(4,'Keira', 'Knightley');
insert into actores values(5,'Jack', 'Davenport');

insert into actores values(6,'Kurt', 'Russell');
insert into actores values(8,'Wilford', 'Brimley');
insert into actores values(9,'T.K.', 'Carter');
insert into actores values(10,'David', 'Clennon');
insert into actores values(11,'Keith', 'David');
insert into actores values(12,'Richard', 'Dysart');
insert into actores values(13,'Charles', 'Hallahan');
insert into actores values(14,'Peter', 'Maloney');
insert into actores values(15,'Richard', 'Masur');
insert into actores values(16,'Donald', 'Moffat');
insert into actores values(17,'Joel', 'Polis');
insert into actores values(18,'Thomas', 'Waites');

/* insertando peliculas */ describe peliculas;
insert into peliculas values(1,'PIRATAS DEL CARIBE 1','la maldicion del perla negra',143,'Gore Verbinski',1);
insert into peliculas values(2,'LA COSA','un equipo cientifico descubre en la antártida un ente de otro mundo',109,'John Carpenter',2);

/* insertando repartos */
insert into reparto values(1,'reparto de piratas del caribe 1');
insert into reparto values(2,'reparto de la cosa');

/* insertando actores en repartos*/

insert into actor_en_reparto values(1,1);
insert into actor_en_reparto values(2,1);
insert into actor_en_reparto values(3,1);
insert into actor_en_reparto values(4,1);
insert into actor_en_reparto values(5,1);

insert into actor_en_reparto values(6,2);
insert into actor_en_reparto values(8,2);
insert into actor_en_reparto values(9,2);
insert into actor_en_reparto values(10,2);
insert into actor_en_reparto values(11,2);
insert into actor_en_reparto values(12,2);
insert into actor_en_reparto values(13,2);
insert into actor_en_reparto values(14,2);
insert into actor_en_reparto values(15,2);
insert into actor_en_reparto values(16,2);
insert into actor_en_reparto values(17,2);
insert into actor_en_reparto values(18,2);
insert into actor_en_reparto values(19,1);

/* insertando clasificaciones*/

insert into clasificacion_peliculas values(1,"ATP","apta para todo publico",1);
insert into clasificacion_peliculas values(2,"M16","mayores de 16 años",2);

/* insertando generos */
insert into genero_peliculas values(1,"aventura",1);
insert into genero_peliculas values(2,"terror",2);
insert into genero_peliculas values(3,"ciencia ficcion",2);

/* insertando tipos */
insert into tipo_peliculas values(1,"3D","latino","ninguno",1);
insert into tipo_peliculas values(2,"2D","latino","ninguno",2);
insert into tipo_peliculas values(3,"2D","latino","ninguno",1);
insert into tipo_peliculas values(4,"2D","ingles","español",2);

/* insertando salas */  
alter table salas drop column precio;
alter table formato_salas add column precio float not null;

insert into salas values(1,200);
insert into salas values(2,250);
insert into salas values(3,200);
insert into salas values(4,200);
insert into salas values(5,250);

/* insertando formatos*/ 
insert into formato_salas values(1,"2D","2 dimensiones",600);
insert into formato_salas values(2,"3D","3 dimensiones",900);
insert into formato_salas values(3,"4D","4 dimensiones",1000);

/* insertando formatos a las salas*/  select * from salas_tienen_formato_salas;
insert into salas_tienen_formato_salas values(1,1);
insert into salas_tienen_formato_salas values(2,2);
insert into salas_tienen_formato_salas values(3,2);
insert into salas_tienen_formato_salas values(4,3);
insert into salas_tienen_formato_salas values(5,1);

/* insertando funciones */ select * from funciones;
insert into funciones values(1,'2022-04-07',5,1);
insert into funciones values(2,'2022-05-07',3,2);

/* insertando butacas*/ select * from butacas;
insert into butacas(id_butaca,salas_id_sala,reservas_id_reserva) values(1,1,1);
insert into butacas(id_butaca,salas_id_sala,reservas_id_reserva) values(2,1,1);
insert into butacas(id_butaca,salas_id_sala,reservas_id_reserva) values(3,1,1);
insert into butacas(id_butaca,salas_id_sala,reservas_id_reserva) values(4,1,1);
insert into butacas(id_butaca,salas_id_sala,reservas_id_reserva) values(5,1,1);
insert into butacas(id_butaca,salas_id_sala,reservas_id_reserva) values(6,1,1);
insert into butacas(id_butaca,salas_id_sala,reservas_id_reserva) values(7,1,1);
insert into butacas(id_butaca,salas_id_sala,reservas_id_reserva) values(8,1,1);
insert into butacas(id_butaca,salas_id_sala,reservas_id_reserva) values(9,1,1);
insert into butacas(id_butaca,salas_id_sala,reservas_id_reserva) values(10,1,1);
select * from butacas;

/*insertando reservas*/ describe reparto;
describe peliculas;
select id_genero_pelicula,genero_peliculas.nombre, id_pelicula from peliculas inner join genero_peliculas where id_pelicula=2;
describe genero_peliculas;
insert into reservas values(1,'2022-06-20',600,5,1,1,5,1);
describe reservas;
select * from reservas;
/* no se puede realizar reservas si no existen funciones, ni hacer reservas en salas que no tienen funciones*/
select  actores.nombre, actores.apellido from actores inner join reparto inner join peliculas where id_pelicula=1 ;

/*update y delete de reservas*/
select * from reservas;
update reservas set id_reserva='4', fecha='2022-07-09',precio='500',descuento='4',usuarios_id_usuario='100',funciones_id_funcion='1',funciones_salas_id_sala='5',funciones_peliculas_id_pelicula='1' where id_reserva=3;
insert into reservas values(3,'2022-07-08',700,4,100,1,5,1);
delete  from reservas where id_reserva=3;
insert into reservas values(4,'2022-07-09',500,2,100,2,3,2);

select id_reserva, fecha, precio,username,email,telefono,id_usuario from usuarios inner join reservas on id_usuario=usuarios_id_usuario where usuarios.id_usuario=100;
select * from reservas where usuarios_id_usuario=100;
describe reservas;
select * from funciones;

select  actores.nombre, actores.apellido from actores inner join reparto inner join peliculas on peliculas.reparto = reparto.id_reparto where id_pelicula=1; 
describe reparto;
select * from usuarios;

select * from salas;
select * from formato_salas;
select * from salas_tienen_formato_salas;

/* ver salas*/
select id_sala as numero_de_sala,capacidad,formato_salas_id_formato,identificador as formato,descripcion,precio from salas inner join salas_tienen_formato_salas inner join formato_salas on id_sala=salas_id_sala and formato_salas_id_formato=id_formato order by id_sala;

/*ver reservas*/
select * from reservas;
select id_reserva, reservas.fecha, id_usuario,username,id_funcion,funciones.fecha,salas_id_sala,peliculas_id_pelicula,peliculas.nombre,cantidad from reservas inner join usuarios inner join funciones inner join salas inner join peliculas on usuarios_id_usuario=usuarios.id_usuario and funciones_id_funcion=funciones.id_funcion and funciones_salas_id_sala=salas.id_sala and funciones_peliculas_id_pelicula=peliculas.id_pelicula;
select id_reserva,username from reservas inner join usuarios on reservas.usuarios_id_usuario = usuarios.id_usuario order by id_reserva;

update reservas set cantidad='6' where id_reserva=1;
update reservas set cantidad='7' where id_reserva=2;
update reservas set cantidad='7' where id_reserva=3;
update reservas set cantidad='5' where id_reserva=4;
describe reservas;

select * from reservas;
/*creando vistas*/
create view vista_reservas_1 as select id_reserva, reservas.fecha as fecha_reserva, id_usuario,username,id_funcion,funciones.fecha as fecha_funcion,salas_id_sala,peliculas_id_pelicula,peliculas.nombre,cantidad from reservas inner join usuarios inner join funciones inner join salas inner join peliculas on usuarios_id_usuario=usuarios.id_usuario and funciones_id_funcion=funciones.id_funcion and funciones_salas_id_sala=salas.id_sala and funciones_peliculas_id_pelicula=peliculas.id_pelicula;

select * from vista_reservas_1;
create view vista_salas_1 as select id_sala as numero_de_sala,capacidad,formato_salas_id_formato,identificador as formato,descripcion,precio from salas inner join salas_tienen_formato_salas inner join formato_salas on id_sala=salas_id_sala and formato_salas_id_formato=id_formato order by id_sala;

select * from vista_salas_1;


select id_reserva, fecha_reserva,id_usuario,username,id_funcion,fecha_funcion,salas_id_sala,peliculas_id_pelicula,nombre,cantidad,numero_de_sala,cantidad,precio as precio_unitario
from vista_reservas_1 inner join vista_salas_1 on salas_id_sala=numero_de_sala;

select * from butacas;
alter table butacas drop column `reservas_id_reserva`;
alter table butacas drop constraint `fk_butacas_reservas1`;

describe butacas;
select * from formato_salas;
 select id_sala,capacidad,salas_id_sala,formato_salas_id_formato,id_formato,identificador,descripcion,precio from salas inner join salas_tienen_formato_salas inner join formato_salas;
 
 /* modificando butacas*/
 use cinemar_v1;
 select * from butacas;
 
 alter table butacas add column identificador varchar(5) unique after id_butaca;
 
 update butacas set identificador ='A1' where id_butaca=1;
  update butacas set identificador ='A2' where id_butaca=2;
   update butacas set identificador ='A3' where id_butaca=3;
    update butacas set identificador ='A4' where id_butaca=4;
     update butacas set identificador ='A5' where id_butaca=5;
      update butacas set identificador ='A6' where id_butaca=6;
       update butacas set identificador ='A7' where id_butaca=7;
        update butacas set identificador ='A8' where id_butaca=8;
         update butacas set identificador ='A9' where id_butaca=9;
          update butacas set identificador ='A10' where id_butaca=10;
/* agregar butacas a la sala */
insert into butacas ()values ();
delete from butacas where id_butaca=11;
/* ver butacas ocupadas o desocupadas de una sala*/
select id_butaca,identificador,estado from butacas where salas_id_sala=1 and estado=0;
/* funciones para determinada sala y fecha */
select id_funcion,fecha,peliculas_id_pelicula,id_sala,capacidad from funciones inner join salas on salas.id_sala=2 and funciones.fecha='2022-04-07' ;
/* ver sala y pelicula de todas las funciones*/
select id_funcion,fecha,peliculas_id_pelicula,id_sala,capacidad,id_pelicula,nombre,director from funciones inner join salas inner join peliculas on salas.id_sala=funciones.salas_id_sala and funciones.peliculas_id_pelicula=peliculas.id_pelicula;

/* mostrar todas las butacas de una funcion*/
select * from funciones;

/* en proceso */ 
select * from vista_salas_1;
select * from descuentos;
update descuentos set id_descuento='7',dia='domingo',descuento=0.25 where id_descuento=7;
select * from salas;

/* reservar una butaca*/
select * from peliculas;
update butacas set estado=1 where salas_id_sala=0;

/* ver clasificacion de una pelicula*/
select id_tipo, formato, idioma, subtitulos,peliculas_id_pelicula from tipo_peliculas where peliculas_id_pelicula=2;
describe tipo_peliculas;
SELECT id_clasificacion, identificador,descripcion, peliculas_id_pelicula FROM clasificacion_peliculas WHERE peliculas_id_pelicula = 2;

select * from salas_tienen_formato_salas;
select * from formato_salas;
select * from salas;
/* mostrar informacion de una sala segun id ingresado*/
select id_sala,capacidad,id_formato,identificador,descripcion,precio from salas inner join salas_tienen_formato_salas inner join formato_salas  on salas.id_sala= salas_tienen_formato_salas.salas_id_sala 
and salas_tienen_formato_salas.formato_salas_id_formato=formato_salas.id_formato where salas.id_sala=1;

/* mostrar informacion de una sala segun id ingresado, incluido butacas*/
select id_sala,capacidad,id_formato,formato_salas.identificador,descripcion,precio,butacas.id_butaca,butacas.identificador,estado from salas inner join salas_tienen_formato_salas inner join formato_salas  inner join butacas on salas.id_sala= salas_tienen_formato_salas.salas_id_sala 
and salas_tienen_formato_salas.formato_salas_id_formato=formato_salas.id_formato and butacas.salas_id_sala=salas.id_sala where salas.id_sala=1;

select id_sala,id_formato,identificador,descripcion,capacidad from salas inner join salas_tienen_formato_salas inner join formato_salas 
on salas.id_sala=salas_tienen_formato_salas.salas_id_sala and salas_tienen_formato_salas.formato_salas_id_formato=formato_salas.id_formato where salas.id_sala=2 ;

select id_sala,capacidad,identificador from salas inner join salas_tienen_formato_salas inner join formato_salas 
on salas.id_sala=salas_tienen_formato_salas.salas_id_sala and salas_tienen_formato_salas.formato_salas_id_formato=formato_salas.id_formato where salas.id_sala=2 ;

select id_butaca,identificador,estado from butacas where salas_id_sala=2;


select id_funcion,fecha,salas_id_sala,peliculas_id_pelicula from funciones;

select id_reserva, fecha, cantidad, descuento,usuarios_id_usuario, funciones_id_funcion, funciones_salas_id_sala, funciones_peliculas_id_pelicula from reservas where id_reserva=3;
select * from reservas;
/*ultimo insert de iron man*/
insert into peliculas(id_pelicula,nombre,sinopsis,duracion,director) values(3,'IRON MAN','el hombre de acero',126,'Jon Favreau');