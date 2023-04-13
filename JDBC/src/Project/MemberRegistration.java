package Project;


import java.util.*;
import javax.swing.JOptionPane;

public class MemberRegistration {
	
	static HashMap<String, Member> map = new HashMap<>();
	public static void main(String[] args) {
		int i = 0;
		MemberEvent ma = new MemberEvent(map);
		ma.createMember(i++);

	}
	

	
	
	
	
	

}


