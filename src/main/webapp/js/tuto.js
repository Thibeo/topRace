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
periode = setInterval(clignotement, 500);

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