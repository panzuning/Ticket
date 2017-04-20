package com.ticket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.ticket.entites.Line;
import com.ticket.entites.Order;
import com.ticket.entites.User;
import com.ticket.service.LineService;
import com.ticket.service.OrderService;
import com.ticket.service.impl.LineServiceImpl;
import com.ticket.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderController
 */
public class OrderController extends BaseController {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();
	private LineService lineService = new LineServiceImpl();

	/**
	 * @see BaseController#BaseController()
	 */
	public OrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void commitOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lineid = request.getParameter("lineid");
		String userInfo = request.getParameter("userinfo");
		String count = request.getParameter("count");
		String totalcount = request.getParameter("totalcount");
		request.setAttribute("count", count);
		request.setAttribute("totalcount", totalcount);
		Line line = lineService.getLineById(lineid);
		request.setAttribute("line", line);
		if (line.getTicket_num() > 0) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			String orderid = orderService.commitOrder(line, userInfo, user.getUser_id(), count, totalcount);
			request.setAttribute("orderid", orderid);
			request.getRequestDispatcher("/pages/ticket/dopay.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "票已被抢光");
			request.getRequestDispatcher("/pages/ticket/pay.jsp").forward(request, response);
		}
	}

	public void getAllOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderid = request.getParameter("orderid");
		String paystatu = request.getParameter("paystatu");
		Order order = new Order();
		order.setOrderId(orderid);
		if (paystatu != null && !"".equals(paystatu)) {
			order.setPayStatu(Integer.parseInt(paystatu));
		}
		List<Order> orders = orderService.getAllOrder(order);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/pages/order/list.jsp").forward(request, response);

	}
}
