package framework.utilities.serverComponents.requestMethods;

import framework.utilities.serverComponents.models.responses.Data;
import framework.utilities.serverComponents.models.responses.ListUsersData;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class RestRequests extends Endpoints{
    private final String baseURI = "https://reqres.in";
    private final String basePath = "/api";
    String endpoint= null;

    public String getSingleUser() {
        endpoint= getEndpoint("getSingleUser");
        Response response = getRequest(endpoint);
        JsonPath json = response.jsonPath();
        String fullName = json.get("data.first_name") + " "+ json.get("data.last_name");
        return fullName;
    }

    public List<Data> getListUsersData(){
        endpoint= getEndpoint("getUsersList");
        Response response = getRequest(endpoint);
        ListUsersData listUsersData= response.as(ListUsersData.class);
        List<Data> usersData = listUsersData.getData();
        return usersData;
    }

    public String createUser(){
        endpoint = getEndpoint("createUser");
        String jsonBody = "{\n" +
                "    \"name\": \"Christian\",\n" +
                "    \"job\": \"QA Engineer\"\n" +
                "}";
        Response response = postRequest(endpoint, jsonBody);
        JsonPath res = response.jsonPath();
        String createdDate = res.get("createdAt");
        System.out.println(createdDate);
        return createdDate;
    }

    public String updateUser(){
        endpoint = getEndpoint("updateUser");
        String jsonBody = "{\n" +
                "    \"name\": \"Christian\",\n" +
                "    \"job\": \"Senior QA Engineer\"\n" +
                "}";
        Response response = putRequest(endpoint, jsonBody);
        JsonPath res = response.jsonPath();
        String updatedDate = res.get("updatedAt");
        System.out.println(updatedDate);
        return updatedDate;
    }

    public int deleteUser(){
        endpoint = getEndpoint("deleteUser");
        Response response = deleteRequest(endpoint);
        int statusCode = response.statusCode();
        return statusCode;
    }

    public Response getRequest(String endpoint) {
        Response response = given()
                .get(baseURI+basePath+endpoint);
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }

    public Response postRequest(String endpoint, String jsonBody){
        Response response = given()
                .header("Content-Type", "application/json")
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post(baseURI+basePath+endpoint);
        Assert.assertEquals(response.statusCode(), 201);
        return response;
    }

    public Response putRequest(String endpoint, String jsonBody){
        Response response = given()
                .header("Content-Type", "application/json")
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .put(baseURI+basePath+endpoint);
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }

    public Response deleteRequest(String endpoint){
        Response response = given()
                .delete(baseURI+basePath+endpoint);
        return response;
    }
}
