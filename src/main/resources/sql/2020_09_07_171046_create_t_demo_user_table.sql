CREATE TABLE `t_demo_user` (
    `uid` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `phone` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户名称',
    `username` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户昵称',
    `avatar_url` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户头像',
    `gender` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '性别，1=>男；2=>女',
    `province` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '省',
    `city` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '市',
    `last_logined_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最后登录时间',
    `last_logined_ip` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最后登录ip',
    `created_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    `updated_at` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '更新时间',
    `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '记录状态，1=>可用；0=>不可用',
    PRIMARY KEY (`uid`),
    UNIQUE KEY `phone_unique_idx` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';