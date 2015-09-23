CREATE DATABASE  IF NOT EXISTS `logiware` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `logiware`;
-- MySQL dump 10.13  Distrib 5.5.32, for Linux (i686)
--
-- Host: localhost    Database: logiware
-- ------------------------------------------------------
-- Server version	5.5.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COMP_ID` int(10) unsigned NOT NULL,
  `STATE_ID` int(10) unsigned NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `DEL_FLAG` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`ID`),
  KEY `FK_city` (`STATE_ID`),
  KEY `FK_city_comp` (`COMP_ID`),
  CONSTRAINT `FK_city` FOREIGN KEY (`STATE_ID`) REFERENCES `state` (`ID`),
  CONSTRAINT `FK_city_comp` FOREIGN KEY (`COMP_ID`) REFERENCES `cust_comp_branch` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (4,1,3,'Hydrabd','N');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'India');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cust_comp_branch`
--

DROP TABLE IF EXISTS `cust_comp_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cust_comp_branch` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `COMP_ID` int(10) unsigned NOT NULL,
  `ADDRESS` varchar(250) NOT NULL,
  `CONTACT_NO` int(13) NOT NULL,
  `EMAIL_ID` varchar(100) DEFAULT NULL,
  `DEL_FLAG` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`ID`),
  KEY `FK_cust_comp_branch` (`COMP_ID`),
  CONSTRAINT `FK_cust_comp_branch` FOREIGN KEY (`COMP_ID`) REFERENCES `cust_company` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust_comp_branch`
--

LOCK TABLES `cust_comp_branch` WRITE;
/*!40000 ALTER TABLE `cust_comp_branch` DISABLE KEYS */;
INSERT INTO `cust_comp_branch` VALUES (1,'Hydrabad branch',1,'ggdgfd',656546646,'fgfdgf@fdfg','N'),(2,'dgdfgdsfg',1,'fgsdg',454654,'ghdfh','N');
/*!40000 ALTER TABLE `cust_comp_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cust_comp_employee`
--

DROP TABLE IF EXISTS `cust_comp_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cust_comp_employee` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COMP_ID` int(10) unsigned NOT NULL,
  `BRANCH_ID` int(10) unsigned DEFAULT NULL,
  `NAME` varchar(100) NOT NULL,
  `ADDRESS` varchar(250) NOT NULL,
  `CONTACT_NO` varchar(13) NOT NULL,
  `GENDER` char(1) NOT NULL,
  `IS_SYS_ACC` char(1) NOT NULL DEFAULT 'N',
  `SALARAY_TYPE` varchar(10) DEFAULT NULL,
  `SALARAY` float DEFAULT NULL,
  `PAN` varchar(20) DEFAULT NULL,
  `CREATED_BY` int(10) unsigned DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_BY` int(10) unsigned DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `DEL_FLG` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`ID`),
  KEY `FK_cust_comp_employee` (`COMP_ID`),
  KEY `FK_cust_comp_employee_brnch` (`BRANCH_ID`),
  CONSTRAINT `FK_cust_comp_employee` FOREIGN KEY (`COMP_ID`) REFERENCES `cust_company` (`ID`),
  CONSTRAINT `FK_cust_comp_employee_brnch` FOREIGN KEY (`BRANCH_ID`) REFERENCES `cust_comp_branch` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust_comp_employee`
--

LOCK TABLES `cust_comp_employee` WRITE;
/*!40000 ALTER TABLE `cust_comp_employee` DISABLE KEYS */;
INSERT INTO `cust_comp_employee` VALUES (1,1,NULL,'Logistic Company','Hydrabad','7588965689','M','N','Daily',36546,'AWERFCV345',NULL,NULL,NULL,NULL,'N'),(2,1,NULL,'Priya Shelke','YDYTDT','9561153870','M','Y','Hourly',45896,'ABCDEF',NULL,NULL,NULL,NULL,'N');
/*!40000 ALTER TABLE `cust_comp_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cust_company`
--

DROP TABLE IF EXISTS `cust_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cust_company` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(250) NOT NULL,
  `CUST_ID` int(10) unsigned DEFAULT NULL,
  `CONTACT_NO1` varchar(13) NOT NULL,
  `CONTACT_NO2` varchar(13) DEFAULT NULL,
  `ADDRESS` varchar(250) NOT NULL,
  `EMAIL_ID1` varchar(250) DEFAULT NULL,
  `EMAIL_ID2` varchar(250) DEFAULT NULL,
  `PAN_NO` varchar(12) DEFAULT NULL,
  `TAN_NO` varchar(50) DEFAULT NULL,
  `LOGO` varchar(20) DEFAULT NULL,
  `TAG_LINE` varchar(100) DEFAULT NULL,
  `DEL_FLAG` char(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_cust_company` (`CUST_ID`),
  CONSTRAINT `FK_cust_company` FOREIGN KEY (`CUST_ID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust_company`
--

LOCK TABLES `cust_company` WRITE;
/*!40000 ALTER TABLE `cust_company` DISABLE KEYS */;
INSERT INTO `cust_company` VALUES (1,'Mahesh Logistics',NULL,'7588945623','9850371025','Hydrabad','xyz@gmail.com','choj@yahoo.com','AAAADE','EYTRY',NULL,'We deliver your things','N');
/*!40000 ALTER TABLE `cust_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cust_contract_company`
--

DROP TABLE IF EXISTS `cust_contract_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cust_contract_company` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `COMP_ID` int(10) unsigned NOT NULL,
  `ADDRESS` varchar(250) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `CONTACT_PERSION` varchar(150) NOT NULL,
  `CONTACT_NO1` varchar(13) NOT NULL,
  `CONTACT_NO2` varchar(13) DEFAULT NULL,
  `CREATED_BY` int(10) unsigned DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_BY` int(10) unsigned DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `DEL_FLG` char(1) DEFAULT 'N',
  PRIMARY KEY (`ID`),
  KEY `FK_cust_contract_company` (`COMP_ID`),
  CONSTRAINT `FK_cust_contract_company` FOREIGN KEY (`COMP_ID`) REFERENCES `cust_company` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust_contract_company`
--

LOCK TABLES `cust_contract_company` WRITE;
/*!40000 ALTER TABLE `cust_contract_company` DISABLE KEYS */;
INSERT INTO `cust_contract_company` VALUES (7,'Parle G',1,'fw rtret reter t ert ret','Direct','gdfgdfg','7588942517','8798754896',NULL,'2015-09-17 18:17:33',NULL,'2015-09-17 18:17:33','Y'),(8,'Parle G',1,'fw rtret reter t ert ret','Direct','gdfgdfg','7588942517','8798754896',NULL,'2015-09-17 18:20:49',NULL,'2015-09-17 18:20:49','Y'),(9,'Parle G',1,'fw rtret reter t ert ret','NONE','gdfgdfg','7588942517','8798754896',NULL,'2015-09-17 18:27:13',NULL,'2015-09-17 18:27:13','Y'),(10,'Sox',1,'fw rtret reter t ert ret','NONE','gdfgdfg','7588942517','8798754896',NULL,'2015-09-17 22:26:28',NULL,'2015-09-17 22:26:28','Y'),(11,'Sox',1,'fw rtret reter t ert ret','Direct','gdfgdfg','7588942517','8798754896',NULL,'2015-09-17 22:35:01',NULL,'2015-09-17 22:35:01','Y'),(12,'Parle G',1,'fw rtret reter t ert ret','Direct','gdfgdfg','7588942517','8798754896',NULL,'2015-09-18 14:20:59',NULL,'2015-09-18 14:20:59','Y'),(13,'Parle G',1,'fw rtret reter t ert ret','Direct','gdfgdfg','7588942517','8798754896',NULL,'2015-09-18 14:28:45',NULL,'2015-09-18 14:28:45','Y'),(14,'Parle G',1,'fw rtret reter t ert ret','NONE','gdfgdfg','7588942517','8798754896',NULL,'2015-09-18 14:35:33',NULL,'2015-09-18 14:35:33','Y'),(15,'Sox',1,'gjkgjg','Direct','gdfgdfg','7588942517','8798754896',NULL,'2015-09-18 20:12:25',NULL,'2015-09-18 20:12:25','Y'),(16,'tretre',1,'vjhvjhv','Direct','knknkn','7588942517','67676767667',NULL,'2015-09-18 20:13:34',NULL,'2015-09-18 20:13:34','Y'),(17,'Sox',1,'dff','Direct','dfsdf','7588942517','8798754896',NULL,'2015-09-18 20:17:06',NULL,'2015-09-18 20:17:06','Y'),(18,'Parle G',1,'fw rtret reter t ert ret','Direct','gdfgdfg','9561153870','8798754896',NULL,'2015-09-18 20:18:01',NULL,'2015-09-18 20:18:01','Y'),(19,'Parle G',1,'fw rtret reter t ert ret','Direct','jhgjh','9561153870','8798754896',NULL,'2015-09-18 20:19:33',NULL,'2015-09-18 20:19:33','N'),(20,'Sox',1,'fw rtret reter t ert ret','Agent','gdfgdfg','9561153870','8798754896',NULL,'2015-09-18 20:26:17',NULL,'2015-09-18 20:26:17','N'),(21,'Sox',1,'fw rtret reter t ert ret','Direct','gdfgdfg','9623967593','8798754896',NULL,'2015-09-18 20:29:02',NULL,'2015-09-18 20:29:02','N'),(22,'ml',1,'kmlk','Direct','knlknlk','9623967593','7675675',NULL,'2015-09-18 20:34:42',NULL,'2015-09-18 20:34:42','N');
/*!40000 ALTER TABLE `cust_contract_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cust_contract_company_exceptions`
--

DROP TABLE IF EXISTS `cust_contract_company_exceptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cust_contract_company_exceptions` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CONTRACT_COMP_ID` int(10) unsigned NOT NULL,
  `EXCEPTION_NAME` varchar(250) NOT NULL,
  `EXCEPTION_COST` double NOT NULL,
  `ADD_TYPE` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_cust_contract_company_exceptions` (`CONTRACT_COMP_ID`),
  CONSTRAINT `FK_cust_contract_company_exceptions` FOREIGN KEY (`CONTRACT_COMP_ID`) REFERENCES `cust_contract_company` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust_contract_company_exceptions`
--

LOCK TABLES `cust_contract_company_exceptions` WRITE;
/*!40000 ALTER TABLE `cust_contract_company_exceptions` DISABLE KEYS */;
/*!40000 ALTER TABLE `cust_contract_company_exceptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cust_contract_pay_setting`
--

DROP TABLE IF EXISTS `cust_contract_pay_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cust_contract_pay_setting` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CONTRACT_COMP_ID` int(10) unsigned NOT NULL,
  `PAY_DURATION` varchar(10) NOT NULL,
  `ADVANCE_AMT` double NOT NULL,
  `PAYMENT_DATE` int(11) DEFAULT NULL,
  `IS_LODING_INCLUDE` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_cust_contract_pay_setting` (`CONTRACT_COMP_ID`),
  CONSTRAINT `FK_cust_contract_pay_setting` FOREIGN KEY (`CONTRACT_COMP_ID`) REFERENCES `cust_contract_company` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust_contract_pay_setting`
--

LOCK TABLES `cust_contract_pay_setting` WRITE;
/*!40000 ALTER TABLE `cust_contract_pay_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `cust_contract_pay_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cust_contract_route`
--

DROP TABLE IF EXISTS `cust_contract_route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cust_contract_route` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CONTRACT_COMP_ID` int(10) unsigned NOT NULL,
  `START_ROUTE` int(10) unsigned NOT NULL,
  `END_ROUTE` int(10) unsigned NOT NULL,
  `TRANSPORT_DTL_ID` int(10) unsigned NOT NULL,
  `COST` double NOT NULL,
  `ADVANCE_AMT` double DEFAULT NULL,
  `CREATED_BY` int(10) unsigned NOT NULL,
  `CREATED_ON` datetime NOT NULL,
  `UPDATED_BY` int(10) unsigned DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `DEL_FLG` char(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`ID`),
  KEY `FK_cust_contract_route` (`CONTRACT_COMP_ID`),
  KEY `FK_cust_contract_route_tr` (`TRANSPORT_DTL_ID`),
  KEY `FK_cust_contract_route_strt` (`START_ROUTE`),
  KEY `FK_cust_contract_route_end` (`END_ROUTE`),
  CONSTRAINT `FK_cust_contract_route` FOREIGN KEY (`CONTRACT_COMP_ID`) REFERENCES `cust_contract_company` (`ID`),
  CONSTRAINT `FK_cust_contract_route_end` FOREIGN KEY (`END_ROUTE`) REFERENCES `city` (`ID`),
  CONSTRAINT `FK_cust_contract_route_strt` FOREIGN KEY (`START_ROUTE`) REFERENCES `city` (`ID`),
  CONSTRAINT `FK_cust_contract_route_tr` FOREIGN KEY (`TRANSPORT_DTL_ID`) REFERENCES `cust_transport_type_dtl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust_contract_route`
--

LOCK TABLES `cust_contract_route` WRITE;
/*!40000 ALTER TABLE `cust_contract_route` DISABLE KEYS */;
/*!40000 ALTER TABLE `cust_contract_route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cust_transport_type`
--

DROP TABLE IF EXISTS `cust_transport_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cust_transport_type` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COMP_ID` int(10) unsigned NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `DEL_FLG` char(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_cust_transport_type` (`COMP_ID`),
  CONSTRAINT `FK_cust_transport_type` FOREIGN KEY (`COMP_ID`) REFERENCES `cust_company` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust_transport_type`
--

LOCK TABLES `cust_transport_type` WRITE;
/*!40000 ALTER TABLE `cust_transport_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `cust_transport_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cust_transport_type_dtl`
--

DROP TABLE IF EXISTS `cust_transport_type_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cust_transport_type_dtl` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TRANS_ID` int(10) unsigned NOT NULL,
  `TRUCK_NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `SIZE` varchar(50) NOT NULL,
  `UNIT` int(10) unsigned NOT NULL,
  `WHEEL_NOS` int(11) NOT NULL,
  `WIDTH` varchar(50) NOT NULL,
  `MAX_CAPACITY` varchar(15) NOT NULL,
  `CAPACITY` varchar(15) NOT NULL,
  `DEL_FLAG` char(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_cust_transport_type_dtl` (`TRANS_ID`),
  KEY `FK_cust_transport_type_dtl_unit` (`UNIT`),
  CONSTRAINT `FK_cust_transport_type_dtl` FOREIGN KEY (`TRANS_ID`) REFERENCES `cust_transport_type` (`ID`),
  CONSTRAINT `FK_cust_transport_type_dtl_unit` FOREIGN KEY (`UNIT`) REFERENCES `unit` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust_transport_type_dtl`
--

LOCK TABLES `cust_transport_type_dtl` WRITE;
/*!40000 ALTER TABLE `cust_transport_type_dtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `cust_transport_type_dtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `CONTACT_NO` varchar(13) NOT NULL,
  `EMAIL_ID` varchar(250) DEFAULT NULL,
  `WEBSITE` varchar(250) DEFAULT NULL,
  `PRICE_PLAN_ID` int(10) unsigned NOT NULL,
  `ADDRESS` varchar(250) DEFAULT NULL,
  `EMP_ID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_customer_plan` (`PRICE_PLAN_ID`),
  KEY `FK_customer_emp` (`EMP_ID`),
  CONSTRAINT `FK_customer_emp` FOREIGN KEY (`EMP_ID`) REFERENCES `cust_comp_employee` (`ID`),
  CONSTRAINT `FK_customer_plan` FOREIGN KEY (`PRICE_PLAN_ID`) REFERENCES `price_plan` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Mahesh','7588942517','itamol.shelke@gmail.com',NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lowery_owner`
--

DROP TABLE IF EXISTS `lowery_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lowery_owner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `COMP_ID` int(11) DEFAULT NULL,
  `BRANCH_ID` int(11) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `ADDRESS` varchar(45) DEFAULT NULL,
  `CONTACT_NO` varchar(45) DEFAULT NULL,
  `CONTACT_PERSION` varchar(45) DEFAULT NULL,
  `EMAIL_ID` varchar(45) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `UPDATED_BY` int(11) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `DEL_FLG` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lowery_owner`
--

LOCK TABLES `lowery_owner` WRITE;
/*!40000 ALTER TABLE `lowery_owner` DISABLE KEYS */;
INSERT INTO `lowery_owner` VALUES (3,1,1,'adfsdfsdf','sdfsdf','45555566666666','dfgdfg','dfgdfg',NULL,NULL,NULL,NULL,'Y'),(4,1,1,'wwwww','wwww','2222222','www','wwwww',NULL,NULL,NULL,NULL,'Y'),(5,1,1,'aaaaa','aaaaaaa','32434','aaaaaaaa','aaaaaaa',NULL,NULL,NULL,NULL,'Y'),(6,1,1,'Ajinkya Kshirsagar','Pune','9028341164','Raj','ajinkya@gmail.com',NULL,NULL,NULL,NULL,'N');
/*!40000 ALTER TABLE `lowery_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `module` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner_transport_details`
--

DROP TABLE IF EXISTS `owner_transport_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owner_transport_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOWERY_NO` varchar(45) DEFAULT NULL,
  `TRANSPORT_TYPE_DTL_ID` int(11) DEFAULT NULL,
  `LOWERY_OWNER_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `UPDATED_BY` int(11) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `DEL_FLAG` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner_transport_details`
--

LOCK TABLES `owner_transport_details` WRITE;
/*!40000 ALTER TABLE `owner_transport_details` DISABLE KEYS */;
INSERT INTO `owner_transport_details` VALUES (1,'321',2,1,NULL,1,NULL,NULL,'N'),(2,'321',2,1,NULL,1,NULL,NULL,'N');
/*!40000 ALTER TABLE `owner_transport_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pages`
--

DROP TABLE IF EXISTS `pages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pages` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `INDEX_NO` int(11) NOT NULL,
  `URI` int(11) NOT NULL,
  `TAB_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_pages` (`TAB_ID`),
  CONSTRAINT `FK_pages` FOREIGN KEY (`TAB_ID`) REFERENCES `tabs` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pages`
--

LOCK TABLES `pages` WRITE;
/*!40000 ALTER TABLE `pages` DISABLE KEYS */;
/*!40000 ALTER TABLE `pages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_plan`
--

DROP TABLE IF EXISTS `price_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_plan` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `PRICE` double NOT NULL,
  `ROLE_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_price_plan` (`ROLE_ID`),
  CONSTRAINT `FK_price_plan` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_plan`
--

LOCK TABLES `price_plan` WRITE;
/*!40000 ALTER TABLE `price_plan` DISABLE KEYS */;
INSERT INTO `price_plan` VALUES (1,'Price Plan 1',NULL,100000,1);
/*!40000 ALTER TABLE `price_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_plan_details`
--

DROP TABLE IF EXISTS `price_plan_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_plan_details` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PRICE_PLAN_ID` int(10) unsigned NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_price_plan_details` (`PRICE_PLAN_ID`),
  CONSTRAINT `FK_price_plan_details` FOREIGN KEY (`PRICE_PLAN_ID`) REFERENCES `price_plan` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_plan_details`
--

LOCK TABLES `price_plan_details` WRITE;
/*!40000 ALTER TABLE `price_plan_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `price_plan_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raw_messages`
--

DROP TABLE IF EXISTS `raw_messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `raw_messages` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `MSG` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raw_messages`
--

LOCK TABLES `raw_messages` WRITE;
/*!40000 ALTER TABLE `raw_messages` DISABLE KEYS */;
INSERT INTO `raw_messages` VALUES (1,'Yuor company registered in our company '),(2,'Yuor company registered in our company '),(3,'Yuor company registered in our company '),(4,'Yuor company registered in our company ');
/*!40000 ALTER TABLE `raw_messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `ORG_CODE` int(10) DEFAULT NULL,
  `CREATED_ON` datetime NOT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `UPDATED_BY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'SysAdmin',NULL,NULL,'2015-08-01 00:00:00',NULL,NULL,NULL),(2,'Admin',NULL,NULL,'2015-08-01 00:00:00',NULL,NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_tab`
--

DROP TABLE IF EXISTS `role_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_tab` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(10) unsigned NOT NULL,
  `TAB_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_role_tab` (`TAB_ID`),
  KEY `FK_role_tab_role` (`ROLE_ID`),
  CONSTRAINT `FK_role_tab` FOREIGN KEY (`TAB_ID`) REFERENCES `tabs` (`ID`),
  CONSTRAINT `FK_role_tab_role` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_tab`
--

LOCK TABLES `role_tab` WRITE;
/*!40000 ALTER TABLE `role_tab` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings`
--

DROP TABLE IF EXISTS `settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COMP_ID` int(10) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `VALUE` varchar(50) NOT NULL,
  `DISPLAY_TYPE` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings`
--

LOCK TABLES `settings` WRITE;
/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
INSERT INTO `settings` VALUES (1,1,'CONTRACT_COMP_SMS','Y','CONTRACT_COMP_SMS','rty');
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_config`
--

DROP TABLE IF EXISTS `sms_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_config` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORG_ID` varchar(15) NOT NULL,
  `URL` varchar(200) NOT NULL,
  `UID` varchar(100) NOT NULL,
  `PIN` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_config`
--

LOCK TABLES `sms_config` WRITE;
/*!40000 ALTER TABLE `sms_config` DISABLE KEYS */;
INSERT INTO `sms_config` VALUES (2,'1','http://smsalertbox.com/api/','616d6f6c73353036','4f36aa3903768');
/*!40000 ALTER TABLE `sms_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_inbox`
--

DROP TABLE IF EXISTS `sms_inbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_inbox` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORG_CODE` varchar(45) DEFAULT NULL,
  `ROUTE` int(11) DEFAULT NULL,
  `MOBILE` varchar(45) DEFAULT NULL,
  `RAW_MSG_ID` int(11) DEFAULT NULL,
  `MSG_ID` varchar(45) DEFAULT NULL,
  `MSG_PUSH_ID` varchar(45) DEFAULT NULL,
  `MSG_STATUS` enum('SENT','DELIVERED','DND','FAILED','PROCESSING') DEFAULT NULL,
  `SENT_ON` datetime DEFAULT NULL,
  `DELEVERED_ON` datetime DEFAULT NULL,
  `DEL_FLG` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `RAW_MSG_ID_FK_idx` (`RAW_MSG_ID`),
  CONSTRAINT `RAW_MSG_ID_FK` FOREIGN KEY (`RAW_MSG_ID`) REFERENCES `raw_messages` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_inbox`
--

LOCK TABLES `sms_inbox` WRITE;
/*!40000 ALTER TABLE `sms_inbox` DISABLE KEYS */;
INSERT INTO `sms_inbox` VALUES (1,'1',4,'7588942517',1,'410959263',NULL,'PROCESSING','2015-09-18 14:35:36',NULL,'N'),(2,'1',4,'7588942517',2,'411104156',NULL,'PROCESSING','2015-09-18 20:12:42',NULL,'N'),(3,'1',4,'9561153870',3,'411106544',NULL,'PROCESSING','2015-09-18 20:27:29',NULL,'N'),(4,'1',4,'9623967593',4,'411107705',NULL,'PROCESSING','2015-09-18 20:34:52',NULL,'N');
/*!40000 ALTER TABLE `sms_inbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_template`
--

DROP TABLE IF EXISTS `sms_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_template` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COMP_ID` int(10) NOT NULL,
  `MESSAGE` varchar(1000) NOT NULL,
  `TEMPLATE_TYPE` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_template`
--

LOCK TABLES `sms_template` WRITE;
/*!40000 ALTER TABLE `sms_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COUNTRY_ID` int(10) unsigned NOT NULL,
  `NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_state` (`COUNTRY_ID`),
  CONSTRAINT `FK_state` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `country` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (2,1,'Maharashtra'),(3,1,'A. Pradesh');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabs`
--

DROP TABLE IF EXISTS `tabs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabs` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `MODULE_ID` int(10) unsigned NOT NULL,
  `INDEX_NO` int(11) NOT NULL,
  `PARENT_ID` int(10) unsigned DEFAULT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_tabs` (`MODULE_ID`),
  KEY `FK_tabs_parent` (`PARENT_ID`),
  CONSTRAINT `FK_tabs` FOREIGN KEY (`MODULE_ID`) REFERENCES `module` (`ID`),
  CONSTRAINT `FK_tabs_parent` FOREIGN KEY (`PARENT_ID`) REFERENCES `tabs` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabs`
--

LOCK TABLES `tabs` WRITE;
/*!40000 ALTER TABLE `tabs` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unit` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `USER_ID` int(10) unsigned NOT NULL,
  `USER_TYPE` varchar(15) NOT NULL,
  `LAST_LOGIN` datetime NOT NULL,
  `FAILED_ATTEMPT` int(11) NOT NULL,
  `EMP_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_user_login_emp` (`EMP_ID`),
  CONSTRAINT `FK_user_login_emp` FOREIGN KEY (`EMP_ID`) REFERENCES `cust_comp_employee` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
INSERT INTO `user_login` VALUES (1,'admin','password',1,'ADMIN','2015-08-01 00:00:00',0,1);
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-23 18:48:49
