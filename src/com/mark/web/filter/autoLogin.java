package com.mark.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mark.bean.User;
import com.mark.service.userService;

/**
 * Servlet Filter implementation class autoLogin
 */
public class autoLogin implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		if(request.getSession().getAttribute("user") == null){
			try {
				Cookie[] cookies = request.getCookies();
				String username = null;
				String password = null;
				for (Cookie cookie : cookies) {
					if("autoName".equals(cookie.getName())){
						username = cookie.getValue();
					}
					if("autoPassword".equals(cookie.getName())){
						password = cookie.getValue();
					}
				}
				userService service = new userService();
				User user = service.findUserByNameAndPass(username, password);
				if(user != null){
					request.getSession().setAttribute("user", user);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
