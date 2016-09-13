package donation.web.servlet.don;

//import donation.web.common.util.DonationListUtils;
import donation.core.domain.Donation;
import donation.core.domain.User;
import donation.core.service.api.DonationService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static donation.web.util.Views.SEARCH_PAGE;

@WebServlet(name = "SearchServlet", urlPatterns = "/donations/search")
public class SearchServlet extends HttpServlet {

    private DonationService donationService;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        donationService = applicationContext.getBean(DonationService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String yearInfo = request.getParameter("year");
       int year = Integer.ParseInt(yearInfo);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(DonationListUtils.SESSION_USER);

        List<Donation> donationList = donationService.searchDonationListByYear(user.getId(), year);
        request.setAttribute("donationList", donationList);

        request.getRequestDispatcher(SEARCH_PAGE).forward(request, response);

    }

}