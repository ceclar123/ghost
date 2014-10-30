package org.bond.ghost.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
public class RequestListener implements ServletRequestListener {

	/**
	 * Default constructor.
	 */
	public RequestListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Date time = Calendar.getInstance().getTime();

			System.out.println("requestDestroyed:--------------"
					+ format.format(time));
		} catch (Exception ex) {
			System.out.println("requestDestroyed:" + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Date time = Calendar.getInstance().getTime();

			System.out.println("requestInitialized:--------------"
					+ arg0.getServletRequest().getLocalAddr()
					+ format.format(time));
		} catch (Exception ex) {
			System.out.println("requestInitialized:" + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
