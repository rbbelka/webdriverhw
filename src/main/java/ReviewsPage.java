import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;


public class ReviewsPage extends ModelPage {

    private static By pageTab = By.className("n-product-tabs__item_name_reviews");

    public ReviewsPage(WebDriver driver) {
        super(driver, pageTab);
    }

    public boolean checkReviews() {
        Optional<WebElement> placeholder = getIfExistsElement(By.className("n-product-placeholder__title"));
        if (placeholder.isPresent()
                && placeholder.get().getText().equalsIgnoreCase("Отзывов ещё нет, ваш может стать первым."))
            return true;

        return existsElement(By.className("n-product-review-item"));

    }
}
