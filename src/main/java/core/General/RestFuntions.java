package core.General;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.hamcrest.core.IsEqual.equalTo;

import static core.General.envGlobals.*;
import static org.testng.Assert.assertEquals;

public class RestFuntions {
    public RestFuntions(){
    }

    private static boolean bool;

//******************************************            Fixed Functions            ******************************************

    public static void perfSpec(){
        RestAssured.baseURI = configProps.PERF_baseUri;
    }
    public static void devSpec(){
        RestAssured.baseURI = configProps.DEV_baseUri;
    }
    public static void qaSpec(){
        RestAssured.baseURI = configProps.QA_baseUri;
    }
    public static void uatSpec(){
        RestAssured.baseURI = configProps.UAT_baseUri;
    }

    public static void givenFunction() {
        ExcelReader.convertAll(row);

        request =
                given()
                    .log().all()
                    .auth().preemptive().basic(configProps.UserName, configProps.Password)
                    .contentType("application/json")
                    .headers(headersMap)
                    .pathParams(pathParamsMap)
                    .queryParams(queryParamsMap)
                    .formParams(formParamsMap);

        if (sheetRequestPayload.get(row).length() != 0 || !sheetRequestPayload.get(row).equals("")
                || !sheetRequestPayload.get(row).isEmpty()) {
            request.body(sheetRequestPayload.get(row));
        }
    }

    public static void andMethodEndPointFunction() {
        switch (sheetMethod.get(row)){
            case "get":
                response = request
                        .when()
                            .get(sheetEndpoint.get(row));
                break;
            case "post":
                response = request
                        .when()
                            .post(sheetEndpoint.get(row));
                break;
            case "put":
                response = request
                        .when()
                            .put(sheetEndpoint.get(row));
                break;
            case "patch":
                response = request
                        .when()
                            .patch(sheetEndpoint.get(row));
                break;
            case "delete":
            response = request
                        .when()
                            .delete(sheetEndpoint.get(row));
            break;
        }
    }

    public static void thenFunction(){
        response
            .then()
                .log().all()
                .assertThat().statusCode(Integer.parseInt(sheetStatusCode.get(row)));
    }

    private static void assertions(){
        JSONArray jsonArr = new JSONArray(sheetResponse.get(row));

        for (int i=0 ; i<jsonArr.length(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);

            response
                .then()
                    .body(jsonObj.getString("path"), equalTo(jsonObj.get("value")));
        }
    }

    private static void andAssertionFunction() {
        for (int i=0 ; i<assertionPath.size() ; i++) {
//            For INTEGER data type
            if (isNumeric(assertionValue.get(i))) {
                response
                    .then()
                        .body(assertionPath.get(i), equalTo(Integer.parseInt(assertionValue.get(i))));
            }
//            For BOOLEAN data type set as TRUE
            else if (assertionValue.get(i).equalsIgnoreCase("true")){
                bool = true;
                response
                    .then()
                        .body(assertionPath.get(i), equalTo(bool));
            }
//            For BOOLEAN data type set as FALSE
            else if(assertionValue.get(i).equalsIgnoreCase("false")) {
                bool = false;
                response
                    .then()
                        .body(assertionPath.get(i), equalTo(bool));
            }
//            For NULL
            else if(assertionValue.get(i) == null || assertionValue.get(i).equals("") || assertionValue.get(i).isEmpty()) {
                response
                    .then()
                        .body(assertionPath.get(i), equalTo(null));
            }
//            Final will remain for STRING data type
            else{
                response
                    .then()
                        .body(assertionPath.get(i), equalTo(assertionValue.get(i)));
            }
        }
    }

    private static void responseToString(){
        res = response.asString();
    }

    public static String extractFromResponse(String param){
        return response.getBody().path(param).toString();
    }

    public static void assertResponse(){
        if (sheetResponseFlag.get(row).equalsIgnoreCase("true")) {
            if (!res.isEmpty() || !res.equals("")) {
                ObjectMapper mapper = new ObjectMapper();

                try {
                    assertEquals(mapper.readTree(response.asString()), mapper.readTree(res));
                } catch (IOException e) {
                    e.getMessage();
//                e.printStackTrace();
                }
            }
        }
        else if(sheetResponseFlag.get(row).equalsIgnoreCase("false")){
//            if (!sheetResponseAssertions.get(row).isEmpty())
//                andAssertionFunction();
            if (!sheetResponse.get(row).isEmpty())
                assertions();
        }

        responseToString();
    }
//***************************************************************************************************************************

}
