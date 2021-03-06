package com.ticket.service.impl;

import java.util.List;

import com.ticket.dao.TicketDao;
import com.ticket.dao.impl.TicketDaoImpl;
import com.ticket.entites.Ticket;
import com.ticket.service.TicketService;

public class TicketServiceImpl implements TicketService{

	private TicketDao ticketDao = new TicketDaoImpl();
	
	@Override
	public void addTicket(Ticket ticket) {
		ticketDao.addTicket(ticket);
	}

	@Override
	public List<Ticket> getAllTicket(Ticket ticket) {
		return ticketDao.getAllTicket(ticket);
	}

}
