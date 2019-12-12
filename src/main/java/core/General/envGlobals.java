package core.General;

import com.relevantcodes.extentreports.ExtentTest;
import core.configuration.configProperties;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class envGlobals{

    // Rest Assured Global variables
    public static Response response; // API response object
    public static RequestSpecification request; // given store object
    public static ExtentTest logger;
    public static configProperties configProps = new configProperties();
    public static Date time = GenericFunctions.getTime();
    public static boolean readOnce = true;
    public static List<JSONArray> jsonArrayList = new ArrayList<>();

    public static List<String> fileList = new ArrayList<>();
    public static String sheetName = "";
    public static List<String> sheetMethod = new ArrayList<>();
    public static List<String> sheetEndpoint = new ArrayList<>();
    public static List<String> sheetHeaders = new ArrayList<>();
    public static List<String> sheetPathParams = new ArrayList<>();
    public static List<String> sheetQueryParams = new ArrayList<>();
    public static List<String> sheetFormParams = new ArrayList<>();
    public static List<String> sheetRequestPayload = new ArrayList<>();
    public static List<String> sheetStatusCode = new ArrayList<>();
    public static List<String> sheetResponseFlag = new ArrayList<>();
    public static List<String> sheetResponseAssertions = new ArrayList<>();
    public static List<String> sheetResponse = new ArrayList<>();

    public static Map<String, String> headersMap = new HashMap<String, String>();
    public static Map<String, String>  pathParamsMap = new HashMap<String, String>();
    public static Map<String, String>  queryParamsMap = new HashMap<String, String>();
    public static Map<String, String>  formParamsMap = new HashMap<String, String>();
    public static String function = "";
    public static List<String>  assertionPath = new ArrayList<>();
    public static List<String>  assertionValue = new ArrayList<>();

    public static int filesCount = 0;
    public static int row = 0;
    public static int rowsCount = 0;

    public static Workbook workbook;
    public static List<Sheet> sheet = new ArrayList<>();

    public static String terminator = ";";
    public static String separator = ",";
    public static String key = "";
    public static String value = "";

    public static int index = 0;
    public static String res = "";
    public static String oCode = "";


}
