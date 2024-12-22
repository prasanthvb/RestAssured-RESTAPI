package tests;

// static import of RestAssured
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC02_LearnWithBDD {

	// Setup method to configure base URI for the API tests
	@BeforeMethod
	public void setup() {
		// calling directly as i'm using static import of RestAssured
		baseURI = "https://reqres.in/";
	}

	// Test to fetch all users from the API
	@Test
	public void getAllUsers() {
		given()
		.when()
		.get("api/users?page=2")
		.prettyPrint();
	}

	// Test to create a new user via POST request
	@Test
	public void createUser() {
		given()
			.header("content-Type", "application/json")
			.body("{\r\n" + "    \"name\": \"Prasanth\",\r\n" + "    \"job\": \"Lead\"\r\n" + "}")
			.when()
			.post("api/users")
			.prettyPrint();
	}
	
	// Test to update an existing user's information via PUT request
	@Test 
	public void updateUser() {
		given()
			.header("content-Type", "application/json")
			.body("{\r\n" + "    \"name\": \"Prasanth\",\r\n" + "    \"job\": \"QA Lead\"\r\n" + "}")
			.when()
			.put("api/users/12")
			.prettyPrint();
			
		}
		
	// Test to delete a user from the API
	@Test
	public void DeleteUser() {
		given()
			.when()
			.delete("api/users/2")
			.prettyPrint();
		}
		
	// Test to fetch a single user's details from the API
	@Test
	public void getSingleUser() {
		given()
			.when()
			.get("api/users/12")
			.prettyPrint();		
		}

}
