package core.General;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.Date;

import static core.General.RestFuntions.extractFromResponse;
import static core.General.envGlobals.*;

public class MainCall {
    public MainCall(){}

    private static ExtentReports extent;
    private static Date time = GenericFunctions.getTime();

    static ExtentReports startReport() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/reports/ExtentReport.html", true);
        extent.addSystemInfo("Environment", configProps.Environment);

        return extent;
    }

    static void stepExecution(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            MainCall.clearData();

//            envGlobals.logger.log(LogStatus.FAIL);
            logger.log(LogStatus.FAIL, "Test Case Failed reason is: " + result.getThrowable());
            logger.log(LogStatus.FAIL, "Request Payload: " + request.toString());
            logger.log(LogStatus.FAIL, "Response Body: " + response.getBody().asString());
            logger.log(LogStatus.INFO, "StackTrace Result: " + Arrays.toString(result.getThrowable().getStackTrace()));
    } else if (result.getStatus() == ITestResult.SKIP) {
            MainCall.clearData();

            logger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
    } else {
        envGlobals.logger.log(LogStatus.PASS, "Test successfully passed !");
//        envGlobals.logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Passed");
//        envGlobals.logger.log(LogStatus.PASS, "Request Details: " + envGlobals.request.toString());
//        logger.log(LogStatus.PASS, "Request Payload: " + request.toString());
//        logger.log(LogStatus.PASS, "Response Body: " + response.getBody().asString());
    }

        logger.setEndedTime(time);
        MainCall.getExtentReport().endTest(logger);
    }

    public static ExtentReports getExtentReport() {
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }

    static void setupRestAssured(){
        //Rest Assured config
        switch (configProps.Environment){
            case "PERF":
                RestAssured.baseURI = configProps.PERF_baseUri;
                break;
            case "QA":
                RestAssured.baseURI = configProps.QA_baseUri;
                break;
            case "DEV":
                RestAssured.baseURI = configProps.DEV_baseUri;
                break;
            case "UAT":
                RestAssured.baseURI = configProps.UAT_baseUri;
                break;
        }
//        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public static void clearData(){
        // HEADERS MAP
        headersMap.clear();
        // PATH PARAMS MAP
        pathParamsMap.clear();
        pathParamsMap.put("O_CODE", oCode);
        // QUERY PARAMS MAP
        queryParamsMap.clear();
        // FORM PARAMS MAP
        formParamsMap.clear();
        // FUNCTION NAME
        function = "";
        // ASSERTION PATH
        assertionPath.clear();
        // ASSERTION VALUE
        assertionValue.clear();
    }

    static void clearSheet(){
        // SHEET NAME
        sheetName = "";
        // SHEET METHODS
        sheetMethod.clear();
        // SHEET ENDPOINTS
        sheetEndpoint.clear();
        // SHEET HEADERS
        sheetHeaders.clear();
        // SHEET PATH PARAMS
        sheetPathParams.clear();
        pathParamsMap.clear();
        // SHEET QUERY PARAMS
        sheetQueryParams.clear();
        // SHEET FORM PARAMS
        sheetFormParams.clear();
        // SHEET REQUEST PAYLOAD
        sheetRequestPayload.clear();
        // SHEET STATUS CODE
        sheetStatusCode.clear();
        // SHEET RESPONSE FLAG
        sheetResponseFlag.clear();
        // SHEET RESPONSE ASSERTIONS
        sheetResponseAssertions.clear();
        // SHEET RESPONSE
        sheetResponse.clear();

        // RESPONSE STRING
        res = "";
        // O_CODE STRING
        oCode = "";
    }

}
