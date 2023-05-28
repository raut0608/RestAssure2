package testClassPackage;

import java.io.IOException;

import org.testng.Assert;

import commonFunctionPackage.API_Common_Function;
import commonFunctionPackage.utility_Common_Function;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.post_req_repository;

public class post_TC_1 {


	public static void execute() throws IOException {
		
		for( int i=0;i<5;i++)
		{
			int res_status_Code=API_Common_Function.res_statusCode(post_req_repository.base_URI(), post_req_repository.post_resource(),
					post_req_repository.post_TC1());
			if(res_status_Code==200) 
			{
				String responseBody=API_Common_Function.response_Body(post_req_repository.base_URI(), post_req_repository.post_resource(),
						post_req_repository.post_TC1());
				System.out.println(responseBody);
				post_TC_1.validator(responseBody, res_status_Code);
				utility_Common_Function.evidencefilecreator("post_TC_1",post_req_repository.post_TC1(),responseBody);
				break; 
			}
			
			else
			{
				System.out.println("correct status code is not found hence retrying the API");
			}
		}
       }	
		
				
		public static void validator(String  responseBody,int res_status_Code) {
		JsonPath jspresponse=new JsonPath(responseBody);
		String res_name=jspresponse.getString("name");
		String res_job=jspresponse.getString("job");
		String res_id=jspresponse.getString("id");
		//String res_createdAt=jspresponse.getString("createdAt");
		

		/* fetch request body
		JsonPath jspreq=new JsonPath(post_req_repository.post_TC1());
		String req_name=jspreq.getString("name");
		String req_job =jspreq.getString("job");
		*/
		
		// step 6 validation
		Assert.assertEquals(res_name,"bill");
		Assert.assertEquals(res_job, "leader");
		Assert.assertNotNull(res_id);
		//String currentdate=LocalDate.now().toString();
		//Assert.assertEquals(res_createdAt.substring(0,10), currentdate);
	
			
	}

}
