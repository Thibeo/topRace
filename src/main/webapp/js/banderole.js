function compteur(textFinal){
    var compteur=document.getElementById('compteur');
    var s = parseInt( compteur.innerText || compteur.textContent );
    console.log("durée = "+s);
    console.log(compteur);
    s = s-1 ;
    if(s == 0 ){
        console.log(textFinal);
        var eltParent = document.getElementById('navCompteur');
        eltParent.innerHTML=textFinal;
        var newElt = document.createElement("span"); //on crée le span (qui sert de compteur)
        newElt.id = "compteur"; //on met son id
        newElt.innerHTML = s.toString(); // le temps du compteur
        newElt.style.display = "none";
        eltParent.appendChild(newElt); // le compteur
        if (textFinal == 'début de la partie' ){
            Cacher('compteurInclicable');
        }
        window.setTimeout("compteur('"+textFinal+"');",2999);
    } else if (s == -1 ){
        document.getElementById('navCompteur').innerHTML="";
        document.getElementById('navCompteur').style.display="none";
        fermerTuto();
    } else {
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

/*

    var eltParent = document.createElement('navCompteur');
    eltParent.style.position = "fixed";
    eltParent.style.top = "9vh";
    eltParent.style.left = "50%";
    eltParent.style.transform = "translate(-50%, 0)";
    eltParent.style.backgroundColor = "#9E9E9E";
    eltParent.style.borderRadius = "1vh";
    eltParent.style.border = "0.4vh solid red";
    eltParent.style.padding = "0.5vh";
    eltParent.style.zIndex = "120";
 */