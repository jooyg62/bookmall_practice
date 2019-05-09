package bookshop.test;

import java.util.ArrayList;
import java.util.List;

import bookshop.dao.OrderDao;
import bookshop.vo.OrderDetailVo;
import bookshop.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		//insert data
//		Long last_no = insertDaoList();
		
		//insert detail data
//		insertDetailList(last_no);
		
		//getList Test
		getListTest(1L);
		getDetailListTest(1L);
	}
	
	private static Long insertDaoList() {
		OrderDao dao = new OrderDao();
		
		OrderVo vo = new OrderVo();
		vo.setAddr("서울시 관악구 신림로 58길 21");
		vo.setMember_no(1L);
		vo.setPrice(38900);
		
		Long last_no = dao.insertOrder(vo);
		
		System.out.println(last_no);
		
		return last_no;
	}
	
	private static void insertDetailList(Long lastNo) {
		OrderDao dao = new OrderDao();
		
		List<OrderDetailVo> voList = new ArrayList<OrderDetailVo>();
		
		OrderDetailVo vo = new OrderDetailVo();
		vo.setOrder_no(lastNo);
		vo.setBook_no(1L);
		vo.setCount(1);
		
		voList.add(vo);
		
		OrderDetailVo vo2 = new OrderDetailVo();
		
		vo2.setOrder_no(lastNo);
		vo2.setBook_no(2L);
		vo2.setCount(1);
		
		voList.add(vo2);
		
		dao.insertOrderBookList(voList);
	}


	public static void getListTest(Long param_member_no) {
		List<OrderVo> list = new OrderDao().getList(param_member_no);
		
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void getDetailListTest(Long order_no) {
		List<OrderDetailVo> list = new OrderDao().getDetailList(order_no);
		
		for(OrderDetailVo vo : list) {
			System.out.println(vo);
		}
	}
	
}
