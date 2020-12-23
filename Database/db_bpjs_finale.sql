-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2020 at 10:09 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_bpjs_finale`
--

-- --------------------------------------------------------

--
-- Table structure for table `bpjs`
--

CREATE TABLE `bpjs` (
  `id_bpjs` int(11) NOT NULL,
  `nama_pelanggan` varchar(255) DEFAULT NULL,
  `no_bpjs` int(11) DEFAULT NULL,
  `status_pembayaran` varchar(255) DEFAULT NULL,
  `total_tagihan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bpjs`
--

INSERT INTO `bpjs` (`id_bpjs`, `nama_pelanggan`, `no_bpjs`, `status_pembayaran`, `total_tagihan`) VALUES
(1, 'andi', 123456789, 'Belum Bayar', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bpjs`
--
ALTER TABLE `bpjs`
  ADD PRIMARY KEY (`id_bpjs`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
