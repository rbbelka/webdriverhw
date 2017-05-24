import org.openqa.selenium.WebElement;


public class PriceElement {
    private WebElement price;

    PriceElement(WebElement price) {
        this.price = price;
    }

    public Integer getPrice() {
        return Integer.parseInt(price.getText().replaceAll("[\\D]", ""));
    }
}
