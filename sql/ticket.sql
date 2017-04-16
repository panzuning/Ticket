/*
Navicat MySQL Data Transfer

Source Server         : panzuning
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ticket

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-04-16 17:02:29
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
INSERT INTO `t_line` VALUES ('1', '沈阳', '大连', '2017-01-14 00:04:00', '2017-01-15 00:04:00', '100.00', '30', '0', '2017-04-15 00:50:18', '2017-04-15 00:50:22', '2');
INSERT INTO `t_line` VALUES ('2', '请求', '启动', '2017-01-16 00:01:00', '2017-01-16 00:01:00', '12.00', '12', '0', '2017-04-16 01:26:06', '2017-04-16 01:26:06', '1');
INSERT INTO `t_line` VALUES ('3', '一已解决', '分为非', '2017-01-16 00:04:00', '2017-01-16 00:04:00', '3232.00', '123', '1', '2017-04-16 01:27:53', '2017-04-16 01:27:53', '1');

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
