package com.amazon.mobile.reporting;


import com.amazon.mobile.utils.StateHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.ITestResult;

import static io.restassured.RestAssured.given;


public class ReportingManager {


    public void generateAccessToken() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("client_id", "7AE09E3569AE405D8D32ADC5961DCB46");
        requestBody.put("client_secret", "d05d2009e7df3054893beaf97b766e33020d263dbd922465b571f13e4f684075");
        Response response = given().body(requestBody.toJSONString()).when().contentType(ContentType.JSON).post("https://xray.cloud.getxray.app/api/v2/authenticate");
        StateHelper.setStepState("reportingAccessToken", "Bearer " + response.getBody().asString().replaceAll("\"", ""));
    }

    public void updateTestStatus(String testId, ITestResult iTestResult) {
        JSONArray tests = new JSONArray();
        JSONObject testDetails = new JSONObject();
        testDetails.put("testKey", "TEST-" + testId);
        if (iTestResult.isSuccess()) {
            testDetails.put("status", "PASSED");
        } else {
            testDetails.put("status", "FAILED");
        }
        tests.add(testDetails);
        JSONObject requestBody = new JSONObject();
        requestBody.put("testExecutionKey", "TEST-" + System.getProperty("testExecId"));
        requestBody.put("tests", tests);
        given().header("Authorization", StateHelper.getStepState("reportingAccessToken").toString())
                .when().contentType(ContentType.JSON)
                .body(requestBody.toJSONString())
                .post("https://xray.cloud.getxray.app/api/v2/import/execution");
    }

}
