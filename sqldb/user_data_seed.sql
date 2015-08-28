/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.6.24 : Database - logiware
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`logiware` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `logiware`;

/*Data for the table `cust_comp_employee` */

insert  into `cust_comp_employee`(`ID`,`COMP_ID`,`BRANCH_ID`,`NAME`,`ADDRESS`,`CONTACT_NO`,`GENDER`,`IS_SYS_ACC`,`SALARAY_TYPE`,`SALARAY`,`PAN`,`CREATED_BY`,`CREATED_ON`,`UPDATED_BY`,`UPDATED_ON`,`DEL_FLG`) values (1,1,NULL,'Logistic Company','Hydrabad','7588965689','M','N',NULL,NULL,NULL,1,'2015-08-01 00:00:00',NULL,NULL,'N');

/*Data for the table `cust_company` */

insert  into `cust_company`(`ID`,`NAME`,`CUST_ID`,`CONTACT_NO1`,`CONTACT_NO2`,`ADDRESS`,`EMAIL_ID1`,`EMAIL_ID2`,`PAN_NO`,`TAN_NO`,`LOGO`,`TAG_LINE`) values (1,'Logistics ',1,'7588945623',NULL,'Hydrabad','xyz@gmail.com',NULL,NULL,NULL,NULL,NULL);

/*Data for the table `customer` */

insert  into `customer`(`ID`,`NAME`,`CONTACT_NO`,`EMAIL_ID`,`WEBSITE`,`PRICE_PLAN_ID`,`ADDRESS`,`EMP_ID`) values (1,'Mahesh','7588942517','itamol.shelke@gmail.com',NULL,1,NULL,NULL);

/*Data for the table `price_plan` */

insert  into `price_plan`(`ID`,`NAME`,`DESCRIPTION`,`PRICE`,`ROLE_ID`) values (1,'Price Plan 1',NULL,100000,1);

/*Data for the table `price_plan_details` */

/*Data for the table `role` */

insert  into `role`(`ID`,`ROLE`,`DESCRIPTION`,`ORG_CODE`,`CREATED_ON`,`CREATED_BY`,`UPDATED_ON`,`UPDATED_BY`) values (1,'SysAdmin',NULL,NULL,'2015-08-01 00:00:00',NULL,NULL,NULL),(2,'Admin',NULL,NULL,'2015-08-01 00:00:00',NULL,NULL,NULL);

/*Data for the table `user_login` */

insert  into `user_login`(`ID`,`USER_NAME`,`PASSWORD`,`USER_ID`,`USER_TYPE`,`LAST_LOGIN`,`FAILED_ATTEMPT`,`EMP_ID`) values (1,'admin','password',1,'ADMIN','2015-08-01 00:00:00',0,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
