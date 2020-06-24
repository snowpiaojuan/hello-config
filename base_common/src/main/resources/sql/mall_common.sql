 CREATE DATABASE mall_common;

-- ----------------------------
-- Table structure for dict_city
-- ----------------------------
DROP TABLE IF EXISTS `mall_common`.`dict_city`;
CREATE TABLE `mall_common`.`dict_city`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '城市名称',
  `province_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '省份ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '城市表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dict_province
-- ----------------------------
DROP TABLE IF EXISTS `mall_common`.`dict_province`;
CREATE TABLE `mall_common`.`dict_province`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '省份表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
