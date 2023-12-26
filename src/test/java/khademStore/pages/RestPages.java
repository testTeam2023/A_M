package khademStore.pages;

import io.qameta.allure.Step;
import khademStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class RestPages {
    private WebDriver driver ;
    private WebDriverWait wait;

    public RestPages(WebDriver driver) {
        this.driver = driver;
    }

    private By systemSettingButton  = By.xpath("//a[@href=\"#\"]/i[contains(@class, \"px-nav-icon fa fa-gear\")]/following-sibling::span[contains(@class, \"px-nav-label\")]");
    private By mainOperationsButton  = By.xpath("/html/body/nav[1]/div/ul/li[3]/a");
    private By reportsButton  = By.xpath("/html/body/nav[1]/div/ul/li[4]/a");
    private By systemSettings = By.xpath("/html/body/nav[1]/div/ul/li[2]/a");
    private By parentMenu = By.xpath("/html/body/nav[1]/div/ul/li[2]/ul");
    private By childMenu = By.tagName("a");
    private By settingAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By citesAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By unitAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By banksAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By lKCategoryAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By supplierWorkAreaAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By supplierAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By managementsAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By employeesAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By storesAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By storesCuratorAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By classificationAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By itemsAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By financeYearAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By itemsReceivedRecordAssertion = By.xpath("//*[@id=\"secondTab\"]");


    public RestPages mainPageLoad()throws InterruptedException{
        try {
            driver.get(ConfigUtils.getInstance().getUrl());
        }
        catch (Exception e) {
            // Handle the case where the element is not found within the specified timeout
            System.out.println("No internet connection or the page took too long to load.");
            throw new RuntimeException("Page load timed out.");
        }
        Thread.sleep(2000);
           return this ;
    }
    public RestPages clickOnSystemSettingsButton(){
        driver.findElement(systemSettingButton).click();
        return this ;
    }
    public RestPages navigateToSettingPage() throws InterruptedException{
      wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(0).click();
        Thread.sleep(1500);
        return this ;
    }

    public boolean settingPageIsDisplayed(){
     wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(settingAssertion)).isDisplayed();
    }
    public RestPages navigateToCitiesPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(1).click();
        Thread.sleep(1500);
        return this;
    }

    public boolean citiesPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(citesAssertion)).isDisplayed();
    }
    public RestPages navigateToUnitPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(2).click();
        Thread.sleep(1500);
        return this;
    }

    public boolean unitPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(unitAssertion)).isDisplayed();
    }
    public RestPages navigateToBanksPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(3).click();
        Thread.sleep(1500);
        return this ;
    }

    public boolean banksPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(banksAssertion)).isDisplayed();
    }

    public RestPages navigateToLkCategoryPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(4).click();
        Thread.sleep(1500);
        return this;
    }

    public boolean lkCategoryPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lKCategoryAssertion)).isDisplayed();
    }
    public RestPages navigateToSuppliersWorkAreaPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(5).click();
        Thread.sleep(1500);
        return this;
    }

    public boolean supplierWorkAreaPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(supplierWorkAreaAssertion)).isDisplayed();
    }
    public RestPages navigateToSuppliersPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(6).click();
        Thread.sleep(1500);
        return this ;
    }

    public boolean suppliersPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(supplierAssertion)).isDisplayed();
    }
    public RestPages navigateToManagementPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(7).click();
        Thread.sleep(1500);
        return this ;
    }

    public boolean managementPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(managementsAssertion)).isDisplayed();
    }
    public RestPages navigateToEmployeesPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(8).click();
        Thread.sleep(1500);
        return this ;
    }

    public boolean employeesPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(employeesAssertion)).isDisplayed();
    }
    public RestPages navigateToStoresPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(9).click();
        Thread.sleep(1500);
        return this ;
    }

    public boolean storesPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(storesAssertion)).isDisplayed();
    }
    public RestPages navigateToStoresCuratorPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(10).click();
        Thread.sleep(1500);
        return this ;
    }

    public boolean storesCuratorPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(storesCuratorAssertion)).isDisplayed();
    }
    public RestPages navigateToClassificationsPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(11).click();
        Thread.sleep(1500);
        return this ;
    }

    public boolean classificationsPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(classificationAssertion)).isDisplayed();
    }
    public RestPages navigateToItemsPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(12).click();
        Thread.sleep(1500);
        return this ;
    }

    public boolean ItemsPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemsAssertion)).isDisplayed();
    }

    public RestPages navigateToFinancialYearPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(13).click();
        Thread.sleep(1500);
        return this ;
    }

    public boolean financialYearPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(financeYearAssertion)).isDisplayed();
    }
    public RestPages clickOnMainOperationsButton(){
        driver.findElement(mainOperationsButton).click();
        return this ;
    }

    public RestPages navigateToItemsReceivedRecordPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(ConfigUtils.getInstance().getItemReceivedRecordPage());
        Thread.sleep(1500);
        return this ;
    }
    public boolean itemsReceivedRecordPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemsReceivedRecordAssertion)).isDisplayed();
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    private By receivedRecordReport = By.xpath("//*[@href=\"/KhademStores/Reports/ReportParamters?ReportID=13\"]");
    private By displayReportButton = By.xpath("//*[@id=\"btnSave\"]");
    private By receivedRecordReportIsDisplay = By.xpath("//*[contains(text(),\"عمل لمحاضر الاستلام\")]");
    private By statisticalReceivedReportDisplay = By.xpath("//*[contains(text(),\"عمل لمحاضر الاستلام\")]");
    private By statisticalReceivedReport = By.xpath("//*[@href=\"/KhademStores/Reports/ReportParamters?ReportID=77\"]");
    private By supplier = By.xpath("//*[@id=\"select2-SuppID-container\"]");
    private By parentSupplier = By.xpath("//*[@id=\"select2-SuppID-results\"]");
    private By childSupplier = By.tagName("li");
    private By recordClassification = By.xpath("//*[@id=\"select2-CategoryID-container\"]");
    private By parentRecordClassification = By.xpath("//*[@id=\"select2-CategoryID-results\"]");
    private By childRecordClassification = By.tagName("li");
    //
    private By clickOnsaveIcon = By.xpath("//*[@id=\"ReportViewer1_ctl09_ctl04_ctl00_ButtonImg\"]");
    private By clickOnPdf = By.xpath("//*[@id=\"ReportViewer1_ctl09_ctl04_ctl00_Menu\"]/div[3]/a");
    public RestPages clickOnReporsButton(){
        driver.findElement(reportsButton).click();
        return this ;
    }

    @Step
    public RestPages navigateToMainOperationReportPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(ConfigUtils.getInstance().getReportsPage());
        Thread.sleep(1500);
        return this ;
    }
    @Step
    public RestPages clickOnReceivedRecordReport()throws InterruptedException{
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(receivedRecordReport)).click();
        Thread.sleep(1500);
        return this ;
    }
    @Step

    public RestPages openReceivedRecordReport() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        String main =  driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(displayReportButton)).click();
        Thread.sleep(13000);
        Set<String> windows = driver.getWindowHandles();
        for (String s :windows){
            if (!s.equals(main)){
                driver.switchTo().window(s);
                //wait.until(ExpectedConditions.elementToBeClickable(clickOnsaveIcon)).click();
              //  Thread.sleep(1300);
              ///  wait.until(ExpectedConditions.elementToBeClickable(clickOnPdf)).click();
    //            Thread.sleep(2500);
                Actions action = new Actions(driver);
                action.moveToElement(driver.findElement(receivedRecordReportIsDisplay)).perform();
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("window.scrollBy(0,150)");
                boolean result =wait.until(ExpectedConditions.presenceOfElementLocated(receivedRecordReportIsDisplay)).isDisplayed();
                System.out.println(result);
                driver.close();
                driver.switchTo().window(main);
            }
        }
        return this ;
    }
    @Step

    public boolean isReceivedRecordReportDisplay(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.presenceOfElementLocated(receivedRecordReportIsDisplay)).isDisplayed();
    }
    public boolean isStatisticalReceivedReportDisplay(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.presenceOfElementLocated(statisticalReceivedReportDisplay)).isDisplayed();
    }
    public RestPages clickOnStatisticalReceivedReport()throws InterruptedException{
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(statisticalReceivedReport)).click();
        Thread.sleep(1500);
        return this ;
    }
    @Step

    public RestPages chooseSupplier(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(supplier)).click();
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentSupplier));
        List<WebElement>child = parent.findElements(childSupplier);
        child.get(1).click();
        return this;
    }

    @Step

    public RestPages chooseRecordClassification(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(recordClassification)).click();
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentRecordClassification));
        List<WebElement>child = parent.findElements(childRecordClassification);
        child.get(1).click();
        return this;
    }
    @Step

    public RestPages openStatisticalReceivedReport() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        String main =  driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(displayReportButton)).click();
        Thread.sleep(13000);
        Set<String> windows = driver.getWindowHandles();
        for (String s :windows){
            if (!s.equals(main)){
                driver.switchTo().window(s);
                //wait.until(ExpectedConditions.elementToBeClickable(clickOnsaveIcon)).click();
                //Thread.sleep(1300);
               // wait.until(ExpectedConditions.elementToBeClickable(clickOnPdf)).click();
               // Thread.sleep(2500);
                Actions action = new Actions(driver);
                action.moveToElement(driver.findElement(statisticalReceivedReportDisplay)).perform();
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("window.scrollBy(0,150)");
                boolean result =wait.until(ExpectedConditions.presenceOfElementLocated(statisticalReceivedReportDisplay)).isDisplayed();
                System.out.println(result);
                driver.switchTo().window(main);
            }
        }
        return this ;
    }
    @Step
    public RestPages extractPdf()throws InterruptedException{
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickOnsaveIcon)).click();
        Thread.sleep(1300);
        wait.until(ExpectedConditions.elementToBeClickable(clickOnPdf)).click();
        Thread.sleep(2500);
        return this;
    }






















}
