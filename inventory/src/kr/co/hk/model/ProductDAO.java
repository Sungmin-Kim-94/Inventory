package kr.co.hk.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private ProductDAO() {}
	
	// 물품 조회
	public static List<ProductVO> getProductList() {
		List<ProductVO> voList = new ArrayList<ProductVO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT "
				+ " P_NO, P_NAME, P_CNT, TO_CHAR(P_REGDATE, 'YYYY-MM-DD') AS P_REGDATE "
				+ " FROM I_PRODUCT "
				+ " ORDER BY P_REGDATE DESC ";
		
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
				
				System.out.println(vo);
				
				voList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn, ps, rs);
		}
		return voList;
	}
	
	// 물품 등록
	public static int registerProduct(ProductVO vo) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO I_PRODUCT "
				+ " (P_NO, P_NAME) "
				+ " VALUES "
				+ " ((SELECT NVL(MAX(P_NO), 0) + 1 FROM I_PRODUCT), ?) ";
		
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getP_name());
			result = ps.executeUpdate();
			
			System.out.println("result=" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn, ps);
		}
		
		return result;
	}
}
