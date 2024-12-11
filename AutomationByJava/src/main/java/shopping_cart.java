
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class shopping_cart
{
    //public static  driver_home_page;
    static WebDriver driver_shopping_cart;

    //אתחול דרייבר
    public shopping_cart(WebDriver driver) {
        this.driver_shopping_cart = driver;
    }

    //ניווט לדף מוצרים
    public void link_shopping_cart()
    {
        driver_shopping_cart.get("https://www.demoblaze.com/cart.html");
    }

    private final By Pic_Locator = By.linkText("Pic");
    private final By Title_Locator = By.linkText("Title");
    private final By Price_Locator = By.linkText("Price");
    private final By x_Locator = By.linkText("x");
    private final By Place_Order_Locator = By.linkText("Place Order");

   // private static final By ContactLocator = By.linkText("Contact");





 }





