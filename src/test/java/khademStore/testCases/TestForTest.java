package khademStore.testCases;

import khademStore.basess.TestBase;
import khademStore.pages.RestPages;
import khademStore.utils.RandomArItems;
import org.testng.annotations.Test;

public class TestForTest extends TestBase {
    RestPages restPages ;
    @Test(priority = 1)
    public void openSettingPage() throws InterruptedException{
        restPages=new RestPages(driver);
        restPages.mainPageLoad().clickOnSystemSettingsButton()
                .navigateToSettingPage()
                .clickOnSaveButton()
                .clickOnSuccessMessageButton();
    }
    @Test(priority = 2)
    public void citiesPageTest() throws InterruptedException{
        restPages=new RestPages(driver);
        restPages.mainPageLoad().clickOnSystemSettingsButton()
                .navigateToCitiesPage()
                .enterCityName(RandomArItems.randomArData())
                .clickOnSaveButton()
                .clickOnSuccessMessageButton();
    }


}
