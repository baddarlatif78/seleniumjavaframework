package reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            String reportDir = System.getProperty("user.dir") + "/reports";
            new File(reportDir).mkdirs();

            String reportPath = reportDir + "/AutomationReport.html";

            System.out.println("Extent Report Path: " + reportPath);

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            spark.config().setReportName("Selenium Automation Report");
            spark.config().setDocumentTitle("Automation Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Baddar Latif");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Language", "Java");
        }

        return extent;
    }
}