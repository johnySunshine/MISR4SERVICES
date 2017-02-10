CREATE TABLE `tcustomconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `config_key` varchar(50) DEFAULT NULL,
  `config_value` varchar(100) DEFAULT NULL,
  `usertype` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8