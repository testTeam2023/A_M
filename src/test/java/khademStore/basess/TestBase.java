package khademStore.basess;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.qameta.allure.Allure;
import khademStore.factoryPage.Factory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {
    protected WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setup() {
        driver = new Factory().initialization();

        // Set up Extent Report
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testResult = result.getMethod().getMethodName();
        String fileName = "target/screenshots/" + testResult + ".png";
        captureScreenShot(fileName);
        // Log test status in Extent Report
        test = extent.createTest(testResult);
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test skipped");
        }

        // Attach screenshot to Extent Report
        try {
            test.addScreenCaptureFromPath(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Flush Extent Report
        extent.flush();
        driver.quit();
    }

    public void captureScreenShot(String fileName) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (InputStream inputStream = new FileInputStream(fileName)) {
            Allure.addAttachment("ScreenShots", inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
