# Tela de login com validação de senha pelo algoritmo MD5

* Script MySQL:
```
SET SQL_SAFE_UPDATES = 0;
DROP DATABASE IF EXISTS DBLOGIN;
CREATE DATABASE DBLOGIN;
USE DBLOGIN; 

CREATE TABLE USUARIO (
	IDUSUARIO INT NOT NULL AUTO_INCREMENT
    , LOGIN VARCHAR (64)
    , SENHA VARCHAR (32)
    , PRIMARY KEY (IDUSUARIO)
);

INSERT INTO USUARIO VALUES (1, "edson", "522e3f83fb865ec46d260868ba556092");
INSERT INTO USUARIO VALUES (2, "rivellino", "25767849cc4c9263ef82fbff5249ca06");
INSERT INTO USUARIO VALUES (3, "ronaldo", "c4277bde177933832023e066b0eede68");

```

* Senhas descriptografadas de cada usuário para teste:

```
edson
pele1958

rivellino
riva1970

ronaldo
fenomeno2002
```

* Para rodar, clone o repositório, converta o projeto para Maven e execute a partir do arquivo Principal, no pacote View. 
