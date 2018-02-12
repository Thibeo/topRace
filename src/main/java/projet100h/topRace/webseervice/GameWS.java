package projet100h.topRace.webseervice;



import com.google.gson.Gson;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/game")
public class GameWS {

    @POST
    public Response postMyOpinion(@FormParam("data") int compteur){
        Gson gson = new Gson();
        
        int compteur1= compteur+1;
        String compteur1Json =gson.toJson(compteur1);
        System.out.println("compteur" +compteur1Json);
        return Response.status(200).entity(compteur1Json).build();
    }

}
