

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema metaphorcebd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema metaphorcebd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `metaphorcebd` DEFAULT CHARACTER SET utf8mb3 ;
USE `metaphorcebd` ;

-- -----------------------------------------------------
-- Table `metaphorcebd`.`contracttype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `metaphorcebd`.`contracttype` (
  `ContractTypeId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(80) NOT NULL,
  `Description` VARCHAR(255) NULL DEFAULT NULL,
  `IsActive` TINYINT NOT NULL,
  `DateCreated` DATETIME NOT NULL,
  PRIMARY KEY (`ContractTypeId`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `metaphorcebd`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `metaphorcebd`.`employee` (
  `EmployeeId` INT NOT NULL AUTO_INCREMENT,
  `TaxIdNumber` VARCHAR(13) NOT NULL,
  `Name` VARCHAR(60) NOT NULL,
  `LastName` VARCHAR(120) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `Email` VARCHAR(60) NOT NULL,
  `CellPhone` VARCHAR(20) NOT NULL,
  `IsActive` TINYINT NOT NULL,
  `DateCreated` DATETIME NOT NULL,
  PRIMARY KEY (`EmployeeId`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `metaphorcebd`.`contract`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `metaphorcebd`.`contract` (
  `ContractId` BIGINT NOT NULL AUTO_INCREMENT,
  `EmployeeId` INT NOT NULL,
  `ContractTypeId` INT NOT NULL,
  `DateFrom` DATETIME NOT NULL,
  `DateTo` DATETIME NOT NULL,
  `SalaryPerDay` DECIMAL(10,0) NOT NULL,
  `IsActive` TINYINT NOT NULL,
  `DateCreated` DATETIME NOT NULL,
  PRIMARY KEY (`ContractId`),
  INDEX `fk_Contract_Employee_idx` (`EmployeeId` ASC) ,
  INDEX `fk_Contract_ContractType1_idx` (`ContractTypeId` ASC) ,
  CONSTRAINT `fk_Contract_ContractType1`
    FOREIGN KEY (`ContractTypeId`)
    REFERENCES `metaphorcebd`.`contracttype` (`ContractTypeId`),
  CONSTRAINT `fk_Contract_Employee`
    FOREIGN KEY (`EmployeeId`)
    REFERENCES `metaphorcebd`.`employee` (`EmployeeId`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;

INSERT INTO `contracttype` VALUES (1,'Permanent',NULL,1,'2022-07-09 19:05:38'),(2,'Fixed-Term',NULL,1,'2022-07-09 19:05:38'),(3,'External',NULL,1,'2022-07-09 19:05:38');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
