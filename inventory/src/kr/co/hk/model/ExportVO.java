package kr.co.hk.model;

public class ExportVO {
	private int e_no;
	private ProductVO product;
	private int e_cnt;
	private String e_date;
	public ExportVO() {
		super();
	}
	public ExportVO(int e_no, ProductVO product, int e_cnt, String e_date) {
		super();
		this.e_no = e_no;
		this.product = product;
		this.e_cnt = e_cnt;
		this.e_date = e_date;
	}
	public int getE_no() {
		return e_no;
	}
	public void setE_no(int e_no) {
		this.e_no = e_no;
	}
	public ProductVO getProduct() {
		return product;
	}
	public void setProduct(ProductVO product) {
		this.product = product;
	}
	public int getE_cnt() {
		return e_cnt;
	}
	public void setE_cnt(int e_cnt) {
		this.e_cnt = e_cnt;
	}
	public String getE_date() {
		return e_date;
	}
	public void setE_date(String e_date) {
		this.e_date = e_date;
	}
	@Override
	public String toString() {
		return "ExportVO [e_no=" + e_no + ", p_no=" + product.getP_no() + ", e_cnt="
				+ e_cnt + ", e_date=" + e_date + "]";
	}
	
	
}
