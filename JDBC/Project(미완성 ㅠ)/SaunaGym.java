package Project;

public class SaunaGym extends Member {
	
	private int rdate;
	
	public SaunaGym(String name, String addr, int tel, int rdate) {
		super(name, addr, tel);
		this.rdate=rdate;
	}
	public void setRDate(int d) {
		this.rdate=d;
	}
	
	public int getRDate() {
		return rdate;
	}
	
	@Override
	public String toString() {
		return "이름= \t"+getName()+"주소= \t"+getAddr()+"전화번호= \t"+getTel();
	}
}

