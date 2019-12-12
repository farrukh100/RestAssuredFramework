package core.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import core.General.ExcelReader;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import static core.General.envGlobals.*;

public class AnnotationTransformerImpl implements IAnnotationTransformer {

    @Override
    public void transform(
        ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (!testMethod.getName().equalsIgnoreCase("compare")) {
            return;
        }
        if (readOnce) {
            ExcelReader.readExcelFiles();
            readOnce = false;
        }

        annotation.setInvocationCount(filesCount);
    }
}
