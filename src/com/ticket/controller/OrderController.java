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

	/**
	 * 订单提交，将所有的订单信息获取
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void commitOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取所有的订单参数
		String lineid = request.getParameter("lineid");
		String userInfo = request.getParameter("userinfo");
		String count = request.getParameter("count");
		String totalcount = request.getParameter("totalcount");
		//将需要回显的参数保存在request中
		request.setAttribute("count", count);
		request.setAttribute("totalcount", totalcount);
		//根据路线的id获取路线信息
		Line line = lineService.getLineById(lineid);
		request.setAttribute("line", line);
		//判断票是否充足
		if (line.getTicket_num() > 0) {
			//票充足,获取保存在session中的用户信息
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			//将提交订单信息保存
			String orderid = orderService.commitOrder(line, userInfo, user.getUser_id(), count, totalcount);
			//将订单号保存request域，页面获取订单信息
			request.setAttribute("orderid", orderid);
			//重定向
			request.getRequestDispatcher("/pages/ticket/dopay.jsp").forward(request, response);
		} else {
			//如果票已卖完，将信息提示给用户
			request.setAttribute("message", "票已被抢光");
			request.getRequestDispatcher("/pages/ticket/pay.jsp").forward(request, response);
		}
	}

	/**
	 * 查询所有订单信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
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
	
	
	
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderid = request.getParameter("orderid");
		orderService.deleteOrderById(orderid);
		response.sendRedirect(request.getContextPath() + "/OrderController?method=getAllOrder");
	}
}
