-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2023 at 04:55 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `manufacture`
--

CREATE TABLE `manufacture` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(128) NOT NULL,
  `Location` varchar(128) NOT NULL,
  `Employee` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manufacture`
--

INSERT INTO `manufacture` (`ID`, `Name`, `Location`, `Employee`) VALUES
('1', 'Lê Văn Sỹ', 'Lê Văn Sỹ, Q3', 10),
('2', 'My', 'My', 0);

-- --------------------------------------------------------

--
-- Table structure for table `mobilephone`
--

CREATE TABLE `mobilephone` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(128) NOT NULL,
  `Price` int(11) NOT NULL,
  `color` varchar(10) NOT NULL,
  `Country` varchar(10) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `manufacture_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mobilephone`
--

INSERT INTO `mobilephone` (`ID`, `Name`, `Price`, `color`, `Country`, `Quantity`, `manufacture_id`) VALUES
('1', 'Iphone 6', 900000000, 'blue', 'VN', 2, 1),
('2', 'Xiaomi 10', 5000, 'pink', 'VN', 2, 1),
('3', 'Iphone 7', 7000, 'pin', 'Anh', 1, 1),
('p01', 'Tinh', 500, 'pink', 'US', 1, 1),
('pu', 'pu', 155, 'cao', 'h', 5, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mobilephone`
--
ALTER TABLE `mobilephone`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
