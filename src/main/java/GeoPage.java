import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GeoPage extends ModelPage {
    private static By pageTab = By.className("n-product-tabs__item_name_geo");

    public GeoPage(WebDriver driver) {
        super(driver, pageTab);
    }

    public boolean checkMap() {
        return existsElement(By.className("n-geo__map"))
                && existsElement(By.className("n-geo__panel-set"));
    }
}
