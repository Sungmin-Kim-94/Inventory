package kr.co.hk.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private ProductDAO() {
	}
	
	public static List<ExportVO> getExportList() {
		List<ExportVO> voList = new ArrayList<ExportVO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT "
				+ " E.E_NO, P.P_NO, P.P_NAME, E.E_CNT, TO_CHAR(E.E_DATE, 'YYYY-MM-DD') AS E_DATE "
				+ " FROM I_EXPORT E " + " INNER JOIN I_PRODUCT P "
				+ " ON E.P_NO = P.P_NO " + " ORDER BY E.E_NO DESC ";

		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ExportVO vo = new ExportVO();
				vo.setProduct(new ProductVO());

				vo.setE_no(rs.getInt("E_NO"));
				vo.getProduct().setP_no(rs.getInt("P_NO"));
				vo.getProduct().setP_name(rs.getString("P_NAME"));
				vo.setE_cnt(rs.getInt("E_CNT"));
				vo.setE_date(rs.getString("E_DATE"));

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

	public static List<ImportVO> getImportList() {
		List<ImportVO> voList = new ArrayList<ImportVO>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT "
				+ " I.I_NO, P.P_NO, P.P_NAME, I.I_CNT, TO_CHAR(I.I_DATE, 'YYYY-MM-DD') AS I_DATE "
				+ " FROM I_IMPORT I " + " INNER JOIN I_PRODUCT P "
				+ " ON I.P_NO = P.P_NO " + " ORDER BY I.I_NO DESC ";

		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ImportVO vo = new ImportVO();
				vo.setProduct(new ProductVO());

				vo.setI_no(rs.getInt("I_NO"));
				vo.getProduct().setP_no(rs.getInt("P_NO"));
				vo.getProduct().setP_name(rs.getString("P_NAME"));
				vo.setI_cnt(rs.getInt("I_CNT"));
				vo.setI_date(rs.getString("I_DATE"));

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
	
	public static int insertExport(ExportVO vo) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO I_EXPORT " + " (E_NO, P_NO, E_CNT) "
				+ " VALUES "
				+ " ((SELECT NVL(MAX(E_NO), 0) + 1 FROM I_EXPORT), ?, ?) ";

		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getProduct().getP_no());
			ps.setInt(2, vo.getE_cnt());
			result = ps.executeUpdate();

			if (result > 0) {
				int updateCnt = vo.getProduct().getP_cnt() - vo.getE_cnt();
				System.out.println(vo.getProduct().getP_cnt() + " => "
						+ updateCnt);
				updateProductCnt(vo.getProduct().getP_no(), updateCnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn, ps);
		}
		
		return result;
	}

	public static int insertImport(ImportVO vo) {
		int result = -1;

		Connection conn = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO I_IMPORT " + " (I_NO, P_NO, I_CNT) "
				+ " VALUES "
				+ " ((SELECT NVL(MAX(I_NO), 0) + 1 FROM I_IMPORT), ?, ?) ";

		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getProduct().getP_no());
			ps.setInt(2, vo.getI_cnt());
			result = ps.executeUpdate();

			if (result > 0) {
				int updateCnt = vo.getProduct().getP_cnt() + vo.getI_cnt();
				System.out.println(vo.getProduct().getP_cnt() + " => "
						+ updateCnt);
				updateProductCnt(vo.getProduct().getP_no(), updateCnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn, ps);
		}

		return result;
	}

	public static int updateProductName(int p_no, String p_name) {
		int result = -1;

		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE I_PRODUCT " + " SET P_NAME = ? "
				+ " WHERE P_NO = ? ";
		
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, p_name);
			ps.setInt(2, p_no);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn, ps);
		}
		
		return result;
	}
	
	public static int updateProductCnt(int p_no, int p_cnt) {
		int result = -1;

		Connection conn = null;
		PreparedStatement ps = null;

		String sql = " UPDATE I_PRODUCT " + " SET P_CNT = ? "
				+ " WHERE P_NO = ? ";

		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, p_cnt);
			ps.setInt(2, p_no);
			result = ps.executeUpdate();
			System.out.println("result=" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn, ps);
		}

		return result;
	}

	public static ProductVO getProduct(int p_no) {
		ProductVO vo = new ProductVO();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT "
				+ " P_NO, P_NAME, P_CNT, TO_CHAR(P_REGDATE, 'YYYY-MM-DD') AS P_REGDATE "
				+ " FROM I_PRODUCT " + " WHERE P_NO = ? ";

		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, p_no);
			rs = ps.executeQuery();

			while (rs.next()) {
				vo.setP_no(rs.getInt("P_NO"));
				vo.setP_name(rs.getString("P_NAME"));
				vo.setP_cnt(rs.getInt("P_CNT"));
				vo.setP_regdate(rs.getString("P_REGDATE"));

				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn, ps, rs);
		}

		return vo;
	}

	// 물품 조회
	public static List<ProductVO> getProductList() {
		List<ProductVO> voList = new ArrayList<ProductVO>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT "
				+ " P_NO, P_NAME, P_CNT, TO_CHAR(P_REGDATE, 'YYYY-MM-DD') AS P_REGDATE "
				+ " FROM I_PRODUCT " + " ORDER BY P_NO DESC ";

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

		String sql = " INSERT INTO I_PRODUCT " + " (P_NO, P_NAME) "
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
