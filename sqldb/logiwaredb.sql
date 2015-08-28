/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.5.43-0ubuntu0.14.04.1 : Database - sql687652
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`logiware` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `logiware`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `STATE_ID` int(10) unsigned NOT NULL,
  `NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_city` (`STATE_ID`),
  CONSTRAINT `FK_city` FOREIGN KEY (`STATE_ID`) REFERENCES `state` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `city` */

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `country` */

/*Table structure for table `cust_comp_branch` */

DROP TABLE IF EXISTS `cust_comp_branch`;

CREATE TABLE `cust_comp_branch` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `COMP_ID` int(10) unsigned NOT NULL,
  `ADDRESS` varchar(250) NOT NULL,
  `CONTACT_NO` int(13) NOT NULL,
  `EMAIL_ID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_cust_comp_branch` (`COMP_ID`),
  CONSTRAINT `FK_cust_comp_branch` FOREIGN KEY (`COMP_ID`) REFERENCES `cust_company` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cust_comp_branch` */

/*Table structure for table `cust_comp_employee` */

DROP TABLE IF EXISTS `cust_comp_employee`;

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
  `CREATED_BY` int(10) unsigned NOT NULL,
  `CREATED_ON` datetime NOT NULL,
  `UPDATED_BY` int(10) unsigned DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `DEL_FLG` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`ID`),
  KEY `FK_cust_comp_employee` (`COMP_ID`),
  KEY `FK_cust_comp_employee_brnch` (`BRANCH_ID`),
  CONSTRAINT `FK_cust_comp_employee` FOREIGN KEY (`COMP_ID`) REFERENCES `cust_company` (`ID`),
  CONSTRAINT `FK_cust_comp_employee_brnch` FOREIGN KEY (`BRANCH_ID`) REFERENCES `cust_comp_branch` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cust_comp_employee` */

/*Table structure for table `cust_company` */

DROP TABLE IF EXISTS `cust_company`;

CREATE TABLE `cust_company` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(250) NOT NULL,
  `CUST_ID` int(10) unsigned NOT NULL,
  `CONTACT_NO1` varchar(13) NOT NULL,
  `CONTACT_NO2` varchar(13) DEFAULT NULL,
  `ADDRESS` varchar(250) NOT NULL,
  `EMAIL_ID1` varchar(250) DEFAULT NULL,
  `EMAIL_ID2` varchar(250) DEFAULT NULL,
  `PAN_NO` varchar(12) DEFAULT NULL,
  `TAN_NO` varchar(50) DEFAULT NULL,
  `LOGO` varchar(20) DEFAULT NULL,
  `TAG_LINE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_cust_company` (`CUST_ID`),
  CONSTRAINT `FK_cust_company` FOREIGN KEY (`CUST_ID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cust_company` */

/*Table structure for table `cust_contract_company` */

DROP TABLE IF EXISTS `cust_contract_company`;

CREATE TABLE `cust_contract_company` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `COMP_ID` int(10) unsigned NOT NULL,
  `ADDRESS` varchar(250) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `CONTACT_PERSION` varchar(150) NOT NULL,
  `CONTACT_NO1` varchar(13) NOT NULL,
  `CONTACT_NO2` varchar(13) DEFAULT NULL,
  `CREATED_BY` int(10) unsigned NOT NULL,
  `CREATED_ON` datetime NOT NULL,
  `UPDATED_BY` int(10) unsigned DEFAULT NULL,
  `UPDATED_ON` datetime DEFAULT NULL,
  `DEL_FLG` char(1) DEFAULT 'N',
  PRIMARY KEY (`ID`),
  KEY `FK_cust_contract_company` (`COMP_ID`),
  CONSTRAINT `FK_cust_contract_company` FOREIGN KEY (`COMP_ID`) REFERENCES `cust_company` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cust_contract_company` */

/*Table structure for table `cust_contract_company_exceptions` */

DROP TABLE IF EXISTS `cust_contract_company_exceptions`;

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

/*Data for the table `cust_contract_company_exceptions` */

/*Table structure for table `cust_contract_pay_setting` */

DROP TABLE IF EXISTS `cust_contract_pay_setting`;

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

/*Data for the table `cust_contract_pay_setting` */

/*Table structure for table `cust_contract_route` */

DROP TABLE IF EXISTS `cust_contract_route`;

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

/*Data for the table `cust_contract_route` */

/*Table structure for table `cust_transport_type` */

DROP TABLE IF EXISTS `cust_transport_type`;

CREATE TABLE `cust_transport_type` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COMP_ID` int(10) unsigned NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_cust_transport_type` (`COMP_ID`),
  CONSTRAINT `FK_cust_transport_type` FOREIGN KEY (`COMP_ID`) REFERENCES `cust_company` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cust_transport_type` */

/*Table structure for table `cust_transport_type_dtl` */

DROP TABLE IF EXISTS `cust_transport_type_dtl`;

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
  PRIMARY KEY (`ID`),
  KEY `FK_cust_transport_type_dtl` (`TRANS_ID`),
  KEY `FK_cust_transport_type_dtl_unit` (`UNIT`),
  CONSTRAINT `FK_cust_transport_type_dtl` FOREIGN KEY (`TRANS_ID`) REFERENCES `cust_transport_type` (`ID`),
  CONSTRAINT `FK_cust_transport_type_dtl_unit` FOREIGN KEY (`UNIT`) REFERENCES `unit` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cust_transport_type_dtl` */

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `CONTACT_NO` varchar(13) NOT NULL,
  `EMAIL_ID` varchar(250) DEFAULT NULL,
  `WEBSITE` varchar(250) DEFAULT NULL,
  `PRICE_PLAN_ID` int(10) unsigned NOT NULL,
  `ADDRESS` varchar(250) DEFAULT NULL,
  `EMP_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_customer_plan` (`PRICE_PLAN_ID`),
  KEY `FK_customer_emp` (`EMP_ID`),
  CONSTRAINT `FK_customer_emp` FOREIGN KEY (`EMP_ID`) REFERENCES `cust_comp_employee` (`ID`),
  CONSTRAINT `FK_customer_plan` FOREIGN KEY (`PRICE_PLAN_ID`) REFERENCES `price_plan` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `module` */

/*Table structure for table `pages` */

DROP TABLE IF EXISTS `pages`;

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

/*Data for the table `pages` */

/*Table structure for table `price_plan` */

DROP TABLE IF EXISTS `price_plan`;

CREATE TABLE `price_plan` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `PRICE` double NOT NULL,
  `ROLE_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_price_plan` (`ROLE_ID`),
  CONSTRAINT `FK_price_plan` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `price_plan` */

/*Table structure for table `price_plan_details` */

DROP TABLE IF EXISTS `price_plan_details`;

CREATE TABLE `price_plan_details` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PRICE_PLAN_ID` int(10) unsigned NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_price_plan_details` (`PRICE_PLAN_ID`),
  CONSTRAINT `FK_price_plan_details` FOREIGN KEY (`PRICE_PLAN_ID`) REFERENCES `price_plan` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `price_plan_details` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `role` */

/*Table structure for table `role_tab` */

DROP TABLE IF EXISTS `role_tab`;

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

/*Data for the table `role_tab` */

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COUNTRY_ID` int(10) unsigned NOT NULL,
  `NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_state` (`COUNTRY_ID`),
  CONSTRAINT `FK_state` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `country` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `state` */

/*Table structure for table `tabs` */

DROP TABLE IF EXISTS `tabs`;

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

/*Data for the table `tabs` */

/*Table structure for table `unit` */

DROP TABLE IF EXISTS `unit`;

CREATE TABLE `unit` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `unit` */

/*Table structure for table `user_login` */

DROP TABLE IF EXISTS `user_login`;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_login` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
