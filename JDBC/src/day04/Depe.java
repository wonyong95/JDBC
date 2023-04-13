package day04;
import java.security.PublicKey;
import java.sql.*;
import common.util.*;
import javax.swing.*;

public class Depe {
	public static void main(String[] args) throws Exception {
		String noStr=JOptionPane.showInputDialog("수정할 글번호를 입력하세요");
		String name=JOptionPane.showInputDialog("작성자명을 입력하세요");
  	  String msg=JOptionPane.showInputDialog("메모 내용을 입력하세요");
  	  if(noStr==null|| name==null|| msg==null) return;
  	  
  	  Connection con=DBUtil.getCon();
  	  String sql="{call memo_edit(?,?,?)}";
  	  
		CallableStatement cs=con.prepareCall(sql);
		//in parameter값 setting
		
		cs.setInt(1, Integer.parseInt(noStr));
		cs.setString(2, name);
		cs.setString(3, msg);
		
		//실행
		cs.execute();
		System.out.println("메모 글 등록 성공!");
		
		cs.close();
		con.close();
	}
}