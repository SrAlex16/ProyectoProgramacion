CREATE TABLE `arma` (
  `nombre` varchar(20) NOT NULL,
  `ataque` int(11) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `armadura` (
  `nombre` varchar(20) NOT NULL,
  `vida` int(11) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `enemigo` (
  `nombre` varchar(20) NOT NULL,
  `ataque` int(11) DEFAULT NULL,
  `vida` int(11) DEFAULT NULL,
   arma varchar(20),
   armadura varchar(20), 
   casilla int(2),
   tipo varchar(6),
   foreign key (casilla) references casilla(numero),
   foreign key (arma) references arma(nombre),
   foreign key (armadura) references armadura(nombre),
   primary key(nombre,casilla)
   
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `protagonista` (
  #`nombre` varchar(50) NOT NULL,
  `ataque` int(3) DEFAULT NULL,
  `vida` int(3) DEFAULT NULL,
  foreign key (casilla) references casilla(numero),
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `casilla` (
  `descripcion` varchar(20) DEFAULT NULL,
  `numero` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table caminos_casilla(
	origen int(2),
    destino int(2),
    foreign key (origen) references casilla(numero),
    foreign key (destino) references casilla(numero),
	primary key(origen,destino)
);


insert into enemigo values("", 25, 250, "Espada", "Escudo de madera", 7, "Zombie");
insert into enemigo values("", 25, 250, "Hacha", "Escudo de acero", 8, "Zombie");
insert into enemigo values("", 25, 250, "Daga", "Casco", 9, "Zombie");
insert into enemigo values("", 25, 250, "Cuchillo", "Pechera", 10, "Zombie");
insert into enemigo values("", 25, 250, "Lanza", "Armadura completa", 8, "Zombie");
insert into enemigo values("Lurtz", 30, 200, "katana", "Brazalete",2, "Goblin");
insert into enemigo values("Uglúk", 30, 200, "Espada de dos manos", "Pantalones de malla",11, "Goblin");
insert into enemigo values("Mauhúr", 30, 200, "Maza", "Casco de acero",4, "Goblin");
insert into enemigo values("Uruks", 30, 200, "Puño americano", "Armadura completa de malla",3, "Goblin");

insert into casilla values ("Te despiertas en una habitación con las paredes de piedra, en ellas hay conlagas dos antorchas que iluminan
la habitación. Al ponerte de pie ves que tienes dos pasillos enfrente de tí. Elige a qué pasillo quieres ir (A o B)",1);
#TODO elegir pasillo al elegir pasillo (ver mapa)
insert into casilla values ("Al llegar a esta habitación, te encuentras a un Zombie.
Este corre hacia a tí. Elige a qué pasillo quieres ir (A o B)",2); #TODO combate
insert into casilla values ("Cuando entras a la sala, aparentemene no ves nada, con forme avanzas hacia la salida, escuchas un 
ruido detrás de tí, al darte la vuelta, ves a un Zombie. Elige a qué pasillo quieres ir (A o B)",3);
insert into casilla values ("Nada más salir de tan angustioso enfrentamiento, entras a otra sala muy parecida a la anterior, tanto que
hasta te encuentras el mismo tipo de enenmigo, otro Zombie. Elige a qué pasillo quieres ir (A o B)",4);
insert into casilla values ("Al entrar a esta sala, te fijas en que es la sala más grande que has visto en todo tu recorrido. Esta está iluminada
por grandes lámparas que cuelgan del techo. En cuanto das dos pasos para adentrarte en la habitación, la puerta de detrás tuya se
cierra. Justo después escuchas un rugido, te das cuenta de que viene de un Dragón.",5); #TODO matas al boss final
insert into casilla values ("Al llegar a esta sala, No encuentras absolutamente nada que te llame la atención excepto una gran puerta.
Al abrirla consigues salir del lugar. Has ganado",6); #TODO ganas el juego
insert into casilla values ("Cuando entras a la habitación te encuentras a un Goblin que corre hacia a tí con cara de loco gritando. Elige a qué pasillo quieres ir (A o B)",7);
insert into casilla values ("justo despues de que entres te cae un Goblin del techo, no sabes de donde viene aunque consigues esquivarlo,
pero no te queda más remedio que pelear. Elige a qué pasillo quieres ir (A o B)",8);
insert into casilla values ("Después de entrar a esta sala, ves a un Goblin, tanto tú como el sabeís que no podéis hacer
otra cosa salvo pelear. Elige a qué pasillo quieres ir (A o B)",9);
insert into casilla values ("Llegas a la sala, y de repente... ¡Un Goblin salvaje ha aparecido!",10);
insert into casilla values ("Al entrar a la habitación, te encuentras a un Zombie. Elige a qué pasillo quieres ir (A o B)",11);

insert into caminos_casilla values(1,5);
insert into caminos_casilla values(1,8);
insert into caminos_casilla values(1,9);
insert into caminos_casilla values(1,10);
insert into caminos_casilla values(1,11);
insert into caminos_casilla values(2,11);
insert into caminos_casilla values(2,7);
insert into caminos_casilla values(3,4);
insert into caminos_casilla values(3,8);
insert into caminos_casilla values(4,3);
insert into caminos_casilla values(4,10);
insert into caminos_casilla values(5,1);
insert into caminos_casilla values(5,9);
insert into caminos_casilla values(5,10);
insert into caminos_casilla values(6,5);
insert into caminos_casilla values(7,2);
insert into caminos_casilla values(7,9);
insert into caminos_casilla values(8,1);
insert into caminos_casilla values(8,3);
insert into caminos_casilla values(8,11);
insert into caminos_casilla values(9,1);
insert into caminos_casilla values(9,5);
insert into caminos_casilla values(9,7);
insert into caminos_casilla values(9,10);
insert into caminos_casilla values(10,1);
insert into caminos_casilla values(10,4);
insert into caminos_casilla values(10,5);
insert into caminos_casilla values(10,9);
insert into caminos_casilla values(11,1);
insert into caminos_casilla values(11,2);
insert into caminos_casilla values(11,8);

insert into arma values("Espada",20);
insert into arma values("Hacha",30);
insert into arma values("Daga",10);
insert into arma values("Cuchillo",5);
insert into arma values("Lanza",15);
insert into arma values("Katana",25);
insert into arma values("Espada a dos manos",35);
insert into arma values("Maza",16);
insert into arma values("Puño americano",3);

insert into armadura values("Escudo de madera",15);
insert into armadura values("Escudo de acero",20);
insert into armadura values("Casco de malla",10);
insert into armadura values("Pechera de acero",25);
insert into armadura values("Armadura completa de acero",30);
insert into armadura values("Brazalete",5);
insert into armadura values("Pantalones de malla",33);
insert into armadura values("Casco de acero",24);
insert into armadura values("Armadura completa de malla",35);

