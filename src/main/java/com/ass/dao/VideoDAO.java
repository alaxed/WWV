package com.ass.dao;

import java.util.List;

import com.asm.entity.Video;





public interface VideoDAO {

	Video findById(String id);
	List<Video> findAll();
	List<Video> findAll(Integer pageNumber, Integer pageSize);
	List<Video> find6V();
	List<Video> selectVideoFavByUserId(String userId);
	Video findByTitle(String title);
	Video create(Video v);
	Video update(Video v);
	Video delete(Video v);
	
//	// lấy hết data video
//	public List<Video> selectAll() {
//		EntityManager em = jpaUtil.getEntityManager();
//		TypedQuery<Video> query = em.createNamedQuery("Video.findAll", Video.class);
//		return query.getResultList();
//	}
//	
//	public List<Video> selectVideoByFav() {
//		EntityManager em = jpaUtil.getEntityManager();
//		TypedQuery<Video> query = em.createNamedQuery("Video.finbVideoByFav", Video.class);
//		return query.getResultList();
//	}
//	
//	
//
//	// Tìm video theo đuocwj user like (id cảu user cần truyền)
//	public  List<Video> findFavoritesVideoById(String id) {
//		EntityManager em = jpaUtil.getEntityManager();
//		TypedQuery<Video> query = em.createNamedQuery("Video.finbyUser", Video.class);
//		query.setParameter("id", id);
//		return query.getResultList();
//	}
//
//	public  Video selectVideoById(String id) {
//		EntityManager em = jpaUtil.getEntityManager();
//		TypedQuery<Video> query = em.createNamedQuery("Video.findAllById", Video.class);
//		query.setParameter("id", id);
//		return query.getSingleResult();
//	}
//
//	// tìm video theo keyword
//	public List<Video> findFVByKeyword(String kw) {
//		EntityManager em = jpaUtil.getEntityManager();
//		TypedQuery<Video> query = em.createNamedQuery("Video.findByKw", Video.class);
//		query.setParameter("kw", "%" + kw.trim() + "%");
//		return query.getResultList();
//	}
//	
//	
//	public List<Video> FillRandom6Vid(){
//		EntityManager em = jpaUtil.getEntityManager();
//		String sql = "SELECT TOP 6 * FROM videos ORDER BY NEWID()";
//		Query query = em.createNativeQuery(sql, Video.class);
//
//		return query.getResultList();
//	}
//	
//	
//
//	public  void insert(Video v) {
//		EntityManager em = jpaUtil.getEntityManager();
//		EntityTransaction trans = em.getTransaction();
//
//
//		// bắt đầu giao dịch
//		trans.begin();
//		try {
//			em.persist(v);
//			trans.commit();
//			System.out.println("Thanh cong");
//		} catch (Exception e) {
//			// TODO: handle exception
//			trans.rollback();
//			System.out.println("That bai");
//			e.printStackTrace();
//		}
//	}
//
//	private  void update(Video v) {
//		EntityManager em = jpaUtil.getEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		try {
//			trans.begin();
//			em.merge(v);
//			trans.commit();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			trans.rollback();
//			System.out.println("That bai");
//			e.printStackTrace();
//		}
//	}
//	
//	
//	private void delete(String id) {
//		EntityManager em = jpaUtil.getEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		try {
//			trans.begin();
//			Video u = em.find(Video.class, id);
//			if (u != null) {
//				em.remove(u);
//				trans.commit();
//				System.out.println("Thanh cong");
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			trans.rollback();
//			System.out.println("That bai");
//			e.printStackTrace();
//		}
//
//	}
	

	
}
