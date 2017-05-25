import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.stream.Collectors;


public class OffersPage extends ModelPage {

    private static By pageTab = By.className("n-product-tabs__item_name_offers");

    public OffersPage(WebDriver driver) {
        super(driver, pageTab);
    }

    public boolean checkOffers() {
        Optional<WebElement> sorterTitle = getIfExistsElement(By.className("n-filter-sorter__label"));
        if (!sorterTitle.isPresent())
            return false;
        if (!sorterTitle.get().getText().equalsIgnoreCase("Сортировать:"))
            return false;
        return existsElement(By.className("snippet-card_type_offer"));
    }

    public boolean checkSorting() {
        List<WebElement> priceElements = new ArrayList<>();
        Optional<WebElement> snippets;

        Optional<WebElement> button = getIfExistsElement(By.linkText("по цене"));

        while (button.isPresent()) {
            button.get().click();
            snippets = getIfExistsElement(By.className("snippet-card__price"));
            if (!snippets.isPresent())
                return false;
            priceElements.addAll(driver.findElements(By.xpath(".//*[@class='snippet-card__price']/span")));
            button = getIfExistsElement(By.className("n-pager__button-next"));
        }
        List<Integer> prices = priceElements.stream()
                .map(elem -> new PriceElement(elem).getPrice())
                .collect(Collectors.toList());

        List<Integer> sorted = new ArrayList<>(prices);
        Collections.sort(sorted);
        return sorted.equals(prices);
    }

}
