package endPoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class people {
    static Response response;
    public static Response getPeople(String request){
        response =  given().header("Content-Type","application/json").get(request);
        return response;
    }
}
