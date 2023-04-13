package day03;
import java.sql.*;
import common.util.DBUtil;
public class EmpSelect {

	public static void main(String[] args) throws Exception{
		Connection con=DBUtil.getCon();
        //EMP의 모든정보를 가져오자
//		String sql="SELECT * FROM emp ORDER BY empno ASC";
		//lpad() /rpad()
		String sql="SELECT empno,ename, rpad(job,12,' ') job,";
		sql+="rpad(mgr,10,' ') mgr, hiredate,";
		sql+="lpad(sal,10,' ') sal, lpad(comm,10,' ') comm,";
		sql+="deptno from emp order by 1";
		System.out.println(sql);
		Statement st=con.createStatement();
		
		//boolean execute(): 모든sql문 실행
		//int executeUpdate(): DML문장 실행
		//ResultSet executeQuery(): DQL문장(select문)실행
		ResultSet rs=st.executeQuery(sql);
		
		//반복문 돌면서 데이터 꺼내 출력하세요
		while (rs.next()) {
	         int no=rs.getInt(1);
	         String name = rs.getString(2);
	         String job = rs.getString(3);
	         int mgr = rs.getInt(4);
	         java.sql.Date hireDate = rs.getDate(5);
	         int sal = rs.getInt(6);
	         int comm = rs.getInt(7);
	         int deptno = rs.getInt(8);
	         
         System.out.printf("%d\t%s\t%s\n\t%d\t%s\t%d\t%d\t%d\n\n",
        		 no,name,job,mgr,hireDate.toString(),sal,comm,deptno);	                  
	         
	      }	
		//자원반납
		if(rs!=null) rs.close();
		if(st!=null) st.close();
		if(con!=null) con.close();
		
		
		
		
	}

}
