package com.ticket.service.impl;

import java.util.List;

import com.ticket.dao.LineDao;
import com.ticket.dao.impl.LineDaoImpl;
import com.ticket.entites.Line;
import com.ticket.service.LineService;

public class LineServiceImpl implements LineService{

	private LineDao lineDao = new LineDaoImpl();
	
	@Override
	public List<Line> getAllLine(Line line) {
		return lineDao.getAllLine(line);
	}

	@Override
	public Line getLineById(String lineid) {
		Line line = null;
		try {
			int lineId = Integer.parseInt(lineid);
			line = lineDao.getLineById(lineId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return line;
	}

	@Override
	public void updateLine(Line line) {
		// TODO Auto-generated method stub
		lineDao.updateLine(line);
	}

	@Override
	public void deleteLine(int lineId) {
		lineDao.deleteLine(lineId);
	}

	@Override
	public void addLine(Line line) {
		lineDao.addLine(line);
		
	}

}
