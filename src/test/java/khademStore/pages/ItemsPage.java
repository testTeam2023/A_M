package khademStore.pages;
import khademStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ItemsPage {
    private WebDriver driver;
    private WebDriverWait wait ;
   // Locate the itemPage elements
    private By itemName = By.xpath("//*[@id=\"Name\" and @name = \"Name\"]");
    private   By itemClassificationButton = By.xpath("//a[contains(text(), 'إختر فئة الصنف')]");
    private  By classificationModalSearchBox = By.id("ItemName");
    private   By classificationModalSearchButton = By.xpath("//input[@value=\"بحث\"]");
    private  By classificationViews = By.xpath("//*[@id=\"25\"]");
    private   By itemCode = By.name("Code");//TestCase getText
    private  By itemLname = By.name("Name_E");
    private By itemPrice = By.name("Price");
    private  By supplierName = By.xpath("//*[@id=\"select2-SUPP_NO-container\"]");
    private  By suppName = By.xpath("//li[contains(text(), 'تيست')]");
    private By parentSupplierName = By.xpath("//*[@id=\"select2-SUPP_NO-results\"]");
    private By childSupplierName = By.tagName("li");

    private   By itemType = By.id("ItemType");
    private By maxQty = By.xpath("//*[@id=\"MaxQntyForRequest\"]");
    private   By maxQtyPeryear = By.xpath("//*[@id=\"MaxQntyFinacialYear\"]");
    private   By itemhasWarranty = By.xpath("//*[@id=\"Iswarranty\"]");
    private By itemhasEndDate = By.xpath("//*[@id=\"HasEndDate\"]");
    private   By itemUnit = By.xpath("//*[@id=\"UnitID_\"]");
    private  By addUnit = By.xpath("//*[@id=\"btnAddNewItemItemsUnits\"]");
    private  By unitNameIsDisplay = By.id("unit_name_0");
    private By unitDelete = By.xpath("//a[contains(@class,'btn-danger')]");
    private  By storeN1Selection = By.xpath("//*[@id=\"divItemDtlList\"]/table/tbody/tr[1]/td[1]/input");
    private  By storeN2Selection = By.xpath("//*[@id=\"divItemDtlList\"]/table/tbody/tr[2]/td[1]/input");
    private  By storeN3Selection = By.xpath("//*[@id=\"divItemDtlList\"]/table/tbody/tr[3]/td[1]/input");
    private  By openStockForStore1 = By.xpath("//*[@id=\"divItemDtlList\"]/table/tbody/tr[1]/td[7]/input[1]");
    private  By openStockForStore2 = By.xpath("//*[@id=\"divItemDtlList\"]/table/tbody/tr[2]/td[7]/input[1]");
    private  By openStockForStore3 = By.xpath("//*[@id=\"divItemDtlList\"]/table/tbody/tr[3]/td[7]/input[1]");
    private   By save = By.xpath("//input[@value=\"حفظ\"]");
    private   By messageSuccess = By.xpath("//*[@id=\"div-success-modal\"]/div/div");
    private  By messageSuccessButton = By.cssSelector("#btn-ok-modal");
    private By editButtonIsDisplay = By.xpath("//*[@id=\"btnSave\"]");
    private By search_TabLink = By.xpath("//*[@id=\"AnchorfirstTab\"]");
    private By  itemNumber_searchBox = By.xpath("//*[@id=\"SearchControl_Criteria_List_0__Value\"]");
    private By  itemNumber_searchBox_SelectFilter = By.xpath("//*[@id=\"SearchControl_Criteria_List_0__SelectedComparator\"]");
    private By  itemCode_searchBox = By.xpath("//*[@id=\"SearchControl_Criteria_List_1__Value\"]");
    private By  itemCode_searchBox_filter = By.xpath("//*[@id=\"SearchControl_Criteria_List_1__SelectedComparator\"]");
    private By  itemName_searchBox = By.xpath("//*[@id=\"SearchControl_Criteria_List_2__Value\"]");
    private By  itemName_searchBox_filter = By.xpath("//*[@id=\"SearchControl_Criteria_List_2__SelectedComparator\"]");

    private By  itemType_searchBox = By.xpath("//*[@id=\"select2-SearchControl_Criteria_List_4__Value-container\"]");
    //
    private By  parentItemType_searchBox = By.xpath("//*[@id=\"select2-SearchControl_Criteria_List_4__Value-results\"]");
    private By  childItemType_searchBox = By.tagName("li");

    private By itemHasSerialSearchBox = By.xpath("//*[@id=\"SearchControl_Criteria_List_6__SelectedComparator\"]");
    private By selectItemType = By.xpath("//*[@id=\"select2-SearchControl_Criteria_List_4__Value-result-3ov0-1\"]");

    private By  itemClassification_searchBox = By.xpath("//*[@id=\"select2-SearchControl_Criteria_List_5__Value-container\"]");
    private By Search_button = By.xpath("//div//input[@value=\"بـحـث\"]");
    private By parentSearchResultTable= By.xpath("//*[@id=\"tblDataTableClient\"]/tbody");
    private By childSearchResults =By.tagName("tr");
    //
    private By parenFilterSearchResult = By.xpath("//*[@id=\"tblDataTableClient\"]/tbody/tr[1]");
    private By childFilterSearchResult = By.tagName("td");
    //
    private By parentButtons =By.xpath("//*[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[7]");
    private By childButtons =By.tagName("a");
    private By clickOnErrorButton= By.xpath("//*[@id=\"btn-error-modal\"]");
    private By clickOnEditButton =By.xpath("//*[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[7]/a[1]");
    private By clickOnDeleteButton =By.xpath("//*[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[7]/a[2]");
    private By deleteMessageText= By.xpath("//*[@id=\"div-success-modal\"]/div/div/div[3]");
    private By deleteButtonHasRecord= By.xpath("//*[contains(@onclick,'Delete/7825')]");
    private By pagination= By.xpath("//*[@id=\"datatables_paginate\"]/div/div/input[6]");
    private By parentPagination= By.xpath("//*[@id=\"datatables_paginate\"]/div/div");
    private By childPagination= By.tagName("input");
    private By modalSuccess = By.cssSelector("#div-success-modal > div > div");
    private By editTextIsDisplay= By.xpath("//*[contains(@value,\"تعديل\")]");

    public ItemsPage(WebDriver driver){
        this.driver=driver;
    }
    //Add new Item
   public ItemsPage navigateToItemsPage() throws InterruptedException {
       int maxAttempt = 2;
       int attempt = 0;
       while (attempt < maxAttempt) {
        try {
            driver.get(ConfigUtils.getInstance().getItemsPageUrl());
            Thread.sleep(3000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return this;
        }
        catch (Exception e) {
            attempt++;
        }
       }
            throw new RuntimeException("Page load timed out.");
        }


  public ItemsPage enterItemName(String randomItemName) throws InterruptedException{
   wait = new WebDriverWait(driver,Duration.ofSeconds(20));
   Actions actions = new Actions(driver);
   actions.moveToElement(driver.findElement(itemName)).perform();
        wait
            .until(ExpectedConditions.elementToBeClickable(driver.findElement(itemName)))
            .sendKeys(randomItemName);
      return this;
  }
  public ItemsPage chooseClassificationOfItem(String classificationSearchBox)  {
   wait = new WebDriverWait(driver,Duration.ofSeconds(10));
   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(itemClassificationButton))).click();
   wait.until(ExpectedConditions.visibilityOf(driver.findElement(classificationModalSearchBox))).sendKeys(classificationSearchBox);
   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(classificationModalSearchButton))).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(classificationViews))).click();
      return this;
  }
   public boolean itemCodeVisible(){
      return driver.findElement(itemCode).isDisplayed();
  }

  public ItemsPage l_nameInput(){
     String getItemNameText = driver.findElement(itemName).getText();
       driver.findElement(itemLname).sendKeys(getItemNameText);
     return this;
 }
  public ItemsPage itemPrice()  {
      Random random = new Random();
      int randomPrices = random.nextInt(10001)+10 ;
      String price = String.valueOf(randomPrices);
     driver.findElement(itemPrice).sendKeys(price);
    return this;
}
 public ItemsPage chooseSupplier() throws InterruptedException {
     wait = new WebDriverWait(driver, Duration.ofSeconds(10));

     // Retry mechanism
     int maxRetries = 3;
     int retryCount = 0;

     while (retryCount < maxRetries) {
         try {
             // Attempt to click the supplier element
             wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(supplierName))).click();

             // Obtain a fresh reference to the parent element
             WebElement parentSupp = wait.until(ExpectedConditions.presenceOfElementLocated(parentSupplierName));
             List<WebElement> childSupp = parentSupp.findElements(childSupplierName);
             childSupp.get(1).click();
             // Exit the loop if the operation is successful
             break;
         } catch (StaleElementReferenceException e) {
             // Log or print the exception
             System.out.println("StaleElementReferenceException: Retrying...");
             retryCount++;
         }
     }
     return this;
}
   public ItemsPage setItemType() {
       wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       Select select = new Select(wait.until(ExpectedConditions.visibilityOf(driver.findElement(itemType))));
       select.selectByIndex(1);
  return this;
}
  public ItemsPage elec_Qty(String maxQnty,String maxQntyPeryear ){
      wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(maxQty)).clear();
      wait.until(ExpectedConditions.elementToBeClickable(maxQty)).sendKeys(maxQnty);
      wait.until(ExpectedConditions.elementToBeClickable(maxQtyPeryear)).clear();
      wait.until(ExpectedConditions.elementToBeClickable(maxQtyPeryear)).sendKeys(maxQntyPeryear);
    return this;
}
  public ItemsPage someChoices(){
      wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(itemhasWarranty)).click();
      return this;
}
  public ItemsPage setUnits()  {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Select select = new Select(driver.findElement(itemUnit));
        select.selectByIndex(10);
      wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(addUnit))).click();
      Actions actions = new Actions(driver);
      actions.scrollByAmount(0,700);

    return this ;

}
  public ItemsPage addStockAndStores(String store1OpenStock  , String store2OpenStock,String store3OpenStock ) throws InterruptedException {
      wait = new WebDriverWait(driver,Duration.ofSeconds(15));
      wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(storeN1Selection))).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(openStockForStore1))).clear();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(openStockForStore1))).sendKeys(store1OpenStock);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(storeN2Selection))).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(openStockForStore2))).clear();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      wait.until(ExpectedConditions.visibilityOf( driver.findElement(openStockForStore2))).sendKeys(store2OpenStock );
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(storeN3Selection))).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      wait.until(ExpectedConditions.visibilityOf( driver.findElement(openStockForStore3))).clear();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      wait.until(ExpectedConditions.visibilityOf( driver.findElement(openStockForStore3))).sendKeys(store3OpenStock);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      try {

          wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(save))).click();
          Thread.sleep(8000);
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          Alert alert = driver.switchTo().alert();
          alert.accept();
          Thread.sleep(1000);
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          setUnits();
          wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(save))).click();
          Thread.sleep(8000);
      }
      catch (Exception e){
          System.out.println(e);
      }
    return this ;
      }
  public String saveation(){
      wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      return wait.until(ExpectedConditions.visibilityOf(driver.findElement(messageSuccess))).getText();
  }
  public String editTextIsDisplayed(){
        return driver.findElement(editTextIsDisplay).getAttribute("value");
  }

   public ItemsPage clickMessageButton() throws InterruptedException {
       wait = new WebDriverWait(driver,Duration.ofSeconds(15));
           try {
               wait.until(ExpectedConditions.visibilityOfElementLocated(modalSuccess));
               wait.until(ExpectedConditions.presenceOfElementLocated(modalSuccess));
               if( driver.findElement(modalSuccess).isDisplayed()) {
               wait.until(ExpectedConditions.visibilityOfElementLocated(messageSuccessButton));
               Actions actions = new Actions(driver);
               actions.scrollToElement(driver.findElement(messageSuccessButton)).perform();
               actions.moveToElement(driver.findElement(messageSuccessButton)).click().build().perform();
           }
           }
               catch (Exception e) {
                   System.out.println(e.getMessage());
           }
      return this;

}
    public ItemsPage clickOutsideTheModal () {
        Actions actions = new Actions(driver);
        actions.moveByOffset(-80, -80).click().build().perform();
        return this ;
    }
   public void setUnitDelete(){
      driver.findElement(unitDelete).sendKeys();
 }


   // Search Section
    public ItemsPage clickOnSearchTab() throws InterruptedException {
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(search_TabLink))).click();
        Thread.sleep(3000);
        return this;
    }
    public ItemsPage clickOnsearch_button() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                Actions actions = new Actions(driver);
                actions.scrollToElement(driver.findElement(Search_button));
                actions.moveToElement(driver.findElement(Search_button)).click().build().perform();
                Thread.sleep(2500);
                js.executeScript("window.scrollBy(0,900)");
            } catch (TimeoutException | StaleElementReferenceException | ElementClickInterceptedException e) {
               driver.navigate().refresh();
               clickOnSearchTab();
                clickOnSearchTab();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(Search_button)).click().build().perform();                Thread.sleep(2500);
                js.executeScript("window.scrollBy(0,900)");
        }
        return this;
    }
    public int numberOfsearchResult(){
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement parentTable = wait.until(ExpectedConditions.presenceOfElementLocated(parentSearchResultTable));
        List<WebElement> childSearchResult = parentTable.findElements(childSearchResults);
        int numberOfTableRows = childSearchResult.size();
        System.out.println(numberOfTableRows);
        return numberOfTableRows;

    }
    public boolean searchResultIsDisplayed() {
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
       return wait.until(ExpectedConditions.visibilityOf(driver.findElement(parentSearchResultTable))).isDisplayed();

    }

    public ItemsPage searchByItemNumber(String itemNumber){
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        Select select = new Select(driver.findElement(itemNumber_searchBox_SelectFilter));
        select.selectByIndex(3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(itemNumber_searchBox))).sendKeys(itemNumber);
        return this;
    }
    public ItemsPage searchByItemCode(String itemCode){
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        Select select = new Select(driver.findElement(itemCode_searchBox_filter));
        select.selectByIndex(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemCode_searchBox)).sendKeys(itemCode);
        return this;

    }
    public ItemsPage searchByItemName(String itemName){
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        //Select select = new Select(driver.findElement(itemName_searchBox_filter));
       // select.selectByIndex(1);
        wait.until(ExpectedConditions.elementToBeClickable(itemName_searchBox)).sendKeys(itemName);
        return this;

    }
    public ItemsPage searchByItemType(){
        wait=new WebDriverWait(driver,Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(itemType_searchBox))).click();
        WebElement parenItemTypeSelection = wait.until(ExpectedConditions.presenceOfElementLocated(parentItemType_searchBox));
        List<WebElement>childItemTypeSelection= parenItemTypeSelection.findElements(childItemType_searchBox);
        childItemTypeSelection.get(1).click();
        return this;
    }
    public ItemsPage searchByItemHasSerial(){
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        Select select = new Select(driver.findElement(itemHasSerialSearchBox));
        select.selectByIndex(2);
        return this;
    }
   public String filterSearchResult(){
        WebElement parentTableOfContent = driver.findElement(parentSearchResultTable);
        List<WebElement> childTableOfContent = parentTableOfContent.findElements(childFilterSearchResult);
       String rowTextResult= childTableOfContent.get(0).getText().trim();
       System.out.println(rowTextResult);
      return rowTextResult;
   }
    //Edit Section

    public ItemsPage clickOnEditButton()throws InterruptedException{
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement parentEditButton = wait.until(ExpectedConditions.presenceOfElementLocated(parentButtons));
        List<WebElement> childEditButton = parentEditButton.findElements(childButtons);
        childEditButton.get(0).click();
        Thread.sleep(2500);
        return this;
    }
    public ItemsPage scrollDown() throws InterruptedException{
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0, 700);");
        Thread.sleep(2000);
        return this;

    }
    public ItemsPage editStock(String editStock){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(openStockForStore2)).clear();
        driver.findElement(openStockForStore2).sendKeys(editStock);
        return this ;
    }
    public ItemsPage setClickOnEditButtn() throws InterruptedException{
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(editButtonIsDisplay))).click();
        Thread.sleep(5000);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalSuccess)).isDisplayed();
            if(driver.findElement(modalSuccess).isDisplayed()) {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(messageSuccessButton)).click();
                } catch (Exception s) {
                    System.out.println(s.getMessage());
                }
            }
        }
        catch (Exception e){
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(clickOnErrorButton)));
            Thread.sleep(1000);
            Actions actions1 =new Actions(driver);
            actions1.scrollToElement(driver.findElement(storeN3Selection));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(storeN3Selection))).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(editButtonIsDisplay))).click();
            Thread.sleep(5000);
            if(driver.findElement(modalSuccess).isDisplayed()) {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(messageSuccessButton)).click();
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        }
        return this;
    }

   /* public ItemsPage editItemAdded(String editStock) throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(openStockForStore2));
        Thread.sleep(2000);

         wait.until(ExpectedConditions.visibilityOfElementLocated(openStockForStore2)).clear();
         driver.findElement(openStockForStore2).sendKeys(editStock);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(editButtonIsDisplay))).click();
        Thread.sleep(5000);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalSuccess)).isDisplayed();
            if(driver.findElement(modalSuccess).isDisplayed()) {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(messageSuccessButton)).click();
                } catch (Exception s) {
                    System.out.println(s.getMessage());
                    }
                }
            }

        catch (Exception e){
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(clickOnErrorButton)));
            Thread.sleep(1000);
            Actions actions1 =new Actions(driver);
            actions1.scrollToElement(driver.findElement(storeN3Selection));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(storeN3Selection))).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(editButtonIsDisplay))).click();
            Thread.sleep(5000);
            if(driver.findElement(modalSuccess).isDisplayed()) {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(messageSuccessButton)).click();
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        }
           // try {
             //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
           //     Actions actions2 = new Actions(driver);
             //   actions2.scrollToElement(driver.findElement(messageSuccessButton)).perform();
             //   actions2.moveToElement(driver.findElement(messageSuccessButton)).click().build().perform();
           // }
           // catch (Exception ee){
           //     Actions actions3 = new Actions(driver);
             //   actions3.moveByOffset(-80, -80).click().build().perform();
           // wait.until(ExpectedConditions.elementToBeClickable(messageSuccessButton)).click();
           // Thread.sleep(1000);
           // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    //    }}
        return this;
       }
    */

    public String setEditButtonIsDisplay(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(editButtonIsDisplay)).getText();
    }
    public boolean editMessageSuccess() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(messageSuccess)).isDisplayed();
    }
    // Delete Section
    public ItemsPage clickOnDeleteButton()throws InterruptedException{
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickOnDeleteButton)).click();
        Thread.sleep(1500);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(1000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // Try to handle a potential second alert
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();
            Thread.sleep(1000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        } catch (NoAlertPresentException e) {
            // No second alert present, do nothing or log a message
        }

        return this;
    }
    public boolean deleteMessageSuccess(){

        return driver.findElement(deleteMessageText).isDisplayed();
    }
    public ItemsPage clickOnDeleteButtonHasRecord()throws InterruptedException{
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement parentPaginationButton = wait.until(ExpectedConditions.presenceOfElementLocated(parentPagination));
        List<WebElement> childPaginationButton = parentPaginationButton.findElements(childPagination);
        childPaginationButton.get(6).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement parentEditButton = wait.until(ExpectedConditions.presenceOfElementLocated(parentButtons));
        List<WebElement> childEditButton = parentEditButton.findElements(childButtons);
        childEditButton.get(1).click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Alert alert1= driver.switchTo().alert();
        alert1.accept();
        return this;
    }
    public void firstSearchResult (){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement parentFirstSearch = wait.until(ExpectedConditions.presenceOfElementLocated(parenFilterSearchResult));
        List<WebElement>childFirstSearch = parentFirstSearch.findElements(childFilterSearchResult);
        childFirstSearch.get(0).getText();
    }


    }
