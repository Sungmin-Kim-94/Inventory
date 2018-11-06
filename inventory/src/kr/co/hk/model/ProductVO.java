package kr.co.hk.model;

public class ProductVO {
	private int p_no;
	private String p_name;
	private int p_cnt;
	private String p_regdate;

	public ProductVO() {
		super();
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_cnt() {
		return p_cnt;
	}

	public void setP_cnt(int p_cnt) {
		this.p_cnt = p_cnt;
	}

	public String getP_regdate() {
		return p_regdate;
	}

	public void setP_regdate(String p_regdate) {
		this.p_regdate = p_regdate;
	}

	@Override
	public String toString() {
		return "ProductVO [p_no=" + p_no + ", p_name=" + p_name + ", p_cnt="
				+ p_cnt + ", p_regdate=" + p_regdate + "]";
	}

}
