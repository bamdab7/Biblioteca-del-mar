-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdbibliotecadelmar1
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.21-MariaDB

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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `idAutor` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(155) NOT NULL,
  `apellidos` varchar(155) NOT NULL,
  `status` enum('ACTIVO','NO ACTIVO') NOT NULL,
  `imagen` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Herman','Melvile','ACTIVO','Herman.jpg'),(2,'Julio','Verne','NO ACTIVO','Julio.jpg'),(3,'Yukio','Mishima','NO ACTIVO','Yukio.jpg'),(4,'Yann','Martel','ACTIVO','Yannl.jpg'),(5,'Carmen','Rodriguez','ACTIVO','Carmen.jpg'),(6,'Catherine','D.Hughes','ACTIVO','Catherine.png'),(7,'Laura','F.Marsh','ACTIVO','Laura.jpg'),(8,'Melissa','Stewart','ACTIVO','Melissa.jpg'),(9,'Sy','Montgomery','ACTIVO','img-null.jpg'),(10,'Nicholas','Leer','ACTIVO','img-null.jpg'),(11,'Claude','Delafosse','ACTIVO','Claude.jpeg'),(12,'Francesco','Pittau','ACTIVO','img-null.jpg'),(13,'Tom','Percival','ACTIVO','Tom.jpg');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editorial` (
  `idEditorial` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(155) NOT NULL,
  `fundacion` int(4) NOT NULL,
  `direcionSede` varchar(250) NOT NULL,
  `url` varchar(250) NOT NULL,
  PRIMARY KEY (`idEditorial`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editorial`
--

LOCK TABLES `editorial` WRITE;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
INSERT INTO `editorial` VALUES (1,'Richard Bentley',1800,'Inglaterra',''),(2,'Hetzel',1800,'Francia',''),(3,'Shinchosha',1986,'Tokio,Japan','https://www.shinchosha.co.jp'),(4,'Random House Canada',1944,'Canada','https://www.penguinrandomhouse.ca'),(5,'Susaeta',1953,'Spain','https://www.editorialsusaeta.com/es/'),(6,'Geographic',1888,'Washinton D.C. , USA','https://www.nationalgeographic.com.es'),(7,'HarperAudio',1990,'California, USA','https://www.harpercollins.com/pages/harperaudio'),(8,'Orca Book Publishers',1984,'Canada','https://www.orcabook.com'),(9,'Ediciones SM',1938,'Spain','https://www.grupo-sm.com/es/'),(10,'Andana Editorial',2009,'Spain','https://www.andana.net');
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `idLibro` int(3) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(155) NOT NULL,
  `tipo` enum('LIBRO','REVISTA','ENCICLOPEDIA','CD') NOT NULL,
  `saga` varchar(155) NOT NULL,
  `idEditorial` int(3) NOT NULL,
  `paginas` int(3) DEFAULT NULL,
  `descripcion` text NOT NULL,
  `imagen` varchar(155) NOT NULL,
  `idAutor` int(3) NOT NULL,
  PRIMARY KEY (`idLibro`),
  KEY `librotoeditorial_idx` (`idEditorial`),
  KEY `librotoautor_idx` (`idAutor`),
  CONSTRAINT `librotoautor` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `librotoeditorial` FOREIGN KEY (`idEditorial`) REFERENCES `editorial` (`idEditorial`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'Moby-Dick','LIBRO','Moby-Dick',1,826,'Narra la travesia del barco ballenero Pequod, comandado por el capitán Ahab, junto a Ismael y el arponero Queequeg en la obsesiva y autodestructiva persecucion de un cachalote blanco.','mobydick.jpg',1),(2,'Veinte mil leguas de viaje submarino','LIBRO','Veinte mil leguas de viaje submarino',2,576,'Narra en primera persona la historia de un biólogo francés que es prisionero por el Capitán Nemo y es conducido por los océanos a borde del submarino Nautilus.','julioverne1.jpg',2),(3,'El rumor del oleaje','LIBRO','El rumor del oleaje',3,240,'Su trama aborda el paso de la adolescencia a la juventuz amorosa de una pareja en un entorno primitivo. Está ambientada en una remota isla habitada por pescadores.','rumor-oleaje.jpg',3),(4,'La vida de Pi','LIBRO','La vida de Pi',4,334,'Narra la vida de un joven que sobrevive 227  días en un bote junto con un tigre de Bengala tras el naufragio de su barco en el Pacífico.','vidadepi.jpg',4),(5,'Animales del mar','ENCICLOPEDIA','Biblioteca esencial',5,174,' Todas las informaciones y curiosidades sobre estos maravillosos seres las encontrarás en este volumen, lleno de ilustraciones a todo color. También puedes disfrutar y aprender con el \\\"Especial Tiburones\\\", que te espera al final del libro.','animalesmar.jpg',5),(6,'Mi primer gran libro del oceano','ENCICLOPEDIA','National Geographic KIDS',6,128,'Un adorable álbum ilustrado que incluye los animales más interesantes del mar, como los delfines, los tiburones, las nutrias marinas y los pingüinos.','librooceano.jpg',6),(7,'Grandes Migraciones: Las ballenas','ENCICLOPEDIA','National Geographic KIDS',6,48,'En un mundo donde las temperaturas globales están cambiando de forma extrema tanto en la tierra y en el mar, las migraciones anuales de animales de todo tipo son historias de fuerza y voluntad increíble. Nuevas tecnologías nos permite seguir a estos animales y comprender mejor nuestro mundo que está en constante movimiento. Este texto relata el viaje de las ballenas por las aguas azules del profundo océano.','migracionesballenas.jpg',7),(8,'Los delfines','LIBRO','National Geographic KIDS',6,32,'Aprende todo acerca de los delfines en este emocionante libro en español. Con sus imágenes encantadoras, los niños aprenderán todo sobre estos asombrosos animales marinos. Este libro de Nivel 2 es apropiado para los primeros pasos de lectura independiente o para una experiencia de lectura en voz alta, ¡perfecto para motivar a futuros científicos y exploradores!','delfines.jpg',8),(9,'Los pulpos: explorando la mente de los moluscos','CD','Scientist in the Field',7,NULL,'En este audio libro aprenderás todo lo relacionado con estos curiosos moluscos que desafian las leyes de la gravedad. Compuesto de cientos de ventosas, este animal tiene poderes de superhéroe.','pulpos.jpg',9),(10,'The Seal Garden','CD','My Great Bear Rainforest',8,NULL,'Cuando rugen las tormentas y las orcas están al acecho, son los jardines de focas del Mar del Gran Oso los que brindan seguridad y refugio.','thesealgarden.jpg',10),(11,'Los animales marinos','ENCICLOPEDIA','Mundo maravilloso',9,34,'Un interesante libro para conocer a los animales que viven en el mar. ¿Cómo viven los animales multicolores de los fondos marinos? Tiene una linterna mágica para descubrir los mil detalles escondidos en cada página.','animalesmarinos.jpg',11),(12,'Animales soprendentes','ENCICLOPEDIA','Mundo maravilloso',9,28,'Lee este libro y descubrirás muchos animales increíbles, por su aspecto o comportamiento. Incluye una pequeña linterna de papel para poder iluminar las imágenes.','animalessoprendentes.jpg',11),(13,'Oceanos','ENCICLOPEDIA','Oceanos',9,22,'Sumérgete en Océanos y nada entre peces, crustáceos y moluscos.','oceanos.jpg',12),(14,'Mar lo vio','LIBRO','Mar lo vio',10,32,'Una mirada hermosa que nos demuestra que nada se pierde si lo guardas en tu corazón ... Cuando Sofía pierde a su querido peluche después de un día en la playa, ella está desconsolada. Pero el mar lo vio todo, y quizás, solo tal vez, pueda volver a unir a Sofía y su peluche. No importa cuánto tiempo pueda tardar ...','elmarlovio.jpg',13);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librousuario`
--

DROP TABLE IF EXISTS `librousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librousuario` (
  `idLibro` int(3) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idLibro`,`idUsuario`),
  KEY `libroToUsuario_idx` (`idUsuario`),
  CONSTRAINT `libroToUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usuarioToLibro` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librousuario`
--

LOCK TABLES `librousuario` WRITE;
/*!40000 ALTER TABLE `librousuario` DISABLE KEYS */;
INSERT INTO `librousuario` VALUES (1,1),(5,1),(7,1);
/*!40000 ALTER TABLE `librousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perfil` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
INSERT INTO `perfiles` VALUES (1,'ADMINISTRADOR'),(2,'USUARIO');
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioperfil`
--

DROP TABLE IF EXISTS `usuarioperfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarioperfil` (
  `idUsuario` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`,`idPerfil`),
  KEY `usuarioToPerfil_idx` (`idPerfil`),
  CONSTRAINT `perfilToUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usuarioToPerfil` FOREIGN KEY (`idPerfil`) REFERENCES `perfiles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioperfil`
--

LOCK TABLES `usuarioperfil` WRITE;
/*!40000 ALTER TABLE `usuarioperfil` DISABLE KEYS */;
INSERT INTO `usuarioperfil` VALUES (1,2),(2,1),(4,2);
/*!40000 ALTER TABLE `usuarioperfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Martin Deibe','markyuu02@gmail.com','mdeibe','$2a$10$C9o2BXpPWCPHU/TaidYHFelU9O90I.G83KdFEJKJlpDS6/NWolOL.',1),(2,'Administrador','admin@gmail.com','admin','$2a$10$pgneDUUIXDc3hEAXooDyCeifzZmhKVuXl3t2Ey40zT1ebNq6roXo2',1),(4,'Pedro','pedro@gmail.com','pedro','$2a$10$RQbr6Spz5fLmaeYi3p1y9eCi.D9pxN7M65wt.XqDL7oxB9cmb.slC',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-06 18:58:37
