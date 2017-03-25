-- Dumping database structure for student
CREATE DATABASE IF NOT EXISTS `students` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `students`;

-- Dumping structure for table student.student
CREATE TABLE IF NOT EXISTS `student` (
  `rollno` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
