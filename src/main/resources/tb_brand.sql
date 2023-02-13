/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : db1

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2023-02-05 18:25:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_brand`
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(20) DEFAULT NULL,
  `company_name` varchar(20) DEFAULT NULL,
  `ordered` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_brand
-- ----------------------------
INSERT INTO `tb_brand` VALUES ('16', '京东2', '北京京东世纪贸易有限公司', '40', '就是快', '1');
INSERT INTO `tb_brand` VALUES ('17', '华为3', '华为技术有限公司', '100', '万物互联', '1');
INSERT INTO `tb_brand` VALUES ('19', '格力', '格力电器股份有限公司', '30', '让世界爱上中国造', '0');
INSERT INTO `tb_brand` VALUES ('20', '阿里巴巴', '阿里巴巴集团控股有限公司', '10', '买买买', '1');
INSERT INTO `tb_brand` VALUES ('21', '腾讯', '腾讯计算机系统有限公司', '50', '玩玩玩', '0');
INSERT INTO `tb_brand` VALUES ('22', '百度', '百度在线网络技术公司', '5', '搜搜搜', '0');
INSERT INTO `tb_brand` VALUES ('23', '京东', '北京京东世纪贸易有限公司', '40', '就是快', '1');
INSERT INTO `tb_brand` VALUES ('25', '三只松鼠', '三只松鼠股份有限公司', '5', '好吃不上火', '0');
INSERT INTO `tb_brand` VALUES ('26', '华为', '华为技术有限公司', '100', '万物互联', '1');
INSERT INTO `tb_brand` VALUES ('28', '格力', '格力电器股份有限公司', '30', '让世界爱上中国造', '1');
INSERT INTO `tb_brand` VALUES ('31', '百度', '百度在线网络技术公司', '5', '搜搜搜', '0');
INSERT INTO `tb_brand` VALUES ('32', '京东', '北京京东世纪贸易有限公司', '40', '就是快', '1');
INSERT INTO `tb_brand` VALUES ('33', '华为', '华为技术有限公司', '100', '万物互联', '1');
INSERT INTO `tb_brand` VALUES ('34', '小米', '小米科技有限公司', '50', 'are you ok', '1');
INSERT INTO `tb_brand` VALUES ('35', '格力', '格力电器股份有限公司', '30', '让世界爱上中国造', '1');
INSERT INTO `tb_brand` VALUES ('36', '阿里巴巴', '阿里巴巴集团控股有限公司', '10', '买买买', '1');
INSERT INTO `tb_brand` VALUES ('37', '腾讯', '腾讯计算机系统有限公司', '50', '玩玩玩', '0');
INSERT INTO `tb_brand` VALUES ('38', '百度', '百度在线网络技术公司', '5', '搜搜搜', '0');
INSERT INTO `tb_brand` VALUES ('39', '京东', '北京京东世纪贸易有限公司', '40', '就是快', '1');
INSERT INTO `tb_brand` VALUES ('40', '小米', '小米科技有限公司', '50', 'are you ok', '1');
INSERT INTO `tb_brand` VALUES ('41', '三只松鼠', '三只松鼠股份有限公司', '5', '好吃不上火', '0');
INSERT INTO `tb_brand` VALUES ('42', '华为', '华为技术有限公司', '100', '万物互联', '1');
INSERT INTO `tb_brand` VALUES ('43', '小米', '小米科技有限公司', '50', 'are you ok', '1');
INSERT INTO `tb_brand` VALUES ('44', '格力', '格力电器股份有限公司', '30', '让世界爱上中国造', '1');
INSERT INTO `tb_brand` VALUES ('45', '阿里巴巴', '阿里巴巴集团控股有限公司', '10', '买买买', '1');
INSERT INTO `tb_brand` VALUES ('46', '腾讯', '腾讯计算机系统有限公司', '50', '玩玩玩', '0');
INSERT INTO `tb_brand` VALUES ('47', '百度', '百度在线网络技术公司', '5', '搜搜搜', '0');
INSERT INTO `tb_brand` VALUES ('48', '京东', '北京京东世纪贸易有限公司', '40', '就是快', '1');
