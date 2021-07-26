import org.testng.Assert;
import org.testng.annotations.Test;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	@Test
	public void MockAPIParse() {
		// As this MockAPI so we are skipping the 'Given' part and will be introduced
		// once original API developed and ready to use.
		// For time being using the mock api and finding below queries from the mock api
		// schema/response

		JsonPath JP = new JsonPath(payload.MockApiCoursePrice()); // api response

//	1. Print No of courses returned by API
		int courseCount = JP.getInt("courses.size"); // Courses is array and size gives count of courses
		System.out.println("Course count = " + courseCount);

//	2.Print Purchase Amount
		int totalAmount = JP.getInt("dashboard.purchaseAmount");
		System.out.println("Total purchase amount = " + totalAmount);

//	3. Print Title of the first course
		String title = JP.getString("courses[0].title"); // use the index for grabbing the contents in the array
		System.out.println("First Course title = " + title);

//	4. Print All course titles and their respective Prices

		System.out.println("Courses Titles & Price : ");
		for (int i = 0; i < courseCount; i++) {
			String courseTitles = JP.getString("courses[" + i + "].title");
			int coursePrice = JP.getInt("courses[" + i + "].price");
			System.out.println(courseTitles + " : " + coursePrice);
		}

//		5. Print no of copies sold by RPA Course

		for (int i = 0; i < courseCount; i++) {
			if (JP.getString("courses[" + i + "].title").equalsIgnoreCase("RPA")) {
				int copies = JP.getInt("courses[" + i + "].copies");
				System.out.println("Number of copies sold by RPA course : " + copies);
			}

		}

//		6. Verify if Sum of all Course prices matches with Purchase Amount

		// all courses amount = course price * copies
		int sum = 0;
		for (int i = 0; i < courseCount; i++) {
			int Price = JP.getInt("courses[" + i + "].price");
			int Copies = JP.getInt("courses[" + i + "].copies");
			sum = sum + (Price * Copies);
		}
		System.out.println("Total price of all copies sold = " + sum);

		int purchaseAmount = JP.getInt("dashboard.purchaseAmount");

		Assert.assertEquals(sum, purchaseAmount);

	}

}
