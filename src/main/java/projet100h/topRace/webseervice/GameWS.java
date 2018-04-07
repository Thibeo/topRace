package projet100h.topRace.webseervice;

import com.google.gson.Gson;
import projet100h.topRace.entities.*;
import projet100h.topRace.managers.GameLibrary;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/game")
public class GameWS {

    private Gson gsonService = new Gson();

    @POST
    @Path("/avancer")
    public Response avancer(@FormParam("data") String data1){

        JsonCreatedClass jsooon = gsonService.fromJson(data1, JsonCreatedClass.class);
        // on recupère les variables
        int idPartie = jsooon.getIdPartie();
        String couleurJ = jsooon.getCouleur();
        String data = jsooon.getData();

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
                Plateau plateau = GameLibrary.getInstance().getPlateau(idPartie);
                List carte = (List) listDeplacementCarte.get(i);
                String couleur = (String) carte.get(1);
                int nbCases = (int) carte.get(0);
                System.out.println("la voiture "+carte.get(1)+" se déplace de "+nbCases+" case(s)");
                Joueur joueurADeplacer = GameLibrary.getInstance().getJoueur(couleur,idPartie);
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
            System.out.println("je suis dans le else");
            int fin = data.length();
            System.out.println(data.substring(0,2));
            int idCarte = Integer.parseInt(data.substring(0,2));
            System.out.println(data.substring(2,fin));
            String couleur = data.substring(2,fin);
            System.out.println("la voiture "+couleur+" et l'idCartes "+idCarte);
            if (idCarte == 27 || idCarte == 28 || idCarte == 29){
                String answer = "1";
                Plateau plateau = GameLibrary.getInstance().getPlateau(idPartie);
                Joueur joueurADeplacer = GameLibrary.getInstance().getJoueur(couleur,idPartie);
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
                Plateau plateau = GameLibrary.getInstance().getPlateau(idPartie);
                Joueur joueurADeplacer = GameLibrary.getInstance().getJoueur(couleur,idPartie);
                PartieCase caseArrivee = joueurADeplacer.deplacer(5, plateau);
                GameLibrary.getInstance().changerCase(joueurADeplacer, caseArrivee);
                String answer2 = GameLibrary.getInstance().getTopLeft(caseArrivee);
                System.out.println(answer2);
                answer = answer + "-" + joueurADeplacer.getCouleur() + "#" + answer2;
                // avancer des 2 cases en fonction de l'idCartes
                Plateau plateau2 = GameLibrary.getInstance().getPlateau(idPartie);
                List carte = (List) listDeplacementCarte.get(0);
                String couleur2 = (String) carte.get(1);
                int nbCases = (int) carte.get(0);
                System.out.println("la voiture "+carte.get(1)+" se déplace de "+nbCases+" case(s)");
                Joueur joueurADeplacer2 = GameLibrary.getInstance().getJoueur(couleur2,idPartie);
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
                    Plateau plateau2 = GameLibrary.getInstance().getPlateau(idPartie);
                    List carte = (List) listDeplacementCarte.get(i);
                    String couleur2 = (String) carte.get(1);
                    int nbCases = (int) carte.get(0);
                    System.out.println("la voiture "+carte.get(1)+" se déplace de "+nbCases+" case(s)");
                    Joueur joueurADeplacer2 = GameLibrary.getInstance().getJoueur(couleur2,idPartie);
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
                Plateau plateau = GameLibrary.getInstance().getPlateau(idPartie);
                Joueur joueurADeplacer = GameLibrary.getInstance().getJoueur(couleur,idPartie);
                PartieCase caseArrivee = joueurADeplacer.deplacer(2, plateau);
                GameLibrary.getInstance().changerCase(joueurADeplacer, caseArrivee);
                String answer2 = GameLibrary.getInstance().getTopLeft(caseArrivee);
                System.out.println(answer2);
                answer = answer + "-" + joueurADeplacer.getCouleur() + "#" + answer2;
                // avancer des 1 cases en fonction de l'idCartes
                Plateau plateau2 = GameLibrary.getInstance().getPlateau(idPartie);
                List carte = (List) listDeplacementCarte.get(2);
                String couleur2 = (String) carte.get(1);
                int nbCases = (int) carte.get(0);
                System.out.println("la voiture "+carte.get(1)+" se déplace de "+nbCases+" case(s)");
                Joueur joueurADeplacer2 = GameLibrary.getInstance().getJoueur(couleur2,idPartie);
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

    @POST
    @Path("/parier")
    public Response parier(@FormParam("data") String data1 ){
        System.out.println("data envoyé dans le GameWS au @Path(\"/parier\") = "+data1);

        JsonCreatedClass jsooon = gsonService.fromJson(data1, JsonCreatedClass.class);
        // on recupère les variables
        int idPartie = jsooon.getIdPartie();
        String couleurJ = jsooon.getCouleur();
        String data = jsooon.getData();

        // transformation du string data en class grâce au JSON
        Pari pariJsonAnswer = gsonService.fromJson(data, Pari.class);

        // on recupère les variables
        int numeroPari = pariJsonAnswer.getNumeroPari();
        boolean jaune = pariJsonAnswer.isJaune();
        boolean bleue = pariJsonAnswer.isBleue();
        boolean rouge = pariJsonAnswer.isRouge();
        boolean violette = pariJsonAnswer.isViolette();
        boolean blanche = pariJsonAnswer.isBlanche();
        boolean verte = pariJsonAnswer.isVerte();

        String answer=null;
        int compteur = 0;
        //on regarde qu'il y ai bien 3 paris
        if (jaune == false){ compteur++; }
        if (bleue == false){ compteur++; }
        if (rouge == false){ compteur++; }
        if (violette == false){ compteur++; }
        if (blanche == false){ compteur++; }
        if (verte == false){ compteur++; }

        if (compteur != 3){
            answer = "error1"; //le pari n'est pas complet
            System.out.println("error1");
            System.out.println();
        } else {
            try {
                boolean existe = GameLibrary.getInstance().pariExiste(idPartie, couleurJ, numeroPari);
                if (existe == true) {
                    answer = "error2"; //le pari est déjà effectué
                    System.out.println("error2");
                    System.out.println();
                } else {
                    GameLibrary.getInstance().ajoutPari(idPartie, couleurJ, numeroPari, jaune, bleue, rouge, violette, blanche, verte);
                    answer = "succeed"; // tout s'est bien passé
                }
            }catch (Exception e) {
                answer = "error4";
                System.out.println("error4");
                System.out.println();
            }
        }
        System.out.println("réponse retourné après le @Path(\"/parier\") du GameWS = "+answer);
        System.out.println();
        return Response.ok().entity(gsonService.toJson(answer)).build();

    }

    @POST
    @Path("/checkPari")
    public Response checkPari(@FormParam("data") String data1 ){
        System.out.println("data envoyé dans le GameWS au @Path(\"/checkPari\") = "+data1);
        JsonCreatedClass jsooon = gsonService.fromJson(data1, JsonCreatedClass.class);

        // on recupère les variables
        int idPartie = jsooon.getIdPartie();
        String couleurJ = jsooon.getCouleur();
        String data2 = jsooon.getData();
        int data = Integer.parseInt(data2);

        // on créé un réponse
        String answer;

        try {
            boolean existe = GameLibrary.getInstance().pariExiste(idPartie,couleurJ, data); // on verifie que le pari existe

            if (existe == true){
                answer = "le pari a bien été envoyé";
            } else { //faire un pari aléatoire pour le joueur
                try {
                    List<Integer> listAlea = new ArrayList<Integer>();
                    Random rand = new Random();
                    int nombreAleatoire1 = rand.nextInt(5 - 0 + 1);
                    listAlea.add(nombreAleatoire1);
                    while (listAlea.size()<3){
                        int nombreAleatoire2 = rand.nextInt(5 - 0 + 1);
                        if (!listAlea.contains(nombreAleatoire2)){
                            listAlea.add(nombreAleatoire2);
                        }
                    }
                    boolean jaune = false; boolean bleue = false; boolean rouge = false; boolean violette = false; boolean blanche = false; boolean verte = false;
                    for (int i = 0 ; i < 3 ; i ++){
                        if(listAlea.get(i) == 1){ jaune=true ;}
                        else if (listAlea.get(i) == 2){ bleue=true ;}
                        else if (listAlea.get(i) == 3){ rouge=true ;}
                        else if (listAlea.get(i) == 4){ violette=true ;}
                        else if (listAlea.get(i) == 5){ blanche=true ;}
                        else if (listAlea.get(i) == 0){ verte=true ;}
                    }
                    try {
                        GameLibrary.getInstance().ajoutPari(idPartie,couleurJ, data, jaune, bleue, rouge, violette, blanche, verte);
                        try {
                            boolean existe2 = GameLibrary.getInstance().pariExiste(idPartie, couleurJ, data);
                            if (existe2 == true) {
                                answer = "un pari aléatoire a été effectué";
                            } else {
                                answer = "error1";
                            }
                        }catch (Exception e) {
                            answer = "error4";
                            System.out.println("error4");
                            System.out.println();
                        }
                    }catch (Exception e) {
                        answer = "error6";
                        System.out.println("error6");
                        System.out.println();
                    }
                }catch (Exception e) {
                    answer = "error3";
                    System.out.println("error3");
                    System.out.println();
                }
            }
        }
        catch (Exception e) {
            answer = "error4";
            System.out.println("error4");
            System.out.println();
        }

        System.out.println("réponse retourné après le @Path(\"/checkPari\") du GameWS = "+answer);
        System.out.println();
        return Response.ok().entity(gsonService.toJson(answer)).build();
    }

    @POST
    @Path("/getPari")
    public Response getPari(@FormParam("data") String data1 ){
        System.out.println("data envoyé dans le GameWS au @Path(\"/getPari\") = "+data1);
        JsonCreatedClass jsooon = gsonService.fromJson(data1, JsonCreatedClass.class);

        // on recupère les variables
        int idPartie = jsooon.getIdPartie();
        String couleurJ = jsooon.getCouleur();
        String data2 = jsooon.getData();
        int data = Integer.parseInt(data2);

        // on créé la réponse
        String answer;

        try {
            boolean existe = GameLibrary.getInstance().pariExiste(idPartie,couleurJ, data);
            // on verifie qu'un pari a bien été effectuer
            if (existe == true){ // soit oui, dans ce cas la on le récupère
                answer = GameLibrary.getInstance().getPari(idPartie,couleurJ, data);
            } else {
                answer = "pas de pari effectué";
            }
        }
        catch (Exception e) {
            answer = "error4";
            System.out.println("error4");
            System.out.println();
        }



        System.out.println("réponse retourné après le @Path(\"/checkPari\") du GameWS = "+answer);
        System.out.println();
        return Response.ok().entity(gsonService.toJson(answer)).build();
    }

    @POST
    @Path("/lastAct")
    public Response derniereAction(@FormParam("data") String data1 ){
        System.out.println("data envoyé dans le GameWS au @Path(\"/act\") = "+data1);
        JsonCreatedClass jsooon = gsonService.fromJson(data1, JsonCreatedClass.class);

        // on recupère les variables
        int idPartie = jsooon.getIdPartie();
        String couleurJ = jsooon.getCouleur();
        String data = jsooon.getData();

        // on créé la réponse
        String answer;

        // puis on change l'action du joueur dans la BDD, et on revois une réponse positive si cela fonctionne
        try {
            GameLibrary.getInstance().changerDernierAction(idPartie, couleurJ, data);
            answer = "succeed"; // tout s'est bien passé
        }
        catch (Exception e) {
            answer = "error5";
            System.out.println("error5");
            System.out.println();
        }

        System.out.println("réponse retourné après le @Path(\"/act\") du GameWS = "+answer);
        System.out.println();
        return Response.ok().entity(gsonService.toJson(answer)).build();
    }

    @POST
    @Path("/finishAct")
    public Response ActionFinie(@FormParam("data") String data1 ){
        System.out.println("data envoyé dans le GameWS au @Path(\"/finishAct\") = "+data1);
        JsonCreatedClass jsooon = gsonService.fromJson(data1, JsonCreatedClass.class);

        // on recupère les variables
        int idPartie = jsooon.getIdPartie();
        String couleurJ = jsooon.getCouleur();
        String data = jsooon.getData();

        // on créé la réponse
        String answer;

        Boolean finie;

        // puis on change l'action du joueur dans la BDD, et on revois une réponse positive si cela fonctionne
        try {
            finie = GameLibrary.getInstance().actionFinieParTousJoueurs(idPartie,data);
            if (finie==true){
                answer = "true"; // oui l'action est finie par tout les joueurs
            } else {
                answer = "false";// non l'action n'est pas finie par tout les joueurs
            }
        }
        catch (Exception e) {
            answer = "error9";
            System.out.println("error9");
            System.out.println();
        }

        System.out.println("réponse retourné après le @Path(\"/finishAct\") du GameWS = "+answer);
        System.out.println();
        return Response.ok().entity(gsonService.toJson(answer)).build();
    }

    @POST
    @Path("/getEtat")
    public Response getEtat(@FormParam("data") String data1 ){
        JsonCreatedClass jsooon = gsonService.fromJson(data1, JsonCreatedClass.class);

        // on recupère les variables
        int idPartie = jsooon.getIdPartie();
        String couleurJ = jsooon.getCouleur();
        String data = jsooon.getData();

        // on créé la réponse
        String answer;

        String etat;

        // puis on recupère l'état actuelle de la partie
        try {
            etat = GameLibrary.getInstance().getEtat(idPartie);
            String joueurCouleur = "joueur"+couleurJ;
            if (etat==joueurCouleur || etat.equals(joueurCouleur)){
                answer = "true"; // oui c'est au tour de ce joueur
            } else {
                answer = "false";// non ce n'est pas au tour de ce joueur
            }
        }
        catch (Exception e) {
            answer = "error10";
            System.out.println("error10");
            System.out.println();
        }

        return Response.ok().entity(gsonService.toJson(answer)).build();
    }

    @POST
    @Path("/changeEtat")
    public Response changeEtat(@FormParam("data") String data1 ){
        System.out.println("data envoyé dans le GameWS au @Path(\"/changeEtat\") = "+data1);
        JsonCreatedClass jsooon = gsonService.fromJson(data1, JsonCreatedClass.class);

        // on recupère les variables
        int idPartie = jsooon.getIdPartie();
        String couleurJ = jsooon.getCouleur();
        String data = jsooon.getData();

        // on créé la réponse
        String answer;

        String etat;

        // puis on recupère l'état actuelle de la partie
        try {
            if(couleurJ=="Bleu" || couleurJ.equals("Bleu")){
                GameLibrary.getInstance().changeEtat(idPartie,"joueurBlanc");
            }else if(couleurJ=="Blanc" || couleurJ.equals("Blanc")){
                GameLibrary.getInstance().changeEtat(idPartie,"joueurViolet");
            }else if(couleurJ=="Violet" || couleurJ.equals("Violet")){
                GameLibrary.getInstance().changeEtat(idPartie,"joueurVert");
            }else if(couleurJ=="Vert" || couleurJ.equals("Vert")){
                GameLibrary.getInstance().changeEtat(idPartie,"joueurRouge");
            }else if(couleurJ=="Rouge" || couleurJ.equals("Rouge")){
                GameLibrary.getInstance().changeEtat(idPartie,"joueurJaune");
            }else if(couleurJ=="Jaune" || couleurJ.equals("Jaune")){
                GameLibrary.getInstance().changeEtat(idPartie,"joueurBleu");
            }
            answer="succeed";
        }
        catch (Exception e) {
            answer = "error12";
            System.out.println("error12");
            System.out.println();
        }
        System.out.println("réponse retourné après le @Path(\"/changeEtat\") du GameWS = "+answer);
        System.out.println();
        return Response.ok().entity(gsonService.toJson(answer)).build();
    }

}