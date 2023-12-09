package com.ass.dao.impl;

import java.util.List;

import com.asm.entity.Report;
import com.ass.dao.OEDAO;
import com.ass.dao.ReportDAO;

public class ReportDAOImpl extends OEDAO<Report> implements ReportDAO {

	@Override
	public Report selectLike(String id) {
		String jpql = "SELECT new Report(f.video.title, count(f), max(f.likeDate), min(f.likeDate)) FROM Favorite f where f.video.id = ?0  GROUP BY f.video.title";
		return super.findOne(Report.class, jpql, id);
	}

	@Override
	public List<Report> selectFavCountLiked() {
		String jpql = "SELECT new Report(f.video.title, count(f), max(f.likeDate), min(f.likeDate)) FROM Favorite f GROUP BY f.video.title";
		return super.finMany(Report.class, jpql);
	}

}
