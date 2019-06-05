package pl.dro.anna.skills_collector.filters;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter extends HttpFilter {



    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String path = req.getServletPath();
        allowedPaths(allowedPaths);
        if (authorizationDemandedPaths(path, authorizedPaths)) {
            HttpSession httpSession = req.getSession();
            if (httpSession.getAttribute("user") != null) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect("/login");
            }

        } else if (allowedPaths.contains(path)) {
            chain.doFilter(req, res);
        } else {
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }

    List<String> allowedPaths = new ArrayList<>();
    List<String> authorizedPaths = new ArrayList<>();

    private List<String> allowedPaths(List<String> allowedPaths) {
        allowedPaths.add("/login");
        allowedPaths.add("/register");
        allowedPaths.add("/logout");
        return allowedPaths;
    }

    private List<String> authorizedPaths(List<String> authorizedPaths) {
        authorizedPaths.add("/user/skills");
        authorizedPaths.add("/user/sources");
        authorizedPaths.add("/user/unknown-sources");
        return authorizedPaths;
    }

    boolean authorizationDemandedPaths(String path, List<String> authorizedPaths) {
        authorizedPaths(authorizedPaths);
        boolean answer = authorizedPaths.stream()
                .anyMatch(n -> n.equals(path));
        if (answer) {
            return true;
        }
        return false;
    }
}
