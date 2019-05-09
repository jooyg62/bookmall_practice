package bookshop.test;

import java.util.List;

import bookshop.dao.CartDao;
import bookshop.vo.CartVo;

public class CartDaoTest {
	
	public static void main(String[] args) {
		//insert
		insertDaoList();
				
		//getList Test
		getListTest(1L);
	}
	
	private static void insertDaoList() {
		CartDao dao = new CartDao();
		
		CartVo vo = new CartVo();
		vo.setBook_no(1);
		vo.setMember_no(1);
		vo.setCount(2);
		
		dao.insert(vo);
		
		vo.setBook_no(2);
		vo.setMember_no(1);
		vo.setCount(3);
		
		dao.insert(vo);
		
		vo.setBook_no(3);
		vo.setMember_no(2);
		vo.setCount(2);
		
		dao.insert(vo);
		
	}
	
	public static void getListTest(long member_no) {
		List<CartVo> list = new CartDao().getList(member_no);
		
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}

}
