package com.ass.dao;

import java.util.List;

import com.asm.entity.User;

public interface UserDAO {
	
	User findById(String id);
	User findByEmail(String email);
	User findByAndPass(String id, String pass );
	User findByIdAndemail(String id, String email );
	List<User> findAll();
	List<User> findAll(Integer pageNumber, Integer pageSize);
	List<User> findUserLikedByVideo(String video);
	User resetPass(User u);
	User create(User u);
	User update(User u);
	User delete(String u);
	
	
	
	
	
	
	
//
//	public  List<User> selectAll() {
//		EntityManager em = jpaUtil.getEntityManager();
//		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
//		List<User> list = query.getResultList();
//		em.close();
//		return list;
//	}
//	
//	
//	//Tìm theo user đã thích video
//	public  List<User> findUserLiked(String idV){
//		EntityManager em = jpaUtil.getEntityManager();
//		String jpql = "SELECT f.user FROM Favorite f where f.video.id= :idV";
//		TypedQuery<User> query = em.createQuery(jpql, User.class);
//		query.setParameter("idV", idV);
//		return query.getResultList();
//	}
//	
//	public  User selectUserById(String id) {
//		EntityManager em = jpaUtil.getEntityManager();
//		TypedQuery<User> query = em.createNamedQuery("User.findAllById", User.class);
//		query.setParameter("id", id);
//		return query.getSingleResult();
//	}
//	
//	public  void insert(User u) {
//		EntityManager em = jpaUtil.getEntityManager();
//		EntityTransaction trans = em.getTransaction();
//
//
//		// bắt đầu giao dịch
//		trans.begin();
//		try {
//			if(u!=null) {
//				em.persist(u);
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
//	}
//	
//	private  void update(User u) {
//		EntityManager em = jpaUtil.getEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		try {
//			trans.begin();
//			em.merge(u);
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
//	private  void delete(String id) {
//		EntityManager em = jpaUtil.getEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		try {
//			trans.begin();
//			User u = em.find(User.class, id);
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
	

	









