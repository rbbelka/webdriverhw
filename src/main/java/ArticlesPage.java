import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;


public class ArticlesPage extends ModelPage {
    private static By pageTab = By.className("n-product-tabs__item_name_articles");

    public ArticlesPage(WebDriver driver) {
        super(driver, pageTab);
    }

    public boolean checkArticles() {
        Optional<WebElement> placeholder = getIfExistsElement(By.className("n-product-placeholder__title"));
        if (placeholder.isPresent()
                && placeholder.get().getText().equalsIgnoreCase("На Маркете пока нет обзоров этого товара."))
            return true;

        return existsElement(By.className("product-articles__item"));
    }
}
