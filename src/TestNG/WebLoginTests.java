package TestNG;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class WebLoginTests {
	
	//This is the main automation script for the scenario provided. 
	public String URL;
	
	public WebDriver driver;
	public String driverPath = "C:\\Users\\SAM\\Downloads\\chromedriver_win32\\chromedriver.exe";
	ConfigReader config = new ConfigReader();
	
	@BeforeTest
	public void launchapp() 
	{
	      	System.out.println(" Executing in CHROME");
	         System.setProperty("webdriver.chrome.driver", driverPath);
	         driver = new ChromeDriver();
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         
	         // Launch website
	         driver.navigate().to(config.getApplicationURL());
	         driver.manage().window().maximize();
	}
	   
@Test
  public void LoginTest1() throws Exception {
	  
	  	String ExpectedSubTotalPrice = "20.00";

		
		driver.get("http://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath(config.clickLogin())).click();
		
		driver.getPageSource().contains("Welcome, Please Sign In!");
		
		//Logging in by entering credentials
		driver.findElement(By.xpath(config.enterEmail())).sendKeys("testdemowebshop@gmail.com");

		driver.findElement(By.id(config.enterPassword())).sendKeys("Test123");
	
		driver.findElement(By.xpath(config.loginButton())).click();

		driver.findElement(By.xpath(config.accountId())).isDisplayed();
		
		driver.findElement(By.xpath(config.shoppingCartLink())).click();
		
		driver.findElement(By.xpath(config.removeFromCart())).click();
		driver.findElement(By.xpath(config.updateCart())).click();
		
		driver.findElement(By.xpath(config.booksMenu())).click();
		
		driver.findElement(By.xpath(config.computingInternet())).click();
		
		String PriceofBook = driver.findElement(By.xpath(config.priceOfBook())).getText();
		
		driver.findElement(By.xpath(config.Quantity())).clear();
		driver.findElement(By.xpath(config.Quantity())).sendKeys("2");
		
		driver.findElement(By.xpath(config.addToCart())).click();
		
		driver.findElement(By.xpath(config.addToCartMessage())).isDisplayed();
		
		driver.findElement(By.xpath(config.shoppingCartLink())).click();
		
		//Verifying SubTotalPrice
		String SubTotalPrice = driver.findElement(By.xpath(config.subTotalPrice())).getText();
		if(SubTotalPrice.equals(ExpectedSubTotalPrice))
		{
			System.out.println("Prices matched");
		}
		else 
		{
			System.out.println("Prices didn't match");
		}
		
		driver.findElement(By.xpath(config.termsOfService())).click();
		driver.findElement(By.xpath(config.Checkout())).click();
		
		//Entering New Address
		Select drpBillingAddress = new Select(driver.findElement(By.name(config.drpBillingAddress())));
		drpBillingAddress.selectByVisibleText("New Address");
		
		Select drpbillingNewAddress = new Select(driver.findElement(By.name(config.drpbillingNewAddress())));
		drpbillingNewAddress.selectByVisibleText("India");
		
		driver.findElement(By.xpath(config.billingAddressCity())).sendKeys("Hyderabad");
		driver.findElement(By.xpath(config.billingAddress1())).sendKeys("Test");
		driver.findElement(By.xpath(config.billingAddressZip())).sendKeys("500089");
		driver.findElement(By.xpath(config.billingAddressPhoneNumber())).sendKeys("9999999999");
		driver.findElement(By.xpath(config.billingAddressContinue())).click();
		
	
		//Couldn't find shipping address same as billing address value in drop down.
		driver.findElement(By.xpath(config.ShippingAddressContinue())).click();
		driver.findElement(By.xpath(config.shippingNextDayAir())).click();
		driver.findElement(By.xpath(config.shippingMethodContinue())).click();
		driver.findElement(By.xpath(config.paymentMethodContinue())).click();
		
		driver.getPageSource().contains("You will pay by COD");
		driver.findElement(By.xpath(config.paymentInfoContinue())).click();
		driver.findElement(By.xpath(config.confirmOrder())).click();
		driver.getPageSource().contains("Your order has been successfully processed!");
	}
  
  @AfterTest
  public void terminatetest() 
  {
      driver.close();
  }
}

