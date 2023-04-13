package day02;
import java.util.*;
import java.sql.*;
public class MemoInsert {
	
	public static void main(String[] args) 
		throws ClassNotFoundException,SQLException
		{
		    Scanner sc=new Scanner(System.in);
		    System.out.println("작성자: ");
		    String name=sc.nextLine();
		    System.out.println("메모 내용: ");
		    String msg=sc.nextLine();
		    System.out.println(name+"/"+msg);
		    
		    
			//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 성공");
		    //2. DB연결
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott",pwd = "tiger";
		Connection con= DriverManager.getConnection(url,user,pwd);
		System.out.println("DB연결됨");
		    //3. SQL문 작성
		String sql="INSERT INTO memo(no,name,msg,wdate)";
		      sql+=" VALUES(MEMO_SEQ.NEXTVAL,'"+name+"','"+ msg +"',SYSDATE)";
		      System.out.println(sql);
		
		    //4. Statement얻기
		    Statement stmt=con.createStatement();
		    //5. execute()호출
		    // public int executeUpdate(String sql) : INSERT/DELETE/UPDATE문을 실행시키고자 할때
//		    boolean b=stmt.execute(sql);
		    int b=stmt.executeUpdate(sql);
		    //sql문에 의해 영향받은 레코드 개수를 반환한다
		    
		    System.out.println(b+"개의 레코드를 등록했습니다");
		    System.out.println((b>0)?"글쓰기 성공":"글쓰기 실패");
			//6. DB자원 반납 
		    if(stmt!=null) {
		    	stmt.close();
		    }if(con!=null) {
	            con.close();
		}
	
		}
}
