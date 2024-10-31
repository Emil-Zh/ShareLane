import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void checkFullPositiveSignUp(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();

        driver.findElement(By.name("first_name")).sendKeys("Emil");
        driver.findElement(By.name("last_name")).sendKeys("Zh");
        driver.findElement(By.name("email")).sendKeys("alis@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345678");
        driver.findElement(By.name("password2")).sendKeys("12345678");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String signUpMessage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(signUpMessage, "Account is created!");
        driver.quit();
    }
}
