
import donation.core.domain.Donation;
import donation.core.domain.User;
import donation.core.service.api.*;
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
import java.util.ResourceBundle;

import static donation.web.util.Views.ERROR_PAGE;

@WebServlet(name = "DeleteDonationServlet", urlPatterns = "/donations/delete.do")
public class DeleteDonationServlet extends HttpServlet {

    private DonationService donationService;

    private ResourceBundle resourceBundle;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        donationService = applicationContext.getBean(DonationService.class);
        resourceBundle = ResourceBundle.getBundle("donationlist");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String id = request.getParameter("donationId");
        try {
            long donationId = Long.parseLong(id);
            Donation donation = donationService.getDonationById(donationId);
            if (donation != null) {
                donationService.remove(donation);
                request.getRequestDispatcher("/donations").forward(request, response);
            } else {
                redirectToErrorPage(request, response, id);
            }
        } catch (NumberFormatException e) {
            redirectToErrorPage(request, response, id);
        }
    }

    private void redirectToErrorPage(HttpServletRequest request, HttpServletResponse response, String donationId) throws ServletException, IOException {
        request.setAttribute("error", MessageFormat.format(resourceBundle.getString("no.such.donation"), donationId));
        request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
    }

}
