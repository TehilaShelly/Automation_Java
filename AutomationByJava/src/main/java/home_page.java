import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
//import java.util.List;

public  class home_page {
    static WebDriver driver_home_page;

    //static WebDriver driver;
    //אתחול הדרייבר
    public home_page(WebDriver driver_home) {
        this.driver_home_page = driver_home;
    }

    public void link_home_page() {
        driver_home_page.get("https://www.demoblaze.com");
    }

    //מציאת קטגוריות
    private final By phonesLocator = By.linkText("Phones");
    private final By laptopsLocator = By.linkText("Laptops");
    private final By monitorsLocator = By.linkText("Monitors");
    //מערך של מזהי הכפתורים:
    //TEST3
    // home_page.driver_home_page.findElement(laptopsLocator).click();
    String[] categoriesLocator = {"Phones", "Laptops", "Monitors"};

    public void Clicking_on_the_categories(WebDriver driver, String[] categoriesLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        for (int i = 0; i < categoriesLocator.length; i++) {
            driver_home_page.findElement(By.linkText(categoriesLocator[i])).click();
            System.out.println(i);
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText(categoriesLocator[i])));
            List<WebElement> buttonElementsContainer = driver.findElements(By.cssSelector("[class='card-img-top img-fluid']"));
            System.out.println(buttonElementsContainer.size());
//           for (WebElement element : buttonElementsContainer)
//             {
//                 wait.until(ExpectedConditions.visibilityOf(element));
//                 Assert.assertTrue("Elements not displayed",element.isDisplayed());
//             }

        }
    }

    private final By homeLocator = By.linkText("Home ");
    private final By ContactLocator = By.linkText("Contact");
    private final By PopupContactLocator = By.linkText("Contact");
    private final By About_usLocator = By.linkText("About us");
    private final By CartLocator = By.linkText("Cart");
    private final By Log_inLocator = By.linkText("Log in");
    private final By Sign_upLocator = By.linkText("Sign up");
    private final By new_massage_Locator = By.linkText(" New message");
    //test4
    //מציאת כל האלמנטים בסרגל הכלים
    String[] menu = {"Home ", "Contact", "About us", "Cart", "Log in", "Sign up"};
    public void ClickElementInMenu(WebDriver driver, String[] menu) {
        List<WebElement> menuItems = driver.findElements(By.cssSelector("[class='nav-link']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (WebElement menuItem : menuItems) {
            menuItem.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nav-link']")));
            String menuItemText = menuItem.getText().trim();
            System.out.println("Clicked on menu item: " + menuItemText);
            switch (menuItemText.toLowerCase()) {
                case "home":
                    if (driver.getCurrentUrl().equals("https://www.demoblaze.com")) {
                        System.out.println("Current page is Home.");
                    } else {
                        System.out.println("Current page is not Home.");
                    }
                    break;
                case "contact":
                    WebElement Contact_popup = DriverGet.driver.findElement(By.linkText("Contact"));
                  driver.navigate().back();
                    break;
                case "about us":
                    WebElement About_us_popup = DriverGet.driver.findElement(By.linkText("About us"));
//                  driver.navigate().back();
                    break;
                case "cart":
                    if (driver.getCurrentUrl().equals("https://www.demoblaze.com/cart.html")) {
                        System.out.println("Current page is Cart.");
                    } else {
                        System.out.println("Current page is not Cart.");
                    }
                    break;
                case "log in":
                    WebElement log_in_popup = DriverGet.driver.findElement(By.linkText("log in"));
                    driver.navigate().back();
                    break;
                case "sign up":
                    WebElement sign_up = DriverGet.driver.findElement(By.linkText("sign up"));
                    driver.navigate().back();
                    break;
                default:
                    System.out.println("No specific check for this menu item: " + menuItemText);
                    break;
            }
            driver.navigate().refresh();
        }
    }


    private static final By new_message_Locator = By.linkText("New message");
    private static final By ContactLocator2 = By.linkText("Contact");
    private static final By email_Locator = By.id("recipient-email");
    private static final By name_Locator = By.id("recipient-name");
    private static final By message_Locator = By.id("message-text");
    // private static final By send_message = By.xpath("btn btn-primary");
    private static final By send_message1 = By.xpath("//button[@class='btn btn-primary']");
    private static final By Add_to_cart_Locator1 = By.cssSelector(".btn.btn-success.btn-lg");
    private static final By Add_to_cart_Locator2 = By.linkText("Add to cart");

    private static final By product = By.cssSelector("[class='card-img-top img-fluid']");

    private static final By Customer_Name_ID = By.id("name");
    private static final By country_ID = By.id("country");
    private static final By city_ID = By.id("city");
    private static final By card_ID = By.id("card");
    private static final By month_ID = By.id("month");
    private static final By year_ID = By.id("year");
    //private static final By Purchase_ID = By.linkText("Purchase");
    private static final By Close_ID = By.linkText("Close");

    private static final By placeOrder = By.cssSelector("[class='btn btn-success']");
    private static final By Purchase_ID = By.className("[class='btn btn-primary']");

    private static final By Purchase_ID2 = By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn-primary')]");

    private static final By Purchase_ID3 = By.linkText("Purchase");

    public void purchaseProduct(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(product));
        productElement.click();
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(Add_to_cart_Locator2));
        addToCartButton.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText=alert.getText();
        alert.accept();
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(CartLocator));
        cart.click();
        WebElement place_order = wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
        place_order.click();
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(Customer_Name_ID));
        name.sendKeys("tehila");
        home_page.driver_home_page.findElement(country_ID).sendKeys("israel");
        home_page.driver_home_page.findElement(city_ID).sendKeys("netivot");
        home_page.driver_home_page.findElement(card_ID).sendKeys("5555");
        //להוסיף וולידציות
        home_page.driver_home_page.findElement(month_ID).sendKeys("april");
        home_page.driver_home_page.findElement(year_ID).sendKeys("2024");
       // WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(Purchase_ID3));
        //ok.click();
        //WebDriverWait wait2 = new WebDriverWait(home_page.driver_home_page, Duration.ofSeconds(2));
        //Alert alert=wait2.until(ExpectedConditions.alertIsPresent());
        //String alertText=alert.getText();
        //alert.accept();




        //CartLocator




    }


    //test5
    public static void Click_on_Contact() {
        WebDriverWait wait = new WebDriverWait(home_page.driver_home_page, Duration.ofSeconds(2));

        //if (DriverGet.driver.getTitle().contains("New message")) {
        //System.out.println("gggg");
        home_page.driver_home_page.findElement(ContactLocator2).click();
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(email_Locator));
        home_page.driver_home_page.findElement(email_Locator).sendKeys("tehila211sh@gmail.com");
        home_page.driver_home_page.findElement(name_Locator).sendKeys("tehila");
        home_page.driver_home_page.findElement(message_Locator).sendKeys("xxxx");
        home_page.driver_home_page.findElement((send_message1)).click();
        WebDriverWait wait2 = new WebDriverWait(home_page.driver_home_page, Duration.ofSeconds(2));
        Alert alert=wait2.until(ExpectedConditions.alertIsPresent());
        String alertText=alert.getText();
        alert.accept();

    }
}