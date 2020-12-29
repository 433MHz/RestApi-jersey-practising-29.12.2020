package pl.krystian.RestApiPractising;

import java.util.List;

import com.google.gson.Gson;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("student")
public class MyResource {
	
	Gson gson = new Gson();
	StudentRepository studentRepository = new StudentRepository();
	
    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
    	
    	List<Student> list = studentRepository.getStudents();
    	String answer = gson.toJson(list);
    	return answer;
    }
}
