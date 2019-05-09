package bookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.util.BsUtil;
import bookshop.vo.OrderDetailVo;
import bookshop.vo.OrderVo;

public class OrderDao {
	
	public Long insertOrder(OrderVo vo){
		long result = 0L;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = BsUtil.getConnection();

			String sql = 
					"insert into orders values (null, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAddr());
			pstmt.setLong(2, vo.getMember_no());
			pstmt.setInt(3, vo.getPrice());
			
			pstmt.executeUpdate();
			
			rs =pstmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				result = rs.getLong(1);				
			}
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		return result;
	}
	
	public Boolean insertOrderBookList(List<OrderDetailVo> voList){
		
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = BsUtil.getConnection();

			String sql = 
					"insert into order_book values (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			for(OrderDetailVo vo : voList) {
				pstmt.setLong(1, vo.getOrder_no());
				pstmt.setLong(2, vo.getBook_no());
				pstmt.setInt(3, vo.getCount());
				
				pstmt.executeUpdate();				
			}
			
			result = true;
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

	public List<OrderVo> getList(long param_member_no){
		List<OrderVo> result = new ArrayList<OrderVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = BsUtil.getConnection();
	
			String sql = 
					" select no, addr, member_no, price, (select name from member where no = member_no)" + 
					" from orders" + 
					" where member_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, param_member_no);
			
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				long no = rs.getLong(1);
				String addr = rs.getString(2);
				long member_no = rs.getLong(3);
				int price = rs.getInt(4);
				String name = rs.getString(5);
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setAddr(addr);
				vo.setMember_no(member_no);
				vo.setPrice(price);
				vo.setName(name);
								
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
				} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public List<OrderDetailVo> getDetailList(long param_order_no){
		List<OrderDetailVo> result = new ArrayList<OrderDetailVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = BsUtil.getConnection();
	
			String sql = 
					" select order_no, book_no, count, no, title, price, category_no" + 
					" from order_book a, book b" + 
					" where a.book_no = b.no" + 
					"  and a.order_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, param_order_no);
			
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				long order_no = rs.getLong(1);
				long book_no = rs.getLong(2);
				int count = rs.getInt(3);
				long no = rs.getLong(4);
				String title = rs.getString(5);
				int price = rs.getInt(6);
				long category_no = rs.getLong(7);
				
				OrderDetailVo vo = new OrderDetailVo();
				vo.setOrder_no(order_no);
				vo.setBook_no(book_no);
				vo.setCount(count);
				vo.setNo(no);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCategory_no(category_no);
								
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
				} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
