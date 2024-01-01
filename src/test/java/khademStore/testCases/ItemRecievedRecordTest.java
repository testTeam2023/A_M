package khademStore.testCases;

import khademStore.basess.TestBase;
import khademStore.pages.ItemReceivedRecordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemRecievedRecordTest extends TestBase {
    ItemReceivedRecordPage itemReceivedRecord ;
   /* @Test(description = " item Received Record for Multiple items" , priority = 1)
    public void item_Received_Record_Valid_Test_ForMultipleItem() throws InterruptedException{
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord
                .navigateToTheItemReceivedRecordPage()
                .enterInvoiceNumber("125")
                .selectSupplierName()
                .enterAttachment("125kj")
                .selectMultipleItems().scrollDown()
                .clickOnSaveButton().clickOnmessageSuccessbutton();
    }
    */
   @Test(description = "Search Valid Test", priority = 1)
   public void search_Valid_Test() throws InterruptedException {
       itemReceivedRecord=new ItemReceivedRecordPage(driver);
       itemReceivedRecord.navigateToTheItemReceivedRecordPage()
               .clickOnSearchTab().clickOnSearchTab()
               .clickOnSearchButton();
       boolean searchResult = itemReceivedRecord.searchResultIsDisplayed();
       Assert.assertTrue(searchResult);
   }
    @Test(description = " item_Received_Record_Valid_Test" , priority = 2)
    public void itemsReceivedRecordValidTest() throws InterruptedException{
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .enterInvoiceNumber("102123")
                .selectSupplierName()
                .enterAttachment("1250MNB")
                .selectAnItemFromItemList()
                .enterQuantity()
                .enterPrice()
                .clickOnAddItemButton()
                .scrollDown()
                .clickOnSaveButton()
                .clickOnmessageSuccessbutton();
        double actualResults = itemReceivedRecord.totalPriceWithTaxes();
        double expectedResults = itemReceivedRecord.totalPrice();
        Assert.assertEquals(actualResults,expectedResults);
    }
    @Test(description = "Edit record valid test ",priority = 3)
    public void Edit_Record_valid_Test() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab()
                .clickOnSearchButton()
                .clickOnEditButton()
                .setReceiverName("62")
                .clickOnSaveEditButton()
                .clickOnmessageSuccessbutton();
    }
    @Test(description = "Copy the record valid test ",priority =4 )
    public void copy_The_Record_valid_Test() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab()
                .clickOnSearchButton().clickOnSearchTab()
                .clickOnRecordCopyButton()
                .editTheRecord()
                .enterAttachment("10")
                .clickOnSaveButton()
                .clickOnmessageSuccessbutton();
    }
    @Test(description = "Delete record valid test ",priority = 5)
    public void Delete_Record_valid_Test() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab()
                .clickOnSearchButton().clickOnSearchTab()
                .clickOnDeleteButton()
                .clickOnmessageSuccessbutton();
    }

    /*
    @Test(description = " item Received Record validation test" , priority = 3)
    public void item_Received_Record_Valid_Test_For_Validations() throws InterruptedException{
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord
                .navigateToTheItemReceivedRecordPage()
                .clickOnSaveButton();
        String expectedResult = "مطلوب";
        String invoiceNumberValidationText = itemReceivedRecord.invoiceNumberValidationText();
        Assert.assertEquals(invoiceNumberValidationText,expectedResult);
        String attachmentValidationText = itemReceivedRecord.attachmentErrorValidationText();
        Assert.assertEquals(attachmentValidationText,expectedResult);
        String supplierNameValidationText = itemReceivedRecord.supplierNameErrorValidationText();
        Assert.assertEquals(supplierNameValidationText,expectedResult);
    }
*/
    /*
    @Test(description = " item_Received_Record_Valid_Test" , priority = 4 )
    public void item_Received_Record_Enter_Item_Validation() throws InterruptedException{
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord
                .navigateToTheItemReceivedRecordPage()
                .enterInvoiceNumber("125")
                .selectSupplierName()
                .enterAttachment("125kj")
                .scrollDown()
                .clickOnSaveButton();
        String actualResult = "يجب إضافة صنف واحد على الأقل";
        String expectedResult = itemReceivedRecord.enterItemValidationText();
        Assert.assertEquals(actualResult,expectedResult);
    }

     */

  /*  @Test(description = "Pagination test",priority = 6)
    public void pagination_Test() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().clickOnSearchButton().clickOnPaginationSign();
        boolean searchResult = itemReceivedRecord.searchResultIsDisplayed();
        Assert.assertTrue(searchResult);

    }

   */
    /*
    @Test(description = "Search with invoice number " , priority = 7)
    public void search_With_Invoice_Number() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().searchWithInvoiceNumber("125")
                .clickOnSearchButton();
        String actual=itemReceivedRecord.invoiceNoText();
        Assert.assertEquals(actual,"125");
    }
    @Test(description = "Search with selection of financial year " ,priority =8)
    public void search_With_Selection_Of_Financial_year() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().selectFinancialYear()
                .clickOnSearchButton();
        boolean searchResult = itemReceivedRecord.searchResultIsDisplayed();
        Assert.assertTrue(searchResult);
    }
    @Test(description = "Search with number of the record ",priority = 9)
    public void search_With_The_Number_Of_The_Record() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().searchWithRecordNumber("10")
                .clickOnSearchButton();
        boolean searchResult = itemReceivedRecord.searchResultIsDisplayed();
        Assert.assertTrue(searchResult);
    }
    @Test(description = "Search with the received record number ",priority =10)
    public void search_With_The_Number_Of_The_Received_Record() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().searchWithreceivedRecordNumber("10")
                .clickOnSearchButton();
        boolean searchResult = itemReceivedRecord.searchResultIsDisplayed();
        Assert.assertTrue(searchResult);
    }
    @Test(description = "Search with the private number ",priority = 11)
    public void search_With_The_Private_Number() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().enterPrivateNumber("1")
                .clickOnSearchButton();
        boolean searchResult = itemReceivedRecord.searchResultIsDisplayed();
        Assert.assertTrue(searchResult);
    }

    //enterPrivateNumber
    @Test(description = "Search with the Store name ",priority = 12)
    public void search_With_The_Store_Name() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().selectStore()
                .clickOnSearchButton();
        boolean searchResult = itemReceivedRecord.searchResultIsDisplayed();
        Assert.assertTrue(searchResult);
    }
    @Test(description = "Search with the receiver name ",priority = 13)
    public void search_With_The_Receiver_Name() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().selectReceiver()
                .clickOnSearchButton();
        boolean searchResult = itemReceivedRecord.searchResultIsDisplayed();
        Assert.assertTrue(searchResult);
    }
    @Test(description = "Search with the supplier name ",priority = 14)
    public void search_With_The_Supplier_Name() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().selectSupplier()
                .clickOnSearchButton();
        boolean searchResult = itemReceivedRecord.searchResultIsDisplayed();
        Assert.assertTrue(searchResult);
    }
    @Test(description = "Search with the total price with tax ",priority = 15)
    public void search_With_The_Total_Price_With_Tax() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().enterTotalPriceWithTax("300")
                .clickOnSearchButton();
        boolean searchResult = itemReceivedRecord.totalWithTaxIsDisplayed();
        Assert.assertTrue(searchResult);

    }
    @Test(description = "Search with the record maker name ",priority = 16)
    public void search_With_The_Record_Maker_name() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab().clickOnSearchTab().selectRecordMaker()
                .clickOnSearchButton();
        String searchResult = itemReceivedRecord.recordMaker();
        String expected = "asos1";
        Assert.assertEquals(searchResult,expected);

    }

     */

    /*
    @Test(description = "Copy the record Invalid test ",priority = 19)
    public void copy_The_Record_Invalid_Test() throws InterruptedException {
        itemReceivedRecord=new ItemReceivedRecordPage(driver);
        itemReceivedRecord.navigateToTheItemReceivedRecordPage()
                .clickOnSearchTab()
                .clickOnSearchButton().clickOnSearchTab()
                .clickOnRecordCopyButton()
                .editTheRecordWithInvalid()
                .enterAttachment("10")
                .clickOnSaveButton()
                .acceptErrorMessage();
    }

     */





















}
