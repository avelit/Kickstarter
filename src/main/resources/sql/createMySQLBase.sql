-- phpMyAdmin SQL Dump
-- version 4.0.10.2
-- http://www.phpmyadmin.net
--
-- ����: hbt00.mysql.ukraine.com.ua
-- ����� ��������: ��� 20 2015 �., 10:46
-- ������ �������: 5.1.72-cll-lve
-- ������ PHP: 5.2.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- ���� ������: `hbt00_gojava32`
--

-- --------------------------------------------------------

--
-- ��������� ������� `blogs`
--

CREATE TABLE IF NOT EXISTS `blogs` (
  `id` int(11) NOT NULL,
  `author` text,
  `id_project` int(11) DEFAULT NULL,
  `text` text,
  `created` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_project` (`id_project`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- ���� ������ ������� `blogs`
--

INSERT INTO `blogs` (`id`, `author`, `id_project`, `text`, `created`) VALUES
(1, '1', 1, 'blablabla_blog', '0000-00-00');

-- --------------------------------------------------------

--
-- ��������� ������� `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL,
  `name` text,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- ���� ������ ������� `categories`
--

INSERT INTO `categories` (`id`, `name`, `description`) VALUES
(1, 'Music', 'desc Music'),
(2, 'Medicine', 'desc Medicine'),
(45, 'Tech', 'test description'),
(46, 'Food', 'food desc');

-- --------------------------------------------------------

--
-- ��������� ������� `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL,
  `author` text,
  `id_project` int(11) DEFAULT NULL,
  `text` text,
  `created` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_project` (`id_project`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- ��������� ������� `persistent_logins`
--

CREATE TABLE IF NOT EXISTS `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- ��������� ������� `pictures`
--

CREATE TABLE IF NOT EXISTS `pictures` (
  `id` int(11) NOT NULL,
  `id_project` int(11) DEFAULT NULL,
  `picture` blob,
  PRIMARY KEY (`id`),
  KEY `id_project` (`id_project`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- ��������� ������� `projects`
--

CREATE TABLE IF NOT EXISTS `projects` (
  `id` int(11) NOT NULL,
  `name` text,
  `id_category` int(11) DEFAULT NULL,
  `id_author` int(11) DEFAULT NULL,
  `description` text,
  `moneyNeed` int(11) DEFAULT NULL,
  `moneyHas` int(11) DEFAULT NULL,
  `picture` blob,
  `video` text,
  PRIMARY KEY (`id`),
  KEY `id_author` (`id_author`),
  KEY `id_category` (`id_category`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- ���� ������ ������� `projects`
--

INSERT INTO `projects` (`id`, `name`, `id_category`, `id_author`, `description`, `moneyNeed`, `moneyHas`, `picture`, `video`) VALUES
(1, 'project 1', 1, 1, 'bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-', NULL, NULL, NULL, 'https://www.youtube.com/embed/J4L4UQnbjGc'),
(22, 'testproject 2', 1, 1, 'test description', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- ��������� ������� `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL,
  `name` text,
  `password` text,
  `email` text,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- ���� ������ ������� `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `active`) VALUES
(1, 'test', 'c8837b23ff8aaa8a2dde915473ce0991', 'test@test.mail', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
