package projet100h.topRace.servlets;


import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import projet100h.topRace.entities.Case;
import projet100h.topRace.managers.GameLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
}