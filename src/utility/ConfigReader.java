package utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigReader {

	//This method is used to read the object values from OR and pass it to WebLoginTests(i.e. application.properties file)
	Properties prop;
	
	public ConfigReader()
	{
		 try 
			{
				File src= new File(".//application.properties");
				FileInputStream fis = new FileInputStream(src);
				prop = new Properties();
				prop.load(fis);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Exception is =="+e.getMessage());
			}
			
	}
	
	public String getChromePath()
	{
		String path = prop.getProperty("ChromeDriver");
		
		return path;
		
	}
	
	public String getApplicationURL()
	{
		return prop.getProperty("URL");
	}
	
	public String clickLogin()
	{
		return prop.getProperty("Login");
	}
	
	public String enterEmail()
	{
		return prop.getProperty("EmailTextBox");
	}
	
	public String enterPassword()
	{
		return prop.getProperty("PasswordTextBox");
	}
	
	public String loginButton()
	{
		return prop.getProperty("LoginButton");
	}
	
	public String accountId()
	{
		return prop.getProperty("AccountId");
	}
	
	public String shoppingCartLink()
	{
		return prop.getProperty("ShoppingCartLink");
	}
	
	public String removeFromCart()
	{
		return prop.getProperty("RemoveFromCart");
	}
	
	public String updateCart()
	{
		return prop.getProperty("UpdateCart");
	}
	
	public String booksMenu()
	{
		return prop.getProperty("BooksMenu");
	}
	
	public String computingInternet()
	{
		return prop.getProperty("ComputingInternet");
	}
	
	public String priceOfBook()
	{
		return prop.getProperty("Price");
	}
	
	public String Quantity()
	{
		return prop.getProperty("Quantity");
	}
	
	public String addToCart()
	{
		return prop.getProperty("AddtoCart");
	}
	
	public String addToCartMessage()
	{
		return prop.getProperty("AddToCartMessage");
	}
	
	public String subTotalPrice()
	{
		return prop.getProperty("SubTotal");
	}
	
	public String termsOfService()
	{
		return prop.getProperty("TermsofService");
	}
	
	public String Checkout()
	{
		return prop.getProperty("Checkout");
	}
	
	public String drpBillingAddress()
	{
		return prop.getProperty("drpBillingAddress");
	}
	
	public String drpbillingNewAddress()
	{
		return prop.getProperty("drpbillingNewAddress");
	}
	
	public String billingAddressCity()
	{
		return prop.getProperty("BillingAddressCity");
	}
	
	public String billingAddress1()
	{
		return prop.getProperty("BillingAddress1");
	}
	
	public String billingAddressZip()
	{
		return prop.getProperty("BillingAddressZip");
	}
	
	public String billingAddressPhoneNumber()
	{
		return prop.getProperty("BillingAddressPhoneNumber");
	}
	
	public String billingAddressContinue()
	{
		return prop.getProperty("BillingAddressContinue");
	}
	
	public String shippingAddress()
	{
		return prop.getProperty("ShippingAddress");
	}
	
	public String ShippingAddressContinue()
	{
		return prop.getProperty("ShippingAddressContinue");
	}
	
	public String shippingNextDayAir()
	{
		return prop.getProperty("ShippingNextDayAir");
	}
	
	public String shippingMethodContinue()
	{
		return prop.getProperty("ShippingMethodContinue");
	}
	
	public String paymentMethodContinue()
	{
		return prop.getProperty("PaymentMethodContinue");
	}
	
	public String paymentInfoContinue()
	{
		return prop.getProperty("PaymentInfoContinue");
	}
	
	public String confirmOrder()
	{
		return prop.getProperty("ConfirmOrder");
	}
}
