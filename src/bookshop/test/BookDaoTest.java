package bookshop.test;

import java.util.List;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//insert
		insertDaoList();
		
		//getList Test
		getListTest();
	}
	
	private static void insertDaoList() {
		BookDao dao = new BookDao();
		
		BookVo vo = new BookVo();
		vo.setTitle("java performance fundamental");
		vo.setPrice(29000);
		vo.setCategory_no(3L);
		dao.insert(vo);
		
		vo.setTitle("언어의 정원");
		vo.setPrice(9900);
		vo.setCategory_no(1L);
		dao.insert(vo);
		
		vo.setTitle("워런 버핏 바이블");
		vo.setPrice(25200);
		vo.setCategory_no(5L);
		dao.insert(vo);
		
	}
	
	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
}
