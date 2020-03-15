/**
 * 
 */
package com.chen.service;

import com.chen.bean.Comments;
import com.chen.bean.Topics;
import com.chen.bean.Users;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */
public interface CommentService {

	public boolean newComment(Comments comment, Users user, Topics topic);


	/**
	 * @param comment
	 * @param topic 
	 */
	public void deleteComment(Comments comment, Topics topic);
}
