package com.amazon.web.reporting;

import com.amazon.web.utils.StateHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.ITestResult;

import static io.restassured.RestAssured.given;

public class ReportingManager {
    // This method generates an access token for authenticating with an external service (Xray in this case).
    public void generateAccessToken() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("client_id", "7AE09E3569AE405D8D32ADC5961DCB46");
        requestBody.put("client_secret", "372ffe663dc63cbd0f42814c2739d8ec794c0013750c5b688e7000fa48b06643");

        // Send a POST request to obtain an access token.
        Response response = given().body(requestBody.toJSONString()).when().contentType(ContentType.JSON).post("https://xray.cloud.getxray.app/api/v2/authenticate");

        // Extract the access token from the response and store it for later use.
        StateHelper.setStepState("reportingAccessToken", "Bearer " + response.getBody().asString().replaceAll("\"", ""));
    }

    // This method updates the test status in an external system (Xray) based on the test result.
    public void updateTestStatus(String testId, ITestResult iTestResult) {
        JSONArray tests = new JSONArray();
        JSONObject testDetails = new JSONObject();
        testDetails.put("testKey", "TEST-" + testId);

        // Set the test status as "PASSED" if the test is successful, or "FAILED" if it's not.
        if (iTestResult.isSuccess()) {
            testDetails.put("status", "PASSED");
        } else {
            testDetails.put("status", "FAILED");
        }

        tests.add(testDetails);

        JSONObject requestBody = new JSONObject();
        requestBody.put("testExecutionKey", "TEST-" + System.getProperty("testExecId"));
        requestBody.put("tests", tests);

        // Create an HTTP client and send a POST request to update the test status.
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost request = new HttpPost("https://xray.cloud.getxray.app/api/v2/import/execution");
            StringEntity params = new StringEntity(requestBody.toJSONString());
            request.addHeader("content-type", "application/json");

            // Add the access token to the request headers for authentication.
            request.addHeader("Authorization", StateHelper.getStepState("reportingAccessToken").toString());
            request.setEntity(params);

            // Execute the HTTP request to update the test status in the external system.
            httpClient.execute(request);
        } catch (Exception ex) {
            // Handle any exceptions that may occur during the process.
        }
    }
}
