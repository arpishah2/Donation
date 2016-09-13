package donation.web.filter;

import donation.core.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/user/*", "/donations/*"})
public class LoginFilter implements Filter {
	
	public void init(FilterConfig config) throws ServletException {
    }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(DonationListUtils.SESSION_USER);
		if (user != null) {
			chain.doFilter(request, response);
	    } else {
	    	request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
	    }
	}
}