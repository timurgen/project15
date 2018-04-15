package no.ohuen.sbanken.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 101)
public class SessionDetailsFilter extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        final HttpSession session = request.getSession();
        if (null == session.getAttribute("isDisclaimerShown")) {
            session.setAttribute("isDisclaimerShown", Boolean.TRUE);
            request.getRequestDispatcher("disclaimer").forward(request, response);
            return;
        }
        if (null == session.getAttribute("") && !"POST".equalsIgnoreCase(request.getMethod())) {
            request.getRequestDispatcher("init").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }
}
