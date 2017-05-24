import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;


public class ForumsPage extends ModelPage {
    private static By pageTab = By.className("n-product-tabs__item_name_forums");

    public ForumsPage(WebDriver driver) {
        super(driver, pageTab);
    }

    public boolean checkForums() {
        Optional<WebElement> forumOpt = getIfExistsElement(By.className("n-product-forum"));
        if (!forumOpt.isPresent())
            return false;
        WebElement forum = forumOpt.get();
        List<WebElement> emptyForums = forum.findElements(By.className("product-forums-empty"));
        if (emptyForums.size() > 0
                && emptyForums.get(0).getText().equalsIgnoreCase("Этот товар пока никто не обсуждал"))
            return true;
        return forum.findElements(By.className("n-product-forum-item")).size() > 0;
    }
}
