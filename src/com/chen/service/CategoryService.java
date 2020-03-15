/**
 * 
 */
package com.chen.service;

import java.util.List;


import com.chen.bean.Categorys;
import com.chen.bean.Pages;
import com.chen.bean.Topics;
import com.chen.bean.Types;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */
public interface CategoryService {
	public boolean add(Categorys cate);

	public boolean delete(int index);

	public boolean update(Categorys cate);

	public List<Categorys> getAll();

	/**
	 * @param id
	 * @return
	 */
	public List<Types> getType(int id);

	public List<Types> new_getType(int id);

	/**
	 * @param listType
	 * @return
	 */
	public List<Topics> getTopic(List<Types> listType);

	/**
	 * @param i
	 * @param nowPage
	 * @param listType
	 * @return
	 */
	public Pages getAllForPages(int pageSize, int nowPage, List<Types> listType);

	/**
	 * @param id
	 * @return
	 */
	public Categorys find(int id);

	/**
	 * @param id
	 * @return
	 */
	public List<Types> manageType(int id);
}
