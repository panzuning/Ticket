package com.ticket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		List<User> users = userService.getAllUser();
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
	 * ��¼
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/pages/user/list.jsp").forward(request,
				response);

	}

	/**
	 * ע��
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
