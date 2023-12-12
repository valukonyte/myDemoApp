package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import static steps.DriverFactory.driver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsSteps {
    private final AppiumDriver driver;

    public ProductsSteps() {
        this.driver = DriverFactory.driver;
    }

    @Given("User is on {string} page")
    public void user_is_on_page(String page) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + page + "\")")).isDisplayed();
    }

    @When("User clicks {string} button")
    public void user_click_button(String button) {
        driver.findElement(AppiumBy.accessibilityId(button)).click();
    }

    @Then("First product title is {string}")
    public void first_product_title_is(String title) {
        String element = driver.findElements(AppiumBy.androidUIAutomator(
                "description(\"store item text\")")).get(0).getText();
        assertEquals(element, title);
    }

    @Given("{string} functionality is available")
    public void sortFunctionalityIsAvailable(String button) {
        driver.findElement(AppiumBy.accessibilityId(button)).isDisplayed();
    }
}
