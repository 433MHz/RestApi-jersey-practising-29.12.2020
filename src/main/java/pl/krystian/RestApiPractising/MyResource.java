package pl.krystian.RestApiPractising;

import java.util.List;

import com.google.gson.Gson;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("student")
public class MyResource {
	
	Gson gson = new Gson();
	StudentRepository studentRepository = new StudentRepository();
	
    @GET
    @Path("getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getIt() {
    	
    	List<Student> list = studentRepository.getStudents();
    	return list;
    }
    
    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getIt(@PathParam("id")int id) {
    	Student student = studentRepository.getStudents(id);
    	return student;
    }

    @POST
    @Path("set")
    @Produces(MediaType.TEXT_PLAIN)
    public String setIt(String objectJSON) {
    	Student student = gson.fromJson(objectJSON, Student.class);
    	studentRepository.addStudent(student);
    	return "Done";
    }
}
