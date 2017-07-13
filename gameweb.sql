-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: gameweb
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_type` varchar(45) DEFAULT NULL,
  `game_title` varchar(200) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `regular_price` varchar(10) DEFAULT NULL,
  `discounted_price` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`item_id`,`game_title`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (10,'Action','STAR WARS™ Battlefront™ II: Elite Trooper Deluxe Edition','Elite Trooper Deluxe Edition turns your troopers into the ultimate opponents','79.99','59.99'),(11,'Sports','Need for Speed™ Payback Deluxe Edition','one of the world’s bestselling video game franchises returns with a vengeance in the new Need for Speed Payback - Deluxe Edition','79.99','49.99'),(12,'Action','Battlefield™ 1 - Titanfall® 2 Deluxe Bundle','The Battlefield™ 1 - Titanfall® 2 Deluxe bundle puts you right in the middle of the action.','119.99','89.95'),(13,'Sports','FIFA 18','Pre-order now and kick-start your FIFA Ultimate Season\nAre you ready for your biggest season yet?','59.99','49.99'),(14,'Action','Mirror\'s Edge™ Catalyst','Experience the Rise of Faith.\nRun, leap and fight your way to freedom in the city of Glass. Get ready to hit the ground running in this fast-paced, free-running adventure with stunning visuals','39.99','19.99'),(15,'Action-adventure','Batman™: Arkham Origins','Take back the sprawling streets of Gotham!\nThis version only supports single player.','25.99','19.99'),(16,'Action-adventure','The Final Hours of Titanfall™','videogame journalist Geoff Keighley chronicles the inside story of Respawn Entertainment as only he can with a gripping 25,000 word digital book.','5.99','1.99'),(17,'Action-adventure','This War of Mine™ - War Child Charity DLC Rank 1','War Child Charity DLC contains unique street art pieces made by artists from all over the world','5.99','0.99'),(18,'Simulation','SIMCITY: Amusement Park Set','Build thrills.\nCreate your own customized, fun-filled amusement park! Build your park around your city\'s terrain and layout using amusement park paths.','5.99','4.99'),(19,'Role-playing','Dragon Age™: Inquisition - Game of the Year Edition','You are the Inquisitor, tasked with saving the people of Thedas from the brink of chaos and a host of fearsome enemies. The Game of the Year Edition comes with all of the following.','59.99','39.99'),(20,'Sports','FIFA 17 Deluxe Edition','Powered by Frostbite, FIFA 17 transforms the way you play, compete and emotionally connect with the game.','49.99','19.99'),(21,'Strategy','Plants vs. Zombies™ Garden Warfare 2: Deluxe Edition','Ready the Peashooters and prepare for the craziest, funniest shooter in the universe: Plants vs.','39.99','9.99');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `user_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `ordered date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`,`order_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (27,'james','d','aaa@hotmail.com','admin','admin'),(28,'Jee','Ha','jhy1213@hotmail.com','chloe','U2ehd'),(29,'gas','feea','dada@.com','aasd','asd'),(30,'asdasd','asda','adsad@.com','att2211a','asd'),(31,'james','t','oo@gmail.com','test','1234');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-13 18:20:40
