package com.icia.member.controller;

/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*import com.icia.member.dto.MemberDTO;*/
import com.icia.member.dto.joinDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mbsvc;
	
	private ModelAndView mav;
			
//	첫화면 설정 - join
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="join",method=RequestMethod.GET)
	public ModelAndView insert(@ModelAttribute joinDTO member) {
		mav = new ModelAndView();
		mav = mbsvc.insert(member);
		return mav;
	}
		
}
