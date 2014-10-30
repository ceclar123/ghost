package org.bond.ghost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class MaximController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/maxim/toEdit")
	public ModelAndView toEdit() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/maxim/edit");

		return mav;
	}
}
