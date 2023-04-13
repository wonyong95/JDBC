package day01;

import java.sql.*;

public class MemoInsert {
	public static void main(String[] args) 
		throws ClassNotFoundException, SQLException
		{
			//1.Dirver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
			
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott" ,pwd="tiger";
		    //2.DB연결
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB연결성공");
		/* CREATE SEQUENCE MEMO_SEQ
		 * START WITH 3
		 * INCREMENT BY 1;
		 * */
		    //3.SQL문 작성=>memo테이블에 Insert문장 작성하기
		String sql="INSERT INTO memo(no,name,msg,wdate)";		      
		       sql+=" VALUES(MEMO_SEQ.NEXTVAL,'최영희','나도 JAVA로 메모글을 작성합니다',SYSDATE) ";
		       System.out.println(sql);
		    //4.Statement 얻어오기
		Statement stmt=con.createStatement();
		    //5.execute()호출
		boolean b=stmt.execute(sql);
		System.out.println("b: "+b);
		System.out.println("데이터 삽입성공");
		//jdbc에서는 auto commit이됨
		    //6.DB연결자원 반납
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
		}
	

}
