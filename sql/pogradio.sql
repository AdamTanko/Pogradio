CREATE DATABASE IF NOT EXISTS `pogradio`;
USE `pogradio`;

-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: pogradio
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `musor`
--

DROP TABLE IF EXISTS `musor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `leiras` varchar(255) DEFAULT NULL,
  `musorvezetoid` bigint DEFAULT NULL,
  `cim` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `musorvezetoid` (`musorvezetoid`),
  CONSTRAINT `musor_ibfk_1` FOREIGN KEY (`musorvezetoid`) REFERENCES `musorvezeto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musor`
--

LOCK TABLES `musor` WRITE;
/*!40000 ALTER TABLE `musor` DISABLE KEYS */;
/*!40000 ALTER TABLE `musor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musor_ido`
--

DROP TABLE IF EXISTS `musor_ido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musor_ido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `endido` time DEFAULT NULL,
  `musorid` bigint DEFAULT NULL,
  `nap` varchar(255) DEFAULT NULL,
  `startido` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `musorid` (`musorid`),
  CONSTRAINT `musor_ido_ibfk_1` FOREIGN KEY (`musorid`) REFERENCES `musor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musor_ido`
--

LOCK TABLES `musor_ido` WRITE;
/*!40000 ALTER TABLE `musor_ido` DISABLE KEYS */;
/*!40000 ALTER TABLE `musor_ido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musorvezeto`
--

DROP TABLE IF EXISTS `musorvezeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musorvezeto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `kep` varchar(255) DEFAULT NULL,
  `leiras` varchar(255) DEFAULT NULL,
  `nev` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musorvezeto`
--

LOCK TABLES `musorvezeto` WRITE;
/*!40000 ALTER TABLE `musorvezeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `musorvezeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pogradio'
--

--
-- Dumping routines for database 'pogradio'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-28 19:04:32
