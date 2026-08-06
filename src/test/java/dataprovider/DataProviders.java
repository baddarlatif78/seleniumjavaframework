package dataprovider;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtil;

public class DataProviders {

    @DataProvider(name = "loginData")

    public Object[][] loginData() {

        return ExcelUtil.getTestData(

                "src/test/resources/testdata/LoginData.xlsx",

                "Sheet1");

    }

}