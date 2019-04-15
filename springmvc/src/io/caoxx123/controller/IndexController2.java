package io.caoxx123.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController2 {
	@RequestMapping("index")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "hello spring mvc Annotation");
		return mav;
	}
	@RequestMapping("hello")
	public ModelAndView handleRequest1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("hello");
		mav.addObject("message", "hellojsp");
		return mav;
	}
    @RequestMapping("/jump")
    public ModelAndView jump() {
        ModelAndView mav = new ModelAndView("redirect:/index");
        return mav;
    }
    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
    	Integer i=(Integer) session.getAttribute("count");
    	if(i==null) {
    		i=0;
    	}else {
    		i++;
    	}
    	session.setAttribute("count", i);
    	ModelAndView mav=new ModelAndView("check");
    	return mav;
    }
}
