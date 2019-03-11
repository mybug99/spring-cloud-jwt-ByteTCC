/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 127.0.0.1:3306
 Source Schema         : cloud-test

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 11/03/2019 11:29:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bytejta
-- ----------------------------
DROP TABLE IF EXISTS `bytejta`;
CREATE TABLE `bytejta`  (
  `xid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gxid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bxid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ctime` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`xid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'guxin', '123456');

-- ----------------------------
-- Table structure for user_detlis
-- ----------------------------
DROP TABLE IF EXISTS `user_detlis`;
CREATE TABLE `user_detlis`  (
  `u_id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `money` bigint(20) NULL DEFAULT NULL,
  `money_status` int(11) NULL DEFAULT NULL COMMENT '0.可用 1.冻结'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_detlis
-- ----------------------------
INSERT INTO `user_detlis` VALUES (1, '谷鑫', 1202, 0);

SET FOREIGN_KEY_CHECKS = 1;
