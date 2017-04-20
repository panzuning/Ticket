/*
Navicat MySQL Data Transfer

Source Server         : panzuning
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ticket

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-04-20 20:52:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_num` varchar(10) DEFAULT NULL COMMENT '车牌号',
  `car_driver` varchar(255) DEFAULT NULL COMMENT '司机',
  `car_seat` int(100) DEFAULT NULL COMMENT '座位数',
  `data_statu` int(11) DEFAULT NULL COMMENT '数据状态（0为启用，1为删除）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '辽A50707', '马云12', '30', '0', '2017-04-15 00:49:09', '2017-04-15 00:49:13');
INSERT INTO `t_car` VALUES ('2', '辽B12345', 'haha', '32', '0', '2017-04-13 19:31:11', '2017-04-15 19:31:16');
INSERT INTO `t_car` VALUES ('3', '贵A123456', 'lala ', '34', '0', '2017-04-16 15:43:38', '2017-04-16 15:43:38');
INSERT INTO `t_car` VALUES ('4', '哈哈', '肥肥', '23', '1', '2017-04-16 16:05:15', '2017-04-16 16:05:15');

-- ----------------------------
-- Table structure for t_line
-- ----------------------------
DROP TABLE IF EXISTS `t_line`;
CREATE TABLE `t_line` (
  `line_id` int(11) NOT NULL AUTO_INCREMENT,
  `start_station` varchar(255) DEFAULT NULL COMMENT '始发站',
  `end_station` varchar(255) DEFAULT NULL COMMENT '终点站',
  `start_time` datetime DEFAULT NULL COMMENT '发车时间',
  `expected_time` datetime DEFAULT NULL,
  `ticket_price` decimal(10,2) DEFAULT NULL COMMENT '票价',
  `ticket_num` int(11) DEFAULT NULL,
  `data_statu` int(10) DEFAULT NULL COMMENT '数据状态(1为删除，0为启用)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `car_id` int(11) DEFAULT NULL COMMENT '车次',
  PRIMARY KEY (`line_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_line
-- ----------------------------
INSERT INTO `t_line` VALUES ('1', '沈阳', '大连', '2017-01-14 00:04:00', '2017-01-15 00:04:00', '100.00', '25', '0', '2017-04-15 00:50:18', '2017-04-15 00:50:22', '2');
INSERT INTO `t_line` VALUES ('2', '请求', '启动', '2017-01-16 00:01:00', '2017-01-16 00:01:00', '12.00', '12', '0', '2017-04-16 01:26:06', '2017-04-16 01:26:06', '1');
INSERT INTO `t_line` VALUES ('3', '一已解决', '分为非', '2017-01-16 00:04:00', '2017-01-16 00:04:00', '3232.00', '123', '1', '2017-04-16 01:27:53', '2017-04-16 01:27:53', '1');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `orderid` varchar(255) NOT NULL,
  `pay_statu` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `totalcount` double NOT NULL,
  `data_statu` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('14925663852712017041911', '0', '1', '1', '100', '0', '2017-04-19 09:46:25', '2017-04-19 09:46:25');
INSERT INTO `t_order` VALUES ('14925665182002017041911', '1', '1', '1', '100', '0', '2017-04-19 09:48:38', '2017-04-19 09:48:38');
INSERT INTO `t_order` VALUES ('14926917895912017042011', '2', '1', '1', '100', '0', '2017-04-20 20:36:29', '2017-04-20 20:36:29');
INSERT INTO `t_order` VALUES ('14926917974692017042011', '3', '1', '1', '100', '0', '2017-04-20 20:36:37', '2017-04-20 20:36:37');
INSERT INTO `t_order` VALUES ('14926917992692017042011', '0', '1', '1', '100', '0', '2017-04-20 20:36:39', '2017-04-20 20:36:39');
INSERT INTO `t_order` VALUES ('14926924480872017042011', '0', '1', '1', '100', '0', '2017-04-20 20:47:28', '2017-04-20 20:47:28');
INSERT INTO `t_order` VALUES ('14926924498522017042011', '0', '1', '1', '100', '0', '2017-04-20 20:47:29', '2017-04-20 20:47:29');

-- ----------------------------
-- Table structure for t_ticket
-- ----------------------------
DROP TABLE IF EXISTS `t_ticket`;
CREATE TABLE `t_ticket` (
  `ticketid` int(11) NOT NULL AUTO_INCREMENT,
  `lineid` int(11) DEFAULT NULL,
  `rider` varchar(255) DEFAULT NULL COMMENT '乘车人',
  `riderphone` varchar(255) DEFAULT NULL,
  `drawticket` int(11) DEFAULT NULL COMMENT '出票(0未出票，1已出票)',
  `orderid` varchar(255) DEFAULT NULL,
  `data_statu` int(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ticketid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ticket
-- ----------------------------
INSERT INTO `t_ticket` VALUES ('1', '1', 'pzn', 'dsdsd', null, '14925665182002017041911', '0', '2017-04-19 09:48:38', '2017-04-19 09:48:38');
INSERT INTO `t_ticket` VALUES ('2', '1', 'pzn', 'dsdsd', null, '14926917895912017042011', '0', '2017-04-20 20:36:29', '2017-04-20 20:36:29');
INSERT INTO `t_ticket` VALUES ('3', '1', 'pzn', 'dsdsd', null, '14926917974692017042011', '0', '2017-04-20 20:36:37', '2017-04-20 20:36:37');
INSERT INTO `t_ticket` VALUES ('4', '1', 'pzn', 'dsdsd', null, '14926917992692017042011', '0', '2017-04-20 20:36:39', '2017-04-20 20:36:39');
INSERT INTO `t_ticket` VALUES ('5', '1', 'pzn', 'dsdsd', '0', '14926924480872017042011', '0', '2017-04-20 20:47:28', '2017-04-20 20:47:28');
INSERT INTO `t_ticket` VALUES ('6', '1', 'pzn', 'dsdsd', '0', '14926924498522017042011', '0', '2017-04-20 20:47:29', '2017-04-20 20:47:29');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) NOT NULL,
  `user_pwd` varchar(255) NOT NULL,
  `admin_flag` int(11) DEFAULT NULL COMMENT '管理员标志（1为管理员用户，2为普通用户）',
  `user_phone` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `data_statu` int(11) DEFAULT NULL COMMENT '数据状态（1 ：删除 0 ：启用）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'pzn', '123456', '1', 'dsdsd', '895048669@qq.com', 'fjelfjeljfelj', '0', '2017-04-14 00:42:25', '2017-04-14 00:42:31');
INSERT INTO `t_user` VALUES ('2', 'fef', 'fefe', '1', 'fww', 'fwe', 'fwe', '0', '2017-04-16 16:53:22', '2017-04-16 16:53:22');
INSERT INTO `t_user` VALUES ('3', 'fefw', 'fwfe', '0', '', '', '', '0', '2017-04-16 16:53:37', '2017-04-16 16:53:37');
