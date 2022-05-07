insert into ciudad values(1,"Pereira");
insert into ciudad values(2,"Bogota");
insert into ciudad values(3,"Circasia");
insert into ciudad values(4,"Montenegro");
insert into ciudad values(5,"Medellin");

insert into cliente values ("123456","jfroa@hotmail.com","Julian","prueba123",1);
insert into cliente values ("111111","mail@hotmail.com","David","test123",2);
insert into cliente values ("999999","aaaa@hotmail.com","Carlos","email123",3);
insert into cliente values ("112233","bbbb@hotmail.com","Julie","julian123",4);

insert into administrador values ("654321","admin1@hotmail.com","Viviana","vivi123");
insert into administrador values ("593578","admin2@hotmail.com","Jose","jose675");
insert into administrador values ("123987","admin2@hotmail.com","Carolina","caro3982");

insert into administrador_hotel values ("958367","adh@hotmail.com","Sebastian","sebas123");
insert into administrador_hotel values ("122584","adh2@hotmail.com","Pedro","pedro913");
insert into administrador_hotel values ("955321","adh3@hotmail.com","Juan","juanito23");

insert into hotel values(1,"Carrera 5 #20-34",4,"Hotel Deluxe","178945632","958367",1);
insert into hotel values(2,"Carrera 3 #19-20",5,"Hotel Miramar","123698745","958367",2);
insert into hotel values(3,"Calle 9 Norte #16-01",4,"Hotel Mocawa","98499452","958367",3);
insert into hotel values(4,"Calle 2 Sur #20-20",3,"Eco Hotel Las Palmas","699894657","958367",1);

insert into habitacion values(1,4,350000.0,1);
insert into habitacion values(2,2,160500.0,2);
insert into habitacion values(3,4,200500.0,2);
insert into habitacion values(4,2,260700.0,4);
insert into habitacion values(5,2,380000.0,3);

insert into cama values (1,"Individual");
insert into cama values (2,"Doble");
insert into cama values (3,"Doble");
insert into cama values (4,"Individual");

insert into caracteristica values(1,"Wi-Fi");
insert into caracteristica values(2,"Piscina");
insert into caracteristica values(3,"Balcon");
insert into caracteristica values(4,"Lavanderia");
insert into caracteristica values(5,"Mucamas");

insert into comentario values(1,4,"Muy bueno el servicio a la habitacion","2022-04-22","123456", 1);
insert into comentario values(2,3,"Podria mejorar el servicio al cuarto","2022-03-18","123456", 3);

insert into descuento values(1,45,1);
insert into descuento values(2,50,2);
insert into descuento values(3,25,3);
insert into descuento values(4,30,4);

insert into foto values(1,"imgur.com/H23K42zP",1,1);

insert into queja values(1,"La piscina estaba sucia","999999",1);

insert into reserva values(1,2,"Disponible","2022-03-01","2022-02-18","2012-06-18 10:34:09",1500000.0,"112233");

insert into vuelo values(1,"Avianca","En pista",1,2);

insert into silla values(1,"A2",150400.0,1);

insert into telefono values("132456879","Casa","111111");