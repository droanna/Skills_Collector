package pl.dro.anna.skills_collector.servlets;

import org.hibernate.SessionFactory;
import pl.dro.anna.skills_collector.model.dao.UserDao;
import pl.dro.anna.skills_collector.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = (SessionFactory) getServletContext().getAttribute("session_factory");
        userDao = new UserDao(sessionFactory);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastNmae(lastName);
        user.setPassword(password);
        user.setUsername(username);

        Boolean usernameAvaible = userDao.isUsernameAvailable(username);
        if (usernameAvaible) {
            userDao.save(user);
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("error", "Nazwa użytkownika już zajęta");
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
        }

    }
}
