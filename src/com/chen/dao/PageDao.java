/**
 * 
 */
package com.chen.dao;

import java.util.List;

import org.hibernate.Query;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */
public interface PageDao {
	public int getAllRowCount(String hql);
	public List query_Objects_ForPages(String hql, int offset, int length);
}
