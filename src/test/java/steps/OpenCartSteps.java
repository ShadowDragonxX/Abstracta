package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OpenCartPage;

public class OpenCartSteps {

    private WebDriver driver;
    private OpenCartPage openCartPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Captura pantalla paso a paso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("^arranco la URL de OpenCart$")
    public void navigateToOpenCart(){
        openCartPage = new OpenCartPage(driver);
        openCartPage.navigateToOpenCart();
    }

    @When("^hago click en la barra de busqueda y busco iphone")
    public void searchForItem(){
        openCartPage.setSearchQuery("iphone");
        openCartPage.submitSearch();
    }

    @And("hago click en el primer resultado")
    public void hagoClickEnElPrimerResultado() {
        openCartPage.clickItem();
    }

    @And("agrego al carrito el producto")
    public void agregoAlCarritoElProducto() {
        openCartPage.clickAddToCart();
    }

    @And("ingreso al carrito de compras")
    public void ingresoAlCarritoDeCompras() {
        openCartPage.clickOpenCartButton();
    }

    @And("valido que el item este dentro del carro")
    public void validoQueElItemEsteDentroDelCarro() {
        openCartPage.validateItemInCart();
    }

    @And("elimino el item del carro")
    public void eliminoElItemDelCarro() {
        openCartPage.deleteFromCart();
    }

    @And("valido que no este el item dentro del carro")
    public void validoQueNoEsteElItemDentroDelCarro() {
        openCartPage.validateEmptyCart();
    }
}
