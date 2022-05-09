package com.petStore.step_definitions;

import com.petStore.pojo.Category;
import com.petStore.pojo.Pet;
import com.petStore.utilities.PetStoreUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Arrays;

import static io.restassured.RestAssured.*;


public class firstStep_definition {

Response response;
PetStoreUtils url =new PetStoreUtils();


    @Given("User send get request to the right url and {string} end point")
    public void user_send_get_request_to_the_right_url_and_end_point(String endpoint) {
           response = given()
                    .accept(ContentType.JSON)
                    .and()
                    .queryParam("status", "available")
                    .when()
                    .get(url.url()+endpoint);

    }

    @Then("status code should be {int}")
    public void status_code_should_be(int statusCode) {
       Assert.assertEquals(statusCode,response.statusCode());

    }

    @Given("user send get request to the right url {string} end point with path param with id {int}")
    public void user_send_get_request_to_the_right_url_end_point_with_path_param_with_id(String endpoint, int ID) {
        response =
                given()
                        .accept(ContentType.JSON)
                        .pathParam("petID", ID)
                        .when()
                        .get(url.url() + endpoint);
    }

    @Given("user sends post request to the right url {string} endpoint")
    public void userSendsPostRequestToTheRightUrlEndpoint(String endpoint) {
        Category category = new Category();
        category.setId(120);
        category.setName("Persian");

        Pet newPet = new Pet();
        newPet.setName("Cat");
        newPet.setId(120);
        newPet.setCategory(category);
        newPet.setPhotoUrls(Arrays.asList("url"));
        newPet.setStatus("Good");

        response =
                given()
                        .accept(ContentType.JSON)
                        .and().contentType(ContentType.JSON)
                        .body(newPet)
                        .when()
                        .post(url.url() + endpoint);




    }

    @Given("user send a delete request to the right url {string} endpoint with path param with id {int}")
    public void userSendADeleteRequestToTheRightUrlEndpointWithPathParamWithId(String endpoint, int ID) {
        response =
                given().log().all()
                        .accept(ContentType.JSON)
                        .header("api_key",12345)
                        .pathParam("petID",ID)
                        .when()
                        .delete(url.url() + endpoint);
        response.prettyPrint();

    }


}
