package com.ticket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticket.entites.Line;
import com.ticket.service.LineService;
import com.ticket.service.impl.LineServiceImpl;

/**
 * Servlet implementation class TicketController
 */
public class TicketController extends BaseController {
	private static final long serialVersionUID = 1L;
       
	private LineService lineService = new LineServiceImpl();
	
    public TicketController() {
        super();
        
        
    }
    
    protected void getAllLine(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String carnum = request.getParameter("carnum");
		String startstation = request.getParameter("startstation");
		String endstation = request.getParameter("endstation");
		Line line = new Line();
		line.setCar_num(carnum);
		line.setStart_station(startstation);
		line.setEnd_station(endstation);
		List<Line> lines = lineService.getAllLine(line);
		request.setAttribute("lines", lines);
		request.getRequestDispatcher("/pages/ticket/query.jsp").forward(request,
				response);
	}
    
    public void toPay(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/pages/ticket/pay.jsp").forward(request,
				response);
    }
}
