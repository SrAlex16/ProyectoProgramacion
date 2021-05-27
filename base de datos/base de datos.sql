create table caminos_casilla(
	origen int(2),
    destino int(2),
    foreign key (origen) references casilla(numero),
    foreign key (destino) references casilla(numero),
	primary key(origen,destino)
);

insert into caminos_casilla values(9,1);
insert into caminos_casilla values(9,12);
insert into caminos_casilla values(3);

