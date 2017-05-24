import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ModelTest {
    private WebDriver driver;
    final String testPage = "https://market.yandex.ru/product/1720217048/offers?hid=91491&track=tabs";
    final String testPage1 = "https://market.yandex.ru/product--lenovo-vibe-b/14196004";
    final String testPage2 = "https://market.yandex.ru/product/1716608944/spec?hid=91529&track=tabs";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TestPage() {
        driver.get(testPage);
        ProductPage productPage = new ProductPage(driver);
        assertTrue(productPage.getAveragePrice() >= 0);
        assertTrue(productPage.mainPhotoPresent());
        assertTrue(productPage.checkShortDescription());

        SpecPage specPage = new SpecPage(driver);
        assertTrue(specPage.checkSpecs());

        OffersPage offersPage = new OffersPage(driver);
        assertTrue(offersPage.checkOffers());
        assertTrue(offersPage.checkSorting());

        GeoPage geoPage = new GeoPage(driver);
        assertTrue(geoPage.checkMap());

        ReviewsPage reviewsPage = new ReviewsPage(driver);
        assertTrue(reviewsPage.checkReviews());

        ArticlesPage articlesPage = new ArticlesPage(driver);
        assertTrue(articlesPage.checkArticles());

        ForumsPage forumsPage = new ForumsPage(driver);
        assertTrue(forumsPage.checkForums());
    }

}