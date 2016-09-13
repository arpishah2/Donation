package donation.web.servlet.user;

import donation.web.common.form.LoginForm;
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
import java.util.ResourceBundle;
import java.util.Set;

import static donation.web.util.Views.LOGIN_PAGE;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/login.do"})

public class LoginServlet extends HttpServlet {

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
        request.setAttribute("loginTabStyle", "active");
        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        LoginForm loginForm = new LoginForm();
        loginForm.setEmail(email);

        String nextPage = LOGIN_PAGE;

        validateCredentials(request, loginForm);

        if (isInvalid(request)) {
            request.getRequestDispatcher(nextPage).forward(request, response);
            return;
        }

        //made a change here 
        if (isInvalidEmail(email) {
            request.setAttribute("error", resourceBundle.getString("login.error.global.invalid"));
        } else {
            HttpSession session = request.getSession(true);//create session
            User user = userService.getUserByEmail(email);
            session.setAttribute(TodoListUtils.SESSION_USER, user);
            nextPage = "/donations";
        }
        request.getRequestDispatcher(nextPage).forward(request, response);
    }

    private void validateCredentials(HttpServletRequest request, LoginForm loginForm) {
        validateEmail(request, loginForm);
    }

    private boolean isInvalidEmailString email) {
        return !userService.login(email);
    }

    private void validateEmail(HttpServletRequest request, LoginForm loginForm) {
        Set<ConstraintViolation<LoginForm>> constraintViolations = validator.validateProperty(loginForm, "email");
        if (!constraintViolations.isEmpty()) {
            request.setAttribute("errorEmail", constraintViolations.iterator().next().getMessage());
            addGlobalLoginErrorAttribute(request);
        }
    }

    private void addGlobalLoginErrorAttribute(HttpServletRequest request) {
        request.setAttribute("error", resourceBundle.getString("login.error.global"));
    }

    private boolean isInvalid(HttpServletRequest request) {
        return request.getAttribute("error") != null;
    }

}
