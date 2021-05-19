-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1:3306
-- Tid vid skapande: 19 maj 2021 kl 12:31
-- Serverversion: 5.7.31
-- PHP-version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `blandditposts`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `posts`
--

DROP TABLE IF EXISTS `posts`;
CREATE TABLE IF NOT EXISTS `posts` (
  `postId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `text` varchar(200) NOT NULL,
  `tag` varchar(30) NOT NULL,
  PRIMARY KEY (`postId`)
) ENGINE=MyISAM AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `posts`
--

INSERT INTO `posts` (`postId`, `title`, `text`, `tag`) VALUES
(55, 'First post', 'Short Novel', 'Hashtag'),
(56, 'Second entry', 'Interesting text', 'Tagtastic'),
(57, 'Cool Title', 'Third entry', '333');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
