import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;


public abstract class ModelPage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected static By nameLocator = By.xpath(".//*[@class='n-title__text']/h1");
    protected static By buttonsLocator = By.xpath(".//*[@class='n-product-headline__toolbar']");
    protected static By tabsLocator = By.xpath(".//*[@class='n-product-tabs__list']");

    public ModelPage(WebDriver driver, By pageTab) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, 30);
        switchToTab(pageTab);
    }

    protected void switchToTab(By pageTab) {
        WebElement tabs = getWhenVisible(tabsLocator);
        WebElement tab = tabs.findElement(pageTab);
        if (!tab.isSelected()) {
            tab.click();
        }
    }

    public Integer getPrice(By priceLocator) {
        WebElement priceBlock = getWhenVisible(priceLocator);
        return new PriceElement(priceBlock).getPrice();
    }

    public String getName() {
        WebElement nameBlock = getWhenVisible(nameLocator);
        return nameBlock.getText();
    }

    public Boolean photoPresent(By photoLocator) {
        WebElement mainPhoto = getWhenVisible(photoLocator);
        return (Boolean) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].complete" +
                        " && typeof arguments[0].naturalWidth != \"undefined\"" +
                        " && arguments[0].naturalWidth > 0"
                , mainPhoto);
    }

    protected WebElement getWhenVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected boolean existsElement(By locator) {
        try {
            getWhenVisible(locator);
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
        return true;
    }

    protected Optional<WebElement> getIfExistsElement(By locator) {
        WebElement element;
        try {
            element = getWhenVisible(locator);
        } catch (NoSuchElementException | TimeoutException e) {
            return Optional.empty();
        }
        return Optional.of(element);
    }

}
