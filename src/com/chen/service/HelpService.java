/**
 * 
 */
package com.chen.service;

import java.util.List;

import com.chen.bean.Helps;
import com.chen.bean.Pages;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */
public interface HelpService {
	public List<Helps> getAll();

	/**
	 * @param pageSize
	 * @param nowPage
	 * @return
	 */
	public Pages ManageAllForPages(int pageSize, int nowPage);

	/**
	 * @param index
	 * @return
	 */
	public Helps find(int index);

	/**
	 * @param thelp
	 */
	public void ManageAdd(Helps thelp);

	/**
	 * @param thelp
	 */
	public void ManageUpdate(Helps thelp);
}
