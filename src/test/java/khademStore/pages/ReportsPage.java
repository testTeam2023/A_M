package khademStore.pages;

import io.qameta.allure.Step;
import khademStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ReportsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public ReportsPage(WebDriver driver) {
        this.driver = driver;
    }
    private By receivedRecordReport = By.xpath("//*[@href=\"/KhademStores/Reports/ReportParamters?ReportID=13\"]");
    private By displayReportButton = By.xpath("//*[@id=\"btnSave\"]");
    private By reportIsDisplay = By.xpath("//*[contains(text(),\"تقرير بأوامر العمل لمحاضر الاستلام\")]");
    private By statisticalReceivedReport = By.xpath("//*[@href=\"/KhademStores/Reports/ReportParamters?ReportID=77\"]");
    private By supplier = By.xpath("//*[@id=\"select2-SuppID-container\"]");
    private By parentSupplier = By.xpath("//*[@id=\"select2-SuppID-results\"]");
    private By childSupplier = By.tagName("li");
    //
    private By recordClassification = By.xpath("//*[@id=\"select2-CategoryID-container\"]");
    private By parentRecordClassification = By.xpath("//*[@id=\"select2-CategoryID-results\"]");
    private By childRecordClassification = By.tagName("li");
    //
    private By clickOnsaveIcon = By.xpath("//*[@id=\"ReportViewer1_ctl09_ctl04_ctl00_ButtonImg\"]");
    private By clickOnPdf = By.xpath("//*[@id=\"ReportViewer1_ctl09_ctl04_ctl00_Menu\"]/div[3]/a");

    @Step
    public ReportsPage navigateToReportsPage()throws InterruptedException{
        int maxAttempt = 5;
        int attempt = 0;
        while (attempt < maxAttempt) {
            try {
                driver.get(ConfigUtils.getInstance().getReportsPage());
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                return this;
            }
            catch (Exception e){
                attempt++;
            }
        }
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues");    }
    @Step
    public ReportsPage clickOnReceivedRecordReport()throws InterruptedException{
    wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.elementToBeClickable(receivedRecordReport)).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    return this ;
}
    @Step

public ReportsPage openReceivedRecordReport() throws InterruptedException {
    wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    String main =  driver.getWindowHandle();
    System.out.println(main);
    wait.until(ExpectedConditions.elementToBeClickable(displayReportButton)).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    Set<String> windows = driver.getWindowHandles();
    for (String s :windows){
        if (!s.equals(main)){
            driver.switchTo().window(s);
            System.out.println(s);
        }
    }
     return this ;
}
    @Step

    public boolean isReportDisplay(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(reportIsDisplay)).isDisplayed();
}
    public ReportsPage clickOnStatisticalReceivedReport()throws InterruptedException{
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(statisticalReceivedReport)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    @Step

    public ReportsPage chooseSupplier(){
    wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.elementToBeClickable(supplier)).click();
    WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentSupplier));
    List<WebElement>child = parent.findElements(childSupplier);
    child.get(1).click();
    return this;
}

    @Step

    public ReportsPage chooseRecordClassification(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(recordClassification)).click();
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentRecordClassification));
        List<WebElement>child = parent.findElements(childRecordClassification);
        child.get(1).click();
        return this;
    }
    @Step

    public ReportsPage openStatisticalReceivedReport() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        String main =  driver.getWindowHandle();
        System.out.println(main);
        wait.until(ExpectedConditions.elementToBeClickable(displayReportButton)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Set<String> windows = driver.getWindowHandles();
        for (String s :windows){
            if (!s.equals(main)){
                driver.switchTo().window(s);
                System.out.println(s);
            }
        }
        return this ;
    }
    @Step
    public ReportsPage extractPdf()throws InterruptedException{
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickOnsaveIcon)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(clickOnPdf)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this;
    }

}
