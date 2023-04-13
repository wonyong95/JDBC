package Project;

public class PTMember extends Member {
	
	private int pt_number;

	public PTMember(String name, String addr, int tel, int pt_number) {
		super(name, addr, tel);
		this.pt_number = pt_number;
	}
	
	public void setpt_number(int p) {
		this.pt_number=p;
	}
	
	public int getpt_number() {
		return pt_number;
	}
	
	@Override
	public String toString() {
		return "이름= \t"+getName()+"주소= \t"+getAddr()+"전화번호= \t"+getTel();
	}

}
