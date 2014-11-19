package org.bond.webxm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bond.webxm.entity.Userinfo;

/**
 * SpringMVC+Hibernate +MySql+ EasyUI ---CRUD
 * 
 * @author 宗潇帅 类名称：UserDao
 * @date 2014-11-15 下午4:34:51 备注：
 */
public class UserDao extends BaseDao {

	public List<Map<String, Object>> list(String name, int start, int size, String order) {
		List<Object> param = new ArrayList<Object>();
		String sql = "select u.* from userinfo u where 1=1 ";
		if (null != name && name.trim().length() > 0) {
			sql += " and u.name like ? ";
			param.add("%" + name + "%");
		}
		if (null == order || order.length() == 0) {
			order = " birthday asc";
		}
		return super.listByNative(sql, param.toArray(), start, size, order);
	}

	public int count(String name, int start, int size, String order) {
		List<Object> param = new ArrayList<Object>();
		String sql = "select count(*) from userinfo u where 1=1 ";
		if (null != name && name.trim().length() > 0) {
			sql += " and u.name like ? ";
			param.add("%" + name + "%");
		}
		return super.countByNative(sql, param.toArray());
	}

	@SuppressWarnings("unchecked")
	public Userinfo getUserByName(String name) {
		String hql = "select u from Userinfo u where u.name=? ";
		List<Userinfo> list = super.list(hql, new Object[] { name });
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
