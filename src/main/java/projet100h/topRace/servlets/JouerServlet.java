package projet100h.topRace.servlets;


import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import projet100h.topRace.entities.Case;
import projet100h.topRace.entities.Joueur;
import projet100h.topRace.entities.Partie;
import projet100h.topRace.entities.PartieCase;
import projet100h.topRace.managers.GameLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@WebServlet("/jouer")
public class JouerServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        List listofPartie = GameLibrary.getInstance().listPartie();
        context.setVariable("listPartie", listofPartie);

        List listNbJoueur = GameLibrary.getInstance().nbDeJoueur();
        context.setVariable("listNbJoueur", listNbJoueur);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("jouer", context, resp.getWriter());
    }

    /*protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        switch (action){
            case "Nouvelle Partie":

                // GET PARAMETERS
                String nomDePartie = null;
                String nomDEProprio = null;

                nomDePartie = req.getParameter("nomPartie");
                nomDEProprio = req.getParameter("pseudo");

                // CREER PARTIE
                Partie newPartie = new Partie(null,nomDEProprio,nomDePartie);
                Partie createdPartie = GameLibrary.getInstance().creerPartie(newPartie);

                // CREER JOUEUR
                Random rand = new Random();
                int nombreAleatoire = rand.nextInt(5 - 0 + 1);
                ArrayList listeCouleur= new ArrayList();
                listeCouleur=GameLibrary.getInstance().listCouleur();
                ArrayList listeCaracteristique=new ArrayList();
                listeCaracteristique= (ArrayList) listeCouleur.get(nombreAleatoire);
                int positionX= (int) listeCaracteristique.get(0);
                String positionYString= (String) listeCaracteristique.get(1);
                char positionY=positionYString.charAt(0);
                String couleur= (String) listeCaracteristique.get(2);

                PartieCase caseActuelle=new PartieCase(positionX,positionY,createdPartie.getIdPartie(),true);

                Joueur newJoueur = new Joueur(couleur,nomDEProprio,caseActuelle,createdPartie.getIdPartie());
                GameLibrary.getInstance().creerJoueur(newJoueur);
                try {

                    // REDIRIGE VERS LA PAGE D'ATTENTE
                    resp.sendRedirect("wait");
                } catch (IllegalArgumentException e) {
                    String errorMessage = e.getMessage();

                    req.getSession().setAttribute("errorMessage", errorMessage);

                    resp.sendRedirect("jouer");
                }
            break;



            case "Valider":
                Integer idPartie=null;
                String pseudoJoueur=null;

                idPartie = Integer.parseInt(req.getParameter("idPartie"));
                pseudoJoueur = req.getParameter("nomPseudo");

                Random rand2 = new Random();
                int nombreAleatoire2 = rand2.nextInt(5 - 0 + 1);
                ArrayList listeCouleur2= new ArrayList();
                listeCouleur2=GameLibrary.getInstance().listCouleur();
                ArrayList listeCaracteristique2=new ArrayList();
                listeCaracteristique2 = (ArrayList) listeCouleur2.get(nombreAleatoire2);
                int positionnX= (int) listeCaracteristique2.get(0);
                String positionnYString= (String) listeCaracteristique2.get(1);
                char positionnY=positionnYString.charAt(0);
                String couleur2= (String) listeCaracteristique2.get(2);



                PartieCase caseActuelle2=new PartieCase(positionnX,positionnY,idPartie,true);

                Joueur newJoueur2 = new Joueur(couleur2,pseudoJoueur,caseActuelle2,idPartie);
                GameLibrary.getInstance().creerJoueur(newJoueur2);


                try {

                    // REDIRIGE VERS LA PAGE D'ATTENTE
                    resp.sendRedirect("wait");

                } catch (IllegalArgumentException e) {
                    String errorMessage = e.getMessage();
                    req.getSession().setAttribute("errorMessage", errorMessage);
                    resp.sendRedirect("jouer");
                }
            break;
        }
    }*/
}