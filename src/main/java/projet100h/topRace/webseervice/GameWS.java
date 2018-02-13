package projet100h.topRace.webseervice;

import com.google.gson.Gson;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/game")
public class GameWS {

    private Gson gsonService = new Gson();

    @POST
    @Path("/test")
    public Response avancer(@FormParam("data") String data){
        System.out.println("avancer with data : "+data);

        int nbCase = Integer.parseInt(data.substring(1, 2));
        String voitureEnCours = data.substring(2);
        String voiture = voitureEnCours.substring(0,voitureEnCours.length()-1);

        if (nbCase == 9){nbCase=10;}

        System.out.println("voiture est "+voiture+" et elle avance de "+nbCase);
        System.out.println();
        /*Joueur joueurADeplacer = DefinirJoueur(voiture);  une fonction qui retourne un Joueur quand
                                                            on lui rentre un String qui est la couleur
        Case caseArrivee = joueurADeplacer.deplacer(nbCase);
        String answer = position(caseArrivee);   une fonction qui retoune un String correspondant aux
                                                 positions en px de la case d'arrivée du déplacement*/
        String answer = "62.5/59"; /* ici on met une valeur par défault en attendant */
        return Response.ok().entity(gsonService.toJson(answer)).build();
    }
}