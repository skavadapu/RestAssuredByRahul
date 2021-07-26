import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_AddPlace {
	
	@Test
	void AddMapToGoogle() {
		//Specify baseURI
				RestAssured.baseURI = "https://rahulshettyacademy.com/maps/api/place";
				
				//Request object creation
				RequestSpecification httprequest=RestAssured.given();
				
				//Request payload along with post request
				
				JSONObject requestParams = new JSONObject ();
				
				requestParams.put("lat", -38.383494);
				requestParams.put("lng", 33.427362);
				requestParams.put("accuracy", 50);
				requestParams.put("name", "Frontline house");
				requestParams.put("phone_number", "(+91) 983 893 3937");
				requestParams.put("address", "29, side layout, cohen 09");
				requestParams.put("types", "shoe park");
				
				//mention data type
				httprequest.header("Content-Type", "application/json");
				
				//Attaching the data to post request
				httprequest.body(requestParams.toJSONString());
				
				//Send request to database
				
				Response res = httprequest.request(Method.POST,"/add/json?key= qaclick123");
				
				//Validation starts - Status code
				
				int statusCode = res.statusCode();
				
				System.out.println("Status code is "+statusCode);
				
				Assert.assertEquals(statusCode, 200);
				
				//Validating the successCode message
				
				String successcode = res.jsonPath().get("SuccessCode");
				Assert.assertEquals(successcode, "OPERATION SUCCESS");
				
				
				
				
	}

}
