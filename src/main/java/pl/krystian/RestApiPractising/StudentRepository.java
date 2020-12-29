package pl.krystian.RestApiPractising;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
	
	private Student student;
	private List<Student> studentsList = new ArrayList<Student>();
	
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

	public void addStudent(Student student) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Students","root","");  
			String sql = "insert into firstclass values (?, ?, ?, ?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, student.getId());
			stmt.setString(2, student.getFirstName());
			stmt.setString(3, student.getLastName());
			stmt.setInt(4, student.getAge());
			stmt.executeUpdate();
			stmt.close();
			con.close();
		}
		catch(Exception e){ System.out.println(e);}
	}

	public void updateStudent(Student student) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Students","root","");  
			String sql = "update firstclass set FirstName=?, LastName=? ,Age=? where ID = ?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setInt(3, student.getAge());
			stmt.setInt(4, student.getId());
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		}
		catch(Exception e){ System.out.println(e);}
	}
	
	public void deleteStudent(Student student) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Students","root","");  
			String sql = "delete from firstclass where ID = ?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, student.getId());
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		}
		catch(Exception e){ System.out.println(e);}
	}
}
