package com.fdmgroup.dao.interfaces;

public interface IRemovable<T extends IStorable> {
	public boolean remove(T t);
}
