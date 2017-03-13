package it4kids.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String firstName = "";
		String accountType = "";

		if (userDAO.authenticateUser(email, password)) {
			req.getSession().setAttribute("userid", email);
			
			firstName = userDAO.getFirstName();
			accountType = AccountType.valueOf(userDAO.getAccountType()).name();
			
			HttpSession session = req.getSession();
			session.setAttribute("accountType", accountType);
			session.setAttribute("userName", userDAO.getUsername());
			
			req.setAttribute("firstName", firstName);
			req.getRequestDispatcher("user/" + AccountType.valueOf(accountType).getType().toLowerCase()
					+ "/" + AccountType.valueOf(accountType).getType()+ ".jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("invalidPassword.jsp").forward(req, resp);
		}
	}
}
