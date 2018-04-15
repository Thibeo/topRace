function derniereAction(txt) {
    console.log("derniereAction("+txt+")");
    var data = {};
    var request = new XMLHttpRequest();
    request.open("POST", "webservices/game/lastAct", true);
    request.responseType = "json";
    request.onload = function () {
        var answer = this.response;
        console.log(answer+" à mettre l'état "+txt);
    }
    data.data= txt;
    data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
    data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
    console.log('derniereAction avec data = '+data);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send("data=" + JSON.stringify(data));
}

function ActionFinie(txt, texteFinal) {
    console.log("ActionFinie("+txt+","+texteFinal+")");
    var data = {};
    var request = new XMLHttpRequest();
    request.open("POST", "webservices/game/finishAct", true);
    request.responseType = "json";
    request.onload = function () {
        var answer = this.response;
        console.log(answer);
        if (answer == "true"){
            if (texteFinal == 'début de la partie' || texteFinal == 'Pari 1 envoyé !' || texteFinal == 'Pari 2 envoyé !' || texteFinal == 'Pari 3 envoyé !'){
                document.getElementById('compteur').innerHTML=1;
            }
        }
    }
    data.data= txt;
    data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
    data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send("data=" + JSON.stringify(data));
}

function getEtat() {
    var data = {};
    var request = new XMLHttpRequest();
    request.open("POST", "webservices/game/getEtat", true);
    request.responseType = "json";
    request.onload = function () {
        var answer = this.response;
        console.log("getEtat = "+answer);
        if (answer == "true"){
            document.getElementById('compteur').innerHTML=1;
        } else if (answer == "ligneJaune1" || answer == "ligneJaune2" || answer == "ligneJaune3" ){
            var idPari = answer.substr(10);
            console.log("idPari gâce au substr = "+idPari);
            clearTimeout(timerr);
            creationCompteur('La ligne Jaune n° '+idPari+' à été dépassé !', 10, '');// on va créer un nouveau compteur
            document.getElementById("compteur").style.position = "fixed";
            document.getElementById("compteur").style.top= "-40vh";
            disableCarte();
            getPariResult(idPari);
            if (idPari == '1'){
                timerr = window.setTimeout("compteur('Maintenant il faut effectuer le pari 2');",999); // on lance le compteur
            }else if (idPari == '2'){
                timerr = window.setTimeout("compteur('Maintenant il faut effectuer le pari 3');",999); // on lance le compteur
            } else if (idPari == '3'){
                timerr = window.setTimeout("compteur('Maintenant, chacun pour sois');",999); // on lance le compteur
            }
        } else if (answer == 'ligneFinale'){
            console.log('answer == ligneFinale');
            clearTimeout(timerr);
            getPariResult("finale");
            creationCompteur('Fin','','');// on va créer un nouveau compteur
            document.getElementById("btnImpression").style.display = 'block';
            document.getElementById("btnImpression").style.marginTop = '3vh';
            document.getElementById("btnImpression").style.marginLeft = '10vh';
            document.getElementById("impressionFermer").onclick = function(){ Afficher('compteurInclicable');bullePari('fermer','','','','','','');};
            document.getElementById("fondResultPari").onclick = function(){ Afficher('compteurInclicable');bullePari('fermer','','','','','','');};
        }
    }
    data.data= "";
    data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
    data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send("data=" + JSON.stringify(data));
}

function changeEtat(text) {
    console.log("changeEtat("+text+")");
    var data = {};
    var request = new XMLHttpRequest();
    request.open("POST", "webservices/game/changeEtat", true);
    request.responseType = "json";
    request.onload = function () {
        var answer = this.response;
        console.log(answer+" de changer l'état de la partie");
    }
    data.data= text;
    data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
    data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send("data=" + JSON.stringify(data));
}

function getFleche() {
    var data = {};
    var request = new XMLHttpRequest();
    request.open("POST", "webservices/game/getFleche", true);
    request.responseType = "json";
    request.onload = function () {
        var answer = this.response;
        console.log(answer);
        var couleur = "";
        var idCarte = "";
        var i = 0;
        for (var j = 0; j < 2; j++) {
            while (answer[i] != '-') {
                if (j == 0) {
                    couleur = couleur + answer[i];
                } else if (j == 1) {
                    idCarte = idCarte + answer[i];
                }
                i = i + 1;
            }
            i = i + 1;
        }
        console.log("couleur = "+couleur);
        console.log("idCare = "+idCarte);
        if (idCarte != 'Effectue'){
            var bkgd = "url(img/cartes/"+idCarte+".png)";
            document.getElementById("lastCarte").style.backgroundImage = bkgd;
        }
        if (couleur == "Violet"){
            document.getElementById("flecheRouge").style.top = "29.8vh";
            document.getElementById("lastCarte").style.top = "54.5vh";
        } else if (couleur == "Vert"){
            document.getElementById("flecheRouge").style.top = "36vh";
            document.getElementById("lastCarte").style.top = "26vh";
        } else if (couleur == "Rouge"){
            document.getElementById("flecheRouge").style.top = "42.1vh";
            document.getElementById("lastCarte").style.top = "31.6vh";
        } else if (couleur == "Jaune"){
            document.getElementById("flecheRouge").style.top = "47.7vh";
            document.getElementById("lastCarte").style.top = "37.3vh";
        } else if (couleur == "Bleu"){
            document.getElementById("flecheRouge").style.top = "53.3vh";
            document.getElementById("lastCarte").style.top = "43vh";
        } else if (couleur == "Blanc"){
            document.getElementById("flecheRouge").style.top = "59vh";
            document.getElementById("lastCarte").style.top = "48.6vh";
        }


    }
    data.data= "";
    data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
    data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send("data=" + JSON.stringify(data));
}