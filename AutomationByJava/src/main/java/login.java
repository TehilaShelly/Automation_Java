import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login
{
    WebDriver driver;

    //public login(WebDriver newdriver)
//    {
//        this.driver=newdriver;
//    }
    public void get_web()
    {
       WebDriverManager.chromedriver().setup();
        driver.get("https://www.demoblaze.com");
        driver.manage().window().maximize();






    }
}