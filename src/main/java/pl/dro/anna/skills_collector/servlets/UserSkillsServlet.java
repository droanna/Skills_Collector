package pl.dro.anna.skills_collector.servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.dro.anna.skills_collector.model.dao.UserDao;
import pl.dro.anna.skills_collector.model.entities.Skill;
import pl.dro.anna.skills_collector.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/user/skills")
public class UserSkillsServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = (SessionFactory) getServletContext().getAttribute("session_factory");
        userDao = new UserDao(sessionFactory);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");
        Map<Skill, Integer> userSkills = new HashMap<>();
        for (Skill s : userDao.getAllSkillsByUsername(user.getUsername())) {
            if (userSkills.containsKey(s)) {
                int value = userSkills.get(s);
                userSkills.put(s, value + 1);
            } else {
                userSkills.put(s, 1);
            }
        }
        req.setAttribute("skills", userSkills);
        req.getRequestDispatcher("/WEB-INF/views/user-skills.jsp").forward(req, resp);

    }


}
