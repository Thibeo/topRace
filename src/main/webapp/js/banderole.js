function compteur(textFinal){
    var compteur=document.getElementById('compteur');
    var s = parseInt( compteur.innerText || compteur.textContent ); // on récupère la valeur du compteur et on la transforme en int
    s = (s-1) ; // on diminue le compteur de 1
    console.log("compteur("+textFinal+") :: durée = "+s);
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
            checkPari(1); // si le pari est le 1er pari, on applique la fonction check pari 1
        } else if (textFinal == 'A vous de jouer'){
            var eltParent = document.getElementById('navCompteur'); // puis on va modifier tout le compteur pour afficher le texte
            eltParent.innerHTML=textFinal;
            var newElt = document.createElement("span"); //on crée le span (qui sert de compteur)
            newElt.id = "compteur"; //on met son id
            newElt.innerHTML = s.toString(); // le temps du compteur
            newElt.style.display = "none"; // on le cache
            eltParent.appendChild(newElt); // le compteur
            enableCarte();
            window.setTimeout("compteur('"+textFinal+"');",2999);
        } else if (textFinal == 'Carte jouée'){
            var eltParent = document.getElementById('navCompteur'); // puis on va modifier tout le compteur pour afficher le texte
            eltParent.innerHTML='Une carte aléatoire a été jouée';
            //créer un fonction pour jouer une carte aléatoirement
            var newElt = document.createElement("span"); //on crée le span (qui sert de compteur)
            newElt.id = "compteur"; //on met son id
            newElt.innerHTML = s.toString(); // le temps du compteur
            newElt.style.display = "none"; // on le cache
            eltParent.appendChild(newElt); // le compteur
            window.setTimeout("compteur('"+'Une carte aléatoire a été jouée'+"');",2999);
            Cacher("choixCartes");
            Cacher("fondChoixCartes");
            ConfirmChoixCartes("fermer");
            changeEtat("rien");
            console.log("je suis ligne 45");
        }
    } else if (s == -1 ){
        document.getElementById('navCompteur').innerHTML=""; //on vide l'élément nav compteur
        document.getElementById('navCompteur').style.display="none"; // on le cache
        if (textFinal == 'début de la partie' ){ // si le texte est 'début de la partie'
            changeEtat("premierPari");
            creationCompteur('Vous avez ', 31, ' secondes pour valider votre 1er pari');// on va créer un nouveau compteur
            document.getElementById("btnPari1").onclick = function(){parier(1);}; // on va permettre a l'utilisateur de parier
            window.setTimeout("compteur('Pari 1 envoyé !');",999); // on lance le compteur
            disableCarte();
            fermerTuto(); // et on ferme le tutoriel si il est encore ouvert
        }else if (textFinal == 'A vous de jouer'){
            avancer(0);
            getFleche();
            creationCompteur('Vous avez ', 31, ' secondes pour jouer une carte');// on va créer un nouveau compteur
            window.setTimeout("compteur('Carte jouée');",999); // on lance le compteur
            console.log("je suis ligne 72");
        } else if (textFinal == 'Pari 1 reçu !' || textFinal == 'Un pari aléatoire a été éffectué pour le pari 1' ||
            textFinal == 'Pari 2 reçu !' || textFinal == 'Un pari aléatoire a été éffectué pour le pari 2' ||
            textFinal == 'Pari 3 reçu !' || textFinal == 'Un pari aléatoire a été éffectué pour le pari 3' ||
            textFinal=='Carte jouée' || textFinal=='Une carte aléatoire a été jouée'){
            if (textFinal == 'Pari 1 reçu !' || textFinal == 'Un pari aléatoire a été éffectué pour le pari 1'){
                changeEtat("joueurBleu");
                document.getElementById("btnPari1").onclick = function(){console.log('coucou je suis plus là');};
            }
            bulleAlert("fermer");
            creationCompteur('En attente de votre tour', 999, '');// on va créer un nouveau compteur
            //document.getElementById("compteur").style.position = "fixed";
            //document.getElementById("compteur").style.top= "40vh";
            window.setTimeout("compteur('A vous de jouer');",999); // on lance le compteur
            console.log("je suis ligne 72");
        }
    } else {
        if (s>=3){ // si le temps restant est supperieur a 4 secondes
            if (textFinal == 'début de la partie' ){
                ActionFinie("fermerTuto",'début de la partie');
            } else if (textFinal == 'Pari 1 envoyé !'){
                ActionFinie("pari1Effectue",'Pari 1 envoyé !');
            } else if (textFinal == 'A vous de jouer'){
                if (s%5 == 0 ){
                    avancer(0);
                    getEtat();
                    getFleche();
                } else if (s== 997){
                    avancer(0);
                    getEtat();
                    getFleche();
                }
            }
        }
        compteur.innerHTML=s;
        if (textFinal == 'Carte jouée' && s >= 100){

        }else{
            window.setTimeout("compteur('"+textFinal+"');",999);
            console.log("je suis ligne 90");
        }
    }
}

function creationCompteur(texte1, temps, texte2) {
    console.log("creationCompteur("+texte1+","+temps+","+texte2+")");
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

function disableCarte() {
    console.log("disableCarte");
    var ligneCartes = document.getElementById('ligneCartes');
    ligneCartes.style.pointerEvents = 'none';

}
function enableCarte() {
    console.log("enableCarte");
    var ligneCartes = document.getElementById('ligneCartes');
        ligneCartes.style.pointerEvents = 'auto';
}