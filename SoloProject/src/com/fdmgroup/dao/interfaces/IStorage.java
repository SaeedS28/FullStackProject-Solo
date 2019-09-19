package com.fdmgroup.dao.interfaces;

import java.util.List;

public interface IStorage<T extends IStorable> {
	public T create(T t);
	public T findById(int id);
	public List<T> findAll();
}
