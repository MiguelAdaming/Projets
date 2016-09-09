package com.adaming.adaming.dao;

import java.util.List;


public interface IGenericDao<T> {
	
	public T add(T t);
	
	public void delete(Long id);
	
	public T update(T t);
	
	public List<T> getAll();
	
	public T getById(Long id);

}
