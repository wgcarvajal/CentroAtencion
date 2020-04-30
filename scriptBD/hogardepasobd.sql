-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 30-04-2020 a las 02:44:38
-- Versión del servidor: 5.7.28
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hogardepasobd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animal`
--

CREATE TABLE `animal` (
  `anId` bigint(20) NOT NULL,
  `anNombre` varchar(50) NOT NULL,
  `anEspNombre` varchar(50) NOT NULL,
  `anDescripcion` text,
  `faId` int(11) NOT NULL,
  `grupotaxonomicoId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `animal`
--

INSERT INTO `animal` (`anId`, `anNombre`, `anEspNombre`, `anDescripcion`, `faId`, `grupotaxonomicoId`) VALUES
(1, 'Mono aullador', 'Alouatta seniculus', NULL, 6, 4),
(2, 'Loro frente azul', 'Amazona amazonica', NULL, 4, 3),
(3, 'Loro frente amarillo', 'Amazona ochrocephala', NULL, 4, 3),
(4, 'Guacamayo azul y amarillo', 'Ara ararauna', NULL, 4, 3),
(5, 'Guacamaya bandera', 'Ara macao', NULL, 4, 3),
(6, 'Guacamaya cariseca', 'Ara severus', NULL, 4, 3),
(7, 'Perico cara sucia', 'Eupsittula pertinax', NULL, 4, 3),
(8, 'Perico frentirojo', 'Psittacara wagleri', NULL, 4, 3),
(9, 'Búho orejudo negro', 'Asio stygius', NULL, 37, 3),
(10, 'Erizo africano', 'Atelerix albiventris', NULL, 33, 4),
(11, 'Tucán esmeralda', 'Aulacorhynchus prasinus', NULL, 46, 3),
(12, 'Boa constrictor', 'Boa constrictor', NULL, 7, 2),
(13, 'Oso perezoso', 'Bradypus tridactylus', NULL, 8, 4),
(14, 'Perezoso bayo', 'Bradypus variegatus', NULL, 8, 4),
(15, 'Garza ganadera', 'Bubulcus ibis', NULL, 5, 3),
(16, 'Gavilán gris', 'Buteo magnirostris', NULL, 11, 3),
(17, 'Babilla', 'Caiman crocodilus', NULL, 3, 2),
(18, 'Cara cara', 'Caracara cheriway', NULL, 34, 3),
(19, 'Mono cariblanco', 'Cebus albifrons', NULL, 20, 4),
(20, 'Zorro perro', 'Cerdocyon thous', NULL, 17, 4),
(21, 'Morrocoy patas amarillas', 'Chelonoidis denticulata', NULL, 10, 2),
(22, 'Morrocoy patas rojas', 'Chelonoidis carbonaria', NULL, 10, 2),
(24, 'Serpiente juetiadora ', 'Chironius spixii', NULL, 22, 2),
(25, 'Perezoso de dos dedos', 'Choloepus hoffmanni', NULL, 54, 4),
(26, 'Puercoespin arborícola', 'Coendou prehensilis', NULL, 32, 4),
(27, 'Serpiente cascabel', 'Crotalus durissus', NULL, 53, 2),
(28, 'Borugo o paca', 'Cuniculus paca', NULL, 26, 4),
(29, 'Guara o ñeque oscuro', 'Dasyprocta fuliginosa', NULL, 28, 4),
(30, 'Guara o ñeque centroamericano', 'Dasyprocta punctata', NULL, 28, 4),
(31, 'Armadillo de nueve bandas', 'Dasypus novemcinctus', NULL, 27, 4),
(32, 'Pato pisingo', 'Dendrocygna autumnalis', NULL, 14, 3),
(33, 'Zarigüeya', 'Didelphis marsupialis', NULL, 29, 4),
(34, 'Serpiente indigo', 'Drymarchon corais', NULL, 22, 2),
(35, 'Anaconda', 'Eunectes murinus', NULL, 7, 2),
(36, 'Perico cascabelito', 'Forpus conspicillatus', NULL, 4, 3),
(37, 'Grisón o huroncito', 'Galictis vittata', NULL, 39, 4),
(38, 'Gavilán coliblanco', 'Geranoaetus albicaudatus', NULL, 11, 3),
(39, 'Puma yaguarundí', 'Herpailurus yagouaroundi', NULL, 1, 4),
(40, 'Chigüiro', 'Hydrochoerus hydrochaeris', NULL, 9, 4),
(41, 'Iguana', 'Iguana iguana', NULL, 36, 2),
(42, 'Tortuga estuche', 'Kinosternon scorpioides', NULL, 2, 2),
(43, 'Mono churuco', 'Lagothrix lagotricha', NULL, 6, 4),
(44, 'Ocelote', 'Leopardus pardalis', NULL, 1, 4),
(45, 'Nutria', 'Lontra longicaudis', NULL, 39, 4),
(46, 'Venado colorado', 'Mazama rufina', NULL, 21, 4),
(47, 'Búho currucutú', 'Megascops choliba', NULL, 37, 3),
(48, 'Garrapatero', 'Milvago chimachima', NULL, 34, 3),
(49, 'Mirla blanca', 'Mimus gilvus', NULL, 38, 3),
(50, 'Cusumbo', 'Nasua nasua', NULL, 44, 4),
(51, 'Cusumbo andino', 'Nasuella olivacea', NULL, 44, 4),
(52, 'Guarda camino', 'Nyctidromus albicollis', NULL, 18, 3),
(53, 'Guacharaca', 'Ortalis columbiana', NULL, 24, 3),
(54, 'Aguila pescadora', 'Pandion haliaetus', NULL, 41, 3),
(55, 'Polla de agua', 'Pardirallus nigricans', NULL, 45, 3),
(56, 'Lora negra', 'Pionus chalcopterus', NULL, 4, 3),
(57, 'Cotorra cheja', 'Pionus menstruus', NULL, 4, 3),
(58, 'Bichofué', 'Pitangus sulphuratus', NULL, 52, 3),
(59, 'Charapa arrau', 'Podocnemis expansa', NULL, 43, 2),
(60, 'Tortuga terecay', 'Podocnemis unifilis', NULL, 43, 2),
(61, 'Polla azul', 'Porphyrio martinicus', NULL, 45, 3),
(62, 'Perro de monte', 'Potos flavus', NULL, 44, 4),
(63, 'Mapache', 'Procyon cancrivorus', NULL, 44, 4),
(64, 'Búho Rayado', 'Asio clamator', NULL, 37, 3),
(65, 'Tucán pichí bandirrojo', 'Pteroglossus castanotis', NULL, 46, 3),
(66, 'Tucán pechiblanco', 'Ramphastos tucanus', NULL, 46, 3),
(67, 'Mico león bebeleche', 'Saguinus fuscicollis', NULL, 16, 4),
(68, 'Mono ardilla', 'Saimiri sciureus', NULL, 20, 4),
(69, 'Ardilla', 'Sciurus granatensis', NULL, 48, 4),
(70, 'Aguila real de montaña', 'Spizaetus isidori', NULL, 11, 3),
(71, 'Guácharo', 'Steatornis caripensis', NULL, 49, 3),
(72, 'Vencejo de collar blanco', 'Streptoprocne zonaris', NULL, 15, 3),
(73, 'Oso hormiguero', 'Tamandua mexicana', NULL, 40, 4),
(74, 'Cocli', 'Theristicus caudatus', NULL, 51, 3),
(75, 'Tortuga hicotea', 'Trachemys callirostris', NULL, 31, 2),
(76, 'Tortuga palmera', 'Rhinoclemmys melanosterna', NULL, 35, 2),
(77, 'Azulejo', 'Thraupis episcopus', NULL, 50, 3),
(78, 'Perico real', 'Brotogeris jugularis', NULL, 4, 3),
(79, 'Búho orejudo grande', 'Bubo virginianus', NULL, 37, 3),
(80, 'Culebra sabanera', 'Drymarchon melanurus', NULL, 22, 2),
(81, 'Cernícalo americano', 'Falco sparverius', NULL, 34, 3),
(82, 'Carriquí verde amarillo', 'Gyanocorax incas', NULL, 23, 3),
(83, 'Margay', 'Leopardus wiedii', NULL, 1, 4),
(84, 'Carpintero  habano', 'Melanerpes rubricupillus', NULL, 42, 3),
(85, 'Coral rabo de ají', 'Micrurus mipartitus', NULL, 47, 2),
(86, 'Roscón overo', 'Pardirallus maculatus', NULL, 45, 3),
(87, 'Ibis negro-coquito', 'Phimosus infuscatus', NULL, 51, 3),
(88, 'Charapa del magdalena', 'Podocnemis lewyana', NULL, 43, 2),
(89, 'Tucán de garganta amarilla', 'Ramphastos citrolaemus', NULL, 46, 3),
(90, 'Mono maicero', 'Sapajus apella', NULL, 20, 4),
(91, 'Zopilote rey-rey gallinazo', 'Sarcoramphus papa', NULL, 19, 3),
(92, 'Canario silvestre', 'Sicalis flaveola', NULL, 50, 3),
(93, 'Serpiente toche o cazadora', 'Spilotes pullatus', NULL, 22, 2),
(94, 'Osito melero', 'Tamandua tetradactyla', NULL, 40, 4),
(95, 'Gorrión copetón común', 'Zonotrichia capensis', NULL, 55, 3),
(96, 'Tórtola torcaza', 'Zenaida auriculata', NULL, 25, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `depId` bigint(20) NOT NULL,
  `depNombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`depId`, `depNombre`) VALUES
(1, 'Huila');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desarrollobiologico`
--

CREATE TABLE `desarrollobiologico` (
  `desbioId` int(11) NOT NULL,
  `desbioNombre` varchar(20) NOT NULL,
  `desbioAbreviatura` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `desarrollobiologico`
--

INSERT INTO `desarrollobiologico` (`desbioId`, `desbioNombre`, `desbioAbreviatura`) VALUES
(1, 'Cría', 'CR'),
(2, 'Polluelo', 'P'),
(3, 'Juvenil', 'J'),
(4, 'Adulto', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direcctionterritorial`
--

CREATE TABLE `direcctionterritorial` (
  `dirterId` int(11) NOT NULL,
  `dirterNombre` varchar(50) NOT NULL,
  `dirterAbreviatura` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `direcctionterritorial`
--

INSERT INTO `direcctionterritorial` (`dirterId`, `dirterNombre`, `dirterAbreviatura`) VALUES
(1, 'Dirección territorial norte', 'DTN'),
(2, 'Dirección territorial sur', 'DTS'),
(3, 'Dirección territorial centro', 'DTC'),
(4, 'Dirección territorial occidental', 'DTO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donanteinfractor`
--

CREATE TABLE `donanteinfractor` (
  `doninId` bigint(20) NOT NULL,
  `doninIdentifiacion` varchar(20) DEFAULT NULL,
  `doninNombres` varchar(100) DEFAULT NULL,
  `doninApellidos` varchar(100) DEFAULT NULL,
  `doninDireccion` varchar(100) DEFAULT NULL,
  `doninTelefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `donanteinfractor`
--

INSERT INTO `donanteinfractor` (`doninId`, `doninIdentifiacion`, `doninNombres`, `doninApellidos`, `doninDireccion`, `doninTelefono`) VALUES
(1, '1075220291', 'Wilson', 'Carvajal', 'Cr 5b #63-07 el cortijo neiva', '3182785398');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familia`
--

CREATE TABLE `familia` (
  `faId` int(11) NOT NULL,
  `faNombre` varchar(50) NOT NULL,
  `faDescripcion` text,
  `orId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `familia`
--

INSERT INTO `familia` (`faId`, `faNombre`, `faDescripcion`, `orId`) VALUES
(1, 'Felidae', NULL, 6),
(2, 'Kinosternidae', NULL, 24),
(3, 'Alligatoridae', NULL, 8),
(4, 'Psittacidae', NULL, 20),
(5, 'Ardeidae', NULL, 16),
(6, 'Atelidae', NULL, 19),
(7, 'Boidae', NULL, 22),
(8, 'Bradypodidae', NULL, 18),
(9, 'Caviidae', NULL, 21),
(10, 'Testudinidae', NULL, 24),
(11, 'Accipitridae', NULL, 1),
(14, 'Anatidae', NULL, 2),
(15, 'Apodidae', NULL, 3),
(16, 'Callitrichidae', NULL, 19),
(17, 'Canidae', NULL, 6),
(18, 'Caprimulgidae', NULL, 5),
(19, 'Cathartidae', NULL, 12),
(20, 'Cebidae', NULL, 19),
(21, 'Cervidae', NULL, 4),
(22, 'Colubridae', NULL, 22),
(23, 'Corvidae', NULL, 15),
(24, 'Cracidae', NULL, 13),
(25, 'Columbidae', NULL, 9),
(26, 'Cuniculidae', NULL, 21),
(27, 'Dasypodidae', NULL, 7),
(28, 'Dasyproctidae', NULL, 21),
(29, 'Didelphidae', NULL, 10),
(30, 'Emberizidae', NULL, 15),
(31, 'Emydidae', NULL, 24),
(32, 'Erethizontidae', NULL, 21),
(33, 'Erinaceidae', NULL, 11),
(34, 'Falconidae', NULL, 12),
(35, 'Geoemydidae', NULL, 24),
(36, 'Iguanidae', NULL, 22),
(37, 'Strigidae', NULL, 23),
(38, 'Mimidae', NULL, 15),
(39, 'Mustelidae', NULL, 6),
(40, 'Myrmecophagidae', NULL, 18),
(41, 'Pandionidae', NULL, 1),
(42, 'Picidae', NULL, 17),
(43, 'Podocnemididae', NULL, 24),
(44, 'Procyonidae', NULL, 6),
(45, 'Rallidae', NULL, 14),
(46, 'Ramphastidae', NULL, 17),
(47, 'Elapidae', NULL, 22),
(48, 'Sciuridae', NULL, 21),
(49, 'Steatornithidae', NULL, 5),
(50, 'Thraupidae', NULL, 15),
(51, 'Threskiornithidae', NULL, 16),
(52, 'Tyrannidae', NULL, 15),
(53, 'Viperidae', NULL, 22),
(54, 'Megalonychidae', NULL, 18),
(55, 'Passerellidae', NULL, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fotoanimal`
--

CREATE TABLE `fotoanimal` (
  `fotanId` bigint(20) NOT NULL,
  `fotanNombre` varchar(50) NOT NULL,
  `animalId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `genId` int(11) NOT NULL,
  `genNombre` varchar(20) NOT NULL,
  `genAbreviatura` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`genId`, `genNombre`, `genAbreviatura`) VALUES
(1, 'Macho', 'M'),
(2, 'Hembra', 'H');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE `grupo` (
  `grupoid` varchar(10) NOT NULL,
  `grupodescripcion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`grupoid`, `grupodescripcion`) VALUES
('admin', 'usuario admin'),
('user', 'usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupotaxonomico`
--

CREATE TABLE `grupotaxonomico` (
  `gruptaxId` int(11) NOT NULL,
  `gruptaxNombre` varchar(30) NOT NULL,
  `grupotaxAbreviatura` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `grupotaxonomico`
--

INSERT INTO `grupotaxonomico` (`gruptaxId`, `gruptaxNombre`, `grupotaxAbreviatura`) VALUES
(1, 'Anfibio', 'AN'),
(2, 'Reptil', 'RE'),
(3, 'Ave', 'AV'),
(4, 'Mamifero', 'MA'),
(5, 'Peces', 'PE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso`
--

CREATE TABLE `ingreso` (
  `ingId` bigint(20) NOT NULL,
  `ingFecha` datetime NOT NULL,
  `ingRadicado` varchar(50) DEFAULT NULL,
  `ingAUCTFF` varchar(50) DEFAULT NULL,
  `dirterId` int(11) NOT NULL,
  `animalId` bigint(20) NOT NULL,
  `funcionarioId` bigint(20) NOT NULL,
  `donanteinfractorId` bigint(20) DEFAULT NULL,
  `ingConsecutivo` bigint(20) DEFAULT NULL,
  `ingEstado` int(11) DEFAULT NULL COMMENT 'vivo=1 muerto = 2',
  `ingCausa` varchar(2) DEFAULT NULL COMMENT 'Entrega voluntaria = EV , decomiso = DC',
  `lugardecomisoentregavoluntariaId` int(11) DEFAULT NULL,
  `genId` int(11) DEFAULT NULL,
  `desbioId` int(11) DEFAULT NULL,
  `ingObservaciones` longtext,
  `ingEstadoSalud` varchar(1) DEFAULT NULL COMMENT 'B=Bueno,M=Malo,R=Regular',
  `depOcurrenciaId` bigint(20) DEFAULT NULL,
  `depExtraccionId` bigint(20) DEFAULT NULL,
  `munOcurrenciaId` bigint(20) DEFAULT NULL,
  `munExtraccionId` bigint(20) DEFAULT NULL,
  `verOcurrenciaId` bigint(20) DEFAULT NULL,
  `verExtraccionId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ingreso`
--

INSERT INTO `ingreso` (`ingId`, `ingFecha`, `ingRadicado`, `ingAUCTFF`, `dirterId`, `animalId`, `funcionarioId`, `donanteinfractorId`, `ingConsecutivo`, `ingEstado`, `ingCausa`, `lugardecomisoentregavoluntariaId`, `genId`, `desbioId`, `ingObservaciones`, `ingEstadoSalud`, `depOcurrenciaId`, `depExtraccionId`, `munOcurrenciaId`, `munExtraccionId`, `verOcurrenciaId`, `verExtraccionId`) VALUES
(1, '2020-04-06 00:00:00', '465767', '32545645', 2, 20, 1, 1, 1, 2, 'EV', 10, 1, 4, 'kdlkfklds', NULL, 1, NULL, NULL, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresosubproducto`
--

CREATE TABLE `ingresosubproducto` (
  `ingsubproId` bigint(20) NOT NULL,
  `ingId` bigint(20) NOT NULL,
  `subprodId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ingresosubproducto`
--

INSERT INTO `ingresosubproducto` (`ingsubproId`, `ingId`, `subprodId`) VALUES
(1, 1, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugardecomisoentregavoluntaria`
--

CREATE TABLE `lugardecomisoentregavoluntaria` (
  `lugDecEntVoId` int(11) NOT NULL,
  `lugDecEntVoNombre` varchar(100) NOT NULL,
  `lugDecEntVoAbreviatura` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lugardecomisoentregavoluntaria`
--

INSERT INTO `lugardecomisoentregavoluntaria` (`lugDecEntVoId`, `lugDecEntVoNombre`, `lugDecEntVoAbreviatura`) VALUES
(1, 'Plaza de mercado', 'PM'),
(2, 'Terminal de transporte terrestre', 'TTT'),
(3, 'Terminal de transporte aereo', 'TTA'),
(4, 'Puesto de control', 'PC'),
(5, 'Tienda de mascotas', 'TM'),
(6, 'Establecimiento privado', 'EP'),
(7, 'Residencia', 'RS'),
(8, 'Centro de atención y valoración', 'CAV'),
(9, 'Finca', 'FCA'),
(10, 'Direccion territorial', 'DT'),
(11, 'Centro de atención inmediata', 'CAI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `municipio`
--

CREATE TABLE `municipio` (
  `munId` bigint(20) NOT NULL,
  `munNombre` varchar(100) NOT NULL,
  `departamentoId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `municipio`
--

INSERT INTO `municipio` (`munId`, `munNombre`, `departamentoId`) VALUES
(1, 'Neiva', 1),
(2, 'Pitalito', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

CREATE TABLE `orden` (
  `orId` int(11) NOT NULL,
  `orNombre` varchar(50) NOT NULL,
  `orDescripcion` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `orden`
--

INSERT INTO `orden` (`orId`, `orNombre`, `orDescripcion`) VALUES
(1, 'Accipitriformes', NULL),
(2, 'Anseriformes ', NULL),
(3, 'Apodiforme', NULL),
(4, 'Artiodactyla', NULL),
(5, 'Caprimulgiformes', NULL),
(6, 'Carnivora', NULL),
(7, 'Cingulata', NULL),
(8, 'Crocodilia ', NULL),
(9, 'Culumbiformes', NULL),
(10, 'Didelphimorphia', NULL),
(11, 'Eulipotyphla', NULL),
(12, 'Falconiformes', NULL),
(13, 'Galliformes', NULL),
(14, 'Gruiformes', NULL),
(15, 'Passeriformes', NULL),
(16, 'Pelecaniformes', NULL),
(17, 'Piciformes', NULL),
(18, 'Pilosa', NULL),
(19, 'Primates', NULL),
(20, 'Psittaciformes', NULL),
(21, 'Rodentia', NULL),
(22, 'Squamata', NULL),
(23, 'Strigiformes', NULL),
(24, 'Testudines', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `perId` bigint(20) NOT NULL,
  `perIdentificacion` varchar(20) NOT NULL,
  `perNombres` varchar(100) NOT NULL,
  `perApellidos` varchar(100) NOT NULL,
  `perdireccion` varchar(100) DEFAULT NULL,
  `pertelefono` varchar(20) DEFAULT NULL,
  `perEmail` varchar(200) DEFAULT NULL,
  `municipioId` bigint(20) DEFAULT NULL,
  `tipoidentificacionId` int(11) DEFAULT NULL,
  `usuarioId` bigint(20) NOT NULL,
  `veredaId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`perId`, `perIdentificacion`, `perNombres`, `perApellidos`, `perdireccion`, `pertelefono`, `perEmail`, `municipioId`, `tipoidentificacionId`, `usuarioId`, `veredaId`) VALUES
(1, '1061705800', 'Deisy Cristina', 'Piñeros Triviño', 'cr 8 este #3-21 sur', '3143791267', 'deisypt@gmail.com', NULL, NULL, 2, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responsable`
--

CREATE TABLE `responsable` (
  `respId` int(11) NOT NULL,
  `respNombre` varchar(100) NOT NULL,
  `respAbreviatura` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `responsable`
--

INSERT INTO `responsable` (`respId`, `respNombre`, `respAbreviatura`) VALUES
(1, 'Corporación autónoma regional del alto magdalena', 'CAM'),
(2, 'Carabineros', 'CARAB'),
(3, 'Policia nacional', 'PONAL'),
(4, 'Ejercito nacional de colombia', 'EJERCOL'),
(5, 'RED TIES', 'RED TIES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responsableingreso`
--

CREATE TABLE `responsableingreso` (
  `respingId` bigint(20) NOT NULL,
  `ingId` bigint(20) NOT NULL,
  `respId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `responsableingreso`
--

INSERT INTO `responsableingreso` (`respingId`, `ingId`, `respId`) VALUES
(1, 1, 2),
(2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subproducto`
--

CREATE TABLE `subproducto` (
  `subprodId` int(11) NOT NULL,
  `subprodNombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `subproducto`
--

INSERT INTO `subproducto` (`subprodId`, `subprodNombre`) VALUES
(1, 'Huevo'),
(2, 'Piel'),
(3, 'Pluma'),
(4, 'Garra'),
(5, 'Pico'),
(6, 'Carne'),
(7, 'Animal disecado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoidentificacion`
--

CREATE TABLE `tipoidentificacion` (
  `tipidentId` int(11) NOT NULL,
  `tipidentNombre` varchar(40) NOT NULL,
  `tipidentAbreviatura` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuId` bigint(20) NOT NULL,
  `usuNombreUsuario` varchar(100) NOT NULL,
  `usuContrasena` varchar(256) NOT NULL,
  `usuEstado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuId`, `usuNombreUsuario`, `usuContrasena`, `usuEstado`) VALUES
(1, 'admin', '8bb0cf6eb9b17d0f7d22b456f121257dc1254e1f01665370476383ea776df414', 1),
(2, 'deisypt', '8bb0cf6eb9b17d0f7d22b456f121257dc1254e1f01665370476383ea776df414', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariogrupo`
--

CREATE TABLE `usuariogrupo` (
  `grupoId` varchar(10) NOT NULL,
  `usuarioId` bigint(20) NOT NULL,
  `nombreusuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuariogrupo`
--

INSERT INTO `usuariogrupo` (`grupoId`, `usuarioId`, `nombreusuario`) VALUES
('admin', 1, 'admin'),
('user', 2, 'deisypt');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vereda`
--

CREATE TABLE `vereda` (
  `verId` bigint(20) NOT NULL,
  `verNombre` varchar(100) NOT NULL,
  `municipioId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vereda`
--

INSERT INTO `vereda` (`verId`, `verNombre`, `municipioId`) VALUES
(1, 'Vereda holanda', 2),
(2, 'Vereda la esmeralda', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`anId`),
  ADD KEY `fk_animal_especie` (`faId`),
  ADD KEY `fk_animal_grupotaxonomico` (`grupotaxonomicoId`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`depId`);

--
-- Indices de la tabla `desarrollobiologico`
--
ALTER TABLE `desarrollobiologico`
  ADD PRIMARY KEY (`desbioId`);

--
-- Indices de la tabla `direcctionterritorial`
--
ALTER TABLE `direcctionterritorial`
  ADD PRIMARY KEY (`dirterId`);

--
-- Indices de la tabla `donanteinfractor`
--
ALTER TABLE `donanteinfractor`
  ADD PRIMARY KEY (`doninId`);

--
-- Indices de la tabla `familia`
--
ALTER TABLE `familia`
  ADD PRIMARY KEY (`faId`),
  ADD KEY `fk_orden_familia` (`orId`);

--
-- Indices de la tabla `fotoanimal`
--
ALTER TABLE `fotoanimal`
  ADD PRIMARY KEY (`fotanId`),
  ADD KEY `fk_fotoanimal_animal` (`animalId`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`genId`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`grupoid`);

--
-- Indices de la tabla `grupotaxonomico`
--
ALTER TABLE `grupotaxonomico`
  ADD PRIMARY KEY (`gruptaxId`);

--
-- Indices de la tabla `ingreso`
--
ALTER TABLE `ingreso`
  ADD PRIMARY KEY (`ingId`),
  ADD KEY `fk_ingreso_direccionterritorial` (`dirterId`),
  ADD KEY `fk_ingreso_animal` (`animalId`),
  ADD KEY `fk_ingreso_funcionario` (`funcionarioId`),
  ADD KEY `fk_ingreso_donanteinfractor` (`donanteinfractorId`),
  ADD KEY `fk_ingreso_lugardecomisoentregavoluntaria` (`lugardecomisoentregavoluntariaId`),
  ADD KEY `fk_ingreso_desarrollobiologico` (`desbioId`),
  ADD KEY `fk_ingreso_genero` (`genId`),
  ADD KEY `fk_ingreso_departamentoextraccion` (`depExtraccionId`),
  ADD KEY `fk_ingreso_departamentoocurrencia` (`depOcurrenciaId`),
  ADD KEY `fk_ingreso_municipioextraccion` (`munExtraccionId`),
  ADD KEY `fk_ingreso_municipioocurrencia` (`munOcurrenciaId`),
  ADD KEY `fk_ingreso_veredaextraccion` (`verExtraccionId`),
  ADD KEY `fk_ingreso_veredaocurrencia` (`verOcurrenciaId`);

--
-- Indices de la tabla `ingresosubproducto`
--
ALTER TABLE `ingresosubproducto`
  ADD PRIMARY KEY (`ingsubproId`),
  ADD KEY `fk_ingresosubproducto_ingreso` (`ingId`),
  ADD KEY `fk_ingresosubproducto_subproducto` (`subprodId`);

--
-- Indices de la tabla `lugardecomisoentregavoluntaria`
--
ALTER TABLE `lugardecomisoentregavoluntaria`
  ADD PRIMARY KEY (`lugDecEntVoId`);

--
-- Indices de la tabla `municipio`
--
ALTER TABLE `municipio`
  ADD PRIMARY KEY (`munId`),
  ADD KEY `fk_municipio_departamento` (`departamentoId`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`orId`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`perId`),
  ADD KEY `fk_persona_tipoidentifiacion` (`tipoidentificacionId`),
  ADD KEY `fk_persona_municipio` (`municipioId`),
  ADD KEY `fk_persona_vereda` (`veredaId`),
  ADD KEY `fk_persona_usuario` (`usuarioId`);

--
-- Indices de la tabla `responsable`
--
ALTER TABLE `responsable`
  ADD PRIMARY KEY (`respId`);

--
-- Indices de la tabla `responsableingreso`
--
ALTER TABLE `responsableingreso`
  ADD PRIMARY KEY (`respingId`),
  ADD KEY `fk_responsableingreso_ingreso` (`ingId`),
  ADD KEY `fk_responsableingreso_responsable` (`respId`);

--
-- Indices de la tabla `subproducto`
--
ALTER TABLE `subproducto`
  ADD PRIMARY KEY (`subprodId`);

--
-- Indices de la tabla `tipoidentificacion`
--
ALTER TABLE `tipoidentificacion`
  ADD PRIMARY KEY (`tipidentId`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuId`);

--
-- Indices de la tabla `usuariogrupo`
--
ALTER TABLE `usuariogrupo`
  ADD PRIMARY KEY (`usuarioId`,`grupoId`),
  ADD KEY `fk_usuariogrupo_grupo` (`grupoId`);

--
-- Indices de la tabla `vereda`
--
ALTER TABLE `vereda`
  ADD PRIMARY KEY (`verId`),
  ADD KEY `fk_vereda_municipio` (`municipioId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `animal`
--
ALTER TABLE `animal`
  MODIFY `anId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `depId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `desarrollobiologico`
--
ALTER TABLE `desarrollobiologico`
  MODIFY `desbioId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `direcctionterritorial`
--
ALTER TABLE `direcctionterritorial`
  MODIFY `dirterId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `donanteinfractor`
--
ALTER TABLE `donanteinfractor`
  MODIFY `doninId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `familia`
--
ALTER TABLE `familia`
  MODIFY `faId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT de la tabla `fotoanimal`
--
ALTER TABLE `fotoanimal`
  MODIFY `fotanId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `genId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `grupotaxonomico`
--
ALTER TABLE `grupotaxonomico`
  MODIFY `gruptaxId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `ingreso`
--
ALTER TABLE `ingreso`
  MODIFY `ingId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `ingresosubproducto`
--
ALTER TABLE `ingresosubproducto`
  MODIFY `ingsubproId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `lugardecomisoentregavoluntaria`
--
ALTER TABLE `lugardecomisoentregavoluntaria`
  MODIFY `lugDecEntVoId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `municipio`
--
ALTER TABLE `municipio`
  MODIFY `munId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `orden`
--
ALTER TABLE `orden`
  MODIFY `orId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `perId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `responsable`
--
ALTER TABLE `responsable`
  MODIFY `respId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `responsableingreso`
--
ALTER TABLE `responsableingreso`
  MODIFY `respingId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `subproducto`
--
ALTER TABLE `subproducto`
  MODIFY `subprodId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tipoidentificacion`
--
ALTER TABLE `tipoidentificacion`
  MODIFY `tipidentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `vereda`
--
ALTER TABLE `vereda`
  MODIFY `verId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `fk_animal_familia` FOREIGN KEY (`faId`) REFERENCES `familia` (`faId`),
  ADD CONSTRAINT `fk_animal_grupotaxonomico` FOREIGN KEY (`grupotaxonomicoId`) REFERENCES `grupotaxonomico` (`gruptaxId`);

--
-- Filtros para la tabla `familia`
--
ALTER TABLE `familia`
  ADD CONSTRAINT `fk_orden_familia` FOREIGN KEY (`orId`) REFERENCES `orden` (`orId`);

--
-- Filtros para la tabla `fotoanimal`
--
ALTER TABLE `fotoanimal`
  ADD CONSTRAINT `fk_fotoanimal_animal` FOREIGN KEY (`animalId`) REFERENCES `animal` (`anId`);

--
-- Filtros para la tabla `ingreso`
--
ALTER TABLE `ingreso`
  ADD CONSTRAINT `fk_ingreso_animal` FOREIGN KEY (`animalId`) REFERENCES `animal` (`anId`),
  ADD CONSTRAINT `fk_ingreso_departamentoextraccion` FOREIGN KEY (`depExtraccionId`) REFERENCES `departamento` (`depId`),
  ADD CONSTRAINT `fk_ingreso_departamentoocurrencia` FOREIGN KEY (`depOcurrenciaId`) REFERENCES `departamento` (`depId`),
  ADD CONSTRAINT `fk_ingreso_desarrollobiologico` FOREIGN KEY (`desbioId`) REFERENCES `desarrollobiologico` (`desbioId`),
  ADD CONSTRAINT `fk_ingreso_direccionterritorial` FOREIGN KEY (`dirterId`) REFERENCES `direcctionterritorial` (`dirterId`),
  ADD CONSTRAINT `fk_ingreso_donanteinfractor` FOREIGN KEY (`donanteinfractorId`) REFERENCES `donanteinfractor` (`doninId`),
  ADD CONSTRAINT `fk_ingreso_funcionario` FOREIGN KEY (`funcionarioId`) REFERENCES `persona` (`perId`),
  ADD CONSTRAINT `fk_ingreso_genero` FOREIGN KEY (`genId`) REFERENCES `genero` (`genId`),
  ADD CONSTRAINT `fk_ingreso_lugardecomisoentregavoluntaria` FOREIGN KEY (`lugardecomisoentregavoluntariaId`) REFERENCES `lugardecomisoentregavoluntaria` (`lugDecEntVoId`),
  ADD CONSTRAINT `fk_ingreso_municipioextraccion` FOREIGN KEY (`munExtraccionId`) REFERENCES `municipio` (`munId`),
  ADD CONSTRAINT `fk_ingreso_municipioocurrencia` FOREIGN KEY (`munOcurrenciaId`) REFERENCES `municipio` (`munId`),
  ADD CONSTRAINT `fk_ingreso_veredaextraccion` FOREIGN KEY (`verExtraccionId`) REFERENCES `vereda` (`verId`),
  ADD CONSTRAINT `fk_ingreso_veredaocurrencia` FOREIGN KEY (`verOcurrenciaId`) REFERENCES `vereda` (`verId`);

--
-- Filtros para la tabla `ingresosubproducto`
--
ALTER TABLE `ingresosubproducto`
  ADD CONSTRAINT `fk_ingresosubproducto_ingreso` FOREIGN KEY (`ingId`) REFERENCES `ingreso` (`ingId`),
  ADD CONSTRAINT `fk_ingresosubproducto_subproducto` FOREIGN KEY (`subprodId`) REFERENCES `subproducto` (`subprodId`);

--
-- Filtros para la tabla `municipio`
--
ALTER TABLE `municipio`
  ADD CONSTRAINT `fk_municipio_departamento` FOREIGN KEY (`departamentoId`) REFERENCES `departamento` (`depId`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `fk_persona_municipio` FOREIGN KEY (`municipioId`) REFERENCES `municipio` (`munId`),
  ADD CONSTRAINT `fk_persona_tipoidentifiacion` FOREIGN KEY (`tipoidentificacionId`) REFERENCES `tipoidentificacion` (`tipidentId`),
  ADD CONSTRAINT `fk_persona_usuario` FOREIGN KEY (`usuarioId`) REFERENCES `usuario` (`usuId`),
  ADD CONSTRAINT `fk_persona_vereda` FOREIGN KEY (`veredaId`) REFERENCES `vereda` (`verId`);

--
-- Filtros para la tabla `responsableingreso`
--
ALTER TABLE `responsableingreso`
  ADD CONSTRAINT `fk_responsableingreso_ingreso` FOREIGN KEY (`ingId`) REFERENCES `ingreso` (`ingId`),
  ADD CONSTRAINT `fk_responsableingreso_responsable` FOREIGN KEY (`respId`) REFERENCES `responsable` (`respId`);

--
-- Filtros para la tabla `usuariogrupo`
--
ALTER TABLE `usuariogrupo`
  ADD CONSTRAINT `fk_usuariogrupo_grupo` FOREIGN KEY (`grupoId`) REFERENCES `grupo` (`grupoid`),
  ADD CONSTRAINT `fk_usuariogrupo_usuario` FOREIGN KEY (`usuarioId`) REFERENCES `usuario` (`usuId`);

--
-- Filtros para la tabla `vereda`
--
ALTER TABLE `vereda`
  ADD CONSTRAINT `fk_vereda_municipio` FOREIGN KEY (`municipioId`) REFERENCES `municipio` (`munId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
