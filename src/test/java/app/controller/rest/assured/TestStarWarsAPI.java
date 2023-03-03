package app.controller.rest.assured;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Optional;

public class TestStarWarsAPI {
  public static void main(String[] args) {

    RestAssured.baseURI = "https://swapi.dev/api";
    RequestSpecification StarWarsRequest = RestAssured.given();

    Response swResp = StarWarsRequest.get("people");

    JsonPath StarWarsResponse = swResp.jsonPath();
    //"results.[?(@.height>200)]."
    System.out.println(Optional.ofNullable(StarWarsResponse.getList("findAll{'results'.'height'>200}.")));


  }
}
