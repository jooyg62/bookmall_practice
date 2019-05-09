package bookshop.test;

import java.util.List;

import bookshop.dao.MemberDao;
import bookshop.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		//insert data
		insertDaoList();
		
		//getList Test
		getListTest();
	}
	
	private static void insertDaoList() {
		MemberDao dao = new MemberDao();
		
		MemberVo vo = new MemberVo();
		vo.setName("서장규");
		vo.setEmail("jooyg62@naver.com");
		vo.setPassword("jgseo");
		vo.setTel("01041156736");
		
		dao.insert(vo);
		
		vo.setName("아무개");
		vo.setEmail("amugae@naver.com");
		vo.setPassword("amugae");
		vo.setTel("01012345678");
		
		dao.insert(vo);
		
	}

	public static void getListTest() {
		List<MemberVo> list = new MemberDao().getList();
		
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
	}
}
