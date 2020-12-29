package pl.krystian.RestApiPractising;

public class Student {

	private int id;
	private String FirstName;
	private String LastName;
	private int age;
	
	
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public int getAge() {
		return age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
