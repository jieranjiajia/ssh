package org.study.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.study.dao.BaseDAO;


/**
 * @param <T> 泛型T是指数据的持久化映射类{pojo}
 * ====================================
 * 这个是数据交互的基础类，hibernate5.0以后，spring4取消了hibernateDaoSupport的使用
 * 一般直接使用HibernateSession来获取session然后操作数据
 * ====================================
 */
/**
 * @param <T>
 */
/**
 * @param <T>
 */
@SuppressWarnings("all")
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {
	
	/** 具体泛型的实例 */
	private Class<T> entityClass;
	
	/** spring注入的sessionFactory */
	@Autowired private SessionFactory sessionFactory;
	
	/**
	 * 无参构造方法 
	 */
	public BaseDAOImpl() {
		init();
		if(null == entityClass) {
			throw new RuntimeException("初始化泛型类失败！");
		}
	}
	
	/**
	 * 用于获取具体的泛型参数
	 */
	private void init() {
		Class<? extends BaseDAOImpl> clazz = getClass();
		Type genType = clazz.getGenericSuperclass();
		if(genType instanceof ParameterizedType) {
			Type[] actualTypeArguments = ((ParameterizedType) genType).getActualTypeArguments();
			this.entityClass = (Class<T>) actualTypeArguments[0];
		}
	}
	
	public Class getEntityClass() {
		return entityClass;
	}
	
	/**
	 * @return Hibernate的session
	 */
	public Session getSession() {
		Assert.notNull(sessionFactory);
		return sessionFactory.openSession();
	}

	
	//------------------通用的数据操作方法------------------------
	@Override
	public T getById(Serializable id) {
		return (T)getSession().get(getEntityClass(), id);
	}
	
	@Override
	public List<T> getByProperty(String query, Object params) {
		Query _query = getSession().createQuery(query);
		this.setParamters(_query, params);
		return _query.list();
	}
	
	@Override
	public void delete(T t) {
		getSession().delete(t);
	}
	
	@Override
	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}
	
	@Override
	public void merger(T t) {
		getSession().merge(t);
	}

	/** 基本的通用的将参数动态的赋值给query */
	public void setParamters(Query query, Object params) {
		if(null == params) {
			return;
		}
		
		if(params instanceof String) {
			query.setParameter(0, params);
			return;
		}
		
		Class<? extends Object> type = params.getClass();
		/*如果params是String 或者Integer等类型时*/
		try {
			if(((Class)type.getField("TYPE").get(null)).isPrimitive()) {
				query.setParameter(0, params);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*当封装参数是以map的形式传入进来的时候*/
		if(params instanceof Map) {
			Map<String,Object> mapParams = (Map) params;
			for(Map.Entry<String, Object> entry : mapParams.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				if(value instanceof Collection) {
					Collection col = (Collection) value;
					query.setParameterList(key, col);
				} else if(value instanceof Map) {
					Map valueMap = (Map) value;
					query.setProperties(valueMap);
				} else if (value instanceof Object[]) {
					Object[] arr = (Object[]) value;
					query.setParameterList(key, arr);
				} else {
					query.setParameter(key, value);
				}
			}
		} else {
			/*如果不是，将认为是以一个对象的传入进来的，将调用这个对象的get方法获取相应的参数*/
			query.setProperties(params);
		}
	}
	
	/** 以动态传参的形式将params参数传给占位符'?' */
	public void setParameter(Query query,Object... params) {
		Assert.notNull(params);
		for(int i = 0,len = params.length; i < len; i++) {
			query.setParameter(i, params[i]);
		}
	}
}
