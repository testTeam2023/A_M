package khademStore.basess;
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

public class TestBase {
    protected WebDriver driver ;
    public void driver(WebDriver driver){
        this.driver=driver;
    }
    @BeforeMethod
    public void setup() {
        driver = new Factory().initialization();
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        String testResult= result.getMethod().getMethodName();
        String fileName = "target"+File.separator+"screenshots"+File.separator+testResult+".png";
        captureScreenShot(fileName);
       driver.quit();
    }
    public void captureScreenShot(String fileName){
        File screenShot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
    }
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Allure.addAttachment("screenShots",inputStream);
}

    }
