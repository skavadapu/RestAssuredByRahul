import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*; //Static packages are not recognised by eclipse so manually
//need to import them.

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.ReUsableMethods;
import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Rahul_Add_Update_GetPlace {

	@Test
	void E2ETest() {
		// OBJECTIVE - 1. Adding place to Google Maps using POST Http method.
		// 2. Updating place using PUT Http method (retrieve the place id from step1)
		// 3. Get the updated place using GET Http method and verify updation.

		// 1. ADD PLACE
		System.out.println("*************ADD PLACE USING POST METHOD****************");
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String Response = given().log().all().queryParam("key", "qaclickacademy")
				.header("Content-Type", "application/json").body(payload.AddPlace()).when()
				.post("maps/api/place/add/json").then().extract().response().asString(); // Extracting the response in
																							// String format

		// Printing the response as string in console
		System.out.println("Response string is : " + Response);

		// Creating the JSON object and parsing the String into Json format and grab
		// place_id

		JsonPath JP = ReUsableMethods.rawToJson(Response);

		// Grab place_id from the Json response
		String placeId = JP.getString("place_id");
		System.out.println("PlaceId is : " + placeId);

		// 2. UPDATE PLACE
		System.out.println("*************UPDATE PLACE USING PUT METHOD****************");

		String newAddress = "100 Black Diamond walk, DALLAS, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\n" + "\"place_id\":\"" + placeId + "\",\n" + "\"address\":\"" + newAddress + "\",\n"
						+ "\"key\":\"qaclick123\"\n" + "}")
				.when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		// 3. GET PLACE
		System.out.println("*************RETRIEVING PLACE USING GET METHOD****************");

		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				.when().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract()
				.response().asString();

		JsonPath JSGet = ReUsableMethods.rawToJson(getPlaceResponse);
		String actualAddress = JSGet.getString("address");
		System.out.println(actualAddress);

		Assert.assertEquals(actualAddress, newAddress);

	}

}
