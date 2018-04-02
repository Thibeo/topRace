function compteur(textFinal){
    var compteur=document.getElementById('compteur');
    var s = parseInt( compteur.innerText || compteur.textContent );
    console.log("durée = "+s);
    console.log(compteur);
    s = s-1 ;
    if(s == 0 ){
        if (textFinal == 'début de la partie' ){
            Cacher('compteurInclicable');
            console.log("je suis le texte final : "+textFinal);
            var eltParent = document.getElementById('navCompteur');
            eltParent.innerHTML=textFinal;
            var newElt = document.createElement("span"); //on crée le span (qui sert de compteur)
            newElt.id = "compteur"; //on met son id
            newElt.innerHTML = s.toString(); // le temps du compteur
            newElt.style.display = "none";
            eltParent.appendChild(newElt); // le compteur
            window.setTimeout("compteur('"+textFinal+"');",2999);
        } else if (textFinal == 'Pari envoyé !'){
            checkPari(1);
        }
    } else if (s == -1 ){
        document.getElementById('navCompteur').innerHTML="";
        document.getElementById('navCompteur').style.display="none";
        if (textFinal == 'début de la partie' ){
            creationCompteur('Vous avez ', 31, ' secondes pour valider votre 1er pari');
            document.getElementById("btnPari1").onclick = function(){parier(1);};
            window.setTimeout("compteur('Pari envoyé !');",999);
            fermerTuto();
        }
    } else { // on diminue le compteur
        compteur.innerHTML=s;
        window.setTimeout("compteur('"+textFinal+"');",999);
    }
}

function creationCompteur(texte1, temps, texte2) {
    var eltParent = document.getElementById('navCompteur');
    eltParent.style.display="block";
    eltParent.innerHTML = ""; // on vide la div parent
    var newElt = document.createElement("span"); //on crée le span (qui sert de compteur)
    newElt.id = "compteur"; //on met son id
    newElt.innerHTML = temps.toString(); // le temps du compteur
    eltParent.appendChild(document.createTextNode(texte1)); // le texte qui apparait avnt le compteur
    eltParent.appendChild(newElt); // le compteur
    eltParent.appendChild(document.createTextNode(texte2)); // le texte qui apparait après le compteur
    console.log(eltParent);
}