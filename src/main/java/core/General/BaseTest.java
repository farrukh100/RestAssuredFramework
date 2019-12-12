package core.General;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

import static core.General.envGlobals.*;

public class BaseTest {
    private static String isEnableReporting = configProps.isEnableReporting;

    @BeforeSuite
    public void startReport() throws IOException{
        if (isEnableReporting.equals("true")) {
            MainCall.startReport();
        }
    }

    @BeforeMethod
    public void setup(Method method, ITestContext context) {
        ExcelReader.readSheets();

        if (isEnableReporting.equals("true")) {
            logger = MainCall.getExtentReport().startTest(fileList.get(index), "");
            logger.setStartedTime(envGlobals.time);
        }

        //Rest Assured config
        MainCall.setupRestAssured();
        row = 0;
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (isEnableReporting.equals("true"))
            MainCall.stepExecution(result);

        MainCall.clearSheet();
        index++;
    }

    @AfterSuite
    public void endReport() {
        if (isEnableReporting.equals("true")) {
            MainCall.getExtentReport().flush();
            MainCall.getExtentReport().close();
        }
    }

}
