DROP TABLE `user`;
CREATE TABLE `user`(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(20) COMMENT '用户名',
`password` VARCHAR(32) COMMENT '密码',
create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
email VARCHAR(32) COMMENT '邮箱'
) ENGINE=INNODB CHARSET=utf8 ;


CREATE TABLE `role`(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` VARCHAR(20) COMMENT '角色名',
`description` VARCHAR(20) COMMENT '描述',
`status` TINYINT COMMENT '状态',
PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8 COMMENT '角色表';

CREATE TABLE resource(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
`url` VARCHAR(255) COMMENT '资源地址',
`pid` INT COMMENT '父级id',
PRIMARY KEY (`id`),
FOREIGN KEY (`pid`) REFERENCES resource(`id`)
)ENGINE=INNODB CHARSET=utf8 COMMENT '资源表';


CREATE TABLE `user_role` (
`id` INT AUTO_INCREMENT COMMENT '主键',
`userid` INT COMMENT '用户id',
`roleid` INT COMMENT '角色id',
PRIMARY KEY (`id`)
)ENGINE=INNODB CHARSET=utf8 COMMENT '用户角色表';

--添加索引
--全文索引FULLTEXT
ALTER TABLE `user_role` ADD INDEX `idx_user_role_ids` (`userid`,`roleid`) USING BTREE;
