DELETE FROM typeVoiture;
DELETE FROM carte;
DELETE FROM nbCase;
DELETE FROM cse;
DELETE FROM partieCase;
DELETE FROM partie;
DELETE FROM joueur;
DELETE FROM pari;
DELETE FROM cartejoueur;
DELETE FROM positionpari;

/* ------------------------------------ */
/* ------------ LES CARTES ------------ */
/* ------------------------------------ */

/* initialisation des cartes */
INSERT INTO `carte` (`idCarte`) VALUES (0) , (1), (2), (3), (4), (5), (6),
                                            (11),(12),(13),(14),(15),(16),
                                            (21),(22),(23),(24),(25),(26),
                                            (31),(32),(33),(34),(35),(36),
                                            (41),(42),(43),(44),(45),(46),
                                            (61),(62),(63),(64),(65),(66);

/* carte 0, pour recupérer la position actuelle des joueurs */
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Jaune",0,0),("Rouge",0,0),("Violet",0,0),("Bleu",0,0),("Vert",0,0),("Blanc",0,0);

/* cartes booster */
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Jaune",1,10),("Rouge",2,10),("Violet",3,10),("Bleu",4,10),("Vert",5,10),("Blanc",6,10);

/* cartes : 5 - 2 */
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Jaune",7,5),("Violet",7,2);

/* cartes : 6 - 4 - 2 - 1 */
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Bleu",8,6),("Blanc",8,4),("Vert",8,2),("Rouge",8,1);
/* cartes : 6 - 4 - 2 noir - 1 */
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Bleu",41,6),("Blanc",41,4),("Jaune",41,1);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Jaune",42,6),("Bleu",42,4),("Blanc",42,1);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Blanc",43,6),("Jaune",43,4),("Bleu",43,1);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Violet",44,6),("Vert",44,4),("Rouge",44,1);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Vert",45,6),("Rouge",45,4),("Violet",45,1);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Rouge",46,6),("Violet",46,4),("Vert",46,1);

/* cartes : 6 - 5 - 4 - 3 - 2 - 1 */
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Vert",11,6),("Violet",11,5),("Blanc",11,4),("Jaune",11,3),("Bleu",11,2),("Rouge",11,1);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Vert",12,5),("Violet",12,4),("Blanc",12,3),("Jaune",12,2),("Bleu",12,1),("Rouge",12,6);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Vert",13,4),("Violet",13,3),("Blanc",13,2),("Jaune",13,1),("Bleu",13,6),("Rouge",13,5);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Vert",14,3),("Violet",14,2),("Blanc",14,1),("Jaune",14,6),("Bleu",14,5),("Rouge",14,4);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Vert",15,2),("Violet",15,1),("Blanc",15,6),("Jaune",15,5),("Bleu",15,4),("Rouge",15,3);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Vert",16,1),("Violet",16,6),("Blanc",16,5),("Jaune",16,4),("Bleu",16,3),("Rouge",16,2);

/* cartes : 5  */
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Jaune",21,5),("Rouge",22,5),("Violet",23,5),("Bleu",24,5),("Vert",25,5),("Blanc",26,5);
/* cartes : 5 noir - 2 */
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Jaune",31,2),("Rouge",32,2),("Violet",33,2),("Bleu",34,2),("Vert",35,2),("Blanc",36,2);

/* ----------------------------------- */
/* ------------ LES CASES ------------ */
/* ----------------------------------- */

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`,`rotate`) VALUES
(69,'a',false,0,0,0),         (69,'b',false,0,0,0),         (69,'c',false,0,0,0),
(68,'a',false,62.5,89,0),     (68,'b',false,65,89,0),       (68,'c',false,67.5,89,0),
(67,'a',false,62.5,94,0),     (67,'b',false,65,94,0),       (67,'c',false,67.5,94,0),
(66,'a',false,62.5,89,0),     (66,'b',false,65,89,0),       (66,'c',false,67.5,89,0),
(65,'a',false,62.5,104.8,0),  (65,'b',false,65,104.8,0),    (65,'c',false,67.5,104.8,0),
(64,'a',false,61,111,315),    (64,'b',false,64.5,110,345),  (64,'c',false,67,110,345),
(63,'a',true,61,111,315),    (63,'b',true,64.5,110,345),  (63,'c',true,67,110,345),
(62,'a',true,61,111,315),    (62,'b',true,64.5,110,345),  (62,'c',false,64.5,114.7,315),
(61,'a',true,61,111,315),    (61,'b',false,60.4,114.6,300),(61,'c',true,64.5,114.7,315),
(60,'a',true,61,111,315),    (60,'b',true,60.4,114.6,300),(60,'c',false,60.2,117.6,290),
(59,'a',true,61,111,315),    (59,'b',true,60.4,114.6,300),(59,'c',true,60.2,117.6,290),
(58,'a',false,55,112.8,270),  (58,'b',false,55,115.5,270),  (58,'c',false,55,118.1,270),
(57,'a',false,49.8,111.5,225),(57,'b',false,50,114.8,245),  (57,'c',false,50,117.8,250),
(56,'a',true,49.8,111.5,225),(56,'b',true,50,114.8,245),  (56,'c',true,50,117.8,250),
(55,'a',true,49.8,111.5,225),(55,'b',true,50,114.8,245),  (55,'c',false,45.8,115.3,225),
(54,'a',true,49.8,111.5,225),(54,'b',false,46,110.5,200),  (54,'c',true,45.8,115.3,225),
(53,'a',true,49.8,111.5,225),(53,'b',true,46,110.5,200),  (53,'c',false,43.4,110.8,200),
(52,'a',true,49.8,111.5,225),(52,'b',true,46,110.5,200),  (52,'c',true,43.4,110.8,200),
(51,'a',false,47.8,105,180),  (51,'b',false,45.4,105,180),  (51,'c',false,42.9,105,180),
(50,'a',false,47.8,99.8,180), (50,'b',false,45.4,99.8,180), (50,'c',false,42.9,99.8,180),
(49,'a',false,47.8,94.2,180), (49,'b',false,45.4,94.2,180), (49,'c',false,42.9,94.2,180),
(48,'a',false,47.8,88.8,180), (48,'b',false,45.4,88.8,180), (48,'c',false,42.9,88.8,180),
(47,'a',false,47.8,83.5,180), (47,'b',false,45.4,83.5,180), (47,'c',false,42.9,83.5,180),
(46,'a',false,47.8,78.1,180), (46,'b',false,45.4,78.1,180), (46,'c',false,42.9,78.1,180),
(45,'a',false,47.8,72.7,180), (45,'b',false,44.4,72.7,160), (45,'c',true,0,0,0),
(44,'a',false,47.5,67.5,180), (44,'b',true,0,0,0),         (44,'c',true,0,0,0),
(43,'a',false,46,61.2,225),   (43,'b',true,0,0,0),         (43,'c',true,0,0,0),
(42,'a',false,41,60.1,270),   (42,'b',true,0,0,0),         (42,'c',true,0,0,0),
(41,'a',false,35.8,61.2,315), (41,'b',true,0,0,0),         (41,'c',true,0,0,0),
(40,'a',false,33.7,67.6,0),   (40,'b',true,0,0,0),         (40,'c',true,0,0,0),
(39,'a',false,34,73,0),       (39,'b',false,31.5,73,0),     (39,'c',true,0,0,0),
(38,'a',false,34,79,0),       (38,'b',false,31.5,79,0),     (38,'c',true,0,0,0),
(37,'a',false,34,84,0),       (37,'b',false,31.5,84,0),     (37,'c',true,0,0,0),
(36,'a',false,34,89.2,0),     (36,'b',false,31.5,89.2,0),   (36,'c',true,0,0,0),
(35,'a',false,34,94.5,0),     (35,'b',false,31.5,94.5,0),   (35,'c',true,0,0,0),
(34,'a',false,34,100,0),      (34,'b',false,31.5,100,0),    (34,'c',true,0,0,0),
(33,'a',false,34,105.5,0),    (33,'b',false,31.5,105.5,0),  (33,'c',true,0,0,0),
(32,'a',false,33.7,111,0),    (32,'b',true,0,0,0),         (32,'c',true,0,0,0),
(31,'a',false,32.5,117,315),  (31,'b',true,0,0,0),         (31,'c',true,0,0,0),
(30,'a',false,27.1,118.4,270),(30,'b',true,0,0,0),         (30,'c',true,0,0,0),
(29,'a',false,21.5,117,225),  (29,'b',true,0,0,0),         (29,'c',true,0,0,0),
(28,'a',false,20.5,111,180),  (28,'b',true,0,0,0),         (28,'c',true,0,0,0),
(27,'a',false,24,105.5,160),  (27,'b',false,20.5,105.5,180),(27,'c',true,0,0,0),
(26,'a',false,25.4,99.8,180), (26,'b',false,22.8,99.8,180), (26,'c',false,20.3,99.8,180),
(25,'a',false,25.4,94.7,180), (25,'b',false,22.8,94.7,180), (25,'c',false,20.3,94.7,180),
(24,'a',false,25.4,89.3,180), (24,'b',false,22.8,89.3,180), (24,'c',false,20.3,89.3,180),
(23,'a',false,25.4,83.9,180), (23,'b',false,22.8,83.9,180), (23,'c',false,20.3,83.9,180),
(22,'a',false,25.4,78.5,180), (22,'b',false,22.8,78.5,180), (22,'c',false,20.3,78.5,180),
(21,'a',false,25.4,73,180),   (21,'b',false,22.8,73,180),   (21,'c',false,20.3,73,180),
(20,'a',false,25.4,67.5,180), (20,'b',false,22.8,67.5,180), (20,'c',false,20.3,67.5,180),
(19,'a',false,23.8,62,200),   (19,'b',false,20.3,62,180),   (19,'c',true,0,0,0),
(18,'a',false,22.8,56.5,180), (18,'b',false,20.3,56.5,180), (18,'c',true,0,0,0),
(17,'a',false,24.8,49.6,135), (17,'b',false,21,50,155),     (17,'c',true,0,0,0),
(16,'a',true,0,0,0),         (16,'b',false,25.8,45.7,115), (16,'c',true,0,0,0),
(15,'a',false,31.3,48.8,70),  (15,'b',false,31.3,45.3,90),  (15,'c',true,0,0,0),
(14,'a',false,36.6,50.4,90),  (14,'b',false,36.6,47.8,90),  (14,'c',false,36.6,45.1,90),
(13,'a',false,41.5,50.4,90),  (13,'b',false,41.5,47.8,90),  (13,'c',false,41.5,45.1,90),
(12,'a',false,46.6,50.4,90),  (12,'b',false,46.6,47.8,90),  (12,'c',false,46.6,45.1,90),
(11,'a',false,51.7,50.4,90),  (11,'b',false,51.7,47.8,90),  (11,'c',false,51.7,45.1,90),
(10,'a',false,56.5,49,110),   (10,'b',false,56.7,45.3,90),  (10,'c',true,0,0,0),
(9,'a',false,63,49.6,45),     (9,'b',false,62,45.8,65),     (9,'c',true,0,0,0),
(8,'a',true,0,0,0),          (8,'b',false,66.4,50,30),     (8,'c',true,0,0,0),
(7,'a',false,64,56.5,340),    (7,'b',false,67.2,56.5,0),    (7,'c',true,0,0,0),
(6,'a',false,62.5,62,0),      (6,'b',false,65,62,0),        (6,'c',false,67.5,62,0),
(5,'a',false,62.5,67.5,0),    (5,'b',false,65,67.5,0),      (5,'c',false,67.5,67.5,0),
(4,'a',false,62.5,72.5,0),    (4,'b',false,65,72.5,0),      (4,'c',false,67.5,72.5,0),
(3,'a',false,62.5,78,0),      (3,'b',false,65,78,0),        (3,'c',false,67.5,78,0),
(2,'a',false,62.5,82.9,0),    (2,'b',false,65,82.9,0),      (2,'c',false,67.5,82.9,0),
(1,'a',true,62.5,89,0),       (1,'b',true,65,89,0),         (1,'c',true,67.5,89,0),
(0,'a',true,62.5,94,0),       (0,'b',true,65,94,0),         (0,'c',true,67.5,94,0);

/* -------------------------------------- */
/* ------------ LES VOITURES ------------ */
/* -------------------------------------- */

INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ("Jaune",1,'a');
INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ("Rouge",0,'c');
INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ("Violet",1,'c');
INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ("Bleu",0,'a');
INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ("Vert",1,'b');
INSERT INTO `typeVoiture` (`couleurV`,x,y) VALUES ("Blanc",0,'b');


/* ------------------------------------------------ */
/* données qui sont sensées se créer toutes seules */
/* ------------------------------------------------ */

INSERT INTO `partie` (`idPartie`, `nomDePartie`, `couleurDeProprio`, `etatActuel`, `etatAncien`) VALUES (1, 'partie1test', 'Violet','attente','rien');
INSERT INTO `partie` (`idPartie`, `nomDePartie`, `couleurDeProprio`, `etatActuel`, `etatAncien`) VALUES (2, 'partie2test', 'Violet','attente','rien');

INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Jaune", "BobJaune", 2, 1, 'a',"rien",0);
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Vert", "BobVert", 2, 1, 'b',"rien",0);
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Violet", "BobViolet", 2, 1, 'c',"rien",0);
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Blanc", "BobBlanc", 2, 0, 'b',"rien",0);
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Rouge", "BobRouge", 2, 0, 'c',"rien",0);
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Bleu", "BobBleu", 2, 0, 'a',"rien",0);


INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Jaune", "BobJaune", 1, 1, 'a',"pari1Effectue",0);
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Vert", "BobVert", 1, 1, 'b',"pari1Effectue",0);
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Rouge", "BobRouge", 1, 0, 'c',"pari1Effectue",0);
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Blanc", "BobBlanc", 1, 0, 'b',"pari1Effectue",0);
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`, `derniereAction`,`score`) VALUES ("Bleu", "BobBleu", 1, 0, 'a',"pari1Effectue",0);

INSERT INTO `pari` (`idPartie`, `couleurJ`, `numeroPari`, `jaune`, `bleue`, `rouge`, `violette`, `blanche`, `verte`) VALUES ('1', 'Jaune', '1', '0', '1', '0', '0', '1', '1');
INSERT INTO `pari` (`idPartie`, `couleurJ`, `numeroPari`, `jaune`, `bleue`, `rouge`, `violette`, `blanche`, `verte`) VALUES ('1', 'Rouge', '1', '1', '1', '0', '0', '1', '0');
INSERT INTO `pari` (`idPartie`, `couleurJ`, `numeroPari`, `jaune`, `bleue`, `rouge`, `violette`, `blanche`, `verte`) VALUES ('1', 'Vert', '1', '0', '1', '0', '1', '0', '1');
INSERT INTO `pari` (`idPartie`, `couleurJ`, `numeroPari`, `jaune`, `bleue`, `rouge`, `violette`, `blanche`, `verte`) VALUES ('1', 'Blanc', '1', '0', '1', '0', '1', '0', '1');
INSERT INTO `pari` (`idPartie`, `couleurJ`, `numeroPari`, `jaune`, `bleue`, `rouge`, `violette`, `blanche`, `verte`) VALUES ('1', 'Bleu', '1', '0', '1', '0', '1', '0', '1');


INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (0, 'a', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (0, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (0, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (1, 'a', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (1, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (1, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (2, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (2, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (2, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (3, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (3, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (3, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (4, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (4, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (4, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (5, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (5, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (5, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (6, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (6, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (6, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (7, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (7, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (7, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (8, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (8, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (8, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (9, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (9, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (9, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (10, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (10, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (10, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (11, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (11, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (11, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (12, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (12, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (12, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (13, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (13, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (13, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (14, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (14, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (14, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (15, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (15, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (15, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (16, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (16, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (16, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (17, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (17, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (17, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (18, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (18, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (18, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (19, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (19, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (19, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (20, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (20, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (20, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (21, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (21, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (21, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (22, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (22, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (22, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (23, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (23, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (23, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (24, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (24, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (24, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (25, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (25, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (25, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (26, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (26, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (26, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (27, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (27, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (27, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (28, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (28, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (28, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (29, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (29, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (29, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (30, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (30, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (30, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (31, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (31, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (31, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (32, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (32, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (32, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (33, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (33, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (33, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (34, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (34, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (34, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (35, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (35, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (35, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (36, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (36, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (36, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (37, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (37, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (37, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (38, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (38, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (38, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (39, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (39, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (39, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (40, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (40, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (40, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (41, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (41, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (41, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (42, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (42, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (42, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (43, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (43, 'b', 1, TRUE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (43, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (44, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (44, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (44, 'c', 1, TRUE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (45, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (45, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (45, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (46, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (46, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (46, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (47, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (47, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (47, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (48, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (48, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (48, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (49, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (49, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (49, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (50, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (50, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (50, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (51, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (51, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (51, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (52, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (52, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (52, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (53, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (53, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (53, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (54, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (54, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (54, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (55, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (55, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (55, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (56, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (56, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (56, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (57, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (57, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (57, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (58, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (58, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (58, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (59, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (59, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (59, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (60, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (60, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (60, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (61, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (61, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (61, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (62, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (62, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (62, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (63, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (63, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (63, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (64, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (64, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (64, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (65, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (65, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (65, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (66, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (66, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (66, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (67, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (67, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (67, 'c', 1, FALSE);

INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (68, 'a', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (68, 'b', 1, FALSE);
INSERT INTO `partieCase` (`x`, `y`, `idPartie`, `occupee`) VALUES (68, 'c', 1, FALSE);

