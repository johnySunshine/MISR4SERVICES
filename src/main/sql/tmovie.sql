CREATE TABLE `tmovies` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `run_time` varchar(50) DEFAULT NULL,
  `original_title` varchar(50) DEFAULT NULL,
  `child_protection_display_name` varchar(100) DEFAULT NULL,
  `child_protection_Id` varchar(20) DEFAULT NULL,
  `child_protection_level` varchar(50) DEFAULT NULL,
  `countries` varchar(50) DEFAULT NULL,
  `main_genre` varchar(50) DEFAULT NULL,
  `long_description` text,
  `year` varchar(20) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `creation_date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8