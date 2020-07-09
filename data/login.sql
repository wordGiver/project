/*
 Navicat Premium Data Transfer

 Source Server         : LocalHost
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : utf-8

 Date: 07/01/2018 21:28:02 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `student.html`
-- ----------------------------
DROP TABLE IF EXISTS `Login`;
CREATE TABLE `Login` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `passwd` varchar(100)  CHARACTER SET utf8  COMMENT '密码' ,
  `identity` int(10) COMMENT '身份',

  PRIMARY KEY (`uid`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='登陆';

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`(
    `uid` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL ,
    `identity` int(10),
    `salary` int(10) default 2000,
    PRIMARY KEY (`uid`)
)ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='员工';

DROP TABLE IF EXISTS `Member` ;
CREATE TABLE `Member`(
    `mid` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) not null ,
    `phone` varchar(15),
    `score` int(25) ,
    PRIMARY KEY (`mid`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='会员';

DROP TABLE IF EXISTS `Commodity`;
CREATE TABLE `Commodity`(
                            `cid` int(11) NOT NULL AUTO_INCREMENT,
                            `name` varchar(100) CHARACTER SET utf8,
                            `price` double(11,2) NOT NULL ,
                            `quantity` int(11) DEFAULT 0,
                            `discount` double(3,1) DEFAULT 10.0,

                            primary key (`cid`)
)ENGINE=InnoDB AUTO_INCREMENT=1 Comment '商品';

DROP TABLE IF EXISTS `Log` ;
CREATE TABLE `Log`(
                            `lid` int(100) NOT NULL AUTO_INCREMENT,
                            `oname` varchar(100)  CHARACTER SET utf8,
                            `cid` int(11) NOT NULL,
                            `quantity` int(10) DEFAULT 1,
                            `cname` varchar(100),
                            `date`  varchar(20),

                            primary key (`lid`)

)ENGINE=InnoDB AUTO_INCREMENT=1 Comment '日志';


-- ----------------------------
--  Records of `student.html`
-- ----------------------------
BEGIN;
INSERT INTO `Login` VALUES ('18080123', '123456','0'), ('18080120','123456','1'),('18080121','123456',2),('18080122','123456',3),('18080119','123456','3'),(18080118,123456,3);
INSERT INTO `User`  VALUES ('18080123','高健','0','10000'),('18080120','张三','1','8000'),('18080121','李四','2','5000'),('18080122','王五','3','3500'),('18080119','猫猫','3','3500'),('18080118','德莱文','3','3200');

INSERT INTO `Commodity` VALUES ('5999','ipad',8848,50,10),('299','鼠标',1999,20,10),('3366','康师傅方便面',3,100,10),(1422,'冰红茶',3,50,10),(1423,'绿茶',3,50,10),(1426,'茉莉花茶',3,50,10),(1424,'联想Y7000',5999,20,9.6),(1425,'联想小新',4500,30,9.6);
INSERT INTO `Member` VALUES ('123','卡特','180141245','152'),('124','瑞文','1842447242','243'),('127','赵信','181234455','501'),('185','塞纳','1248792441','780');
-- INSERT INTO `Log` VALUES ('1','test','0','0','0','1970.1.1');


COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
