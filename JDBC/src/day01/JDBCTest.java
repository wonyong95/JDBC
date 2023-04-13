package day01;
import java.sql.*;

public class JDBCTest {
   public static void main(String[] args) {
      // 1. Driver Loading : 드라이버를 메모리에 올린다. =>ojdbc6.jar
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("Driver Loading 성공");
         
         
      // 2. Oracle DB 접속
         String url ="jdbc:oracle:thin:@localhost:1521:XE";
         // protocol : DBMS 유형 : driver type : @DB 서버 host : port : 전역 데이터베이스명
         String user = "scott", pwd = "tiger";
         
         Connection con = DriverManager.getConnection(url,user,pwd); 
                                 // db 서버의 url, id, passwd 전달
         System.out.println("DB Connected!! "); 
         
      // 3. SQL문을 작성
         String sql="CREATE TABLE memo (no number(4) primary key,"; 
                sql+= "name varchar2(30) not null, "; 
                sql+= "msg varchar2(100), "; 
                sql+= "wdate date default sysdate) "; 
         
      // 4.Statement객체를 Connection의 createStatement()메서드를 이용해서 얻어온다
         Statement stmt = con.createStatement();
               
      // 5.execute()/executeUpdate()/executeQuery() 메서드 중 하나를 이용해서  sql문을 실행시킨다
 		 boolean b=stmt.execute(sql);//sql문을 실행시킴
 		 System.out.println("b: "+b);//select문을 실행시키면 true를 반환, 그외의 문잘을 실행시키면 false를반환함
 	 //6. DB와 연결된 자원을 반납=>반드시실행되어야함
         if(stmt!=null) stmt.close();
         if(con!=null) con.close();
 		 
      } catch (ClassNotFoundException e) {
         // [1]
         System.out.println("Dirver Loading 실패");
         e.printStackTrace();
         
      }catch (SQLException e) {
         // [2]
         System.out.println("DB연결 중 에러 발생");
      }
   }
}