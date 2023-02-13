/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : db1

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2023-02-05 18:25:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'zhangsan', '123');
INSERT INTO `tb_user` VALUES ('2', 'lisi', '234');
INSERT INTO `tb_user` VALUES ('3', 'zhangsanf', '123');
INSERT INTO `tb_user` VALUES ('18', 'zhangsanfeng', '123456');
