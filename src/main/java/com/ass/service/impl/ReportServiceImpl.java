package com.ass.service.impl;

import java.util.List;

import com.asm.entity.Report;
import com.ass.dao.ReportDAO;
import com.ass.dao.impl.ReportDAOImpl;
import com.ass.service.ReportService;

public class ReportServiceImpl implements ReportService {

	private ReportDAO dao;
	
	public ReportServiceImpl() {
		dao = new ReportDAOImpl();
	}

	@Override
	public Report selectLike(String id) {
		Report r = dao.selectLike(id);
		if (r == null) {
			r = new Report();
			r.setLike(0);
		}
		return r;
	}

	@Override
	public List<Report> selectFavCountLiked() {
		return dao.selectFavCountLiked();
	}

}
