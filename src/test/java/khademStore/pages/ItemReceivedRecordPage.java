package khademStore.pages;

import khademStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ItemReceivedRecordPage {
    private WebDriver driver ;
    private WebDriverWait wait;
    public ItemReceivedRecordPage(WebDriver driver){
        this.driver=driver;
    }
    private By invoiceNumber = By.xpath("//*[@id=\"InvoiceNumber\"]");
    private By invoiceNumberError = By.xpath("//*[@id=\"InvoiceNumber-error\"]");
    private By supplierName = By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[1]/form/div[3]/div[3]/div/span[1]/span[1]/span/span[1]");
    private By supplierNameError = By.xpath("//*[@id=\"SuppID-error\"]");
    //private By searchInSupplierName   = By.xpath("/html/body/span/span/span[1]/input");
    private By parentSupplierName   = By.xpath("//*[@id=\"select2-SuppID-results\"]");
    private By childSupplierName   = By.tagName("li");
    private By selectSupplierName   = By.xpath("//li[contains(text(), 'تيست')]");
    private By attachment  = By.xpath("//*[@id=\"Enclosed\"]");
    private By attachmentError  = By.xpath("//*[@id=\"Enclosed-error\"]");
    //
    private By receiverName  = By.xpath("//*[@id=\"EmployeeIDRecieved\"]");
    private By itemName  = By.xpath("//*[@id=\"TxtItemNameSearchautocomplete\"]");
    private By parentItemsSelection  = By.xpath("//ul[@id=\"ui-id-1\"]");
    private By childItems  = By.xpath("//*[@class=\"ui-menu-item\"]");
    private By parentItemList = By.xpath("//*[@id=\"itemStoresList\"]");
    private By childItemList = By.tagName("li");
    private By selectItemName1  = By.xpath("//*[@id=\"ui-id-31\"]");
    private By selectItemName2  = By.xpath("//*[@id=\"ui-id-5\"]");
    private By itemQuantity  = By.xpath("//*[@id=\"Itemquantity\"]");
    private By itemPrice  = By.xpath("//*[@id=\"Itemprice\"]");
    private By netValue = By.xpath("//*[@id=\"Net_value\"]");
    private By taxValue = By.xpath("//*[@id=\"AddedValue\"]");
    private By totalValue = By.xpath("//*[@id=\"TotalAfterAddedValue\"]");
    private By addItemButton  = By.xpath("//*[@id=\"btnAddNewItem\"]");
    private By valueDiscountType  = By.xpath("//input[@name=\"DIS_Type\" and @value=\"2\"]");
    private By percentDiscountType  = By.xpath("//input[@name=\"DIS_Type\" and @value=\"1\"]");
    private By percentDiscountBox  = By.xpath("//*[@id=\"DIS_PER\"]");
    private By valueDiscountBox  = By.xpath("//*[@id=\"DIS_VAL\"]");
    private By saveButton  = By.xpath("//*[contains(@class,\"btn btn-3d btn-success margin-left-20\")]");
    private By messaageSuccessButton  = By.xpath("//*[@id=\"btn-ok-modal\"]");
    private By messaageSuccess  = By.xpath("/html/body/div[10]/div/div/div[3]");

    private By enterItemation  = By.xpath("//*[@id=\"div-error-modal\"]/div/div/div[3]");

    public ItemReceivedRecordPage navigateToTheItemReceivedRecordPage() throws InterruptedException{
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.get(ConfigUtils.getInstance().getItemReceivedRecordPage());
            driver.navigate().refresh();
                Thread.sleep(5000);
            Actions action = new Actions(driver);
            action.doubleClick(wait.until(ExpectedConditions.visibilityOf(driver.findElement(invoiceNumber))));
        }
        catch (Exception e) {
            // Handle the case where the element is not found within the specified timeout
            throw new RuntimeException("No internet connection or the page took too long to load.");
        }
        return this;
    }
    public ItemReceivedRecordPage enterInvoiceNumber(String invoice_Number) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(invoiceNumber)).sendKeys(invoice_Number);
        Thread.sleep(1000);
        return this;
    }
    public ItemReceivedRecordPage selectSupplierName() throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean staleElement = true;
        while (staleElement) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(supplierName)).click();
                Thread.sleep(1000);
                WebElement parentSuppName = wait.until(ExpectedConditions.presenceOfElementLocated(parentSupplierName));
                List<WebElement> childSuppName = parentSuppName.findElements(childSupplierName);
                childSuppName.get(1).click();
                Thread.sleep(1000);
                staleElement = false;
            } catch (Exception e) {
                System.out.println("StaleElementReferenceException occurred. Retrying...");
            }
        }
        return this;
    }
    public ItemReceivedRecordPage enterAttachment(String attachemnt){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(attachment)).sendKeys(attachemnt);
        return this;
    }
    public ItemReceivedRecordPage setReceiverName(String receiver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(receiverName)).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(receiverName)).sendKeys(receiver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(receiverName)).sendKeys(Keys.ENTER);
        }
        catch (Exception e){
            System.out.println(e);
        }

        return this;
    }

    public ItemReceivedRecordPage addTheItem(String item) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(itemName)).sendKeys(item);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this;
    }
    public ItemReceivedRecordPage selectMultipleItems() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        addTheItem("V");
        WebElement element = driver.findElement(parentItemsSelection);
        wait.until(ExpectedConditions.presenceOfElementLocated(parentItemsSelection));
        List<WebElement> items = element.findElements(childItems);
        for (int i = 0; i < items.size(); i++) {
            WebElement item = element.findElements(childItems).get(i);
            wait.until(ExpectedConditions.elementToBeClickable(item));
            String itemName = item.getText();
            System.out.println("Selecting item: " + itemName);
            try {
                item.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                enterQuantity();
                enterPrice();
                clickOnAddItemButton();
                try {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                    enterQuantity().clickOnAddItemButton();
                }
                catch (Exception e){
                    new RuntimeException(e);
                }
            }
            catch (Exception e){
            }
            addTheItem("v");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(childItems));
        }
        return this;
    }
    public ItemReceivedRecordPage selectAnItemFromItemList()throws InterruptedException{
     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addTheItem("v");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement parentItems = wait.until(ExpectedConditions.presenceOfElementLocated(parentItemsSelection));
        List<WebElement> childItem = parentItems.findElements(childItems);
        childItem.get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this;
    }
    public ItemReceivedRecordPage enterQuantity(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Random random = new Random();
        int randomQty= random.nextInt(91)+10;
        String itemQty = String.valueOf(randomQty);
        wait.until(ExpectedConditions.elementToBeClickable(itemQuantity)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(itemQuantity)).sendKeys(itemQty);
        return this;
    }
    public ItemReceivedRecordPage enterPrice() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Random random = new Random();
        int randomPrices = random.nextInt(10001)+10 ;
        String price = String.valueOf(randomPrices);
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemPrice)).clear();
        driver.findElement(itemPrice).sendKeys(price);
        return this;
    }
    public double totalPriceWithTaxes(){
        String netValueStr = driver.findElement(netValue).getAttribute("value");
        String taxValueStr = driver.findElement(taxValue).getAttribute("value");
        Double netValueInt = Double.parseDouble(netValueStr);
        Double taxValueInt = Double.parseDouble(taxValueStr);
       return netValueInt + taxValueInt;
       // int resultAsInt = (int) Math.round(result);
       // return resultAsInt ;
    }
    public double  totalPrice(){
        String totalPrice =driver.findElement(totalValue).getAttribute("value");
        return  Double.parseDouble(totalPrice);
     //   int resultInt = (int) Math.round(netValueNumber);
       // return resultInt;
    }
    public ItemReceivedRecordPage clickOnAddItemButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addItemButton)).click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this;
    }
    public ItemReceivedRecordPage scrollDown(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(saveButton)).perform();
        return this ;
    }
    public ItemReceivedRecordPage clickOnSaveButton()throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(saveButton)).perform();
        actions.moveToElement(driver.findElement(saveButton)).click().build().perform();
        Thread.sleep(8000);
        return this;
    }
    public ItemReceivedRecordPage clickOutsideTheModal () {
        Actions actions = new Actions(driver);
        try {
            actions.moveByOffset(200, -50).click().build().perform();
        }
        catch (Exception e){
            actions.moveByOffset(0, 0).click().build().perform();
        }
        return this ;
    }
    public ItemReceivedRecordPage clickOnMessageSuccessButton()throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      //  try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Actions actions = new Actions(driver);
            actions.scrollToElement(driver.findElement(messaageSuccessButton)).perform();
            actions.moveToElement(driver.findElement(messaageSuccessButton)).click().build().perform();
   //     }
    //    catch (Exception e){
   //         try {
       //     Actions actions = new Actions(driver);
      //      actions.moveByOffset(200, -50).click().build().perform();
    //    }
        //    catch (Exception ee){
          //      Actions actions = new Actions(driver);
         //       actions.moveByOffset(0, 0).click().build().perform();
         //   }
   //     }
        return this;
    }
    public String invoiceNumberationText(){
       return driver.findElement(invoiceNumberError).getText();
    }
    public String attachmentErrorationText(){
        return driver.findElement(attachmentError).getText();
    }
    public String supplierNameErrorationText(){
        return driver.findElement(supplierNameError).getText();
    }
    public String enterItemationText(){
        return driver.findElement(enterItemation).getText();
    }
    //-----------------------------------------------------------------------------------------------------------------//
    private By searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private By  inoviceNo_searchBox = By.xpath("//input[@id=\"SearchControl_Criteria_List_0__Value\"]");
    private By  byNumber_searchBox = By.xpath("//*[@id=\"SearchControl_Criteria_List_1__Value\"]");
    private By  filterToSelect = By.xpath("//select[@id=\"SearchControl_Criteria_List_1__SelectedComparator\"]");
    private By  receivedRecordNo_searchBox = By.xpath("//input[@id=\"SearchControl_Criteria_List_2__Value\"]");
    private By  filterOfSelect = By.xpath("//select[@id=\"SearchControl_Criteria_List_2__SelectedComparator\"]");
    private By  financialYear = By.xpath("//*[@id=\"select2-SearchControl_Criteria_List_3__Value-container\"]");
    private By  parentFinancialYear = By.xpath("//ul[@id=\"select2-SearchControl_Criteria_List_3__Value-results\"]");
    private By  childFinancialYear = By.tagName("li");
    private By privateNo_SearchBox = By.xpath("//*[@id=\"SearchControl_Criteria_List_4__Value\"]");
    private By  filterOfSelection = By.xpath("//*[@id=\"SearchControl_Criteria_List_4__SelectedComparator\"]");
    private By selectStore = By.xpath("//*[@id=\"select2-SearchControl_Criteria_List_5__Value-container\"]");
    private By parentSelectStore = By.xpath("//ul[@id=\"select2-SearchControl_Criteria_List_5__Value-results\"]");
    private By childSelectStore = By.tagName("li");
    private By receiver= By.xpath("//*[@id=\"select2-SearchControl_Criteria_List_6__Value-container\"]");
    private By parentReceiver= By.xpath("//*[@id=\"select2-SearchControl_Criteria_List_6__Value-results\"]");
    private By childReceiver= By.tagName("li");
    private By supplier= By.xpath("//span[@id=\"select2-SearchControl_Criteria_List_7__Value-container\"]");
    private By parentSupplier= By.xpath("//ul[@id=\"select2-SearchControl_Criteria_List_7__Value-results\"]");
    private By childSupplier= By.tagName("li");
    private By  totalWithTax_searchBox = By.xpath("//*[@id=\"SearchControl_Criteria_List_8__Value\"]");
    private By filterToSelection = By.xpath("//*[@name=\"SearchControl.Criteria.List[8].SelectedComparator\" and @id=\"SearchControl_Criteria_List_8__SelectedComparator\"]");
    private By recordMaker= By.xpath("//*[@id=\"select2-SearchControl_Criteria_List_9__Value-container\"]");
    private By parentRecordMaker= By.xpath("//*[@id=\"select2-SearchControl_Criteria_List_9__Value-results\"]");
    private By childRecordMaker= By.tagName("li");
    ////*[@id="select2-SearchControl_Criteria_List_9__Value-results"]
    private By Search_button = By.xpath("//*[@value=\"بـحـث\"]");
    private By parentSearchTable = By.xpath("//*[@id=\"tblDataTableClient\"]/thead");
    private By childSearchTable = By.tagName("tr");
    private By parentSearchResult = By.xpath("//*[@id=\"tblDataTableClient\"]/tbody");
    private By childSearchResult = By.tagName("td");
    private By paginationSign = By.xpath("//*[contains(@class,\"btn-outline\") and @value=\">\"]");
    public ItemReceivedRecordPage clickOnSearchTab()throws InterruptedException{
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchTab))).click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this;
    }
    public ItemReceivedRecordPage clickOnSearchButton()throws InterruptedException{
    wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    try {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(Search_button));
        actions.moveToElement(driver.findElement(Search_button)).click().build().perform();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    catch (Exception e){
        driver.navigate().refresh();
        clickOnSearchTab();
        clickOnSearchTab();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Search_button)).click().build().perform();        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    return this ;
}

    public ItemReceivedRecordPage searchWithInvoiceNumber(String invoiceNo){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(inoviceNo_searchBox))).sendKeys(invoiceNo);
        return this;
    }
    public ItemReceivedRecordPage searchWithRecordNumber(String recordNo){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Select select = new Select(driver.findElement(filterToSelect));
        select.selectByIndex(3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(byNumber_searchBox))).sendKeys(recordNo);
        return this;

    }
    public ItemReceivedRecordPage searchWithreceivedRecordNumber(String recordNo){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Select select = new Select(driver.findElement(filterOfSelect));
        select.selectByIndex(2);
        wait.until(ExpectedConditions.elementToBeClickable(receivedRecordNo_searchBox)).sendKeys(recordNo);
        return this;
    }
    public ItemReceivedRecordPage selectFinancialYear()throws InterruptedException{
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(financialYear))).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement parentFinancial = wait.until(ExpectedConditions.presenceOfElementLocated(parentFinancialYear));
        List<WebElement>childFinancial = parentFinancial.findElements(childFinancialYear);
        childFinancial.get(1).click();
        return this;
    }
    public ItemReceivedRecordPage enterPrivateNumber(String privateNo){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Select select = new Select(driver.findElement(filterOfSelection));
        select.selectByIndex(3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(privateNo_SearchBox))).sendKeys(privateNo);
        return this;
    }

    public ItemReceivedRecordPage selectStore() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(selectStore))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement parentStore = wait.until(ExpectedConditions.presenceOfElementLocated(parentSelectStore));
        List<WebElement>childStore = parentStore.findElements(childSelectStore);
        childStore.get(3).click();
        return this ;

    }
    public ItemReceivedRecordPage selectReceiver() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(receiver))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement parent_Receiver = wait.until(ExpectedConditions.presenceOfElementLocated(parentReceiver));
        List<WebElement>childReceiver = parent_Receiver.findElements(childSelectStore);
        childReceiver.get(1).click();
        return this ;

    }
    public ItemReceivedRecordPage selectSupplier() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(supplier))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement parent_Supplier = wait.until(ExpectedConditions.presenceOfElementLocated(parentSupplier));
        List<WebElement>child_Supplier = parent_Supplier.findElements(childSelectStore);
        child_Supplier.get(1).click();
        return this ;

    }
    public ItemReceivedRecordPage enterTotalPriceWithTax(String totalPrice){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(filterToSelection)));
        Select select = new Select(driver.findElement(filterToSelection));
        select.selectByIndex(3);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(totalWithTax_searchBox))).sendKeys(totalPrice);
        return this ;

    }
    public ItemReceivedRecordPage selectRecordMaker() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(recordMaker))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement parent_RecordMaker = wait.until(ExpectedConditions.visibilityOf(driver.findElement(parentRecordMaker)));
        List<WebElement>child_RecordMaker = parent_RecordMaker.findElements(childRecordMaker);
        child_RecordMaker.get(6).click();
        return this ;
    }
    public ItemReceivedRecordPage clickOnPaginationSign() throws InterruptedException{
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(paginationSign))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
public boolean searchResultIsDisplayed(){
    wait = new WebDriverWait(driver,Duration.ofSeconds(20));
     return wait.until(ExpectedConditions.presenceOfElementLocated(parentSearchResult)).isDisplayed();
}
public String number(){
    wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    WebElement parentSearchResults = wait.until(ExpectedConditions.visibilityOf(driver.findElement(parentSearchResult)));
    List<WebElement>childSearchResults = parentSearchResults.findElements(childSearchResult);
    return childSearchResults.get(0).getText();
}
    public String receivedRecordNoText(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement parentSearchResults = wait.until(ExpectedConditions.visibilityOf(driver.findElement(parentSearchResult)));
        List<WebElement>childSearchResults = parentSearchResults.findElements(childSearchResult);
        return childSearchResults.get(1).getText();
    }
    public String recordMaker(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement parentSearchResults = wait.until(ExpectedConditions.visibilityOf(driver.findElement(parentSearchResult)));
        List<WebElement>childSearchResults = parentSearchResults.findElements(childSearchResult);
        System.out.println(childSearchResults.get(3).getText());
        return childSearchResults.get(3).getText();
    }
    public String invoiceNoText(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement parentSearchResults = wait.until(ExpectedConditions.visibilityOf(driver.findElement(parentSearchResult)));
        List<WebElement>childSearchResults = parentSearchResults.findElements(childSearchResult);
        System.out.println(childSearchResults.get(5).getText());
        return childSearchResults.get(5).getText();
    }
    public boolean totalWithTaxIsDisplayed(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement parentSearchResults = wait.until(ExpectedConditions.visibilityOf(driver.findElement(parentSearchResult)));
        List<WebElement>childSearchResults = parentSearchResults.findElements(childSearchResult);
        System.out.println(childSearchResults.get(6).getText());
        return childSearchResults.get(6).isDisplayed();
    }
    //--------------------------------------------------------------------------------------------------------------------//

    private By parentButtons = By.xpath("//*[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[8]");
    private By childButtons = By.tagName("a");
    private By editRecordButton = By.xpath("//*[contains(@class,\"btn btn-3d btn-success margin-left-20\") and @value=\"تعديل\"]");
    public ItemReceivedRecordPage clickOnEditButton()throws InterruptedException{
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement parentButtonEdit = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(parentButtons)));
        List<WebElement>childButtonEdit = parentButtonEdit.findElements(childButtons);
        childButtonEdit.get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public ItemReceivedRecordPage clickOnSaveEditButton()throws InterruptedException{
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(editRecordButton)).click();
        Thread.sleep(2500);
        return this ;
    }
    public boolean messageOfSuccess(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        System.out.println(driver.findElement(messaageSuccess).getText());
       return wait.until(ExpectedConditions.visibilityOfElementLocated(messaageSuccess)).isDisplayed();

    }
//----------------------------------------------------------------------------------------------------------//
   public ItemReceivedRecordPage clickOnDeleteButton() throws InterruptedException{
       wait = new WebDriverWait(driver,Duration.ofSeconds(20));
       WebElement parentButtonEdit = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(parentButtons)));
       List<WebElement>childButtonEdit = parentButtonEdit.findElements(childButtons);
       childButtonEdit.get(1).click();
       Thread.sleep(1000);
       Alert alert = driver.switchTo().alert();
       alert.accept();
       Thread.sleep(1000);
       return this ;
   }
//----------------------------------------------------------------------------------------------------
    private By selectStoreOnRecordPage = By.xpath("//*[@id=\"select2-StoreID-container\"]");
    private By parentSelectStoreOnRecordPage = By.xpath("//*[@id=\"select2-StoreID-results\"]");
    private By childSelectStoreOnRecordPage = By.tagName("li");
    private By errorMessage = By.xpath("//*[@id=\"btn-error-modal\"]");



    public ItemReceivedRecordPage clickOnRecordCopyButton() throws InterruptedException{
    wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    WebElement parentButtonEdit = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(parentButtons)));
    List<WebElement>childButtonEdit = parentButtonEdit.findElements(childButtons);
    childButtonEdit.get(2).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    return this ;
}
    public ItemReceivedRecordPage editTheRecord() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(selectStoreOnRecordPage)).click();
        WebElement parentButtonEdit = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(parentSelectStoreOnRecordPage)));
        List<WebElement> childButtonEdit = parentButtonEdit.findElements(childSelectStoreOnRecordPage);
        childButtonEdit.get(2).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this;
    }
    public ItemReceivedRecordPage editTheRecordWithIn() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(selectStoreOnRecordPage)).click();
        WebElement parentButtonEdit = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(parentSelectStoreOnRecordPage)));
        List<WebElement> childButtonEdit = parentButtonEdit.findElements(childSelectStoreOnRecordPage);
        childButtonEdit.get(10).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this;
    }

public void acceptErrorMessage(){
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.elementToBeClickable(errorMessage)).click();
}

}


