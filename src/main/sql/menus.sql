CREATE TABLE `tmenus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuText` varchar(50) DEFAULT NULL,
  `menuUrl` varchar(100) DEFAULT NULL,
  `target` varchar(50) DEFAULT NULL,
  `subid` varchar(50) DEFAULT NULL,
  `hubIsVisible` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8