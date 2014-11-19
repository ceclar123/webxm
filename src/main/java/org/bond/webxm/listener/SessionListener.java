package org.bond.webxm.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * SpringMVC+Hibernate +MySql+ EasyUI ---CRUD
 * @author 宗潇帅
 * 类名称：SessionListener 
 * @date 2014-11-15 下午4:35:06 
 * 备注：
 */
public class SessionListener implements HttpSessionListener {

	private static Set<HttpSession> sessionSet = new HashSet<HttpSession>();
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		sessionSet.add(event.getSession());
		event.getSession().getServletContext().setAttribute("sessionSet", sessionSet);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		sessionSet.remove(event.getSession());
		event.getSession().getServletContext().setAttribute("sessionSet", sessionSet);
	}

}
