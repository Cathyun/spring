package com.icia.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
                    //value값 설정!
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	/*
	 * //처음 시작하는 페이지(value = "/") //경로 확인하는 방법 : spring - appServlet - servlet-context.xml에서 확인!
	 *  
	 * @RequestMapping(value = "/", method = RequestMethod.GET) 
	 * public String Index() { 
	 * return "Index"; 
	 * //실제 실행되는 jsp경로 //return/WEB-INF/views/Index.jsp
	 * //prefix: /WEB-INF/views //seffix:.jsp }
	 */
	
}
