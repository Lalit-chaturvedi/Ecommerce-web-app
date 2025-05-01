-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2025 at 09:10 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommers`
--

-- --------------------------------------------------------

--
-- Table structure for table `productcategory`
--

CREATE TABLE `productcategory` (
  `active` bit(1) NOT NULL,
  `productcategory_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `productcategory`
--

INSERT INTO `productcategory` (`active`, `productcategory_id`, `description`, `name`) VALUES
(b'1', 1, 'description', 'Furniture'),
(b'1', 2, 'description', 'Artifects'),
(b'1', 3, 'description', 'Lights'),
(b'1', 4, 'description', 'Doors'),
(b'1', 5, 'description', 'Office Furniture'),
(b'1', 6, 'description', 'Furnishings'),
(b'0', 7, 'description', 'XYZ');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `active` bit(1) NOT NULL,
  `price` double DEFAULT NULL,
  `fk_productcategory_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productsubcategory`
--

CREATE TABLE `productsubcategory` (
  `active` bit(1) NOT NULL,
  `fk_productcategory_id` bigint(20) DEFAULT NULL,
  `productsubcategory_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `productsubcategory`
--

INSERT INTO `productsubcategory` (`active`, `fk_productcategory_id`, `productsubcategory_id`, `description`, `name`) VALUES
(b'1', 1, 1, 'description', 'Bed'),
(b'1', 1, 2, 'description', 'Sofa'),
(b'1', 1, 3, 'description', 'Center Table'),
(b'1', 1, 4, 'description', 'Bed side table'),
(b'1', 1, 5, 'description', 'Bed Bench'),
(b'1', 1, 6, 'description', 'Dining Table'),
(b'1', 1, 7, 'description', 'Dining chair'),
(b'1', 1, 8, 'description', 'Crockery Unit'),
(b'1', 1, 9, 'description', 'Dining Cabinet'),
(b'1', 2, 10, 'description', 'Wall Artifect'),
(b'1', 2, 11, 'description', 'Table Artifect'),
(b'1', 2, 12, 'description', 'Wall Paintings'),
(b'1', 2, 13, 'description', 'Hanging Artifects'),
(b'1', 3, 14, 'description', 'Table Lamp'),
(b'1', 3, 15, 'description', 'Wall Lamp'),
(b'1', 3, 16, 'description', 'Hanging Lamp'),
(b'1', 3, 17, 'description', 'Chandilier'),
(b'1', 3, 18, 'description', 'Outdoor Wall Lamp'),
(b'1', 3, 19, 'description', 'Outdoor Pole Light'),
(b'1', 3, 20, 'description', 'Indoor Ceiling Lights'),
(b'1', 3, 21, 'description', 'Pole Lamps'),
(b'1', 4, 22, 'description', 'Flush Doors'),
(b'1', 4, 23, 'description', 'Alluminium Doors'),
(b'1', 4, 24, 'description', 'Electric doors'),
(b'1', 5, 25, 'description', 'Office Desk'),
(b'1', 5, 26, 'description', 'Workstation'),
(b'1', 5, 27, 'description', 'Boss Chair'),
(b'1', 5, 28, 'description', 'Staff Chair'),
(b'1', 5, 29, 'description', 'Stool'),
(b'1', 5, 30, 'description', 'Conferrence table'),
(b'1', 5, 31, 'description', 'Side Cabinet'),
(b'1', 6, 32, 'description', 'Curtain'),
(b'1', 6, 33, 'description', 'Sheer'),
(b'1', 6, 34, 'description', 'Bedsheets');

-- --------------------------------------------------------

--
-- Table structure for table `product_changes_questions`
--

CREATE TABLE `product_changes_questions` (
  `active` bit(1) NOT NULL,
  `answer` bit(1) NOT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `product_chagques_id` bigint(20) NOT NULL,
  `question` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_images`
--

CREATE TABLE `product_images` (
  `active` bit(1) NOT NULL,
  `default_image` bit(1) NOT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `image_size` bigint(20) NOT NULL,
  `product_images_id` bigint(20) NOT NULL,
  `image_description` varchar(255) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `image_type` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `phone_verified` bit(1) NOT NULL,
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `productcategory`
--
ALTER TABLE `productcategory`
  ADD PRIMARY KEY (`productcategory_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD UNIQUE KEY `UKdfh5ltxwrsk518rdhb7t51k42` (`fk_productcategory_id`);

--
-- Indexes for table `productsubcategory`
--
ALTER TABLE `productsubcategory`
  ADD PRIMARY KEY (`productsubcategory_id`),
  ADD KEY `FKa2op217gf70g22uj9pu173a45` (`fk_productcategory_id`);

--
-- Indexes for table `product_changes_questions`
--
ALTER TABLE `product_changes_questions`
  ADD PRIMARY KEY (`product_chagques_id`),
  ADD KEY `FKq3jf1i6gh6h94ts9bqag2e24j` (`fk_product_id`);

--
-- Indexes for table `product_images`
--
ALTER TABLE `product_images`
  ADD PRIMARY KEY (`product_images_id`),
  ADD KEY `FK7qc4o7l9txirqtpdkleqtcasm` (`fk_product_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `productcategory`
--
ALTER TABLE `productcategory`
  MODIFY `productcategory_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productsubcategory`
--
ALTER TABLE `productsubcategory`
  MODIFY `productsubcategory_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `product_changes_questions`
--
ALTER TABLE `product_changes_questions`
  MODIFY `product_chagques_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product_images`
--
ALTER TABLE `product_images`
  MODIFY `product_images_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK58hm53j3hm0np67dmhvhhysu8` FOREIGN KEY (`fk_productcategory_id`) REFERENCES `productcategory` (`productcategory_id`);

--
-- Constraints for table `productsubcategory`
--
ALTER TABLE `productsubcategory`
  ADD CONSTRAINT `FKa2op217gf70g22uj9pu173a45` FOREIGN KEY (`fk_productcategory_id`) REFERENCES `productcategory` (`productcategory_id`);

--
-- Constraints for table `product_changes_questions`
--
ALTER TABLE `product_changes_questions`
  ADD CONSTRAINT `FKq3jf1i6gh6h94ts9bqag2e24j` FOREIGN KEY (`fk_product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `product_images`
--
ALTER TABLE `product_images`
  ADD CONSTRAINT `FK7qc4o7l9txirqtpdkleqtcasm` FOREIGN KEY (`fk_product_id`) REFERENCES `products` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
