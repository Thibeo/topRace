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


        WebContext context = new WebContext(req, resp, req.getServletContext());

        List<Joueur> listOfJoueur = GameLibrary.getInstance().listOfJoueur(idPartie);
        context.setVariable("listOfJoueur", listOfJoueur);

        Partie PartieById = GameLibrary.getInstance().getPartieById(idPartie);
        context.setVariable("PartieById", PartieById);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("pageAttente", context, resp.getWriter());
    }
}