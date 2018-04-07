package projet100h.topRace.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import projet100h.topRace.entities.*;
import projet100h.topRace.managers.GameLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.*;

@WebServlet("/game")
public class GameServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Integer idPartie = (Integer) session.getAttribute("sessionIdPartie");
        String nomJoueur= (String) session.getAttribute("sessionNomJoueur");
        String couleurJoueur ="";

        System.out.println("idPartie = "+idPartie+" // nomJoueur = "+nomJoueur);

        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("nomJ", nomJoueur);

        Partie PartieById = GameLibrary.getInstance().getPartieById(idPartie);
        context.setVariable("PartieById", PartieById);

        List<Joueur> listOfJoueur = GameLibrary.getInstance().listOfJoueur(idPartie);
        context.setVariable("listOfJoueur", listOfJoueur);

        List<Case> listCase = GameLibrary.getInstance().listCase();
        context.setVariable("listCase", listCase);

        for (int i = 0 ; i < listOfJoueur.size() ; i++){
            if (listOfJoueur.get(i).getNomJoueur().equals(nomJoueur)){
                couleurJoueur=listOfJoueur.get(i).getCouleur();
            }
        }

        context.setVariable("couleurJoueurr", couleurJoueur);

        List<CarteJoueur> listCarte = GameLibrary.getInstance().getCarteJoueur(idPartie,couleurJoueur);
        context.setVariable("listCarte", listCarte);

        List<NbCase> listNbCase = GameLibrary.getInstance().listNbCase();
        context.setVariable("listNbCase", listNbCase);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("pageJeu", context, resp.getWriter());
    }

/*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // GET PARAMETERS
        String nomPartie = null;
        String pseudoJoueur=null;
        String couleurJoueur = null;


        nomPartie = req.getParameter("nom");
        pseudoJoueur = req.getParameter("pseudo");
        couleurJoueur = req.getParameter("couleurJoueur");


        List<PartieCase> listAleatoire=new ArrayList<>();



        // CREATION DE LA PARTIE:
        try {
            Joueur nouveauJoueur=new Joueur(couleurJoueur,pseudoJoueur,);

            Partie nouvellePartie=new Partie(null,pseudoJoueur,nomPartie);

            GameLibrary.getInstance().creerPartie(nouvellePartie);

            // REDIRECT TO CONTACT PAGE

            resp.sendRedirect("contact");

        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            req.getSession().setAttribute("errorMessage", errorMessage);
            resp.sendRedirect("contact");
        }

    }*/
}