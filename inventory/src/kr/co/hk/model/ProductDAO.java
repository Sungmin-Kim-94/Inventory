package kr.co.hk.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private ProductDAO() {}
	
	public static List<ProductVO> getProductList() {
		List<ProductVO> voList = new ArrayList<ProductVO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT "
				+ " P_NO, P_NAME, P_CNT, TO_CHAR(P_REGDATE, 'YYYY-MM-DD') "
				+ " FROM I_PRODUCT ";
		
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setP_no(rs.getInt("P_NO"));
				vo.setP_name(rs.getString("P_NAME"));
				vo.setP_cnt(rs.getInt("P_CNT"));
				vo.setP_regdate(rs.getString("P_REGDATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn, ps, rs);
		}
		return voList;
	}
}
