package com.mark.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mark.bean.User;
import com.mark.constant.Constant;
import com.mark.service.userService;
import com.mark.utils.MailUtils;
import com.mark.utils.UUIDUtils;

/**
 * Servlet implementation class userServlet
 */
public class userServlet extends baseServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 注册功能模块
	 * */
	//用户名查重
	public void checkName(HttpServletRequest request, HttpServletResponse response){  
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		userService service = new userService();
		try {
			String error = service.checkName(username);
			response.getWriter().println(error);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//注册
	public void register(HttpServletRequest request, HttpServletResponse response){  
		String code = request.getParameter("code");
		String vcode = (String) request.getSession().getAttribute("vcode");
		if(vcode.equalsIgnoreCase(code)){
			Map map = request.getParameterMap();
			User user = new User();
			
			try {
				BeanUtils.populate(user, map);
				user.setUid(UUIDUtils.getId());
				user.setState(Constant.USER_NOT_ACTIVE);
				user.setCode(UUIDUtils.getCode());
				userService service = new userService();
				int num = service.regist(user);
				if(num > 0){
					MailUtils.sendMail(user.getEmail(), "你好:"+user.getName()+",请<a href='http://localhost:8080/project1_mark/userServlet?method=active&code="+user.getCode()+"'>点击激活</a>");
					request.setAttribute("msg", "注册成功，请前往邮箱激活！");
					request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else{
			request.setAttribute("tis", "验证码错误!!!!!");
			try {
				request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	//激活用户
	public void active(HttpServletRequest request, HttpServletResponse response){
		String code = request.getParameter("code");
		userService service = new userService();
		try {
			User user = service.active(code);
			if(user != null){
				user.setState(Constant.USER_ACTIVED);
				user.setCode(null);
				service.update(user);
				request.setAttribute("msg", "恭喜激活成功，赶快去登录吧！");
				request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 登录功能模块
	 * */
	//登录
	public void login(HttpServletRequest request, HttpServletResponse response){
		String code = request.getParameter("code");
		String vcode = (String) request.getSession().getAttribute("vcode");
		if(vcode.equalsIgnoreCase(code)){	
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String rem = request.getParameter("rem");
			String autoLog = request.getParameter("autoLog");
			userService service = new userService();
			try {
				User user = service.findUserByNameAndPass(username, password);
				if(user != null){
					if(user.getState() == 1 && user.getCode() == null){
						//记住用户名
						if(rem != null){
							Cookie cookie = new Cookie("remName",user.getUsername());
							cookie.setMaxAge(60*60*24*7);
							response.addCookie(cookie);
						}else{
							Cookie cookie = new Cookie("remName",user.getUsername());
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
						//自动登录
						if(autoLog != null){
							Cookie cookie_name = new Cookie("autoName", user.getUsername());
							Cookie cookie_pass = new Cookie("autoPassword", user.getPassword());
							cookie_name.setMaxAge(60*60*24);
							cookie_pass.setMaxAge(60*60*24);
							response.addCookie(cookie_name);
							response.addCookie(cookie_pass);
						}else{
							Cookie cookie_name = new Cookie("autoName", user.getUsername());
							Cookie cookie_pass = new Cookie("autoPassword", user.getPassword());
							cookie_name.setMaxAge(0);
							cookie_pass.setMaxAge(0);
							response.addCookie(cookie_name);
							response.addCookie(cookie_pass);
						}
						request.getSession().setAttribute("user", user);
						response.sendRedirect("/project1_mark/index.jsp");
						
				}else{
					request.setAttribute("msg", "账号未激活，请先前往邮箱激活......");
					request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("msg", "账号密码不匹配......");
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			request.setAttribute("tis", "验证码错误!!!!!");
			try {
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	//注销
	public void logout(HttpServletRequest request, HttpServletResponse response){
		request.getSession().removeAttribute("user");
		try {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
