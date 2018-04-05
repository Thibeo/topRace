function derniereAction(txt) {
    var data = {};
    var request = new XMLHttpRequest();
    request.open("POST", "webservices/game/lastAct", true);
    request.responseType = "json";
    request.onload = function () {
        var answer = this.response;
        console.log(answer+" = to change derniereAction");
    }
    data.data= txt;
    data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
    data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
    console.log('derniereAction avec data = '+data);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send("data=" + JSON.stringify(data));
}

function ActionFinie(txt, texteFinal) {
    var data = {};
    var request = new XMLHttpRequest();
    request.open("POST", "webservices/game/finishAct", true);
    request.responseType = "json";
    request.onload = function () {
        var answer = this.response;
        console.log(answer);
        if (answer == "true"){
            if (texteFinal == 'début de la partie'){
                document.getElementById('compteur').innerHTML=1;
            }
        }
    }
    data.data= txt;
    data.couleurJ = document.getElementById("couleurJ").innerText || document.getElementById("couleurJ").textContent;
    data.idPartie = document.getElementById("idPartie").innerText || document.getElementById("idPartie").textContent;
    console.log(data);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send("data=" + JSON.stringify(data));
}
