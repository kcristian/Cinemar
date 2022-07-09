use cinemar_v1;
select*from peliculas;
describe butacas;
select id_funcion,fecha,salas_id_sala,peliculas_id_pelicula,nombre from funciones inner join peliculas on peliculas_id_pelicula = id_pelicula where fecha <= curdate();
SELECT id_usuario, rol, username, usuarios.password,email,fecha_nacimiento,telefono,fecha_registro FROM usuarios WHERE usuarios.username='cristian9' and usuarios.password='cristian22';
select*from funciones where fecha <= curdate();

select *  from reservas;
update butacas set estado=1,reservas_id_reserva=1 where id_butaca=5; 
select id_reserva,fecha,precio,usuarios_id_usuario,funciones_id_funcion,funciones_salas_id_sala,funciones_peliculas_id_pelicula,nombre,id_butaca,estado,reservas_id_reserva 
from reservas inner join butacas inner join peliculas where id_reserva = reservas_id_reserva and id_pelicula = funciones_peliculas_id_pelicula ;

describe cinemar_v1.salas_tienen_formato_salas;
select * from cinemar_v1.clasificacion_peliculas;

describe descuentos;
create table descuentos(

	id_descuento int primary key,
    dia varchar(45),
    descuento float

);
describe reservas;
alter table reservas add constraint fk_reservas foreign key (reserva_descuento) references descuentos(id_descuento);

delete  from butacas;
drop table butacas;
drop table reservas;
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`reservas` (
  `id_reserva` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `precio` FLOAT NULL,
  `descuento` INT NULL,
  `usuarios_id_usuario` INT NOT NULL,
  `funciones_id_funcion` INT NOT NULL,
  `funciones_salas_id_sala` INT NOT NULL,
  `funciones_peliculas_id_pelicula` INT NOT NULL,
  PRIMARY KEY (`id_reserva`, `usuarios_id_usuario`, `funciones_id_funcion`, `funciones_salas_id_sala`, `funciones_peliculas_id_pelicula`),
  INDEX `fk_reservas_usuarios1_idx` (`usuarios_id_usuario` ASC) VISIBLE,
  INDEX `fk_reservas_funciones1_idx` (`funciones_id_funcion` ASC, `funciones_salas_id_sala` ASC, `funciones_peliculas_id_pelicula` ASC) VISIBLE,
  CONSTRAINT `fk_reservas_usuarios1`
    FOREIGN KEY (`usuarios_id_usuario`)
    REFERENCES `Cinemar_v1`.`usuarios` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservas_funciones1`
    FOREIGN KEY (`funciones_id_funcion` , `funciones_salas_id_sala` , `funciones_peliculas_id_pelicula`)
    REFERENCES `Cinemar_v1`.`funciones` (`id_funcion` , `salas_id_sala` , `peliculas_id_pelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION, 
  CONSTRAINT `fk_reservas_descuentos`
    FOREIGN KEY (`descuento`)
    REFERENCES `cinemar_v1`.`descuentos`(id_descuento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`butacas` (
  `id_butaca` INT UNIQUE NOT NULL,
  `estado` TINYINT NULL DEFAULT 0,
  `salas_id_sala` INT NOT NULL,
  `reservas_id_reserva` INT NOT NULL,
  PRIMARY KEY (`id_butaca`, `salas_id_sala`, `reservas_id_reserva`),
  INDEX `fk_butacas_salas1_idx` (`salas_id_sala` ASC) VISIBLE,
  INDEX `fk_butacas_reservas1_idx` (`reservas_id_reserva` ASC) VISIBLE,
  CONSTRAINT `fk_butacas_salas1`
    FOREIGN KEY (`salas_id_sala`)
    REFERENCES `Cinemar_v1`.`salas` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_butacas_reservas1`
    FOREIGN KEY (`reservas_id_reserva`)
    REFERENCES `Cinemar_v1`.`reservas` (`id_reserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
describe butacas;
insert into descuentos values(1,'lunes',0);
insert into descuentos values(2,'martes',0.5);
insert into descuentos values(3,'miercoles',0.4);
insert into descuentos values(4,'jueves',0.3);
insert into descuentos values(5,'viernes',0.2);
insert into descuentos values(6,'sabado',0.1);
insert into descuentos values(7,'domingo',0.2);
