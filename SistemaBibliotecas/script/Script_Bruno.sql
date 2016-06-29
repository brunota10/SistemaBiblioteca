-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dbBiblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbBiblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbBiblioteca` DEFAULT CHARACTER SET utf8 ;
USE `dbBiblioteca` ;

-- -----------------------------------------------------
-- Table `dbBiblioteca`.`TB_ACERVO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbBiblioteca`.`TB_ACERVO` (
  `CD_ACERVO` INT NOT NULL AUTO_INCREMENT,
  `DS_ACERVO` VARCHAR(45) NOT NULL,
  `TIPO_ACERVO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CD_ACERVO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbBiblioteca`.`TB_ALUNO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbBiblioteca`.`TB_ALUNO` (
  `CD_ALUNO` INT NOT NULL AUTO_INCREMENT,
  `RA_ALUNO` INT NOT NULL,
  `NM_ALUNO` VARCHAR(45) NOT NULL,
  `TEL_ALUNO` VARCHAR(45) NOT NULL,
  `END_ALUNO` VARCHAR(45) NOT NULL,
  `EMAIL_ALUNO` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`CD_ALUNO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbBiblioteca`.`TB_EMPRESTIMO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbBiblioteca`.`TB_EMPRESTIMO` (
  `CD_EMPRESTIMO` INT NOT NULL AUTO_INCREMENT,
  `CD_ALUNO` INT NOT NULL,
  `DT_EMPRESTIMO` DATE NOT NULL,
  `DT_DEVOLUCAO` DATE NULL,
  PRIMARY KEY (`CD_EMPRESTIMO`),
  INDEX `fk_TB_EMPRESTIMO_TB_ALUNO_idx` (`CD_ALUNO` ASC),
  CONSTRAINT `fk_TB_EMPRESTIMO_TB_ALUNO`
    FOREIGN KEY (`CD_ALUNO`)
    REFERENCES `dbBiblioteca`.`TB_ALUNO` (`CD_ALUNO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbBiblioteca`.`TB_ITEM_EMPRESTIMO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbBiblioteca`.`TB_ITEM_EMPRESTIMO` (
  `CD_ACERVO` INT NOT NULL,
  `CD_EMPRESTIMO` INT NOT NULL,
  PRIMARY KEY (`CD_ACERVO`, `CD_EMPRESTIMO`),
  INDEX `fk_TB_ITEM_EMPRESTIMO_TB_EMPRESTIMO1_idx` (`CD_EMPRESTIMO` ASC),
  CONSTRAINT `fk_TB_ITEM_EMPRESTIMO_TB_ACERVO1`
    FOREIGN KEY (`CD_ACERVO`)
    REFERENCES `dbBiblioteca`.`TB_ACERVO` (`CD_ACERVO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_ITEM_EMPRESTIMO_TB_EMPRESTIMO1`
    FOREIGN KEY (`CD_EMPRESTIMO`)
    REFERENCES `dbBiblioteca`.`TB_EMPRESTIMO` (`CD_EMPRESTIMO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
