function compteur(textFinal){
    var compteur=document.getElementById('compteur');
    var s = parseInt( compteur.innerText || compteur.textContent ); // on récupère la valeur du compteur et on la transforme en int
    console.log("durée = "+s);
    s = (s-1) ; // on diminue le compteur de 1
    if(s == 0 ){
        console.log("ou je suis");// si le compteur = 0
        if (textFinal == 'début de la partie' ){ // si le texte final est 'début de partie'
            Cacher('compteurInclicable'); // on va enlever l'incliquabilité du site
            console.log("je suis le texte final : "+textFinal);
            var eltParent = document.getElementById('navCompteur'); // puis on va modifier tout le compteur pour afficher le texte
            eltParent.innerHTML=textFinal;
            var newElt = document.createElement("span"); //on crée le span (qui sert de compteur)
            newElt.id = "compteur"; //on met son id
            newElt.innerHTML = s.toString(); // le temps du compteur
            newElt.style.display = "none"; // on le cache
            eltParent.appendChild(newElt); // le compteur
            window.setTimeout("compteur('"+textFinal+"');",2999);
        } else if (textFinal == 'Pari 1 envoyé !'){
            checkPari(1); // si le pari est le 1er pari, on applique la fonction check pari
        }
    } else if (s == -1 ){
        console.log("si je suis la"); // si le compteur = -1
        document.getElementById('navCompteur').innerHTML=""; //on vide l'élément nav compteur
        document.getElementById('navCompteur').style.display="none"; // on le cache
        if (textFinal == 'début de la partie' ){ // si le texte est 'début de la partie'
            creationCompteur('Vous avez ', 31, ' secondes pour valider votre 1er pari');// on va créer un nouveau compteur
            document.getElementById("btnPari1").onclick = function(){parier(1);}; // on va permettre a l'utilisateur de parier
            window.setTimeout("compteur('Pari 1 envoyé !');",999); // on lance le compteur
            fermerTuto(); // et on ferme le tutoriel si il est encore ouvert
        }
    } else {
        if (s>=3){ // si le temps restant est supperieur a 4 secondes
            if (textFinal == 'début de la partie' ){
                ActionFinie("fermerTuto",'début de la partie');
            }
        }
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