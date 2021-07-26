import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import Files.payload;
import io.restassured.RestAssured;

public class Rahul_Basics {

	@Test
	void AddGoogleMap() { // OBJECTIVE - Adding place to Google Maps using POST Http method.
		// Validate if Add place (Google Maps) API is working as expected (Refer Add
		// Place in postman manual test)
		// There 3 key methods used in REST-assured
		// 1. Given - This contains all input details like body/payload
		// 2. When - What kind of submit used like PUT, GET, POST etc.. and Resource
		// 3. Then - validate the response
		RestAssured.baseURI = "https://rahulshettyacademy.com/";

		// Provide all input details(Query params, header, body etc using Given command
		// Provide HTTP method and Resource using 'When' method
		// Validate response using 'Then' method
		// log().all() - retrieves all the logs for request and response
		given().log().all().queryParam("key", "qaclickacademy").header("Content-Type", "application/json")
				.body(payload.AddPlace()).when().post("maps/api/place/add/json").then().log().all().statusCode(200)
				.header("server", "Apache/2.4.18 (Ubuntu)"); // validating statu code, server details

	}

}
