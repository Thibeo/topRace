DELETE FROM typeVoiture;
DELETE FROM carte;
DELETE FROM nbCase;
DELETE FROM cse;

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (4,'a',false,62.5,59);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (4,'b',false,65,59);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (4,'c',false,67.5,59);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (3,'a',false,62.5,64);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (3,'b',false,65,64);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (3,'c',false,67.5,64);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (2,'a',false,62.5,79);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (2,'b',false,65,79);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (2,'c',false,67.5,79);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (1,'a',false,62.5,84);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (1,'b',false,65,84);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (1,'c',false,67.5,84);

INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (0,'a',false,62.5,84);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (0,'b',false,65,84);
INSERT INTO `cse` (`x`,`y`,`occupee`,`top`,`left`) VALUES (0,'c',false,67.5,84);

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
