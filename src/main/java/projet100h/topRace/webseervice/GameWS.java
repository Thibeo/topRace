package projet100h.topRace.webseervice;

import com.google.gson.Gson;
import projet100h.topRace.entities.Joueur;
import projet100h.topRace.entities.Partie;
import projet100h.topRace.entities.PartieCase;
import projet100h.topRace.entities.Plateau;
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
        boolean bool = false;
        try {
            int i = Integer.parseInt(data);
            bool=true;
        }
        catch (Exception e) {
            System.out.println("n'est pas un entier");
        }
        System.out.println("bool = "+bool);
        if (bool == true){
            int idCarte = Integer.parseInt(data);
            List listDeplacementCarte = GameLibrary.getInstance().listDeplacementCarte(idCarte);
            String answer = String.valueOf(listDeplacementCarte.size());
            for (int i=0 ; i<listDeplacementCarte.size() ; i++){
                Plateau plateau = GameLibrary.getInstance().getPlateau(1);
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
        } else {
            int fin = data.length();
            int idCarte = Integer.parseInt(data.substring(1,3));
            String couleur = data.substring(3,fin-1);
            System.out.println("la voiture "+couleur+" et l'idCartes "+idCarte);
            if (idCarte == 27 || idCarte == 28 || idCarte == 29){
                String answer = "1";
                Plateau plateau = GameLibrary.getInstance().getPlateau(1);
                Joueur joueurADeplacer = GameLibrary.getInstance().getJoueur(couleur,1);
                PartieCase caseArrivee = joueurADeplacer.deplacer(5, plateau);
                GameLibrary.getInstance().changerCase(joueurADeplacer, caseArrivee);
                String answer2 = GameLibrary.getInstance().getTopLeft(caseArrivee);
                System.out.println(answer2);
                answer = answer + "-" + joueurADeplacer.getCouleur() + "#" + answer2;
                answer=answer+"-";
                System.out.println(answer);
                return Response.ok().entity(gsonService.toJson(answer)).build();
            } else if (idCarte == 31 || idCarte == 32 || idCarte == 33 || idCarte == 34 || idCarte == 35 || idCarte == 36){
                List listDeplacementCarte = GameLibrary.getInstance().listDeplacementCarte(idCarte);
                String answer = "2";
                Plateau plateau = GameLibrary.getInstance().getPlateau(1);
                Joueur joueurADeplacer = GameLibrary.getInstance().getJoueur(couleur,1);
                PartieCase caseArrivee = joueurADeplacer.deplacer(5, plateau);
                GameLibrary.getInstance().changerCase(joueurADeplacer, caseArrivee);
                String answer2 = GameLibrary.getInstance().getTopLeft(caseArrivee);
                System.out.println(answer2);
                answer = answer + "-" + joueurADeplacer.getCouleur() + "#" + answer2;
                // avancer des 2 cases en fonction de l'idCartes
                Plateau plateau2 = GameLibrary.getInstance().getPlateau(1);
                List carte = (List) listDeplacementCarte.get(0);
                String couleur2 = (String) carte.get(1);
                int nbCases = (int) carte.get(0);
                System.out.println("la voiture "+carte.get(1)+" se déplace de "+nbCases+" case(s)");
                Joueur joueurADeplacer2 = GameLibrary.getInstance().getJoueur(couleur2,1);
                System.out.println("couleur du joueur = "+joueurADeplacer2.getCouleur());
                System.out.println("sa case actuelle est : "+joueurADeplacer2.getCaseActuelle().getX()+","+joueurADeplacer2.getCaseActuelle().getY());
                PartieCase caseArrivee2 = joueurADeplacer2.deplacer(nbCases, plateau2);
                System.out.println("caseArrivee = " + caseArrivee2.getX() + "," + caseArrivee2.getY());
                GameLibrary.getInstance().changerCase(joueurADeplacer2, caseArrivee2);
                String answer3 = GameLibrary.getInstance().getTopLeft(caseArrivee2);
                System.out.println(answer3);
                answer = answer + "-" + joueurADeplacer2.getCouleur() + "#" + answer3;

                answer=answer+"-";
                System.out.println(answer);
                return Response.ok().entity(gsonService.toJson(answer)).build();
            } else if (idCarte == 41 || idCarte == 42 || idCarte == 43 || idCarte == 44 || idCarte == 45 || idCarte == 46){
                List listDeplacementCarte = GameLibrary.getInstance().listDeplacementCarte(idCarte);
                String answer = "4";
                // avancer des 6 et 4 cases en fonction de l'idCartes
                for (int i =0; i<2; i++){
                    Plateau plateau2 = GameLibrary.getInstance().getPlateau(1);
                    List carte = (List) listDeplacementCarte.get(i);
                    String couleur2 = (String) carte.get(1);
                    int nbCases = (int) carte.get(0);
                    System.out.println("la voiture "+carte.get(1)+" se déplace de "+nbCases+" case(s)");
                    Joueur joueurADeplacer2 = GameLibrary.getInstance().getJoueur(couleur2,1);
                    System.out.println("couleur du joueur = "+joueurADeplacer2.getCouleur());
                    System.out.println("sa case actuelle est : "+joueurADeplacer2.getCaseActuelle().getX()+","+joueurADeplacer2.getCaseActuelle().getY());
                    PartieCase caseArrivee2 = joueurADeplacer2.deplacer(nbCases, plateau2);
                    System.out.println("caseArrivee = " + caseArrivee2.getX() + "," + caseArrivee2.getY());
                    GameLibrary.getInstance().changerCase(joueurADeplacer2, caseArrivee2);
                    String answer3 = GameLibrary.getInstance().getTopLeft(caseArrivee2);
                    System.out.println(answer3);
                    answer = answer + "-" + joueurADeplacer2.getCouleur() + "#" + answer3;
                }
                // avancé des noirs
                Plateau plateau = GameLibrary.getInstance().getPlateau(1);
                Joueur joueurADeplacer = GameLibrary.getInstance().getJoueur(couleur,1);
                PartieCase caseArrivee = joueurADeplacer.deplacer(2, plateau);
                GameLibrary.getInstance().changerCase(joueurADeplacer, caseArrivee);
                String answer2 = GameLibrary.getInstance().getTopLeft(caseArrivee);
                System.out.println(answer2);
                answer = answer + "-" + joueurADeplacer.getCouleur() + "#" + answer2;
                // avancer des 1 cases en fonction de l'idCartes
                Plateau plateau2 = GameLibrary.getInstance().getPlateau(1);
                List carte = (List) listDeplacementCarte.get(2);
                String couleur2 = (String) carte.get(1);
                int nbCases = (int) carte.get(0);
                System.out.println("la voiture "+carte.get(1)+" se déplace de "+nbCases+" case(s)");
                Joueur joueurADeplacer2 = GameLibrary.getInstance().getJoueur(couleur2,1);
                System.out.println("couleur du joueur = "+joueurADeplacer2.getCouleur());
                System.out.println("sa case actuelle est : "+joueurADeplacer2.getCaseActuelle().getX()+","+joueurADeplacer2.getCaseActuelle().getY());
                PartieCase caseArrivee2 = joueurADeplacer2.deplacer(nbCases, plateau2);
                System.out.println("caseArrivee = " + caseArrivee2.getX() + "," + caseArrivee2.getY());
                GameLibrary.getInstance().changerCase(joueurADeplacer2, caseArrivee2);
                String answer3 = GameLibrary.getInstance().getTopLeft(caseArrivee2);
                System.out.println(answer3);
                answer = answer + "-" + joueurADeplacer2.getCouleur() + "#" + answer3;

                answer=answer+"-";
                System.out.println(answer);
                return Response.ok().entity(gsonService.toJson(answer)).build();
            } else {
                System.out.println("error = idCarte non défini");
                return null;
            }

        }
    }
}