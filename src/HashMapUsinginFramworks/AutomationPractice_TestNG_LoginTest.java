package HashMapUsinginFramworks;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AutomationPractice_TestNG_LoginTest {

	static WebDriver driver;
	static String customerCedentials;
	static String customerInfo[];

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Prakash\\eclipse-workspace\\HashMapConcept\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void loginWithCustomerUserTest() {

		// Sign in Part

		WebElement SigninBtn = driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
		SigninBtn.click();

		// HashMap Concept

		// Data data = new Data(); //using Without static in Data class we want to create Object to call the Method.

		customerCedentials = Data.getUserLoginInfo().get("customer");
		customerInfo = customerCedentials.split("_");

		WebElement EmailAddress = driver.findElement(By.id("email"));
		EmailAddress.sendKeys(customerInfo[0]);

		WebElement Password = driver.findElement(By.id("passwd"));
		Password.sendKeys(customerInfo[1]);

		// SubmitLoginButton Part

		WebElement SubmitLogin = driver.findElement(By.id("SubmitLogin"));
		SubmitLogin.click();

		// SignOut Part

		WebElement SignOut = driver.findElement(By.xpath("//a[@title='Log me out']"));
		SignOut.click();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
