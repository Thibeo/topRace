DELETE FROM typeVoiture;
DELETE FROM carte;
DELETE FROM nbCase;
DELETE FROM cse;
DELETE FROM partieCase;
DELETE FROM partie;
DELETE FROM joueur;

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (7,'a',false,64,56.5);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (7,'b',false,67.2,56.5);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (7,'c',false,0,0);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (6,'a',false,62.5,62);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (6,'b',false,65,62);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (6,'c',false,67.5,62);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (5,'a',false,62.5,67.5);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (5,'b',false,65,67.5);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (5,'c',false,67.5,67.5);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (4,'a',false,62.5,72.5);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (4,'b',false,65,72.5);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (4,'c',false,67.5,72.5);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (3,'a',false,62.5,78);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (3,'b',false,65,78);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (3,'c',false,67.5,78);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (2,'a',false,62.5,82.9);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (2,'b',false,65,82.9);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (2,'c',false,67.5,82.9);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (1,'a',true,62.5,89);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (1,'b',true,65,89);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (1,'c',true,67.5,89);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (0,'a',true,62.5,94);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (0,'b',true,65,94);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (0,'c',true,67.5,94);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (66,'a',true,62.5,89);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (66,'b',true,65,89);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (66,'c',true,67.5,89);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (65,'a',true,62.5,94);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (65,'b',true,65,94);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (65,'c',true,67.5,94);

INSERT INTO `typeVoiture` (`couleurV`) VALUES ("Jaune");
INSERT INTO `typeVoiture` (`couleurV`) VALUES ("Rouge");
INSERT INTO `typeVoiture` (`couleurV`) VALUES ("Violet");
INSERT INTO `typeVoiture` (`couleurV`) VALUES ("Bleu");
INSERT INTO `typeVoiture` (`couleurV`) VALUES ("Vert");
INSERT INTO `typeVoiture` (`couleurV`) VALUES ("Blanc");

INSERT INTO `partie` (`idPartie`, `nomDePartie`) VALUES (1, 'partie1test');

INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`) VALUES ("Jaune", "BobJaune", 1, 1, 'a');
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`) VALUES ("Vert", "BobVert", 1, 1, 'b');
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`) VALUES ("Violet", "BobViolet", 1, 1, 'c');
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`) VALUES ("Bleu", "BobBleu", 1, 0, 'a');
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`) VALUES ("Blanc", "BobBlanc", 1, 0, 'b');
INSERT INTO `joueur` (`couleurJ`, `nomDeJoueur`, `idPartie`, `x`, `y`) VALUES ("Rouge", "BobRouge", 1, 0, 'c');

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


INSERT INTO `carte` (`idCarte`) VALUES (1); /* booster */
INSERT INTO `carte` (`idCarte`) VALUES (2); /* booster */
INSERT INTO `carte` (`idCarte`) VALUES (3); /* booster */
INSERT INTO `carte` (`idCarte`) VALUES (4); /* booster */
INSERT INTO `carte` (`idCarte`) VALUES (5); /* booster */
INSERT INTO `carte` (`idCarte`) VALUES (6); /* booster */
INSERT INTO `carte` (`idCarte`) VALUES (7);
INSERT INTO `carte` (`idCarte`) VALUES (8);
INSERT INTO `carte` (`idCarte`) VALUES (9);
INSERT INTO `carte` (`idCarte`) VALUES (10);
INSERT INTO `carte` (`idCarte`) VALUES (11);
INSERT INTO `carte` (`idCarte`) VALUES (12);
INSERT INTO `carte` (`idCarte`) VALUES (13);
INSERT INTO `carte` (`idCarte`) VALUES (14);
INSERT INTO `carte` (`idCarte`) VALUES (15);
INSERT INTO `carte` (`idCarte`) VALUES (16);
INSERT INTO `carte` (`idCarte`) VALUES (17);
INSERT INTO `carte` (`idCarte`) VALUES (18);
INSERT INTO `carte` (`idCarte`) VALUES (19);
INSERT INTO `carte` (`idCarte`) VALUES (20);

/* booster */
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Jaune",1,10);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Rouge",2,10);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Violet",3,10);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Bleu",4,10);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Vert",5,10);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Blanc",6,10);
/* 5 - 2 */
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Jaune",7,5);
INSERT INTO `nbCase` (`couleurV`, `idCarte`, `nbCase`) VALUES ("Violet",7,2);
