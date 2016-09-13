package donation.web.servlet.user;

/**
 * Created by arpi on 9/13/16.
 */

//import donation.web.common.util.DonationListUtils;
        import donation.core.domain.Donation;
        import donation.core.domain.User;
        import donation.core.service.api.DonationService;
        import donation.web.util.Views;
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

        import static donation.web.util.Views.CREATE_DONATION_PAGE;

@WebServlet(name = "CreateDonationServlet", urlPatterns = {"/donations/create", "/donations/create.do"})
public class CreateDonationServlet extends HttpServlet {

    private DonationService donationService;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        donationService = applicationContext.getBean(DonationService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("today", new SimpleDateFormat(DonationListUtils.DATE_FORMAT).format(new Date()));
        request.getRequestDispatcher(CREATE_DONATION_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Views.SESSION_USER);

        String description = request.getParameter("description");
        String estimate = request.getParameter("estimate");

        Donation donation = new Donation(user.getId(), description, Float.parseFloat(estimate));
        donationService.create(donation);
        request.getRequestDispatcher("/donations").forward(request, response);

    }

}