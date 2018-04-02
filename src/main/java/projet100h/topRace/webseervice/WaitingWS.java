package projet100h.topRace.webseervice;

import com.google.gson.Gson;
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
        System.out.println("data envoyé dans le WaitingWS au @Path(\"/charg\") = "+data1);
        int data = Integer.parseInt(data1.substring(1,2));

        Partie partie = GameLibrary.getInstance().getPartieById(data);
        int etat = partie.getEtat();
        String answer;

        if (etat !=0){
            answer="start";
        } else{
            answer="wait";
        }

        System.out.println("réponse retourné après le @Path(\"/charg\") du WaitingWS = "+answer);
        System.out.println();
        return Response.ok().entity(gsonService.toJson(answer)).build();
    }
}