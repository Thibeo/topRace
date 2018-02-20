package projet100h.topRace.webseervice;

import com.google.gson.Gson;
import projet100h.topRace.entities.Joueur;
import projet100h.topRace.entities.Partie;
import projet100h.topRace.entities.PartieCase;
import projet100h.topRace.managers.GameLibrary;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/game")
public class GameWS {

    private Gson gsonService = new Gson();

    @POST
    @Path("/test")
    public Response avancer(@FormParam("data") String data){
        System.out.println("idCarte = "+data);

        int idCarte = Integer.parseInt(data);
        Partie plateau = GameLibrary.getInstance().getPlateau(1);
        List listDeplacementCarte = GameLibrary.getInstance().listDeplacementCarte(idCarte);
        for (int i=0 ; i<listDeplacementCarte.size() ; i++){
            List carte = (List) listDeplacementCarte.get(i);
            String couleur = (String) carte.get(1);
            System.out.println("la voiture "+carte.get(1)+" se déplace de "+carte.get(0)+" case(s)");
            Joueur joueurADeplacer = GameLibrary.getInstance().getJoueur(couleur,1);
            System.out.println("couleur du joueur = "+joueurADeplacer.getCouleur());
            System.out.println("sa case actuelle est : "+joueurADeplacer.getCaseActuelle().getX()+","+joueurADeplacer.getCaseActuelle().getY());
            PartieCase caseArrivee = joueurADeplacer.deplacer((Integer) carte.get(0), plateau);
            System.out.println("caseArrivee = "+caseArrivee.getX()+","+caseArrivee.getY());
    }

        /*
        Case caseArrivee = joueurADeplacer.deplacer(nbCase);
        String answer = position(caseArrivee);   une fonction qui retoune un String correspondant aux
                                                 positions en px de la case d'arrivée du déplacement*/
        String answer = "62.5/59"; /* ici on met une valeur par défault en attendant */
        return Response.ok().entity(gsonService.toJson(answer)).build();
    }
}