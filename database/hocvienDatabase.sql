-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: QuanLySinhViendb
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
-- Table structure for table `hoc_vien`
--

DROP TABLE IF EXISTS `hoc_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoc_vien` (
  `ma_hoc_vien` int NOT NULL AUTO_INCREMENT,
  `ho_ten` varchar(255) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `gioi_tinh` bit(1) NOT NULL DEFAULT b'1',
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`ma_hoc_vien`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoc_vien`
--

LOCK TABLES `hoc_vien` WRITE;
/*!40000 ALTER TABLE `hoc_vien` DISABLE KEYS */;
INSERT INTO `hoc_vien` VALUES (1,'Pham Van Khang','2000-06-17',_binary '','0359686525','Tp.HCM',_binary ''),(2,'Jones Khang','2000-06-11',_binary '\0','0988888888','Tp.HCM',_binary ''),(3,'Pham Khang','2000-11-22',_binary '\0','0356656666','Cang long, Tra Vinh',_binary '\0'),(5,'Nguyễn Thị Ngọc Nữ','2000-11-22',_binary '\0','0356656666','Hồ Chí Minh City',_binary ''),(6,'David Nguyen','2000-11-22',_binary '\0','0356656666','New York City, Hoa Ky',_binary ''),(7,'isomoto','2000-11-22',_binary '','123546896266','Tokyo, Janpan',_binary '');
/*!40000 ALTER TABLE `hoc_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa_hoc`
--

DROP TABLE IF EXISTS `khoa_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa_hoc` (
  `ma_khoa_hoc` int NOT NULL AUTO_INCREMENT,
  `ten_khoa_hoc` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL,
  PRIMARY KEY (`ma_khoa_hoc`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa_hoc`
--

LOCK TABLES `khoa_hoc` WRITE;
/*!40000 ALTER TABLE `khoa_hoc` DISABLE KEYS */;
INSERT INTO `khoa_hoc` VALUES (1,'Java','Lập trình Java cơ bản','2020-06-22','2021-06-19',_binary ''),(2,'MySQL','Làm quen với Mysql','2021-03-11','2021-03-30',_binary ''),(3,'Python','Lập trình Python cơ bản lắm luôn','2021-03-10','2021-10-01',_binary '');
/*!40000 ALTER TABLE `khoa_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop_hoc`
--

DROP TABLE IF EXISTS `lop_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lop_hoc` (
  `ma_lop_hoc` int NOT NULL AUTO_INCREMENT,
  `ma_khoa_hoc` int DEFAULT NULL,
  `ma_hoc_vien` int DEFAULT NULL,
  `ngay_dang_ky` date DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL,
  PRIMARY KEY (`ma_lop_hoc`),
  KEY `FK_nsk96k2rdocji4oakgsv51nuq` (`ma_hoc_vien`),
  KEY `FK_pvhxvf4oy1n5bp8tvn8a6tcnu` (`ma_khoa_hoc`),
  CONSTRAINT `FK_nsk96k2rdocji4oakgsv51nuq` FOREIGN KEY (`ma_hoc_vien`) REFERENCES `hoc_vien` (`ma_hoc_vien`),
  CONSTRAINT `FK_pvhxvf4oy1n5bp8tvn8a6tcnu` FOREIGN KEY (`ma_khoa_hoc`) REFERENCES `khoa_hoc` (`ma_khoa_hoc`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop_hoc`
--

LOCK TABLES `lop_hoc` WRITE;
/*!40000 ALTER TABLE `lop_hoc` DISABLE KEYS */;
INSERT INTO `lop_hoc` VALUES (1,1,7,'2020-06-22',_binary ''),(2,2,7,'2021-03-11',_binary ''),(12,NULL,NULL,'2021-03-22',_binary ''),(13,3,3,'2021-03-22',_binary ''),(14,3,3,'2021-03-22',_binary ''),(15,3,3,'2021-03-22',_binary ''),(16,3,3,'2021-03-22',_binary ''),(17,3,3,'2021-03-22',_binary ''),(18,3,3,'2021-03-22',_binary ''),(19,3,3,'2021-03-22',_binary ''),(20,3,3,'2021-03-22',_binary ''),(21,3,3,'2021-03-22',_binary ''),(22,3,3,'2021-03-22',_binary ''),(23,3,3,'2021-03-22',_binary ''),(24,3,3,'2021-03-22',_binary ''),(25,3,3,'2021-03-02',_binary ''),(26,3,3,'2021-03-02',_binary '');
/*!40000 ALTER TABLE `lop_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan`
--

DROP TABLE IF EXISTS `tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan` (
  `ma_tai_khoan` int NOT NULL AUTO_INCREMENT,
  `ten_dang_nhap` varchar(255) DEFAULT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `tinh_trang` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ma_tai_khoan`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
INSERT INTO `tai_khoan` VALUES (2,'admin','admin',_binary '');
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-21 22:46:16
