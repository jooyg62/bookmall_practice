package bookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.util.BsUtil;
import bookshop.vo.BookVo;

public class BookDao {
	
	public Boolean insert(BookVo vo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = BsUtil.getConnection();

			String sql = 
					"insert into book values (null, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategory_no());
			
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
	
	public List<BookVo> getList(){
		List<BookVo> result = new ArrayList<BookVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = BsUtil.getConnection();

			String sql = "select a.no, a.title, a.price, (select name from category where no = a.category_no), a.category_no from book a order by no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(sql);
			while( rs.next() ) {
				long no = rs.getLong(1);
				String title = rs.getString(2);
				int price = rs.getInt(3);
				String cate_name = rs.getString(4);
				long category_no = rs.getLong(5);
				
				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCate_name(cate_name);
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
