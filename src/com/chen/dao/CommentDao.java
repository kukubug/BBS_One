/**
 * 
 */
package com.chen.dao;

import com.chen.bean.Comments;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */
public interface CommentDao {
	public boolean add(Comments comment);

	/**
	 * @param comments
	 */
	public void update(Comments comments);

	/**
	 * @param id
	 * @return
	 */
	public Comments find(int id);

	/**
	 * @param comment
	 */
	public void delete(Comments comment);

}
