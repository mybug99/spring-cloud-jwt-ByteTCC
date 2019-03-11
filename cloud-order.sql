/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 127.0.0.1:3306
 Source Schema         : cloud-order

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 11/03/2019 11:29:53
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
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `order_state` int(11) NULL DEFAULT NULL COMMENT '0.订单创建 1、订单支付',
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (17, 'PR_d6da2f75-03f5-4753-8da4-ababfaf54257', '899', 1, 'Iphone Max xs', 1, '2019-03-11 03:18:29', '2019-03-11 03:18:29');
INSERT INTO `order` VALUES (18, 'PR_dcf7fada-94ad-4106-a0ad-6193d163d4e6', '899', 1, 'Iphone Max xs', 1, '2019-03-11 03:22:50', '2019-03-11 03:22:50');

SET FOREIGN_KEY_CHECKS = 1;
