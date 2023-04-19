package base;

import configuration.AppProperties;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import providers.DriverFactory;
import steps.UserSteps;


@Slf4j
public class TestBase {
    protected static WebDriver driver;
    private static DriverFactory driverFactory;
    private static AppProperties appProperties;
    protected static UserSteps userSteps;

    @BeforeAll
    static void setup() {
        appProperties = AppProperties.getInstance();
        driverFactory = new DriverFactory();
        userSteps = new UserSteps();
    }

    @BeforeEach
    void setupDriver() {
        driver = driverFactory.getDriver();
        driver.get(System.getProperty("app_url"));
    }

    @AfterEach
    void tearDown() {
        try {
            driver.quit();
            log.info("WebDriver closed successfully");
        } catch (Exception e) {
            log.error("WebDriver was not closed.");
        }
    }
    @SneakyThrows
    public <T extends BasePage> T at(Class<T> pageType) {
        return pageType.getDeclaredConstructor(WebDriver.class).newInstance(driver);
    }
}