/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.24 : Database - pf
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `demo`;

/*Table structure for table `sys_users` */

DROP TABLE IF EXISTS `sys_users`;

CREATE TABLE `sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(20) NOT NULL DEFAULT '',
  `password` char(20) NOT NULL DEFAULT '',
  `nickname` char(20) NOT NULL DEFAULT '',
  `gender` smallint(1) DEFAULT NULL COMMENT '男;女',
  `age` int(3) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `login_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ip` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_users` */

insert  into `sys_users`(`id`,`username`,`password`,`nickname`,`gender`,`age`,`create_time`,`login_time`,`ip`) values (1,'111','111','111',1,21,'2017-07-31 15:46:32','2017-08-01 15:46:36','0.0.0.0.0.0.1'),(2,'222','222','222',1,22,'2017-07-31 17:39:29','2017-08-01 17:39:32','0.0.0.0.0.0.1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
