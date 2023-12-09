package com.ass.dao;

import java.util.List;import java.util.function.ObjDoubleConsumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.asm.entity.User;
import com.asm.utils.jpaUtil;

public class OEDAO<E> {
	public static final EntityManager em = jpaUtil.getEntityManager();
	public static final EntityTransaction trans = em.getTransaction();
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}
	
	
	public E findById(Class<E> clazz, String id) {
		return em.find(clazz, id);
	}
	
	public List<E> findAll(Class<E> clazz, boolean isActive ){
		String eName = clazz.getSimpleName();
		StringBuilder jpql = new StringBuilder();
		jpql.append("select o from ").append(eName).append(" o");
		if(isActive) {
		}
		TypedQuery<E> query  = em.createQuery(jpql.toString(), clazz);
		return query.getResultList();
	}
	
	
	public List<E> findAll(Class<E> clazz, boolean isActive, int pageNumber, int pageSize){
		String eName = clazz.getSimpleName();
		StringBuilder jpql = new StringBuilder();
		jpql.append("select o from ").append(eName).append(" o");
		if(isActive) {
		}
		TypedQuery<E> query  = em.createQuery(jpql.toString(), clazz);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	
	
	public E findOne(Class<E> clazz, String jpql, Object ... params ) {
		TypedQuery<E> query = em.createQuery(jpql, clazz);
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<E> rs = query.getResultList();
		if(rs.isEmpty()) {
			return null;
		}
		return rs.get(0);
	}
	
	
	public List<E> finMany(Class<E> clazz, String jpql, Object ... params ) {
		TypedQuery<E> query = em.createQuery(jpql, clazz);
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> finManyNativeQuery(Class<E> clazz, String sql, Object ... params ) {
		Query query = em.createNativeQuery(sql, clazz);
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
		
	}
	
	
	public E create(E e) {
		try {
			trans.begin();
			em.persist(e);
			trans.commit();
			System.out.println("Successful");
		} catch (Exception e2) {
			// TODO: handle exception
			trans.rollback();
			System.out.println("Failed Insert!");
			e2.printStackTrace();
		}
		return e;
	}
	
	
	public E update(E e) {
		try {
			trans.begin();
			em.merge(e);
			trans.commit();
			System.out.println("Successful");
		} catch (Exception e2) {
			// TODO: handle exception
			trans.rollback();
			System.out.println("Failed Update!");
			e2.printStackTrace();
		}
		return e;
	}
	
	public E delete(E e) {
		try {
			trans.begin();
			em.remove(e);
			trans.commit();
			System.out.println("Successful");
		} catch (Exception e2) {
			// TODO: handle exception
			trans.rollback();
			System.out.println("Failed Remove!");
			e2.printStackTrace();
		}
		return e;
	}


	
}
