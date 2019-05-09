package bookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.util.BsUtil;
import bookshop.vo.CartVo;

public class CartDao {
	
	public Boolean insert(CartVo vo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = BsUtil.getConnection();

			String sql = 
					"insert into cart values (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getBook_no());
			pstmt.setLong(2, vo.getMember_no());
			pstmt.setLong(3, vo.getCount());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
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

	public List<CartVo> getList(long member_no){
		List<CartVo> result = new ArrayList<CartVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = BsUtil.getConnection();
	
			String sql = "select (select name from category where no = b.category_no), b.title, b.price, a.count" + 
					" from cart a, book b, member c" + 
					" where a.book_no = b.no" + 
					"  and a.member_no = c.no" +
					"  and c.no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, member_no);
			
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				String category_name = rs.getString(1);
				String title = rs.getString(2);
				int price = rs.getInt(3);
				int count = rs.getInt(4);
				
				CartVo vo = new CartVo();
				vo.setCategory_name(category_name);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCount(count);
								
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
