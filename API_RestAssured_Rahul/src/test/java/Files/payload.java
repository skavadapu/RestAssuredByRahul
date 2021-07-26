package Files;

public class payload {

	// Function created for body of the data . This created as static so that this
	// can be
	// called straightaway in other places without creating instance of the object.
	public static String AddPlace() {

		return " {\n" + "  \"location\": {\n" + "    \"lat\": -38.383494,\n" + "    \"lng\": 33.427362\n" + "  },\n"
				+ "  \"accuracy\": 50,\n" + "  \"name\": \"Rahul Shetty Academy\",\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\n" + "  \"address\": \"29, side layout, cohen 09\",\n"
				+ "  \"types\": [\n" + "    \"shoe park\",\n" + "    \"shop\"\n" + "  ],\n"
				+ "  \"website\": \"http://rahulshettyacademy.com\",\n" + "  \"language\": \"French-IN\"\n" + "}\n"
				+ " ";

	}

	// The below body is for MOCK API as origina API is not yet ready.

	public static String MockApiCoursePrice() {
		return "{\n" + "\n" + "\"dashboard\": {\n" + "\n" + "\"purchaseAmount\": 910,\n" + "\n"
				+ "\"website\": \"rahulshettyacademy.com\"\n" + "\n" + "},\n" + "\n" + "\"courses\": [\n" + "\n" + "{\n"
				+ "\n" + "\"title\": \"Selenium Python\",\n" + "\n" + "\"price\": 50,\n" + "\n" + "\"copies\": 6\n"
				+ "\n" + "},\n" + "\n" + "{\n" + "\n" + "\"title\": \"Cypress\",\n" + "\n" + "\"price\": 40,\n" + "\n"
				+ "\"copies\": 4\n" + "\n" + "},\n" + "\n" + "{\n" + "\n" + "\"title\": \"RPA\",\n" + "\n"
				+ "\"price\": 45,\n" + "\n" + "\"copies\": 10\n" + "\n" + "}\n" + "\n" + "]\n" + "\n" + "}";
	}

	public static String AddBookBody(String isbn,String aisle) {
		//Passing isbn and aisle parameters
		String payload = "{\n" + "\n" + "\"name\":\"Learn Appium Automation with Java\",\n" + "\"isbn\":\""+isbn+"\",\n"
				+ "\"aisle\":\""+aisle+"\",\n" + "\"author\":\"John foe\"\n" + "}";
		return payload;
	}

}
