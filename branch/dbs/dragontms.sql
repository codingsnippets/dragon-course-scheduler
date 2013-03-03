

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `cs451db`
--

-- --------------------------------------------------------

--
-- Table structure for table `courseRef`
--

CREATE TABLE `courseRef` (
  `ID` int(11) NOT NULL,
  `coursename` int(11) NOT NULL,
  `name` text NOT NULL,
  PRIMARY KEY  (`coursename`),
  KEY `ID` (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `courseRef`
--

INSERT INTO `courseRef` VALUES(1, 218121, 'Computation Laboratory I');
INSERT INTO `courseRef` VALUES(2, 218122, 'Computation Laboratory II');
INSERT INTO `courseRef` VALUES(3, 218123, 'Computation Laboratory III');
INSERT INTO `courseRef` VALUES(4, 218130, 'Programming Concepts with 3D Animation');
INSERT INTO `courseRef` VALUES(5, 218131, 'Computer Programming A');
INSERT INTO `courseRef` VALUES(6, 218132, 'Computer Programming B');
INSERT INTO `courseRef` VALUES(7, 218133, 'Computer Programming C');
INSERT INTO `courseRef` VALUES(8, 218161, 'Introduction to Computing');
INSERT INTO `courseRef` VALUES(9, 218164, 'Introduction to Computer Science');
INSERT INTO `courseRef` VALUES(10, 218171, 'Computer Programming I');
INSERT INTO `courseRef` VALUES(11, 218172, 'Computer Programming II');
INSERT INTO `courseRef` VALUES(12, 218175, 'Computer Programming I-II');
INSERT INTO `courseRef` VALUES(13, 218190, 'Selected Computer Language');
INSERT INTO `courseRef` VALUES(14, 218203, 'Programming for Engineers');
INSERT INTO `courseRef` VALUES(15, 218204, 'Advanced Programming for Engineers');
INSERT INTO `courseRef` VALUES(16, 218260, 'Data Structures');
INSERT INTO `courseRef` VALUES(17, 218265, 'Advanced Programming Tools and Techniques');
INSERT INTO `courseRef` VALUES(18, 218270, 'Mathematical Foundations of Computer Science');
INSERT INTO `courseRef` VALUES(19, 218280, 'Special Topics in Computer Science ');
INSERT INTO `courseRef` VALUES(20, 218281, 'Systems Architecture');
INSERT INTO `courseRef` VALUES(21, 218282, 'Systems Architecture II');
INSERT INTO `courseRef` VALUES(22, 218283, 'Systems Programming');
INSERT INTO `courseRef` VALUES(23, 218300, 'Applied Symbolic Computation');
INSERT INTO `courseRef` VALUES(24, 218303, 'Algorithmic Number Theory and Cryptography');
INSERT INTO `courseRef` VALUES(25, 218337, 'The Psychology of Human-Computer Interaction');
INSERT INTO `courseRef` VALUES(26, 218338, 'Graphical User Interfaces');
INSERT INTO `courseRef` VALUES(27, 218345, 'Computer Game Design and Development');
INSERT INTO `courseRef` VALUES(28, 218347, 'Experimental Game Development');
INSERT INTO `courseRef` VALUES(29, 218348, 'Serious Game Development');
INSERT INTO `courseRef` VALUES(30, 218350, '[WI] Software Design');
INSERT INTO `courseRef` VALUES(31, 218360, 'Programming Language Concepts');
INSERT INTO `courseRef` VALUES(32, 218361, 'Concurrent Programming');
INSERT INTO `courseRef` VALUES(33, 218365, 'System Administration');
INSERT INTO `courseRef` VALUES(34, 218370, 'Operating Systems');
INSERT INTO `courseRef` VALUES(35, 218380, 'Artificial Intelligence');
INSERT INTO `courseRef` VALUES(36, 218430, 'Computer Graphics');
INSERT INTO `courseRef` VALUES(37, 218431, 'Advanced Rendering Techniques');
INSERT INTO `courseRef` VALUES(38, 218432, 'Interactive Computer Graphics');
INSERT INTO `courseRef` VALUES(39, 218435, 'Computational Photography');
INSERT INTO `courseRef` VALUES(40, 218440, 'Theory of Computation');
INSERT INTO `courseRef` VALUES(41, 218441, 'Compiler Workshop I');
INSERT INTO `courseRef` VALUES(42, 218442, 'Compiler Workshop II');
INSERT INTO `courseRef` VALUES(43, 218445, 'Topics in Computer Gaming');
INSERT INTO `courseRef` VALUES(44, 218451, 'Software Engineering');
INSERT INTO `courseRef` VALUES(45, 218457, 'Data Structures and Algorithms I');
INSERT INTO `courseRef` VALUES(46, 218458, 'Data Structures and Algorithms II');
INSERT INTO `courseRef` VALUES(47, 218461, 'Database Systems');
INSERT INTO `courseRef` VALUES(48, 218470, 'Operating Systems Workshop');

-- --------------------------------------------------------

--
-- Table structure for table `currrent_schedule`
--

CREATE TABLE `currrent_schedule` (
  `CRN` mediumint(6) NOT NULL,
  `Subject` text,
  `Course_no` smallint(6) default NULL,
  `Term` text NOT NULL,
  `Section` smallint(6) NOT NULL,
  `Instruction_type` text,
  `Instructor` text,
  `Location` text,
  `Weekday` text,
  `Start_time` time NOT NULL,
  `End_time` time NOT NULL,
  `Start_block` smallint(6) NOT NULL,
  `End_block` smallint(6) NOT NULL,
  `coursename` int(11) NOT NULL,
  PRIMARY KEY  (`CRN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `currrent_schedule`
--

INSERT INTO `currrent_schedule` VALUES(30244, 'CS', 161, 'Spring', 1, 'Lecture', 'STAFF', 'TBD', 'R', '18:30:00', '21:20:00', 22, 24, 218161);
INSERT INTO `currrent_schedule` VALUES(30258, 'CS', 281, 'Spring ', 1, 'Lecture & Lab', 'Jeremy Russell Johnson', 'TBD', 'W', '16:00:00', '17:50:00', 17, 20, 218281);
INSERT INTO `currrent_schedule` VALUES(30260, 'CS', 361, 'Spring', 1, 'Lecture', 'Bruce Char', 'TBD', 'M', '18:00:00', '20:50:00', 21, 24, 218361);
INSERT INTO `currrent_schedule` VALUES(30728, 'CS', 440, 'Spring', 1, 'Lecture', 'Krzysztof Nowak', 'TBD', 'MWF', '10:00:00', '10:50:00', 5, 6, 218440);
INSERT INTO `currrent_schedule` VALUES(30819, 'CS', 171, 'Spring', 1, 'Lecture', 'Adelaida Alban Medlock', 'TBD', 'W', '18:00:00', '20:50:00', 21, 24, 218171);
INSERT INTO `currrent_schedule` VALUES(32093, 'CS', 303, 'Spring', 1, 'Lecture', 'Jeremy Russell Johnson', 'TBD', 'TR', '12:30:00', '13:50:00', 10, 11, 218303);
INSERT INTO `currrent_schedule` VALUES(32097, 'CS', 122, 'Spring', 61, 'Lab', 'STAFF', 'TBD', 'M', '15:00:00', '16:50:00', 15, 18, 218122);
INSERT INTO `currrent_schedule` VALUES(33811, 'CS', 337, 'Spring ', 1, 'Lecture', 'Frank J Lee', 'TBD', 'W', '18:00:00', '20:50:00', 21, 22, 218337);
INSERT INTO `currrent_schedule` VALUES(34541, 'CS', 172, 'Spring', 65, 'Lab', 'STAFF', 'TBD', 'R', '15:00:00', '16:50:00', 15, 14, 218172);

-- --------------------------------------------------------

--
-- Table structure for table `require`
--

CREATE TABLE `require` (
  `coursename` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `subject` int(11) NOT NULL,
  `courseno` int(11) NOT NULL,
  `prereq` text,
  `postreq` text,
  `prespecial` text,
  PRIMARY KEY  (`coursename`),
  UNIQUE KEY `coursename` (`coursename`),
  KEY `ID` (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `require`
--

INSERT INTO `require` VALUES(218121, 1, 218, 121, NULL, '122', NULL);
INSERT INTO `require` VALUES(218122, 2, 218, 122, '121', '123', NULL);
INSERT INTO `require` VALUES(218123, 3, 218, 123, '122', NULL, NULL);
INSERT INTO `require` VALUES(218171, 4, 218, 171, NULL, '172', NULL);
INSERT INTO `require` VALUES(218172, 5, 218, 172, '171', NULL, NULL);
INSERT INTO `require` VALUES(218260, 6, 218, 260, '265', NULL, NULL);
INSERT INTO `require` VALUES(218270, 7, 218, 270, '172', '350,451', NULL);
INSERT INTO `require` VALUES(218265, 8, 218, 265, '172', '350,451,270', NULL);
INSERT INTO `require` VALUES(218281, 9, 218, 281, '270,172', '', 'ECE200,SE103');
INSERT INTO `require` VALUES(218283, 10, 218, 283, '265', '370,472,475,476', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `track`
--

CREATE TABLE `track` (
  `Track_no` smallint(6) NOT NULL default '0',
  `Track_name` text NOT NULL,
  `Course_list` text NOT NULL,
  `Optional` text,
  `Prereq` text,
  PRIMARY KEY  (`Track_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `track`
--

INSERT INTO `track` VALUES(1, 'Algorithms and Data Structures and Algorithms', '218457,218458,218440', NULL, NULL);
INSERT INTO `track` VALUES(2, 'Artificial Intelligence', '218380,218481,218485', NULL, NULL);
INSERT INTO `track` VALUES(3, 'Computer and Network Security', '218472,218475,218303', NULL, '218361');
INSERT INTO `track` VALUES(4, 'Computer Architecture', '218282', '218476,4020402356,4020402413', NULL);
INSERT INTO `track` VALUES(5, 'Computer Graphics and Vision', '218430,218435', '218431,218432,218338', '12001907200');
INSERT INTO `track` VALUES(6, 'Computing Systems', '218361,218370', '218472,218365,218461', NULL);
INSERT INTO `track` VALUES(7, 'Game Development and Design', '218345', '218347,218445,218348,3080612361,3080612362', '3080612260');
INSERT INTO `track` VALUES(8, 'Human-Computer Interaction', '218337,218338', '151824330,218430,218345,218435', '151824101');
INSERT INTO `track` VALUES(9, 'Numeric and Symbolic Computation', '12001907300,218300', '12001907301,12001907305,218303,218480', '12001907200');
INSERT INTO `track` VALUES(10, 'Software Engineering', '12001907311,1804320,1804410', NULL, '218350');
