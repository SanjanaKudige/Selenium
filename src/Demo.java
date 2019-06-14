import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {
	// public static void main(String[] args) throws InterruptedException {
	// chromeInvoke();
	// firefoxInvoke();
	// workingWithSalesforce();
	// DragnDrop();
	// alertAndPopupHandling();
	// checkboxAndRadioButton();
	//
	// }

	private static WebDriver driver;

	@BeforeClass(description = "Invoking browser")
	public void invokeDriver() {
		System.setProperty("webdriver.gecko.driver",
				"/Users/balajianoopgupta/Desktop/SanjanaKudige/Udemy Rest API Testing/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterClass
	public void cleanUpEnvironment() {
		driver.quit();
	}

	@Test
	public static void checkboxAndRadioButton() {

		driver.get("http://demo.guru99.com/test/radio.html");

		WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
		WebElement radio2 = driver.findElement(By.id("vfb-7-2"));

		radio1.click();
		System.out.println("Option 1 Clicked");

		radio2.click();
		System.out.println("Option 2 Clicked");

		WebElement opt = driver.findElement(By.id("vfb-6-0"));
		opt.click();
		if (opt.isSelected()) {
			System.out.println("Checkbox toggled");
		} else
			System.out.println("Checkbox not toggled");

		driver.get("http://demo.guru99.com/test/facebook.html");
		WebElement checkPersist = driver.findElement(By.id("persist_box"));
		for (int i = 0; i < 2; i++) {
			checkPersist.click();
			System.out.println("Persist checkbox status is: " + checkPersist.isSelected());
		}

	}

	@Test
	public static void workingWithTwitter() {

		driver.get("https://twitter.com/");
		driver.findElement(By.name("session[username_or_email]")).sendKeys("email");
		driver.findElement(By.name("session[password]")).sendKeys("password");
		// *[@id="doc"]/div/div[1]/div[1]/div[1]/form/input[1]
		driver.findElement(By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[1]/form/input[1]")).click();
		// List<WebElement> we;

	}

	@Test
	public static void alertAndPopupHandling() throws InterruptedException {

		driver.get("http://demo.guru99.com/test/delete_customer.php");

		driver.findElement(By.name("cusid")).sendKeys("12345");
		driver.findElement(By.name("submit")).submit();

		Alert alert = driver.switchTo().alert();

		String msg = driver.switchTo().alert().getText();

		System.out.println(msg);

		alert.accept();

	}

	@Test
	public static void DragnDrop() {
		driver.get("http://demo.guru99.com/test/drag_drop.html");

		WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));
		WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

		Actions act = new Actions(driver);

		act.dragAndDrop(From, To).build().perform();
	}

	@Test
	public static void chromeInvoke() throws InterruptedException {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		driver.get("https://www.facebook.com/");
		// driver.navigate().back();

		// driver.findElement(By.id("email")).click();
		// driver.findElement(By.id("email")).clear();
		// String sanju = "sanjanaKudige";
		driver.findElement(By.id("email")).sendKeys("sanju");
		// addWaitTime();
		driver.close();

	}

	@Test
	public static void firefoxInvoke() {

		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("email")).sendKeys("sanju");
		driver.findElement(By.linkText("Forgot account?")).click();

	}

	// public static void addWaitTime() {
	// try {
	// Thread.sleep(3000L);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
}
