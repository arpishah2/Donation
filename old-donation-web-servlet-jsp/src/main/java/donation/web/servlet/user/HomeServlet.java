package donation.web.servlet.user;

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

import static donation.web.util.Views.HOME_PAGE;

@WebServlet(name = "HomeServlet", urlPatterns = "/donations")
public class HomeServlet extends HttpServlet {

	private DonationService donationService;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        donationService = applicationContext.getBean(DonationService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(DonationListUtils.SESSION_USER);
        List<Donation> donationList = donationService.getDonationListByUser(user.getId());

        //donation list is request scoped to avoid storing and synchronizing it in session for each CRUD operation
        request.setAttribute("donationList", donationList);
        request.setAttribute("homeTabStyle", "active");

        /*
        int totalCount = donationList.size();
        int doneCount = DonationListUtils.countTotalDone(donationList);
        int donationCount = totalCount - doneCount;
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("doneCount", doneCount);
        request.setAttribute("donationCount", donationCount);
		*/
        request.getRequestDispatcher(HOME_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}