/**
 * 
 */
package com.chen.service.impl;

import java.util.List;

import com.chen.bean.Categorys;
import com.chen.bean.Pages;
import com.chen.bean.Topics;
import com.chen.bean.Types;
import com.chen.dao.CategoryDao;
import com.chen.dao.PageDao;
import com.chen.dao.TypeDao;
import com.chen.service.TypeService;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */

public class TypeServiceImpl implements TypeService {

	private PageDao pageDao;
	private TypeDao typeDao;
	private CategoryDao cateDao;

	public PageDao getPageDao() {
		return pageDao;
	}

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

	public TypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public CategoryDao getCateDao() {
		return cateDao;
	}

	public void setCateDao(CategoryDao cateDao) {
		this.cateDao = cateDao;
	}

	@Override
	public Pages getAllForPages(int pageSize, int nowPage, int typeId) {
		final String sql = "from Topics topic where topic.topicsType.id ="
				+ typeId + " order by topic.id desc";
		int allRecords = this.pageDao.getAllRowCount(sql);
		int totalPage = Pages.calculateTotalPage(pageSize, allRecords);// 总页数
		final int currentoffset = Pages.currentPage_startRecord(pageSize,
				nowPage);// 当前页的开始记录
		final int length = pageSize;
		final int currentPage = Pages.judgeCurrentPage(nowPage);
		List<Topics> listTopics = this.pageDao.query_Objects_ForPages(sql,
				currentoffset, length);
		Pages pagebean = new Pages();
		pagebean.setPageSize(pageSize);
		pagebean.setAllRecords(allRecords);
		pagebean.setCurrentPage(currentPage);
		pagebean.setTotalPages(totalPage);
		pagebean.setListTopics(listTopics);
		pagebean.init();
		return pagebean;
	}

	@Override
	public Types find(int id) {
		return this.typeDao.find(id);
	}

	@Override
	public void add(Types type) {
		Categorys cate = this.cateDao.find(type.getTypesCategory().getId());
		type.setTypesCategory(cate);
		this.typeDao.add(type);
	}

	@Override
	public void update(Types type) {
		this.typeDao.update(type);
	}

}
