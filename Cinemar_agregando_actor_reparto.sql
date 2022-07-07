create table reparto(
	id_reparto int auto_increment primary key,
    descripcion varchar(50)
);
alter table peliculas add column reparto int;
alter table peliculas add foreign key (reparto) references reparto(id_reparto);
create table actores(
	id_actor int auto_increment primary key,
	nombre varchar(25) not null,
    apellido varchar(25) not null
);
create table actor_en_reparto(
	id_actor int,
    id_reparto int,
    foreign key (id_actor) references actores(id_actor),
    foreign key (id_reparto) references reparto(id_reparto)
);
describe usuarios;

