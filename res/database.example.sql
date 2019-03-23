/*
Navicat MySQL Data Transfer

Source Server         : ShareManServer1
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : temp

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-03-08 16:21:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT NULL  ON UPDATE CURRENT_TIMESTAMP,
  `validTimeStart` timestamp NULL DEFAULT NULL,
  `validTimeEnd` timestamp NULL DEFAULT NULL,
  `authSuperAdmin` int(2) DEFAULT NULL,
  `authLogin` int(2) DEFAULT NULL,
  `authSelect` int(2) DEFAULT NULL,
  `authAdd` int(2) DEFAULT NULL,
  `authLog` int(2) DEFAULT NULL,
  `authModify` int(2) DEFAULT NULL,
  `authCreateAccount` int(2) DEFAULT NULL,
  `authDelete` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`,`username`,`password`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth
-- ----------------------------
INSERT INTO `auth` VALUES ('1', 'test', 'test', '测试帐号', '2019-03-08 16:14:18', '2019-03-08 16:14:18', '2019-03-08 16:14:18', null, null, null, null, null, null, null, null);
INSERT INTO `auth` VALUES ('2', 'ShareMan', '4565999538', 'ShareManT', null, null, null, '1', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `value` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id` int(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('EasyDataTable (SCUJCC Data)', '网站名称', 'siteName', '1');
INSERT INTO `config` VALUES ('此网站用于为ShareMan的大学课程设计演示，项目开心地运行着docker容器中。', '公告', 'instruction', '2');
INSERT INTO `config` VALUES ('来访可用账号test密码test登陆进行访问。数据为锦城学院真实数据。', '登陆提示', 'loginTips', '3');

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `BianHao` varchar(255) DEFAULT NULL,
  `XueHao` varchar(255) DEFAULT NULL,
  `XingMing` varchar(255) DEFAULT NULL,
  `LaiYuan` varchar(255) DEFAULT NULL,
  `ShenFenZhengHao` varchar(255) DEFAULT NULL,
  `XingBie` varchar(255) DEFAULT NULL,
  `ShengRi` varchar(255) DEFAULT NULL,
  `MinZu` varchar(255) DEFAULT NULL,
  `ZhengZhiMianMao` varchar(255) DEFAULT NULL,
  `YuanXi` varchar(255) DEFAULT NULL,
  `ZhuanYe` varchar(255) DEFAULT NULL,
  `BanJi` varchar(255) DEFAULT NULL,
  `CengCi` varchar(255) DEFAULT NULL,
  `NianJi` varchar(255) DEFAULT NULL,
  `FenShu` varchar(255) DEFAULT NULL,
  `DiZhi` varchar(255) DEFAULT NULL,
  `SuShe` varchar(255) DEFAULT NULL,
  `ZuZhi` varchar(255) DEFAULT NULL,
  `ShengYuanDi` varchar(255) DEFAULT NULL,
  `YouBian` varchar(255) DEFAULT NULL,
  `ShouJi` varchar(255) DEFAULT NULL,
  `DianHua` varchar(255) DEFAULT NULL,
  `QQ` varchar(255) DEFAULT NULL,
  `YouJian` varchar(255) DEFAULT NULL,
  `GaoZhong` varchar(255) DEFAULT NULL,
  `BeiZhu` varchar(255) DEFAULT NULL,
  `ShengQu` varchar(255) DEFAULT NULL,
  `ZhiWu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41220 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES ('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for dataTable
-- ----------------------------
DROP TABLE IF EXISTS `dataTable`;
CREATE TABLE `dataTable` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `isVisible` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `isChartAble` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dataTable
-- ----------------------------
INSERT INTO `dataTable` VALUES ('1', 'BianHao', '编号', 'int', '1', '个人信息', '');
INSERT INTO `dataTable` VALUES ('2', 'XueHao', '学号', 'int', '1', '校园信息', '');
INSERT INTO `dataTable` VALUES ('3', 'XingMing', '姓名', 'varchar', '1', '个人信息', '1');
INSERT INTO `dataTable` VALUES ('4', 'LaiYuan', '来源', 'varchar', '1', '校园信息', '1');
INSERT INTO `dataTable` VALUES ('5', 'ShenFenZhengHao', '身份证', 'int', '1', '个人信息', '');
INSERT INTO `dataTable` VALUES ('6', 'XingBie', '性别', 'varchar', '1', '个人信息', '1');
INSERT INTO `dataTable` VALUES ('7', 'ShengRi', '生日', 'datetime', '1', '个人信息', '1');
INSERT INTO `dataTable` VALUES ('8', 'MinZu', '民族', 'varchar', '1', '个人信息', '1');
INSERT INTO `dataTable` VALUES ('9', 'ZhengZhiMianMao', '政治面貌', 'varchar', '1', '个人信息', '1');
INSERT INTO `dataTable` VALUES ('10', 'YuanXi', '院系', 'varchar', '1', '校园信息', '1');
INSERT INTO `dataTable` VALUES ('11', 'ZhuanYe', '专业', 'varchar', '1', '校园信息', '1');
INSERT INTO `dataTable` VALUES ('12', 'BanJi', '班级', 'varchar', '1', '校园信息', '');
INSERT INTO `dataTable` VALUES ('13', 'CengCi', '层次', 'varchar', '1', '校园信息', '');
INSERT INTO `dataTable` VALUES ('14', 'NianJi', '年级', 'varchar', '1', '校园信息', '1');
INSERT INTO `dataTable` VALUES ('15', 'FenShu', '分数', 'varchar', '1', '校园信息', '1');
INSERT INTO `dataTable` VALUES ('16', 'DiZhi', '地址', 'varchar', '1', '个人信息', '');
INSERT INTO `dataTable` VALUES ('17', 'SuShe', '宿舍', 'varchar', '1', '校园信息', '');
INSERT INTO `dataTable` VALUES ('18', 'ZuZhi', '组织', 'varchar', '1', '校园信息', '');
INSERT INTO `dataTable` VALUES ('19', 'ShengYuanDi', '生源地', 'varchar', '1', '校园信息', '1');
INSERT INTO `dataTable` VALUES ('20', 'YouBian', '邮编', 'varchar', '1', '个人信息', '');
INSERT INTO `dataTable` VALUES ('21', 'ShouJi', '手机', 'varchar', '1', '联系方式', '');
INSERT INTO `dataTable` VALUES ('22', 'DianHua', '电话', 'varchar', '1', '联系方式', '');
INSERT INTO `dataTable` VALUES ('23', 'QQ', 'QQ', 'varchar', '1', '联系方式', '');
INSERT INTO `dataTable` VALUES ('24', 'YouJian', '邮件', 'varchar', '1', '联系方式', '');
INSERT INTO `dataTable` VALUES ('25', 'GaoZhong', '高中', 'varchar', '1', '个人信息', '1');
INSERT INTO `dataTable` VALUES ('26', 'BeiZhu', '备注', 'varchar', '1', '个人信息', '');
INSERT INTO `dataTable` VALUES ('27', 'ShengQu', '省区', 'varchar', '1', null, '1');
INSERT INTO `dataTable` VALUES ('28', 'ZhiWu', '职务', 'varchar', '1', '校园信息', '');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', 'test', '登陆', 'test用户登陆', '0:0:0:0:0:0:0:1', '2019-03-08 13:56:00');
INSERT INTO `log` VALUES ('2', 'test', '搜索', '曾小满', '0:0:0:0:0:0:0:1', '2019-03-08 14:19:28');
INSERT INTO `log` VALUES ('3', 'ShareMan', '登陆', 'ShareMan用户登陆', '0:0:0:0:0:0:0:1', '2019-03-08 16:14:31');
INSERT INTO `log` VALUES ('4', 'ShareMan', '搜索', '王科', '0:0:0:0:0:0:0:1', '2019-03-08 16:19:31');
INSERT INTO `log` VALUES ('5', 'ShareMan', '搜索', '王治文', '0:0:0:0:0:0:0:1', '2019-03-08 16:19:54');
