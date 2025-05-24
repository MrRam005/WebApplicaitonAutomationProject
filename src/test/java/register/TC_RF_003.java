package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethodsUtil;

public class TC_RF_003 {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
	}

	
	@Test
	public void registeringAccountByProvidingAllFields() {


		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("vish");
		driver.findElement(By.id("input-lastname")).sendKeys("Lan");
		driver.findElement(By.id("input-email")).sendKeys(CommonMethodsUtil.generateEmailWithDate());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("(//label[@class='radio-inline']//child::input)[1]")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Continue')]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

		String properDetailsOne = "Your Account Has Been Created!";
		String properDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String properDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String properDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String properDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";

		WebElement divContent = driver.findElement(By.id("content"));

		Assert.assertTrue(divContent.getText().contains(properDetailsOne));
		Assert.assertTrue(divContent.getText().contains(properDetailsTwo));
		Assert.assertTrue(divContent.getText().contains(properDetailsThree));
		Assert.assertTrue(divContent.getText().contains(properDetailsFour));
		Assert.assertTrue(divContent.getText().contains(properDetailsFive));


		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).isDisplayed());
	}


}
