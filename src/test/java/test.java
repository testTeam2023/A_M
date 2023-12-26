import io.github.bonigarcia.wdm.WebDriverManager;
import khademStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.io.FileWriter;

public class test {

    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigUtils.getInstance().getUrl());
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[2]")))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href=\"/KhademStores/Item\"]")))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/h1/span")))).click();
driver.quit();

    }


}
