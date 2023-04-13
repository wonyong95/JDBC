package Project;
import java.util.*;
import javax.swing.JOptionPane;

public class MemberEvent {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Member> map;
	int  i = 0;
	public MemberEvent(HashMap<String, Member> map) {
		this.map = map;
		this.i = i;
	}

	public void createMember(int i) {

		try {
			for (;;) {
				showFrame();
				String menu = String.valueOf(sc.nextInt());
				switch (menu) {

			case "1": {
				addM(i);
				break;
				}
			
			case "2": up();
			break;
			
			case "3":
				del();
				break;
//				
//			case "4":
//				sea();
//				break;

				default:
					System.out.println("정확히 입력해주세요\n");
					break;
				}
			}
		} catch (java.util.InputMismatchException e) {
			System.out.println("메뉴 번호중에서 선택하세요");

		}

	}




	public void showFrame() {
		System.out.println("--------등록 회원--------");
		System.out.println("1.등록 회원");
		System.out.println("2.수정 회원");
		System.out.println("3.삭제 회원");
		System.out.println("4.검색 회원");
		System.out.println("9. 종 료");
		System.out.println("--------메뉴를 입력하세요--------");
		
	

	}

	public void addM(int i) {
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		sc.nextLine();
		System.out.println("주소를 입력해주세요");
		String addr = sc.nextLine();	
		System.out.println("전화번호를 입력해주세요");	
		int tel = sc.nextInt();		
		System.out.println("전화번호 뒷 4자리를 다시 입력해주세요");
		String useId = sc.nextLine();
		sc.nextInt();
	
		Member newMen = new Member(name, addr, tel);		
		map.put(useId, newMen);
		
		System.out.println("등록개월수를 입력해주세요");
	        sc.nextLine();
	    System.out.println("PT등록수를 입력해주세요");
	        sc.nextLine();
		
	        
		System.out.println("정상적으로 등록되었습니다~~");

	}
	
	public void up() {
		
		
	}
	
	
	public void del() {
		System.out.println("전화번호 뒤 4자리를 입력해주세요");
		String userId = sc.nextLine();
		sc.nextLine();
		System.out.println(map.containsKey(userId));
		if(!map.containsKey(userId)) {
			System.out.println("등록된 회원 정보가 없습니다.");
			return;
		}
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
            System.out.println(key + " : " + map.get(key));
        }

		
		System.out.println("정상적으로 삭제되었습니다");
	}


}
