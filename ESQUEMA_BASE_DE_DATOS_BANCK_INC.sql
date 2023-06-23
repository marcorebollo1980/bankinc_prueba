CREATE DATABASE bank_inc;
USE bank_inc;

CREATE TABLE IF NOT EXISTS tarjeta_cliente (
idproducto BIGINT AUTO_INCREMENT PRIMARY KEY, 
nombres_titular   VARCHAR(30),
apellidos_titular VARCHAR(30), 
fecha_vencimiento DATE,
movimiento_permitido VARCHAR(10),
numero_tarjeta INTEGER,
activacion_tarjeta VARCHAR(20),
saldo_tarjeta  INTEGER,
saldo_recarga  INTEGER
)  ENGINE=INNODB;

INSERT INTO `bank_inc`.`tarjeta_cliente`
(`idproducto`,
`nombres_titular`,
`apellidos_titular`,
`fecha_vencimiento`,
`movimiento_permitido`,
`numero_tarjeta`,
`activacion_tarjeta`,
`saldo_tarjeta`,
`saldo_recarga`)
VALUES
(1234560000000000,
"Marco Antonio",
"Rebollo Lopez",
"2020-03-25",
"USD",
"123456789",
"Activa",
"1000000",
"2000000");

SELECT * FROM bank_inc.tarjeta_cliente;