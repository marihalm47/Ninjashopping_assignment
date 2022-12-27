package Ninjashop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;

public class Ninjashop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//step 1: Launch the application http://tutorialsninja.com/demo/index.php
		System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php");
        driver.manage().window().maximize();
		
 //step 2:Select the currency in the left top corner to Euro
        
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']/strong/span[contains(text(),'Currency'])")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'€ Euro')]")).click();
		
		
		
//step 3: Try to order a canon EOS 5 D camera and collect the error message occurred due to a bug in select option.
  
		driver.findElement(By.linkText("Cameras")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Canon EOS 5D")).click();
		 driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
		 
	     String err=driver.findElement(By.className("text-danger")).getText();
	     System.out.println("Error message is: "+err);
	  Thread.sleep(1000); 
	   
 //step 4:Move to the home screen, Click on iphone and go to details screen,change the quantity to two then add to cart.
	      
	     Thread.sleep(1000);
	     driver.findElement(By.linkText("Your Store")).click();
	     driver.findElement(By.linkText("iPhone")).click();
	     driver.findElement(By.cssSelector("[name=quantity]")).clear(); 
	     driver.findElement(By.cssSelector("[name=quantity]")).sendKeys("2");  
	     Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
		 
//step 5.Print the success message in the console
		 //String sucess=driver.findElement(By.className("alert alert-success alert-dismissible")).getText();
	     //System.out.println("sucess message is: "+sucess);
		// WebElement msg=driver.findElement(By.xpath("//div[contains(@class,'alert alert-success alert-dismissible')]"));
	     //WebElement msg=driver.findElement(By.className("alert alert-success alert-dismissible"));
		 //WebElement success = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		// WebElement Success = driver.findElement(By.id("//[@id='product-product']/div[1]"));
	
		 //String successMessage = Success.getText();
		//System.out.println("Success Message:"+successMessage);
	
	
// step 6:Click on the cart icon (black color) in the right side top then click view cart
	driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
	Thread.sleep(1000);
	driver.findElement(By.linkText("View Cart")).click();
	
// step 7:Change the quantity of iphone to 3 and click update button 
	driver.findElement(By.xpath("//input[@class='form-control']")).clear();
    driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("3");
  //*[@id="content"]/form/div/table/tbody/tr/td[4]/div/span/button[1]/i
    
    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
   
 // step 8: Print the Eco tax and VAT Amount in console and click Checkout button
  
		String ecovalue = driver.findElement(By.xpath("(//tbody/tr[2]/td[@class='text-right'])[4]")).getText();
		System.out.println("ECO Tax value is               : "+ecovalue);
	
		
		String vat = driver.findElement(By.xpath("(//tbody/tr[3]/td[@class='text-right'])[4]")).getText();
		System.out.println("VAT value is               : "+vat);
		
// step 9: Print the error message and remove the product from the cart
	 
	     
	     WebElement errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
			String error = errorMsg.getText();
			System.out.println("Error message is :"+error);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
			
// step 10:Move to the home screen and click on Mac book, check the default quantity is 1 and click add to cart then verify success message
			
			Thread.sleep(1000);
			driver.findElement(By.linkText("Your Store")).click();	
			driver.findElement(By.linkText("MacBook")).click();
			
			//check default quantity is 1
			WebElement quantity = driver.findElement(By.cssSelector("[name=quantity]"));
			String quant = quantity.getAttribute("value");
			Thread.sleep(1000);
			System.out.println("Quantity of Macbook is :"+quant);
			
			//add to cart and verify message
			
			driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
		//WebElement sucessmsg = driver.findElement(By.xpath("//div/ul/div[@class='alert alert-success alert-dismissible']"));
			////WebElement sucessmsg = driver.findElement(By.xpath("//div[@class='container']/div[1][@class='alert alert-success alert-dismissible']"));
				//String sucss = sucessmsg.getText();
				//System.out.println("sucess message is :"+sucss);
			Thread.sleep(1000);
			
// step 11:Click on the shopping cart link in the top and apply ABCD123 as coupon code to check, print error message
			driver.findElement(By.xpath("//div[@id='top-links']/ul/li[4]/a")).click();	
			//driver.findElement(By.xpath("//div/div[@class='panel-heading']/h4/a[contains(text(),'Use Coupon Code')]")).click();
			 //driver.findElement(By.xpath("//div[@class='input-group']/input[@name='coupon']")).sendKeys("ABCD123");
			 //Thread.sleep(1000);
			// driver.findElement(By.xpath("//input[@id='button-coupon']")).click();
			 
				Thread.sleep(1000);
				
			//	String couponErr = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
				//Thread.sleep(1000);
				//System.out.println("Coupon error message        :"+couponErr);
			
				
//step 12:Enter AXDFGH123 as gift certificate and perform apply to check, print error message
				driver.findElement(By.xpath("//div/div[@class='panel-heading']/h4/a[contains(text(),'Use Gift Certificate ')]")).click();
				Thread.sleep(1000);
				//driver.findElement(By.xpath("//div[@class='panel-heading']/div[@class='input-group']/input[@name='voucher']")).sendKeys("AXDFGH123");
				driver.findElement(By.xpath("//input[@id='input-voucher']")).sendKeys("AXDFGH123");
				driver.findElement(By.xpath("//input[@id='button-voucher']")).click();
				Thread.sleep(1000);
				
				
				//String giftvoucher = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
				//Thread.sleep(1000);
				//System.out.println("Gift Certificate Voucher error message  :"+giftvoucher);
				
//Step 13: Clear both textbox values and proceed to checkout
				
				driver.findElement(By.xpath("//div/div[@class='panel-heading']/h4/a[contains(text(),'Use Gift Certificate ')]")).click();
				driver.findElement(By.xpath("//input[@id='input-voucher']")).clear();
				
				//driver.findElement(By.xpath("//div[@id='top-links']/ul/li[4]/a")).click();
				//driver.findElement(By.xpath("//div[@class='input-group']/input[@name='coupon']")).clear();	
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//div/div[2][@class='pull-right']/a[contains(text(),'Checkout')]")).click();
				
// step 14: Select register account option and enter all account and billing details, click continue
				
				//driver.findElement(By.xpath("//input[@id='button-account']")).click();
				//driver.findElement(By.tagName("//input[@id='button-account']")).click();
			//	driver.findElement(By.xpath("//div/div[1]/input[@type='button' and @value='Continue']")).click();
			
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@value='Continue']")).click();

			Thread.sleep(1000);
				driver.findElement(By.name("firstname")).sendKeys("test");
				driver.findElement(By.name("lastname")).sendKeys("test1");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@name='email' and @id='input-payment-email']")).sendKeys("mm88m@gmail.com");
				driver.findElement(By.name("telephone")).sendKeys("55566655");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='input-payment-password' and @name='password']")).sendKeys("testing");
				driver.findElement(By.name("confirm")).sendKeys("testing");
				driver.findElement(By.name("company")).sendKeys("kansas Ltd");
				driver.findElement(By.name("address_1")).sendKeys("woodland");
				driver.findElement(By.name("address_2")).sendKeys("metcalf");
				driver.findElement(By.name("city")).sendKeys("overland");
				driver.findElement(By.name("postcode")).sendKeys("66224");
				
				WebElement countryEle = driver.findElement(By.name("country_id"));
				Select country=new Select(countryEle);
				country.selectByValue("81");
				
				Thread.sleep(1000);
				
				WebElement zoneEle = driver.findElement(By.name("zone_id"));
				Select zone=new Select(zoneEle);
				zone.selectByValue("1265");
					
				driver.findElement(By.xpath("//input[@name='agree']")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("button-register")).click();
				Thread.sleep(1000);
				
//step: 15 Add comments, click continue and check the error message related to payment method
				
				driver.findElement(By.name("comment")).sendKeys("This product is awesome!!!");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@name='agree']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@value='Continue' and @id='button-payment-method']")).click();
				
				Thread.sleep(1000);
				String paymentErrormsg = driver.findElement(By.xpath("//div[@class='panel-body']/div[@class='alert alert-danger alert-dismissible']")).getText();
				System.out.println("Payment error message :"+paymentErrormsg);
				
//step 16: Click on contact us hyperlink and submit a contact request and click continue
				Thread.sleep(1000);
				
				driver.findElement(By.linkText("Contact Us")).click();
				//*[@id="input-enquiry"]
				driver.findElement(By.id("input-enquiry")).sendKeys("what is the return policy of the product?");	
				
				Thread.sleep(1000);
				//driver.findElement(By.xpath("div[@class='pull-right']/input[@value='Submit']")).click();
				driver.findElement(By.xpath("//input[@value='Submit']")).click();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Continue")).click(); 
}

}
