package module;

import core.General.BaseTest;
import core.General.MainCall;
import org.testng.annotations.Test;

import static core.General.RestFuntions.*;
import static core.General.envGlobals.*;

public class Tests extends BaseTest{
    public Tests(){
    }

    @Test
    public void compare() {
        for (int i=0 ; i<rowsCount-1 ; i++) {
            row = i;

            givenFunction();
            andMethodEndPointFunction();
            thenFunction();
            assertResponse();

            if (i == 0)
                oCode = extractFromResponse("o_Code");

            MainCall.clearData();
        }
    }

}
