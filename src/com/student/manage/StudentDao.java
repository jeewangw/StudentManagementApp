package com.student.manage;
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.Statement;


public class StudentDao {
	
	public static boolean insertStudentToDB(Student st) {
		
		boolean f=false;
		try {
			
			//jdbc code...
			Connection con = CP.createC();
			String q="insert into STUDNETS(SName,SPhone,SCity) values(?,?,?)";
			
			//Prepared Statement
			PreparedStatement pstmt= con.prepareStatement(q);
			
			//Set the values of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			f= true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	
	public static boolean deleteStudent (int userID) {
		
		
		boolean f=false;
		try {
			
			//jdbc code...
			Connection con = CP.createC();
			String q="delete from STUDNETS where SID=?";
			
			//Prepared Statement
			PreparedStatement pstmt= con.prepareStatement(q);
			
			//Set the values of parameter
			pstmt.setInt(1, userID);
			
			//execute
			pstmt.executeUpdate();
			f= true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
		
	}


	public static void showAllStudent() {
		// TODO Auto-generated method stub
		
		try {
			
			//jdbc code...
			Connection con = CP.createC();
			String q="select * from STUDNETS";
			
			//Prepared Statement
			Statement stmt= con.createStatement();
			
			//Set the values of parameter
			ResultSet set = stmt.executeQuery(q);
			
			while (set.next()) {
				
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone = set.getString(3);
				String city= set.getString("SCity");
				
				System.out.println("ID: "+ id);
				System.out.println("Name: "+ name);
				System.out.println("Phone: "+ phone);
				System.out.println("City: "+ city);
				System.out.println("------------------");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		
	}
	


	public static boolean updateStudent(Student st) {

		boolean f=false;
		try {
			
			//jdbc code...
			Connection con = CP.createC();
			String q="UPDATE STUDNETS SET SName=?, SPhone=?, SCity=? where SID=?";
			
			//Prepared Statement
			PreparedStatement pstmt= con.prepareStatement(q);
			
			//Set the values of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			pstmt.setInt(4, st.getStudentId());
			
			//execute
			pstmt.executeUpdate();
			f= true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
		
	}

}
