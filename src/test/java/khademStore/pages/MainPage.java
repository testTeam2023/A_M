package khademStore.pages;

import khademStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    By systemSettings = By.xpath("/html/body/nav[1]/div/ul/li[2]");
    By items = By.xpath("//a[@href=\"/KhademStores/Classification\"]");
    By itemsPage =By.xpath("//*[@id=\"content\"]/div[1]/div/div/h1/span");

    public MainPage load(){
        return this ;
    }
 public RestPages mainPageLoad(){
     try {
         driver.get(ConfigUtils.getInstance().getUrl());
     }
      catch (Exception e) {
         // Handle the case where the element is not found within the specified timeout
         throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues");
     }
   return new RestPages(driver);

 }
 public RestPages clickOnSystemSettingsButton(){
     driver.findElement(systemSettings).click();
     return new RestPages(driver);

 }
 public void itemsButton(){
        driver.findElement(items).click();
    }
 public String getItemsPageText(){
     String itemPageText =driver.findElement(itemsPage).getText();
     return itemPageText;
 }

}
