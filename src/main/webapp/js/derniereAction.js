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
        var topFleche;
        var topCarte;
        if (couleur == "Violet"){
            topFleche = 29.8;
            topCarte = 54.5;
            if (couleur == document.getElementById("couleurJ").innerText ){
                topFleche = topFleche + 0.4;
                topCarte = topCarte + 0.4;
            }
        } else if (couleur == "Vert"){
            topFleche = 35.1;
            topCarte = 26;
            if (couleur == document.getElementById("couleurJ").innerText ){
                topFleche = topFleche + 0.4;
                topCarte = topCarte + 0.4;
            } else if ("Violet" == document.getElementById("couleurJ").innerText ){
                topFleche = topFleche + 0.8;
                topCarte = topCarte + 0.8;
            }
        } else if (couleur == "Rouge"){
            topFleche = 41.1;
            topCarte = 31.6;
            if (couleur == document.getElementById("couleurJ").innerText ){
                topFleche = topFleche + 0.4;
                topCarte = topCarte + 0.4;
            } else if ("Violet" == document.getElementById("couleurJ").innerText ||
                       "Vert" == document.getElementById("couleurJ").innerText){
                topFleche = topFleche + 0.8;
                topCarte = topCarte + 0.8;
            }
        } else if (couleur == "Jaune"){
            topFleche = 46.7;
            topCarte = 37.3;
            if (couleur == document.getElementById("couleurJ").innerText ){
                topFleche = topFleche + 0.4;
                topCarte = topCarte + 0.4;
            } else if ("Violet" == document.getElementById("couleurJ").innerText ||
                       "Vert" == document.getElementById("couleurJ").innerText ||
                       "Rouge" == document.getElementById("couleurJ").innerText){
                topFleche = topFleche + 0.8;
                topCarte = topCarte + 0.8;
            }
        } else if (couleur == "Bleu"){
            topFleche = 52.3;
            topCarte = 43;
            if (couleur == document.getElementById("couleurJ").innerText ){
                topFleche = topFleche + 0.4;
                topCarte = topCarte + 0.4;
            } else if ("Violet" == document.getElementById("couleurJ").innerText ||
                       "Vert" == document.getElementById("couleurJ").innerText ||
                       "Rouge" == document.getElementById("couleurJ").innerText ||
                       "Jaune" == document.getElementById("couleurJ").innerText){
                topFleche = topFleche + 0.8;
                topCarte = topCarte + 0.8;
            }
        } else if (couleur == "Blanc"){
            topFleche = 58;
            topCarte = 48.6;
            if (couleur == document.getElementById("couleurJ").innerText ){
                topFleche = topFleche + 0.4;
                topCarte = topCarte + 0.4;
            } else if ("Violet" == document.getElementById("couleurJ").innerText ||
                       "Vert" == document.getElementById("couleurJ").innerText ||
                       "Rouge" == document.getElementById("couleurJ").innerText ||
                       "Jaune" == document.getElementById("couleurJ").innerText ||
                       "Bleu" == document.getElementById("couleurJ").innerText){
                topFleche = topFleche + 0.8;
                topCarte = topCarte + 0.8;
            }
        }
        var topFlecheString = topFleche.toString()+"vh";
        var topCarteString = topCarte.toString()+"vh";
        document.getElementById("flecheRouge").style.top = topFlecheString;
        document.getElementById("lastCarte").style.top = topCarteString;


    }
    data.data= "";
    data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
    data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send("data=" + JSON.stringify(data));
}