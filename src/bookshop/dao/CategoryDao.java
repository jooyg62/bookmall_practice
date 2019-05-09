package bookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.util.BsUtil;
import bookshop.vo.CategoryVo;

public class CategoryDao {
	
	public Boolean insert(CategoryVo vo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = BsUtil.getConnection();

			String sql = 
					"insert into category values (null, ?);";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			
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

	public List<CategoryVo> getList(){
		List<CategoryVo> result = new ArrayList<CategoryVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = BsUtil.getConnection();
	
			String sql = "select no, name from category";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(sql);
			while( rs.next() ) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				
				CategoryVo vo = new CategoryVo();
				vo.setNo(no);
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
}
