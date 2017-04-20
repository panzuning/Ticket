package com.ticket.dao;

import java.util.List;

import com.ticket.entites.Ticket;

public interface TicketDao {

	public void addTicket(Ticket ticket);

	public List<Ticket> getAllTicket(Ticket ticket);
}
