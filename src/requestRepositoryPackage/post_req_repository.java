package requestRepositoryPackage;
import java.io.IOException;
import java.util.ArrayList;

import commonFunctionPackage.utility_Common_Function;
public class post_req_repository {

	public static String base_URI() 
	{
		
		String baseURI="https://reqres.in/";
		return baseURI;
		
	}
	
	public static String post_resource() 
	{
		String resource="api/users";
		return resource;
	}
	
	public static String post_TC1() throws IOException 
	{
		ArrayList<String> data=utility_Common_Function.readdataexcel("Post_Test_Data", "post_TC_1");
		String req_name=data.get(1);
		String req_job=data.get(2);
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;
	}
	
}
