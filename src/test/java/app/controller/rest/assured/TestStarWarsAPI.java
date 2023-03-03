package app.controller.rest.assured;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestStarWarsAPI {

  static {RestAssured.baseURI = "https://swapi.dev/api";}
  private static final RequestSpecification StarWarsRequest = RestAssured.given();
  private static final Response swResp = StarWarsRequest.get("people");
  private static final JsonPath StarWarsResponse = swResp.jsonPath();
  public static void main(String[] args) {}

  @BeforeAll
  public static void CanConnect2API(){
    assertDoesNotThrow( ()->{swResp.then().statusCode(200);});
  }
  @Test
  public void IsResultsPresent(){
    Assertions.assertTrue(StarWarsResponse.getList("results").size()>0);
    System.out.println(StarWarsResponse.getList("results")+"\nsize: "+ StarWarsResponse.getList("results").size());
  }

  @Test
  public void IsNamesPresent(){

    List<String> AllNames= StarWarsResponse.getList("results.name");
    for ( Object name: AllNames) {    System.out.println(name);}
    //System.out.println(StarWarsResponse.getList("results[height>200]"));
    Assertions.assertTrue(AllNames.size()!=0); }

@Test
public void AreThereCharactersTallerthan200(){
  System.out.println("\n\nHow about List of persons who height greater than 200.");

  List<String> ThoseTallerthan200 = StarWarsResponse.getList("results.findAll { it.height > '200' }.name");
  for ( String name: ThoseTallerthan200) {    System.out.println(name);}

  System.out.println("\n\n--------SPECS------");
  List<Object> Names = StarWarsResponse.getList("results.findAll { it.height > '200' }.");
  for ( Object name: Names) {    System.out.println(name);}

  Assertions.assertTrue(Names.size()>0);
  }
}
