package dao;

import java.io.Serializable;

public interface BaseDAO<T> {

	 T getById(Serializable id);
	
}
