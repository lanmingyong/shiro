
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `permission` */

CREATE TABLE `permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `token` varchar(20) DEFAULT '' COMMENT '标识',
  `name` varchar(20) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='权限表';

/*Data for the table `permission` */

insert  into `permission`(`id`,`token`,`name`) values (1,'user:query','用户列表');
insert  into `permission`(`id`,`token`,`name`) values (2,'user:edit','用户编辑');
insert  into `permission`(`id`,`token`,`name`) values (3,'user:delete','用户删除');

/*Table structure for table `role` */

CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `token` varchar(20) DEFAULT '' COMMENT '标识',
  `name` varchar(20) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `role` */

insert  into `role`(`id`,`token`,`name`) values (1,'admin','管理员');
insert  into `role`(`id`,`token`,`name`) values (2,'guest','游客');

/*Table structure for table `role_to_permission` */

CREATE TABLE `role_to_permission` (
  `rid` int(10) unsigned NOT NULL COMMENT '角色ID',
  `pid` int(10) unsigned NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`rid`,`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

/*Data for the table `role_to_permission` */

insert  into `role_to_permission`(`rid`,`pid`) values (1,1);
insert  into `role_to_permission`(`rid`,`pid`) values (1,2);
insert  into `role_to_permission`(`rid`,`pid`) values (1,3);

/*Table structure for table `user_to_role` */

CREATE TABLE `user_to_role` (
  `uid` int(10) unsigned NOT NULL COMMENT '用户ID',
  `rid` int(10) unsigned NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`rid`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `user_to_role` */

insert  into `user_to_role`(`uid`,`rid`) values (1,1);

/*Table structure for table `users` */

CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginName` varchar(200) NOT NULL DEFAULT '' COMMENT '登录名',
  `password` varchar(200) DEFAULT '' COMMENT '密码',
  `userName` varchar(100) DEFAULT '' COMMENT '姓名',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `userPhone` varchar(150) DEFAULT '' COMMENT '电话',
  `userEmail` varchar(100) DEFAULT '' COMMENT '邮箱',
  `headImg` varchar(200) DEFAULT '' COMMENT '头像',
  `deleteFlag` tinyint(1) DEFAULT '1' COMMENT '删除标记',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=471693 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (1,'admin','669df080b3009d81f429ce5f035f2617','管理员','2016-12-06 11:20:03','1429693668568','x@y.com','',0);
insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (4,'test-4','tpass-4','测试-4',NULL,'1429693668598','x@y.com','',0);
insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (5,'test-5','tpass-5','测试-5',NULL,'1429693668620','x@y.com','',0);
insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (6,'test-6','tpass-6','测试-6',NULL,'1429693668650','x@y.com','',0);
insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (7,'test-7','tpass-7','测试-7',NULL,'1429693668680','x@y.com','',0);
insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (8,'test-8','tpass-8','测试-8',NULL,'1429693668709','x@y.com','',0);
insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (9,'test-9','tpass-9','测试-9',NULL,'1429693668739','x@y.com','',0);
insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (10,'test-10','tpass-10','测试-10',NULL,'1429693668767','x@y.com','',0);
insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (11,'test-11','tpass-11','测试-11',NULL,'1429693668789','x@y.com','',0);
insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (12,'test-12','tpass-12','测试-12',NULL,'1429693668817','x@y.com','',0);
insert  into `users`(`userId`,`loginName`,`password`,`userName`,`birthday`,`userPhone`,`userEmail`,`headImg`,`deleteFlag`) values (13,'test-13','tpass-13','测试-13',NULL,'1429693668839','x@y.com','',0);

