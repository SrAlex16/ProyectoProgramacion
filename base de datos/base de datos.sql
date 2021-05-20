CREATE TABLE `arma` (
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `armadura` (
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `enemigo` (
  `nombre` varchar(20) NOT NULL,
  `ataque` int(11) DEFAULT NULL,
  `vida` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `objetoinventario` (
  `unSoloUso` tinyint(1) DEFAULT NULL,
  `vidaAportada` int(11) DEFAULT NULL,
  `ataqueApotado` int(11) DEFAULT NULL,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `protagonista` (
  `nombre` varchar(50) NOT NULL,
  `ataque` int(3) DEFAULT NULL,
  `vida` int(3) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `casilla` (
  `descripcion` varchar(20) DEFAULT NULL,
  `numero` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#crear las tablas
#insertar todas las filas iniciales (todas las casillas con todos los enemigos que tienen todas las armas)