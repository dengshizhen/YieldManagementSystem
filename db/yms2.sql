/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - yms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yms`;

/*Table structure for table `actionmaster` */

DROP TABLE IF EXISTS `actionmaster`;

CREATE TABLE `actionmaster` (
  `action_id` varchar(20) NOT NULL,
  `action_desc` varchar(45) NOT NULL,
  `action_group` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `actionmaster` */

/*Table structure for table `classcode` */

DROP TABLE IF EXISTS `classcode`;

CREATE TABLE `classcode` (
  `prod_id` varchar(10) NOT NULL,
  `prod_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `classcode` */

insert  into `classcode`(`prod_id`,`prod_desc`) values ('0124','台式机'),('0125','笔记本电脑'),('0126','一体机'),('0127','iPAD');

/*Table structure for table `commodity` */

DROP TABLE IF EXISTS `commodity`;

CREATE TABLE `commodity` (
  `serialnum` int(8) NOT NULL AUTO_INCREMENT,
  `ordernum` char(8) DEFAULT NULL,
  `commoditynum` char(8) DEFAULT NULL,
  `commodityname` varchar(500) DEFAULT NULL,
  `size` char(60) DEFAULT NULL,
  `color` char(8) DEFAULT NULL,
  `quantity` int(8) DEFAULT NULL,
  PRIMARY KEY (`serialnum`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

/*Data for the table `commodity` */

insert  into `commodity`(`serialnum`,`ordernum`,`commoditynum`,`commodityname`,`size`,`color`,`quantity`) values (86,'QY-17-71','000001','杂色双面绒','80*30','杂色',5040),(87,'QY170139','00002','\"刀边有带子和魔术贴2cm海绵坐垫 带子面料同正反面\" ','38*38.5cm','深灰色',10472),(88,'QY170139','000003','\"刀边有带子和魔术贴2cm海绵坐垫 带子面料同正反面\" ','38*38.5cm','绿色',4032),(89,'QY170139','000004','正面印蓝底彩色竖条纹，反面深灰色平板，单面刀边，内加2cm海绵坐垫（D型，直接封口，裁片印花）  ','38*38.5cm','绿色',4032),(90,'QY170139','000005','正面印灰色系蝴蝶，反面深灰色平板，单面刀边，内加2cm海绵坐垫（D型，直接封口，裁片印花）   ','38*38.5cm','绿色',4032),(91,'QY170139','000006','双面刀边，充400克净重汉邦棉真空压缩靠垫(隐拉) ','38*38.5cm','绿色',4032),(92,'QY170139','000007','双面刀边，充400克净重汉邦棉真空压缩靠垫(隐拉) ','38*38.5cm','绿色',4032);

/*Table structure for table `comprocess` */

DROP TABLE IF EXISTS `comprocess`;

CREATE TABLE `comprocess` (
  `serialnum` int(8) NOT NULL AUTO_INCREMENT,
  `commoditynum` char(8) DEFAULT NULL,
  `processname` varchar(60) DEFAULT NULL,
  `category` varchar(8) DEFAULT NULL,
  `univalent` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`serialnum`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

/*Data for the table `comprocess` */

insert  into `comprocess`(`serialnum`,`commoditynum`,`processname`,`category`,`univalent`) values (120,'000001','裁剪刀','裁剪','0.06'),(121,'000001','剪毛 检验','车缝','0.08'),(122,'000001','拷边夹标','车缝','0.05'),(123,'00002','手剪','裁剪','0.03'),(124,'00002','点塑布五线拷边','车缝','0.02'),(125,'000003','剪验腰带','车缝','0.03'),(126,'000004','剪验腰带','车缝','0.03'),(127,'000005','验回修','检验','0.02'),(128,'000006','全工序','包装','0.03'),(129,'000007','点塑布五线拷边','车缝','0.01'),(130,'000001','剪毛 检验','车缝','0.06'),(131,'000001','检验 剪毛','检验','0.03');

/*Table structure for table `currency` */

DROP TABLE IF EXISTS `currency`;

CREATE TABLE `currency` (
  `cur_id` varchar(10) NOT NULL,
  `cur_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `currency` */

insert  into `currency`(`cur_id`,`cur_desc`) values ('AUD','澳大利亚元'),('CNY','人民币元'),('DEM','马克'),('GBP','英镑'),('HKD','港元'),('INR','卢比'),('JPY','日圆 '),('KPW','朝鲜圆'),('LAK','基普'),('MOP','澳门元'),('MYR','马元 '),('THP','泰铢'),('VND','越南盾');

/*Table structure for table `currencyrate` */

DROP TABLE IF EXISTS `currencyrate`;

CREATE TABLE `currencyrate` (
  `cur_id` varchar(10) NOT NULL,
  `cur_id1` varchar(10) NOT NULL,
  `Mouth1` smallint(6) NOT NULL,
  `Cur_rate` double NOT NULL,
  PRIMARY KEY (`cur_id`,`cur_id1`,`Mouth1`,`Cur_rate`),
  KEY `FK3BF8CC7178BBFD9` (`cur_id`),
  KEY `FK3BF8CC719B192056` (`cur_id1`),
  CONSTRAINT `FK3BF8CC7178BBFD9` FOREIGN KEY (`cur_id`) REFERENCES `currency` (`cur_id`),
  CONSTRAINT `FK3BF8CC719B192056` FOREIGN KEY (`cur_id1`) REFERENCES `currency` (`cur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `currencyrate` */

/*Table structure for table `daily_production` */

DROP TABLE IF EXISTS `daily_production`;

CREATE TABLE `daily_production` (
  `serialnum` int(8) NOT NULL AUTO_INCREMENT,
  `jobnum` char(8) DEFAULT NULL,
  `ordernum` char(8) DEFAULT NULL,
  `commoditynum` char(8) DEFAULT NULL,
  `commodityname` varchar(200) DEFAULT NULL,
  `processname` varchar(60) DEFAULT NULL,
  `univalent` double DEFAULT NULL,
  `quantity` int(8) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `remarks` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`serialnum`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8;

/*Data for the table `daily_production` */

insert  into `daily_production`(`serialnum`,`jobnum`,`ordernum`,`commoditynum`,`commodityname`,`processname`,`univalent`,`quantity`,`total`,`time`,`remarks`) values (116,'base','QY-17-71','000001','杂色双面绒','裁剪刀',0.06,0,0,'2017-03-06 11:50:20','无'),(117,'base','QY-17-71','000001','杂色双面绒','剪毛 检验',0.07,0,0,'2017-03-06 11:50:31','无'),(118,'base','QY-17-71','000001','杂色双面绒','拷边夹标',0.05,0,0,'2017-03-06 11:50:41','无'),(119,'02','QY-17-71','000001','杂色双面绒','裁剪刀',0.06,580,34.8,'2017-03-06 11:56:06','无'),(120,'base','QY170139','00002','\"刀边有带子和魔术贴2cm海绵坐垫 带子面料同正反面\" ','点塑布五线拷边',0.02,0,0,'2017-03-07 13:21:38','无'),(121,'base','QY170139','000003','\"刀边有带子和魔术贴2cm海绵坐垫 带子面料同正反面\" ','剪验腰带',0.03,0,0,'2017-03-07 13:23:10','无'),(122,'base','QY170139','000004','正面印蓝底彩色竖条纹，反面深灰色平板，单面刀边，内加2cm海绵坐垫（D型，直接封口，裁片印花）  ','剪验腰带',0.03,0,0,'2017-03-07 13:23:41','无'),(123,'base','QY170139','000005','正面印灰色系蝴蝶，反面深灰色平板，单面刀边，内加2cm海绵坐垫（D型，直接封口，裁片印花）   ','验回修',0.02,0,0,'2017-03-07 13:23:58','无'),(124,'base','QY170139','000006','双面刀边，充400克净重汉邦棉真空压缩靠垫(隐拉) ','全工序',0.03,0,0,'2017-03-07 13:24:16','无'),(125,'base','QY170139','000007','双面刀边，充400克净重汉邦棉真空压缩靠垫(隐拉) ','点塑布五线拷边',0.01,0,0,'2017-03-07 13:24:55','无'),(126,'cf0002','QY170139','000004','正面印蓝底彩色竖条纹，反面深灰色平板，单面刀边，内加2cm海绵坐垫（D型，直接封口，裁片印花）  ','剪验腰带',0.03,100,3,'2017-03-07 13:40:24','无'),(127,'02','QY170139','000003','\"刀边有带子和魔术贴2cm海绵坐垫 带子面料同正反面\" ','剪验腰带',0.03,100,3,'2017-03-07 13:41:34','无'),(128,'cf0002','QY170139','000003','\"刀边有带子和魔术贴2cm海绵坐垫 带子面料同正反面\" ','剪验腰带',0.03,300,9,'2017-03-07 13:42:28','无'),(129,'cf0119','QY170139','000005','正面印灰色系蝴蝶，反面深灰色平板，单面刀边，内加2cm海绵坐垫（D型，直接封口，裁片印花）   ','验回修',0.02,12,0.24,'2017-03-08 12:19:40','无'),(132,'000003','QY-17-71','000001','杂色双面绒','裁剪刀',0.06,200,12,'2017-03-10 08:53:30','无'),(133,'base','QY-17-71','000001','杂色双面绒','剪毛 检验',0.08,0,0,'2017-03-10 09:35:00','无'),(134,'base','QY-17-71','000001','杂色双面绒','剪毛 检验',0.06,0,0,'2017-03-10 09:35:25','无'),(135,'base','QY-17-71','000001','杂色双面绒','检验 剪毛',0.03,0,0,'2017-03-10 09:35:53','无');

/*Table structure for table `eceipt` */

DROP TABLE IF EXISTS `eceipt`;

CREATE TABLE `eceipt` (
  `Key_id` int(11) NOT NULL,
  `Item_id` varchar(10) NOT NULL,
  `Loca_id` varchar(10) NOT NULL COMMENT '浠?浣?',
  `Ware_id` varchar(10) NOT NULL,
  `Reas_code` varchar(10) NOT NULL COMMENT '??ュ????????',
  `Re_type` varchar(1) NOT NULL COMMENT '??ュ??绫诲??',
  `Qty` double NOT NULL COMMENT '??ュ????伴??',
  `Bill_no` varchar(20) NOT NULL,
  `Actual_Qty` double NOT NULL,
  `AdJu_amt` double NOT NULL COMMENT '搴?瀛?璋???撮??棰?',
  `Trans_date` datetime DEFAULT NULL,
  PRIMARY KEY (`Key_id`),
  KEY `FKB1FC0F46BB2534FC` (`Loca_id`),
  KEY `FKB1FC0F46EC2CA92E` (`Item_id`),
  KEY `FKB1FC0F46BB541A13` (`Reas_code`),
  KEY `FKB1FC0F464B87AE52` (`Ware_id`),
  CONSTRAINT `FKB1FC0F464B87AE52` FOREIGN KEY (`Ware_id`) REFERENCES `warehouse` (`Ware_id`),
  CONSTRAINT `FKB1FC0F46BB2534FC` FOREIGN KEY (`Loca_id`) REFERENCES `location` (`Loca_id`),
  CONSTRAINT `FKB1FC0F46BB541A13` FOREIGN KEY (`Reas_code`) REFERENCES `stockreason` (`Rea_code`),
  CONSTRAINT `FKB1FC0F46EC2CA92E` FOREIGN KEY (`Item_id`) REFERENCES `itemgeneral` (`Item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `eceipt` */

/*Table structure for table `eceipt_bill` */

DROP TABLE IF EXISTS `eceipt_bill`;

CREATE TABLE `eceipt_bill` (
  `bill_no` varchar(20) NOT NULL,
  `create_emp` varchar(10) NOT NULL COMMENT '??跺??浜?',
  `handle_emp` varchar(10) DEFAULT NULL COMMENT '缁????浜?',
  `bill_desc` varchar(200) DEFAULT NULL COMMENT '???瑕?',
  `createDate` datetime NOT NULL COMMENT '??跺????堕??',
  `lastHandleDate` datetime DEFAULT NULL COMMENT '??????澶??????堕??',
  `SourceCompany` varchar(45) NOT NULL COMMENT '寰???ュ??浣?',
  `cert_no` varchar(20) NOT NULL COMMENT '???绁ㄥ??',
  `status` varchar(1) NOT NULL COMMENT '??舵??',
  PRIMARY KEY (`bill_no`),
  KEY `FK41116960CE6E6A01` (`create_emp`),
  KEY `FK41116960F348C12D` (`handle_emp`),
  CONSTRAINT `FK41116960CE6E6A01` FOREIGN KEY (`create_emp`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `FK41116960F348C12D` FOREIGN KEY (`handle_emp`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `eceipt_bill` */

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `emp_id` varchar(10) NOT NULL,
  `emp_desc` varchar(45) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `folk` varchar(45) DEFAULT NULL COMMENT '姘????',
  `marri` varchar(45) DEFAULT NULL COMMENT '濠?濮?',
  `family` varchar(45) DEFAULT NULL COMMENT '瀛?濂?',
  `collage` varchar(45) DEFAULT NULL,
  `speci` varchar(45) DEFAULT NULL COMMENT '涓?涓?',
  `wage` bigint(20) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `employee` */

insert  into `employee`(`emp_id`,`emp_desc`,`birth`,`password`,`folk`,`marri`,`family`,`collage`,`speci`,`wage`) values ('1','刘大伟',NULL,'111',NULL,NULL,NULL,NULL,NULL,1);

/*Table structure for table `employeerole` */

DROP TABLE IF EXISTS `employeerole`;

CREATE TABLE `employeerole` (
  `employeeRole_id` int(11) NOT NULL,
  `employee_id` varchar(10) NOT NULL,
  `role_id` varchar(10) NOT NULL,
  PRIMARY KEY (`employeeRole_id`),
  KEY `FK99096024491CBCAA` (`role_id`),
  KEY `FK99096024B348D348` (`employee_id`),
  CONSTRAINT `FK99096024491CBCAA` FOREIGN KEY (`role_id`) REFERENCES `rolemaster` (`role_id`),
  CONSTRAINT `FK99096024B348D348` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `employeerole` */

/*Table structure for table `handle_record` */

DROP TABLE IF EXISTS `handle_record`;

CREATE TABLE `handle_record` (
  `user_time` date DEFAULT NULL,
  `user_name` varchar(16) DEFAULT NULL,
  `handle_text` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `handle_record` */

insert  into `handle_record`(`user_time`,`user_name`,`handle_text`) values ('2017-03-07','admin','登录'),('2017-03-07','admin','登录'),('2017-03-07','admin','登录'),('2017-03-07','admin','退出'),('2017-03-07','admin','登录'),('2017-03-07','admin','退出'),('2017-03-07','admin','登录'),('2017-03-07','admin','退出'),('2017-03-07','admin','登录'),('2017-03-07','admin','退出'),('2017-03-07','admin','登录'),('2017-03-07','admin','退出'),('2017-03-07','admin','登录'),('2017-03-07','admin','退出'),('2017-03-07','admin','登录'),('2017-03-07','admin','退出'),('2017-03-07','admin','登录'),('2017-03-07','admin','退出'),('2017-03-07','admin','登录'),('2017-03-08','admin','登录'),('2017-03-08','admin','退出'),('2017-03-08','admin','登录'),('2017-03-08','admin','登录'),('2017-03-08','admin','退出'),('2017-03-08','admin','登录'),('2017-03-08','admin','退出'),('2017-03-08','admin','登录'),('2017-03-08','admin','退出'),('2017-03-08','admin','登录'),('2017-03-08','admin','退出'),('2017-03-08','admin','登录'),('2017-03-08','admin','退出'),('2017-03-11','admin','登录'),('2017-03-11','admin','退出'),('2017-03-11','admin','登录'),('2017-03-11','admin','退出'),('2017-03-11','admin','登录'),('2017-03-11','admin','退出'),('2017-03-11','admin','登录'),('2017-03-11','admin','退出'),('2017-03-11','admin','登录');

/*Table structure for table `inventorytag` */

DROP TABLE IF EXISTS `inventorytag`;

CREATE TABLE `inventorytag` (
  `Lable` int(11) NOT NULL,
  `Warehouse` varchar(10) NOT NULL,
  `Audi_man` varchar(10) DEFAULT NULL,
  `Fr_loca` varchar(10) NOT NULL,
  `Fr_Item` varchar(10) NOT NULL,
  `Inc_zero` varchar(1) NOT NULL,
  `Inc_nega` varchar(1) NOT NULL,
  PRIMARY KEY (`Lable`),
  KEY `FK99F8D8BEB6F11AD0` (`Audi_man`),
  KEY `FK99F8D8BE82AB38B7` (`Fr_loca`),
  KEY `FK99F8D8BE49BA360D` (`Fr_Item`),
  KEY `FK99F8D8BE917576F8` (`Warehouse`),
  CONSTRAINT `FK99F8D8BE49BA360D` FOREIGN KEY (`Fr_Item`) REFERENCES `itemgeneral` (`Item_id`),
  CONSTRAINT `FK99F8D8BE82AB38B7` FOREIGN KEY (`Fr_loca`) REFERENCES `location` (`Loca_id`),
  CONSTRAINT `FK99F8D8BE917576F8` FOREIGN KEY (`Warehouse`) REFERENCES `warehouse` (`Ware_id`),
  CONSTRAINT `FK99F8D8BEB6F11AD0` FOREIGN KEY (`Audi_man`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `inventorytag` */

/*Table structure for table `itemgeneral` */

DROP TABLE IF EXISTS `itemgeneral`;

CREATE TABLE `itemgeneral` (
  `Item_id` varchar(10) NOT NULL,
  `Sale_Emp_id` varchar(10) DEFAULT NULL COMMENT '?????????',
  `PO_Emp_id` varchar(10) DEFAULT NULL COMMENT '???璐????',
  `Um_id` varchar(10) NOT NULL COMMENT '璁￠?????浣?',
  `Prod_code` varchar(10) NOT NULL COMMENT '???绫?',
  `Item_desc` varchar(45) DEFAULT NULL,
  `Color` varchar(20) DEFAULT NULL,
  `Tax_rate` bigint(20) NOT NULL COMMENT '0.0',
  `Sale_Pic` double DEFAULT NULL COMMENT '0.0',
  `Whol_Pic` double DEFAULT NULL COMMENT '0.0',
  `Status` varchar(1) NOT NULL,
  PRIMARY KEY (`Item_id`),
  KEY `FK782D8275B95DC52E` (`PO_Emp_id`),
  KEY `FK782D8275CC1071E6` (`Sale_Emp_id`),
  KEY `FK782D8275FBCBAB6A` (`Um_id`),
  KEY `FK782D82753F221EAC` (`Prod_code`),
  CONSTRAINT `FK782D82753F221EAC` FOREIGN KEY (`Prod_code`) REFERENCES `classcode` (`prod_id`),
  CONSTRAINT `FK782D8275B95DC52E` FOREIGN KEY (`PO_Emp_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `FK782D8275CC1071E6` FOREIGN KEY (`Sale_Emp_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `FK782D8275FBCBAB6A` FOREIGN KEY (`Um_id`) REFERENCES `ummaster` (`um_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `itemgeneral` */

insert  into `itemgeneral`(`Item_id`,`Sale_Emp_id`,`PO_Emp_id`,`Um_id`,`Prod_code`,`Item_desc`,`Color`,`Tax_rate`,`Sale_Pic`,`Whol_Pic`,`Status`) values ('BH123','1','1','0100','0125','联想笔记本电脑','白色',18,4800,4800000,'0'),('LH121','1','1','0100','0125','惠普笔记本电脑','黑色',18,3900,3900000,'1'),('NB198','1','1','0100','0125','华硕笔记本电脑','白色',18,3500,3500000,'1');

/*Table structure for table `itemlocation` */

DROP TABLE IF EXISTS `itemlocation`;

CREATE TABLE `itemlocation` (
  `Ware_id` varchar(10) NOT NULL,
  `Item_id` varchar(10) NOT NULL,
  `Loca_id` varchar(10) NOT NULL,
  `Rank` int(11) NOT NULL,
  `Loca_qty` double NOT NULL,
  PRIMARY KEY (`Ware_id`,`Item_id`,`Loca_id`,`Rank`,`Loca_qty`),
  KEY `FK92EA57C8BB2534FC` (`Loca_id`),
  KEY `FK92EA57C84B87AE52` (`Ware_id`),
  CONSTRAINT `FK92EA57C84B87AE52` FOREIGN KEY (`Ware_id`) REFERENCES `warehouse` (`Ware_id`),
  CONSTRAINT `FK92EA57C8BB2534FC` FOREIGN KEY (`Loca_id`) REFERENCES `location` (`Loca_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `itemlocation` */

/*Table structure for table `iusse` */

DROP TABLE IF EXISTS `iusse`;

CREATE TABLE `iusse` (
  `Key_id` int(11) NOT NULL,
  `Item_id` varchar(10) NOT NULL,
  `Loca_id` varchar(10) NOT NULL,
  `Ware_id` varchar(10) NOT NULL,
  `Reas_code` varchar(10) NOT NULL,
  `Is_type` varchar(1) NOT NULL,
  `Qty` double NOT NULL COMMENT '??哄????伴??',
  `Actual_Qty` double NOT NULL,
  `AdJu_amt` double NOT NULL,
  `Trans_date` datetime DEFAULT NULL COMMENT '澶??????堕??',
  `Bill_no` varchar(20) NOT NULL,
  PRIMARY KEY (`Key_id`),
  KEY `FK5FE9159BB2534FC` (`Loca_id`),
  KEY `FK5FE9159EC2CA92E` (`Item_id`),
  KEY `FK5FE9159BB541A13` (`Reas_code`),
  KEY `FK5FE91594B87AE52` (`Ware_id`),
  CONSTRAINT `FK5FE91594B87AE52` FOREIGN KEY (`Ware_id`) REFERENCES `warehouse` (`Ware_id`),
  CONSTRAINT `FK5FE9159BB2534FC` FOREIGN KEY (`Loca_id`) REFERENCES `location` (`Loca_id`),
  CONSTRAINT `FK5FE9159BB541A13` FOREIGN KEY (`Reas_code`) REFERENCES `stockreason` (`Rea_code`),
  CONSTRAINT `FK5FE9159EC2CA92E` FOREIGN KEY (`Item_id`) REFERENCES `itemgeneral` (`Item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `iusse` */

/*Table structure for table `iusse_bill` */

DROP TABLE IF EXISTS `iusse_bill`;

CREATE TABLE `iusse_bill` (
  `bill_no` varchar(20) NOT NULL,
  `create_emp` varchar(10) NOT NULL COMMENT '??跺??浜?',
  `handle_emp` varchar(10) DEFAULT NULL COMMENT '缁????浜?',
  `bill_desc` varchar(200) DEFAULT NULL,
  `createDate` datetime NOT NULL,
  `lastHandleDate` datetime DEFAULT NULL,
  `DestCompany` varchar(45) NOT NULL,
  `cert_no` varchar(20) NOT NULL COMMENT '???绁ㄥ??',
  `status` varchar(1) NOT NULL,
  PRIMARY KEY (`bill_no`),
  KEY `FK14BC3B2DCE6E6A01` (`create_emp`),
  KEY `FK14BC3B2DF348C12D` (`handle_emp`),
  CONSTRAINT `FK14BC3B2DCE6E6A01` FOREIGN KEY (`create_emp`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `FK14BC3B2DF348C12D` FOREIGN KEY (`handle_emp`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `iusse_bill` */

/*Table structure for table `location` */

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `Loca_id` varchar(10) NOT NULL,
  `Loca_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Loca_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `location` */

insert  into `location`(`Loca_id`,`Loca_desc`) values ('FH0123512','北京-西直门站-3H'),('FH0123513','北京-西直门站-4H'),('FH0123514','北京-东直门站-5D'),('FH0123515','北京-东直门站-5H'),('FH0123516','北京-上地站-1A'),('FH0123517','北京-上地站-3F'),('FH0123518','北京-上地站-6B');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `serialnum` int(8) NOT NULL AUTO_INCREMENT,
  `ordernum` char(8) DEFAULT NULL,
  PRIMARY KEY (`serialnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `physicsdata` */

DROP TABLE IF EXISTS `physicsdata`;

CREATE TABLE `physicsdata` (
  `Key_id` int(11) NOT NULL,
  `Item_id` varchar(10) NOT NULL,
  `Loca_id` varchar(10) NOT NULL,
  `Ware_id` varchar(10) NOT NULL,
  `Statue` varchar(1) NOT NULL,
  `Cutoff` double NOT NULL COMMENT '?????虫?伴??',
  `Act_qty` double NOT NULL COMMENT '瀹??????伴??',
  PRIMARY KEY (`Key_id`),
  KEY `FK82455A71BB2534FC` (`Loca_id`),
  KEY `FK82455A71EC2CA92E` (`Item_id`),
  KEY `FK82455A714B87AE52` (`Ware_id`),
  CONSTRAINT `FK82455A714B87AE52` FOREIGN KEY (`Ware_id`) REFERENCES `warehouse` (`Ware_id`),
  CONSTRAINT `FK82455A71BB2534FC` FOREIGN KEY (`Loca_id`) REFERENCES `location` (`Loca_id`),
  CONSTRAINT `FK82455A71EC2CA92E` FOREIGN KEY (`Item_id`) REFERENCES `itemgeneral` (`Item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `physicsdata` */

/*Table structure for table `processnames` */

DROP TABLE IF EXISTS `processnames`;

CREATE TABLE `processnames` (
  `serialnum` int(8) NOT NULL AUTO_INCREMENT,
  `processname` varchar(60) DEFAULT NULL,
  `category` char(8) DEFAULT NULL,
  PRIMARY KEY (`serialnum`)
) ENGINE=InnoDB AUTO_INCREMENT=374 DEFAULT CHARSET=utf8;

/*Data for the table `processnames` */

insert  into `processnames`(`serialnum`,`processname`,`category`) values (277,'热切','裁剪'),(278,'手剪','裁剪'),(279,'裁剪刀','裁剪'),(280,'点塑布五线拷边','车缝'),(281,'剪验腰带','车缝'),(282,'订标','车缝'),(283,'订吊带','车缝'),(284,'订角','车缝'),(285,'订牛津','车缝'),(286,'订织标','车缝'),(287,'定吊带位','车缝'),(288,'翻','车缝'),(289,'翻扎带','车缝'),(290,'复合布/网眼布合缝','车缝'),(291,'复合布合缝','车缝'),(292,'复合布拼斜角','车缝'),(293,'后片打杆','车缝'),(294,'麂皮绒拼斜角','车缝'),(295,'检验','车缝'),(296,'剪吊带','车缝'),(297,'剪线毛','车缝'),(298,'卷侧边','车缝'),(299,'卷上摆','车缝'),(300,'卷上下摆','车缝'),(301,'卷上下摆加衬','车缝'),(302,'卷下摆','车缝'),(303,'拷侧边','车缝'),(304,'拷拉链口边','车缝'),(305,'拷四边夹标夹牛津','车缝'),(306,'拉链定位','车缝'),(307,'拼侧缝','车缝'),(308,'拼贴片','车缝'),(309,'前后片合缝','车缝'),(310,'上摆拷四边','车缝'),(311,'上摆压线.cm','车缝'),(312,'上抽带','车缝'),(313,'上拉链','车缝'),(314,'四周合缝','车缝'),(315,'烫吊带','车缝'),(316,'烫腰带粘衬','车缝'),(317,'五线拼接网眼立高','车缝'),(318,'下摆拷边','车缝'),(319,'压线','车缝'),(320,'压线.cm','车缝'),(321,'压线.cm','车缝'),(322,'折窗帘','车缝'),(323,'针织/网眼合缝','车缝'),(324,'针织布/网眼合缝','车缝'),(325,'针织布拷四边','车缝'),(326,'针织布拷四角','车缝'),(327,'针织布网眼合缝','车缝'),(328,'针织布折四角','车缝'),(329,'做吊带','车缝'),(330,'做上摆','车缝'),(331,'做上摆整件','车缝'),(332,'做上下摆','车缝'),(333,'做下摆','车缝'),(334,'做腰带','车缝'),(335,'做扎带','车缝'),(336,'做整件','车缝'),(337,'检验','检验'),(338,'验回修','检验'),(339,'全工序','包装'),(340,'套','包装'),(341,'套袋','包装'),(342,'贴防盗标','包装'),(343,'折','包装'),(344,'折叠','包装'),(345,'折叠套袋','包装'),(346,'折套','包装'),(347,'编箱号','充棉'),(348,'充棉','充棉'),(349,'穿吊牌','充棉'),(350,'打吊牌','充棉'),(351,'开棉','充棉'),(352,'塞棉','充棉'),(353,'套封口袋','充棉'),(354,'套真空袋','充棉'),(355,'套中包袋子','充棉'),(356,'贴白色不干胶','充棉'),(357,'贴不干胶','充棉'),(358,'贴不干胶贴纸','充棉'),(359,'贴单品贴纸','充棉'),(360,'贴港口贴纸','充棉'),(361,'贴广告贴','充棉'),(362,'贴广告贴纸','充棉'),(363,'贴警示语','充棉'),(364,'贴条码贴纸','充棉'),(365,'贴外箱贴纸','充棉'),(366,'压缩装箱入库','充棉'),(367,'装箱','充棉'),(368,'装箱入库','充棉'),(369,'检验 剪毛','检验'),(371,'检验 剪边','检验'),(372,'拷边夹标','车缝'),(373,'剪毛 检验','车缝');

/*Table structure for table `roleaction` */

DROP TABLE IF EXISTS `roleaction`;

CREATE TABLE `roleaction` (
  `roleActionID` int(11) NOT NULL AUTO_INCREMENT,
  `actionID` varchar(20) NOT NULL,
  `roleID` varchar(10) NOT NULL,
  PRIMARY KEY (`roleActionID`),
  KEY `FK6F644E2CE830AF37` (`actionID`),
  KEY `FK6F644E2CBFE26F37` (`roleID`),
  CONSTRAINT `FK6F644E2CBFE26F37` FOREIGN KEY (`roleID`) REFERENCES `rolemaster` (`role_id`),
  CONSTRAINT `FK6F644E2CE830AF37` FOREIGN KEY (`actionID`) REFERENCES `actionmaster` (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `roleaction` */

/*Table structure for table `rolemaster` */

DROP TABLE IF EXISTS `rolemaster`;

CREATE TABLE `rolemaster` (
  `role_id` varchar(10) NOT NULL,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `rolemaster` */

/*Table structure for table `shipaddr` */

DROP TABLE IF EXISTS `shipaddr`;

CREATE TABLE `shipaddr` (
  `ship_id` varchar(10) NOT NULL,
  `ship_dec` varchar(100) DEFAULT NULL,
  `ship_city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ship_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `shipaddr` */

/*Table structure for table `shipvin` */

DROP TABLE IF EXISTS `shipvin`;

CREATE TABLE `shipvin` (
  `Shipvia_id` varchar(10) NOT NULL,
  `Shipvia_desc` varchar(45) NOT NULL,
  PRIMARY KEY (`Shipvia_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `shipvin` */

insert  into `shipvin`(`Shipvia_id`,`Shipvia_desc`) values ('011111','火车车皮'),('0111112','水运'),('0111113','海运'),('0111114','航空运');

/*Table structure for table `stockreason` */

DROP TABLE IF EXISTS `stockreason`;

CREATE TABLE `stockreason` (
  `Rea_code` varchar(10) NOT NULL,
  `Rea_desc` varchar(45) NOT NULL,
  PRIMARY KEY (`Rea_code`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `stockreason` */

/*Table structure for table `ummaster` */

DROP TABLE IF EXISTS `ummaster`;

CREATE TABLE `ummaster` (
  `um_id` varchar(10) NOT NULL,
  `um_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`um_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `ummaster` */

insert  into `ummaster`(`um_id`,`um_desc`) values ('0100','台'),('0200','毫米'),('0201','厘米'),('0202','分米'),('0203','米'),('0204','十米'),('0205','百米'),('0206','千米');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `serialnum` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`serialnum`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`serialnum`,`user_name`,`password`) values (1,'admin','admin');

/*Table structure for table `vendermaster` */

DROP TABLE IF EXISTS `vendermaster`;

CREATE TABLE `vendermaster` (
  `Vend_id` varchar(10) NOT NULL,
  `Vend_type` varchar(10) DEFAULT NULL,
  `Vend_Shipvia` varchar(10) DEFAULT NULL COMMENT '???璐ч??寰?',
  `Vend_desc` varchar(45) DEFAULT NULL,
  `Vend_addr` varchar(100) DEFAULT NULL,
  `Vend_city` varchar(45) DEFAULT NULL,
  `Vend_nati` varchar(45) DEFAULT NULL,
  `Vend_phone` varchar(20) DEFAULT NULL,
  `Vend_post` varchar(10) DEFAULT NULL,
  `Vend_Email` varchar(30) DEFAULT NULL,
  `TradeAmount` bigint(20) DEFAULT NULL COMMENT '浜ゆ??棰?',
  `Cont_man` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Vend_id`),
  KEY `FK7650F8F476A4FD09` (`Vend_Shipvia`),
  KEY `FK7650F8F4761C2441` (`Vend_type`),
  CONSTRAINT `FK7650F8F4761C2441` FOREIGN KEY (`Vend_type`) REFERENCES `vendtype` (`Vendtype_id`),
  CONSTRAINT `FK7650F8F476A4FD09` FOREIGN KEY (`Vend_Shipvia`) REFERENCES `shipvin` (`Shipvia_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `vendermaster` */

/*Table structure for table `vendtype` */

DROP TABLE IF EXISTS `vendtype`;

CREATE TABLE `vendtype` (
  `Vendtype_id` varchar(10) NOT NULL,
  `Vendtype_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Vendtype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `vendtype` */

insert  into `vendtype`(`Vendtype_id`,`Vendtype_desc`) values ('0100','厂家直销'),('0101','授权分销'),('0102','独立分销');

/*Table structure for table `warehouse` */

DROP TABLE IF EXISTS `warehouse`;

CREATE TABLE `warehouse` (
  `Ware_id` varchar(10) NOT NULL,
  `Ware_desc` varchar(45) DEFAULT NULL,
  `Ware_adrr` varchar(130) DEFAULT NULL,
  `Val_emp` varchar(20) DEFAULT NULL COMMENT '???系人',
  `Fax` varchar(15) DEFAULT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Ware_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `warehouse` */

insert  into `warehouse`(`Ware_id`,`Ware_desc`,`Ware_adrr`,`Val_emp`,`Fax`,`Phone`) values ('0102010','北京-五道口','北京市五道口','庞先生','789456123','789456123'),('010203','北京-西直门站','北京市西直门','王先生','123456789','123456789'),('010204','北京-东直门站','北京东直门','刘先生','123456','123456'),('010205','北京-上地站','北京市上地','张先生','123456123','123456123'),('010206','北京-五道口','北京市五道口','庞先生','789456123','789456123'),('010207','北京-回龙观','北京市回龙观','黄先生','789456123','789456123'),('010208','北京-霍营','北京市霍营','牛先生','789456123','789456123'),('010209','北京-西三旗','北京市西三旗','杨先生','789456123','789456123');

/*Table structure for table `warehouse_item` */

DROP TABLE IF EXISTS `warehouse_item`;

CREATE TABLE `warehouse_item` (
  `Item_id` varchar(10) NOT NULL,
  `Ware_id` varchar(10) NOT NULL,
  `Safe_stock` bigint(20) NOT NULL,
  `Last_count` datetime NOT NULL,
  PRIMARY KEY (`Item_id`,`Ware_id`,`Safe_stock`,`Last_count`),
  KEY `FKFFB23B0FEC2CA92E` (`Item_id`),
  KEY `FKFFB23B0F4B87AE52` (`Ware_id`),
  CONSTRAINT `FKFFB23B0F4B87AE52` FOREIGN KEY (`Ware_id`) REFERENCES `warehouse` (`Ware_id`),
  CONSTRAINT `FKFFB23B0FEC2CA92E` FOREIGN KEY (`Item_id`) REFERENCES `itemgeneral` (`Item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `warehouse_item` */

/*Table structure for table `worker` */

DROP TABLE IF EXISTS `worker`;

CREATE TABLE `worker` (
  `serialnum` int(8) NOT NULL AUTO_INCREMENT,
  `jobnum` char(8) DEFAULT NULL,
  `workername` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`serialnum`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `worker` */

insert  into `worker`(`serialnum`,`jobnum`,`workername`) values (10,'cf0001','张三'),(11,'cf0002','李四'),(12,'jy0001','王五'),(14,'02','候'),(15,'cf0119','王麻子'),(18,'000003','车缝一组丽丽');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
