package projet100h.topRace.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import projet100h.topRace.entities.Carte;
import projet100h.topRace.entities.Case;
import projet100h.topRace.entities.NbCase;
import projet100h.topRace.managers.GameLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/game")
public class GameServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        List<Case> listCase = GameLibrary.getInstance().listCase();
        context.setVariable("listCase", listCase);

        List<Carte> listCarte = GameLibrary.getInstance().listCarte();
        context.setVariable("listCarte", listCarte);

        List<NbCase> listNbCase = GameLibrary.getInstance().listNbCase();
        context.setVariable("listNbCase", listNbCase);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("pageJeu", context, resp.getWriter());
    }
}