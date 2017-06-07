如何快速搭好一个ssh框架
1.先同过maven依赖相关的jar包，hibernate的相关配置属性在etc文件下有一个hibernate.properties的文件
2.创建hibernate.cfg.xml，也可以在spring中配置hibernate的相关配置

介绍hibernate：
重点：hibernate有5个核心接口
1.Session接口     			负责被持久化对象的crud操作，注意这个session是非线程安全的，与httpsession不同
2.SessionFactory接口		负责hibernate的初始化环境，比如数据存储源的代理，创建session，并且这个是重量级的，最好是只初始化一次
3.Configuration接口		负责配置并启动hibernate，加载配置文件，创建SessionFactory对象
4.Transaction接口		负责事务管理
5.Query和Criteria接口	负责各种数据库的查询，有HQL或SQL语句两种查询方式


注意事项：
1.使用hibernate框架的好处以及它的缺点	
	a）注意要知道在哪里找相关配置文件的属性，整理好要讲课的内容，以及文件
2.和spring整合需要注意的事项
	a）有两种方式。第一种直接在spring中配置hibernate的参数，第二种通过加载资源的方式来加载hibernate的配值文件
	b）注意连接池的选用，以及连接池的配置
	c）减少模版式代码，spring提供hibernateDaoSupport支持，可以获得一个模版类（HibernateTempate），这个可以提供业务逻辑不是特别复杂的操作。如果遇到特殊的业务要求，需要调用execute方法。比如调用数据库的存储过程
	d）spring添加的声明是事务处理，有注解方式（慎用）和配置文件方式。需要了解spring的事务传播机制和隔离级别