import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;

public class SpecPage extends ModelPage {
    private static By pageTab = By.className("n-product-tabs__item_name_spec");

    private By specLocator = By.className("n-product-spec-wrap");

    public SpecPage(WebDriver driver) {
        super(driver, pageTab);
    }

    public boolean checkSpecs() {
        Optional<WebElement> specTitle = getIfExistsElement(By.className("n-product-spec-wrap__title"));
        if (!specTitle.isPresent())
            return false;
        if (!specTitle.get().getText().equalsIgnoreCase("Подробные характеристики"))
            return false;
        WebElement spec = getWhenVisible(specLocator);
        return spec.findElements(By.xpath("div")).size() > 0;
    }
}
