package com.ass.service;

import java.util.List;

import com.asm.entity.Report;

public interface ReportService {
	Report selectLike(String id);
	List<Report> selectFavCountLiked();
}
