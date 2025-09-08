package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class YouTubeSteps {

    private final String apiKey = "AIzaSyCF8nWbDfbjvVpJnaFNtmi109nMuLR9jgo";
    private String videoId;
    private Response response;

    @Given("I have the YouTube video id {string}")
    public void i_have_the_youtube_video_id(String id) {
        this.videoId = id;
    }

    @When("I request the video status")
    public void i_request_the_video_status() {
        response = RestAssured
                .given()
                .queryParam("part", "status")
                .queryParam("id", videoId)
                .queryParam("key", apiKey)
                .when()
                .get("/videos");
    }

    @Then("the video should be public and processed")
    public void the_video_should_be_public_and_processed() {
        response.then().statusCode(200);
        String uploadStatus = response.path("items[0].status.uploadStatus");
        String privacyStatus = response.path("items[0].status.privacyStatus");

        assertThat(uploadStatus, equalTo("processed"));
        assertThat(privacyStatus, equalTo("public"));
    }

    @When("I request the video statistics")
    public void i_request_the_video_statistics() {
        response = RestAssured
                .given()
                .queryParam("part", "statistics")
                .queryParam("id", videoId)
                .queryParam("key", apiKey)
                .when()
                .get("/videos");
    }

    @Then("the video should have more than 0 views")
    public void the_video_should_have_more_than_0_views() {
        response.then().statusCode(200);
        int views = Integer.parseInt(response.path("items[0].statistics.viewCount"));
        assertThat("Video should have views", views, greaterThan(0));
    }

    @When("I request the video details")
    public void i_request_the_video_details() {
        response = RestAssured
                .given()
                .queryParam("part", "contentDetails")
                .queryParam("id", videoId)
                .queryParam("key", apiKey)
                .when()
                .get("/videos");
    }

    @Then("the video should have a valid duration")
    public void the_video_should_have_a_valid_duration() {
        response.then().statusCode(200);
        String duration = response.path("items[0].contentDetails.duration");
        assertThat("Duration should not be null", duration, notNullValue());
        assertThat("Duration should contain PT (ISO 8601 format)", duration, containsString("PT"));
    }



}
