package com.ticket.dao;

import java.util.List;

import com.ticket.entites.Line;

public interface LineDao {

	public List<Line> getAllLine(Line line);

	public Line getLineById(int lineId);

	public void updateLine(Line line);

	public void deleteLine(int lineId);

	public void addLine(Line line);
}
