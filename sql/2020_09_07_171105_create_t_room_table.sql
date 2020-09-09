CREATE TABLE IF NOT EXISTS `t_room` (
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `room_owner` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT "房主，即房主的用户id",
    `room_name` varchar(16) NOT NULL DEFAULT "" COMMENT "房间名称",
    `room_password` varchar(16) NOT NULL DEFAULT "" COMMENT "房间密码",
    `room_status` tinyint(3) NOT NULL DEFAULT 1 COMMENT "房间状态，0已销毁，1未满人，2满人，3游戏中",
    `created_date` char(10) NOT NULL DEFAULT "" COMMENT "创建日期",
    `created_at` int UNSIGNED NOT NULL DEFAULT 0 COMMENT "创建时间",
    `last_updated_at` int UNSIGNED NOT NULL DEFAULT 0 COMMENT "更新时间",
    `deleted_at` int UNSIGNED NOT NULL DEFAULT 0 COMMENT "销毁时间",
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT="房间表";