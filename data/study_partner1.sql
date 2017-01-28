-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 28, 2017 at 02:14 PM
-- Server version: 5.6.28
-- PHP Version: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `study_partner1`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignments`
--

CREATE TABLE `assignments` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `deadline` varchar(100) DEFAULT NULL,
  `subject_id` int(11) UNSIGNED NOT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `exams`
--

CREATE TABLE `exams` (
  `id` int(11) UNSIGNED NOT NULL,
  `subject_id` int(11) UNSIGNED DEFAULT NULL,
  `start_time` varchar(10) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exams`
--

INSERT INTO `exams` (`id`, `subject_id`, `start_time`, `date`, `description`) VALUES
(6, 10, '08:00', '2016-10-20', ''),
(7, 11, '09:00', '2016-10-31', ''),
(8, 12, '14:00', '2016-12-16', ''),
(9, 13, '08:00', '2016-12-12', 'Open Exam'),
(11, 15, '10:00', '2016-10-14', ''),
(12, 17, '14:00', '2016-12-15', '');

-- --------------------------------------------------------

--
-- Table structure for table `semesters`
--

CREATE TABLE `semesters` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `semesters`
--

INSERT INTO `semesters` (`id`, `name`) VALUES
(11, 'Autumn 2016'),
(12, 'Spring 2017');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `credits` int(11) UNSIGNED NOT NULL,
  `semester_id` int(11) UNSIGNED DEFAULT NULL,
  `teacher_id` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`id`, `name`, `credits`, `semester_id`, `teacher_id`) VALUES
(10, 'Finnish Language and Culture 1', 3, 11, 11),
(11, 'Basic of Mathematical Techniques', 3, 11, 12),
(12, 'Device Technology of Computer', 3, 11, 14),
(13, 'Software Engineering Tools', 3, 11, 13),
(14, 'Java Programming', 6, 11, 15),
(15, 'Basic of Computer Technology', 3, 11, 14),
(16, 'Studying in UAS', 3, 11, 12),
(17, 'Professional English Communication', 3, 11, 11),
(18, 'Finnish Language and Culture 2', 3, 12, 11),
(19, '3D-Mathematics', 3, 12, 12),
(20, 'Mechanics', 3, 12, 12),
(21, 'Databases', 6, 12, 16),
(22, 'Internet Programming', 6, 12, 15),
(23, 'Software Development Project 1', 6, 12, 15),
(24, 'Engineering English', 3, 12, 11),
(25, 'Server Operating Systems', 3, 12, 17);

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

CREATE TABLE `teachers` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `phone_number` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `teachers`
--

INSERT INTO `teachers` (`id`, `name`, `phone_number`) VALUES
(11, 'Kaija Posioo', ''),
(12, 'Susanna Kujanpää', ''),
(13, 'Veijo Väisänen', ''),
(14, 'Timo Vainio', ''),
(15, 'Kari Laitinen', ''),
(16, 'Pekka Alaluukas', ''),
(17, 'Teemu Korpela', '');

-- --------------------------------------------------------

--
-- Table structure for table `time_table`
--

CREATE TABLE `time_table` (
  `id` int(11) UNSIGNED NOT NULL,
  `subject_id` int(11) UNSIGNED DEFAULT NULL,
  `day` varchar(50) DEFAULT NULL,
  `room_number` varchar(10) DEFAULT NULL,
  `start_time` varchar(10) DEFAULT NULL,
  `end_time` varchar(10) DEFAULT NULL,
  `teacher_id` int(11) UNSIGNED DEFAULT NULL,
  `semester_id` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `time_table`
--

INSERT INTO `time_table` (`id`, `subject_id`, `day`, `room_number`, `start_time`, `end_time`, `teacher_id`, `semester_id`) VALUES
(6, 11, '2', '2362', '12:00', '14:00', 12, 11),
(7, 15, '2', '3364', '14:00', '16:00', 14, 11),
(8, 10, '2', '3432', '08:00', '11:00', 11, 11),
(9, 15, '3', '1318', '11:00', '14:00', 14, 11),
(10, 10, '4', '2396', '12:00', '14:00', 11, 11),
(11, 16, '4', '3362', '14:00', '16:00', 12, 11),
(12, 11, '5', '3364', '09:00', '12:00', 12, 11),
(13, 14, '5', '1322', '12:00', '16:00', 15, 11),
(14, 14, '2', '1322', '08:00', '12:00', 15, 11),
(15, 16, '2', '3328', '12:00', '14:00', 12, 11),
(16, 13, '2', '1318', '08:00', '13:00', 13, 11),
(17, 17, '4', '3318', '10:00', '12:00', 11, 11),
(18, 17, '5', '2316', '12:00', '14:00', 11, 11),
(19, 12, '5', '1320', '08:00', '12:00', 14, 11),
(20, 18, '1', '1320', '08:00', '10:00', 11, 12),
(21, 19, '2', '3364', '10:00', '13:00', 12, 12),
(22, 20, '3', '3330', '12:00', '14:00', 12, 12),
(23, 21, '4', '3332', '12:00', '16:00', 16, 12),
(24, 22, '5', '3332', '09:00', '14:00', 15, 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignments`
--
ALTER TABLE `assignments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `exams`
--
ALTER TABLE `exams`
  ADD PRIMARY KEY (`id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `semesters`
--
ALTER TABLE `semesters`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `semester_id` (`semester_id`),
  ADD KEY `teacher_id` (`teacher_id`);

--
-- Indexes for table `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `time_table`
--
ALTER TABLE `time_table`
  ADD PRIMARY KEY (`id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `teacher_id` (`teacher_id`),
  ADD KEY `semester_id` (`semester_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignments`
--
ALTER TABLE `assignments`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `exams`
--
ALTER TABLE `exams`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `semesters`
--
ALTER TABLE `semesters`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `teachers`
--
ALTER TABLE `teachers`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `time_table`
--
ALTER TABLE `time_table`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignments`
--
ALTER TABLE `assignments`
  ADD CONSTRAINT `assignments_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `exams`
--
ALTER TABLE `exams`
  ADD CONSTRAINT `exams_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subjects`
--
ALTER TABLE `subjects`
  ADD CONSTRAINT `subjects_ibfk_1` FOREIGN KEY (`semester_id`) REFERENCES `semesters` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `subjects_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `time_table`
--
ALTER TABLE `time_table`
  ADD CONSTRAINT `time_table_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `time_table_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `time_table_ibfk_3` FOREIGN KEY (`semester_id`) REFERENCES `semesters` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
