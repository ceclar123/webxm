package org.bond.webxm.service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bond.webxm.dao.UserDao;
import org.bond.webxm.entity.Userinfo;
import org.bond.webxm.util.StringUtil;

public class UserService extends BaseService {
	UserDao userDao;

	/**
	 * list
	 * 
	 * @param name
	 * @param start
	 * @param size
	 * @param order
	 * @return
	 */
	public String list(String name, int start, int size, String order) {
		List<Map<String, Object>> list = userDao.list(name, start, size, order);
		int count = count(name, start, size, order);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String s = gson.toJson(map);
		return s;
	}

	/**
	 * save
	 * 
	 * @param userinfo
	 * @return
	 */
	public String save(Userinfo userinfo) {
		String result = null;
		Date date = new Date();
		userinfo.setBirthday(date);
		userinfo.setPassword("888888");
		super.save(userinfo);
		result = "{\"success\":true,\"msg\":\"新增角色成功\"}";
		return result;
	}

	/**
	 * count
	 * 
	 * @param name
	 * @param start
	 * @param size
	 * @param order
	 * @return
	 */
	public int count(String name, int start, int size, String order) {
		return userDao.count(name, start, size, order);
	}

	/**
	 * getuserbyname
	 * 
	 * @param name
	 * @return
	 */
	public Userinfo getUserByName(String name) {
		return userDao.getUserByName(name);
	}

	/**
	 * update
	 * 
	 * @param request
	 * @param userinfo
	 * @param id
	 * @return
	 */
	public String update(HttpServletRequest request, Userinfo userinfo, Integer id) {
		Userinfo userinfoOld = super.get(Userinfo.class, id);
		if (null != userinfo) {
			StringUtil.requestToObject(request, userinfoOld);
		}
		super.update(userinfoOld);
		String result = "{\"success\":true,\"msg\":\"更新成功！\"}";
		return result;
	}

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void delete(Serializable id) {
		userDao.delete(Userinfo.class, id);
	}

	/*------------------*/
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
