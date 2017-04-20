package com.ticket.service;

import java.util.List;

import com.ticket.entites.Ticket;

public interface TicketService {

	public void addTicket(Ticket ticket);

	public List<Ticket> getAllTicket(Ticket ticket);

}
