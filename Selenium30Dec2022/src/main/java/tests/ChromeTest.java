package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest {

	@Test
	public void launch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cmt3.research.microsoft.com/User/Login?ReturnUrl=%2F");
		System.out.println(driver.findElement(By.xpath("//h1[text()='Microsoft CMT']")).getText());
		driver.findElement(By.cssSelector("input#emailTextbox")).sendKeys("usere47574745@gm.com");
		driver.findElement(By.cssSelector("input#passwordTextbox")).sendKeys("user45397@gmsd");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		//Thread.sleep(4000);
		//String error=driver.findElement(By.cssSelector("div.alert.alert-error")).getText();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement error=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert.alert-error")));
		
		Assert.assertTrue(error.getText().contains("records"));
		driver.quit();
	}
}
