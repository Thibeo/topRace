function avancer(cse){
    var carte = document.getElementsByClassName('nbCaseDeCase'+cse);
    for (var i =0 ; i<carte.length ; i++){
        console.log("couleur = "+carte[i].innerHTML);
        console.log("nbCase = "+carte[i].getAttribute("value"));

        var postMyOpinionRequest = new XMLHttpRequest();
        postMyOpinionRequest.open("POST","webservice/game",true);
        postMyOpinionRequest.responseType="json";

        postMyOpinionRequest.onload = function() {
            var answer=this.response;
            console.log("answer : "+answer);
        }

        postMyOpinionRequest.send("data="+JSON.stringify(carte[i].getAttribute("value")));

    }

}