DROP TABLE typeVoiture;
DROP TABLE carte;
DROP TABLE nbCase;
DROP TABLE cse;
DROP TABLE partie;
DROP TABLE joueur;
DROP TABLE partieCase;
DROP TABLE carteJoueur;
DROP TABLE pari;

CREATE TABLE `pari` (
  `idPartie` int(11) NOT NULL,
  `couleurJ` varchar(6) NOT NULL,
  `numeroPari` int(11) NOT NULL,
  `jaune` boolean,
  `bleue` boolean,
  `rouge` boolean,
  `violette` boolean,
  `blanche` boolean,
  `verte` boolean,
  KEY `idPartie_fk` (`idPartie`),
  KEY `couleurJ_fk` (`couleurJ`),
  PRIMARY KEY (`idPartie`,`couleurJ`,`numeroPari`)
);

CREATE TABLE `positionPari` (
  `idPartie` int(11) NOT NULL,
  `couleurV` varchar(6) NOT NULL,
  `numeroPari` int(11) NOT NULL,
  `x` int(11) NOT NULL, /* 1,2,3,4 ... */
  `y` char(1) NOT NULL, /* a,b ou c */
  KEY `idPartie_fk` (`idPartie`),
  KEY `couleurV_fk` (`couleurV`),
  PRIMARY KEY (`idPartie`,`couleurV`,`numeroPari`)
);


CREATE TABLE `typeVoiture` (
  `couleurV` varchar(6) NOT NULL,
  `x` int(11) NOT NULL, /* 1,2,3,4 ... */
  `y` char(1) NOT NULL, /* a,b ou c */
  PRIMARY KEY (`couleurV`)
);

CREATE TABLE `carte` (
  `idCarte` int(11) NOT NULL,
  PRIMARY KEY (`idCarte`)
);

CREATE TABLE `nbCase` (
  `couleurV` varchar(6) NOT NULL,
  `idCarte` int(11) NOT NULL,
  `nbCase` int(11) NOT NULL,
  KEY `couleurV_fk` (`couleurV`),
  KEY `idCarte_fk` (`idCarte`),
  PRIMARY KEY (`couleurV`,`idCarte`)
);

CREATE TABLE `cse` (
  `x` int(11) NOT NULL, /* 1,2,3,4 ... */
  `y` char(1) NOT NULL, /* a,b ou c */
  `occupee` boolean,
  `top` FLOAT(11) NOT NULL,
  `left` FLOAT(11) NOT NULL,
  `rotate` int(11) NOT NULL,
  PRIMARY KEY (`x`,`y`)
);

CREATE TABLE `partie` (
  `idPartie` int(11) NOT NULL AUTO_INCREMENT,
  `nomDePartie` varchar(45) NOT NULL,
  `couleurDeProprio` varchar(45) NOT NULL,
  `etat` varchar(45) NOT NULL,
  PRIMARY KEY (`idPartie`)
);

CREATE TABLE `joueur` (
  `couleurJ` varchar(6) NOT NULL,
  `nomDeJoueur`varchar(45) NOT NULL,
  `idPartie` int(11) NOT NULL,
  `x` int(11) NOT NULL,
  `y` char(1) NOT NULL,
  `derniereAction`varchar(45) NOT NULL,
  `score` int(11) ,
  PRIMARY KEY (`couleurJ`,`idPartie`)
);

CREATE TABLE `partieCase` (
  `x` int(11) NOT NULL,
  `y` char(1) NOT NULL,
 `idPartie` int(11) NOT NULL,
  `occupee` boolean,
  KEY `x_fk` (`x`),
  KEY `y_fk` (`x`),
  KEY `idPartie_fk` (`idPartie`),
  PRIMARY KEY (`x`,`y`,`idPartie`)
);

CREATE TABLE `carteJoueur` (
 `idPartie` int(11) NOT NULL,
 `couleurJ` varchar(6) NOT NULL,
 `idCarte` int(11) NOT NULL,
  `utilisee` boolean,
  KEY `idPartie_fk` (`idPartie`),
  KEY `couleurJ_fk` (`couleurJ`),
  KEY `idCarte_fk` (`idCarte`),
  PRIMARY KEY (`idPartie`,`couleurJ`,`idCarte`)
);