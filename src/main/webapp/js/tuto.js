function fermerTableau() {
    if (document.getElementById("titreCol0").style.display != "none"){
        inverse('tb', 'col0');
        inverse('tb', 'col6');
        inverse('tb', 'col3');
    }
    if (document.getElementById("titreCol1").style.display != "none"){
        inverse('tb', 'col1');
        inverse('tb', 'col7');
        inverse('tb', 'col4');
    }
    if (document.getElementById("titreCol2").style.display != "none"){
        inverse('tb', 'col2');
        inverse('tb', 'col8');
        inverse('tb', 'col5');
    }
}

function ouvrirTableau() {
    if (document.getElementById("titreCol0").style.display != ""){
        inverse('tb', 'col0');
        inverse('tb', 'col6');
        inverse('tb', 'col3');
    }
    if (document.getElementById("titreCol1").style.display != ""){
        inverse('tb', 'col1');
        inverse('tb', 'col7');
        inverse('tb', 'col4');
    }
    if (document.getElementById("titreCol2").style.display != ""){
        inverse('tb', 'col2');
        inverse('tb', 'col8');
        inverse('tb', 'col5');
    }
}


var clignotement = function(){
    if (document.getElementById('ligneJaune').style.visibility=='visible'){
        document.getElementById('ligneJaune').style.visibility='hidden';
    }
    else{
        document.getElementById('ligneJaune').style.visibility='visible';
    }
};
periode = 0;

function zindex(id,index){
    if (id == 'col0'){
        document.getElementsByTagName(id).style.zIndex = index;
    } else{
        document.getElementById(id).style.zIndex = index;
    }
}

function animationPariEntree() {
    document.getElementById("rouge1").checked = true;
    document.getElementById("jaune1").checked = true;
    document.getElementById("violette1").checked = true;
    zindex("joueurJaune",100001);
    zindex("joueurViolet",100001);
    zindex("joueurRouge",100001);
}

function animationPariSortie() {
    document.getElementById("rouge1").checked = false;
    document.getElementById("jaune1").checked = false;
    document.getElementById("violette1").checked = false;
    zindex("joueurJaune",1);
    zindex("joueurViolet",1);
    zindex("joueurRouge",1);
}

function fermerTuto() {
    Afficher("tutoNomPartieJoueurs");Afficher("tutoPari1");
    Cacher("fondTuto");Cacher("tutoInclicable");Cacher("fondTuto1");Cacher("fondTuto2");
    Cacher("tutoPrez");
    Cacher("tutoTouSElmt");Cacher("tutoPlateau");Cacher("tutoCarte");
    Cacher("tutoParis");Cacher("tutoPari2");Cacher("tutoPari3");
    Cacher("ligneJaune");
    zindex("plateauParis",1);
    zindex("ligneJaune",-10);
    zindex("nomPartie",1);zindex("joueurs",1);zindex("plateau",0);
    zindex("ligneCartes",1);zindex("carteTitre",2);zindex("carreHaut",2);zindex("carreBas",2);
    zindex("joueurJaune",1);zindex("joueurViolet",1);zindex("joueurBleu",1);
    zindex("joueurRouge",1);zindex("joueurBlanc",1);zindex("joueurVert",1);
    fermerTableau();animationPariSortie();
}

function ouvrirTuto() {
    Cacher('tutoTouSElmt');Cacher('tutoPlateau');
    Cacher('tutoParis');Cacher('tutoPari2');
    Cacher('tutoPari3');Cacher('ligneJaune');
    Cacher('fondTuto1');Cacher('fondTuto2');
    Afficher('fondTuto');Afficher('tutoPrez');Afficher("tutoInclicable");
    zindex('joueurJaune',1);
    zindex('joueurViolet',1);
    zindex('joueurBleu',1);
    zindex('joueurRouge',1);
    zindex('joueurBlanc',1);
    zindex('joueurVert',1);
    fermerTableau();
}