package donation.web.servlet.don;

//import donation.core.domain.Priority;
import donation.core.domain.Donation;
import donation.core.service.api.DonationService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ResourceBundle;


import static donation.web.util.Views.ERROR_PAGE;
import static donation.web.util.Views.UPDATE_DONATION_PAGE;

@WebServlet(name = "UpdateDonationServlet", urlPatterns = {"/donations/update", "/donations/update.do"})
public class UpdateDonationServlet extends HttpServlet {

    private DonationService donationService;

    private ResourceBundle resourceBundle;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        donationService = applicationContext.getBean(DonationService.class);
        resourceBundle = ResourceBundle.getBundle("donationlist");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String id = request.getParameter("id");
        try {
            long donationId = Long.parseLong(id);
            Donation donation = donationService.getDonationById(donationId); // FIXME security : may provide an id for a donation of another user!
            request.setAttribute("donation", donation);
            request.getRequestDispatcher(UPDATE_TODO_PAGE).forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", MessageFormat.format(resourceBundle.getString("no.such.donation"), id));
            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long donationId = Long.parseLong(request.getParameter("id"));
        String description = request.getParameter("description");
        float estimate = Float.ParseFloat(request.getParameter("estimate"));

        Donation donation = donationService.getDonationById(donationId);
        donation.setDescription(description);
        donation.setEstimate(estimate);

        donationService.update(donation);
        request.getRequestDispatcher("/donations").forward(request, response);

    }

}