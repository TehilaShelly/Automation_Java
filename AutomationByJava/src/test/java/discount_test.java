import org.testng.annotations.Test;

public class discount_test extends DriverGet
{
    home_page x;
    @Test void test3()
    {
       // System.out.print("Hello and welcome!");
        getDriver();
        x=new  home_page((driver));
        String [] categoriesLocator = {"Phones", "Laptops", "Monitors"};
        x.Clicking_on_the_categories(driver,categoriesLocator );
    }
    @Test void test4() throws InterruptedException
    {
        getDriver();
        new  home_page((driver));
        x=new  home_page((driver));
        String[] menu = {"home", "Contact", "About us","Cart", "Log in", "Sign up"};
        x.ClickElementInMenu(driver,menu);
    }

    @Test void test5()
            //throws InterruptedException
    {
        System.out.print("Hello and welcome!");
        getDriver();
        x=new  home_page((driver));
        x.Click_on_Contact();
    }

    @Test void test6()
    {
        System.out.print("Hello and welcome!");
        getDriver();
        x=new  home_page((driver));
        x.purchaseProduct(driver);
    }

    }












    //WebDriver webDriver =new DriverGet().getDriver();
    //login loginclass =new login();
    //shopping_cart shoppingCart_variable=new shopping_cart(driver);


    //WebDriver driver = new ChromeDriver();
    //home_page homePage = new home_page(driver);
