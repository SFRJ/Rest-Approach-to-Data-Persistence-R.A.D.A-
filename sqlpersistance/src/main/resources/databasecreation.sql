SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `hibernate_schema` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `hibernate_schema` ;

-- -----------------------------------------------------
-- Table `hibernate_schema`.`ADDRESS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hibernate_schema`.`ADDRESS` (
  `UNIQUE_ID` INT NOT NULL,
  `FIRST_LINE` VARCHAR(45) NULL,
  `SECOND_LINE` VARCHAR(45) NULL,
  `POSTCODE` VARCHAR(45) NULL,
  PRIMARY KEY (`UNIQUE_ID`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hibernate_schema`.`PERSON`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hibernate_schema`.`PERSON` (
  `UNIQUE_ID` INT NOT NULL,
  `FIRST_NAME` VARCHAR(45) NULL,
  `SECOND_NAME` VARCHAR(45) NULL,
  `FK_ADDRESS` INT NULL,
  PRIMARY KEY (`UNIQUE_ID`),
  INDEX `fk_PERSON_ADDRESS_idx` (`FK_ADDRESS` ASC),
  CONSTRAINT `fk_PERSON_ADDRESS`
  FOREIGN KEY (`FK_ADDRESS`)
  REFERENCES `hibernate_schema`.`ADDRESS` (`UNIQUE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;