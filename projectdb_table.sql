CREATE TABLE `cart` (
  `consumer_id` int(11) NOT NULL COMMENT '消费者ID',
  `sale_info_id` int(11) DEFAULT NULL COMMENT '商品id',
  `quantity` int(11) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`consumer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `consumer` (
  `id` int(11) NOT NULL,
  `username` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名(登录账户)',
  `pay_pwd` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '消费者支付密码',
  `password` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录密码',
  `salt` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `birthday` date DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `balance` double DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `delivery_info` (
  `id` int(11) NOT NULL,
  `consumer_id` int(11) DEFAULT NULL COMMENT '消费者id',
  `name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收件人姓名',
  `address` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收件地址',
  `phone` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `postcode` int(11) DEFAULT NULL COMMENT '邮编',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `order_form` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单号',
  `creation_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `consumer_id` int(11) DEFAULT NULL COMMENT '消费者id',
  `delivery_id` int(11) DEFAULT NULL COMMENT '收件人信息id',
  `notes` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '附加信息',
  `total_bill` int(11) DEFAULT NULL COMMENT '总支付费用',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL COMMENT '数量',
  `notes` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '附加信息',
  `order_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单号(对应order_form的order_id)',
  `sale_info_id` int(11) DEFAULT NULL COMMENT '商品id',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态: 0-已支付, 1-待发货,2-已发货,3-已完成,4-已取消',
  PRIMARY KEY (`id`),
  KEY `FKcb8g5748xrhjevu47l27pa6cg` (`sale_info_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `sale_info` (
  `id` int(11) NOT NULL,
  `company_id` int(11) DEFAULT NULL COMMENT '公司ID',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品描述',
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品图片',
  `mvo_cmdt_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `name` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名字',
  `price` int(11) DEFAULT NULL COMMENT '商品价格',
  `quantity` int(11) DEFAULT NULL COMMENT '商品数量',
  `seller_id` int(11) DEFAULT NULL COMMENT '借卖方ID',
  `shop_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `state` tinyint(2) DEFAULT NULL COMMENT '商品状态',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `seller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telephone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `pay_pwd` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
