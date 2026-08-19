package Day1;
/*
TEST case 
 ------------
 1)Launch browser(chrome)
 2)Open url : https://demo.nopcommerce.com/
 3)validate title should be "nopCommerce demo Store"
 4)close the browser
*/
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class FirstTestCase {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        String act_title = driver.getTitle();

        System.out.println("Actual Title: " + act_title);

        if (act_title.equals("Swag Labs")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}

