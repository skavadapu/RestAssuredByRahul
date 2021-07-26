import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getMapDetails() {
		
		//Specify baseURI
		RestAssured.baseURI = "http://rahulshettyacademy.com/maps/api/place/get/json";
		
		//Request object creation
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object creation
		
		Response res = httprequest.request(Method.GET,"?place_id=cfed2ebb51e563dd7660053380b98f32&key=qaclick123");
		
		//Convert the response from Json format to string format
		
		String responseBody = res.getBody().asString();
		
		//Print the response in console
		System.out.println("Response from server="+responseBody);
		
		//Validation starts - Status code
		
		int statusCode = res.statusCode();
		
		System.out.println("Status code is "+statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		//Validate status line
		
		String statusLine = res.statusLine();
		System.out.println("Status line is "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
	}

}
