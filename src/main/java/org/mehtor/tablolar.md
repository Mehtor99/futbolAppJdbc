CREATE TABLE tbltakim
(
id serial PRIMARY KEY,
takimAd varchar(30)NOT NULL,
baskan varchar(30),
kurulusYili int,
stadyum varchar(40),
sehir varchar(20),
state int DEFAULT 1 --0:Pasif, 1:Aktif
)


CREATE TABLE tblfutbolcu
(
id serial PRIMARY KEY,
takimId int,
FOREING KEY (takimId) references tbltakim(id),
ad varchar(20) NOT NULL,
soyad varchar(20) NOT NULL,
dtarih date,
pozisyon varchar(20),
state int DEFAULT 1 --0:Pasif, 1:Aktif
)