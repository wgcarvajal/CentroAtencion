-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 21-04-2020 a las 18:38:36
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
  `anDescripcion` text NOT NULL,
  `espId` int(11) NOT NULL,
  `grupotaxonomicoId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignazona`
--

CREATE TABLE `asignazona` (
  `azonaId` bigint(20) NOT NULL,
  `azonaObservaciones` text NOT NULL,
  `azonafechanicial` datetime NOT NULL,
  `azonafechafinal` datetime NOT NULL,
  `entradaid` bigint(20) NOT NULL,
  `zonaubicacionanimalId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `carid` int(11) NOT NULL,
  `carNombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `causaingreso`
--

CREATE TABLE `causaingreso` (
  `causaingId` int(11) NOT NULL,
  `causaingNombre` varchar(50) NOT NULL,
  `causaingAbreviatura` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contrato`
--

CREATE TABLE `contrato` (
  `contId` bigint(20) NOT NULL,
  `contFechaInicial` datetime NOT NULL,
  `contFechaFinal` datetime NOT NULL,
  `cargoId` int(11) NOT NULL,
  `entId` int(11) NOT NULL,
  `perId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denuncia`
--

CREATE TABLE `denuncia` (
  `denId` bigint(20) NOT NULL,
  `denPersonaNombre` varchar(100) NOT NULL,
  `denDescripcion` text NOT NULL,
  `denLugar` text NOT NULL,
  `denUbicacion` int(11) NOT NULL,
  `denTelefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denunciaaudios`
--

CREATE TABLE `denunciaaudios` (
  `dauId` bigint(20) NOT NULL,
  `dauNombre` int(11) NOT NULL,
  `denId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denunciafotos`
--

CREATE TABLE `denunciafotos` (
  `dfotId` bigint(20) NOT NULL,
  `dfotNombre` varchar(100) NOT NULL,
  `denId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `desbioEstado` varchar(30) NOT NULL,
  `desbioEstadoAbreviatura` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diagnostico`
--

CREATE TABLE `diagnostico` (
  `diagId` bigint(20) NOT NULL,
  `diagFecha` datetime NOT NULL,
  `diagPresuntivo` text NOT NULL,
  `diagObervacion` text NOT NULL,
  `ingresoId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direcctionterritorial`
--

CREATE TABLE `direcctionterritorial` (
  `dirterId` int(11) NOT NULL,
  `dirterNombre` varchar(50) NOT NULL,
  `dirterAbreviatura` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entidad`
--

CREATE TABLE `entidad` (
  `entId` int(11) NOT NULL,
  `entNombre` varchar(100) NOT NULL,
  `entDireccion` varchar(100) NOT NULL,
  `entTelefono` varchar(20) NOT NULL,
  `direccionterritorialId` int(11) NOT NULL,
  `municipioId` bigint(20) NOT NULL,
  `veredaId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especie`
--

CREATE TABLE `especie` (
  `espId` int(11) NOT NULL,
  `espNombre` varchar(50) NOT NULL,
  `espDescripcion` text NOT NULL,
  `faId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  (13, 'Arinae', NULL, 20),
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
  (53, 'Viperidae', NULL, 22);

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
('admin', 'usuario admin');

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
  `ingNumeroRadicado` varchar(40) NOT NULL,
  `ingFecha` datetime NOT NULL,
  `ingFechaFin` datetime DEFAULT NULL,
  `ingNumeroUCTFF` varchar(50) NOT NULL,
  `ingresomuerto` int(11) NOT NULL,
  `infractordonatanteId` bigint(20) NOT NULL,
  `denunciaId` bigint(20) NOT NULL,
  `causaingresoId` int(11) NOT NULL,
  `sexoId` int(11) DEFAULT NULL,
  `veredaId` bigint(20) DEFAULT NULL,
  `desarrollobiologicoId` int(11) NOT NULL,
  `muerteId` bigint(20) NOT NULL,
  `entidadId` int(11) NOT NULL,
  `funcionarioId` bigint(20) NOT NULL,
  `ingresoIdOrigen` bigint(20) DEFAULT NULL,
  `municipioId` bigint(20) DEFAULT NULL,
  `liberacionId` bigint(20) NOT NULL,
  `lugardecomisoentregavoluntariaId` int(11) NOT NULL,
  `marcaId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresofoto`
--

CREATE TABLE `ingresofoto` (
  `ingfotoId` int(11) NOT NULL,
  `ingfotoNombre` int(11) NOT NULL,
  `ingfotoFecha` datetime NOT NULL,
  `ingresoId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `liberacion`
--

CREATE TABLE `liberacion` (
  `libId` bigint(20) NOT NULL,
  `veredaId` bigint(20) DEFAULT NULL,
  `municipioId` bigint(20) NOT NULL,
  `libFecha` datetime NOT NULL,
  `libUbicacion` varchar(100) NOT NULL,
  `libObservacion` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugardecomisoentregavoluntaria`
--

CREATE TABLE `lugardecomisoentregavoluntaria` (
  `ldeId` int(11) NOT NULL,
  `ldeNombre` varchar(50) NOT NULL,
  `ldeAbreviatura` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `marcId` bigint(20) NOT NULL,
  `ingresoId` bigint(20) NOT NULL,
  `tipomarcaid` int(11) NOT NULL,
  `ubicacionmarcaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `muerto`
--

CREATE TABLE `muerto` (
  `mueId` bigint(20) NOT NULL,
  `mueFecha` datetime NOT NULL,
  `mueResultadoNecropsia` text NOT NULL,
  `mueEutanasia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 'Neiva', 1);

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
  `perdireccion` varchar(100) NOT NULL,
  `pertelefono` varchar(20) NOT NULL,
  `perEmail` varchar(200) NOT NULL,
  `municipioId` bigint(20) NOT NULL,
  `tipoidentificacionId` int(11) NOT NULL,
  `usuarioId` bigint(20) NOT NULL,
  `veredaId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sexo`
--

CREATE TABLE `sexo` (
  `sexId` int(11) NOT NULL,
  `sexTipo` varchar(30) NOT NULL,
  `sexTipoAbreviatura` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Estructura de tabla para la tabla `tipomarca`
--

CREATE TABLE `tipomarca` (
  `tipomarcId` int(11) NOT NULL,
  `tipomarcaNombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipozonaubicacion`
--

CREATE TABLE `tipozonaubicacion` (
  `tzuId` int(11) NOT NULL,
  `tzuNombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacionmarca`
--

CREATE TABLE `ubicacionmarca` (
  `ubicacionmarcId` int(11) NOT NULL,
  `ubicacionmarcNombre` varchar(60) NOT NULL,
  `ubicacionmarcAbreviatura` varchar(5) NOT NULL
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
(1, 'admin', '8bb0cf6eb9b17d0f7d22b456f121257dc1254e1f01665370476383ea776df414', 1);

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
('admin', 1, 'admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vereda`
--

CREATE TABLE `vereda` (
  `verId` bigint(20) NOT NULL,
  `verNombre` varchar(100) NOT NULL,
  `municipioId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonaubicacionanimal`
--

CREATE TABLE `zonaubicacionanimal` (
  `zonubianId` int(11) NOT NULL,
  `zonubianNombre` varchar(100) NOT NULL,
  `zonubianDescripcion` text,
  `zonubianUbicacion` varchar(50) DEFAULT NULL,
  `zonaubianArea` int(11) NOT NULL,
  `entidadId` int(11) NOT NULL,
  `tipozonaubicacionId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`anId`),
  ADD KEY `fk_animal_especie` (`espId`),
  ADD KEY `fk_animal_grupotaxonomico` (`grupotaxonomicoId`);

--
-- Indices de la tabla `asignazona`
--
ALTER TABLE `asignazona`
  ADD PRIMARY KEY (`azonaId`),
  ADD KEY `fk_asignazona_ingreso` (`entradaid`),
  ADD KEY `fk_asignazona_zonaubicacionanimal` (`zonaubicacionanimalId`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`carid`);

--
-- Indices de la tabla `causaingreso`
--
ALTER TABLE `causaingreso`
  ADD PRIMARY KEY (`causaingId`);

--
-- Indices de la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD PRIMARY KEY (`contId`),
  ADD KEY `fk_contrato_cargo` (`cargoId`),
  ADD KEY `fk_contrato_entidad` (`entId`),
  ADD KEY `fk_contrato_persona` (`perId`);

--
-- Indices de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD PRIMARY KEY (`denId`);

--
-- Indices de la tabla `denunciaaudios`
--
ALTER TABLE `denunciaaudios`
  ADD PRIMARY KEY (`dauId`),
  ADD KEY `fk_denunciaaudios_denuncia` (`denId`);

--
-- Indices de la tabla `denunciafotos`
--
ALTER TABLE `denunciafotos`
  ADD PRIMARY KEY (`dfotId`),
  ADD KEY `fk_denunciafotos_denuncia` (`denId`);

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
-- Indices de la tabla `diagnostico`
--
ALTER TABLE `diagnostico`
  ADD PRIMARY KEY (`diagId`),
  ADD KEY `fk_diagnostico_ingreso` (`ingresoId`);

--
-- Indices de la tabla `direcctionterritorial`
--
ALTER TABLE `direcctionterritorial`
  ADD PRIMARY KEY (`dirterId`);

--
-- Indices de la tabla `entidad`
--
ALTER TABLE `entidad`
  ADD PRIMARY KEY (`entId`),
  ADD KEY `fk_entidad_direccionterritorial` (`direccionterritorialId`),
  ADD KEY `fk_entidad_municipio` (`municipioId`),
  ADD KEY `fk_entidad_vereda` (`veredaId`);

--
-- Indices de la tabla `especie`
--
ALTER TABLE `especie`
  ADD PRIMARY KEY (`espId`),
  ADD KEY `fk_especie_familia` (`faId`);

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
  ADD KEY `fk_ingreso_causaingreso` (`causaingresoId`),
  ADD KEY `fk_ingreso_denuncia` (`denunciaId`),
  ADD KEY `fk_ingreso_desarrollobiologico` (`desarrollobiologicoId`),
  ADD KEY `fk_ingreso_entidad` (`entidadId`),
  ADD KEY `fk_ingreso_personafuncionario` (`funcionarioId`),
  ADD KEY `fk_ingreso_personainfractor` (`infractordonatanteId`),
  ADD KEY `fk_ingreso_liberacion` (`liberacionId`),
  ADD KEY `fk_ingreso_ingresoorigen` (`ingresoIdOrigen`),
  ADD KEY `fk_ingreso_lugardecomisoentregavoluntaria` (`lugardecomisoentregavoluntariaId`),
  ADD KEY `fk_ingreso_muerto` (`muerteId`),
  ADD KEY `fk_ingreso_municipio` (`municipioId`),
  ADD KEY `fk_ingreso_sexo` (`sexoId`),
  ADD KEY `fk_ingreso_vereda` (`veredaId`),
  ADD KEY `fk_ingreso_marca` (`marcaId`);

--
-- Indices de la tabla `ingresofoto`
--
ALTER TABLE `ingresofoto`
  ADD PRIMARY KEY (`ingfotoId`),
  ADD KEY `fk_ingresofoto_ingreso` (`ingresoId`);

--
-- Indices de la tabla `liberacion`
--
ALTER TABLE `liberacion`
  ADD PRIMARY KEY (`libId`),
  ADD KEY `fk_liberacion_municipio` (`municipioId`),
  ADD KEY `fk_liberacion_vereda` (`veredaId`);

--
-- Indices de la tabla `lugardecomisoentregavoluntaria`
--
ALTER TABLE `lugardecomisoentregavoluntaria`
  ADD PRIMARY KEY (`ldeId`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`marcId`),
  ADD KEY `fk_marca_ingreso` (`ingresoId`),
  ADD KEY `fk_marca_ubicacionmarca` (`ubicacionmarcaId`);

--
-- Indices de la tabla `muerto`
--
ALTER TABLE `muerto`
  ADD PRIMARY KEY (`mueId`);

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
-- Indices de la tabla `sexo`
--
ALTER TABLE `sexo`
  ADD PRIMARY KEY (`sexId`);

--
-- Indices de la tabla `tipoidentificacion`
--
ALTER TABLE `tipoidentificacion`
  ADD PRIMARY KEY (`tipidentId`);

--
-- Indices de la tabla `tipomarca`
--
ALTER TABLE `tipomarca`
  ADD PRIMARY KEY (`tipomarcId`);

--
-- Indices de la tabla `tipozonaubicacion`
--
ALTER TABLE `tipozonaubicacion`
  ADD PRIMARY KEY (`tzuId`);

--
-- Indices de la tabla `ubicacionmarca`
--
ALTER TABLE `ubicacionmarca`
  ADD PRIMARY KEY (`ubicacionmarcId`);

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
-- Indices de la tabla `zonaubicacionanimal`
--
ALTER TABLE `zonaubicacionanimal`
  ADD PRIMARY KEY (`zonubianId`),
  ADD KEY `fk_zonaubicacionanimal_entidad` (`entidadId`),
  ADD KEY `fk_zonaubicacionanimal_tipozonaubicacion` (`tipozonaubicacionId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `animal`
--
ALTER TABLE `animal`
  MODIFY `anId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `asignazona`
--
ALTER TABLE `asignazona`
  MODIFY `azonaId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `carid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `causaingreso`
--
ALTER TABLE `causaingreso`
  MODIFY `causaingId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `contrato`
--
ALTER TABLE `contrato`
  MODIFY `contId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  MODIFY `denId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `denunciaaudios`
--
ALTER TABLE `denunciaaudios`
  MODIFY `dauId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `denunciafotos`
--
ALTER TABLE `denunciafotos`
  MODIFY `dfotId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `depId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `desarrollobiologico`
--
ALTER TABLE `desarrollobiologico`
  MODIFY `desbioId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `diagnostico`
--
ALTER TABLE `diagnostico`
  MODIFY `diagId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `direcctionterritorial`
--
ALTER TABLE `direcctionterritorial`
  MODIFY `dirterId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `entidad`
--
ALTER TABLE `entidad`
  MODIFY `entId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `especie`
--
ALTER TABLE `especie`
  MODIFY `espId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `familia`
--
ALTER TABLE `familia`
  MODIFY `faId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT de la tabla `fotoanimal`
--
ALTER TABLE `fotoanimal`
  MODIFY `fotanId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `grupotaxonomico`
--
ALTER TABLE `grupotaxonomico`
  MODIFY `gruptaxId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `ingreso`
--
ALTER TABLE `ingreso`
  MODIFY `ingId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ingresofoto`
--
ALTER TABLE `ingresofoto`
  MODIFY `ingfotoId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `liberacion`
--
ALTER TABLE `liberacion`
  MODIFY `libId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `lugardecomisoentregavoluntaria`
--
ALTER TABLE `lugardecomisoentregavoluntaria`
  MODIFY `ldeId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `marcId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `muerto`
--
ALTER TABLE `muerto`
  MODIFY `mueId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `municipio`
--
ALTER TABLE `municipio`
  MODIFY `munId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `orden`
--
ALTER TABLE `orden`
  MODIFY `orId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `perId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sexo`
--
ALTER TABLE `sexo`
  MODIFY `sexId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipoidentificacion`
--
ALTER TABLE `tipoidentificacion`
  MODIFY `tipidentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipomarca`
--
ALTER TABLE `tipomarca`
  MODIFY `tipomarcId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipozonaubicacion`
--
ALTER TABLE `tipozonaubicacion`
  MODIFY `tzuId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ubicacionmarca`
--
ALTER TABLE `ubicacionmarca`
  MODIFY `ubicacionmarcId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `vereda`
--
ALTER TABLE `vereda`
  MODIFY `verId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `zonaubicacionanimal`
--
ALTER TABLE `zonaubicacionanimal`
  MODIFY `zonubianId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `fk_animal_especie` FOREIGN KEY (`espId`) REFERENCES `especie` (`espId`),
  ADD CONSTRAINT `fk_animal_grupotaxonomico` FOREIGN KEY (`grupotaxonomicoId`) REFERENCES `grupotaxonomico` (`gruptaxId`);

--
-- Filtros para la tabla `asignazona`
--
ALTER TABLE `asignazona`
  ADD CONSTRAINT `fk_asignazona_ingreso` FOREIGN KEY (`entradaid`) REFERENCES `ingreso` (`ingId`),
  ADD CONSTRAINT `fk_asignazona_zonaubicacionanimal` FOREIGN KEY (`zonaubicacionanimalId`) REFERENCES `zonaubicacionanimal` (`zonubianId`);

--
-- Filtros para la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD CONSTRAINT `fk_contrato_cargo` FOREIGN KEY (`cargoId`) REFERENCES `cargo` (`carid`),
  ADD CONSTRAINT `fk_contrato_entidad` FOREIGN KEY (`entId`) REFERENCES `entidad` (`entId`),
  ADD CONSTRAINT `fk_contrato_persona` FOREIGN KEY (`perId`) REFERENCES `persona` (`perId`);

--
-- Filtros para la tabla `denunciaaudios`
--
ALTER TABLE `denunciaaudios`
  ADD CONSTRAINT `fk_denunciaaudios_denuncia` FOREIGN KEY (`denId`) REFERENCES `denuncia` (`denId`);

--
-- Filtros para la tabla `denunciafotos`
--
ALTER TABLE `denunciafotos`
  ADD CONSTRAINT `fk_denunciafotos_denuncia` FOREIGN KEY (`denId`) REFERENCES `denuncia` (`denId`);

--
-- Filtros para la tabla `diagnostico`
--
ALTER TABLE `diagnostico`
  ADD CONSTRAINT `fk_diagnostico_ingreso` FOREIGN KEY (`ingresoId`) REFERENCES `ingreso` (`ingId`);

--
-- Filtros para la tabla `entidad`
--
ALTER TABLE `entidad`
  ADD CONSTRAINT `fk_entidad_direccionterritorial` FOREIGN KEY (`direccionterritorialId`) REFERENCES `direcctionterritorial` (`dirterId`),
  ADD CONSTRAINT `fk_entidad_municipio` FOREIGN KEY (`municipioId`) REFERENCES `municipio` (`munId`),
  ADD CONSTRAINT `fk_entidad_vereda` FOREIGN KEY (`veredaId`) REFERENCES `vereda` (`verId`);

--
-- Filtros para la tabla `especie`
--
ALTER TABLE `especie`
  ADD CONSTRAINT `fk_especie_familia` FOREIGN KEY (`faId`) REFERENCES `familia` (`faId`);

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
  ADD CONSTRAINT `fk_ingreso_causaingreso` FOREIGN KEY (`causaingresoId`) REFERENCES `causaingreso` (`causaingId`),
  ADD CONSTRAINT `fk_ingreso_denuncia` FOREIGN KEY (`denunciaId`) REFERENCES `denuncia` (`denId`),
  ADD CONSTRAINT `fk_ingreso_desarrollobiologico` FOREIGN KEY (`desarrollobiologicoId`) REFERENCES `desarrollobiologico` (`desbioId`),
  ADD CONSTRAINT `fk_ingreso_entidad` FOREIGN KEY (`entidadId`) REFERENCES `entidad` (`entId`),
  ADD CONSTRAINT `fk_ingreso_ingresoorigen` FOREIGN KEY (`ingresoIdOrigen`) REFERENCES `ingreso` (`ingId`),
  ADD CONSTRAINT `fk_ingreso_liberacion` FOREIGN KEY (`liberacionId`) REFERENCES `liberacion` (`libId`),
  ADD CONSTRAINT `fk_ingreso_lugardecomisoentregavoluntaria` FOREIGN KEY (`lugardecomisoentregavoluntariaId`) REFERENCES `lugardecomisoentregavoluntaria` (`ldeId`),
  ADD CONSTRAINT `fk_ingreso_marca` FOREIGN KEY (`marcaId`) REFERENCES `marca` (`marcId`),
  ADD CONSTRAINT `fk_ingreso_muerto` FOREIGN KEY (`muerteId`) REFERENCES `muerto` (`mueId`),
  ADD CONSTRAINT `fk_ingreso_municipio` FOREIGN KEY (`municipioId`) REFERENCES `municipio` (`munId`),
  ADD CONSTRAINT `fk_ingreso_personafuncionario` FOREIGN KEY (`funcionarioId`) REFERENCES `persona` (`perId`),
  ADD CONSTRAINT `fk_ingreso_personainfractor` FOREIGN KEY (`infractordonatanteId`) REFERENCES `ingreso` (`ingId`),
  ADD CONSTRAINT `fk_ingreso_sexo` FOREIGN KEY (`sexoId`) REFERENCES `sexo` (`sexId`),
  ADD CONSTRAINT `fk_ingreso_vereda` FOREIGN KEY (`veredaId`) REFERENCES `vereda` (`verId`);

--
-- Filtros para la tabla `ingresofoto`
--
ALTER TABLE `ingresofoto`
  ADD CONSTRAINT `fk_ingresofoto_ingreso` FOREIGN KEY (`ingresoId`) REFERENCES `ingreso` (`ingId`);

--
-- Filtros para la tabla `liberacion`
--
ALTER TABLE `liberacion`
  ADD CONSTRAINT `fk_liberacion_municipio` FOREIGN KEY (`municipioId`) REFERENCES `municipio` (`munId`),
  ADD CONSTRAINT `fk_liberacion_vereda` FOREIGN KEY (`veredaId`) REFERENCES `vereda` (`verId`);

--
-- Filtros para la tabla `marca`
--
ALTER TABLE `marca`
  ADD CONSTRAINT `fk_marca_ingreso` FOREIGN KEY (`ingresoId`) REFERENCES `ingreso` (`ingId`),
  ADD CONSTRAINT `fk_marca_ubicacionmarca` FOREIGN KEY (`ubicacionmarcaId`) REFERENCES `ubicacionmarca` (`ubicacionmarcId`);

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

--
-- Filtros para la tabla `zonaubicacionanimal`
--
ALTER TABLE `zonaubicacionanimal`
  ADD CONSTRAINT `fk_zonaubicacionanimal_entidad` FOREIGN KEY (`entidadId`) REFERENCES `entidad` (`entId`),
  ADD CONSTRAINT `fk_zonaubicacionanimal_tipozonaubicacion` FOREIGN KEY (`tipozonaubicacionId`) REFERENCES `tipozonaubicacion` (`tzuId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
