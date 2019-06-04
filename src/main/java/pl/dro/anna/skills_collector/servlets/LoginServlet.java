package pl.dro.anna.skills_collector.servlets;

import org.hibernate.SessionFactory;
import pl.dro.anna.skills_collector.model.dao.UserDao;
import pl.dro.anna.skills_collector.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = (SessionFactory) getServletContext().getAttribute("session_factory");
        userDao = new UserDao(sessionFactory);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        List<User> users = userDao.getAllByUsernameAndPassword(username, password);
        if (users.size() == 1) {
            User user = users.get(0);
            req.getSession().invalidate();
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            resp.sendRedirect("/user/skills");

        } else {
            req.setAttribute("error", "Błędne dane logowania");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
