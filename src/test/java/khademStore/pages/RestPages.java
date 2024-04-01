package khademStore.pages;

import io.qameta.allure.Step;
import khademStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RestPages {
    private WebDriver driver ;
    private WebDriverWait wait;


    public RestPages(WebDriver driver) {
        this.driver = driver;
    }

    private By systemSettingButton  = By.xpath("/html/body/nav[1]/div/ul/li[2]/a");
    private By saveButton  = By.xpath("//*[@id=\"btnSave\"]");
    private By messageSuccessButton  = By.cssSelector("#btn-ok-modal");
    private By messageSuccessIsDisplayed  = By.xpath("/html/body/div[9]/div/div");
    private By citeyName=By.xpath("//*[@id=\"City_Name\"]");
    private By unitName=By.xpath("//*[@id=\"unit_name\"]");
    private By bankName= By.xpath("//*[@id=\"BanksName\"]");
    private By bankCode= By.xpath("//*[@id=\"BanksCode\"]");
    private By classifcationName = By.xpath("//*[@id=\"CategoryName\"]");
    private By suppWorkAreaName = By.xpath("//*[@id=\"SuppClassName\"]");
    private By suppName = By.xpath("//*[@id=\"Supp_Name\"]");
    private By aadNewClassificationButton = By.xpath("//*[@id=\"btnAddNewClassification\"]");
    private By departmentName= By.xpath("//*[@id=\"DepartmentName\"]");
    private By department= By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/form/div[1]/div[2]/div/span[1]/span[1]/span/span[1]");
    private By departmentParent= By.xpath("//*[@id=\"select2-DepartmentparentId-results\"]");
    private By departmentChild= By.tagName("li");
   // private By employee= By.xpath("//*[@id=\"select2-EmployeeDepartmentId-container\"]");
   // private By employeeParent= By.xpath("//*[@id=\"select2-EmployeeDepartmentId-results\"]");
  //  private By employeeChild= By.tagName("li");
 //   private By employeeName = By.xpath("//*[@id=\"EmployeeName\"]");
  //  private By employeeCode= By.xpath("//*[@id=\"EmployeeUserName\"]");
   // private By storeName = By.xpath("//*[@id=\"store_name\"]");
   // private By StoresLocation = By.xpath("//*[@id=\"store_place\"]");
  //  private By storesType = By.xpath("//*[@id=\"StoreTypeId\"]");
   // private By StoresName = By.xpath("//*[@id=\"select2-Store_id-container\"]");
  //  private By StoresEmployeeParent = By.xpath("//*[@id=\"select2-Store_id-results\"]");
 // private By StoresEmployeeChild = By.tagName("li");
    //
   private By employeeDepartmentWanted= By.xpath("//*[@id=\"EmployeeDepartmentId-error\"]");
   private By storeNameWanted= By.xpath("//*[@id=\"store_name-error\"]");
    private By employeeNameWanted= By.xpath("//*[@id=\"EmployeeName-error\"]");
    private By classificationNameWanted= By.xpath("//*[@id=\"class_name-error\"]");
    private By financialYearNameWanted= By.xpath("//*[@id=\"FinanceYearName\"]");
    private By mainOperationsButton  = By.xpath("/html/body/nav[1]/div/ul/li[3]/a");
    private By reportsButton  = By.xpath("/html/body/nav[1]/div/ul/li[4]/a");
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
    private By modalSuccess = By.cssSelector("#div-success-modal > div > div");


    public RestPages mainPageLoad()throws InterruptedException{
        int maxAttempt = 2;
        int attempt = 0;
        while (attempt < maxAttempt) {
        try {
            driver.get(ConfigUtils.getInstance().getUrl());
            driver.navigate().refresh();
            Thread.sleep(3000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return this ;
        }
        catch (Exception e) {
            attempt++;
        }
        }
            throw new RuntimeException("Page load timed out.");

    }
    public RestPages clickOnSystemSettingsButton() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(systemSettingButton)).click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public RestPages navigateToSettingPage() throws InterruptedException{
      wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }

    public boolean storesPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(storesAssertion)).isDisplayed();
    }
    public RestPages navigateToStoresCuratorPage() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(ConfigUtils.getInstance().getStoreCurator());
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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public boolean itemsReceivedRecordPageIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemsReceivedRecordAssertion)).isDisplayed();
    }

    public RestPages clickOnSaveButton () throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(saveButton)).click().build().perform();
       // wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        Thread.sleep(5000);
        return this ;
    }
    public RestPages clickOutsideTheModal () {
        Actions actions = new Actions(driver);
        try {
            actions.moveByOffset(-80, -80).click().build().perform();
        }
        catch (Exception e){
            actions.moveByOffset(80, 80).click().build().perform();
        }
         return this ;
    }
    public RestPages clickOnSuccessMessageButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalSuccess));
            wait.until(ExpectedConditions.presenceOfElementLocated(modalSuccess));
            if (driver.findElement(modalSuccess).isDisplayed()) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(messageSuccessButton));
                Actions actions = new Actions(driver);
                actions.scrollToElement(driver.findElement(messageSuccessButton)).perform();
                actions.moveToElement(driver.findElement(messageSuccessButton)).click().build().perform();
            }
        }catch (Exception e) {
                boolean isTextDisplayed = driver.getPageSource().contains("تعديل");
                if (isTextDisplayed){
                    System.out.println("Expected text is displayed on the page.");
                }
                else {
                    System.out.println("Expected text is not displayed on the page");
                }
           }
          return this;
    }

    public boolean successMessageIsDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(messageSuccessIsDisplayed)).isDisplayed();

    }
    public RestPages enterCityName(String cityName){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(citeyName)).sendKeys(cityName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public RestPages enterUnitName(String unitsName){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(unitName)).sendKeys(unitsName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;

    }
    public RestPages enterBankDetails(String banksName , String BanksCode){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bankName)).sendKeys(banksName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(bankCode)).sendKeys(BanksCode);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public RestPages enterClassificationDetails(String classificationsName){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(classifcationName)).sendKeys(classificationsName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public RestPages enterSuppWorkAreaDetails(String suppsWorkAreaName){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(suppWorkAreaName)).sendKeys(suppsWorkAreaName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public RestPages enterSuppDetails(String suppsName ) throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(suppName)).sendKeys(suppsName);
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(aadNewClassificationButton));
        wait.until(ExpectedConditions.elementToBeClickable(aadNewClassificationButton)).click();
        Thread.sleep(1500);
    return this ;
    }

    public RestPages enterDepartmentDetails(String departmntName){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         int attempt =0;
        int maxAttempt = 3 ;
        while (attempt<maxAttempt) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(departmentName)).sendKeys(departmntName);
                wait.until(ExpectedConditions.visibilityOfElementLocated(department)).click();
                WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(departmentParent));
                List<WebElement> child = parent.findElements(departmentChild);
                child.get(1).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                return this;
            } catch (Exception e) {
                System.out.println("StaleElementReferenceException occurred. Retrying...");
            }
        }
        throw new RuntimeException("failed to enter department Details");
    }

    public boolean employeeErrorMessageIsDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(employeeDepartmentWanted))
                .isDisplayed();
    }
    public boolean storeErrorMessageIsDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(storeNameWanted))
                .isDisplayed();
    }

    public String storeEmployeeErrorMessageText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        int MaxAttempt = 3 ;
        for (int attempt =0; attempt<MaxAttempt; attempt++) {
            try {

               String getText= wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameWanted))
                        .getText();
                System.out.println(getText);
                return getText ;
            } catch (TimeoutException e) {
                System.out.println("retrying");
            }
        }
            throw new RuntimeException("fail to assert");
        }

    public boolean classificationErrorMessageIsDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(classificationNameWanted))
                .isDisplayed();
    }
    public boolean financialYearErrorMessageIsDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.presenceOfElementLocated(financialYearNameWanted))
                .isDisplayed();
    }


    /////////////////////////////////////////////////////////////////////////////////////////
    private By receivedRecordReport = By.xpath("//*[@href=\"/KhademStores/Reports/ReportParamters?ReportID=13\"]");
    private By displayReportButton = By.xpath("//*[@id=\"btnSave\"]");
    private By parentReportContent = By.xpath("/html/body/form/div[3]/table/tbody/tr/td/div/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[4]/td[3]/table/tbody");
    private By childReportContent = By.tagName("tr");
    private By parentStatisticalReportContent = By.xpath("/html/body/form/div[3]/table/tbody/tr/td/div/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[3]/table/tbody");
    private By receivedRecordReportIsDisplay = By.xpath("//td//div[contains(text(),'تقرير بأوامر العمل لمحاضر الاستلام')]");
    private By statisticalReceivedReportDisplay = By.xpath("//td//div[contains(text(),'تقرير بأوامر العمل لمحاضر الاستلام')]");
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
        int maxAttempt = 2;
        int attempt = 0;
        while (attempt < maxAttempt) {
            try {
                driver.get(ConfigUtils.getInstance().getReportsPage());
                return this;
            }
            catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Retrying navigate to main operation report page");
                attempt++;
            }
        }
        throw new RuntimeException("Page load timed out.");
    }
    @Step
    public RestPages clickOnReceivedRecordReport()throws InterruptedException{
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(receivedRecordReport)).click();
        Thread.sleep(2000);
        return this ;
    }
    @Step

    public RestPages openReceivedRecordReport() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String main = driver.getWindowHandle();

        int maxAttempts = 3;
        int attempt = 0;

        while (attempt < maxAttempts) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(displayReportButton)).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                Set<String> windows = driver.getWindowHandles();
                for (String s : windows) {
                    if (!s.equals(main)) {
                        driver.switchTo().window(s);
                        driver.navigate().refresh();
                        Thread.sleep(13000);
                        WebElement parent = wait.until(ExpectedConditions.visibilityOfElementLocated(parentReportContent));
                        List<WebElement> child = parent.findElements(childReportContent);
                        boolean result = child.get(2).isDisplayed();
                        System.out.println(result);
                        driver.close();
                        driver.switchTo().window(main);
                    }
                }
                return this;
            } catch (Exception e) {
                System.out.println("Attempt #" + (attempt + 1) + " failed: " + e.getMessage());
                attempt++;
            }
        }
        throw new RuntimeException("Failed to open received record report after " + maxAttempts + " attempts");
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
        Thread.sleep(2000);
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
        int maxAttempt = 3 ;
        int attempt = 0 ;
        while (attempt<maxAttempt) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(displayReportButton)).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                Set<String> windows = driver.getWindowHandles();
                for (String s : windows) {
                    if (!s.equals(main)) {
                        driver.switchTo().window(s);
                        driver.navigate().refresh();
                        Thread.sleep(15000);
                        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentStatisticalReportContent));
                        List<WebElement> child = parent.findElements(childReportContent);
                        boolean result = child.get(2).isDisplayed();
                        System.out.println(result);
                        driver.close();
                        driver.switchTo().window(main);
                    }
                }
                return this;
            } catch (Exception e) {
                System.out.println("Attempt #" + (attempt + 1) + " failed: " + e.getMessage());
                attempt++;
            }
        }
            throw new RuntimeException("Failed to open statistical received record report after " + maxAttempt + " attempts");
    }
    @Step
    public RestPages extractPdf()throws InterruptedException{
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickOnsaveIcon)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));;
        wait.until(ExpectedConditions.elementToBeClickable(clickOnPdf)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this;
    }






















}
