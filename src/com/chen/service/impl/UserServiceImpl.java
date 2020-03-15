/**
 * 
 */
package com.chen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chen.bean.Comments;
import com.chen.bean.Grades;
import com.chen.bean.News;
import com.chen.bean.Pages;
import com.chen.bean.Topics;
import com.chen.bean.Types;
import com.chen.bean.Users;
import com.chen.dao.CommentDao;
import com.chen.dao.GradeDao;
import com.chen.dao.NewDao;
import com.chen.dao.PageDao;
import com.chen.dao.TopicDao;
import com.chen.dao.UserDao;
import com.chen.service.UserService;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private PageDao pageDao;
	private TopicDao topicDao;
	private CommentDao commentDao;
	private NewDao newDao;
	private GradeDao gradeDao;

	@Override
	public boolean add(Users user) {
		Grades grade = new Grades();
		grade.setId(1);
		user.setUsersGrade(grade); // 用户注册等级为1级
		Date rtime = new Date();
		user.setRegisterTime(rtime);
		user.setIntegral(50); // 用户注册送50积分
		return this.userDao.add(user);
	}

	@Override
	public void delete(int index) {
		Users user = this.userDao.find(index);
		user.setStatus(1);
		this.userDao.update(user);
	}

	@Override
	public void unDelete(int index) {
		Users user = this.userDao.find(index);
		user.setStatus(0);
		this.userDao.update(user);
	}

	@Override
	public Users find(int index) {
		return this.userDao.find(index);
	}

	@Override
	public boolean update(Users user) {
		return this.userDao.update(user);
	}

	@Override
	public Users findByNP(Users user) {
		return this.userDao.findByNP(user);
	}

	@Override
	public Grades findGrade(int id) {
		return this.gradeDao.find(id);
	}

	@Override
	public boolean findByName(String userName) {
		return this.userDao.findByName(userName);
	}

	@Override
	public boolean findByNic(String userNic) {
		return this.userDao.findByNic(userNic);
	}

	@Override
	public Pages getTopicsForPages(int pageSize, int nowPage, int id) {
		final String sql = "from Topics as topic  where topic.topicsUser.id ="
				+ id + " order by topic.id desc";
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
	public Pages getCommentsForPages(Users user, int pageSize, int nowPage,
			int id) {
		final String sql = "from Comments as comment  where comment.commentsUser.id ="
				+ id
				+ " and comment.commentsTopic.topicsUser.id !="
				+ user.getId() + " order by comment.id desc";
		int allRecords = this.pageDao.getAllRowCount(sql);
		int totalPage = Pages.calculateTotalPage(pageSize, allRecords);// 总页数
		final int currentoffset = Pages.currentPage_startRecord(pageSize,
				nowPage);// 当前页的开始记录
		final int length = pageSize;
		final int currentPage = Pages.judgeCurrentPage(nowPage);
		List<Comments> listComments = this.pageDao.query_Objects_ForPages(sql,
				currentoffset, length);
		Pages pagebean = new Pages();
		pagebean.setPageSize(pageSize);
		pagebean.setAllRecords(allRecords);
		pagebean.setCurrentPage(currentPage);
		pagebean.setTotalPages(totalPage);
		pagebean.setListComments(listComments);
		pagebean.init();
		return pagebean;
	}

	@Override
	public Pages getNewsForPages(int pageSize, int nowPage, int id) {
		final String sql = "from News as tnew  where tnew.newsTopic.topicsUser.id ="
				+ id + " order by tnew.id desc";
		int allRecords = this.pageDao.getAllRowCount(sql);
		int totalPage = Pages.calculateTotalPage(pageSize, allRecords);// 总页数
		final int currentoffset = Pages.currentPage_startRecord(pageSize,
				nowPage);// 当前页的开始记录
		final int length = pageSize;
		final int currentPage = Pages.judgeCurrentPage(nowPage);
		List<News> listNews = this.pageDao.query_Objects_ForPages(sql,
				currentoffset, length);
		Pages pagebean = new Pages();
		pagebean.setPageSize(pageSize);
		pagebean.setAllRecords(allRecords);
		pagebean.setCurrentPage(currentPage);
		pagebean.setTotalPages(totalPage);
		pagebean.setListNews(listNews);
		pagebean.init();
		return pagebean;
	}

	@Override
	public Pages ManageUsersForPage(int pageSize, int nowPage) {
		final String sql = "from Users as user order by user.id asc";
		int allRecords = this.pageDao.getAllRowCount(sql);
		int totalPage = Pages.calculateTotalPage(pageSize, allRecords);// 总页数
		final int currentoffset = Pages.currentPage_startRecord(pageSize,
				nowPage);// 当前页的开始记录
		final int length = pageSize;
		final int currentPage = Pages.judgeCurrentPage(nowPage);
		List<Users> listUser = this.pageDao.query_Objects_ForPages(sql,
				currentoffset, length);
		Pages pagebean = new Pages();
		pagebean.setPageSize(pageSize);
		pagebean.setAllRecords(allRecords);
		pagebean.setCurrentPage(currentPage);
		pagebean.setTotalPages(totalPage);
		pagebean.setListUser(listUser);
		pagebean.init();
		return pagebean;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public PageDao getPageDao() {
		return pageDao;
	}

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

	public TopicDao getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public NewDao getNewDao() {
		return newDao;
	}

	public void setNewDao(NewDao newDao) {
		this.newDao = newDao;
	}

	public GradeDao getGradeDao() {
		return gradeDao;
	}

	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

}
