package org.bond.ghost.controller;

import org.bond.ghost.dao.MaximDAO;
import org.bond.ghost.model.MaximModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@Autowired(required = true)
	private MaximDAO baseDAO;

	@RequestMapping(value = "/index")
	public ModelAndView index() {
		return indexHome();
	}

	@RequestMapping(value = "/")
	public ModelAndView indexHome() {
		ModelAndView mav = new ModelAndView();

		// 名言警句
		MaximModel model = baseDAO.getRandOne();
		mav.addObject("maxim", model);

		mav.setViewName("/index");

		return mav;
	}

	@RequestMapping(value = "/404")
	public ModelAndView index404() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/404");

		return mav;
	}
}
