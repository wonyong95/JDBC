package day04;
import java.sql.*;
import java.util.*;
import common.util.DBUtil;

public class EmpFind {

	public static void main(String[] args) throws Exception {
		//검색할 사원의 이름을 입력받아서 해당 사원정보를 출력하세요
				//사번, 사원명, 부서명, 담당업무, 입사일, 근무지 가져와 출력하기
		Scanner sc=new Scanner(System.in);
		System.out.println("검색할 사원의 키워드 이름 입력: ");
		String keyword=sc.nextLine();
		
		
		Connection con=DBUtil.getCon();
		String sql="select empno, ename, dname, job, hiredate, loc from dept d ";
		      sql+=" join emp e on d.deptno = e.deptno ";
		      sql+=" where ename like ?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, "%"+keyword+"%");
		ResultSet rs=ps.executeQuery();
		int cnt=0;
		while(rs.next()) {
			cnt++;
			int no=rs.getInt("empno");
			String name=rs.getString("ename");
			String dname=rs.getString("dname");
			String job=rs.getString("job");
			java.sql.Date hdate=rs.getDate("hiredate");
			String loc=rs.getString("loc");
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n",no,name,dname,job,hdate.toString(),loc);
		}
		if(cnt==0) {
			System.out.println("검색할 사원 정보는 없습니다");
		}
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(con!=null) con.close();
		
		

	}

}
