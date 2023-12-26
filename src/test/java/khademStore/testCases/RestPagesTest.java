package khademStore.testCases;

import io.qameta.allure.Feature;
import khademStore.basess.TestBase;
import khademStore.pages.MainPage;
import khademStore.pages.RestPages;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("OpenPages")
public class RestPagesTest extends TestBase {

    RestPages restPages ;
    /*
    @Test(priority = 1)
    public void settingPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
       boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToSettingPage().settingPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority = 2)
    public void citiesPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToCitiesPage().citiesPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority = 3)

    public void unitsPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToUnitPage().unitPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority = 4)

    public void banksPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToBanksPage().banksPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority = 5)

    public void lkCategoryPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToLkCategoryPage().lkCategoryPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority =6)

    public void supplierWorkAreaPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToSuppliersWorkAreaPage().supplierWorkAreaPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority =7)

    public void suppliersPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToSuppliersPage().suppliersPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority = 8)

    public void managementPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToManagementPage().ManagementPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority = 9)

    public void employeesPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToEmployeesPage().employeesPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority =10)

    public void storesPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToStoresPage().storesPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority = 11)

    public void storesCuratorPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToStoresCuratorPage().storesCuratorPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority =12)

    public void classificationsPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToClassificationsPage().classificationsPageIsDisplayed();
        Assert.assertTrue(actual);
    }
    @Test(priority = 13)

    public void financialYearPageValidTest() throws InterruptedException{
        restPages=new RestPages(driver);
        boolean actual = restPages.mainPageLoad().clickOnSystemSettingsButton().navigateToFinancialYearPage().financialYearPageIsDisplayed();
        Assert.assertTrue(actual);
    }

     */
    @Test
   public void pagesValidTest ()throws InterruptedException {
         restPages = new RestPages(driver);
         restPages.mainPageLoad().clickOnSystemSettingsButton()
                 .navigateToSettingPage()
                 .navigateToCitiesPage()
                 .navigateToUnitPage()
                 .navigateToBanksPage()
                 .navigateToLkCategoryPage()
                 .navigateToSuppliersWorkAreaPage()
                 .navigateToSuppliersPage()
                 .navigateToManagementPage()
                 .navigateToStoresPage()
                 .navigateToStoresCuratorPage()
                 .navigateToClassificationsPage()
                 .navigateToItemsPage()
                 .navigateToFinancialYearPage()
                 .clickOnMainOperationsButton().navigateToItemsReceivedRecordPage();
         boolean actualForSettings = restPages.settingPageIsDisplayed();
         Assert.assertTrue(actualForSettings);
         boolean actualForCities = restPages.citiesPageIsDisplayed();
         Assert.assertTrue(actualForCities);
         boolean actualForUnits = restPages.unitPageIsDisplayed();
         Assert.assertTrue(actualForUnits);
         boolean actualForBanks = restPages.banksPageIsDisplayed();
         Assert.assertTrue(actualForBanks);
         boolean actualForLKCategory = restPages.lkCategoryPageIsDisplayed();
         Assert.assertTrue(actualForLKCategory);
         boolean actualForSuppliersWorkArea = restPages.supplierWorkAreaPageIsDisplayed();
         Assert.assertTrue(actualForSuppliersWorkArea);
         boolean actualForSuppliers = restPages.suppliersPageIsDisplayed();
         Assert.assertTrue(actualForSuppliers);
         boolean actualForManagement = restPages.managementPageIsDisplayed();
         Assert.assertTrue(actualForManagement);
         boolean actualForStores = restPages.storesPageIsDisplayed();
         Assert.assertTrue(actualForStores);
         boolean actualForStoresCurator = restPages.storesCuratorPageIsDisplayed();
         Assert.assertTrue(actualForStoresCurator);
         boolean actualForClassifications = restPages.classificationsPageIsDisplayed();
         Assert.assertTrue(actualForClassifications);
         boolean actualForItems = restPages.ItemsPageIsDisplayed();
         Assert.assertTrue(actualForItems);
         boolean actualForFinancialYear = restPages.financialYearPageIsDisplayed();
         Assert.assertTrue(actualForFinancialYear);
         boolean actualForItemsReceivedRecordPage = restPages.itemsReceivedRecordPageIsDisplayed();
         Assert.assertTrue(actualForItemsReceivedRecordPage);
    }
         @Test
         public void reportValidTest ()throws InterruptedException{
              restPages=new RestPages(driver);
              restPages.mainPageLoad()
                .clickOnReporsButton()
                .navigateToMainOperationReportPage()
                .clickOnReceivedRecordReport()
                .openReceivedRecordReport()
                .navigateToMainOperationReportPage().clickOnStatisticalReceivedReport().chooseSupplier().chooseRecordClassification()
                .openStatisticalReceivedReport();

    }




}
