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

/* insertando peliculas */
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
insert into butacas(id_butaca,salas_id_sala) values(1,1);
insert into butacas(id_butaca,salas_id_sala) values(2,1);
insert into butacas(id_butaca,salas_id_sala) values(3,1);
insert into butacas(id_butaca,salas_id_sala) values(4,1);
insert into butacas(id_butaca,salas_id_sala) values(5,1);
insert into butacas(id_butaca,salas_id_sala) values(6,1);
insert into butacas(id_butaca,salas_id_sala) values(7,1);
insert into butacas(id_butaca,salas_id_sala) values(8,1);
insert into butacas(id_butaca,salas_id_sala) values(9,1);
insert into butacas(id_butaca,salas_id_sala) values(10,1);


/*insertando reservas*/ describe reservas;
insert into reservas values(1,'2022-06-20',600,1,1,5,1);

/* no se puede realizar reservas si no existen funciones*/
