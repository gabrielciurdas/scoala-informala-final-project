package it4kids.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it4kids.domain.UserLogin;
import it4kids.service.SecurityService;

@Component
public class SecurityFilter implements Filter {

	@Autowired
	private SecurityService securityService;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		UserLogin userLogin = (UserLogin) ((HttpServletRequest) request).getSession().getAttribute("currentUser");

		securityService.setCurrentUser(userLogin);

		String url = ((HttpServletRequest) request).getRequestURL().toString();

		if (url.contains("admin")) {
			if (!userLogin.getAccountType().equalsIgnoreCase("admin")) {
				HttpServletResponse servletResponse = (HttpServletResponse) response;
				String roleRedirect = "/" + userLogin.getAccountType() + "/" + userLogin.getAccountType();
				// servletResponse.sendError(401);
				servletResponse.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
				servletResponse.setHeader("Location", "/login");
				return;
			} else {
			}
		}
		if (url.contains("primary_parent")) {
			if (!userLogin.getAccountType().equalsIgnoreCase("primary_parent")) {
				HttpServletResponse servletResponse = (HttpServletResponse) response;
				// servletResponse.sendError(401);
				servletResponse.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
				servletResponse.setHeader("Location", "/login");
				return;
			} else {
			}
		} if (url.contains("teacher")) {
			if (!userLogin.getAccountType().equalsIgnoreCase("teacher")) {
				HttpServletResponse servletResponse = (HttpServletResponse) response;
				// servletResponse.sendError(401);
				servletResponse.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
				servletResponse.setHeader("Location", "/login");
				return;
			}
			else {
			}
		} if (url.contains("child")) {
			if (!userLogin.getAccountType().equalsIgnoreCase("child")) {
				HttpServletResponse servletResponse = (HttpServletResponse) response;
				// servletResponse.sendError(401);
				servletResponse.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
				servletResponse.setHeader("Location", "/login");
				return;
			}
			else {
			}
		} if (url.contains("parent")) {
			if (!userLogin.getAccountType().equalsIgnoreCase("parent")) {
				HttpServletResponse servletResponse = (HttpServletResponse) response;
				// servletResponse.sendError(401);
				servletResponse.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
				servletResponse.setHeader("Location", "/login");
				return;
			}
			else {
			}
		}

		System.out.println("Thread name: " + Thread.currentThread().getName() + ", current user: "
				+ (userLogin != null ? userLogin.getUserName() : null));

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
