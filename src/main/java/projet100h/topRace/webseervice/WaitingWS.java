package projet100h.topRace.webseervice;

import com.google.gson.Gson;
import projet100h.topRace.entities.JsonCreatedClass;
import projet100h.topRace.entities.Partie;
import projet100h.topRace.managers.GameLibrary;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/wait")
public class WaitingWS {

    private Gson gsonService = new Gson();

    @POST
    @Path("/charg")
    public Response rechargement(@FormParam("data") String data1){
        int data = Integer.parseInt(data1.substring(1,2));

        String answer;
        String etat="";

        try{
            Partie partie = GameLibrary.getInstance().getPartieById(data);
            etat = partie.getEtat();
            if (!etat.equals("attente") || etat == "attente"){
                answer="start";
            } else{
                answer="wait";
            }
        }catch (Exception e) {
            System.out.println("error116");
            System.out.println();
            answer = "error116";
        }

        return Response.ok().entity(gsonService.toJson(answer)).build();
    }

    @POST
    @Path("/quitt")
    public Response quitter(@FormParam("data") String data1){
        System.out.println("data envoyé dans le GameWS au @Path(\"/getPari\") = "+data1);
        JsonCreatedClass jsooon = gsonService.fromJson(data1, JsonCreatedClass.class);

        // on recupère les variables
        int idPartie = jsooon.getIdPartie();
        String couleurJ = jsooon.getCouleur();

        String answer="";

        try {
            GameLibrary.getInstance().deleteJoueur(couleurJ,idPartie);
            answer = "Le joueur "+couleurJ+" a bien quitter la partie "+String.valueOf(idPartie);
        } catch (Exception e) {
            System.out.println("error115");
            System.out.println();
            answer = "error115";
        }


        System.out.println("réponse retourné après le @Path(\"/charg\") du WaitingWS = "+answer);
        System.out.println();
        return Response.ok().entity(gsonService.toJson(answer)).build();
    }

}