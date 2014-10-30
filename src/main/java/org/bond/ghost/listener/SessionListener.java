package org.bond.ghost.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 * Session创建域销毁 新开浏览器， 登录页面就可以监听到Session创建
 *
 */
public class SessionListener implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public SessionListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Date time = Calendar.getInstance().getTime();

			System.out.println("sessionCreated:--------------"
					+ format.format(time));
		} catch (Exception ex) {
			System.out.println("sessionCreated:" + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Date time = Calendar.getInstance().getTime();

			System.out.println("sessionDestroyed:--------------"
					+ format.format(time));
		} catch (Exception ex) {
			System.out.println("sessionDestroyed:" + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
