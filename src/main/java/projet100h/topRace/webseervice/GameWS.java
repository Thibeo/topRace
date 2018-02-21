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
        List listDeplacementCarte = GameLibrary.getInstance().listDeplacementCarte(idCarte);
        String answer = String.valueOf(listDeplacementCarte.size());
        for (int i=0 ; i<listDeplacementCarte.size() ; i++){
            Partie plateau = GameLibrary.getInstance().getPlateau(1);
            List carte = (List) listDeplacementCarte.get(i);
            String couleur = (String) carte.get(1);
            int nbCases = (int) carte.get(0);
            System.out.println("la voiture "+carte.get(1)+" se déplace de "+nbCases+" case(s)");
            Joueur joueurADeplacer = GameLibrary.getInstance().getJoueur(couleur,1);
            System.out.println("couleur du joueur = "+joueurADeplacer.getCouleur());
            System.out.println("sa case actuelle est : "+joueurADeplacer.getCaseActuelle().getX()+","+joueurADeplacer.getCaseActuelle().getY());
            if (idCarte==0){
                String answer2 = GameLibrary.getInstance().getTopLeft(joueurADeplacer.getCaseActuelle());
                System.out.println(answer2);
                answer=answer+"-"+joueurADeplacer.getCouleur()+"#"+answer2;
            } else {
                PartieCase caseArrivee = joueurADeplacer.deplacer(nbCases, plateau);
                System.out.println("caseArrivee = " + caseArrivee.getX() + "," + caseArrivee.getY());
                GameLibrary.getInstance().changerCase(joueurADeplacer, caseArrivee);
                String answer2 = GameLibrary.getInstance().getTopLeft(caseArrivee);
                System.out.println(answer2);
                answer = answer + "-" + joueurADeplacer.getCouleur() + "#" + answer2;
            }
        }
        answer=answer+"-";
        System.out.println(answer);
        return Response.ok().entity(gsonService.toJson(answer)).build();
    }
}