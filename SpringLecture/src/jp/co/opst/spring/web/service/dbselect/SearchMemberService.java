package jp.co.opst.spring.web.service.dbselect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.opst.spring.web.db.dao.MemberDao;
import jp.co.opst.spring.web.db.dto.Member;

@Service
public class SearchMemberService {

		@Autowired
		private MemberDao memberDao;

//		public MemberDao getMemberDao() {
//			return memberDao;
//		}
//
//		public void setMemberDao(MemberDao memberDao) {
//			this.memberDao = memberDao;
//		}

		public List<Member> searchMemberById(String memberNamber){
			return memberDao.findBymemberNumber(memberNamber);
		}

		public List<Member> searchMemberAll(){
			return memberDao.findAll();
		}

		public List<Member> searchMember(String memberNamber){
			List<Member> resultList = null;
			if(!"".equals(memberNamber)){
				resultList = memberDao.findBymemberNumber(memberNamber);
			} else {
				resultList = memberDao.findAll();
			}
			return resultList;
		}



}
