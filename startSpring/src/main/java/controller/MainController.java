package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.Member;

@Controller
public class MainController {
	
	// 처음 시작하는 페이지(value = "/")
	// 경로 확인하는 방법 : spring - appServlet - servlet-context.xml에서
	// value값을 지정해 놓은 대로 Index.jsp로 이동한다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Index() {
		return "home";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test1(Model model, Member member) {
		model.addAttribute("memb",member);
	//member를 model에 addAttribute를 만들어 사용자의 이름, 주소, 나이를 가지고 올 수 있다. 
		return "test";
	}
	
	//value값이 loginpage인 것을 받아온다!
	//return을 login.jsp로 이동!
	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String loginpage() {
		return "login";
	}
	
	@RequestMapping(value = "Login", method = RequestMethod.POST)
	public String Login(HttpServletRequest request,HttpSession session) {
		String userID = request.getParameter("id");
		String userPW = request.getParameter("pw");
		
		session.setAttribute("SessionID", userID);
		session.setAttribute("SessionPW", userPW);
		
		if(userID.equals("admin")&& userPW.equals("admin1234")) {
			return "sucess"; 
		}else {
			return "fail"; 
				
		}
	}
}
