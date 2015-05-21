-- phpMyAdmin SQL Dump
-- version 4.0.10.2
-- http://www.phpmyadmin.net
--
-- Хост: hbt00.mysql.ukraine.com.ua
-- Время создания: Май 21 2015 г., 11:11
-- Версия сервера: 5.1.72-cll-lve
-- Версия PHP: 5.2.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `hbt00_gojava32`
--

-- --------------------------------------------------------

--
-- Структура таблицы `blogs`
--

CREATE TABLE IF NOT EXISTS `blogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` text,
  `id_project` int(11) NOT NULL,
  `text` text,
  `created` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_project` (`id_project`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `blogs`
--

INSERT INTO `blogs` (`id`, `author`, `id_project`, `text`, `created`) VALUES
(1, '1', 1, 'blablabla_blog', '2015-05-07'),
(2, NULL, 23, 'it is blog about nature', '2015-05-21');

-- --------------------------------------------------------

--
-- Структура таблицы `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=48 ;

--
-- Дамп данных таблицы `categories`
--

INSERT INTO `categories` (`id`, `name`, `description`) VALUES
(1, 'Music', 'desc Music'),
(2, 'Medicine', 'desc Medicine'),
(45, 'Tech', 'test description'),
(46, 'Food', 'food desc'),
(47, 'Art', 'Art description');

-- --------------------------------------------------------

--
-- Структура таблицы `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` text,
  `id_project` int(11) NOT NULL,
  `text` text,
  `created` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_project` (`id_project`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `comments`
--

INSERT INTO `comments` (`id`, `author`, `id_project`, `text`, `created`) VALUES
(1, NULL, 23, 'nature is cool', '2015-05-21'),
(2, NULL, 22, 'test', '2015-05-21');

-- --------------------------------------------------------

--
-- Структура таблицы `persistent_logins`
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
-- Структура таблицы `pictures`
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
-- Структура таблицы `projects`
--

CREATE TABLE IF NOT EXISTS `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `id_category` int(11) NOT NULL,
  `id_author` int(11) NOT NULL,
  `description` text,
  `moneyNeed` int(11) DEFAULT NULL,
  `moneyHas` int(11) DEFAULT NULL,
  `picture` blob,
  `video` text,
  PRIMARY KEY (`id`),
  KEY `id_author` (`id_author`),
  KEY `id_category` (`id_category`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=24 ;

--
-- Дамп данных таблицы `projects`
--

INSERT INTO `projects` (`id`, `name`, `id_category`, `id_author`, `description`, `moneyNeed`, `moneyHas`, `picture`, `video`) VALUES
(1, 'project 1', 1, 1, 'bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-', NULL, NULL, NULL, 'https://www.youtube.com/embed/J4L4UQnbjGc'),
(22, 'testproject 2', 1, 1, 'test description', NULL, NULL, NULL, NULL),
(23, 'Nature', 47, 2, 'Nature descr', NULL, NULL, NULL, '');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `password` text,
  `email` text,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `active`) VALUES
(1, 'test', 'c8837b23ff8aaa8a2dde915473ce0991', 'test@test.mail', 1),
(2, 'avelit', '202cb962ac59075b964b07152d234b70', 'avelit@ukr.net', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
