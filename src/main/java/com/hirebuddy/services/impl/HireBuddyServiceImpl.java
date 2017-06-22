package com.hirebuddy.services.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.hirebuddy.common.ConfUtil;
import com.hirebuddy.dao.JPADAO;
import com.hirebuddy.exceptions.HireBuddyException;
import com.hirebuddy.services.HireBuddyService;
public class HireBuddyServiceImpl<K,E> implements HireBuddyService{
	private JPADAO dao;

	protected Class<E> entityClass; 

	

		

		@SuppressWarnings("unchecked") 
		public HireBuddyServiceImpl() { 
		    ParameterizedType genericSuperclass = (ParameterizedType) getClass() 
		            .getGenericSuperclass(); 
		    this.entityClass = (Class<E>) genericSuperclass 
		            .getActualTypeArguments()[1]; 
		} 
		
		public void setEntityManagerOnDao(EntityManager entityManager){
	    	dao.setEntityManager(entityManager);
	    	
	    }
		
		protected void setDAO(JPADAO<K, E> dAO){
			this.dao = dAO;
		}

		public E find(long id) throws HireBuddyException {
			try{
			return (E) dao.findById(id);
			}
			catch(Exception e){
				throw new HireBuddyException( entityClass.getName()+" - not found ", e);
			}
		}

		public List<E> findAll() throws HireBuddyException {
			try{
				return dao.findAll();
			}
			catch(Exception e){
				throw new HireBuddyException( entityClass.getName()+" - ", e);
			}
			
		}
	        
	        public List<E> find(int startFrom,int maxResults) throws HireBuddyException {
	            try{
			return dao.find(startFrom, maxResults);
	            }
	            catch(Exception e){
			throw new HireBuddyException( entityClass.getName()+" - ", e);
	            }
		}

		public void save(Object entity) throws HireBuddyException {
			try{
			dao.persist(entity);
			}
			catch(Exception e){
				throw new HireBuddyException( entityClass.getName()+" - ", e);
			}
			
		}

		public E update(Object entity) throws HireBuddyException {
			try{
	                        dao.merge(entity);
	                        return (E) dao.flush(entity);
			}
			catch(Exception e){
				throw new HireBuddyException( entityClass.getName()+" - ", e);
			}
		}

		public E saveOrUpdate(Object entity) throws HireBuddyException {
			try{
				entity = dao.merge(entity);
	            return (E) dao.flush(entity);
			}
			catch(Exception e){
				throw new HireBuddyException( entityClass.getName()+" - ", e);
			}
			
		}

		public void delete(long id) throws HireBuddyException {
			E e = null;	
			try{
				e = find(id);
				if(e == null){
					throw new HireBuddyException( entityClass.getName()+" - ");
				}
			}
			catch(Exception e1){
				throw new HireBuddyException( entityClass.getName()+" - ", e1);
			}
			
			
			try{
				if(e != null){
					dao.remove(e);
	                                dao.flush(e);
				}
			}
			catch(Exception e1){
				throw new HireBuddyException( entityClass.getName()+" - ", e1);
			}
			
			
		}

		public void deleteIfExisting(long id) throws Exception {
			try{
				E e = find(id);
					if(e != null){
						dao.remove(e);
	                                        dao.flush(e);
					}
			}
			catch(Exception e){
				throw new HireBuddyException( entityClass.getName()+" - ", e);
			}
			
		}

		public List findByNamedQueryAndNamedParams(String queryName, Map params) {
			// TODO Auto-generated method stub
			return dao.findByNamedQueryAndNamedParams(queryName, params);
		}

		public List findByNamedQueryAndNamedParams(String queryName, Map params,
				int startFrom, int maxResults) {
			return dao.findByNamedQueryAndNamedParams(queryName, params, startFrom, maxResults);
		}

		public int recordCount(String name, Map params) {
			return dao.recordCount(name, params);
		}
		


		
	}

