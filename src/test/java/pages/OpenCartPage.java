package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartPage extends BasePage{

    private By searchBox = By.xpath("//input[@name='search']");
    private By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
    private By item = By.xpath("//img[@alt='iPhone']");
    private By addToCart = By.xpath("//button[@id='button-cart']");
    private By buttonCart = By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']");
    private By viewCart = By.xpath("//i[@class='fa fa-shopping-cart']");
    private By itemInCart = By.xpath("//img[@alt='iPhone']");
    private By deleteItemFromCart = By.xpath("//button[@class='btn btn-danger']");
    private By cart = By.xpath("//*[@id=\"content\"]/p");

    public OpenCartPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToOpenCart(){
        navigateTo("https://opencart.abstracta.us");
    }

    public void setSearchQuery(String query){
        writeText(searchBox, query);
    }

    public void submitSearch(){
        clickElement(searchButton);
    }

    public void clickItem(){
        clickElement(item);
    }
    public void clickAddToCart(){
        clickElement(addToCart);
    }
    public void clickOpenCartButton(){
        clickElement(buttonCart);
        clickElement(viewCart);
    }
    public void validateItemInCart(){
        if(isElementPresent(itemInCart)){
            System.out.println("El elemento se encuentra en el carro");
        } else {
            System.out.println("El elemento no se encuentra en el carro");
        }
    }
    public void deleteFromCart(){
        clickElement(deleteItemFromCart);
    }
    public void validateEmptyCart(){
        if(isElementPresent(cart)){
            System.out.println("El carro se encuentra vacio");
        } else {
            System.out.println("El carro no se encuentra vacio");
        }
        waitForSeconds(3);
    }

}
