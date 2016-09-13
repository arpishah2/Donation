package donation.web.util;

public class Views{
	
	private Views() {}

    public static final String SESSION_USER = "user";

    public static final String PREFIX = "/WEB-INF/views";

    public static final String VIEW_DONATIONS_PAGE = PREFIX + "/donate/donations.jsp";

    public static final String LOGIN_PAGE = PREFIX + "/user/login.jsp";

    public static final String ACCOUNT_PAGE = PREFIX + "/user/account.jsp";

    public static final String REGISTER_PAGE = PREFIX + "/user/register.jsp";

    public static final String CREATE_DONATION_PAGE = PREFIX + "/donate/create.jsp";

    public static final String SEARCH_PAGE = PREFIX + "/don/search.jsp";

    public static final String UPDATE_DONATION_PAGE = PREFIX + "/don/update.jsp";

    public static final String ERROR_PAGE = PREFIX + "/error.jsp";

    public static final String ABOUT_PAGE = PREFIX + "/about.jsp";

    public static final String INDEX_PAGE = PREFIX + "/index.jsp";
}
