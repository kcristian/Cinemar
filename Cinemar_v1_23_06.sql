-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Cinemar_v1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Cinemar_v1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Cinemar_v1` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema cinemar
-- -----------------------------------------------------
USE `Cinemar_v1` ;

-- -----------------------------------------------------
-- Table `Cinemar_v1`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`usuarios` (
  `id_usuario` INT NOT NULL,
  `rol` ENUM('CLIENTE', 'ADMINISTRACION') NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `fecha_registro` DATE NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemar_v1`.`peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`peliculas` (
  `id_pelicula` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `sinopsis` VARCHAR(100) NULL,
  `duracion` INT NOT NULL,
  `director` VARCHAR(45) NULL,
  `reparto` VARCHAR(100) NULL,
  PRIMARY KEY (`id_pelicula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemar_v1`.`clasificacion_peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`clasificacion_peliculas` (
  `id_clasificacion` INT NOT NULL,
  `identificador` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `peliculas_id_pelicula` INT NOT NULL,
  PRIMARY KEY (`id_clasificacion`, `peliculas_id_pelicula`),
  INDEX `fk_clasificacion_peliculas_peliculas1_idx` (`peliculas_id_pelicula` ASC) VISIBLE,
  CONSTRAINT `fk_clasificacion_peliculas_peliculas1`
    FOREIGN KEY (`peliculas_id_pelicula`)
    REFERENCES `Cinemar_v1`.`peliculas` (`id_pelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemar_v1`.`tipo_peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`tipo_peliculas` (
  `id_tipo` INT NOT NULL,
  `formato` VARCHAR(45) NOT NULL,
  `idioma` VARCHAR(45) NOT NULL,
  `subtitulos` VARCHAR(45) NOT NULL,
  `peliculas_id_pelicula` INT NOT NULL,
  PRIMARY KEY (`id_tipo`, `peliculas_id_pelicula`),
  INDEX `fk_tipo_peliculas_peliculas1_idx` (`peliculas_id_pelicula` ASC) VISIBLE,
  CONSTRAINT `fk_tipo_peliculas_peliculas1`
    FOREIGN KEY (`peliculas_id_pelicula`)
    REFERENCES `Cinemar_v1`.`peliculas` (`id_pelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemar_v1`.`genero_peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`genero_peliculas` (
  `id_genero_pelicula` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `peliculas_id_pelicula` INT NOT NULL,
  PRIMARY KEY (`id_genero_pelicula`, `peliculas_id_pelicula`),
  INDEX `fk_genero_peliculas_peliculas1_idx` (`peliculas_id_pelicula` ASC) VISIBLE,
  CONSTRAINT `fk_genero_peliculas_peliculas1`
    FOREIGN KEY (`peliculas_id_pelicula`)
    REFERENCES `Cinemar_v1`.`peliculas` (`id_pelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemar_v1`.`salas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`salas` (
  `id_sala` INT NOT NULL,
  `capacidad` INT NULL,
  `precio` FLOAT NULL,
  PRIMARY KEY (`id_sala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemar_v1`.`funciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`funciones` (
  `id_funcion` INT UNIQUE NOT NULL,
  `fecha` DATE NULL,
  `salas_id_sala` INT NOT NULL,
  `peliculas_id_pelicula` INT NOT NULL,
  PRIMARY KEY (`id_funcion`, `salas_id_sala`, `peliculas_id_pelicula`),
  INDEX `fk_funciones_salas1_idx` (`salas_id_sala` ASC) VISIBLE,
  INDEX `fk_funciones_peliculas1_idx` (`peliculas_id_pelicula` ASC) VISIBLE,
  CONSTRAINT `fk_funciones_salas1`
    FOREIGN KEY (`salas_id_sala`)
    REFERENCES `Cinemar_v1`.`salas` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funciones_peliculas1`
    FOREIGN KEY (`peliculas_id_pelicula`)
    REFERENCES `Cinemar_v1`.`peliculas` (`id_pelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemar_v1`.`reservas`
-- -----------------------------------------------------
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
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemar_v1`.`butacas`
-- -----------------------------------------------------
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


-- -----------------------------------------------------
-- Table `Cinemar_v1`.`formato_salas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`formato_salas` (
  `id_formato` INT NOT NULL,
  `identificador` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_formato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemar_v1`.`salas_tienen_formato_salas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemar_v1`.`salas_tienen_formato_salas` (
  `salas_id_sala` INT NOT NULL,
  `formato_salas_id_formato` INT NOT NULL,
  PRIMARY KEY (`salas_id_sala`, `formato_salas_id_formato`),
  INDEX `fk_salas_has_formato_salas_formato_salas1_idx` (`formato_salas_id_formato` ASC) VISIBLE,
  INDEX `fk_salas_has_formato_salas_salas1_idx` (`salas_id_sala` ASC) VISIBLE,
  CONSTRAINT `fk_salas_has_formato_salas_salas1`
    FOREIGN KEY (`salas_id_sala`)
    REFERENCES `Cinemar_v1`.`salas` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_salas_has_formato_salas_formato_salas1`
    FOREIGN KEY (`formato_salas_id_formato`)
    REFERENCES `Cinemar_v1`.`formato_salas` (`id_formato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
