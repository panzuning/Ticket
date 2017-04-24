package com.ticket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ticket.entites.Car;
import com.ticket.entites.User;
import com.ticket.service.UserService;
import com.ticket.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
public class UserController extends BaseController {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	public UserController() {
		super();
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAllUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userphone = request.getParameter("userphone");
		String useremail = request.getParameter("useremail");
		String admin = request.getParameter("admin");
		Integer isAdmin = null;
		if(admin != null && !"".equals(admin)){
			isAdmin = Integer.parseInt(admin);
		}
		User user = new User(username, null, userphone, useremail, null, isAdmin);
		List<User> users = userService.getAllUser(user);
		request.setAttribute("users", users);
		request.getRequestDispatcher("pages/user/list.jsp").forward(request,
				response);
	}

	public void toUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		Integer userId = Integer.parseInt(userid);
		User user = userService.getUserById(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("pages/user/update.jsp").forward(request,
				response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String userphone = request.getParameter("userphone");
		String useremail = request.getParameter("useremail");
		String useraddress = request.getParameter("useraddress");
		String adminflag = request.getParameter("adminflag");

		Integer userId = Integer.parseInt(userid);
		Integer adminFlag = Integer.parseInt(adminflag);

		User user = new User(userId, username, userpwd, userphone, useremail,
				useraddress, adminFlag);
		userService.updateUser(user);
		response.sendRedirect(request.getContextPath()
				+ "/UserController?method=getAllUser");
	}

	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		Integer userId = Integer.parseInt(userid);
		userService.deleteUserById(userId);
		response.sendRedirect(request.getContextPath()
				+ "/UserController?method=getAllUser");
	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String userphone = request.getParameter("userphone");
		String useremail = request.getParameter("useremail");
		String useraddress = request.getParameter("useraddress");
		String adminflag = request.getParameter("adminflag");

		Integer adminFlag = Integer.parseInt(adminflag);

		User user = new User(username, userpwd, userphone, useremail,
				useraddress, adminFlag);
		userService.addUser(user);
		response.sendRedirect(request.getContextPath()
				+ "/UserController?method=getAllUser");
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		User user = userService.getUserByName(username);
		if(user == null){
			request.setAttribute("message", "用户不存在");
		}else {
			if(user.getUser_pwd().equals(userpwd)){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/TicketController?method=getAllLine");
				return ;
			}else{
				request.setAttribute("message", "密码错误");
			}
		}
		request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
	}
	
	protected void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String userphone = request.getParameter("userphone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String admin = request.getParameter("adminFlag");
		System.out.println(admin);
		Integer admindb = 0;
		if(admin != null){
			admindb = Integer.parseInt(admin);
		}
		User user = new User(username, userpwd, userphone, email, address, admindb);
		userService.addUser(user);
		request.setAttribute("username", username);
		request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.invalidate();
		response.sendRedirect(request.getContextPath()
				+ "/index.jsp");
	}

}
