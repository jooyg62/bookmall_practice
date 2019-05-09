package bookshop.test;

import java.util.List;

import bookshop.dao.CategoryDao;
import bookshop.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		//insert data
		insertDaoList();
				
		//getList Test
		getListTest();
	}
	
	private static void insertDaoList() {
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo = new CategoryVo();
		vo.setName("소설");
		dao.insert(vo);
		
		vo.setName("수필");
		dao.insert(vo);
		
		vo.setName("컴퓨터/IT");
		dao.insert(vo);
		
		vo.setName("인문");
		dao.insert(vo);
		
		vo.setName("경제");
		dao.insert(vo);
		
		vo.setName("예술");
		dao.insert(vo);
		
	}

	public static void getListTest() {
		List<CategoryVo> list = new CategoryDao().getList();
		
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
}
