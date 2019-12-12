package core.General;

import org.apache.poi.ss.usermodel.*;
import org.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static core.General.envGlobals.*;
import static core.General.envGlobals.fileList;

public class ExcelReader {
    public static void readExcelFiles(){
        File file = new File("./Sheets");
        File[] files = file.listFiles();
        filesCount = files.length;

        for(File f: files){
            fileList.add(f.getName());

            try {
                workbook = WorkbookFactory.create(new File(f.toString()));

                for (Sheet aSheet: workbook)
                    sheet.add(aSheet);

                // Closing the workbook
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void readSheets() {
        // Getting the Sheet at index zero
        sheetName = sheet.get(index).getSheetName();
        rowsCount = sheet.get(index).getLastRowNum();

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // Using a for-each loop to iterate over the rows and columns
        for (Row row: sheet.get(index)) {
            for (int j=row.getFirstCellNum() ; j<row.getLastCellNum() ; j++) {
                Cell cell = row.getCell(j);
                String cellValue = dataFormatter.formatCellValue(cell);
                String columnHeader = sheet.get(index).getRow(row.getFirstCellNum()).getCell(j).toString();
                int a = row.getRowNum();

                if (cellValue == null || cellValue.equals("")){
                    columnRead(columnHeader, "", a);
                }
                else {
                    columnRead(columnHeader, cellValue, a);
                }
            }
        }
    }

    private static void columnRead(String columnName, String value, int rowNum){
        if (rowNum != 0){
            switch (columnName) {
                case "method":
                    sheetMethod.add(value);
                    break;
                case "endpoint":
                    sheetEndpoint.add(value);
                    break;
                case "headers":
                    sheetHeaders.add(value);
                    break;
                case "path params":
                    sheetPathParams.add(value);
                    break;
                case "query params":
                    sheetQueryParams.add(value);
                    break;
                case "form params":
                    sheetFormParams.add(value);
                    break;
                case "request payload":
                    sheetRequestPayload.add(value);
                    break;
                case "status code":
                    sheetStatusCode.add(value);
                    break;
                case "response flag":
                    sheetResponseFlag.add(value);
                    break;
//                case "response assertions":
//                    sheetResponseAssertions.add(value);
//                    break;
                case "response":
                    sheetResponse.add(value);
                    break;
            }
        }
    }

    private static void toMap(String str, Map map){
        if (!str.equals("") || str.length() != 0) {
            String[] strArr = str.split(terminator);
            for (String aStrArr : strArr) {
                key = GenericFunctions.before(aStrArr, separator);
                value = GenericFunctions.after(aStrArr, separator);
                map.put(key, value);
            }
        }
    }

    private static void toResponseStrings(String str){
        if (!str.equals("") || str.length() != 0) {
            String[] strArr = str.split(terminator);
            for (String aStrArr : strArr) {
                key = GenericFunctions.before(aStrArr, separator);
                value = GenericFunctions.after(aStrArr, separator);
                assertionPath.add(key);
                assertionValue.add(value);
            }
        }
    }

    private static void toJSONObject(String stringToParse){
        if (!stringToParse.equals("") || stringToParse.length() != 0) {
            jsonArrayList.add(new JSONArray(stringToParse));
        }
    }

    static void convertAll(int index){
        toMap(sheetHeaders.get(index), headersMap);
        toMap(sheetQueryParams.get(index), queryParamsMap);
        toMap(sheetPathParams.get(index), pathParamsMap);
        toMap(sheetFormParams.get(index), formParamsMap);
//        toResponseStrings(sheetResponseAssertions.get(index));
        toJSONObject(sheetResponse.get(index));
    }
}
