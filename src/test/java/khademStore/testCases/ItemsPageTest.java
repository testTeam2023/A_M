package khademStore.testCases;

import khademStore.basess.TestBase;
import khademStore.utils.RandomArItems;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemsPageTest extends TestBase {
khademStore.pages.ItemsPage itemsPage;
    @Test(priority = 1 , description = "Make a New Valid Item ")
    public void items_Added_Valid_Test()throws InterruptedException{
        itemsPage = new khademStore.pages.ItemsPage(driver);
        itemsPage
             .navigateToItemsPage()
             .enterItemName(RandomArItems.randomArData())
             .chooseClassificationOfItem("بيانات")
             .l_nameInput()
             .itemPrice()
             .chooseSupplier()
             .setItemType()
             .elec_Qty("100","1000")
             .someChoices()
             .setUnits()
             .addStockAndStores("2","1","3").clickMessageButton();
    }
    @Test(priority = 2, description = "Valid search without Filters")
    public void search_Valid_Test() throws InterruptedException {
        itemsPage = new khademStore.pages.ItemsPage(driver);
         itemsPage.navigateToItemsPage().clickOnSearchTab().clickOnSearchTab().clickOnsearch_button();
         boolean condition = itemsPage.searchResultIsDisplayed();
        Assert.assertTrue(condition);
    }
    /*
    @Test(priority = 2 , description = "Search using an item number filter")
    public void searchByItemNumber() throws InterruptedException {
     itemsPage=new khademStore.pages.ItemsPage(driver);
     itemsPage.navigateToItemsPage()
             .clickOnSearchTab()
             .clickOnSearchTab()
             .searchByItemNumber("10")
             .clickOnsearch_button();
        boolean condition = itemsPage.searchResultIsDisplayed();
        Assert.assertTrue(condition);
    }
    @Test(priority = 3 , description = "Search using an item Code filter")
    public void searchByItemCode() throws InterruptedException {
        itemsPage = new khademStore.pages.ItemsPage(driver);
        itemsPage.navigateToItemsPage().clickOnSearchTab().clickOnSearchTab().searchByItemCode("10").clickOnsearch_button();
        boolean condition = itemsPage.searchResultIsDisplayed();
        Assert.assertTrue(condition);
    }
    @Test(priority = 4, description = "Search using an item Name filter")
    public void searchByItemName() throws InterruptedException {
        itemsPage = new khademStore.pages.ItemsPage(driver);
            itemsPage.navigateToItemsPage().clickOnSearchTab().clickOnSearchTab().searchByItemName("a").clickOnsearch_button();
        boolean condition = itemsPage.searchResultIsDisplayed();
        Assert.assertTrue(condition);
    }

    @Test(priority = 5 , description = "Search using an item type 'مستديم' filter")
    public void searchByItemType() throws InterruptedException {
        itemsPage = new khademStore.pages.ItemsPage(driver);
        itemsPage.navigateToItemsPage().clickOnSearchTab().clickOnSearchTab().searchByItemType().clickOnsearch_button();
        boolean condition = itemsPage.searchResultIsDisplayed();
        Assert.assertTrue(condition);
}
    @Test(priority = 6 , description = "Search using an item has serial filter")
    public void searchByItemHasSerial() throws InterruptedException {
        itemsPage = new khademStore.pages.ItemsPage(driver);
        itemsPage.navigateToItemsPage()
                .clickOnSearchTab().clickOnSearchTab()
                .searchByItemHasSerial()
                .clickOnsearch_button();
        boolean condition = itemsPage.searchResultIsDisplayed();
        Assert.assertTrue(condition);
    }

     */
    @Test(priority = 3 , description = "Click on edit button " )
    public void Edit_Button_Valid_Test()throws InterruptedException{
        itemsPage = new khademStore.pages.ItemsPage(driver);
        itemsPage.navigateToItemsPage()
                .clickOnSearchTab().clickOnSearchTab()
                .clickOnsearch_button()
                .clickOnEditButton()
                .editItemAdded("2");
        boolean editMessageIsDisplayed=itemsPage.editMessageSuccess();
        Assert.assertTrue(editMessageIsDisplayed);
    }
    @Test(priority = 4 , description = "Delete item added", dependsOnMethods = "items_Added_Valid_Test")
    public void delete_Item_Valid_Test() throws InterruptedException{
        itemsPage = new khademStore.pages.ItemsPage(driver);
        itemsPage
                .navigateToItemsPage()
                .clickOnSearchTab().clickOnSearchTab()
                .clickOnsearch_button()
                .clickOnDeleteButton();
    }
    /*
    @Test(priority = 9 , description = "Delete item has record")
    public void delete_Item_Has_Record() throws InterruptedException {
        itemsPage = new khademStore.pages.ItemsPage(driver);
        itemsPage
                .navigateToItemsPage()
                .clickOnSearchTab().clickOnSearchTab()
                .clickOnsearch_button().clickOnDeleteButtonHasRecord();
    }
*/
}
