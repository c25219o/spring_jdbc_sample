package jp.co.opst.spring.web.controller.dbselect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.spring.web.db.dto.Member;
import jp.co.opst.spring.web.service.dbselect.SearchMemberService;

@Controller
public class SearchMemberController {

	@Autowired
	private SearchMemberService searchMemberService;

//	public SearchMemberService getSearchMemberService() {
//		return searchMemberService;
//	}
//
//	public void setSearchMemberService(SearchMemberService searchMemberService) {
//		this.searchMemberService = searchMemberService;
//	}

	@RequestMapping(value = "/executeMemberSearch", method = RequestMethod.POST)
	public ModelAndView searchMember(@RequestParam String memberNumber) {
		//List<Member> memberList = searchMemberService.searchMemberById(memberNumber);
		List<Member> memberList = searchMemberService.searchMember(memberNumber);
		return new ModelAndView("searchMemberResult", "memberList", memberList);
	}

	@RequestMapping(value="/searchMember")
	public String form() {
		return "searchMember";
	}

}
