package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_004 {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
	}

	@Test
	public void verifyProperNotificationMsgDisplayedManField() {
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Continue')]")).click();

		String PrivacyPolicyWarMsg = "Warning: You must agree to the Privacy Policy!";
		String firstNameWarMsg = "First Name must be between 1 and 32 characters!";
		String lastNameWarMsg = "Last Name must be between 1 and 32 characters!";
		String emailIdWarMsg = "E-Mail Address does not appear to be valid!";
		String telephoneWarMsg = "Telephone must be between 3 and 32 characters!";
		String passwordWarMsg = "Password must be between 4 and 20 characters!";

		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).getText(),
				firstNameWarMsg);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-lastname']//following-sibling::div")).getText(),
				lastNameWarMsg);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-email']//following-sibling::div")).getText(),
				emailIdWarMsg);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText(),
				telephoneWarMsg);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(),
				passwordWarMsg);
		Assert.assertEquals(
				driver.findElement(By.cssSelector("div[class='alert alert-danger alert-dismissible']")).getText(),
				PrivacyPolicyWarMsg);
	}

}
