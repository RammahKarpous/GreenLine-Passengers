package filter;

import ManagedBeans.UserLogin;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "Login", urlPatterns = {"/*"})

public class Login implements Filter {

    private FilterConfig filterConfig = null;
    
    @Inject
    UserLogin user;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/faces/login.xhtml";

        boolean loggedIn = user.userLogin();
        boolean loginRequest = request.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest)
        {
            chain.doFilter(request, response);
        }
        else
        {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy()
    {
        this.filterConfig = null;
    }

    @Override
    public void init(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    public void log(String msg)
    {
        filterConfig.getServletContext().log(msg);
    }

}
