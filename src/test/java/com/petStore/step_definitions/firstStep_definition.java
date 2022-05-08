package com.petStore.step_definitions;

import com.petStore.utilities.PetStoreUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

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
}
