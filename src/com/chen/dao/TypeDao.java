/**
 * 
 */
package com.chen.dao;

import java.util.List;

import com.chen.bean.Types;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */
public interface TypeDao {
	public boolean add(Types type);
	public boolean delete(int index);
	public boolean update(Types type);
	public Types find(int index);
	/**
	 * @param id
	 * @return
	 */
	public List<Types> getByCate(int id);
	public List<Types> new_getByCate(int id);
	/**
	 * @param id
	 * @return
	 */
	public List<Types> manageByCate(int id);
}
