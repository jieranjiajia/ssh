package dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import dao.BaseDAO;

@SuppressWarnings("all")
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	private Class<T> entityClass;
	
	public BaseDAOImpl() {
		init();
		if(null == entityClass) {
			throw new RuntimeException("初始化泛型类失败！");
		}
	}
	
	private void init() {
		Class<? extends BaseDAOImpl> clazz = getClass();
		Type genType = clazz.getGenericSuperclass();
		if(genType instanceof ParameterizedType) {
			Type[] actualTypeArguments = ((ParameterizedType) genType).getActualTypeArguments();
			this.entityClass = (Class<T>) actualTypeArguments[0];
		}
	}
	
	public T getById(Serializable id) {
		return (T) hibernateTemplate.get(getEntityClass(), id);
	}

	public Class getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}
	
}
