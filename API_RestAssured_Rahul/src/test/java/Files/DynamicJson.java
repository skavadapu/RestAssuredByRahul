package Files;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class DynamicJson {
	
	@Test
	public void addBook() {
		
		RestAssured.baseURI = "http://216.10.245.166";
	String response = given().log().all().header("Content-Type", "application/json")
		.body(payload.AddBookBody("ab8cd", "b12345"))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath JP = ReUsableMethods.rawToJson(response);
	String id = JP.getString("ID");
	System.out.println(id);
	
	}

}
