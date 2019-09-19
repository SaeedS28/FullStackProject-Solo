package com.fdmgroup.dao.interfaces;

public interface IEditable<T extends IStorable> {
	public T update(T t);
}
