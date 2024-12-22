package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_MethodsUsageTest {
	
	// RequestSpecification instance to store request configurations
	public static RequestSpecification request;

	// Setup method to configure base URI for the API tests
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://reqres.in/";
	}

	// Test to fetch all users from the API
	@Test
	public void getAllUsers() {
		request = RestAssured.given();
		Response response = request.request(Method.GET, "api/users?page=2");

		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}

	// Test to create a new user via POST request
	@Test
	public void createUser() {
		request = RestAssured.given().header("content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"Prasanth\",\r\n" + "    \"job\": \"Lead\"\r\n" + "}");
		Response response = request.request(Method.POST, "api/users");

		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}

	// Test to update an existing user's information via PUT request
	@Test
	public void updateUser() {
		request = RestAssured.given().header("content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"Prasanth\",\r\n" + "    \"job\": \"Lead\"\r\n" + "}");
		Response response = request.request(Method.PUT, "api/users/12");
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}

	// Test to delete a user from the API
	@Test
	public void DeleteUser() {
		request = RestAssured.given();
		Response response = request.request(Method.DELETE, "api/users/2");
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}

	// Test to fetch a single user's details from the API
	@Test
	public void getSingleUser() {
		request = RestAssured.given();
		Response response = request.request(Method.GET, "api/users/12");
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}
}
