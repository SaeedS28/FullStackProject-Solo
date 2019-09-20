package com.fdmgroup.dao.interfaces;


public interface IStorage<T extends IStorable> {
	public T create(T t);
	public T findById(int id);
	
}
