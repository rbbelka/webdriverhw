import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OffersPage extends ModelPage {

    private static By pageTab = By.className("n-product-tabs__item_name_offers");

    public OffersPage(WebDriver driver) {
        super(driver, pageTab);
    }

    public boolean checkOffers() {
        return true;
    }

    public boolean checkSorting() {
        return true;
    }
}
