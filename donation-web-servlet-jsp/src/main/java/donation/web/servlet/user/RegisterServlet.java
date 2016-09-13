package donation.web.servlet.user;

import donation.web.common.form.RegistrationForm;
//import donation.web.common.util.TodoListUtils;
import donation.core.domain.User;
import donation.core.service.api.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.Set;

import static donation.web.util.Views.REGISTER_PAGE;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register", "/register.do"})
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    private ResourceBundle resourceBundle;

    private Validator validator;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //initialize Spring user service
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        userService = applicationContext.getBean(UserService.class);

        //initialize JSR 303 validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        resourceBundle = ResourceBundle.getBundle("donationlist");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("registerTabStyle", "active");
        request.getRequestDispatcher(REGISTER_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setEmail(email);

        String nextPage = REGISTER_PAGE;

        validateRegistrationForm(request, registrationForm);


        if (isInvalid(request)) {
            request.getRequestDispatcher(nextPage).forward(request, response);
            return;
        }

        if (isAlreadyUsed(email)) {
            request.setAttribute("error", MessageFormat.format(resourceBundle.getString("register.error.global.account"), email));
            request.getRequestDispatcher(nextPage).forward(request, response);
            return;
        }

        User user = new User(email);
        user = userService.create(user);
        HttpSession session = request.getSession(true);
        session.setAttribute(TodoListUtils.SESSION_USER, user);
        request.getRequestDispatcher("/donations").forward(request, response);

    }

    private boolean isAlreadyUsed(String email) {
        return userService.getUserByEmail(email) != null;
    }

    private void validateRegistrationForm(HttpServletRequest request, RegistrationForm registrationForm) {
        validateEmail(request, registrationForm);
    }

    private boolean isInvalid(HttpServletRequest request) {
        return request.getAttribute("error") != null;
    }


    private void validateEmail(HttpServletRequest request, RegistrationForm registrationForm) {
        Set<ConstraintViolation<RegistrationForm>> constraintViolations
                = validator.validateProperty(registrationForm, "email");
        if (!constraintViolations.isEmpty()) {
            request.setAttribute("errorEmail", constraintViolations.iterator().next().getMessage());
            addGlobalRegistrationErrorAttribute(request);
        }
    }

    private void addGlobalRegistrationErrorAttribute(HttpServletRequest request) {
        request.setAttribute("error", resourceBundle.getString("register.error.global"));
    }

}