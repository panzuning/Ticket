package com.ticket.service;

import java.util.List;

import com.ticket.entites.Line;

public interface LineService {

	public List<Line> getAllLine(Line line);

	public Line getLineById(String lineid);

	public void updateLine(Line line);

	public void deleteLine(int lineId);

	public void addLine(Line line);
}
