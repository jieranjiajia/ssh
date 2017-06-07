package org.study.dao;

import java.io.Serializable;

public interface BaseDAO<T> {

	 T getById(Serializable id);
	
}
