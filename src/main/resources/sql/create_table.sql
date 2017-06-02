--创建用户表
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER`(
ID INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
SALT VARCHAR(32) DEFAULT 'test' COMMENT '加密盐值',
LOGIN_NAME VARCHAR(32) NOT NULL COMMENT '登录名',
PASSWORD VARCHAR(32) NOT NULL COMMENT '密码',
EMAIL VARCHAR(32) COMMENT '邮箱',
CREATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，默认为插入数据的时间',
STATUS TINYINT DEFAULT 0 COMMENT '用户状态:0为有效1:为失效'
) ENGINE=INNODB CHARSET=UTF8 COMMENT '用户表';

--创建角色表
DROP TABLE IF EXISTS `ROLE`;
CREATE TABLE `role`(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
`role_name` VARCHAR(20) COMMENT '角色名',
`seq` TINYINT DEFAULT 0 COMMENT '排序顺序',
`description` VARCHAR(20) COMMENT '描述',
`status` TINYINT DEFAULT 0 COMMENT '状态0:有效1:无效',
PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8 COMMENT '角色表';

--创建资源表
DROP TABLE IF EXISTS `RESOURCE`;
CREATE TABLE RESOURCE(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` VARCHAR(32) NOT NULL COMMENT '资源名称',
`url` VARCHAR(255) COMMENT '资源地址',
`open_mode` VARCHAR(32) COMMENT '请求资源的方式',
`description` VARCHAR(32) COMMENT '资源描述',
`pid` INT COMMENT '父级id',
`seq` TINYINT COMMENT '排序显示位置',
`status` TINYINT DEFAULT 0 COMMENT '资源可用状态0:可用1:不可用',
`resource_type` VARCHAR(32) COMMENT '资源的类别',
`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，默认是插入数据的当期时间',
PRIMARY KEY (`id`),
FOREIGN KEY (`pid`) REFERENCES resource(`id`)
)ENGINE=INNODB CHARSET=utf8 COMMENT '资源表';

--创建用户角色表
DROP TABLE IF EXISTS `USER_ROLE`;
CREATE TABLE `user_role` (
`id` INT AUTO_INCREMENT COMMENT '主键',
`userid` INT COMMENT '用户id',
`roleid` INT COMMENT '角色id',
PRIMARY KEY (`id`)
)ENGINE=INNODB CHARSET=utf8 COMMENT '用户角色表';

--添加索引
--全文索引FULLTEXT
ALTER TABLE `user_role` ADD INDEX `idx_user_role_ids` (`userid`,`roleid`) USING BTREE;

--创建资源角色表
DROP TABLE IF EXISTS `ROLE_RESOURCE`;
CREATE TABLE `ROLE_RESOURCE`(
ID INT AUTO_INCREMENT COMMENT '主键',
`roleid` INT COMMENT '角色id',
`resourceid` INT COMMENT '资源id',
PRIMARY KEY (`ID`),
INDEX `IDX_ROLE_RESOURCE_IDS` (`ROLEID`,`RESOURCEID`) USING BTREE
)ENGINE=INNODB CHARSET=UTF8 COMMENT '角色资源表';




