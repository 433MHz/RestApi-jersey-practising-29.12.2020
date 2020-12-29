package pl.krystian.RestApiPractising;

import java.util.List;

import com.google.gson.Gson;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
    @Consumes(MediaType.APPLICATION_JSON)
    public String setIt(Student object) {
    	studentRepository.addStudent(object);
    	return "Done";
    }
    
    
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateIt(Student object) {
    	studentRepository.updateStudent(object);
    }
    
    
    @DELETE
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteIt(Student object) {
    	studentRepository.deleteStudent(object);
    }
}
