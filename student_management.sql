/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : student_management

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 22/08/2018 21:16:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `userId` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `position` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('admin', 'admin', 'root');
INSERT INTO `login` VALUES ('user', 'user', 'student');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stuId` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `stuName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `stuSex` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `stuAge` int(255) NULL DEFAULT NULL,
  `stuJg` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `stuZy` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `classId` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `stuSourse` decimal(5, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`stuId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0702318', '杨明辉', '男', 25, '四川', '软件工程', '07020302', 519.35);
INSERT INTO `student` VALUES ('0703225', '任烈华·', '男', 23, '广东', '物理', '07030202', 507.50);
INSERT INTO `student` VALUES ('0704111', '刘文雨', '女', 22, '浙江', '建筑设计', '07040101', 516.00);
INSERT INTO `student` VALUES ('0802105', '易素敏', '女', 20, '陕西', '自动控制', '08020101', 562.50);
INSERT INTO `student` VALUES ('0802535', '黄新海', '男', 21, '山西', '生物化学', '08020501', 543.50);
INSERT INTO `student` VALUES ('2018001', '小明', '男', 20, '山东', '物理', '08020001', 600.25);
INSERT INTO `student` VALUES ('2018003', '小黄', '女', 21, '山西', '地理', '08020002', 687.85);
INSERT INTO `student` VALUES ('2018004', '小海', '女', 22, '浙江', '物理', '08020001', 578.20);
INSERT INTO `student` VALUES ('2018005', '小新', '女', 18, '福建', '化学', '08020003', 456.74);
INSERT INTO `student` VALUES ('2018006', '小李', '女', 21, '广东', '电子信息', '08010001', 568.45);
INSERT INTO `student` VALUES ('2018007', '小马', '女', 20, '广西', '物联网', '08010002', 453.25);
INSERT INTO `student` VALUES ('2018008', '赵鹏飞', '男', 20, '山东', '软件工程', '2016001', 750.85);
INSERT INTO `student` VALUES ('2018009', '黄少童', '男', 20, '山东', '软件工程', '2016001', 751.00);
INSERT INTO `student` VALUES ('2018010', '秦始皇', '男', 20, '西安', '软件工程', '2016001', 700.00);
INSERT INTO `student` VALUES ('2018011', '木乃伊', '女', 20, '西安', '考古学', '2016002', 462.02);
INSERT INTO `student` VALUES ('2018012', '海绵宝宝', '男', 10, '北京', '动画', '2016003', 561.00);
INSERT INTO `student` VALUES ('2018013', '爱迪生', '男', 20, '山东', '软件工程', '2016001', 710.00);
INSERT INTO `student` VALUES ('2018014', '爱因斯坦', '男', 20, '西安', '软件工程', '2016001', 760.00);
INSERT INTO `student` VALUES ('2018015', '蒙娜丽莎', '女', 20, '上海', '考古学', '2016002', 562.02);
INSERT INTO `student` VALUES ('2018016', '派大星', '男', 10, '北京', '动画', '2016003', 451.00);

SET FOREIGN_KEY_CHECKS = 1;
