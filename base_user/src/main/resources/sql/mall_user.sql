 CREATE DATABASE mall_user;

-- ----------------------------
-- Table structure for usr_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`.`usr_user`;
CREATE TABLE `mall_user`.`usr_user`  (
  `id` bigint(20) NOT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密用的盐',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `nick_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `sex` tinyint(4) NOT NULL DEFAULT 0 COMMENT '性别：0无 1男 2女',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `province_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '省份ID',
  `city_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '城市ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户备注',
  `is_deleted` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除。0-否（默认），1-是',
  `created_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
