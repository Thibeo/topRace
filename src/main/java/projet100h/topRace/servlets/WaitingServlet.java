package projet100h.topRace.servlets;


import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import projet100h.topRace.entities.Joueur;
import projet100h.topRace.entities.Partie;
import projet100h.topRace.managers.GameLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/wait")
public class WaitingServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer idPartie = (Integer) session.getAttribute("sessionIdPartie");
        String nomJoueur= (String) session.getAttribute("sessionNomJoueur");

        System.out.println("idPartie = "+idPartie+" // nomJoueur = "+nomJoueur);

        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("nomJ", nomJoueur);

        List<Joueur> listOfJoueur = GameLibrary.getInstance().listOfJoueur(idPartie);
        context.setVariable("listOfJoueur", listOfJoueur);

        int nbJoueur = GameLibrary.getInstance().nbDeJoueurIdPartie(idPartie);
        context.setVariable("nbJoueur",nbJoueur);

        Partie PartieById = GameLibrary.getInstance().getPartieById(idPartie);
        context.setVariable("PartieById", PartieById);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("pageAttente", context, resp.getWriter());
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idPartie = null;
        String pseudoJoueur = null;

        /*pseudoJoueur = req.getParameter("nomJoueur");
        idPartie = Integer.parseInt(req.getParameter("idPartie"));

        // pour "ouvrir" une session correspondant à la partie:
        HttpSession session = req.getSession();
        //String sessionpartie = "sessionpartie";
        session.setAttribute("sessionIdPartie", idPartie);
        session.setAttribute("sessionNomJoueur",pseudoJoueur);
        */
        HttpSession session = req.getSession();
        idPartie = (Integer) session.getAttribute("sessionIdPartie");
        pseudoJoueur= (String) session.getAttribute("sessionNomJoueur");

        try {

            List<Joueur> listOfJoueur = GameLibrary.getInstance().listOfJoueur(idPartie);
            Partie PartieById = GameLibrary.getInstance().getPartieById(idPartie);
            for (int i = 0 ; i < 6 ; i++){
                if (pseudoJoueur.equals(listOfJoueur.get(i).getNomJoueur())){
                    if (listOfJoueur.get(i).getCouleur().equals(PartieById.getCouleurDeProprio())){
                        GameLibrary.getInstance().repartitionCarteJoueur(idPartie);
                    }
                }
            }

            // REDIRIGE VERS LA PAGE DE JEU
            resp.sendRedirect("game");
            session.removeAttribute("error");
            req.setAttribute("sessionIdPartie", idPartie);
            req.setAttribute("sessionNomJoueur", pseudoJoueur);
            GameLibrary.getInstance().changeEtatActuel(idPartie,"lancerTuto");
            GameLibrary.getInstance().changeEtatAncien(idPartie,"attente");


        } catch (IllegalArgumentException e) {

            String errorMessage = e.getMessage();
            req.getSession().setAttribute("errorMessage", errorMessage);
            resp.sendRedirect("wait");
        }

    }
}