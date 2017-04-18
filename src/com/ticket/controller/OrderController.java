package com.ticket.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ticket.entites.User;
import com.ticket.service.OrderService;
import com.ticket.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderController
 */
public class OrderController extends BaseController {
	private static final long serialVersionUID = 1L;
       
	private OrderService orderService = new OrderServiceImpl();
    /**
     * @see BaseController#BaseController()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void commitOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	String lineid = request.getParameter("lineid");
    	String userInfo = request.getParameter("userInfo");
    	HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
    	String orderid = orderService.commitOrder(lineid, userInfo, user.getUser_id());
    	request.setAttribute("orderid", orderid);
    	request.getRequestDispatcher("/pages/ticket/dopay.jsp").forward(request,
				response);
    }
}
