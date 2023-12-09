package com.ass.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.asm.entity.Report;
import com.asm.utils.jpaUtil;



public interface ReportDAO {
	 

	
	Report selectLike(String id);
	List<Report> selectFavCountLiked();
//	public List VideoInYear(Integer year){
//		EntityManager em = jpaUtil.getEntityManager();
//		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Report.spFavoriteByYear2");
//		query.setParameter("year", year);
//		return query.getResultList();
//	}
//	
//	public static List<Report> selectVideoLike(){
//		EntityManager em = jpaUtil.getEntityManager();
//		TypedQuery<Report> query = em.createNamedQuery("Report.selectVidLike", Report.class);
//		return query.getResultList();
//	}
//	
//	
//	
//	
//	public  Report selectLikeVideoByID(String id){
//		EntityManager em = jpaUtil.getEntityManager();
//		String jpql = "SELECT new Report(o.video.title, count(o), " + " max(o.likeDate), min(o.likeDate))"
//				+ " FROM Favorite o where o.video.id = :id " + "GROUP BY o.video.title";
//		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
//		query.setParameter("id", id);
//		return query.getSingleResult();
//	}
//	
	
	
}
