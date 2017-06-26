insert into `dept` (`ID`, `NAME`, `DESCRIPTION`, `DEPT_NUM`) values('1','技术部','负责技术研发','10000');
insert into `dept` (`ID`, `NAME`, `DESCRIPTION`, `DEPT_NUM`) values('2','人事部','人事管理','20000');
insert into `dept` (`ID`, `NAME`, `DESCRIPTION`, `DEPT_NUM`) values('3','业务部','拓展业务','30000');
insert into `dept` (`ID`, `NAME`, `DESCRIPTION`, `DEPT_NUM`) values('4','市场调研','负责市场评估','40000');
insert into `dept` (`ID`, `NAME`, `DESCRIPTION`, `DEPT_NUM`) values('5','风控部','风险评估','50000');


insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('1','权限管理',NULL,NULL,'系统管理',NULL,'0','0','0','2017-06-13 09:18:57');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('2','资源管理','/resource/manager.do',NULL,'资源管理','1','1','0','0','2017-06-13 09:20:39');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('3','角色管理','/role/manager.do',NULL,'角色管理','1','2','0','0','2017-06-13 09:24:27');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('4','用户管理','/user/manager.do',NULL,'用户管理','1','3','0','0','2017-06-13 09:24:57');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('5','部门管理','/dept/manager.do',NULL,'部门管理','1','4','0','0','2017-06-13 09:26:05');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('7','添加','/resource/add.do',NULL,'资源添加','2','0','0','1','2017-06-13 09:34:25');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('8','编辑','/resource/edit.do',NULL,'资源编辑','2','0','0','1','2017-06-13 09:34:47');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('9','删除','/resource/delete.do',NULL,'资源删除','2','0','0','1','2017-06-13 09:35:10');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('11','添加','/role/add.do',NULL,'角色添加','3','0','0','1','2017-06-13 09:37:06');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('12','编辑','/role/edit.do',NULL,'角色编辑','3','0','0','1','2017-06-13 09:37:16');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('13','删除','/role/delete.do',NULL,'角色删除','3','0','0','1','2017-06-13 09:38:09');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('14','授权','/role/grant.do',NULL,'角色授权','3','0','0','1','2017-06-13 09:38:58');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('16','添加','/user/add.do',NULL,'用户添加','4','0','0','1','2017-06-13 09:41:08');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('17','编辑','/user/edit.do',NULL,'用户编辑','4','0','0','1','2017-06-13 09:41:39');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('18','删除','/user/delete.do',NULL,'用户删除','4','0','0','1','2017-06-13 09:42:01');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('20','添加','/dept/add.do',NULL,'部门添加','5','0','0','1','2017-06-13 09:43:17');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('21','编辑','/dept/edit.do',NULL,'部门编辑','5','0','0','1','2017-06-13 09:44:06');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('22','删除','/dept/delete.do',NULL,'部门删除','5','0','0','1','2017-06-13 09:44:34');
insert into `resource` (`id`, `name`, `url`, `open_mode`, `description`, `pid`, `seq`, `status`, `resource_type`, `create_time`) values('23','密码修改','/user/resetpwd.do',NULL,'密码修改',NULL,'0','0','0','2017-06-26 14:47:19');


insert into `role` (`id`, `role_name`, `seq`, `description`, `status`) values('1','root','0','拥有最高权限的root用户','0');
insert into `role` (`id`, `role_name`, `seq`, `description`, `status`) values('2','manager','0','经理(需要按部门划分)','0');
insert into `role` (`id`, `role_name`, `seq`, `description`, `status`) values('3','charge','0','主管(需要按部门划分)','0');
insert into `role` (`id`, `role_name`, `seq`, `description`, `status`) values('4','employee','0','员工(需要按部门划分)','0');
insert into `role` (`id`, `role_name`, `seq`, `description`, `status`) values('5','group_leader','0','组长(需要按部门划分)','0');


insert into `user` (`ID`, `SALT`, `LOGIN_NAME`, `PASSWORD`, `EMAIL`, `CREATE_TIME`, `STATUS`, `DEPT_NUM`) values('1','test','admin','123456','admin@qq.com','2017-06-13 09:59:14','0',NULL);
insert into `user` (`ID`, `SALT`, `LOGIN_NAME`, `PASSWORD`, `EMAIL`, `CREATE_TIME`, `STATUS`, `DEPT_NUM`) values('2','test','oqs','123456','oqs@qq.com','2017-06-13 10:14:19','0','10000');
insert into `user` (`ID`, `SALT`, `LOGIN_NAME`, `PASSWORD`, `EMAIL`, `CREATE_TIME`, `STATUS`, `DEPT_NUM`) values('3','test','mysql','123456','mysql@or.com','2017-06-13 10:15:18','0','10000');
insert into `user` (`ID`, `SALT`, `LOGIN_NAME`, `PASSWORD`, `EMAIL`, `CREATE_TIME`, `STATUS`, `DEPT_NUM`) values('4','test','oracle','123456','oracle@or.com','2017-06-13 10:16:10','0','20000');
insert into `user` (`ID`, `SALT`, `LOGIN_NAME`, `PASSWORD`, `EMAIL`, `CREATE_TIME`, `STATUS`, `DEPT_NUM`) values('5','test','soft','123456','soft@qq.com','2017-06-13 10:16:33','0','30000');
