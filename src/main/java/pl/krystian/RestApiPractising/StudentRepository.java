package pl.krystian.RestApiPractising;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
	
	Student student;
	List<Student> studentsList = new ArrayList<Student>();
	
	public List<Student> getStudents() {
		studentsList = new ArrayList<Student>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Students","root","");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from firstclass");  
			
			while(rs.next()) {
				student = new Student();
				
				student.setId(rs.getInt("ID"));
				student.setFirstName(rs.getString("FirstName"));
				student.setLastName(rs.getString("LastName"));
				student.setAge(rs.getInt("Age"));
				
				studentsList.add(student);
			}
			rs.close();
			con.close();  
			
		}
		catch(Exception e){ System.out.println(e);}
		return studentsList;
	}
	
	public Student getStudents(int id) {
		studentsList = new ArrayList<Student>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Students","root","");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from firstclass where ID = " + id);  
			
			while(rs.next()) {
				student = new Student();
				student.setId(rs.getInt("ID"));
				student.setFirstName(rs.getString("FirstName"));
				student.setLastName(rs.getString("LastName"));
				student.setAge(rs.getInt("Age"));			
				}
			rs.close();
			con.close();  
			
		}
		catch(Exception e){ System.out.println(e);}
		return student;
	}

}
