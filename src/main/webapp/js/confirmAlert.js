function bulleAlert(texte) {
    console.log("bulleAlert("+texte+")");
    if (texte == "fermer"){
        document.getElementById("bulleAlert").style.display = "none";
        document.getElementById("fondbulleAlert").style.display = "none";
    } else{
        document.getElementById("bulleAlertTexte").innerHTML = texte;
        document.getElementById("bulleAlert").style.display = "";
        document.getElementById("fondbulleAlert").style.display = "";
    }
}


function ConfirmChoixCartes(cse){
    console.log("ConfirmChoixCartes("+cse+")");
    if (cse == "fermer"){
        document.getElementById("fondConfirmChoixCartes").style.display = "none";
        document.getElementById("confirmChoixCartes").style.display = "none";
    } else{
        var bkgd = "url(img/cartes/"+cse+".png)";
        document.getElementById("idConfirmChoixCartes").innerHTML = cse;
        document.getElementById("laCarteConfirm").style.backgroundImage = bkgd;
        document.getElementById("fondConfirmChoixCartes").style.display = "";
        document.getElementById("confirmChoixCartes").style.display = "";
    }
}


function suiteDeChoixCarte() {
    console.log("suiteDeChoixCarte");
    var cse = document.getElementById("idConfirmChoixCartes").innerHTML || document.getElementById("idConfirmChoixCartes").textContent;
    if (cse != 61 && cse != 62 && cse != 63 && cse != 64 && cse != 65 && cse != 66 && cse != 31 && cse != 32 && cse != 33 && cse != 34 && cse != 35 && cse != 36
        && cse != 41 && cse != 42 && cse != 43 && cse != 44 && cse != 45 && cse != 46) {
        var eltParent = document.getElementById('navCompteur');
        eltParent.innerHTML='Carte jouée';
        var newElt = document.createElement("span"); //on crée le span (qui sert de compteur)
        newElt.id = "compteur"; //on met son id
        newElt.innerHTML = "0"; // le temps du compteur
        newElt.style.display = "none";
        eltParent.appendChild(newElt); // le compteur
        console.log(" je suis lancé depuis suiteDeChoixCarte");
        window.setTimeout("compteur('" + 'Carte jouée' + "');", 2999);
        disableCarte();
        derniereAction("carte"+cse);
        document.getElementById('carte'+cse).style.display = "none";
        avancer(cse);
        changeEtat("rien");

    }else{
        avancer(cse);
    }
}