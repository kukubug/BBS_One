/**
 * 
 */
package com.chen.dao;

import com.chen.bean.Grades;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */
public interface GradeDao {

	/**
	 * @param id
	 * @return
	 */
	public Grades find(int id);

}
