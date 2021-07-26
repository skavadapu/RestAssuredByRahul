package Files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

	public static JsonPath rawToJson(String response) {
		JsonPath JP = new JsonPath(response);
		return JP;
	}

}
