package org.study.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 通用数据操作的base接口
 * 
 * @param <T>
 */
public interface BaseDAO<T> {

	/**
	 * 根据主键id查询一个实体类
	 * @param id 主键
	 * @return 查询结果
	 */
	T getById(Serializable id);

	/**
	 * 根据查询的query(hql语句) 和 查询参数params来查询一个集合
	 * @param query
	 * @param parms
	 * @return
	 */
	List<T> getByProperty(String query, Object parms);
	
	/**
	 * 根据主键删除一条数据
	 * @param id
	 */
	void delete(T t);
	
	/**
	 * 插入或者更新一个pojo
	 * @param t
	 */
	void saveOrUpdate(T t);
	
	/**
	 * 动态更新一个实体类
	 * @param t
	 */
	void merger(T t);
	
	List<T> getAll();
}
