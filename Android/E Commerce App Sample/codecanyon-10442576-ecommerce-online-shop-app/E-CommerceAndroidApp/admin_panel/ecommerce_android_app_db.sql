-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2019 at 04:59 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommerce_android_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `id` int(11) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` text NOT NULL,
  `email` varchar(100) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `user_role` enum('100','101','102') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id`, `username`, `password`, `email`, `full_name`, `user_role`) VALUES
(1, 'admin', 'd82494f05d6917ba02f7aaa29689ccb444bb73f20380876cb05d1f37537b7892', 'yourmail@gmail.com', 'Administrator', '100');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_category`
--

CREATE TABLE `tbl_category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  `category_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_category`
--

INSERT INTO `tbl_category` (`category_id`, `category_name`, `category_image`) VALUES
(1, 'Office & Industry', '1577-2019-02-25.png'),
(2, 'Health & Sports', '8279-2019-02-25.png'),
(3, 'Home & Furniture', '7632-2019-02-25.png'),
(4, 'Baby Gear', '6305-2019-02-25.png'),
(5, 'Fashions', '4586-2019-02-25.png'),
(8, 'Electronics & Gadgets', '9836-2019-02-25.png');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_config`
--

CREATE TABLE `tbl_config` (
  `id` int(11) NOT NULL,
  `currency_symbol` varchar(10) NOT NULL,
  `currency_id` int(3) NOT NULL,
  `tax` varchar(45) NOT NULL DEFAULT '0',
  `app_fcm_key` varchar(1000) NOT NULL DEFAULT '0',
  `package_name` varchar(500) NOT NULL DEFAULT 'com.app.ecommerce',
  `onesignal_app_id` varchar(500) NOT NULL DEFAULT '0',
  `onesignal_rest_api_key` varchar(500) NOT NULL DEFAULT '0',
  `providers` varchar(45) NOT NULL DEFAULT 'onesignal',
  `protocol_type` varchar(10) NOT NULL DEFAULT 'http://'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_config`
--

INSERT INTO `tbl_config` (`id`, `currency_symbol`, `currency_id`, `tax`, `app_fcm_key`, `package_name`, `onesignal_app_id`, `onesignal_rest_api_key`, `providers`, `protocol_type`) VALUES
(1, '$', 157, '0', '0', 'com.app.ecommerce', '0', '0', 'onesignal', 'http://');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_currency`
--

CREATE TABLE `tbl_currency` (
  `currency_id` bigint(20) NOT NULL,
  `currency_code` varchar(3) CHARACTER SET utf8mb4 NOT NULL,
  `currency_name` varchar(100) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_currency`
--

INSERT INTO `tbl_currency` (`currency_id`, `currency_code`, `currency_name`) VALUES
(1, 'AFA', 'Afghanistan afghani'),
(2, 'ALL', 'Albanian lek'),
(3, 'DZD', 'Algerian dinar'),
(4, 'AOR', 'Angolan kwanza reajustado'),
(5, 'ARS', 'Argentine peso'),
(6, 'AMD', 'Armenian dram'),
(7, 'AWG', 'Aruban guilder'),
(8, 'AUD', 'Australian dollar'),
(9, 'AZN', 'Azerbaijanian new manat'),
(10, 'BSD', 'Bahamian dollar'),
(11, 'BHD', 'Bahraini dinar'),
(12, 'BDT', 'Bangladeshi taka'),
(13, 'BBD', 'Barbados dollar'),
(14, 'BYN', 'Belarusian ruble'),
(15, 'BZD', 'Belize dollar'),
(16, 'BMD', 'Bermudian dollar'),
(17, 'BTN', 'Bhutan ngultrum'),
(18, 'BOB', 'Bolivian boliviano'),
(19, 'BWP', 'Botswana pula'),
(20, 'BRL', 'Brazilian real'),
(21, 'GBP', 'British pound'),
(22, 'BND', 'Brunei dollar'),
(23, 'BGN', 'Bulgarian lev'),
(24, 'BIF', 'Burundi franc'),
(25, 'KHR', 'Cambodian riel'),
(26, 'CAD', 'Canadian dollar'),
(27, 'CVE', 'Cape Verde escudo'),
(28, 'KYD', 'Cayman Islands dollar'),
(29, 'XOF', 'CFA franc BCEAO'),
(30, 'XAF', 'CFA franc BEAC'),
(31, 'XPF', 'CFP franc'),
(32, 'CLP', 'Chilean peso'),
(33, 'CNY', 'Chinese yuan renminbi'),
(34, 'COP', 'Colombian peso'),
(35, 'KMF', 'Comoros franc'),
(36, 'CDF', 'Congolese franc'),
(37, 'CRC', 'Costa Rican colon'),
(38, 'HRK', 'Croatian kuna'),
(39, 'CUP', 'Cuban peso'),
(40, 'CZK', 'Czech koruna'),
(41, 'DKK', 'Danish krone'),
(42, 'DJF', 'Djibouti franc'),
(43, 'DOP', 'Dominican peso'),
(44, 'XCD', 'East Caribbean dollar'),
(45, 'EGP', 'Egyptian pound'),
(46, 'SVC', 'El Salvador colon'),
(47, 'ERN', 'Eritrean nakfa'),
(48, 'EEK', 'Estonian kroon'),
(49, 'ETB', 'Ethiopian birr'),
(50, 'EUR', 'EU euro'),
(51, 'FKP', 'Falkland Islands pound'),
(52, 'FJD', 'Fiji dollar'),
(53, 'GMD', 'Gambian dalasi'),
(54, 'GEL', 'Georgian lari'),
(55, 'GHS', 'Ghanaian new cedi'),
(56, 'GIP', 'Gibraltar pound'),
(57, 'XAU', 'Gold (ounce)'),
(58, 'XFO', 'Gold franc'),
(59, 'GTQ', 'Guatemalan quetzal'),
(60, 'GNF', 'Guinean franc'),
(61, 'GYD', 'Guyana dollar'),
(62, 'HTG', 'Haitian gourde'),
(63, 'HNL', 'Honduran lempira'),
(64, 'HKD', 'Hong Kong SAR dollar'),
(65, 'HUF', 'Hungarian forint'),
(66, 'ISK', 'Icelandic krona'),
(67, 'XDR', 'IMF special drawing right'),
(68, 'INR', 'Indian rupee'),
(69, 'IDR', 'Indonesian rupiah'),
(70, 'IRR', 'Iranian rial'),
(71, 'IQD', 'Iraqi dinar'),
(72, 'ILS', 'Israeli new shekel'),
(73, 'JMD', 'Jamaican dollar'),
(74, 'JPY', 'Japanese yen'),
(75, 'JOD', 'Jordanian dinar'),
(76, 'KZT', 'Kazakh tenge'),
(77, 'KES', 'Kenyan shilling'),
(78, 'KWD', 'Kuwaiti dinar'),
(79, 'KGS', 'Kyrgyz som'),
(80, 'LAK', 'Lao kip'),
(81, 'LVL', 'Latvian lats'),
(82, 'LBP', 'Lebanese pound'),
(83, 'LSL', 'Lesotho loti'),
(84, 'LRD', 'Liberian dollar'),
(85, 'LYD', 'Libyan dinar'),
(86, 'LTL', 'Lithuanian litas'),
(87, 'MOP', 'Macao SAR pataca'),
(88, 'MKD', 'Macedonian denar'),
(89, 'MGA', 'Malagasy ariary'),
(90, 'MWK', 'Malawi kwacha'),
(91, 'MYR', 'Malaysian ringgit'),
(92, 'MVR', 'Maldivian rufiyaa'),
(93, 'MRO', 'Mauritanian ouguiya'),
(94, 'MUR', 'Mauritius rupee'),
(95, 'MXN', 'Mexican peso'),
(96, 'MDL', 'Moldovan leu'),
(97, 'MNT', 'Mongolian tugrik'),
(98, 'MAD', 'Moroccan dirham'),
(99, 'MZN', 'Mozambique new metical'),
(100, 'MMK', 'Myanmar kyat'),
(101, 'NAD', 'Namibian dollar'),
(102, 'NPR', 'Nepalese rupee'),
(103, 'ANG', 'Netherlands Antillian guilder'),
(104, 'NZD', 'New Zealand dollar'),
(105, 'NIO', 'Nicaraguan cordoba oro'),
(106, 'NGN', 'Nigerian naira'),
(107, 'KPW', 'North Korean won'),
(108, 'NOK', 'Norwegian krone'),
(109, 'OMR', 'Omani rial'),
(110, 'PKR', 'Pakistani rupee'),
(111, 'XPD', 'Palladium (ounce)'),
(112, 'PAB', 'Panamanian balboa'),
(113, 'PGK', 'Papua New Guinea kina'),
(114, 'PYG', 'Paraguayan guarani'),
(115, 'PEN', 'Peruvian nuevo sol'),
(116, 'PHP', 'Philippine peso'),
(117, 'XPT', 'Platinum (ounce)'),
(118, 'PLN', 'Polish zloty'),
(119, 'QAR', 'Qatari rial'),
(120, 'RON', 'Romanian new leu'),
(121, 'RUB', 'Russian ruble'),
(122, 'RWF', 'Rwandan franc'),
(123, 'SHP', 'Saint Helena pound'),
(124, 'WST', 'Samoan tala'),
(125, 'STD', 'Sao Tome and Principe dobra'),
(126, 'SAR', 'Saudi riyal'),
(127, 'RSD', 'Serbian dinar'),
(128, 'SCR', 'Seychelles rupee'),
(129, 'SLL', 'Sierra Leone leone'),
(130, 'XAG', 'Silver (ounce)'),
(131, 'SGD', 'Singapore dollar'),
(132, 'SBD', 'Solomon Islands dollar'),
(133, 'SOS', 'Somali shilling'),
(134, 'ZAR', 'South African rand'),
(135, 'KRW', 'South Korean won'),
(136, 'LKR', 'Sri Lanka rupee'),
(137, 'SDG', 'Sudanese pound'),
(138, 'SRD', 'Suriname dollar'),
(139, 'SZL', 'Swaziland lilangeni'),
(140, 'SEK', 'Swedish krona'),
(141, 'CHF', 'Swiss franc'),
(142, 'SYP', 'Syrian pound'),
(143, 'TWD', 'Taiwan New dollar'),
(144, 'TJS', 'Tajik somoni'),
(145, 'TZS', 'Tanzanian shilling'),
(146, 'THB', 'Thai baht'),
(147, 'TOP', 'Tongan paanga'),
(148, 'TTD', 'Trinidad and Tobago dollar'),
(149, 'TND', 'Tunisian dinar'),
(150, 'TRY', 'Turkish lira'),
(151, 'TMT', 'Turkmen new manat'),
(152, 'AED', 'UAE dirham'),
(153, 'UGX', 'Uganda new shilling'),
(154, 'XFU', 'UIC franc'),
(155, 'UAH', 'Ukrainian hryvnia'),
(156, 'UYU', 'Uruguayan peso uruguayo'),
(157, 'USD', 'US dollar'),
(158, 'UZS', 'Uzbekistani sum'),
(159, 'VUV', 'Vanuatu vatu'),
(160, 'VEF', 'Venezuelan bolivar fuerte'),
(161, 'VND', 'Vietnamese dong'),
(162, 'YER', 'Yemeni rial'),
(163, 'ZMK', 'Zambian kwacha'),
(164, 'ZWL', 'Zimbabwe dollar');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fcm_template`
--

CREATE TABLE `tbl_fcm_template` (
  `id` int(11) NOT NULL,
  `message` text NOT NULL,
  `image` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL DEFAULT 'Notification',
  `link` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_fcm_template`
--

INSERT INTO `tbl_fcm_template` (`id`, `message`, `image`, `title`, `link`) VALUES
(28, 'Hello World, This is E-Commerce Android App, you can purchase it on Codecanyon officially.', '2293-2019-02-09.png', 'E-Commerce Android App', ''),
(29, 'E-Commerce Android App 3.0 has been released', '5873-2019-02-09.jpg', 'E-Commerce Android App', 'https://codecanyon.net/item/ecommerce-online-shop-app/10442576');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fcm_token`
--

CREATE TABLE `tbl_fcm_token` (
  `id` int(11) NOT NULL,
  `token` text NOT NULL,
  `user_unique_id` varchar(255) NOT NULL,
  `app_version` varchar(255) NOT NULL,
  `os_version` varchar(255) NOT NULL,
  `device_model` varchar(255) NOT NULL,
  `device_manufacturer` varchar(255) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_fcm_token`
--

INSERT INTO `tbl_fcm_token` (`id`, `token`, `user_unique_id`, `app_version`, `os_version`, `device_model`, `device_manufacturer`, `date`) VALUES
(1, 'e7VLLnt7uQU:APA91bHjFHxF0aTvKIGm1rXU2RCfWOarsEkcEWBfUI9_8JnHmalgrAP0ECZutOaFlfVJBGdGuZ5j9y8p9F-21lcKSAOw3pf-sUtiBLQRYExW6lJxTNIyMILU233Pa-1qkTAy3Mt-3bUp', '87b66d0f1dc0b0ce', '6 (3.3.0)', 'Nougat 7.1.1', 'Android SDK built for x86', 'Google', '2019-01-31 09:54:28');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_help`
--

CREATE TABLE `tbl_help` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_help`
--

INSERT INTO `tbl_help` (`id`, `title`, `content`) VALUES
(1, 'Contact us', '<p>Do you still feel confused by the system that you need? Do not worry, please contact us now! Gladly we will help resolve your needs.</p>\r\n\r\n<p>121 King Street, Melbourne<br />\r\nVictoria 3000 Australia</p>\r\n\r\n<p>Email : help.solodroid@gmail.com</p>\r\n'),
(2, 'Profile', '<p>E-Commerce / Online Shop App is a mobile commerce system which run under Android platform that used for promotion and selling your product with single application. With powerful Admin Panel can manage the order, create category and product menu, also can configurations such as currency, tax, user, ect from admin panel on the web. you can add, update, update or change that product menu, category, tax, currency and change admin password with generate password, etc. This application created by Android for client side and then PHP MySQL for Admin side. Run under Android platform which is the most popular operating system in the world. Using this application you can save your money and time in creating application for ecommerce or online shop application.</p>\r\n'),
(3, 'Shipping', '<p>For shipping, we use a number of shipping services (couriers) JNE, TIKI, and Pos Indonesia.</p>\r\n\r\n<p>Product prices do not include shipping costs, shipping costs depend on the weight and volume of goods, destination address and courier used.</p>'),
(4, 'Payment', '<p>Solomerce will send information on the number of total expenditures and postage to your email address, for details please check your email!</p>\r\n\r\n        <p>Payment can be made by transfer to :</p>\r\n\r\n        <p><b>PayPal</b></p>\r\n        <ul>\r\n            <li>E-Mail : dimas.yanpradipta@gmail.com</li>\r\n        </ul>\r\n\r\n        <p><b>BANK BCA</b></p>\r\n        <ul>\r\n            <li>Account Number : 12345678</li>\r\n            <li>Account Name : Solodroid Developer</li>\r\n        </ul>\r\n\r\n        <p><b>BANK MANDIRI</b></p>\r\n        <ul>\r\n            <li>Account Number : 12345678</li>\r\n            <li>Account Name : Solodroid Developer</li>\r\n        </ul>\r\n\r\n        <p><b>BANK BRI</b></p>\r\n        <ul>\r\n            <li>Account Number : 12345678</li>\r\n            <li>Account Name : Solodroid Developer</li>\r\n        </ul>\r\n\r\n        <p><b>BANK BNI</b></p>\r\n        <ul>\r\n            <li>Account Number : 12345678</li>\r\n            <li>Account Name : Solodroid Developer</li>\r\n        </ul>\r\n\r\n        <p><b>Please note :</b></p>\r\n        <ul>\r\n            <li>Transfer between accounts BCA, Mandiri, BNI and BRI, is a way of sending money the fastest we have\r\n                received and to be confirmed soon</li>\r\n            <li>Cash deposits, usually can be received on the same day</li>\r\n            <li>Transfers between banks, may be received on the same day, it could be 1-2 days after the transfer\r\n                is made, especially if done on weekends (Friday)</li>\r\n        </ul>\r\n\r\n        <p>We will give you confirmation once the money goes into the account.</p>\r\n\r\n        <p><b>Pay in Place (CoD - Cash on Delivery) :</b></p>\r\n        <ul>\r\n            <li>Currently, a special Jakarta, Depok, Bekasi and Bogor City City could pay on the spot - CoD.</li>\r\n            <li>Long time sent according to a schedule, or meet according to the agreement.</li>\r\n            <li>Payment is given to the Courier, a number of Memorandum.</li>\r\n            <li>Minimal expenditure of $10 USD</li>\r\n        </ul>'),
(5, 'How to order', '<p><strong>How To Shop At Solomerce Apps :</strong></p>\r\n\r\n<ul>\r\n	<li>Shopping through the shopping cart, select the items that will be purchased in accordance with your wishes.</li>\r\n	<li>Continue by filling the form e-mail with details of the total price.</li>\r\n	<li>after you place an order, we will immediately check the conditions, the availability (and prices if there are changes in the price), as well as the shipping of the product that you yourselves message, therefore DO NOT send / transfer money before there is confirmation from us via phone / SMS or email.</li>\r\n	<li>Upon confirmation from us, please send / transfer payment to one of the following bank account</li>\r\n	<li>We only accept cash payments by wire transfer to a bank account.</li>\r\n</ul>\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order`
--

CREATE TABLE `tbl_order` (
  `id` int(11) NOT NULL,
  `code` varchar(45) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(500) NOT NULL,
  `shipping` varchar(255) NOT NULL,
  `date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `order_list` text NOT NULL,
  `order_total` varchar(255) NOT NULL,
  `comment` text NOT NULL,
  `status` varchar(1) NOT NULL DEFAULT '0',
  `player_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_product`
--

CREATE TABLE `tbl_product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `product_price` double NOT NULL,
  `product_status` varchar(45) NOT NULL,
  `product_image` text NOT NULL,
  `product_description` text NOT NULL,
  `product_quantity` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_product`
--

INSERT INTO `tbl_product` (`product_id`, `product_name`, `product_price`, `product_status`, `product_image`, `product_description`, `product_quantity`, `category_id`) VALUES
(12, 'Pena Pilot Frixion Cliker 0.5mm - Blue', 20, 'Available', '1551076043_pen.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker includin versions of Lorem Ipsum and more recently with desktop publishing software lik.</p>\r\n\r\n<p><br />\r\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p><br />\r\nThere are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text</p>\r\n', 30, 1),
(21, 'ID Card holder / Name Tag Holder / Tempat ID Card - UHOO 6616', 5, 'Available', '1551076061_id card holder.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker includin versions of Lorem Ipsum and more recently with desktop publishing software lik.</p>\r\n\r\n<p><br />\r\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p><br />\r\nThere are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text</p>\r\n', 100, 1),
(22, 'Scientific Calculator - Doraemon 350 MS', 12, 'Available', '1551076622_calculator.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker includin versions of Lorem Ipsum and more recently with desktop publishing software lik.</p>\r\n\r\n<p><br />\r\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p><br />\r\nThere are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text</p>\r\n', 25, 1),
(23, 'Money Counter Kozure MC-101', 150, 'Available', '1551077054_mesin.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker includin versions of Lorem Ipsum and more recently with desktop publishing software lik.</p>\r\n\r\n<p><br />\r\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p><br />\r\nThere are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text</p>\r\n', 10, 1),
(29, 'Winsor & Newton Designers Gouache - Introductory Set', 45, 'Available', '1551077342_winsor.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker includin versions of Lorem Ipsum and more recently with desktop publishing software lik.</p>\r\n\r\n<p><br />\r\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p><br />\r\nThere are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text</p>\r\n', 10, 1),
(30, 'Ear Thermometer infrared', 14, 'Available', '1551080137_termometer.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker includin versions of Lorem Ipsum and more recently with desktop publishing software lik.</p>\r\n\r\n<p><br />\r\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p><br />\r\nThere are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text</p>\r\n', 25, 2),
(31, 'Dolphin Infrared Massager', 8, 'Available', '1551080401_dolpinmassage.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text</p>\r\n', 36, 2),
(32, 'Digital Tensimeter HL-168', 24, 'Available', '1551080657_tensi.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text</p>\r\n', 24, 2),
(33, 'Nike Magista Obra II Club TF', 42, 'Available', '1551080928_nike.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 8, 2),
(34, 'Electric Treadmill TL 650', 480, 'Available', '1551081242_treadmilk.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 5, 2),
(35, 'Multifunction Stand Hanger', 12, 'Available', '1551081610_hanger.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 20, 3),
(36, 'Robot Vacuum Cleaner Wellcomm Home 2.0', 250, 'Available', '1551081793_vakumcleaner.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 6, 3),
(37, 'Bed Mosquito Net KL200 | 200 x 200 cm', 19, 'Available', '1551082117_kelambu.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 28, 3),
(38, 'Copper Light 3 Battery Warm White - Fairy Light Battery ', 9, 'Available', '1551082411_copper.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 10, 3),
(39, 'Bathroom Toilet Wall Shelves A289', 8, 'Available', '1551082531_rak.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 30, 3),
(40, 'Animal Jumpsuit for Newborn Baby', 10, 'Available', '1551085496_jaket.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 20, 4),
(41, 'GEA Baby RayQueen Plus JHS-400 UV Sterilizer - Metal White', 220, 'Available', '1551086491_geababy.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 10, 4),
(42, 'Portable Bottle Heater', 8, 'Available', '1551086691_heater.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 24, 4),
(43, 'Bib Slabber Waterproof', 8, 'Available', '1551086797_bib.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 18, 4),
(44, 'Hybrid Stroller Cabi Sport Rosse Gold ', 380, 'Available', '1551086987_stroler.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 5, 4),
(45, 'Mini Panda Backpack - Pink', 29, 'Available', '1551087479_tas.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 17, 5),
(46, 'SKMEI Children Sport Rubber LED Watch DG1100 - Black', 75, 'Available', '1551089936_jam.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 8, 5),
(47, 'Short Sleeve Men\'s Batik Shirt OB 445', 25, 'Available', '1551090375_batik.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 28, 5),
(48, 'Gold Titanium Diamond Women\'s Bracelet', 199, 'Available', '1551090506_gelang.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 10, 5),
(49, 'Dolce and Gabbana Heels', 100, 'Available', '1551091324_sepatu.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 6, 5),
(50, 'LED TV 43 Inch Smart TV TCL 43E3 UHD 4K Dolby Sound', 375, 'Available', '1551091590_tv.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 12, 8),
(51, 'Mini Digital Speaker TD-V26 USB FM Radio SD TF Card MP3 - Red', 19, 'Available', '1551091787_spiker.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 9, 8),
(52, 'Apple watch series 3 GPS 42mm Black', 400, 'Available', '1551092902_applewatch2.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 5, 8),
(53, 'U17 USB Portable M3 HUmidifier Air Purifier LED Night Light 200ML', 20, 'Available', '1551108884_purifier.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 10, 8),
(54, 'Samsung Galaxy S10 - Black', 899, 'Available', '1551108906_s10.jpg', '<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&rsquo;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>\r\n\r\n<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &lsquo;Content here, content here&rsquo;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &lsquo;lorem ipsum&rsquo; will uncover many web sites still in their infancy.</p>\r\n\r\n<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don&rsquo;t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn&rsquo;t anything embarrassing hidden in the middle of text.</p>\r\n', 5, 8);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_purchase_code`
--

CREATE TABLE `tbl_purchase_code` (
  `id` int(11) NOT NULL,
  `item_purchase_code` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_setting`
--

CREATE TABLE `tbl_setting` (
  `Variable` varchar(20) NOT NULL,
  `Value` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_setting`
--

INSERT INTO `tbl_setting` (`Variable`, `Value`) VALUES
('Tax', '10'),
('Currency', 'USD');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_shipping`
--

CREATE TABLE `tbl_shipping` (
  `shipping_id` int(11) NOT NULL,
  `shipping_name` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_shipping`
--

INSERT INTO `tbl_shipping` (`shipping_id`, `shipping_name`) VALUES
(1, 'Free Shipping'),
(2, 'Cash On Delivery');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_category`
--
ALTER TABLE `tbl_category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `tbl_config`
--
ALTER TABLE `tbl_config`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_currency`
--
ALTER TABLE `tbl_currency`
  ADD PRIMARY KEY (`currency_id`);

--
-- Indexes for table `tbl_fcm_template`
--
ALTER TABLE `tbl_fcm_template`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_fcm_token`
--
ALTER TABLE `tbl_fcm_token`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_help`
--
ALTER TABLE `tbl_help`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_product`
--
ALTER TABLE `tbl_product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `tbl_purchase_code`
--
ALTER TABLE `tbl_purchase_code`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_shipping`
--
ALTER TABLE `tbl_shipping`
  ADD PRIMARY KEY (`shipping_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_category`
--
ALTER TABLE `tbl_category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_config`
--
ALTER TABLE `tbl_config`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_currency`
--
ALTER TABLE `tbl_currency`
  MODIFY `currency_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=165;

--
-- AUTO_INCREMENT for table `tbl_fcm_template`
--
ALTER TABLE `tbl_fcm_template`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `tbl_fcm_token`
--
ALTER TABLE `tbl_fcm_token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_help`
--
ALTER TABLE `tbl_help`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_order`
--
ALTER TABLE `tbl_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_product`
--
ALTER TABLE `tbl_product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `tbl_purchase_code`
--
ALTER TABLE `tbl_purchase_code`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_shipping`
--
ALTER TABLE `tbl_shipping`
  MODIFY `shipping_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
