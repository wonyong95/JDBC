package Project;

public class Member {
	
	private String name; //이름
	private String addr; //주소
	private int tel; //전화번호
	
	public Member(String name, String addr, int tel) {
		this.name =name;
		this.addr =addr;
		this.tel =tel;
		
	}
	
	public void setName(String n) {
		this.name=n;
	}
	public void setAddr(String a) {
		this.addr=a;
	}
	public void setTle(int t) {
		this.tel=t;
	}
	

	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	public int getTel() {
		return tel;
	}
	
	@Override
	public String toString() {
		return "이름= \n"+getName()+"주소= \n"+getAddr()+"전화번호= \n"+getTel();
	}
	
	public boolean EqualeName(String name) {
		return this.name.equals(name);
	}

}
