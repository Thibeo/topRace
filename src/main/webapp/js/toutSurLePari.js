// fonction pour parier
function parier(idPari){
    console.log("parier("+idPari+")");
    if (idPari>0 && idPari<4) {
        var data = {};
        var request = new XMLHttpRequest();
        request.open("POST", "webservices/game/parier", true);
        request.responseType = "json";
        var jaunne = document.getElementById("jaune" + idPari);
        var bleuue = document.getElementById("bleue" + idPari);
        var roouge = document.getElementById("rouge" + idPari);
        var violettte = document.getElementById("violette" + idPari);
        var blanchee = document.getElementById("blanche" + idPari);
        var verrte = document.getElementById("verte" + idPari);
        request.onload = function () {
            var answer = this.response;
            if (answer == "error102"){
                bulleAlert("veuilliez cocher 3 couleur pour le pari "+idPari);
            } else if (answer == "error103"){
                bulleAlert("le pari "+idPari+" a déjà été effectué");
            } else if (answer = "succeed"){
                // on va fixer les checkbox
                jaunne.disabled = "disabled";
                bleuue.disabled = "disabled";
                roouge.disabled = "disabled";
                violettte.disabled = "disabled";
                blanchee.disabled = "disabled";
                verrte.disabled = "disabled";
                bulleAlert("Le pari "+idPari+" a bien été effectué");
                derniereAction("pari1Effectue");

            }
        }
        var dat = '{"numeroPari":"'+idPari+'","jaune":"'+jaunne.checked+'","bleue":"'+bleuue.checked+'","rouge":"'+roouge.checked+'","violette":"'+violettte.checked+'","blanche":"'+blanchee.checked+'","verte":"'+verrte.checked+'"}';
        data.data= dat;
        data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
        data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
        console.log(data);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.send("data=" + JSON.stringify(data));
        /* et on l'envoit */
    } else {
        console.log("l'idPari n'est pas bon");
    }
}

//verifie si le pari a été envoyé ou pas
function checkPari(idPari){
    console.log("checkPari("+idPari+")");
    if (idPari>0 && idPari<4) {
        var request = new XMLHttpRequest();
        request.open("POST", "webservices/game/checkPari", true);
        request.responseType = "json";
        request.onload = function () {
            var answer = this.response;
            console.log("réponse : "+answer);
            var textFinal = "";
            if (answer == "le pari a bien été envoyé"){
                textFinal = 'Pari '+idPari+' reçu !';
            } else if (answer == "un pari aléatoire a été effectué"){
                textFinal = 'Un pari aléatoire a été éffectué pour le pari '+idPari;
                bulleAlert("Le pari "+idPari+" a été effectué aléatoirement");
            } else {
                textFinal = 'erreur au niveau des paris';
            }
            console.log("je suis le texte final : "+textFinal);
            var eltParent = document.getElementById('navCompteur');
            eltParent.innerHTML=textFinal;
            var newElt = document.createElement("span"); //on crée le span (qui sert de compteur)
            newElt.id = "compteur"; //on met son id
            newElt.innerHTML = "0"; // le temps du compteur
            newElt.style.display = "none";
            eltParent.appendChild(newElt); // le compteur
            clearTimeout(timerr);
            timerr = window.setTimeout("compteur('"+textFinal+"');",2999);
            getPari(idPari);
            derniereAction("pari"+idPari+"Effectue");
        }
        var data = {};
        data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
        data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
        data.data = idPari;
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.send("data=" + JSON.stringify(data));
        /* et on l'envoit */
    } else {
        console.log("l'idPari n'est pas bon");
    }
}

//si le pari a déjà été effectuer, retourne et affiche les selections
function getPari(idPari){
    console.log("getPari("+idPari+")");
    if (idPari>0 && idPari<4) {
        var request = new XMLHttpRequest();
        request.open("POST", "webservices/game/getPari", true);
        request.responseType = "json";
        request.onload = function () {
            var answer = this.response;
            if (answer != "pas de pari effectué") {
                console.log("réponse de getPari(" + idPari + ") = " + answer);
                var couleur1 = "";
                var couleur2 = "";
                var couleur3 = "";
                var i = 0;
                for (var j = 0; j < 3; j++) {
                    while (answer[i] != '-') {
                        if (j == 0) {
                            couleur1 = couleur1 + answer[i];
                        } else if (j == 1) {
                            couleur2 = couleur2 + answer[i];
                        } else if (j == 2) {
                            couleur3 = couleur3 + answer[i];
                        }
                        i = i + 1;
                    }
                    i = i + 1;
                }
                couleur1 = couleur1 + idPari;
                couleur2 = couleur2 + idPari;
                couleur3 = couleur3 + idPari;

                var jaunne = document.getElementById("jaune" + idPari);
                var bleuue = document.getElementById("bleue" + idPari);
                var roouge = document.getElementById("rouge" + idPari);
                var violettte = document.getElementById("violette" + idPari);
                var blanchee = document.getElementById("blanche" + idPari);
                var verrte = document.getElementById("verte" + idPari);

                if (couleur1 == ("jaune" + idPari) || couleur2 == ("jaune" + idPari) || couleur3 == ("jaune" + idPari)) {
                    jaunne.checked = "checked";
                } else {jaunne.checked = "";}

                if (couleur1 == ("bleue" + idPari) || couleur2 == ("bleue" + idPari) || couleur3 == ("bleue" + idPari)) {
                    bleuue.checked = "checked";
                } else {bleuue.checked = "";}

                if (couleur1 == ("rouge" + idPari) || couleur2 == ("rouge" + idPari) || couleur3 == ("rouge" + idPari)) {
                    roouge.checked = "checked";
                } else {roouge.checked = "";}

                if (couleur1 == ("violette" + idPari) || couleur2 == ("violette" + idPari) || couleur3 == ("violette" + idPari)) {
                    violettte.checked = "checked";
                } else {violettte.checked = "";}

                if (couleur1 == ("blanche" + idPari) || couleur2 == ("blanche" + idPari) || couleur3 == ("blanche" + idPari)) {
                    blanchee.checked = "checked";
                } else {blanchee.checked = "";}

                if (couleur1 == ("verte" + idPari) || couleur2 == ("verte" + idPari) || couleur3 == ("verte" + idPari)) {
                    verrte.checked = "checked";
                } else {verrte.checked = "";}

                jaunne.disabled = "disabled";
                bleuue.disabled = "disabled";
                roouge.disabled = "disabled";
                violettte.disabled = "disabled";
                blanchee.disabled = "disabled";
                verrte.disabled = "disabled";

                console.log("couleur1 = " + couleur1 + " // couleur2 = " + couleur2 + " // couleur3 = " + couleur3);
            }else {
                console.log("pas de pari effectuer");
            }
        };
        var data = {};
        data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
        data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
        data.data = idPari;
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.send("data=" + JSON.stringify(data));
        /* et on l'envoit */
    } else {
        console.log("l'idPari n'est pas bon");
    }
}

function bullePari(texte,violet,vert,rouge,jaune,bleu,blanc) {
    if (texte == "fermer"){
        document.getElementById("resultPari").style.display = "none";
        document.getElementById("fondResultPari").style.display = "none";
    } else{
        document.getElementById("VioletPariJoueur").innerHTML = violet;
        document.getElementById("VertPariJoueur").innerHTML = vert;
        document.getElementById("RougePariJoueur").innerHTML = rouge;
        document.getElementById("JaunePariJoueur").innerHTML = jaune;
        document.getElementById("BleuPariJoueur").innerHTML = bleu;
        document.getElementById("BlancPariJoueur").innerHTML = blanc;
        document.getElementById("titreResultPari").innerHTML = texte;
        document.getElementById("resultPari").style.display = "";
        document.getElementById("fondResultPari").style.display = "";
    }
}

function getPariResult(idPari){
    console.log("getResult"+idPari);
    var request = new XMLHttpRequest();
    request.open("POST", "webservices/game/getPariResult", true);
    request.responseType = "json";
    request.onload = function () {
        var answer = this.response;
        var violet = "";
        var vert = "";
        var rouge = "";
        var jaune = "";
        var bleu = "";
        var blanc = "";
        var i = 0;
        for (var j = 0; j < 6; j++) {
            while (answer[i] != '-') {
                if (j == 0) {
                    violet = violet + answer[i];
                } else if (j == 1) {
                    vert = vert + answer[i];
                } else if (j == 2) {
                    rouge = rouge + answer[i];
                } else if (j == 3) {
                    jaune = jaune + answer[i];
                } else if (j == 4) {
                    bleu = bleu + answer[i];
                } else if (j == 5) {
                    blanc = blanc + answer[i];
                }
                i = i + 1;
            }
            i = i + 1;
        }
        bullePari("Voici les résultats du pari "+idPari,violet,vert,rouge,jaune,bleu,blanc);
    }
    var data = {};
    data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
    data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
    data.data = "";
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send("data=" + JSON.stringify(data));
    /* et on l'envoit */
}

// pour eviter qu'on puisse selectionner plus de 3 couleurs
function check(){
    var un = document.querySelectorAll(".pariUn");
    var deux = document.querySelectorAll(".pariDeux");
    var trois = document.querySelectorAll(".pariTrois");

    var i = 0,
        k = 0,
        j = 0;

    for (; i<6; i++){
        un[i].addEventListener("change", function (){
            if (document.querySelectorAll(".pariUn:checked").length > 3){
                this.checked = false;}
        }, false);}

    for (; j<6; j++){
        deux[j].addEventListener("change", function (){
            if (document.querySelectorAll(".pariDeux:checked").length > 3){
                this.checked = false;}
        }, false);}

    for (; k<6; k++){
        trois[k].addEventListener("change", function (){
            if (document.querySelectorAll(".pariTrois:checked").length > 3){
                this.checked = false;}
        }, false);}
}