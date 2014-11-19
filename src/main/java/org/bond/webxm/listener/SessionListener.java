package org.bond.webxm.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bond.webxm.controller.UserController;

public class SessionListener implements HttpSessionListener {

	private static Log log = LogFactory.getLog(UserController.class);
	private static Set<HttpSession> sessionSet = new HashSet<HttpSession>();

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		sessionSet.add(event.getSession());
		event.getSession().getServletContext().setAttribute("sessionSet", sessionSet);
		log.info("sessionCreated:" + event.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		sessionSet.remove(event.getSession());
		event.getSession().getServletContext().setAttribute("sessionSet", sessionSet);
		log.info("sessionDestroyed:" + event.getSession().getId());
	}

}
