insert into ciudad values(1,"Armenia.png","Armenia");
insert into ciudad values(2,"Barranquilla.png","Barranquilla");
insert into ciudad values(3,"Bogota.png","Bogotá");
insert into ciudad values(4,"Cali.png","Cali");
insert into ciudad values(5,"Cartagena.png","Cartagena");
insert into ciudad values(6,"Medellin.png","Medellín");
insert into ciudad values(7,"Pereira.png","Pereira");
insert into ciudad values(8,"Villavicencio.png","Villavicencio");

insert into caracteristica values(1,"A","Wi-Fi","1");
insert into caracteristica values(2,"A","Sauna","1");
insert into caracteristica values(3,"A","Piscina","1");
insert into caracteristica values(4,"A","Lavanderia","1");
insert into caracteristica values(5,"A","Restaurante","1");
insert into caracteristica values(6,"A","Bar","1");
insert into caracteristica values(7,"A","SPA","1");
insert into caracteristica values(8,"A","Bufet","1");
insert into caracteristica values(9,"A","Servicio al cuarto","2");
insert into caracteristica values(10,"A","Jacuzzi","2");
insert into caracteristica values(11,"A","Refrigerador","2");
insert into caracteristica values(12,"A","Toallas","2");
insert into caracteristica values(13,"A","Kit limpieza","2");
insert into caracteristica values(14,"A","Balcón","2");

insert into cliente values ("1020838034","jfroap@uqvirtual.edu.co","Julian","z9qzumzOIpCBuMco/dtmqyxCjo4L2wLVaKbaCK2TdrNHYEZH7AwBoerDEVo9+OR8",1);
insert into cliente values ("9198283812","daniel@hotmail.com","Daniel","z9qzumzOIpCBuMco/dtmqyxCjo4L2wLVaKbaCK2TdrNHYEZH7AwBoerDEVo9+OR8",2);
insert into cliente values ("1923881992","carlos@hotmail.com","Carlos","z9qzumzOIpCBuMco/dtmqyxCjo4L2wLVaKbaCK2TdrNHYEZH7AwBoerDEVo9+OR8",3);
insert into cliente values ("8448567378","julie@hotmail.com","Julie","z9qzumzOIpCBuMco/dtmqyxCjo4L2wLVaKbaCK2TdrNHYEZH7AwBoerDEVo9+OR8",4);

insert into administrador values ("1129388758","admin1@hotmail.com","Viviana","Y03ulClW2Ndj0c+Z2cwuZaVMc5ckhwsRAaqdfGYlQF2G7PsIemNNDuQNcvVfqRbu");
insert into administrador values ("2994928833","admin2@hotmail.com","Jose","Y03ulClW2Ndj0c+Z2cwuZaVMc5ckhwsRAaqdfGYlQF2G7PsIemNNDuQNcvVfqRbu");
insert into administrador values ("7289838829","admin3@hotmail.com","Carolina","Y03ulClW2Ndj0c+Z2cwuZaVMc5ckhwsRAaqdfGYlQF2G7PsIemNNDuQNcvVfqRbu");

insert into administrador_hotel values ("3884939384","adh@hotmail.com","Sebastian","K82knpdMa+w6Wwo45hO5JyO0nU07g+780xWodDJhQHgSXKprSI4/V0EOxx/iuUcO");
insert into administrador_hotel values ("4883884838","adh2@hotmail.com","Pedro","K82knpdMa+w6Wwo45hO5JyO0nU07g+780xWodDJhQHgSXKprSI4/V0EOxx/iuUcO");
insert into administrador_hotel values ("5348838481","adh3@hotmail.com","Juan","K82knpdMa+w6Wwo45hO5JyO0nU07g+780xWodDJhQHgSXKprSI4/V0EOxx/iuUcO");

insert into hotel values(1,"Resort frente a la playa en Cartagena con 5 restaurantes","Calle 9 Norte. #16-01","A",4,"Hotel Armenia","3224250426","3884939384",1,null);
insert into hotel values(2,"Resort frente a la playa en Barranquilla con 5 restaurantes","Calle 9 Norte. #16-01","A",3,"Hotel Barranquilla","3224250426","3884939384",2,null);
insert into hotel values(3,"Resort frente a la playa en Bogotá con 5 restaurantes","Calle 9 Norte. #16-01","A",2,"Hotel Bogotá","3224250426","5348838481",3,null);
insert into hotel values(4,"Resort frente a la playa en Cali con 5 restaurantes","Calle 9 Norte. #16-01","A",5,"Hotel Cali","3224250426","5348838481",4,null);

insert into cama values (1,"Individual");
insert into cama values (2,"Doble");
insert into cama values (3,"Individual");

insert into habitacion value (1, 1, "A",520000,1);
insert into habitacion value (2, 2, "A",200000,1);
insert into habitacion value (3, 2, "A",150000,2);
insert into habitacion value (4, 2, "A",250000,3);
insert into habitacion value (5, 2, "A",184000,1);

insert into habitacion_camas value (1,1);
insert into habitacion_camas value (2,1);
insert into habitacion_camas value (3,2);
insert into habitacion_camas value (4,1);

insert into reserva  value (1, 4, "A", "2022-04-24","2022-04-22","2022-01-01", 500000, "1020838034",null);
insert into reserva  value (2, 3, "A", "2022-04-24","2022-04-21","2022-04-26", 300000, "9198283812",null);
insert into reserva  value (3, 2, "A", "2022-04-24","2022-04-18","2022-04-22", 500000, "1923881992",null);
insert into reserva  value (4, 1, "A", "2022-04-24","2022-04-12","2022-04-16", 250000, "9198283812",null);
insert into reserva  value (5, 7, "A", "2022-04-24","2022-04-11","2022-04-15", 500000, "8448567378",null);

insert into reserva_habitaciones value (1, 1);
insert into reserva_habitaciones value (2, 2);
insert into reserva_habitaciones value (3, 5);
