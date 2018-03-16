function AfficherCacher(texte) {
    var test = document.getElementById(texte).style.display;
    if (test == "none") {
        document.getElementById(texte).style.display = "";
    }
    else {
        document.getElementById(texte).style.display = "none";
    }
}

function Cacher(texte) {
    document.getElementById(texte).style.display = "none";
}
function Afficher(texte) {
    document.getElementById(texte).style.display = "block";
}

function ACQuitter(){
    var test = document.getElementById("quitter").style.display;
    if (test == "none") {
        document.getElementById("quitter").style.display = "";
        document.getElementById("fondQuitter").style.display = "";
        quiFaitTout('aRegles','liRegles','Règles',0);
        quiFaitTout('aPara','liPara','Paramètres',0);
    }
    else {
        document.getElementById("quitter").style.display = "none";
        document.getElementById("fondQuitter").style.display = "none";
        quiFaitTout('aRegles','liRegles','Règles',2);
        quiFaitTout('aPara','liPara','Paramètres',1);
    }
}


function ACPara(){
    var test = document.getElementById("para").style.display;
    if (test == "none") {
        document.getElementById("para").style.display = "";
        document.getElementById("fondPara").style.display = "";
        quiFaitTout('aRegles','liRegles','Règles',0);
        quiFaitTout('aQuitter','liQuitter','Quitter',0);
    }
    else {
        document.getElementById("para").style.display = "none";
        document.getElementById("fondPara").style.display = "none";
        quiFaitTout('aRegles','liRegles','Règles',2);
        quiFaitTout('aQuitter','liQuitter','Quitter',3);
    }
}

function ACRules(){
    var test = document.getElementById("rules").style.display;
    if (test == "none") {
        document.getElementById("rules").style.display = "";
        document.getElementById("fondRules").style.display = "";
        quiFaitTout('aPara','liPara','Paramètres',0);
        quiFaitTout('aQuitter','liQuitter','Quitter',0);
    }
    else {
        document.getElementById("rules").style.display = "none";
        document.getElementById("fondRules").style.display = "none";
        quiFaitTout('aPara','liPara','Paramètres',1);
        quiFaitTout('aQuitter','liQuitter','Quitter',3);
    }
}

function quiFaitTout(supp,remp,text,nombre){
    var aSupprimer = document.getElementById(supp);
    aSupprimer.parentNode.removeChild(aSupprimer);
    var aRemplacer = document.getElementById(remp);
    var newLien = document.createElement('a');
    var newLienText = document.createTextNode(text);
    newLien.id = supp;
    newLien.href = '#';
    if (nombre == 1) {newLien.onclick = function() {Cacher("rules");ACPara();Cacher("quitter");};}
    if (nombre == 2) {newLien.onclick = function() {Cacher("para");ACRules();Cacher("quitter");};}
    if (nombre == 3) {newLien.onclick = function() {Cacher("para");ACQuitter();Cacher("rules");};}
    newLien.appendChild(newLienText);
    aRemplacer.appendChild(newLien);
    return(newLien);
}
