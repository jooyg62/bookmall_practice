package bookshop.main;

import java.util.ArrayList;
import java.util.List;

import bookshop.dao.BookDao;
import bookshop.dao.CartDao;
import bookshop.dao.CategoryDao;
import bookshop.dao.MemberDao;
import bookshop.dao.OrderDao;
import bookshop.vo.BookVo;
import bookshop.vo.CartVo;
import bookshop.vo.CategoryVo;
import bookshop.vo.MemberVo;
import bookshop.vo.OrderDetailVo;
import bookshop.vo.OrderVo;

public class BookShop {

	public static void main(String[] args) {
//		insertMemberList();
//		insertCategoryList();
//		insertBookList();
//		insertCartList();
//		Long last_no = insertOrderList();
//		insertOrderDetailList(last_no);
		
		
		displayMemberList();
		displayCategoryList();
		displayBookList();
		displayCartList();
		displayOrderList();
		displayOrderDetailList();
	}

	private static void insertOrderDetailList(long lastNo) {
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

	private static Long insertOrderList() {
		OrderDao dao = new OrderDao();
		
		OrderVo vo = new OrderVo();
		vo.setAddr("서울시 관악구 신림로 58길 21");
		vo.setMember_no(1L);
		vo.setPrice(38900);
		
		Long lastNo = dao.insertOrder(vo);
		
		System.out.println(lastNo);
		
		return lastNo;
	}

	private static void insertCartList() {
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

	private static void insertBookList() {
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

	private static void insertCategoryList() {
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

	private static void insertMemberList() {
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

	private static void displayOrderDetailList() {
		System.out.println("================== 6. 주문 도서 리스트 ===============");
		List<OrderDetailVo> list = new OrderDao().getDetailList(1L);
		
		for(OrderDetailVo vo : list) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("주문번호: " + vo.getOrder_no());
			buffer.append(", No.: " + vo.getNo());
			buffer.append(", 책 제목: " + vo.getTitle());
			buffer.append(", 책 가격: " + vo.getPrice());
			
			System.out.println(buffer.toString());
		}
		
		
		System.out.println("\n");
	}

	private static void displayOrderList() {
		System.out.println("================== 5. 주문 리스트 ==================");
		List<OrderVo> list = new OrderDao().getList(1L);
		
		for(OrderVo vo : list) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("주문번호: " + vo.getNo());
			buffer.append(", 배송지: " + vo.getAddr());
			buffer.append(", 주문자명: " + vo.getName());
			buffer.append(", 결제 가격: " + vo.getPrice());
			
			System.out.println(buffer.toString());
		}
		
		
		System.out.println("\n");
	}
	
	private static void displayCartList() {
		System.out.println("================== 4. 카트 리스트 ==================");
		List<CartVo> list = new CartDao().getList(1L);
		
		for(CartVo vo : list) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("카테고리명: " + vo.getCategory_name());
			buffer.append(", 책 제목: " + vo.getTitle());
			buffer.append(", 책 가격: " + vo.getPrice());
			buffer.append(", 책 수량: " + vo.getCount());
			
			System.out.println(buffer.toString());
		}
		
		System.out.println("\n");
	}


	private static void displayBookList() {
		System.out.println("================== 3. 상품 리스트 ==================");
		List<BookVo> list = new BookDao().getList();
		
		for(BookVo vo : list) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("책 번호: " + vo.getNo());
			buffer.append(", 제목: " + vo.getTitle());
			buffer.append(", 가격: " + vo.getPrice());
			buffer.append(", 카테고리명: " + vo.getCate_name());
			
			System.out.println(buffer.toString());
		}
		
		System.out.println("\n");
	}

	private static void displayCategoryList() {
		System.out.println("================== 2. 카테고리 리스트 ===============");
		List<CategoryVo> list = new CategoryDao().getList();
		
		for(CategoryVo vo : list) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("카테고리 번호: " + vo.getNo());
			buffer.append(", 카테고리명: " + vo.getName());
			
			System.out.println(buffer.toString());
		}
		
		System.out.println("\n");
	}

	private static void displayMemberList() {
		System.out.println("================== 1. 회원 리스트 ==================");
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.getList();
		
		for(MemberVo vo : list) {
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("회원번호: " + vo.getNo());
			buffer.append(", 이름: " + vo.getName());
			buffer.append(", 전화번호: " + vo.getTel());
			buffer.append(", 이메일: " + vo.getEmail());
			buffer.append(", 패스워드: " + vo.getPassword());
			
			System.out.println(buffer.toString());
		}
		
		System.out.println("\n");
	}

}