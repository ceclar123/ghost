package org.bond.ghost.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.bond.ghost.utility.MD5Util;
import org.bond.ghost.viewmodel.UserRegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, @RequestParam(value = "logname", required = true) String logname, @RequestParam(value = "psd", required = true) String psd) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			logname = logname.trim();
			psd = psd.trim();
			String md5psd = MD5Util.getMD5String(psd).toUpperCase();

			String sSql = "select ID from G_USER where STATUS=0 and LOGNAME=? and PSD=? and MD5PSD=?";
			SqlRowSet set = jdbcTemplate.queryForRowSet(sSql, logname, psd, md5psd);

			if (set.next()) {
				session.setAttribute("userid", set.getLong(1));
				mav.setViewName("/user/loginSuccess");
			} else {
				mav.setViewName("/user/loginFail");
				mav.addObject("errmsg", "未找到对应用户,用户可能已经被删除");
			}
		} catch (Exception ex) {
			mav.setViewName("/user/loginFail");
			mav.addObject("errmsg", ex.getMessage());

			ex.printStackTrace();
			Logger.getLogger(UserController.class).error(ex.getMessage());
		}

		return mav;
	}

	@RequestMapping(value = "/user/register")
	public ModelAndView register(UserRegisterModel user) {
		ModelAndView mav = new ModelAndView();
		try {
			String md5psd = MD5Util.getMD5String(user.getPsd().trim()).toUpperCase();
			System.out.println(user.getLogname() + "_" + user.getName());

			String sSql = "insert into G_USER(LOGNAME,NAME,PSD,MD5PSD) values(?,?,?,?)";
			int rows = jdbcTemplate.update(sSql, user.getLogname().trim(), user.getName(), user.getPsd().trim(), md5psd);

			mav.setViewName("/user/registerSuccess");
		} catch (Exception ex) {
			mav.setViewName("/user/registerFail");
			mav.addObject("errmsg", ex.getMessage());

			ex.printStackTrace();
			Logger.getLogger(UserController.class).error(ex.getMessage());
		}

		return mav;
	}

	@RequestMapping(value = "/user/toLogin")
	public ModelAndView toLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/login");

		return mav;
	}

	@RequestMapping(value = "/user/toRegister")
	public ModelAndView toRegister() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/register");

		return mav;
	}
}
