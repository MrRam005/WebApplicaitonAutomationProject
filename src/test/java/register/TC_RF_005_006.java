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

public class TC_RF_005_006 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
	}

	@Test
	public void registeringAccountByProvidingYesOptForNewsLetter() {

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

		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

		String properDetailsOne = "Your Account Has Been Created!";
		WebElement divContent = driver.findElement(By.id("content"));
		Assert.assertTrue(divContent.getText().contains(properDetailsOne));

		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).isDisplayed());

		driver.findElement(By.xpath("//a[contains(text(),'Subscribe / unsubscribe to newsletter')]")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());

		driver.findElement(By.xpath("//input[@value='Continue'][@type='submit']")).click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText(),
				"Success: Your newsletter subscription has been successfully updated!");
	}

	@Test
	public void registeringAccountByProvidingNoOptForNewsLetter() {

		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("vish");
		driver.findElement(By.id("input-lastname")).sendKeys("Lan");
		driver.findElement(By.id("input-email")).sendKeys(CommonMethodsUtil.generateEmailWithDate());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");

		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Continue')]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

		String properDetailsOne = "Your Account Has Been Created!";
		WebElement divContent = driver.findElement(By.id("content"));
		Assert.assertTrue(divContent.getText().contains(properDetailsOne));

		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).isDisplayed());

		driver.findElement(By.xpath("//a[contains(text(),'Subscribe / unsubscribe to newsletter')]")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).isSelected(),"NewsLetter Subscibe Yes is not Selected");

		driver.findElement(By.xpath("//input[@value='Continue'][@type='submit']")).click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText(),
				"Success: Your newsletter subscription has been successfully updated!");
	}
}
