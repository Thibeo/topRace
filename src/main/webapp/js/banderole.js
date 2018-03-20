function compteurPari(){
    var compteur=document.getElementById('compteur');
    s=duree;
    m=0;h=0;
    if(s<0){
        compteur.innerHTML="un pari a été éffectué a votre place";
    } else {
        compteur.innerHTML=s;
    }
    duree=duree-1;
    window.setTimeout("compteurPari();",999);

}