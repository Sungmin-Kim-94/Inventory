package kr.co.hk.model;

public class ImportVO {
	private int i_no;
	private ProductVO product;
	private int i_cnt;
	private String i_date;
	public ImportVO() {
		super();
	}
	public ImportVO(int i_no, ProductVO product, int i_cnt, String i_date) {
		super();
		this.i_no = i_no;
		this.product = product;
		this.i_cnt = i_cnt;
		this.i_date = i_date;
	}
	public int getI_no() {
		return i_no;
	}
	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
	public ProductVO getProduct() {
		return product;
	}
	public void setProduct(ProductVO product) {
		this.product = product;
	}
	public int getI_cnt() {
		return i_cnt;
	}
	public void setI_cnt(int i_cnt) {
		this.i_cnt = i_cnt;
	}
	public String getI_date() {
		return i_date;
	}
	public void setI_date(String i_date) {
		this.i_date = i_date;
	}
	@Override
	public String toString() {
		return "ImportVO [i_no=" + i_no + ", p_no=" + product.getP_no() + ", i_cnt="
				+ i_cnt + ", i_date=" + i_date + "]";
	}
	
	
}
