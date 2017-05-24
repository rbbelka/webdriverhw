import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;

public class ProductPage extends ModelPage {

    private static By averagePriceLocator = By.xpath(".//*[@class='n-w-product-average-price__average-value']/span");
    private static By mainPhotoLocator = By.xpath(".//*[@class='n-gallery__item-wrap n-gallery__item-wrap_active_yes']/div/img");
    private static By buttonsLocator = By.xpath(".//*[@class='n-product-summary-toolbar']");
    private static By shortsLocator = By.xpath(".//*[@class='n-product-content-block']");
    private static By pageTab = By.className("n-product-tabs__item_name_product");

    public ProductPage(WebDriver driver) {
        super(driver, pageTab);
    }

    public Integer getAveragePrice() {
        return getPrice(averagePriceLocator);
    }

    public boolean mainPhotoPresent() {
        return photoPresent(mainPhotoLocator);
    }

    public boolean checkShortDescription() {
        Optional<WebElement> title = getIfExistsElement(By.className("n-product-content-block__title"));
        return title.isPresent()
                && title.get().getText().equalsIgnoreCase("Коротко о товаре")
                && existsElement(By.className("n-product-content-block__content"));
    }
}
