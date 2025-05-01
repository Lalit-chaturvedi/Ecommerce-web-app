-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2025 at 11:15 AM
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
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

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
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

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
  `image_name` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `image_type` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `static_values`
--

CREATE TABLE `static_values` (
  `active` bit(1) NOT NULL,
  `static_values_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `static_values`
--

INSERT INTO `static_values` (`active`, `static_values_id`, `name`, `value`) VALUES
(b'1', 1, 'Product-SubCategory', 'Bed'),
(b'1', 2, 'Product-SubCategory', 'Sofa'),
(b'1', 3, 'Product-SubCategory', 'Center Table'),
(b'1', 4, 'Product-SubCategory', 'Bed side table'),
(b'1', 5, 'Product-SubCategory', 'Bed Bench'),
(b'1', 6, 'Product-SubCategory', 'Dining Table'),
(b'1', 7, 'Product-SubCategory', 'Dining chair'),
(b'1', 8, 'Product-SubCategory', 'Crockery Unit'),
(b'1', 9, 'Product-SubCategory', 'Dining Cabinet'),
(b'1', 10, 'Product-SubCategory', 'Wall Artifect'),
(b'1', 11, 'Product-SubCategory', 'Table Artifect'),
(b'1', 12, 'Product-SubCategory', 'Wall Paintings'),
(b'1', 13, 'Product-SubCategory', 'Hanging Artifects'),
(b'1', 14, 'Product-SubCategory', 'Table Lamp'),
(b'1', 15, 'Product-SubCategory', 'Wall Lamp'),
(b'1', 16, 'Product-SubCategory', 'Hanging Lamp'),
(b'1', 17, 'Product-SubCategory', 'Chandilier'),
(b'1', 18, 'Product-SubCategory', 'Outdoor Wall Lamp'),
(b'1', 19, 'Product-SubCategory', 'Outdoor Pole Light'),
(b'1', 20, 'Product-SubCategory', 'Indoor Ceiling Lights'),
(b'1', 21, 'Product-SubCategory', 'Pole Lamps'),
(b'1', 22, 'Product-SubCategory', 'Flush Doors'),
(b'1', 23, 'Product-SubCategory', 'Alluminium Doors'),
(b'1', 24, 'Product-SubCategory', 'Electric doors'),
(b'1', 25, 'Product-SubCategory', 'Office Desk'),
(b'1', 26, 'Product-SubCategory', 'Workstation'),
(b'1', 27, 'Product-SubCategory', 'Boss Chair'),
(b'1', 28, 'Product-SubCategory', 'Staff Chair'),
(b'1', 29, 'Product-SubCategory', 'Stool'),
(b'1', 30, 'Product-SubCategory', 'Conferrence table'),
(b'1', 31, 'Product-SubCategory', 'Side Cabinet'),
(b'1', 32, 'Product-SubCategory', 'Curtain'),
(b'1', 33, 'Product-SubCategory', 'Sheer'),
(b'1', 34, 'Product-SubCategory', 'Bedsheets'),
(b'1', 35, 'Product-Category', 'Furniture'),
(b'1', 36, 'Product-Category', 'Artifects'),
(b'1', 37, 'Product-Category', 'Lights'),
(b'1', 38, 'Product-Category', 'Doors'),
(b'1', 39, 'Product-Category', 'Office Furniture'),
(b'1', 40, 'Product-Category', 'Furnishings');

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
-- Indexes for table `static_values`
--
ALTER TABLE `static_values`
  ADD PRIMARY KEY (`static_values_id`);

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
  MODIFY `productcategory_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productsubcategory`
--
ALTER TABLE `productsubcategory`
  MODIFY `productsubcategory_id` bigint(20) NOT NULL AUTO_INCREMENT;

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
-- AUTO_INCREMENT for table `static_values`
--
ALTER TABLE `static_values`
  MODIFY `static_values_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

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
