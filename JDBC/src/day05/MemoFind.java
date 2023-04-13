package day05;
import java.sql.*;


import java.sql.*;
import javax.swing.JOptionPane;
import common.util.DBUtil;
//검색어를 입력하면 해당 검색어를 갖는 메모글을 가져오는 프로시저를 작성하고
//자바와 연동시키세요.
public class MemoFind {
public static void main(String[] args)
throws Exception
{
String keyword=JOptionPane.showInputDialog("메모글 내용의 검색어를 입력하세요");
if(keyword==null) return;
Connection con =DBUtil.getCon();
String sql="{call memo_find(?,?)}";
CallableStatement cs=con.prepareCall(sql);
cs.setString(1, keyword );
cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
cs.execute();
ResultSet rs=(ResultSet)cs.getObject(2);
System.out.println("--"+keyword+"로 검색한 메모내용 확인");
while(rs.next()) {
int no=rs.getInt(1);
String name=rs.getString(2);
String msg=rs.getString(3);
java.sql.Date hdate=rs.getDate(4);
System.out.println(no+"\t"+name+"\t"+msg+"\t"+hdate);
}//while---------
rs.close();
cs.close();
con.close();
}
}